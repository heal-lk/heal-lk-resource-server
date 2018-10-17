package org.aum.fhir3.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import java.io.Serializable;


@Entity
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String _firstName;

    private String _lastName;

	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private ContactPoint _telecom;

    public String get_firstName() {
        return _firstName;
    }

    public String get_lastName() {
        return _lastName;
    }

    public ContactPoint get_telecom() {
        return _telecom;
    }
}