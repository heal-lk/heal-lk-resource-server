package org.aum.fhir3.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import com.fasterxml.jackson.annotation.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Identifier {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String _use;    //official;usual;temp;secondary

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private CodeableConcept _type;

    private String _system;

    private String _value;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private Period _period;

    //TODO
    //private Reference _assigner


}
