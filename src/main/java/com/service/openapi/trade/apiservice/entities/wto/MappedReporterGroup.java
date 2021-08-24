package com.service.openapi.trade.apiservice.entities.wto;

import java.io.Serializable;

import javax.persistence.*;
import com.service.openapi.trade.apiservice.entities.EntityBaseAudit;
import com.service.openapi.trade.apiservice.entities.wto.pk.MappedReporterGroupPk;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Validated
@Entity
@Table(name = "wto_mapped_reporter_group")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
@IdClass(MappedReporterGroupPk.class)
public class MappedReporterGroup extends EntityBaseAudit implements Serializable {
    @Id
    @NonNull
    @Column(name = "group_code", length = 20)
    private String groupCode;

    @Id
    @NonNull
    @Column(name = "reporter_code", length = 20)
    private String reporterCode;

    @Builder
    private MappedReporterGroup(final MappedReporterGroupPk pk) {
        this.groupCode = pk.getGroupCode();
        this.reporterCode = pk.getReporterCode();
    }
}
