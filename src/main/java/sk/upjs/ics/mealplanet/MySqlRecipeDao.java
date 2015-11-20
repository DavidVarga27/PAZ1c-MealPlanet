package sk.upjs.ics.mealplanet;

import org.springframework.jdbc.core.JdbcTemplate;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class MySqlRecipeDao implements RecipeDao{

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
        return jdbcTemplate.query(sql, mapper);//ak mam v databaze rovnake meno tych parametrov ako tu v tomto projekte tak mi to vyberie z databazy data tu do Listu
    }
    
    @Override
    public List<Recipe> getMatching(String name) {
       String sql = "SELECT * FROM recipes WHERE name = ? ";
        BeanPropertyRowMapper<Recipe> mapper = BeanPropertyRowMapper.newInstance(Recipe.class);//tovaren
        
        return jdbcTemplate.query(sql, mapper,name);
    }

   

}
