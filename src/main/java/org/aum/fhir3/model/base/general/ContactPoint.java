package org.aum.fhir3.model.base.general;


import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "ContactPoint")
public class ContactPoint implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @Column(name = "_system")
    private String system;

    @Column(name = "_value")
    private String value;

    @Column(name = "_use")
    private String use;

    @Column(name = "_rank")
    private String rank;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_period")
    private Period period;

    public void setSystem(String system) {
        this.system = system;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public String getSystem() {
        return system;
    }

    public String getValue() {
        return value;
    }

    public String getUse() {
        return use;
    }

    public String getRank() {
        return rank;
    }

    public Period getPeriod() {
        return period;
    }

    public Long getId() {
        return id;
    }
}