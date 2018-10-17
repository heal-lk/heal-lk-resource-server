package org.aum.fhir3.model.enums;

public enum ENUM_ADDRESS_TYPE {
    POSTAL("postal"), PHYSICAL("physical"), BOTH("both");
    private final String text;

    ENUM_ADDRESS_TYPE(final String text){
        this.text = text;
    }

    @Override
    public String toString(){
        return this.text;
    }
}
