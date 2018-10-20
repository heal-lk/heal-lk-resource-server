package org.aum.fhir3.model.base.individual;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.aum.fhir3.model.base.general.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Practitioner")
public class Practitioner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(unique=true, name = "_identifier")
    private Identifier identifier;

    private boolean active;

    @NotNull
    @Size(max = 100)
    @Column(name = "_firstname")
    private String firstName;

    @NotNull
    @Size(max = 100)
    @Column(name = "_lastname")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_telecom")
    private List<ContactPoint> telecom;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_address")
    private List<Address> address;

    @Column(name = "_gender")
    private String gender;

    @Column(name = "_birthDate")
    private Date birthDate;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_photo")
    private Attachment photo;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_qualification")
    private PractitionerQualification qualification;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Column(name = "_communication")
    private List<CodeableConcept> communication;

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public void setTelecom(List<ContactPoint> telecom) {
        this.telecom = telecom;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhoto(Attachment photo) {
        this.photo = photo;
    }

    public void setQualification(PractitionerQualification qualification) {
        this.qualification = qualification;
    }

    public Long getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public String getFirstname() {
        return firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public List<ContactPoint> getTelecom() {
        return telecom;
    }

    public List<Address> getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Attachment getPhoto() {
        return photo;
    }

    public PractitionerQualification getQualification() {
        return qualification;
    }
}
