package org.aum.fhir3.model.general;

import javax.persistence.*;

import org.aum.fhir3.model.general.Coding;

import java.io.Serializable;

@Entity
@Table(name = "CodeableConcept")
public class CodeableConcept implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_coding")
    private Coding coding;

    @Column(name = "_text")
    private String text;
}
