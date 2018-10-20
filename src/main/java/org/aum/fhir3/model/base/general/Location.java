package org.aum.fhir3.model.base.general;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import org.aum.fhir3.model.base.entities.Organization;
import org.aum.fhir3.model.foundation.Reference;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Location")
public class Location {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_identifier")
    private Identifier identifier;

    @Column(name = "_status")
    private String status;  //active/suspended/inactive

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_operationalStatus")
    private Coding operationalStatus;

    @Column(name = "_name")
    private String name;

    @Column(name = "_alias")
    private String alias;

    @Column(name = "_description")
    private String description;

    @Column(name = "_mode")
    private String mode;        // instance | kind

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_type")
    private CodeableConcept type;

    @OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @Column(name = "_telecom")
    private List<ContactPoint> telecom;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_address")
    private Address address;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_physicalType")
    private CodeableConcept physicalType;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_position")
    private Position position;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_managingOrganization")
    private Reference managingOrganization;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_partOf")
    private Reference partOf;

    @OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @Column(name = "_endpoint")
    private List<ContactPoint> endpoint;

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOperationalStatus(Coding operationalStatus) {
        this.operationalStatus = operationalStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setType(CodeableConcept type) {
        this.type = type;
    }

    public void setTelecom(List<ContactPoint> telecom) {
        this.telecom = telecom;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhysicalType(CodeableConcept physicalType) {
        this.physicalType = physicalType;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setManagingOrganization(Reference managingOrganization) {
        this.managingOrganization = managingOrganization;
    }

    public void setPartOf(Reference partOf) {
        this.partOf = partOf;
    }

    public void setEndpoint(List<ContactPoint> endpoint) {
        this.endpoint = endpoint;
    }

    public Long getId() {
        return id;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public String getStatus() {
        return status;
    }

    public Coding getOperationalStatus() {
        return operationalStatus;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public String getDescription() {
        return description;
    }

    public String getMode() {
        return mode;
    }

    public CodeableConcept getType() {
        return type;
    }

    public List<ContactPoint> getTelecom() {
        return telecom;
    }

    public Address getAddress() {
        return address;
    }

    public CodeableConcept getPhysicalType() {
        return physicalType;
    }

    public Position getPosition() {
        return position;
    }

    public Reference getManagingOrganization() {
        return managingOrganization;
    }

    public Reference getPartOf() {
        return partOf;
    }

    public List<ContactPoint> getEndpoint() {
        return endpoint;
    }
}
