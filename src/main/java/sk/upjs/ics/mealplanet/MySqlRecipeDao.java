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
        String sql = "INSERT INTO recipes VALUES(?,?,?,?,?,?)";
        jdbcTemplate.update(sql, recipe.getIdR(), recipe.getName(), recipe.getPrepTime(), recipe.getSteps(), recipe.getRating(), recipe.getType());
    }

    @Override
    public void remove(Recipe recipe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Recipe recipe) {
        String sql = "UPDATE recipes SET name = ?, prepTime=?,steps=?,rating=?,type=? where idR=?;";
        jdbcTemplate.update(sql,recipe.getName(),recipe.getPrepTime(),recipe.getSteps(),recipe.getRating(),recipe.getType(),recipe.getIdR());
    }

    @Override
    public List<Recipe> getAll() {//metoda, ktora z databazy vrati zoznam receptov

        String sql = "SELECT * FROM recipes";
        BeanPropertyRowMapper<Recipe> mapper = BeanPropertyRowMapper.newInstance(Recipe.class);//tovaren pre rowmapper
        List<Recipe> recipes = jdbcTemplate.query(sql, mapper);// recepty tak ako v databaze

        for (Recipe recipe : recipes) {
            String sql2 = "SELECT * FROM mealtypes where idT = ?";
            BeanPropertyRowMapper<MealType> mapper2 = BeanPropertyRowMapper.newInstance(MealType.class);
            List<MealType> mealType = jdbcTemplate.query(sql2, mapper2, recipe.getType());
            recipe.setMealtype(mealType.get(0));
            String sql3 = "select ingredients.idI,ingredients.name,ingredients.protein,ingredients.fat,ingredients.carb from ingredients \n"
                    + "join relations on ingredients.idI=relations.idI\n"
                    + "join recipes on recipes.idr=relations.idr where recipes.idr=?;";
            BeanPropertyRowMapper<Ingredient> mapper3 = BeanPropertyRowMapper.newInstance(Ingredient.class);
            List<Ingredient> ingredients = jdbcTemplate.query(sql3, mapper3, recipe.getIdR());
            recipe.setIngredients(ingredients);
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
