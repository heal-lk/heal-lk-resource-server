package org.aum.fhir3.model.base.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "HumanName")
public class HumanName {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @Column(name = "_use")
    private String use;

    @Column(name = "_text")
    private String text;

    @Column(name = "_family")
    private String family;

    @Column(name = "_given")
    private String given;

    @Column(name = "_prefix")
    private String prefix;

    @Column(name = "_suffix")
    private String suffix;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(unique=true, name = "_period")
    private Period period;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setGiven(String given) {
        this.given = given;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
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

    public String getText() {
        return text;
    }

    public String getFamily() {
        return family;
    }

    public String getGiven() {
        return given;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public Period getPeriod() {
        return period;
    }
}
