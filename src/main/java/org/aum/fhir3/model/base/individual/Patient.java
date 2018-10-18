package org.aum.fhir3.model.base.individual;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import org.aum.fhir3.model.base.entities.Organization;
import org.aum.fhir3.model.base.general.Address;
import org.aum.fhir3.model.base.general.Attachment;
import org.aum.fhir3.model.base.general.ContactPoint;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Patient")
public class Patient implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "_firstname")
    private String firstName;

    @NotNull
    @Size(max = 100)
    @Column(name = "_lastName")
    private String lastName;

    @NotNull
    @Size(max = 30)
    @Column(unique = true, name = "_nic")
    private String nic;

    //TODO phase 2
    /*@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_identifier")
    private Identifier identifier;*/

    @Column(name = "_active")
    private boolean active;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_telecom")
    private List<ContactPoint> telecom;

    @Column(name = "_gender")
    private String gender;

    @Column(name = "_birthDate")
    private Date birthDate;

    @Column(name = "_deceased")
    private boolean deceased;

    @Column(name = "_deceasedDateTime")
    private Date deceasedDateTime;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_address")
    private List<Address> address;

    @Column(name = "_married")
    private boolean married;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_photo")
    private Attachment photo;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_contact")
    private PatientContact contact;

    //TODO PHASE 2
    /*@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "join_patient_communication",
            joinColumns = { @JoinColumn(name = "_patient_id") },
            inverseJoinColumns = { @JoinColumn(name = "_communication_id") })
    private List<PatientCommunication> communication;*/

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_link")
    private PatientLink link;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_managingOrganization")
    private Organization managingOrganization;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_generalPractitioner")
    private Practitioner generalPractitioner;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }*/

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setTelecom(List<ContactPoint> telecom) {
        this.telecom = telecom;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeceased(boolean deceased) {
        this.deceased = deceased;
    }

    public void setDeceasedDateTime(Date deceasedDateTime) {
        this.deceasedDateTime = deceasedDateTime;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public void setPhoto(Attachment photo) {
        this.photo = photo;
    }

    public void setContact(PatientContact contact) {
        this.contact = contact;
    }

    /*public void setCommunication(List<PatientCommunication> communication) {
        this.communication = communication;
    }*/

    public void setLink(PatientLink link) {
        this.link = link;
    }

    public void setManagingOrganization(Organization managingOrganization) {
        this.managingOrganization = managingOrganization;
    }

    public void setGeneralPractitioner(Practitioner generalPractitioner) {
        this.generalPractitioner = generalPractitioner;
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

    /*public Identifier getIdentifier() {
        return identifier;
    }*/

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getNic() {
        return nic;
    }

    public boolean isActive() {
        return active;
    }

    public List<ContactPoint> getTelecom() {
        return telecom;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public boolean isDeceased() {
        return deceased;
    }

    public Date getDeceasedDateTime() {
        return deceasedDateTime;
    }

    public List<Address> getAddress() {
        return address;
    }

    public boolean isMarried() {
        return married;
    }

    public Attachment getPhoto() {
        return photo;
    }

    public PatientContact getContact() {
        return contact;
    }

    /*public List<PatientCommunication> getCommunication() {
        return communication;
    }*/

    public PatientLink getLink() {
        return link;
    }

    public Organization getManagingOrganization() {
        return managingOrganization;
    }

    public Practitioner getGeneralPractitioner() {
        return generalPractitioner;
    }
}

