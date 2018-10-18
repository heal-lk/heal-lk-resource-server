package org.aum.fhir3.model.base.general;

import javax.persistence.*;

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

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public String getContentType() {
        return contentType;
    }

    public String getLanguage() {
        return language;
    }

    public String getData() {
        return data;
    }

    public String getUrl() {
        return url;
    }

    public String getSize() {
        return size;
    }

    public String getHash() {
        return hash;
    }

    public String getTitle() {
        return title;
    }

    public Date getCreated() {
        return created;
    }
}
