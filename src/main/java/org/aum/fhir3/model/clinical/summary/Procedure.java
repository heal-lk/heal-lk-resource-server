package org.aum.fhir3.model.clinical.summary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.aum.fhir3.model.base.general.CodeableConcept;
import org.aum.fhir3.model.base.general.Identifier;
import org.aum.fhir3.model.base.general.Location;
import org.aum.fhir3.model.base.general.Period;
import org.aum.fhir3.model.base.individual.Annotation;
import org.aum.fhir3.model.foundation.Reference;

import javax.persistence.*;
import java.util.List;
import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "_Procedure")
public class Procedure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_identifier")
    private Identifier identifier;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_definition")
    private List<Reference> definition;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_basedOn")
    private List<Reference> basedOn;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_partOf")
    private List<Reference> partOf;

    @Column(name = "_status")
    private String status;    // preparation | in-progress | suspended | aborted | completed | entered-in-error | unknown

    @Column(name = "_notDone")
    private boolean notDone;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_notDoneReason")
    private CodeableConcept notDoneReason;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_category")
    private CodeableConcept category;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_code")
    private CodeableConcept code;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_subject")
    private CodeableConcept subject;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_context")
    private CodeableConcept context;

    @Column(name = "_performedDateTime")
    private Date performedDateTime;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_performedPeriod")
    private Period performedPeriod;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_performer")
    private List<ProcedurePerformer> performer;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_location")
    private Location location;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_reasonCode")
    private List<CodeableConcept> reasonCode;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_reasonReference")
    private List<CodeableConcept> reasonReference;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_bodySite")
    private List<CodeableConcept> bodySite;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_outcome")
    private CodeableConcept outcome;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_report")
    private List<Reference> report;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_complication")
    private List<CodeableConcept> complication;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_complicationDetail")
    private List<Reference> complicationDetail;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_followUp")
    private List<CodeableConcept> followUp;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_annotation")
    private List<Annotation> annotation;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_focalDevice")
    private List<ProcedureFocalDevice> focalDevice;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_usedReference")
    private List<Reference> usedReference;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_usedCode")
    private List<CodeableConcept> usedCode;
}
