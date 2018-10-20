package org.aum.fhir3.model.foundation;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.aum.fhir3.model.base.general.Abatement;
import org.aum.fhir3.model.base.general.CodeableConcept;
import org.aum.fhir3.model.base.general.Identifier;
import org.aum.fhir3.model.base.general.Onset;
import org.aum.fhir3.model.base.individual.Patient;
import org.aum.fhir3.model.base.individual.Practitioner;

import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Reference")
public class Reference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;

    @Column(name = "_reference")
    private String reference;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_identifier")
    private Identifier identifier;

    @Column(name = "_display")
    private String display;

}
