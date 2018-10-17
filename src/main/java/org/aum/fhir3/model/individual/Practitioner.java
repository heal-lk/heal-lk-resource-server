package org.aum.fhir3.model.individual;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.aum.fhir3.model.general.Address;
import org.aum.fhir3.model.general.Attachment;
import org.aum.fhir3.model.general.CodeableConcept;
import org.aum.fhir3.model.general.ContactPoint;

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

    private boolean _active;

    @NotNull
    @Size(max = 100)
    @Column(name = "_firstname")
    private String firstname;

    @NotNull
    @Size(max = 100)
    @Column(name = "_lastname")
    private String lastname;

    @NotNull
    @Size(max = 100)
    @Column(name = "_nic")
    private String nic;

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

    //TODO PHASE 2
    /*@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private CodeableConcept _communication;*/

    public void set_active(boolean _active) {
        this._active = _active;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setNic(String nic) {
        this.nic = nic;
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

    public boolean is_active() {
        return _active;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNic() {
        return nic;
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
