package sk.upjs.ics.mealplanet;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class MySqlIngredientDao implements IngredientDao {

    private JdbcTemplate jdbcTemplate;
    
    public MySqlIngredientDao() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost/mealplanet");
        dataSource.setUser("root");
        dataSource.setPassword("271294");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        String sql = "INSERT INTO ingredients VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, null, ingredient.getName(), ingredient.getProtein(),
                ingredient.getFat(), ingredient.getCarb());

    }
}
