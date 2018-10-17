package org.aum.fhir3.model.general;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
