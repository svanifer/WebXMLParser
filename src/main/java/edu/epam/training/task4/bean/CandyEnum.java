package edu.epam.training.task4.bean;

public enum CandyEnum {

    CANDIES("candies"),
    CANDY("candy"),
    ID("id"),
    TYPE("type"),
    FILLING("filling"),
    NAME("name"),
    ENERGY("energy"),
    VANILLA("vanilla"),
    SUGAR("sugar"),
    FRUCTOSE("fructose"),
    CHOCOLATE_TYPE("chocolate-type"),
    WATER("water"),
    FATS("fats"),
    PROTEINS("proteins"),
    CARBOHYDRATES("carbohydrates"),
    PRODUCTION("production"),
    INGREDIENTS("ingredients"),
    VALUE("value");

    private String field;

    CandyEnum(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
