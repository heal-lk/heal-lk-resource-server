package org.aum.fhir3.outcome;



import java.io.Serializable;

public class Issue implements Serializable {
    private String _severerity;
    private String _code;
    private String _details;
    private String _diagnostics;
    private String _location;
    private String _expression;

    public String get_severerity() {
        return _severerity;
    }

    public String get_code() {
        return _code;
    }

    public String get_details() {
        return _details;
    }

    public String get_diagnostics() {
        return _diagnostics;
    }

    public String get_location() {
        return _location;
    }

    public String get_expression() {
        return _expression;
    }

    public void set_severerity(String _severerity) {
        this._severerity = _severerity;
    }

    public void set_code(String _code) {
        this._code = _code;
    }

    public void set_details(String _details) {
        this._details = _details;
    }

    public void set_diagnostics(String _diagnostics) {
        this._diagnostics = _diagnostics;
    }

    public void set_location(String _location) {
        this._location = _location;
    }

    public void set_expression(String _expression) {
        this._expression = _expression;
    }
}