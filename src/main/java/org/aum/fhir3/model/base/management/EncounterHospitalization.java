package org.aum.fhir3.model.base.management;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import org.aum.fhir3.model.base.entities.Organization;
import org.aum.fhir3.model.base.general.*;
import org.aum.fhir3.model.foundation.Reference;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "_EncounterHospitalization")
public class EncounterHospitalization {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_preAdmissionIdentifier")
    private Identifier preAdmissionIdentifier;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_origin")
    private Reference origin;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_admitSource")
    private CodeableConcept admitSource;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_reAdmission")
    private CodeableConcept reAdmission;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_dietPreference")
    private List<CodeableConcept> dietPreference;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_specialCourtesy")
    private List<CodeableConcept> specialCourtesy;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_specialArrangement")
    private List<CodeableConcept> specialArrangement;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_destination")
    private Reference destination;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_dischargeDisposition")
    private CodeableConcept dischargeDisposition;
}
