package sk.upjs.ics.mealplanet;

/**
 *
 * @author DaviD a PaTrick
 */
public enum RelationDaoFactory {
        INSTANCE;

    public RelationDao getRelationDao() {
        return new MySqlRelationDao();
    }

}
