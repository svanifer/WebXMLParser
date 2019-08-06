package edu.epam.training.task4.bean;

public class NutritionValue {

    private int proteins;
    private int fats;
    private int carbohydrates;

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NutritionValue)) return false;

        NutritionValue value = (NutritionValue) o;

        if (getProteins() != value.getProteins()) return false;
        if (getFats() != value.getFats()) return false;
        return getCarbohydrates() == value.getCarbohydrates();
    }

    @Override
    public int hashCode() {
        int result = getProteins();
        result = 31 * result + getFats();
        result = 31 * result + getCarbohydrates();
        return result;
    }

    @Override
    public String toString() {
        return "NutritionValue{" +
                "proteins=" + proteins + '\'' +
                ", fats=" + fats + '\'' +
                ", carbohydrates=" + carbohydrates +
                '}';
    }
}
