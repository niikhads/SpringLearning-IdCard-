package com.example.LearningSpring.Repository.Impl;

import com.example.LearningSpring.Model.Entity.IdCard;
import com.example.LearningSpring.Repository.IdCardRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IdCardRepositoryImpl implements IdCardRepository {

    private final JdbcTemplate jdbcTemplate;

    public IdCardRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<IdCard> getAll() {
        String query = "SELECT i.id, i.name, i.surname, i.age, i.fincode, i.series, i.serial_number FROM passenger_system.idtable i;";

        RowMapper<IdCard> rowMapper = new RowMapper<>() {
            @Override
            public IdCard mapRow(ResultSet rs, int rowNum) throws SQLException {
                return buildIdCard(rs);
            }
        };

        return jdbcTemplate.query(query, rowMapper);
    }

    @Override
    public IdCard getById(Long id) {
        String query = "SELECT i.id, i.name, i.surname, i.age, i.fincode, i.series, i.serial_number FROM passenger_system.idtable i WHERE i.id = ?";

        RowMapper<IdCard> rowMapper = new RowMapper<IdCard>() {
            @Override
            public IdCard mapRow(ResultSet rs, int rowNum) throws SQLException {
                return buildIdCard(rs);
            }
        };

        List<IdCard> idCards = jdbcTemplate.query(query, rowMapper, id);

        if (idCards.isEmpty()) {
            return IdCard.builder()
                    .build();
        }

        return idCards.get(0);
    }

    @Override
    public boolean insert(IdCard idCard) {
        String query = "INSERT INTO passenger_system.idtable (name, surname, age, fincode, series, serial_number) VALUES (?, ?, ?, ?, ?, ?);";

        int res = jdbcTemplate.update(query, idCard.getName(), idCard.getSurname(), idCard.getAge(), idCard.getFinCode(), idCard.getSeries(), idCard.getSerialNumber());

        return res != 0;
    }

    @Override
    public boolean update(IdCard idCard) {
        String query = "UPDATE passenger_system.idtable i SET i.name = ?, i.surname = ?, i.age = ?, i.fincode = ?, series = ?, i.serial_number = ? WHERE i.id = ?";

        int res = jdbcTemplate.update(query, idCard.getName(), idCard.getSurname(), idCard.getAge(), idCard.getFinCode(), idCard.getSeries(), idCard.getSerialNumber(), idCard.getId());

        return res != 0;
    }

    @Override
    public boolean updateAge(Long id, Integer age) {
        String query = "UPDATE passenger_system.idtable i SET i.age = ? WHERE i.id = ?";

        int res = jdbcTemplate.update(query, age, id);

        return res != 0;
    }

    @Override
    public boolean delete(Long id) {
        String query = "DELETE FROM passenger_system.idtable i WHERE i.id = ?;";

        int res = jdbcTemplate.update(query, id);

        return res != 0;
    }

    private IdCard buildIdCard(ResultSet rs) throws SQLException {
        return IdCard.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .surname(rs.getString("surname"))
                .age(rs.getInt("age"))
                .finCode(rs.getString("fincode"))
                .series(rs.getString("series"))
                .serialNumber(rs.getString("serial_number"))
                .build();
    }
}