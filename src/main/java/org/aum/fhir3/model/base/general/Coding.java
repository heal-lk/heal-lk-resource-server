package org.aum.fhir3.model.base.general;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Coding")
public class Coding implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;
    @Column(name = "_system")
    private String system;

    @Column(name = "_version")
    private String version;

    @Column(name = "_code")
    private String code;

    @Column(name = "_display")
    private String display;

    @Column(name = "_selected")
    private boolean selected;
}
