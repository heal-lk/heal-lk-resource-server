package org.aum.fhir3.model.base.general;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;

@Entity
@Table(name="Coding", uniqueConstraints= @UniqueConstraint(columnNames={"_system", "_version", "_code"}))
public class Coding implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;

    @Size(max = 100)
    @Column(name = "_system")
    private String system;

    @Size(max = 20)
    @Column(name = "_version")
    private String version;

    @Size(max = 30)
    @Column(name = "_code")
    private String code;

    @Column(name = "_display")
    private String display;

    @Column(name = "_selected")
    private boolean selected;

    public Coding(){

    }

    public Coding(String system, String version,
                    String code, String display, boolean selected){
        this.system = system;
        this.version = version;
        this.code = code;
        this.display = display;
        this.selected = selected;
    }

    public Long getId() {
        return id;
    }

    public String getSystem() {
        return system;
    }

    public String getVersion() {
        return version;
    }

    public String getCode() {
        return code;
    }

    public String getDisplay() {
        return display;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
