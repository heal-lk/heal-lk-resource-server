package org.aum.fhir3.model.clinical.summary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.aum.fhir3.model.base.general.CodeableConcept;
import org.aum.fhir3.model.foundation.Reference;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "__ProcedurePerformer")
public class ProcedurePerformer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_role")
    private CodeableConcept role;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_actor")
    private Reference actor;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_onBehalfOf")
    private Reference onBehalfOf;
}
