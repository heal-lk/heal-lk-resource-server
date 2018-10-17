package org.aum.fhir3.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;

@Entity
public class Organization implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //TODO this id generation is insecure

    private boolean _active;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private CodeableConcept _type;

    @Column(unique = true, length = 30)
    private String _name;

    private String _alias;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private ContactPoint _telecom;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private Address _address;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private Organization _partof;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private OrganizationContact _contact;

    public void set_active(boolean _active) {
        this._active = _active;
    }

    public void set_type(CodeableConcept _type) {
        this._type = _type;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_alias(String _alias) {
        this._alias = _alias;
    }

    public void set_telecom(ContactPoint _telecom) {
        this._telecom = _telecom;
    }

    public void set_address(Address _address) {
        this._address = _address;
    }

    public void set_partof(Organization _partof) {
        this._partof = _partof;
    }

    public void set_contact(OrganizationContact _contact) {
        this._contact = _contact;
    }

    public Long getId() {
        return id;
    }

    public boolean is_active() {
        return _active;
    }

    public CodeableConcept get_type() {
        return _type;
    }

    public String get_name() {
        return _name;
    }

    public String get_alias() {
        return _alias;
    }

    public ContactPoint get_telecom() {
        return _telecom;
    }

    public Address get_address() {
        return _address;
    }

    public Organization get_partof() {
        return _partof;
    }

    public OrganizationContact get_contact() {
        return _contact;
    }

    //private Endpoint _endpoint;
}
