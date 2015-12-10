package sk.upjs.ics.mealplanet;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class MySqlRelationDao implements RelationDao {

    private JdbcTemplate jdbcTemplate;

    public MySqlRelationDao() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost/mealplanet");
        dataSource.setUser("root");
        dataSource.setPassword("271294");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addRelation(Relation relation) {
            String sql ="INSERT INTO relations VALUES(?,?,?,?)";
        jdbcTemplate.update(sql,null,relation.getIdR(),relation.getIdI(),relation.getAmount());
    
    }

    @Override
    public void deleteRelation(Relation relation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
