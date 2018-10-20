package org.aum.fhir3.model.base.general;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;

@Entity
@Table(name="Coding", uniqueConstraints= @UniqueConstraint(columnNames={"_type", "_code"}))
public class Coding implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;
    @Column(name = "_system")
    private String system;

    @Column(name = "_version")
    private String version;

    @Size(max = 30)
    @Column(name = "_code")
    private String code;

    @Column(name = "_display")
    private String display;

    @Column(name = "_selected")
    private boolean selected;

    @Size(max = 30)
    @JsonIgnore
    @Column(name = "_type")
    private String type;    //identifier;disease;payment;clinical
}
