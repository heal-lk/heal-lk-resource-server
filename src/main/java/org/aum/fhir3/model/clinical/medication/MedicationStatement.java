package org.aum.fhir3.model.clinical.medication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.aum.fhir3.model.base.general.CodeableConcept;
import org.aum.fhir3.model.base.general.Identifier;
import org.aum.fhir3.model.base.individual.Annotation;
import org.aum.fhir3.model.foundation.Reference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "MedicationStatement")
public class MedicationStatement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_identifier")
    private Identifier identifier;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_basedOn")
    private List<Reference> basedOn;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_partOf")
    private List<Reference> partOf;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_context")
    private Reference context;

    @Column(name = "_status")
    private String status; //active | completed | entered-in-error | intended | stopped | on-hold

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_category")
    private CodeableConcept category;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_medicationCodableConcept")
    private CodeableConcept medicationCodableConcept;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_medicationReference")
    private CodeableConcept medicationReference;

    @Column(name = "_effectiveDateTime")
    private Date effectiveDateTime;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_effectivePeriod")
    private CodeableConcept effectivePeriod;

    @Column(name = "_dateAsserted")
    private Date dateAsserted;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_informationSource")
    private Reference informationSource;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_subject")
    private Reference subject;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_derivedFrom")
    private List<Reference> derivedFrom;

    @Column(name = "_code")
    private String code;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_reasonNotTaken")
    private List<CodeableConcept> reasonNotTaken;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_reasonCode")
    private List<CodeableConcept> reasonCode;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_reasonReference")
    private Reference reasonReference;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_annotation")
    private List<Annotation> annotation;

    //TODO dosage
}
