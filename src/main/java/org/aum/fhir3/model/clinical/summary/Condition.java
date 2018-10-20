package org.aum.fhir3.model.clinical;


import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.aum.fhir3.model.base.general.Abatement;
import org.aum.fhir3.model.base.general.CodeableConcept;
import org.aum.fhir3.model.base.general.Identifier;
import org.aum.fhir3.model.base.general.Onset;
import org.aum.fhir3.model.base.individual.Annotation;
import org.aum.fhir3.model.base.individual.Patient;
import org.aum.fhir3.model.base.individual.Practitioner;
import org.aum.fhir3.model.foundation.Reference;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "_Condition")
public class Condition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_identifier")
    private Identifier identifier;

    @Column(name = "_clinicalStatus")
    private String clinicalStatus;  //active|recurrence|inactive|remission|resolved

    @Column(name = "_verificationStatus")
    private String verificationStatus;  //active|recurrence|inactive|remission|resolved

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_category")
    private List<CodeableConcept> category;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_severity")
    private CodeableConcept severity;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_code")
    private CodeableConcept code;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_bodySite")
    private List<CodeableConcept> bodySite;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_subject")
    private Reference subject;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_context")
    private Reference context;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_onset")
    private Onset onset;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_abatement")
    private Abatement abatement;

    @Column(name = "_assertedDate")
    private Date assertedDate;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_asserter")
    private Reference asserter;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_stage")
    private ConditionStage stage;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_evidence")
    private ConditionEvidence evidence;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_annotation")
    private Annotation annotation;
}
