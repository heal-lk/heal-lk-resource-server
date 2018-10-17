package org.aum.fhir3.model.individual;


import org.aum.fhir3.model.general.ContactPoint;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name = "Person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;

    @NotNull
    @Column(name = "_firstName")
    private String firstName;

    @Column(name = "_lastName")
    private String lastName;

	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_telecom")
    private ContactPoint telecom;

}