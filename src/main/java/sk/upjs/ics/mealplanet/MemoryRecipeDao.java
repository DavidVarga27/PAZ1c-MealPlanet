package sk.upjs.ics.mealplanet;

import java.util.ArrayList;
import java.util.List;


public class MemoryRecipeDao implements RecipeDao{

    private List<Recipe> recipes = new ArrayList<>();
    
    public MemoryRecipeDao(){
    Recipe recipe1 = new Recipe();
    List<Ingredient> ingredients=new ArrayList<>();
    
    Ingredient muka= new Ingredient();///////////////////////muka
    muka.setName("Hladka muka");
    muka.setAmount("40 dkg");
    muka.setId(1);
    
    Ingredient maslo= new Ingredient();///////////////////////maslo
    maslo.setName("maslo");
    maslo.setAmount("pol kocky");
    maslo.setId(2);
    
    ingredients.add(muka);
    ingredients.add(maslo);
    
    recipe1.setId(1);
    recipe1.setName("apple pie");
    recipe1.setPrepTime(55);
    recipe1.setType(1);
    recipe1.setSteps("povedz babke nech ti zrobi");
    recipe1.setIngredients(ingredients);
    
    recipes.add(recipe1);
    
    }
    
    @Override
    public void add(Recipe recipe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Recipe recipe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Recipe recipe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "MemoryRecipeDao{" + "recipes=" + recipes.get(0).toString() + '}';
    }

    
   
    
}
