package org.aum.fhir3.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Practitioner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean _active;

    private String _firstname;

    private String _lastname;

    private String _nic;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private ContactPoint _telecom;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private Address _address;

    private String _gender;

    private Date _birthDate;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private Attachment _photo;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private PractitionerQualification _qualification;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private CodeableConcept _communication;

    public void set_active(boolean _active) {
        this._active = _active;
    }

    public void set_firstname(String _firstname) {
        this._firstname = _firstname;
    }

    public void set_lastname(String _lastname) {
        this._lastname = _lastname;
    }

    public void set_nic(String _nic) {
        this._nic = _nic;
    }

    public void set_telecom(ContactPoint _telecom) {
        this._telecom = _telecom;
    }

    public void set_address(Address _address) {
        this._address = _address;
    }

    public void set_gender(String _gender) {
        this._gender = _gender;
    }

    public void set_birthDate(Date _birthDate) {
        this._birthDate = _birthDate;
    }

    public void set_photo(Attachment _photo) {
        this._photo = _photo;
    }

    public void set_qualification(PractitionerQualification _qualification) {
        this._qualification = _qualification;
    }

    public void set_communication(CodeableConcept _communication) {
        this._communication = _communication;
    }

    public Long getId() {
        return id;
    }

    public boolean is_active() {
        return _active;
    }

    public String get_firstname() {
        return _firstname;
    }

    public String get_lastname() {
        return _lastname;
    }

    public String get_nic() {
        return _nic;
    }

    public ContactPoint get_telecom() {
        return _telecom;
    }

    public Address get_address() {
        return _address;
    }

    public String get_gender() {
        return _gender;
    }

    public Date get_birthDate() {
        return _birthDate;
    }

    public Attachment get_photo() {
        return _photo;
    }

    public PractitionerQualification get_qualification() {
        return _qualification;
    }

    public CodeableConcept get_communication() {
        return _communication;
    }
}
