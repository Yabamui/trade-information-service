package com.service.openapi.trade.apiservice.clients;

import com.service.openapi.trade.apiservice.cofigurations.WtoApiClientConfig;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "wto-api-client", value = "wto-api-client", url = "https://api.wto.org", configuration = {WtoApiClientConfig.class},
        path = "/timeseries")
public interface WtoTimeSeriesApiClient {
    @GetMapping("/v1/product_classifications")
    Response getProductClassifications(@RequestParam("lang") String language);

    @GetMapping("/v1/topics")
    Response getTopics(@RequestParam("lang") String language);

    @GetMapping("/v1/frequencies")
    Response getFrequencies(@RequestParam("lang") String language);

    @GetMapping("/v1/periods")
    Response getPeriods(@RequestParam("lang") String language);

    @GetMapping("/v1/units")
    Response getUnits(@RequestParam("lang") String language);

    @GetMapping("/v1/indicator_categories")
    Response getIndicatorCategories(@RequestParam("lang") String language);

    @GetMapping("/v1/territory/regions")
    Response getTerritoryRegions(@RequestParam("lang") String language);

    @GetMapping("/v1/territory/groups")
    Response getEconomicGroups(@RequestParam("lang") String language);

    @GetMapping("/v1/years")
    Response getYears();

    @GetMapping("/v1/value_flags")
    Response getValueFlags(@RequestParam("lang") String language);

    @GetMapping("/v1/products")
    Response getProducts(@RequestParam("lang") String language,
                         @RequestParam("pc") String productClassificationCode);

    @GetMapping("/v1/reporters")
    Response getEconomicReporters(@RequestParam("lang") String language,
                                  @RequestParam("ig") String ig,
                                  @RequestParam("reg") String regionCode,
                                  @RequestParam("gp") String groupCode);

    @GetMapping("/v1/partners")
    Response getEconomicPartners(@RequestParam("lang") String language,
                                 @RequestParam("ig") String ig,
                                 @RequestParam("reg") String regionCode,
                                 @RequestParam("gp") String groupCode);

    @GetMapping("/v1/indicators")
    Response getIndicators(@RequestParam("lang") String language,
                           @RequestParam("i") String indicator,
                           @RequestParam("t") String topicCode,
                           @RequestParam("pc") String productClassificationCode,
                           @RequestParam("tp") String tradePartner,
                           @RequestParam("frq") String frequency);

    /**
     * Timeseries metadata
     *
     * @param language 1 : English 2 : French 3 : Spanish
     * @param indicator Indicator code. See Indicators.
     * @param economicReporter Reporting economies (comma separated codes). See Reporting economies.
     * @param economicPartner Partner economies where applicable (comma separated codes). See Partner economies.
     * @param productClassificationCode Products/sectors (comma separated codes) where applicable. See Products/sectors.
     * default : includes all the product/sectors codes of the indicator's classification
     *                                  (except for HS : Include all the top level 2 digit products + the whole chapter 01)
     * all : includes all the product/sectors codes of the indicator's classification
     * HS2, HS4, HS6 : All HS codes at 2,4,6 digit-level
     * AG,AGFOFI,MAIS,... : comma separated list of product codes
     *
     * @param isSubProductClassificationCode Include sub products/sectors.
     *                                       If true, all child items in the product/sector hierarchy are recursively included.
     * @return response
     */
    @GetMapping("/v1/metadata")
    Response getMetadata(@RequestParam("lang") String language,
                         @RequestParam("i") String indicator,
                         @RequestParam("r") String economicReporter,
                         @RequestParam("p") String economicPartner,
                         @RequestParam("pc") String productClassificationCode,
                         @RequestParam("spc") boolean isSubProductClassificationCode);

    /**
     * Timeseries datapoints. If you reach the URL length limit, you can use the POST method
     *
     * @param language 1 : English 2 : French 3 : Spanish
     * @param indicator Indicator code. See Indicators.
     * @param economicReporter Default value : all
     *                         Reporting economies (comma separated codes). See Reporting economies.
     * @param economicPartner Default value : default
     *                        Partner economies where applicable (comma separated codes). See Partner economies.
     * @param periodTime Default value : default
     *                   Time period :
     *                   default : The last eight years are applied.
     *
     *                   all : All years are applied.
     *
     *                   YYYY : comma separated list of years.
     *                   If the frequency of the requested indicator is monthly or quarterly,
     *                   the resulting output will reflect this,
     *                   e.g. 2010 will give an output of January-December or 2010Q1-Q4.
     *
     *                   YYYYQn : comma separated list of year + quarter.
     *                   If the indicator frequency is monthly,
     *                   the output will be given in months,
     *                   e.g. 2010Q2 will produce an output of April, May, June.
     *
     *                   YYYYMM : comma separated list of year + month.
     *                   e.g. 201007, 201507.
     *
     *                   YYYY-YYYY : range of years. e.g. 1995-2015.
     *
     *                   YYYYQn-YYYYQn : range of quarters. e.g. 2010Q1-2013Q3.
     *
     *                   YYYYMM-YYYYMM : range of months. e.g. 201501-201606.
     *
     * @param productClassificationCode Default value : default
     *                                  Products/sectors (comma separated codes) where applicable. See Products/sectors.
     *                                  default : includes all the product/sector codes of the indicator's classification
     *                                  (except for HS : includes all the top level 2-digit products + the whole chapter 01)
     *
     *                                  all : includes all the product/sector codes of the indicator's classification
     *
     *                                  HS2, HS4, HS6 : All HS codes at 2,4,6-digit level
     *
     *                                  AG,AGFOFI,MAIS,... : comma separated list of product codes
     * @param isSubProductClassificationCode Default value : false
     *                                       Include sub products/sectors.
     *                                       If true, all child items in the product/sector hierarchy are recursively included.
     * @param format Default value : json Output format
     *               json : json content is streamed
     *               csv : csv file is compressed and zipped
     *
     * @param mode Default value : full Output mode
     *             full : all columns, information repeated on each row
     *             codes : technical codes only
     * @param decimals Default value : default Number of decimals
     *                 default : applies the default number of decimals for the Indicator
     *                 N : sets the number of decimals to N
     * @param offset Default value : 0
     *               Number of records to skip (offset). You can use it for implementing pagination.
     * @param limited Default value : 500
     *                Maximum number of records to return (limited to 1 000 000).
     * @param headerStyle Default value : H Heading style
     *                    H : human readable headings, including special characters and spaces
     *                    M : machine readable headings, easy to parse
     * @param isMetadata Default value : false Include Metadata information.
     *                   If enabled, it will generate additional files/arrays
     *                   (depending on the format, see parameter fmt) :
     *                   Metadata records
     *                   Request summary : number of data records retrieved,
     *                   total number of data records,
     *                   number of metadata records retrieved,
     *                   start time,
     *                   end time,
     *                   duration in seconds
     * @return feign response
     */
    @GetMapping("/v1/data")
    Response getData(@RequestParam("lang") String language,
                     @RequestParam("i") String indicator,
                     @RequestParam("r") String economicReporter,
                     @RequestParam("p") String economicPartner,
                     @RequestParam("ps") String periodTime,
                     @RequestParam("pc") String productClassificationCode,
                     @RequestParam("spc") boolean isSubProductClassificationCode,
                     @RequestParam("fmt") String format,
                     @RequestParam("mode") String mode,
                     @RequestParam("dec") String decimals,
                     @RequestParam("off") int offset,
                     @RequestParam("max") int limited,
                     @RequestParam("head") String headerStyle,
                     @RequestParam("meta") boolean isMetadata);
}
