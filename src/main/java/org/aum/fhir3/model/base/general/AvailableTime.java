package org.aum.fhir3.model.base.general;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "AvailableTime")
public class AvailableTime {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @Column(name = "_daysOfWeek")
    private String daysOfWeek;

    @Column(name = "_allDay")
    private boolean allDay;

    @Column(name = "_availableStartTime")
    private Date availableStartTime;

    @Column(name = "_availableEndTime")
    private Date availableEndTime;
}
