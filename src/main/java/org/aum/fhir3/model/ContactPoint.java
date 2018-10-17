package org.aum.fhir3.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.io.Serializable;

@Entity
public class ContactPoint implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String _system;

    private String _value;

    private String _use;

    private String _rank;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private Period _period;


    public void set_system(String _system) {
        this._system = _system;
    }

    public void set_value(String _value) {
        this._value = _value;
    }

    public void set_use(String _use) {
        this._use = _use;
    }

    public void set_rank(String _rank) {
        this._rank = _rank;
    }

    public void set_period(Period _period) {
        this._period = _period;
    }

    public String get_system() {
        return _system;
    }

    public String get_value() {
        return _value;
    }

    public String get_use() {
        return _use;
    }

    public String get_rank() {
        return _rank;
    }

    public Period get_period() {
        return _period;
    }

    public Long getId() {
        return id;
    }
}