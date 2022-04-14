package com.introidx.lhc_backend.repositories;

import com.introidx.lhc_backend.domain.User;
import com.introidx.lhc_backend.exceptions.EtAuthException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Created by PRAKASH RANJAN on 11-04-2022
 */

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String SQL_CREATE = "INSERT INTO LHC_USERS(USER_ID, NAME, EMAIL, PASSWORD, ROLE) VALUES(NEXTVAL('LHC_USERS_SEQ'), ?, ?, ?, ?)";
    private static final String SQL_COUNT_BY_EMAIL = "SELECT COUNT(*) FROM LHC_USERS WHERE EMAIL = ?";
    private static final String SQL_FIND_BY_ID = "SELECT USER_ID, NAME, EMAIL, PASSWORD, ROLE " +
            "FROM LHC_USERS WHERE USER_ID = ?";
    private static final String SQL_FIND_BY_EMAIL = "SELECT USER_ID, NAME, EMAIL, PASSWORD, ROLE " +
            "FROM LHC_USERS WHERE EMAIL = ?";


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer create(String name, String email, String password, String role) throws EtAuthException {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, hashedPassword);
                ps.setString(4, role);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("USER_ID");
        } catch (Exception e) {
            throw new EtAuthException("Invalid details, Failed to create account");
        }
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws EtAuthException {
        try {
            User user = jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL, new Object[]{email} , userRowMapper);
            if (!BCrypt.checkpw(password, user.getPassword())) {
                throw new EtAuthException("Invalid email/password");
            }
            return user;
        }catch (Exception e){
            throw new EtAuthException("Invalid email/password. Failed to find user with exception: " + e);
        }
    }

    @Override
    public Integer getCountByEmail(String email) {
        return jdbcTemplate.queryForObject(SQL_COUNT_BY_EMAIL, new Object[]{email}, Integer.class);
    }

    @Override
    public User findById(Integer userId) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{userId}, userRowMapper);
    }

    private RowMapper<User> userRowMapper = ((rs, rowNum) -> {
        return new User(rs.getInt("USER_ID"),
                rs.getString("NAME"),
                rs.getString("EMAIL"),
                rs.getString("PASSWORD"),
                rs.getString("ROLE")
        );
    });
}
