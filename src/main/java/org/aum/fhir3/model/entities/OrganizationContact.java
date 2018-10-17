package org.aum.fhir3.model.entities;

import javax.persistence.*;

import org.aum.fhir3.model.general.Address;
import org.aum.fhir3.model.general.ContactPoint;

import java.io.Serializable;

@Entity
public class OrganizationContact implements Serializable {
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
}
