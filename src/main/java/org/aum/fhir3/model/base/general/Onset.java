package org.aum.fhir3.model.base.general;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.aum.fhir3.model.base.general.CodeableConcept;
import org.aum.fhir3.model.base.general.Identifier;
import org.aum.fhir3.model.base.individual.Patient;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Onset")
public class Onset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;

    @Column(name = "_onsetDateTime")
    private Date onsetDateTime;

    @Column(name = "_onsetAge")
    private Integer onsetAge;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_onsetPeriod")
    private Period onsetPeriod;

    //TODO private Range onsetRange;
    @Column(name = "_onsetString")
    private String onsetString;
}
