package edu.epam.training.task4.bean;

public enum Production {

    ROSHEN("Roshen"),
    IVKON("Ivkon"),
    SPARTAK("Spartak"),
    KOMMUNARKA("Kommunarka");

    private final String value;

    Production (String value){
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static Production fromValue(String value) {
        for (Production currentEnum: Production.values()) {
            if (currentEnum.value.equals(value)) {
                return currentEnum;
            }
        }
        throw new IllegalArgumentException(value);
    }
}
