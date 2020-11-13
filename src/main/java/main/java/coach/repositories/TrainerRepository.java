package main.java.coach.repositories;

import main.java.coach.classes.trainer.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface TrainerRepository extends CrudRepository<Trainer, UUID> {
    /*
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TrainerRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Trainer> selectAllTrainers(){
        String sql = "SELECT id,name,surname,password,email FROM trainer";
        return jdbcTemplate.query(sql, mapTrainerFomDb());
    }


    private RowMapper<Trainer> mapTrainerFomDb() {
        return (resultSet, i) -> {
            String trainerIdStr = resultSet.getString("id");
            UUID id = UUID.fromString(trainerIdStr);

            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");

            return new Trainer(id,name,surname,password,email);
        };
    }

     */
}
