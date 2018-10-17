package org.aum.fhir3.model.individual;

import javax.persistence.*;

import org.aum.fhir3.model.general.CodeableConcept;
import org.aum.fhir3.model.general.Period;
import org.aum.fhir3.model.entities.Organization;

import java.io.Serializable;

@Entity
@Table(name = "PractitionerQualification")
public class PractitionerQualification implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_code")
    private CodeableConcept code;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_period")
    private Period period;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_issuer")
    private Organization issuer;
}