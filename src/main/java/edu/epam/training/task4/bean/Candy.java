package edu.epam.training.task4.bean;

public class Candy {

    private String id;
    private String name;
    private CandyTypes type;
    private Filling filling;
    private Ingredients ingredients;
    private NutritionValue value;
    private Production production;
    private int energy;

     public Candy() {
        this.ingredients =  new Ingredients ();
        this.value = new NutritionValue ();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CandyTypes getType() {
        return type;
    }

    public void setType(CandyTypes type) {
        this.type = type;
    }

    public Filling getFilling() {
        return filling;
    }

    public void setFilling(Filling filling) {
        this.filling = filling;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public NutritionValue getValue() {
        return value;
    }

    public void setValue(NutritionValue value) {
        this.value = value;
    }

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candy)) return false;

        Candy candy = (Candy) o;

        if (getEnergy() != candy.getEnergy()) return false;
        if (getId() != null ? !getId().equals(candy.getId()) : candy.getId() != null) return false;
        if (getName() != null ? !getName().equals(candy.getName()) : candy.getName() != null) return false;
        if (getType() != candy.getType()) return false;
        if (getFilling() != candy.getFilling()) return false;
        if (getIngredients() != null ? !getIngredients().equals(candy.getIngredients()) : candy.getIngredients() != null)
            return false;
        if (getValue() != null ? !getValue().equals(candy.getValue()) : candy.getValue() != null) return false;
        return getProduction() == candy.getProduction();
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getFilling() != null ? getFilling().hashCode() : 0);
        result = 31 * result + (getIngredients() != null ? getIngredients().hashCode() : 0);
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        result = 31 * result + (getProduction() != null ? getProduction().hashCode() : 0);
        result = 31 * result + getEnergy();
        return result;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", filling=" + filling +
                ", ingredients=" + ingredients +
                ", value=" + value +
                ", production=" + production +
                ", energy=" + energy +
                '}';
    }
}
