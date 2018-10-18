package org.aum.fhir3.model.base.individual;

import javax.persistence.*;

import org.aum.fhir3.model.base.general.Address;
import org.aum.fhir3.model.base.general.ContactPoint;
import org.aum.fhir3.model.base.general.Period;
import org.aum.fhir3.model.base.entities.Organization;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PatientContact")
public class PatientContact implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;

    @Column(name = "_firstname")
    private String firstname;

    @Column(name = "_lastname")
    private String lastname;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_telecom")
    private ContactPoint telecom;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_address")
    private Address address;

    @Column(name = "_gender")
    private String gender;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_organization")
    private Organization organization;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_period")
    private Period period;

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setTelecom(ContactPoint telecom) {
        this.telecom = telecom;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public ContactPoint getTelecom() {
        return telecom;
    }

    public Address getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public Organization getOrganization() {
        return organization;
    }

    public Period getPeriod() {
        return period;
    }
}
