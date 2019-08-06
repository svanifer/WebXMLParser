package edu.epam.training.task4.bean;

public enum Filling {

    LIQOUR("liquor"),
    NOUGAT("nougat"),
    NUTS("nuts"),
    CREAM("cream");

    private final String value;

    Filling (String value){
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static Filling fromValue(String value) {
        for (Filling currentEnum: Filling.values()) {
            if (currentEnum.value.equals(value)) {
                return currentEnum;
            }
        }
        throw new IllegalArgumentException(value);
    }
}
