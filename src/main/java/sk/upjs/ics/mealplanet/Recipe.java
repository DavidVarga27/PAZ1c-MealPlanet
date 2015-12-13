package sk.upjs.ics.mealplanet;

import java.util.List;


public class Recipe {// toto neni celkovy recept ale recept s jednou ingredienciou

    private long idR;
   
    private String name;
    
    private int type; // typ, dezert,predjedlo,hlavne jedlo, snack, polievka...
    
    private MealType mealtype;
    
    private List<Ingredient> ingredients; 
        
    private int prepTime; // cas na pripravu

    private String steps; //
    
    private int rating; /// tu asi staci integer

    public MealType getMealtype() {
        return mealtype;
    }

    public void setMealtype(MealType mealtype) {
        this.mealtype = mealtype;
    }

    
    
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }
    
    public long getIdR() {
        return idR;
    }

    public void setIdR(long idR) {
        this.idR = idR;
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
