package org.aum.fhir3.model.entities;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import org.aum.fhir3.model.entities.Organization;
import org.aum.fhir3.model.general.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "HealthcareService")
public class HealthcareService {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @Column(name = "_active")
    private boolean active;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_providedBy")
    private Organization providedBy;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_category")
    private CodeableConcept category;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_type")
    private CodeableConcept type;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_specialty")
    private CodeableConcept speciality;

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
    @JoinColumn(name = "_attachment")
    private Attachment attachment;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_telecom")
    private ContactPoint telecom;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_coverageArea")
    private List<Location> coverageArea;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_serviceProvisionCode")
    private CodeableConcept serviceProvisionCode;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_eligibility")
    private List<CodeableConcept> eligibility;

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

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_availableTime")
    private AvailableTime availableTime;

    @Column(name = "_availabilityExceptions")
    private String availabilityExceptions;

}
