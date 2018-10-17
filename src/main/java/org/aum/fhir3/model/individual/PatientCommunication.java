package org.aum.fhir3.model.individual;

import javax.persistence.*;

import org.aum.fhir3.model.general.CodeableConcept;
import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "PatientCommunication")
public class PatientCommunication implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_language")
    private CodeableConcept language;

    @Column(name = "_prefered")
    private boolean prefered;
}
