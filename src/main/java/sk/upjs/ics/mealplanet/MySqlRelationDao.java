package sk.upjs.ics.mealplanet;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
        String sql = "INSERT INTO relations VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, null, relation.getIdR(), relation.getIdI(), relation.getAmount());

    }

    @Override
    public void deleteRelation(Relation relation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Relation> getAll() {
        String sql = "SELECT * FROM relations";
        BeanPropertyRowMapper<Relation> mapper = BeanPropertyRowMapper.newInstance(Relation.class);//tovaren pre rowmapper
        List<Relation> relations = jdbcTemplate.query(sql, mapper);
        return relations;
    }

    @Override
    public List<Relation> getMatching(long idR) {
        List<Relation> relations = new ArrayList<>();
        for (Relation relation : this.getAll()) {
            if (relation.idR == idR) {
                relations.add(relation);
            }
        }

        return relations;
    }

    @Override
    public void delete(long idR) {// tu nie je update, v databaze sa vymazu a napisu nanovo
        String sql = "DELETE FROM relations where idR = ?";
        jdbcTemplate.update(sql,idR); // idReceptu
    }

}
