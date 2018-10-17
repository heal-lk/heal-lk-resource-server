package org.aum.fhir3.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

import java.io.Serializable;

@Entity
public class Period implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date _start;

    private Date _end;

    public void set_start(Date _start) {
        this._start = _start;
    }

    public void set_end(Date _end) {
        this._end = _end;
    }

    public Long getId() {
        return id;
    }

    public Date get_start() {
        return _start;
    }

    public Date get_end() {
        return _end;
    }
}
