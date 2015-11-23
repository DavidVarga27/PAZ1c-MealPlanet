package sk.upjs.ics.mealplanet;

import java.util.List;

public interface RecipeDao {

    public void add(Recipe recipe);

    public void remove(Recipe recipe);

    public void update(Recipe recipe);

    public List<Recipe> getAll();
    
    public List<Recipe> getMatchingName(String name);
    
    public List<Recipe> getMatching(String name,int mealType);
    
}
