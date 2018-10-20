package org.aum.fhir3.outcome;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Issue implements Serializable {

    private String severerity;
    private String code;
    private String details;
    private String diagnostics;
    private String location;
    private String expression;

    public void setSevererity(String severerity) {
        this.severerity = severerity;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setDiagnostics(String diagnostics) {
        this.diagnostics = diagnostics;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getSevererity() {
        return severerity;
    }

    public String getCode() {
        return code;
    }

    public String getDetails() {
        return details;
    }

    public String getDiagnostics() {
        return diagnostics;
    }

    public String getLocation() {
        return location;
    }

    public String getExpression() {
        return expression;
    }
}