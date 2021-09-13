package com.service.openapi.trade.wtoapiservice.entities.wto;

import java.io.Serializable;

import javax.persistence.*;
import com.service.openapi.trade.wtoapiservice.entities.EntityBaseAudit;
import com.service.openapi.trade.wtoapiservice.entities.wto.pk.MappedPartnerGroupPk;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Validated
@Entity
@Table(name = "wto_mapped_partner_group")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
@IdClass(MappedPartnerGroupPk.class)
public class MappedPartnerGroup extends EntityBaseAudit implements Serializable {
    @Id
    @NonNull
    @Column(name = "group_code", length = 20)
    private String groupCode;

    @Id
    @NonNull
    @Column(name = "partner_code", length = 20)
    private String partnerCode;

    @Builder
    private MappedPartnerGroup(final MappedPartnerGroupPk pk) {
        this.groupCode = pk.getGroupCode();
        this.partnerCode = pk.getPartnerCode();
    }
}
