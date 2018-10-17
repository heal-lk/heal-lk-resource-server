package org.aum.fhir3.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;

@Entity
public class PractitionerQualification implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private CodeableConcept _code;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private Period _period;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private Organization _issuer;
}
