package org.aum.fhir3.model.individual;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import org.aum.fhir3.model.entities.HealthcareService;
import org.aum.fhir3.model.entities.Organization;
import org.aum.fhir3.model.general.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "PractitionerRole")
public class PractitionerRole {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    //TODO phase 2
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_identifier")
    private Identifier identifier;

    @Column(name = "_active")
    private boolean active;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_period")
    private Period period;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_practitionerRole")
    private Practitioner practitionerRole;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_organization")
    private Organization organization;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_code")
    private List<CodeableConcept> code;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_speciality")
    private CodeableConcept speciality;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_location")
    private List<Location> location;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_healthcareService")
    private List<HealthcareService> healthcareService;

    @Column(name = "_telecom")
    private ContactPoint telecom;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_availableTime")
    private AvailableTime availableTime;

    @Column(name = "_availabilityExceptions")
    private String availabilityExceptions;
}
