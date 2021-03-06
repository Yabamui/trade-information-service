package com.service.openapi.trade.apiservice.service;

import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.service.openapi.trade.apiservice.clients.WtoTimeSeriesApiClient;
import com.service.openapi.trade.apiservice.entities.wto.*;
import com.service.openapi.trade.apiservice.entities.wto.pk.*;
import com.service.openapi.trade.apiservice.models.wtoapiclient.*;
import com.service.openapi.trade.apiservice.repositories.wto.*;
import com.service.openapi.trade.apiservice.services.WtoService;
import com.service.openapi.trade.apiservice.utils.FeignUtil;
import com.service.openapi.trade.apiservice.utils.JsonConvert;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("local")
@Slf4j
@EnableTransactionManagement
class WtoApiClientTest {
    @Autowired
    private WtoService wtoService;
    @Autowired
    private WtoTimeSeriesApiClient wtoTimeSeriesApiClient;
    @Autowired
    private ProductClassificationRepository productClassificationRepository;
    @Autowired
    private TopicsRepository topicsRepository;
    @Autowired
    private FrequenciesRepository frequenciesRepository;
    @Autowired
    private PeriodsRepository periodsRepository;
    @Autowired
    private UnitsRepository unitsRepository;
    @Autowired
    private IndicatorCategoriesRepository indicatorCategoriesRepository;
    @Autowired
    private TerritoryRegionsRepository territoryRegionsRepository;
    @Autowired
    private EconomicGroupsRepository economicGroupsRepository;
    @Autowired
    private YearsRepository yearsRepository;
    @Autowired
    private ValueFlagsRepository valueFlagsRepository;
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private EconomicReportersRepository economicReportersRepository;
    @Autowired
    private MappedReporterGroupRepository mappedReporterGroupRepository;
    @Autowired
    private MappedReporterRegionRepository mappedReporterRegionRepository;
    @Autowired
    private EconomicPartnersRepository economicPartnersRepository;
    @Autowired
    private MappedPartnerGroupRepository mappedPartnerGroupRepository;
    @Autowired
    private MappedPartnerRegionRepository mappedPartnerRegionRepository;
    @Autowired
    private IndicatorsRepository indicatorsRepository;

    private static final String DEFAULT_LANGUAGE = "1";
    private static final String DEFAULT_PARAM = "all";
    private static final String INDIVIDUAL = "individual";

    @Test
    void topicsResponseConvertTest() {
        final String responseBody = "{\"Dataset\": [{\"IndicatorCategoryCode\":\"SER_BATIS\",\"IndicatorCategory\":\"Balanced International Trade in Services EBOPS 2010 (2005-2019) - (Experimental data set)\",\"IndicatorCode\":\"BAT_BV_M\",\"Indicator\":\"Services imports: balanced values\",\"ReportingEconomyCode\":\"232\",\"ReportingEconomy\":\"Eritrea\",\"PartnerEconomyCode\":\"332\",\"PartnerEconomy\":\"Haiti\",\"ProductOrSectorClassificationCode\":\"BOP6\",\"ProductOrSectorClassification\":\"Services - Extended Balance of Payments Classification (EBOPS 2010)\",\"ProductOrSectorCode\":\"S\",\"ProductOrSector\":\"Memo item: Total services\",\"PeriodCode\":\"A\",\"Period\":\"Annual\",\"FrequencyCode\":\"A\",\"Frequency\":\"Annual\",\"UnitCode\":\"USM\",\"Unit\":\"Million US dollar\",\"Year\":2010,\"ValueFlagCode\":null,\"ValueFlag\":null,\"TextValue\":null,\"Value\":0.0},{\"IndicatorCategoryCode\":\"SER_BATIS\",\"IndicatorCategory\":\"Balanced International Trade in Services EBOPS 2010 (2005-2019) - (Experimental data set)\",\"IndicatorCode\":\"BAT_BV_M\",\"Indicator\":\"Services imports: balanced values\",\"ReportingEconomyCode\":\"232\",\"ReportingEconomy\":\"Eritrea\",\"PartnerEconomyCode\":\"332\",\"PartnerEconomy\":\"Haiti\",\"ProductOrSectorClassificationCode\":\"BOP6\",\"ProductOrSectorClassification\":\"Services - Extended Balance of Payments Classification (EBOPS 2010)\",\"ProductOrSectorCode\":\"S\",\"ProductOrSector\":\"Memo item: Total services\",\"PeriodCode\":\"A\",\"Period\":\"Annual\",\"FrequencyCode\":\"A\",\"Frequency\":\"Annual\",\"UnitCode\":\"USM\",\"Unit\":\"Million US dollar\",\"Year\":2011,\"ValueFlagCode\":null,\"ValueFlag\":null,\"TextValue\":null,\"Value\":0.0},{\"IndicatorCategoryCode\":\"SER_BATIS\",\"IndicatorCategory\":\"Balanced International Trade in Services EBOPS 2010 (2005-2019) - (Experimental data set)\",\"IndicatorCode\":\"BAT_BV_M\",\"Indicator\":\"Services imports: balanced values\",\"ReportingEconomyCode\":\"232\",\"ReportingEconomy\":\"Eritrea\",\"PartnerEconomyCode\":\"332\",\"PartnerEconomy\":\"Haiti\",\"ProductOrSectorClassificationCode\":\"BOP6\",\"ProductOrSectorClassification\":\"Services - Extended Balance of Payments Classification (EBOPS 2010)\",\"ProductOrSectorCode\":\"S\",\"ProductOrSector\":\"Memo item: Total services\",\"PeriodCode\":\"A\",\"Period\":\"Annual\",\"FrequencyCode\":\"A\",\"Frequency\":\"Annual\",\"UnitCode\":\"USM\",\"Unit\":\"Million US dollar\",\"Year\":2012,\"ValueFlagCode\":null,\"ValueFlag\":null,\"TextValue\":null,\"Value\":0.0},{\"IndicatorCategoryCode\":\"SER_BATIS\",\"IndicatorCategory\":\"Balanced International Trade in Services EBOPS 2010 (2005-2019) - (Experimental data set)\",\"IndicatorCode\":\"BAT_BV_M\",\"Indicator\":\"Services imports: balanced values\",\"ReportingEconomyCode\":\"232\",\"ReportingEconomy\":\"Eritrea\",\"PartnerEconomyCode\":\"332\",\"PartnerEconomy\":\"Haiti\",\"ProductOrSectorClassificationCode\":\"BOP6\",\"ProductOrSectorClassification\":\"Services - Extended Balance of Payments Classification (EBOPS 2010)\",\"ProductOrSectorCode\":\"S\",\"ProductOrSector\":\"Memo item: Total services\",\"PeriodCode\":\"A\",\"Period\":\"Annual\",\"FrequencyCode\":\"A\",\"Frequency\":\"Annual\",\"UnitCode\":\"USM\",\"Unit\":\"Million US dollar\",\"Year\":2013,\"ValueFlagCode\":null,\"ValueFlag\":null,\"TextValue\":null,\"Value\":0.0},{\"IndicatorCategoryCode\":\"SER_BATIS\",\"IndicatorCategory\":\"Balanced International Trade in Services EBOPS 2010 (2005-2019) - (Experimental data set)\",\"IndicatorCode\":\"BAT_BV_M\",\"Indicator\":\"Services imports: balanced values\",\"ReportingEconomyCode\":\"232\",\"ReportingEconomy\":\"Eritrea\",\"PartnerEconomyCode\":\"332\",\"PartnerEconomy\":\"Haiti\",\"ProductOrSectorClassificationCode\":\"BOP6\",\"ProductOrSectorClassification\":\"Services - Extended Balance of Payments Classification (EBOPS 2010)\",\"ProductOrSectorCode\":\"S\",\"ProductOrSector\":\"Memo item: Total services\",\"PeriodCode\":\"A\",\"Period\":\"Annual\",\"FrequencyCode\":\"A\",\"Frequency\":\"Annual\",\"UnitCode\":\"USM\",\"Unit\":\"Million US dollar\",\"Year\":2014,\"ValueFlagCode\":null,\"ValueFlag\":null,\"TextValue\":null,\"Value\":0.0},{\"IndicatorCategoryCode\":\"SER_BATIS\",\"IndicatorCategory\":\"Balanced International Trade in Services EBOPS 2010 (2005-2019) - (Experimental data set)\",\"IndicatorCode\":\"BAT_BV_M\",\"Indicator\":\"Services imports: balanced values\",\"ReportingEconomyCode\":\"232\",\"ReportingEconomy\":\"Eritrea\",\"PartnerEconomyCode\":\"332\",\"PartnerEconomy\":\"Haiti\",\"ProductOrSectorClassificationCode\":\"BOP6\",\"ProductOrSectorClassification\":\"Services - Extended Balance of Payments Classification (EBOPS 2010)\",\"ProductOrSectorCode\":\"S\",\"ProductOrSector\":\"Memo item: Total services\",\"PeriodCode\":\"A\",\"Period\":\"Annual\",\"FrequencyCode\":\"A\",\"Frequency\":\"Annual\",\"UnitCode\":\"USM\",\"Unit\":\"Million US dollar\",\"Year\":2015,\"ValueFlagCode\":null,\"ValueFlag\":null,\"TextValue\":null,\"Value\":0.0},{\"IndicatorCategoryCode\":\"SER_BATIS\",\"IndicatorCategory\":\"Balanced International Trade in Services EBOPS 2010 (2005-2019) - (Experimental data set)\",\"IndicatorCode\":\"BAT_BV_M\",\"Indicator\":\"Services imports: balanced values\",\"ReportingEconomyCode\":\"232\",\"ReportingEconomy\":\"Eritrea\",\"PartnerEconomyCode\":\"332\",\"PartnerEconomy\":\"Haiti\",\"ProductOrSectorClassificationCode\":\"BOP6\",\"ProductOrSectorClassification\":\"Services - Extended Balance of Payments Classification (EBOPS 2010)\",\"ProductOrSectorCode\":\"S\",\"ProductOrSector\":\"Memo item: Total services\",\"PeriodCode\":\"A\",\"Period\":\"Annual\",\"FrequencyCode\":\"A\",\"Frequency\":\"Annual\",\"UnitCode\":\"USM\",\"Unit\":\"Million US dollar\",\"Year\":2016,\"ValueFlagCode\":null,\"ValueFlag\":null,\"TextValue\":null,\"Value\":0.0},{\"IndicatorCategoryCode\":\"SER_BATIS\",\"IndicatorCategory\":\"Balanced International Trade in Services EBOPS 2010 (2005-2019) - (Experimental data set)\",\"IndicatorCode\":\"BAT_BV_M\",\"Indicator\":\"Services imports: balanced values\",\"ReportingEconomyCode\":\"232\",\"ReportingEconomy\":\"Eritrea\",\"PartnerEconomyCode\":\"332\",\"PartnerEconomy\":\"Haiti\",\"ProductOrSectorClassificationCode\":\"BOP6\",\"ProductOrSectorClassification\":\"Services - Extended Balance of Payments Classification (EBOPS 2010)\",\"ProductOrSectorCode\":\"S\",\"ProductOrSector\":\"Memo item: Total services\",\"PeriodCode\":\"A\",\"Period\":\"Annual\",\"FrequencyCode\":\"A\",\"Frequency\":\"Annual\",\"UnitCode\":\"USM\",\"Unit\":\"Million US dollar\",\"Year\":2017,\"ValueFlagCode\":null,\"ValueFlag\":null,\"TextValue\":null,\"Value\":0.0},{\"IndicatorCategoryCode\":\"SER_BATIS\",\"IndicatorCategory\":\"Balanced International Trade in Services EBOPS 2010 (2005-2019) - (Experimental data set)\",\"IndicatorCode\":\"BAT_BV_M\",\"Indicator\":\"Services imports: balanced values\",\"ReportingEconomyCode\":\"232\",\"ReportingEconomy\":\"Eritrea\",\"PartnerEconomyCode\":\"332\",\"PartnerEconomy\":\"Haiti\",\"ProductOrSectorClassificationCode\":\"BOP6\",\"ProductOrSectorClassification\":\"Services - Extended Balance of Payments Classification (EBOPS 2010)\",\"ProductOrSectorCode\":\"S\",\"ProductOrSector\":\"Memo item: Total services\",\"PeriodCode\":\"A\",\"Period\":\"Annual\",\"FrequencyCode\":\"A\",\"Frequency\":\"Annual\",\"UnitCode\":\"USM\",\"Unit\":\"Million US dollar\",\"Year\":2018,\"ValueFlagCode\":null,\"ValueFlag\":null,\"TextValue\":null,\"Value\":0.0},{\"IndicatorCategoryCode\":\"SER_BATIS\",\"IndicatorCategory\":\"Balanced International Trade in Services EBOPS 2010 (2005-2019) - (Experimental data set)\",\"IndicatorCode\":\"BAT_BV_M\",\"Indicator\":\"Services imports: balanced values\",\"ReportingEconomyCode\":\"232\",\"ReportingEconomy\":\"Eritrea\",\"PartnerEconomyCode\":\"332\",\"PartnerEconomy\":\"Haiti\",\"ProductOrSectorClassificationCode\":\"BOP6\",\"ProductOrSectorClassification\":\"Services - Extended Balance of Payments Classification (EBOPS 2010)\",\"ProductOrSectorCode\":\"S\",\"ProductOrSector\":\"Memo item: Total services\",\"PeriodCode\":\"A\",\"Period\":\"Annual\",\"FrequencyCode\":\"A\",\"Frequency\":\"Annual\",\"UnitCode\":\"USM\",\"Unit\":\"Million US dollar\",\"Year\":2019,\"ValueFlagCode\":null,\"ValueFlag\":null,\"TextValue\":null,\"Value\":0.0}]}";

        final DataResponse responses = JsonConvert.toObject(responseBody, new TypeReference<>() {
        });

        assertThat(responses).isNotNull();

        log.info(JsonConvert.toString(responses));
    }

    @Test
    @Transactional(transactionManager = "transactionManagerWto")
    void testSaveProductClassification() {
        final Response response = this.wtoTimeSeriesApiClient.getProductClassifications(DEFAULT_LANGUAGE);

        assertThat(response.status()).isEqualTo(HttpStatus.OK.value());

        assertThat(response.body()).isNotNull();

        final String responseBody = FeignUtil.getBodyString(response);

        assertThat(responseBody).isNotBlank();

        final List<ProductClassificationResponse> responses = JsonConvert.toObject(responseBody, new TypeReference<>() {
        });

        assertThat(responses).isNotEmpty();

        final List<ProductClassification> topicsList = this.productClassificationRepository.saveAll(responses.stream()
                .map(productClassificationResponse -> ProductClassification.builder()
                        .name(productClassificationResponse.getName())
                        .code(productClassificationResponse.getCode())
                        .build())
                .collect(Collectors.toList()));

        assertThat(topicsList).isNotEmpty();

        log.info(JsonConvert.toString(topicsList));
    }

    @Test
    void testSaveTopics() {
        final Response response = this.wtoTimeSeriesApiClient.getTopics(DEFAULT_LANGUAGE);

        assertThat(response.status()).isEqualTo(HttpStatus.OK.value());

        assertThat(response.body()).isNotNull();

        final String responseBody = FeignUtil.getBodyString(response);

        assertThat(responseBody).isNotBlank();

        final List<TopicsResponse> responses = JsonConvert.toObject(responseBody, new TypeReference<>() {
        });

        assertThat(responses).isNotEmpty();

        final List<Topics> topicsList = this.topicsRepository.saveAll(responses.stream()
                .map(topicsResponse -> Topics.builder()
                        .id(topicsResponse.getId())
                        .name(topicsResponse.getName())
                        .sortOrder(topicsResponse.getSortOrder())
                        .build())
                .collect(Collectors.toList()));

        assertThat(topicsList).isNotEmpty();

        log.info(JsonConvert.toString(topicsList));
    }

    @Test
    void testSaveFrequencies() {
        final Response response = this.wtoTimeSeriesApiClient.getFrequencies(DEFAULT_LANGUAGE);

        assertThat(response.status()).isEqualTo(HttpStatus.OK.value());

        assertThat(response.body()).isNotNull();

        final String responseBody = FeignUtil.getBodyString(response);

        assertThat(responseBody).isNotBlank();

        final List<FrequenciesResponse> responses = JsonConvert.toObject(responseBody, new TypeReference<>() {
        });

        assertThat(responses).isNotEmpty();

        final List<Frequencies> frequenciesList = this.frequenciesRepository.saveAll(responses.stream()
                .map(frequenciesResponse -> Frequencies.builder()
                        .code(frequenciesResponse.getCode())
                        .name(frequenciesResponse.getName())
                        .build())
                .collect(Collectors.toList()));

        assertThat(frequenciesList).isNotEmpty();

        log.info(JsonConvert.toString(frequenciesList));
    }

    @Test
    void testSavePeriods() {
        final Response response = this.wtoTimeSeriesApiClient.getPeriods(DEFAULT_LANGUAGE);

        assertThat(response.status()).isEqualTo(HttpStatus.OK.value());

        assertThat(response.body()).isNotNull();

        final String responseBody = FeignUtil.getBodyString(response);

        assertThat(responseBody).isNotBlank();

        log.info(responseBody);

        final List<PeriodsResponse> responses = JsonConvert.toObject(responseBody, new TypeReference<>() {
        });

        assertThat(responses).isNotEmpty();

        final List<Periods> periodsList = this.periodsRepository.saveAll(responses.stream()
                .map(periodsResponse -> Periods.builder()
                        .code(periodsResponse.getCode())
                        .name(periodsResponse.getName())
                        .description(periodsResponse.getDescription())
                        .frequencyCode(periodsResponse.getFrequencyCode())
                        .displayOrder(periodsResponse.getDisplayOrder())
                        .build())
                .collect(Collectors.toList()));

        assertThat(periodsList).isNotEmpty();

        log.info(JsonConvert.toString(periodsList));
    }

    @Test
    void testSaveUnits() {
        final Response response = this.wtoTimeSeriesApiClient.getUnits(DEFAULT_LANGUAGE);

        assertThat(response.status()).isEqualTo(HttpStatus.OK.value());

        assertThat(response.body()).isNotNull();

        final String responseBody = FeignUtil.getBodyString(response);

        assertThat(responseBody).isNotBlank();

        log.info(responseBody);

        final List<UnitsResponse> responses = JsonConvert.toObject(responseBody, new TypeReference<>() {
        });

        assertThat(responses).isNotEmpty();

        final List<Units> unitsList = this.unitsRepository.saveAll(responses.stream()
                .map(unitsResponse -> Units.builder()
                        .code(unitsResponse.getCode())
                        .name(unitsResponse.getName())
                        .build())
                .collect(Collectors.toList()));

        assertThat(unitsList).isNotEmpty();

        log.info(JsonConvert.toString(unitsList));
    }

    @Test
    void saveIndicatorCategories() {
        final Response response = this.wtoTimeSeriesApiClient.getIndicatorCategories(DEFAULT_LANGUAGE);

        assertThat(response.status()).isEqualTo(HttpStatus.OK.value());

        assertThat(response.body()).isNotNull();

        final String responseBody = FeignUtil.getBodyString(response);

        assertThat(responseBody).isNotBlank();

        log.info(responseBody);

        final List<IndicatorCategoriesResponse> responses = JsonConvert.toObject(responseBody, new TypeReference<>() {
        });

        assertThat(responses).isNotEmpty();

        final List<IndicatorCategories> indicatorCategoriesList = this.indicatorCategoriesRepository.saveAll(
                responses.stream().map(indicatorCategoriesResponse -> IndicatorCategories.builder()
                        .code(indicatorCategoriesResponse.getCode())
                        .name(indicatorCategoriesResponse.getName())
                        .parentCode(indicatorCategoriesResponse.getParentCode())
                        .sortOrder(indicatorCategoriesResponse.getSortOrder())
                        .build())
                        .collect(Collectors.toList()));

        assertThat(indicatorCategoriesList).isNotEmpty();

        log.info(JsonConvert.toString(indicatorCategoriesList));
    }

    @Test
    void saveTerritoryRegions() {
        final Response response = this.wtoTimeSeriesApiClient.getTerritoryRegions(DEFAULT_LANGUAGE);

        assertThat(response.status()).isEqualTo(HttpStatus.OK.value());

        assertThat(response.body()).isNotNull();

        final String responseBody = FeignUtil.getBodyString(response);

        assertThat(responseBody).isNotBlank();

        log.info(responseBody);

        final List<TerritoryRegionsResponse> responses = JsonConvert.toObject(responseBody, new TypeReference<>() {
        });

        assertThat(responses).isNotEmpty();

        final List<TerritoryRegions> territoryRegionsList = this.territoryRegionsRepository.saveAll(
                responses.stream()
                        .map(territoryRegionsResponse -> TerritoryRegions.builder()
                                .code(territoryRegionsResponse.getCode())
                                .name(territoryRegionsResponse.getName())
                                .displayOrder(territoryRegionsResponse.getDisplayOrder())
                                .build())
                        .collect(Collectors.toList()));

        assertThat(territoryRegionsList).isNotEmpty();

        log.info(JsonConvert.toString(territoryRegionsList));
    }

    @Test
    void saveEconomicGroups() {
        final Response response = this.wtoTimeSeriesApiClient.getEconomicGroups(DEFAULT_LANGUAGE);

        assertThat(response.status()).isEqualTo(HttpStatus.OK.value());

        assertThat(response.body()).isNotNull();

        final String responseBody = FeignUtil.getBodyString(response);

        assertThat(responseBody).isNotBlank();

        log.info(responseBody);

        final List<EconomicGroupsResponse> responses = JsonConvert.toObject(responseBody, new TypeReference<>() {
        });

        assertThat(responses).isNotEmpty();

        final List<EconomicGroups> economicGroupsList = this.economicGroupsRepository.saveAll(
                responses.stream()
                        .map(economicGroupsResponse -> EconomicGroups.builder()
                                .code(economicGroupsResponse.getCode())
                                .name(economicGroupsResponse.getName())
                                .displayOrder(economicGroupsResponse.getDisplayOrder())
                                .build())
                        .collect(Collectors.toList()));

        assertThat(economicGroupsList).isNotEmpty();

        log.info(JsonConvert.toString(economicGroupsList));
    }

    @Test
    void saveYears() {
        final Response response = this.wtoTimeSeriesApiClient.getYears();

        assertThat(response.status()).isEqualTo(HttpStatus.OK.value());

        assertThat(response.body()).isNotNull();

        final String responseBody = FeignUtil.getBodyString(response);

        assertThat(responseBody).isNotBlank();

        log.info(responseBody);

        final List<YearsResponse> responses = JsonConvert.toObject(responseBody, new TypeReference<>() {
        });

        assertThat(responses).isNotEmpty();

        final List<Years> yearsList = this.yearsRepository.saveAll(
                responses.stream()
                        .map(yearsResponse -> Years.builder()
                                .year(yearsResponse.getYear())
                                .build())
                        .collect(Collectors.toList()));

        assertThat(yearsList).isNotEmpty();

        log.info(JsonConvert.toString(yearsList));
    }

    @Test
    void saveValueFlags() {
        final Response response = this.wtoTimeSeriesApiClient.getValueFlags(DEFAULT_LANGUAGE);

        assertThat(response.status()).isEqualTo(HttpStatus.OK.value());

        assertThat(response.body()).isNotNull();

        final String responseBody = FeignUtil.getBodyString(response);

        assertThat(responseBody).isNotBlank();

        log.info(responseBody);

        final List<ValueFlagsResponse> responses = JsonConvert.toObject(responseBody, new TypeReference<>() {
        });

        assertThat(responses).isNotNull().isNotEmpty();

        final List<ValueFlags> valueFlagsList = this.valueFlagsRepository.saveAll(
                responses.stream()
                        .map(valueFlagsResponse -> ValueFlags.builder()
                                .code(valueFlagsResponse.getCode())
                                .description(valueFlagsResponse.getDescription())
                                .build())
                        .collect(Collectors.toList()));

        assertThat(valueFlagsList).isNotEmpty();

        log.info(JsonConvert.toString(valueFlagsList));
    }

    @Test
    void saveProducts() {
        final Response response = this.wtoTimeSeriesApiClient.getProducts(DEFAULT_LANGUAGE, "SITC3");

        assertThat(response.status()).isEqualTo(HttpStatus.OK.value());

        assertThat(response.body()).isNotNull();

        final String responseBody = FeignUtil.getBodyString(response);

        assertThat(responseBody).isNotBlank();

        log.info(responseBody);

        final List<ProductsResponse> responses = JsonConvert.toObject(responseBody, new TypeReference<>() {
        });

        assertThat(responses).isNotNull().isNotEmpty();

        final List<Products> productsList = this.productsRepository.saveAll(
                responses.stream()
                        .map(productsResponse -> Products.builder()
                                .codeUnique(productsResponse.getCodeUnique())
                                .code(productsResponse.getCode())
                                .name(productsResponse.getName())
                                .note(productsResponse.getNote())
                                .productClassification(productsResponse.getProductClassification())
                                .displayOrder(productsResponse.getDisplayOrder())
                                .hierarchy(productsResponse.getHierarchy())
                                .build())
                        .collect(Collectors.toList()));

        assertThat(productsList).isNotEmpty();

        log.info(JsonConvert.toString(productsList));
    }

    @Test
    void saveEconomicReporters() {
        final Response response = this.wtoTimeSeriesApiClient.getEconomicReporters(DEFAULT_LANGUAGE, DEFAULT_PARAM, DEFAULT_PARAM, DEFAULT_PARAM);

        assertThat(response.status()).isEqualTo(HttpStatus.OK.value());

        assertThat(response.body()).isNotNull();

        final String responseBody = FeignUtil.getBodyString(response);

        assertThat(responseBody).isNotBlank();

        log.info(responseBody);

        final List<EconomicReportersResponse> responses = JsonConvert.toObject(responseBody, new TypeReference<>() {
        });

        assertThat(responses).isNotNull().isNotEmpty();

        final List<EconomicReporters> economicReportersList = this.economicReportersRepository.saveAll(
                responses.stream()
                        .map(economicReportersResponse -> EconomicReporters.builder()
                                .code(economicReportersResponse.getCode())
                                .name(economicReportersResponse.getName())
                                .iso3A(economicReportersResponse.getIso3A())
                                .displayOrder(economicReportersResponse.getDisplayOrder())
                                .build())
                        .collect(Collectors.toList()));

        assertThat(economicReportersList).isNotEmpty();

        log.info(JsonConvert.toString(economicReportersList));
    }

    @Test
    void saveMappedReporterGroups() {
        final List<EconomicGroups> economicGroupsList = this.economicGroupsRepository.findAll();

        assertThat(economicGroupsList).isNotEmpty();

        final List<MappedReporterGroup> mappedReporterGroups = economicGroupsList.stream().map(economicGroups -> {
            final Response response = this.wtoTimeSeriesApiClient.getEconomicReporters(
                    DEFAULT_LANGUAGE, DEFAULT_PARAM, DEFAULT_PARAM, economicGroups.getCode());

            final List<EconomicReportersResponse> reportersResponses = FeignUtil.getBodyObject(response, new TypeReference<>() {
            });

            if (CollectionUtils.isEmpty(reportersResponses)) {
                return null;
            }

            return reportersResponses.stream()
                    .map(reportersResponse -> MappedReporterGroup.builder()
                            .pk(MappedReporterGroupPk.builder()
                                    .groupCode(economicGroups.getCode())
                                    .reporterCode(reportersResponse.getCode())
                                    .build())
                            .build())
                    .collect(Collectors.toList());
        }).filter(Objects::nonNull).flatMap(Collection::stream).collect(Collectors.toList());

        assertThat(mappedReporterGroups).isNotEmpty();

        this.mappedReporterGroupRepository.saveAll(mappedReporterGroups);
    }

    @Test
    void saveMappedReporterRegion() {
        final List<TerritoryRegions> regionsList = this.territoryRegionsRepository.findAll();

        assertThat(regionsList).isNotEmpty();

        final List<MappedReporterRegion> mappedReporterGroups = regionsList.stream().map(regions -> {
            final Response response = this.wtoTimeSeriesApiClient.getEconomicReporters(
                    DEFAULT_LANGUAGE, DEFAULT_PARAM, regions.getCode(), DEFAULT_PARAM);

            final List<EconomicReportersResponse> reportersResponses = FeignUtil.getBodyObject(response, new TypeReference<>() {
            });

            if (CollectionUtils.isEmpty(reportersResponses)) {
                return null;
            }

            return reportersResponses.stream()
                    .map(reportersResponse -> MappedReporterRegion.builder()
                            .pk(MappedReporterRegionPk.builder()
                                    .regionCode(regions.getCode())
                                    .reporterCode(reportersResponse.getCode())
                                    .build())
                            .build())
                    .collect(Collectors.toList());
        }).filter(Objects::nonNull).flatMap(Collection::stream).collect(Collectors.toList());

        assertThat(mappedReporterGroups).isNotEmpty();

        this.mappedReporterRegionRepository.saveAll(mappedReporterGroups);
    }

    @Test
    void saveEconomicPartners() {
        final Response response = this.wtoTimeSeriesApiClient.getEconomicPartners(DEFAULT_LANGUAGE, DEFAULT_PARAM, DEFAULT_PARAM, DEFAULT_PARAM);

        assertThat(response.status()).isEqualTo(HttpStatus.OK.value());

        assertThat(response.body()).isNotNull();

        final String responseBody = FeignUtil.getBodyString(response);

        assertThat(responseBody).isNotBlank();

        log.info(responseBody);

        final List<EconomicPartnersResponse> responses = JsonConvert.toObject(responseBody, new TypeReference<>() {
        });

        assertThat(responses).isNotNull().isNotEmpty();

        final List<EconomicPartners> economicReportersList = this.economicPartnersRepository.saveAll(
                responses.stream()
                        .map(economicPartnersResponse -> EconomicPartners.builder()
                                .code(economicPartnersResponse.getCode())
                                .name(economicPartnersResponse.getName())
                                .iso3A(economicPartnersResponse.getIso3A())
                                .displayOrder(economicPartnersResponse.getDisplayOrder())
                                .build())
                        .collect(Collectors.toList()));

        assertThat(economicReportersList).isNotEmpty();

        log.info(JsonConvert.toString(economicReportersList));
    }

    @Test
    void saveMappedPartnerGroups() {
        final List<EconomicGroups> economicGroupsList = this.economicGroupsRepository.findAll();

        assertThat(economicGroupsList).isNotEmpty();

        final List<MappedPartnerGroup> mappedPartnerGroups = economicGroupsList.stream()
                .map(economicGroups -> {
                    final Response response = this.wtoTimeSeriesApiClient.getEconomicPartners(
                            DEFAULT_LANGUAGE, DEFAULT_PARAM, DEFAULT_PARAM, economicGroups.getCode());

                    final List<EconomicPartnersResponse> partnersResponses = FeignUtil.getBodyObject(
                            response, new TypeReference<>() {
                            });

                    if (CollectionUtils.isEmpty(partnersResponses)) {
                        return null;
                    }

                    return partnersResponses.stream()
                            .map(reportersResponse -> MappedPartnerGroup.builder()
                                    .pk(MappedPartnerGroupPk.builder()
                                            .groupCode(economicGroups.getCode())
                                            .partnerCode(reportersResponse.getCode())
                                            .build())
                                    .build())
                            .collect(Collectors.toList());
                }).filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        assertThat(mappedPartnerGroups).isNotEmpty();

        this.mappedPartnerGroupRepository.saveAll(mappedPartnerGroups);
    }

    @Test
    void saveMappedPartnerRegion() {
        final List<TerritoryRegions> regionsList = this.territoryRegionsRepository.findAll();

        assertThat(regionsList).isNotEmpty();

        final List<MappedPartnerRegion> mappedPartnerRegions = regionsList.stream()
                .map(regions -> {
                    final Response response = this.wtoTimeSeriesApiClient.getEconomicPartners(
                            DEFAULT_LANGUAGE, DEFAULT_PARAM, regions.getCode(), DEFAULT_PARAM);

                    final List<EconomicPartnersResponse> partnersResponses = FeignUtil.getBodyObject(
                            response, new TypeReference<>() {
                            });

                    if (CollectionUtils.isEmpty(partnersResponses)) {
                        return null;
                    }

                    return partnersResponses.stream()
                            .map(partnersResponse -> MappedPartnerRegion.builder()
                                    .pk(MappedPartnerRegionPk.builder()
                                            .regionCode(regions.getCode())
                                            .partnerCode(partnersResponse.getCode())
                                            .build())
                                    .build())
                            .collect(Collectors.toList());
                }).filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        assertThat(mappedPartnerRegions).isNotEmpty();

        this.mappedPartnerRegionRepository.saveAll(mappedPartnerRegions);
    }

    @Test
    void saveIndicators() {
        final String indicator = DEFAULT_PARAM;
        final String topicCode = DEFAULT_PARAM;
        final String productClassificationCode = DEFAULT_PARAM;
        final String tradePartner = DEFAULT_PARAM; // yes, no
        final String frequency = DEFAULT_PARAM; // A-annualy, S-semiannualy, Q-quarterly, M-monthly

        final Response response = this.wtoTimeSeriesApiClient.getIndicators(DEFAULT_LANGUAGE, indicator, topicCode,
                productClassificationCode, tradePartner, frequency);

        assertThat(response.status()).isEqualTo(HttpStatus.OK.value());

        assertThat(response.body()).isNotNull();

        final String responseBody = FeignUtil.getBodyString(response);

        assertThat(responseBody).isNotBlank();

        log.info(responseBody);

        final List<IndicatorResponse> responses = JsonConvert.toObject(responseBody, new TypeReference<>() {
        });

        assertThat(responses).isNotNull().isNotEmpty();

        final List<Indicators> indicatorsList = this.indicatorsRepository.saveAll(
                responses.stream().map(Indicators::getInstance).collect(Collectors.toList()));

        assertThat(indicatorsList).isNotEmpty();

        log.info(JsonConvert.toString(indicatorsList));
    }

    @Test
    void saveMetadata() {
        final List<Indicators> indicatorsList = this.indicatorsRepository.findAll();

        assertThat(indicatorsList).isNotNull().isNotEmpty();

        // todo : ????????? ?????? ?????? ?????? ??????.
        final Map<String, String> responseData = indicatorsList.stream()
                .map(indicators -> {
                    final Response response = this.wtoTimeSeriesApiClient.getMetadata(DEFAULT_LANGUAGE, indicators.getCode(), DEFAULT_PARAM,
                            DEFAULT_PARAM, DEFAULT_PARAM, false);

                    if (response.status() != HttpStatus.OK.value() || Objects.isNull(response.body())) {
                        return null;
                    }

                    return Map.of(indicators.getCode(), FeignUtil.getBodyString(response));
                })
                .filter(Objects::nonNull)
                .flatMap(data -> data.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        log.info(JsonConvert.toString(responseData));
    }

    @Test
    void saveData() {
        final String economicReporter = "all";
        final String economicPartner = "default";
        final String periodTime = "all";
        final String productClassificationCode = "default";
        final boolean isSubProductClassificationCode = false;
        final String format = "json";
        final String mode = "full";
        final String decimals = "default";
        final int offset = 0;
        final int limited = 10;
        final String headerStyle = "H";
        final boolean isMetadata = false;

        final List<Indicators> indicatorsList = this.indicatorsRepository.findAll();

        assertThat(indicatorsList).isNotNull().isNotEmpty();

        final Map<String, DataResponse> responseMap = indicatorsList.stream().limit(1)
                .map(indicators -> {
                    final Response response = this.wtoTimeSeriesApiClient.getData(DEFAULT_LANGUAGE, indicators.getCode(),
                            economicReporter, economicPartner,
                            periodTime, productClassificationCode, isSubProductClassificationCode, format, mode,
                            decimals, offset, limited, headerStyle, isMetadata);

                    if (response.status() != HttpStatus.OK.value() || Objects.isNull(response.body())) {
                        return null;
                    }

                    final String responseString = FeignUtil.getBodyString(response);

                    log.info(responseString);

                    if (StringUtils.isEmpty(responseString)) {
                        return null;
                    }

                    return Map.of(indicators.getCode(), JsonConvert.toObject(responseString, new TypeReference<DataResponse>() {}));
                })
                .filter(Objects::nonNull)
                .flatMap(data -> data.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        log.info(JsonConvert.toString(responseMap));
    }
}
