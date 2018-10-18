package org.aum.fhir3.model.base.general;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Address")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @Column(name = "_use")
    private String use;

    @Column(name = "_type")
    private String type;

    @Column(name = "_text")
    private String text;

    @Column(name = "_line")
    private String line;

    @Column(name = "_city")
    private String city;

    @Column(name = "_district")
    private String district;

    @Column(name = "_province")
    private String province;

    @Column(name = "_postalCode")
    private String postalCode;

    @Column(name = "_country")
    private String country;

    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    @JoinColumn(name = "_period")
    private Period period;

    public void setUse(String use) {
        this.use = use;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Long getId() {
        return id;
    }

    public String getUse() {
        return use;
    }

    public String getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public String getLine() {
        return line;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public Period getPeriod() {
        return period;
    }
}

