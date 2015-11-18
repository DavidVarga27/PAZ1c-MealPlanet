package sk.upjs.ics.mealplanet;

public interface RecipeDao {

    public void add(Recipe recipe);

    public void remove(Recipe recipe);

    public void update(Recipe recipe);
}
