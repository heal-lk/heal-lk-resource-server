package org.aum.fhir3.model.base.entities;

import javax.persistence.*;

import org.aum.fhir3.model.base.general.Address;
import org.aum.fhir3.model.base.general.ContactPoint;

import java.io.Serializable;

@Entity
public class OrganizationContact implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;

    @Column(name = "_firstname")
    private String firstName;

    @Column(name = "_lastname")
    private String lastName;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_telecom")
    private ContactPoint telecom;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_address")
    private Address address;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTelecom(ContactPoint telecom) {
        this.telecom = telecom;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ContactPoint getTelecom() {
        return telecom;
    }

    public Address getAddress() {
        return address;
    }
}
