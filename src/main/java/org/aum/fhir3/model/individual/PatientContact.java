package org.aum.fhir3.model.individual;

import javax.persistence.*;

import org.aum.fhir3.model.general.Address;
import org.aum.fhir3.model.general.ContactPoint;
import org.aum.fhir3.model.general.Period;
import org.aum.fhir3.model.entities.Organization;

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

}
