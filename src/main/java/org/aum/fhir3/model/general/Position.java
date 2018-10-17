package org.aum.fhir3.model.general;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import org.aum.fhir3.model.entities.Organization;
import org.aum.fhir3.model.general.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Position")
public class Position {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @Column(name = "_longitude")
    private String longitude;

    @Column(name = "_latitude")
    private String latitude;

    @Column(name = "_altitude")
    private String altitude;
}
