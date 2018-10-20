package org.aum.fhir3.outcome;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OperationOutcome implements Serializable{

    private Issue issue = new Issue();

    public OperationOutcome(String _severerity,
                            String _code,
                            String _details,
                            String _diagnostics,
                            String _location,
                            String _expression){
        issue.setSevererity(_severerity);
        issue.setCode(_code);
        issue.setDetails(_details);
        issue.setDiagnostics(_diagnostics);
        issue.setLocation(_location);
        issue.setExpression(_expression);

    }

    public static OperationOutcome RecordExists(){
        return new OperationOutcome("error", "401", "record already exists", null,null , null );

    }

    public static final OperationOutcome InternalError(){
        return new OperationOutcome("error", "401", "internal error", null,null , null );

    }

    public static final OperationOutcome RecordNotFound(){
        return new OperationOutcome("error", "401", "record not found", null,null , null );

    }

    public static final OperationOutcome InvalidParameter(){
        return new OperationOutcome("error", "401", "please check your input; invalid data present", null,null , null );

    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }
}

