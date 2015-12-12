package sk.upjs.ics.mealplanet;

/**
 *
 * @author DaviD a PaTrick
 */
public enum IngredientDaoFactory {

    INSTANCE;

    public IngredientDao getIngredientDao() {
        return new MySqlIngredientDao();
    }

}
