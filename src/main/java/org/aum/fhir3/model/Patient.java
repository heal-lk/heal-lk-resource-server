package org.aum.fhir3.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.*;

import java.util.Date;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Patient implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String _firstName;

    private String _lastName;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private Identifier _identifier;

    private boolean _active;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private ContactPoint _telecom;

    private String _gender;

    public void set_identifier(Identifier _identifier) {
        this._identifier = _identifier;
    }

    public Identifier get_identifier() {
        return _identifier;
    }

    private Date _birthDate;

    private boolean _deceased;

    private Date _deceasedDateTime;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private Address _address;

    private boolean _married;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private Attachment _photo;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private PatientContact _contact;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private PatientCommunication _communication;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private PatientLink _link;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private Organization _managingOrganization;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private Practitioner _generalPractitioner;


    public void set_firstName(String _firstName) {
        this._firstName = _firstName;
    }

    public void set_lastName(String _lastName) {
        this._lastName = _lastName;
    }

    public String get_firstName() {
        return _firstName;
    }

    public String get_lastName() {
        return _lastName;
    }

    public Long getId() {
        return id;
    }

    public boolean is_active() {
        return _active;
    }

    public ContactPoint get_telecom() {
        return _telecom;
    }

    public String get_gender() {
        return _gender;
    }

    public Date get_birthDate() {
        return _birthDate;
    }

    public boolean is_deceased() {
        return _deceased;
    }

    public Date get_deceasedDateTime() {
        return _deceasedDateTime;
    }

    public Address get_address() {
        return _address;
    }

    public boolean is_married() {
        return _married;
    }

    public Attachment get_photo() {
        return _photo;
    }

    public PatientContact get_contact() {
        return _contact;
    }

    public PatientCommunication get_communication() {
        return _communication;
    }

    public PatientLink get_link() {
        return _link;
    }

    public Organization get_managingOrganization() {
        return _managingOrganization;
    }

    public Practitioner get_generalPractitioner() {
        return _generalPractitioner;
    }

    public void set_active(boolean _active) {
        this._active = _active;
    }

    public void set_telecom(ContactPoint _telecom) {
        this._telecom = _telecom;
    }

    public void set_gender(String _gender) {
        this._gender = _gender;
    }

    public void set_birthDate(Date _birthDate) {
        this._birthDate = _birthDate;
    }

    public void set_deceased(boolean _deceased) {
        this._deceased = _deceased;
    }

    public void set_deceasedDateTime(Date _deceasedDateTime) {
        this._deceasedDateTime = _deceasedDateTime;
    }

    public void set_address(Address _address) {
        this._address = _address;
    }

    public void set_married(boolean _married) {
        this._married = _married;
    }

    public void set_photo(Attachment _photo) {
        this._photo = _photo;
    }

    public void set_contact(PatientContact _contact) {
        this._contact = _contact;
    }

    public void set_communication(PatientCommunication _communication) {
        this._communication = _communication;
    }

    public void set_link(PatientLink _link) {
        this._link = _link;
    }


    public void set_managingOrganization(Organization _managingOrganization) {
        this._managingOrganization = _managingOrganization;
    }

    public void set_generalPractitioner(Practitioner _generalPractitioner) {
        this._generalPractitioner = _generalPractitioner;
    }
}

