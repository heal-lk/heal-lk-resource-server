package org.aum.fhir3.model.base.individual;

import javax.persistence.*;

import org.aum.fhir3.model.base.general.CodeableConcept;
import org.aum.fhir3.model.base.general.Period;
import org.aum.fhir3.model.base.entities.Organization;
import org.aum.fhir3.model.foundation.Reference;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "PractitionerQualification")
public class PractitionerQualification implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @Column(name = "_code")
    private List<CodeableConcept> code;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_period")
    private Period period;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_issuer")
    private Reference issuer;
}
