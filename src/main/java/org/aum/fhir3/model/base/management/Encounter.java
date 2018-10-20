package org.aum.fhir3.model.base.management;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import org.aum.fhir3.model.base.general.*;
import org.aum.fhir3.model.foundation.Reference;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Encounter")
public class Encounter {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(unique=true, name = "_identifier")
    private Identifier identifier;

    @Column(name = "_status")
    private String status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_statusHistory")
    private List<EncounterStatusHistory> statusHistory;

    @Column(name = "_class")
    private String _class;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_classHistory")
    private List<EncounterStatusHistory> classHistory;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_type")
    private List<CodeableConcept> type;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(unique=true, name = "_priority")
    private Identifier priority;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_subject")
    private Reference subject;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_episodeOfCare")
    private List<Reference> episodeOfCare;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_incomingReferal")
    private List<Reference> incomingReferal;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_participant")
    private List<EncounterParticipant> participant;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_appointment")
    private Reference appointment;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_period")
    private Period period;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_reason")
    private List<CodeableConcept> reason;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_diagnosis")
    private List<EncounterDiagnosis> diagnosis;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_account")
    private List<Reference> account;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_hospitalization")
    private EncounterHospitalization hospitalization;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_specialArrangement")
    private List<EncounterLocation> location;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_serviceProvider")
    private Reference serviceProvider;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_partOf")
    private Reference partOf;
}
