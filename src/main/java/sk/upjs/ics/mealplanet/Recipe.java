package sk.upjs.ics.mealplanet;

import java.util.List;

public class Recipe {

    private long id;
   
    private String name;
    
    private int type; // typ, dezert,predjedlo,hlavne jedlo, snack, polievka...
   
    private List<Ingredient> ingredients; 
    
    private int prepTime; // cas na pripravu

    private String steps; //
    
    private long rating;

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
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
