package org.aum.fhir3.model.base.general;

import java.util.Date;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Period")
public class Period implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;

    @Column(name = "_start")
    private Date start;

    @Column(name = "_end")
    private Date end;

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
}
