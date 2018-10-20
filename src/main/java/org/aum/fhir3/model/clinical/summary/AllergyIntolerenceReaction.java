package org.aum.fhir3.model.clinical.summary;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.aum.fhir3.model.base.general.Abatement;
import org.aum.fhir3.model.base.general.CodeableConcept;
import org.aum.fhir3.model.base.general.Identifier;
import org.aum.fhir3.model.base.general.Onset;
import org.aum.fhir3.model.base.individual.Annotation;
import org.aum.fhir3.model.foundation.Reference;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "__AllergyIntolerenceReaction")
public class AllergyIntolerenceReaction {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_substance")
    private CodeableConcept substance;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_manifestation")
    private List<CodeableConcept> manifestation;

    @Column(name = "_description")
    private String description;

    @Column(name = "_onset")
    private Date onset;

    @Column(name = "_severity")
    private Date severity;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_exposureRoute")
    private CodeableConcept exposureRoute;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_annotation")
    private List<Annotation> annotation;
}
