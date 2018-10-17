package org.aum.fhir3.outcome;

import java.io.Serializable;



public class OperationOutcome implements Serializable{
    private Issue _issue;

    public OperationOutcome(String _severerity,
                            String _code,
                            String _details,
                            String _diagnostics,
                            String _location,
                            String _expression){

        _issue.set_severerity(_severerity);
        _issue.set_code(_code);
        _issue.set_details(_details);
        _issue.set_diagnostics(_diagnostics);
        _issue.set_location(_location);
        _issue.set_expression(_expression);

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
}

