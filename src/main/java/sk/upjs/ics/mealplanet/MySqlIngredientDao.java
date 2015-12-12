package sk.upjs.ics.mealplanet;

import org.springframework.jdbc.core.JdbcTemplate;

public class MySqlIngredientDao implements IngredientDao {

    private JdbcTemplate jdbcTemplate;

    public void addIngredient(Ingredient ingredient) {
        String sql = "INSERT INTO ingredients VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, null, ingredient.getName(), ingredient.getProtein(), ingredient.getFat(), ingredient.getCarb());

    }
}
