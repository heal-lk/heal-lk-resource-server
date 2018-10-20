package org.aum.fhir3.model.clinical;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.aum.fhir3.model.base.general.CodeableConcept;
import org.aum.fhir3.model.foundation.Reference;

import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "__ConditionEvidence")
public class ConditionEvidence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_code")
    private CodeableConcept code;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_detail")
    private List<Reference> detail;
}
