package edu.epam.training.task4.bean;

public class Ingredients {

    private int water;
    private int sugar;
    private int fructose;
    private int vanilla;
    private String chocolateType;

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getFructose() {
        return fructose;
    }

    public void setFructose(int fructose) {
        this.fructose = fructose;
    }

    public int getVanilla() {
        return vanilla;
    }

    public void setVanilla(int vanilla) {
        this.vanilla = vanilla;
    }

    public String getChocolateType() {
        return chocolateType;
    }

    public void setChocolateType(String chocolateType) {
        this.chocolateType = chocolateType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredients)) return false;

        Ingredients that = (Ingredients) o;

        if (getWater() != that.getWater()) return false;
        if (getSugar() != that.getSugar()) return false;
        if (getFructose() != that.getFructose()) return false;
        if (getVanilla() != that.getVanilla()) return false;
        return getChocolateType() != null ? getChocolateType().equals(that.getChocolateType()) : that.getChocolateType() == null;
    }

    @Override
    public int hashCode() {
        int result = getWater();
        result = 31 * result + getSugar();
        result = 31 * result + getFructose();
        result = 31 * result + getVanilla();
        result = 31 * result + (getChocolateType() != null ? getChocolateType().hashCode() : 0);
        return result;
    }
}
