package org.aum.fhir3.model.general;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Attachment")
public class Attachment implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @Column(name = "_contentType")
    private String contentType;

    @Column(name = "_language")
    private String language;

    @Column(name = "_data")
    private String data;

    @Column(name = "_url")
    private String url;

    @Column(name = "_size")
    private String size;

    @Column(name = "_hash")
    private String hash;

    @Column(name = "_title")
    private String title;

    @Column(name = "_created")
    private Date created;
}
