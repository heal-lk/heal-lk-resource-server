package org.aum.fhir3.model.base.entities;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import org.aum.fhir3.model.base.general.*;
import org.aum.fhir3.model.foundation.Reference;

import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "HealthcareService")
public class HealthcareService {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(unique=true, name = "_identifier")
    private Identifier identifier;

    @Column(name = "_active")
    private boolean active;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_providedBy")
    private Reference providedBy;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_category")
    private CodeableConcept category;

    @OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @Column(name = "_type")
    private List<CodeableConcept> type;

    @OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @Column(name = "_speciality")
    private List<CodeableConcept> speciality;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_location")
    private List<Location> location;

    @Column(name = "_name")
    private String name;

    @Column(name = "_comment")
    private String comment;

    @Column(name = "_extraDetails")
    private String extraDetails;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_photo")
    private Attachment photo;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_telecom")
    private List<ContactPoint> telecom;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_coverageArea")
    private List<Location> coverageArea;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_serviceProvisionCode")
    private List<CodeableConcept> serviceProvisionCode;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_eligibility")
    private CodeableConcept eligibility;

    @Column(name = "_eligibilityNote")
    private String eligibilityNote;

    @Column(name = "_programName")
    private String programName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_charecteristics")
    private List<CodeableConcept> charecteristics;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_referalMethods")
    private List<CodeableConcept> referalMethods;

    @Column(name = "_appointmentRequired")
    private boolean appointmentRequired;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_availableTime")
    private List<AvailableTime> availableTime;

    @Column(name = "_availabilityExceptions")
    private String availabilityExceptions;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_endpoint")
    private List<Reference> endpoint;

}
