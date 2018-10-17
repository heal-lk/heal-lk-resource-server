package org.aum.fhir3.model;

public enum ENUM_GENDER {
    MALE("male"), FEMALE("female"), OTHER("other"), UNKNOWN("unknown");
    private final String text;

    ENUM_GENDER(final String text){
        this.text = text;
    }

    @Override
    public String toString(){
        return this.text;
    }
}
