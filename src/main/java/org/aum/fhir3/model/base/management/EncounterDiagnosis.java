package org.aum.fhir3.model.base.management;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import org.aum.fhir3.model.base.entities.Organization;
import org.aum.fhir3.model.base.general.*;
import org.aum.fhir3.model.foundation.Reference;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "_EncounterDiagnosis")
public class EncounterDiagnosis {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_condition")
    private Reference condition;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_role")
    private List<CodeableConcept> role;

    @Column(name = "_rank")
    private Integer rank;
}
