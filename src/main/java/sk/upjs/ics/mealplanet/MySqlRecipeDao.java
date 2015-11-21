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
        List<Recipe> recipes = jdbcTemplate.query(sql, mapper);
        List<Recipe> newRecipes = new ArrayList<>();
        List<Long> idArray = new ArrayList<>();//id receptu ale uz sa neopakuje
        for (Recipe oneRecipe : recipes) {
            oneRecipe.setIngredient(-1);
            if (!idArray.contains(oneRecipe.getId())) {
                idArray.add(oneRecipe.getId());
                newRecipes.add(oneRecipe);

            }

        }
        for (Recipe oneRecipe : newRecipes) {
            Long id = oneRecipe.getId();
            String ingr = "SELECT * FROM recipes WHERE id = ? ";
            BeanPropertyRowMapper<Recipe> mapper2 = BeanPropertyRowMapper.newInstance(Recipe.class);
            List<Recipe> ingred = jdbcTemplate.query(ingr, mapper2, id);
            List<Integer> ingredients = new ArrayList<>();
            for (Recipe ingRecipe : ingred) {
                ingredients.add(ingRecipe.getIngredient());

            }

            oneRecipe.setIngredients(ingredients);

        }

        return newRecipes;//ak mam v databaze rovnake meno tych parametrov ako tu v tomto projekte tak mi to vyberie z databazy data tu do Listu
    }

    @Override
    public List<Recipe> getMatching(String name) {
        List<Recipe> allRecipes = this.getAll();
        List<Recipe> matchingRecipes = new ArrayList<>();
        for (Recipe matchingRecipe : allRecipes) {
            if (matchingRecipe.getName().toLowerCase().contains(name.toLowerCase())) {
                matchingRecipes.add(matchingRecipe);
            }
        }

        return matchingRecipes;
    }

}
