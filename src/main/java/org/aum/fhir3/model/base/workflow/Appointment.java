package org.aum.fhir3.model.base.workflow;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.aum.fhir3.model.base.general.CodeableConcept;
import org.aum.fhir3.model.base.general.Identifier;
import org.aum.fhir3.model.base.general.Participant;
import org.aum.fhir3.model.base.general.Period;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Patient")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_identifier")
    private Identifier identifier;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_code")
    private Identifier code;  //proposed | pending | booked | arrived | fulfilled | cancelled | noshow | entered-in-error

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_serviceCategory")
    private CodeableConcept serviceCategory;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_serviceType")
    private CodeableConcept serviceType;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_appointmentType")
    private CodeableConcept appointmentType;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_reason")
    private CodeableConcept reason;

    //TODO indication


    @Column(name = "_priority")
    private int priority;

    @Column(name = "_description")
    private int description;

    //TODO supporting information
    @Column(name = "_start")
    private Date start;

    @Column(name = "_end")
    private Date end;

    @Column(name = "_minutesDuration")
    private int minutesDuration;

    //TODO Slot

    @Column(name = "_created")
    private Date created;

    @Column(name = "_comment")
    private String comment;

    //TODO incoming

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_participant")
    private Participant participant;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_requestedPeriod")
    private Period requestedPeriod;
}
