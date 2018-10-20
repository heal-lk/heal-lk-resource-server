package org.aum.fhir3.model.base.management;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import org.aum.fhir3.model.base.entities.Organization;
import org.aum.fhir3.model.base.general.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "_EncounterClassHistory")
public class EncounterClassHistory {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @Column(name = "_class")
    private String _class;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(unique=true, name = "_period")
    private Period period;
}
