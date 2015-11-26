package sk.upjs.ics.mealplanet;

import org.springframework.jdbc.core.JdbcTemplate;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class MySqlRecipeDao implements RecipeDao {

    private JdbcTemplate jdbcTemplate;

    public MySqlRecipeDao() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost/mealplanet");
        dataSource.setUser("root");
        dataSource.setPassword("271294");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void add(Recipe recipe) {

    }

    @Override
    public void remove(Recipe recipe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Recipe recipe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Recipe> getAll() {

        String sql = "SELECT * FROM recipes";
        BeanPropertyRowMapper<Recipe> mapper = BeanPropertyRowMapper.newInstance(Recipe.class);//tovaren
        List<Recipe> recipes = jdbcTemplate.query(sql, mapper);// recepty tak ako v databaze
        
         for (Recipe recipe : recipes){
         String sql2 = "SELECT * FROM mealtypes where idT = ?";
         BeanPropertyRowMapper<MealType> mapper2 = BeanPropertyRowMapper.newInstance(MealType.class);
         List<MealType> mealType = jdbcTemplate.query(sql2, mapper2,recipe.getType());
         recipe.setMealtype(mealType.get(0));
         }
        
        return recipes;//ak mam v databaze rovnake meno tych parametrov ako tu v tomto projekte tak mi to vyberie z databazy data tu do Listu
    }

    @Override
    public List<Recipe> getMatchingName(String name) {
        List<Recipe> allRecipes = this.getAll();
        List<Recipe> matchingRecipes = new ArrayList<>();
        for (Recipe matchingRecipe : allRecipes) {
            if (matchingRecipe.getName().toLowerCase().contains(name.toLowerCase())) {
                matchingRecipes.add(matchingRecipe);
            }
        }

        return matchingRecipes;
    }

    /* @Override
     public List<Type> getAllTypes() {
     String sql = "SELECT * FROM type";
     BeanPropertyRowMapper<Type> mapper = BeanPropertyRowMapper.newInstance(Type.class);//tovaren
     return jdbcTemplate.query(sql, mapper);
     } */
    @Override
    public List<Recipe> getMatching(String name, int mealType) {
        if (mealType == 0) {
            return this.getMatchingName(name);
        }
        List<Recipe> matchingRecipes = new ArrayList<>();

        for (Recipe matchingRecipe : this.getMatchingName(name)) {
            if (matchingRecipe.getType() == mealType) {
                matchingRecipes.add(matchingRecipe);
            }
        }
        return matchingRecipes;
    }

}
