package org.aum.fhir3.model.base.general;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.*;
import org.aum.fhir3.model.foundation.Reference;

import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Identifier")
public class Identifier {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @Column(name = "_use")
    private String use;    //official;usual;temp;secondary

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_type")
    private CodeableConcept type;

    @Column(name = "_system")
    private String system;

    @Size(max = 50)
    @Column(unique = true, name = "_value")
    private String value;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_period")
    private Period period;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_assigner")
    private Reference assigner;

    public Reference getAssigner() {
        return assigner;
    }

    public void setAssigner(Reference assigner) {
        this.assigner = assigner;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public void setType(CodeableConcept type) {
        this.type = type;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public void setValue(String value) {
        this.value = value;
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

    public CodeableConcept getType() {
        return type;
    }

    public String getSystem() {
        return system;
    }

    public String getValue() {
        return value;
    }

    public Period getPeriod() {
        return period;
    }
}
