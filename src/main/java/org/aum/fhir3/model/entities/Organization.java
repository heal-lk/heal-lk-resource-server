package org.aum.fhir3.model.entities;

import javax.persistence.*;

import org.aum.fhir3.model.general.Address;
import org.aum.fhir3.model.general.CodeableConcept;
import org.aum.fhir3.model.general.ContactPoint;

import java.io.Serializable;

@Entity
public class Organization implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;    //TODO this id generation is insecure

    @Column(name = "_active")
    private boolean active;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_type")
    private CodeableConcept type;

    @Column(name = "_name", unique = true, length = 30)
    private String name;

    @Column(name = "_alias")
    private String alias;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_telecom")
    private ContactPoint telecom;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_address")
    private Address address;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_partof")
    private Organization partof;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_contact")
    private OrganizationContact contact;

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setType(CodeableConcept type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setTelecom(ContactPoint telecom) {
        this.telecom = telecom;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPartof(Organization partof) {
        this.partof = partof;
    }

    public void setContact(OrganizationContact contact) {
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public CodeableConcept getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public ContactPoint getTelecom() {
        return telecom;
    }

    public Address getAddress() {
        return address;
    }

    public Organization getPartof() {
        return partof;
    }

    public OrganizationContact getContact() {
        return contact;
    }
}
