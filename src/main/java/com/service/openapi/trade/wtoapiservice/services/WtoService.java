package com.service.openapi.trade.wtoapiservice.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.service.openapi.trade.wtoapiservice.clients.WtoTimeSeriesApiClient;
import com.service.openapi.trade.wtoapiservice.entities.wto.*;
import com.service.openapi.trade.wtoapiservice.entities.wto.pk.*;
import com.service.openapi.trade.wtoapiservice.models.wtoapiclient.*;
import com.service.openapi.trade.wtoapiservice.repositories.wto.*;
import com.service.openapi.trade.wtoapiservice.utils.FeignUtil;
import feign.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class WtoService {
    private final WtoTimeSeriesApiClient wtoTimeSeriesApiClient;
    private final ProductClassificationRepository productClassificationRepository;
    private final TopicsRepository topicsRepository;
    private final FrequenciesRepository frequenciesRepository;
    private final PeriodsRepository periodsRepository;
    private final UnitsRepository unitsRepository;
    private final IndicatorCategoriesRepository indicatorCategoriesRepository;
    private final TerritoryRegionsRepository territoryRegionsRepository;
    private final EconomicGroupsRepository economicGroupsRepository;
    private final YearsRepository yearsRepository;
    private final ValueFlagsRepository valueFlagsRepository;
    private final ProductsRepository productsRepository;
    private final EconomicReportersRepository economicReportersRepository;
    private final MappedReporterGroupRepository mappedReporterGroupRepository;
    private final MappedReporterRegionRepository mappedReporterRegionRepository;
    private final EconomicPartnersRepository economicPartnersRepository;
    private final MappedPartnerGroupRepository mappedPartnerGroupRepository;
    private final MappedPartnerRegionRepository mappedPartnerRegionRepository;

    private static final String DEFAULT_LANGUAGE = "1";
    private static final String DEFAULT_PARAM = "all";

    @Transactional
    public void saveProductClassification() {
        final List<ProductClassificationResponse> responses = this.getProductClassificationResponses();

        if (CollectionUtils.isEmpty(responses)) {
            return;
        }

        this.productClassificationRepository.saveAll(responses.stream()
                .map(response -> ProductClassification.builder()
                        .code(response.getCode())
                        .name(response.getName())
                        .build())
                .collect(Collectors.toList()));
    }

    private List<ProductClassificationResponse> getProductClassificationResponses() {
        final Response response = this.wtoTimeSeriesApiClient.getProductClassifications(DEFAULT_LANGUAGE);

        return FeignUtil.getBodyObject(response, new TypeReference<>() {
        });
    }

    @Transactional
    public void saveTopics() {
        final List<TopicsResponse> responses = this.getTopicsResponses();

        if (CollectionUtils.isEmpty(responses)) {
            return;
        }

        this.topicsRepository.saveAll(responses.stream()
                .map(response -> Topics.builder()
                        .id(response.getId())
                        .name(response.getName())
                        .sortOrder(response.getSortOrder())
                        .build())
                .collect(Collectors.toList()));
    }

    private List<TopicsResponse> getTopicsResponses() {
        final Response response = this.wtoTimeSeriesApiClient.getTopics(DEFAULT_LANGUAGE);

        return FeignUtil.getBodyObject(response, new TypeReference<>() {
        });
    }

    @Transactional
    public void saveFrequencies() {
        final List<FrequenciesResponse> responses = this.getFrequenciesResponses();

        if (CollectionUtils.isEmpty(responses)) {
            return;
        }

        this.frequenciesRepository.saveAll(responses.stream()
                .map(response -> Frequencies.builder()
                        .code(response.getCode())
                        .name(response.getName())
                        .build())
                .collect(Collectors.toList()));
    }

    private List<FrequenciesResponse> getFrequenciesResponses() {
        final Response response = this.wtoTimeSeriesApiClient.getFrequencies(DEFAULT_LANGUAGE);

        return FeignUtil.getBodyObject(response, new TypeReference<>() {
        });
    }

    @Transactional
    public void savePeriods() {
        final List<PeriodsResponse> responses = this.getPeriodsResponses();

        if (CollectionUtils.isEmpty(responses)) {
            return;
        }

        this.periodsRepository.saveAll(responses.stream()
                .map(response -> Periods.builder()
                        .code(response.getCode())
                        .name(response.getName())
                        .description(response.getDescription())
                        .frequencyCode(response.getFrequencyCode())
                        .displayOrder(response.getDisplayOrder())
                        .build())
                .collect(Collectors.toList()));
    }

    private List<PeriodsResponse> getPeriodsResponses() {
        final Response response = this.wtoTimeSeriesApiClient.getPeriods(DEFAULT_LANGUAGE);

        return FeignUtil.getBodyObject(response, new TypeReference<>() {
        });
    }

    @Transactional
    public void saveUnits() {
        final List<UnitsResponse> responses = this.getUnitsResponses();

        if (CollectionUtils.isEmpty(responses)) {
            return;
        }

        this.unitsRepository.saveAll(responses.stream()
                .map(response -> Units.builder()
                        .code(response.getCode())
                        .name(response.getName())
                        .build())
                .collect(Collectors.toList()));
    }

    private List<UnitsResponse> getUnitsResponses() {
        final Response response = this.wtoTimeSeriesApiClient.getUnits(DEFAULT_LANGUAGE);

        return FeignUtil.getBodyObject(response, new TypeReference<>() {
        });
    }

    @Transactional
    public void saveIndicatorCategories() {
        final List<IndicatorCategoriesResponse> responses = this.getIndicatorCategoriesResponses();

        if (CollectionUtils.isEmpty(responses)) {
            return;
        }

        this.indicatorCategoriesRepository.saveAll(responses.stream()
                .map(response -> IndicatorCategories.builder()
                        .code(response.getCode())
                        .name(response.getName())
                        .parentCode(response.getParentCode())
                        .sortOrder(response.getSortOrder())
                        .build())
                .collect(Collectors.toList()));
    }

    private List<IndicatorCategoriesResponse> getIndicatorCategoriesResponses() {
        final Response response = this.wtoTimeSeriesApiClient.getIndicatorCategories(DEFAULT_LANGUAGE);

        return FeignUtil.getBodyObject(response, new TypeReference<>() {
        });
    }

    @Transactional
    public void saveTerritoryRegions() {
        final List<TerritoryRegionsResponse> responses = this.getTerritoryRegionsResponses();

        if (CollectionUtils.isEmpty(responses)) {
            return;
        }

        this.territoryRegionsRepository.saveAll(
                responses.stream()
                        .map(response -> TerritoryRegions.builder()
                                .code(response.getCode())
                                .name(response.getName())
                                .displayOrder(response.getDisplayOrder())
                                .build())
                        .collect(Collectors.toList()));
    }

    private List<TerritoryRegionsResponse> getTerritoryRegionsResponses() {
        final Response response = this.wtoTimeSeriesApiClient.getTerritoryRegions(DEFAULT_LANGUAGE);

        return FeignUtil.getBodyObject(response, new TypeReference<>() {
        });
    }

    @Transactional
    public void saveEconomicGroups() {
        final List<EconomicGroupsResponse> responses = this.getEconomicGroupsResponses();

        if (CollectionUtils.isEmpty(responses)) {
            return;
        }

        this.economicGroupsRepository.saveAll(
                responses.stream()
                        .map(response -> EconomicGroups.builder()
                                .code(response.getCode())
                                .name(response.getName())
                                .displayOrder(response.getDisplayOrder())
                                .build())
                        .collect(Collectors.toList()));
    }

    private List<EconomicGroupsResponse> getEconomicGroupsResponses() {
        final Response response = this.wtoTimeSeriesApiClient.getEconomicGroups(DEFAULT_LANGUAGE);

        return FeignUtil.getBodyObject(response, new TypeReference<>() {
        });
    }

    @Transactional
    public void saveYears() {
        final List<YearsResponse> responses = this.getYearsResponses();

        if (CollectionUtils.isEmpty(responses)) {
            return;
        }

        this.yearsRepository.saveAll(
                responses.stream()
                        .map(response -> Years.builder()
                                .year(response.getYear())
                                .build())
                        .collect(Collectors.toList()));
    }

    private List<YearsResponse> getYearsResponses() {
        final Response response = this.wtoTimeSeriesApiClient.getYears();

        return FeignUtil.getBodyObject(response, new TypeReference<>() {
        });
    }

    @Transactional
    public void saveValueFlags() {
        final List<ValueFlagsResponse> responses = this.getValueFlagsResponses();

        if (CollectionUtils.isEmpty(responses)) {
            return;
        }

        this.valueFlagsRepository.saveAll(responses.stream()
                .map(response -> ValueFlags.builder()
                        .code(response.getCode())
                        .description(response.getDescription())
                        .build())
                .collect(Collectors.toList()));
    }

    private List<ValueFlagsResponse> getValueFlagsResponses() {
        final Response response = this.wtoTimeSeriesApiClient.getValueFlags(DEFAULT_LANGUAGE);

        return FeignUtil.getBodyObject(response, new TypeReference<>() {
        });
    }

    @Transactional
    public void saveProducts() {
        final List<ProductClassification> productClassifications = this.productClassificationRepository.findAll();

        if (CollectionUtils.isEmpty(productClassifications)) {
            return;
        }

        final List<Products> productsList = productClassifications.stream()
                .map(productClassification -> {
                    final List<ProductsResponse> responses = this.getProductsResponses(productClassification.getCode());

                    if (CollectionUtils.isEmpty(responses)) {
                        return null;
                    }

                    return responses.stream()
                            .map(response -> Products.builder()
                                    .codeUnique(response.getCodeUnique())
                                    .code(response.getCode())
                                    .name(response.getName())
                                    .note(response.getNote())
                                    .productClassification(response.getProductClassification())
                                    .displayOrder(response.getDisplayOrder())
                                    .hierarchy(response.getHierarchy())
                                    .build())
                            .collect(Collectors.toList());
                }).filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        this.productsRepository.saveAll(productsList);
    }

    private List<ProductsResponse> getProductsResponses(final String productClassificationCode) {
        final Response response = this.wtoTimeSeriesApiClient.getProducts(DEFAULT_LANGUAGE, productClassificationCode);

        return FeignUtil.getBodyObject(response, new TypeReference<>() {
        });
    }

    @Transactional
    public void saveEconomicReporters() {
        final List<EconomicReportersResponse> responses = this.getEconomicReportersResponses(
                DEFAULT_PARAM, DEFAULT_PARAM, DEFAULT_PARAM);

        if (CollectionUtils.isEmpty(responses)) {
            return;
        }

        this.economicReportersRepository.saveAll(responses.stream()
                .map(response -> EconomicReporters.builder()
                        .code(response.getCode())
                        .name(response.getName())
                        .iso3A(response.getIso3A())
                        .displayOrder(response.getDisplayOrder())
                        .build())
                .collect(Collectors.toList()));
    }

    private List<EconomicReportersResponse> getEconomicReportersResponses(
            final String ig, final String legionCode, final String groupCode) {
        final Response response = this.wtoTimeSeriesApiClient.getEconomicReporters(
                DEFAULT_LANGUAGE, ig, legionCode, groupCode);

        return FeignUtil.getBodyObject(response, new TypeReference<>() {});
    }

    @Transactional
    public void savMappedReporterGroups() {
        final List<EconomicGroups> economicGroupsList = this.economicGroupsRepository.findAll();

        if (CollectionUtils.isEmpty(economicGroupsList)) {
            return;
        }

        final List<MappedReporterGroup> mappedReporterGroups = economicGroupsList.stream()
                .map(economicGroups -> {
                    final List<EconomicReportersResponse> reportersResponses = this.getEconomicReportersResponses(
                            DEFAULT_PARAM, DEFAULT_PARAM, economicGroups.getCode());

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
                })
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        if (CollectionUtils.isEmpty(mappedReporterGroups)) {
            return;
        }

        this.mappedReporterGroupRepository.saveAll(mappedReporterGroups);
    }

    @Transactional
    public void saveMappedReporterRegions() {
        final List<TerritoryRegions> regionsList = this.territoryRegionsRepository.findAll();

        if (CollectionUtils.isEmpty(regionsList)) {
            return;
        }

        final List<MappedReporterRegion> mappedReporterRegions = regionsList.stream()
                .map(regions -> {
                    final List<EconomicReportersResponse> reportersResponses = this.getEconomicReportersResponses(
                            DEFAULT_PARAM, regions.getCode(), DEFAULT_PARAM);

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
                })
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        if (CollectionUtils.isEmpty(mappedReporterRegions)) {
            return;
        }

        this.mappedReporterRegionRepository.saveAll(mappedReporterRegions);
    }

    @Transactional
    public void saveEconomicPartners() {
        final List<EconomicPartnersResponse> responses = this.getEconomicPartnersResponses(
                DEFAULT_PARAM, DEFAULT_PARAM, DEFAULT_PARAM);

        if (CollectionUtils.isEmpty(responses)) {
            return;
        }

        this.economicPartnersRepository.saveAll(
                responses.stream()
                        .map(economicPartnersResponse -> EconomicPartners.builder()
                                .code(economicPartnersResponse.getCode())
                                .name(economicPartnersResponse.getName())
                                .iso3A(economicPartnersResponse.getIso3A())
                                .displayOrder(economicPartnersResponse.getDisplayOrder())
                                .build())
                        .collect(Collectors.toList()));
    }

    private List<EconomicPartnersResponse> getEconomicPartnersResponses(
            final String ig, final String legionCode, final String groupCode) {
        final Response response = this.wtoTimeSeriesApiClient.getEconomicPartners(
                DEFAULT_LANGUAGE, ig, legionCode, groupCode);

        return FeignUtil.getBodyObject(response, new TypeReference<>() {});
    }

    @Transactional
    public void saveMappedPartnerGroups() {
        final List<EconomicGroups> economicGroupsList = this.economicGroupsRepository.findAll();

        if (CollectionUtils.isEmpty(economicGroupsList)) {
            return;
        }

        final List<MappedPartnerGroup> mappedPartnerGroups = economicGroupsList.stream()
                .map(economicGroups -> {
                    final List<EconomicPartnersResponse> partnersResponses = this.getEconomicPartnersResponses(
                            DEFAULT_PARAM, DEFAULT_PARAM, economicGroups.getCode());

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

        if (CollectionUtils.isEmpty(mappedPartnerGroups)) {
            return;
        }

        this.mappedPartnerGroupRepository.saveAll(mappedPartnerGroups);
    }

    @Transactional
    public void saveMappedPartnerRegion() {
        final List<TerritoryRegions> regionsList = this.territoryRegionsRepository.findAll();

        if (CollectionUtils.isEmpty(regionsList)) {
            return;
        }

        final List<MappedPartnerRegion> mappedPartnerRegions = regionsList.stream()
                .map(regions -> {
                    final List<EconomicPartnersResponse> partnersResponses = this.getEconomicPartnersResponses(
                            DEFAULT_PARAM, regions.getCode(), DEFAULT_PARAM);

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

        if (CollectionUtils.isEmpty(mappedPartnerRegions)) {
            return;
        }

        this.mappedPartnerRegionRepository.saveAll(mappedPartnerRegions);
    }
}
