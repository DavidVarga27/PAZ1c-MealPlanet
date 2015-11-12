package sk.upjs.ics.mealplanet;

import java.util.List;

public class Recipe {

    private long id;
   
    private String name;
    
    private String type; // typ, dezert,predjedlo,hlavne jedlo, snack, polievka...
   
    private List<Ingredient> ingredients; 
    
    private int prepTime; // cas na pripravu

    private String steps; //

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    @Override
    public String toString() {
        return "Recipe{" + "id=" + id + ", name=" + name + ", type=" + type + ", ingredients=" + ingredients + ", prepTime=" + prepTime + ", steps=" + steps + '}';
    }
    
    
}
