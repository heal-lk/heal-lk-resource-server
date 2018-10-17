package org.aum.fhir3.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;

@Entity
public class PatientLink implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String _type;

    private String _url;

    public Long getId() {
        return id;
    }

    public String get_type() {
        return _type;
    }

    public String get_url() {
        return _url;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public void set_url(String _url) {
        this._url = _url;
    }
}
