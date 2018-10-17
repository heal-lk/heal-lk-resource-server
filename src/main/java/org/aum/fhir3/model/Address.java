package org.aum.fhir3.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import com.fasterxml.jackson.annotation.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String _use;
    private String _type;
    private String _text;
    private String _line;
    private String _city;
    private String _district;
    private String _province;
    private String _postalCode;
    private String _country;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    private Period _period;

    public void set_use(String _use) {
        this._use = _use;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public void set_text(String _text) {
        this._text = _text;
    }

    public void set_line(String _line) {
        this._line = _line;
    }

    public void set_city(String _city) {
        this._city = _city;
    }

    public void set_district(String _district) {
        this._district = _district;
    }

    public void set_province(String _province) {
        this._province = _province;
    }

    public void set_postalCode(String _postalCode) {
        this._postalCode = _postalCode;
    }

    public void set_country(String _country) {
        this._country = _country;
    }

    public void set_period(Period _period) {
        this._period = _period;
    }

    public Long getId() {
        return id;
    }

    public String get_use() {
        return _use;
    }

    public String get_type() {
        return _type;
    }

    public String get_text() {
        return _text;
    }

    public String get_line() {
        return _line;
    }

    public String get_city() {
        return _city;
    }

    public String get_district() {
        return _district;
    }

    public String get_province() {
        return _province;
    }

    public String get_postalCode() {
        return _postalCode;
    }

    public String get_country() {
        return _country;
    }

    public Period get_period() {
        return _period;
    }
}

