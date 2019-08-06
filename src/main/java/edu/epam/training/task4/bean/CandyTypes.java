package edu.epam.training.task4.bean;

public enum CandyTypes {

    CARAMEL("caramel"),
    CHOCOLATE("chocolate"),
    IRIS("iris"),
    LOLLOPOP("lollipop");

    private final String value;

    CandyTypes (String value){
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static CandyTypes fromValue(String value) {
        for (CandyTypes currentEnum: CandyTypes.values()) {
            if (currentEnum.value.equals(value)) {
                return currentEnum;
            }
        }
        throw new IllegalArgumentException(value);
    }
}
