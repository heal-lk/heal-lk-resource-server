package org.aum.fhir3.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;

@Entity
public class OrganizationContact implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String _firstname;

    private String _lastname;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private ContactPoint _telecom;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private Address _address;
}
