package org.aum.fhir3.model.enums;

public enum ENUM_ADDRESS_USE {
    HOME("home"), WORK("work"), TEMP("temp"), OLD("old");
    private final String text;

    ENUM_ADDRESS_USE(final String text){
        this.text = text;
    }

    @Override
    public String toString(){
        return this.text;
    }
}
