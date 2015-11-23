package sk.upjs.ics.mealplanet;

import java.util.List;

public class Recipe {// toto neni celkovy recept ale recept s jednou ingredienciou

    private long id;
   
    private String name;
    
    private int type; // typ, dezert,predjedlo,hlavne jedlo, snack, polievka...
    
    private String amount;
    
    private int ingredient; 
    
    private List<Integer> ingredients; 
    
    private int prepTime; // cas na pripravu

    private String steps; //
    
    private long rating;
    
   

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public List<Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Integer> ingredients) {
        this.ingredients = ingredients;
    }

    
    
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

    public int getIngredient() {
        return ingredient;
    }
    

    public void setIngredient(int ingredient) {
        this.ingredient = ingredient;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    
}
