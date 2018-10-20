package org.aum.fhir3.model.clinical.summary;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.aum.fhir3.model.base.general.Abatement;
import org.aum.fhir3.model.base.general.CodeableConcept;
import org.aum.fhir3.model.base.general.Identifier;
import org.aum.fhir3.model.base.general.Onset;
import org.aum.fhir3.model.base.individual.Annotation;
import org.aum.fhir3.model.foundation.Reference;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "_AllergyIntolerence")
public class AllergyIntolerence {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(unique=true, name = "_identifier")
    private Identifier identifier;

    @Column(name = "_clinicalStatus")
    private String clinicalStatus;

    @Column(name = "_type")
    private String type;

    @ElementCollection
    @Column(name = "_category")
    private List<String> category;

    @Column(name = "_criticality")
    private String criticality;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_code")
    private CodeableConcept code;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_patient")
    private Reference patient;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_onset")
    private Onset onset;

    @Column(name = "_assertedDate")
    private Date assertedDate;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_recorder")
    private Reference recorder;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_asserter")
    private Reference asserter;

    @Column(name = "_lastOccurence")
    private Date lastOccurence;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_annotation")
    private List<Annotation> annotation;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_reaction")
    private List<AllergyIntolerenceReaction> reaction;
}
