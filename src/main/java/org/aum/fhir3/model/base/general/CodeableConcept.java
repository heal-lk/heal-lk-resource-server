package org.aum.fhir3.model.base.general;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "CodeableConcept")
public class CodeableConcept implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_coding")
    private List<Coding> coding;

    @Column(name = "_text")
    private String text;

    public void setCoding(List<Coding> coding) {
        this.coding = coding;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public List<Coding> getCoding() {
        return coding;
    }

    public String getText() {
        return text;
    }


}
