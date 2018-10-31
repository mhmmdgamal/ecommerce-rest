package com.domain.ecommerce.customer.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class UserJdbcTemplateImpl {

	private final static String INSERT_SQL = "INSERT INTO user(name,password,email,fullName,groupId,activated,date,avatar) "
			+ "values(?,?,?,?,?,?,?,?,?)";

	@Autowired
	private static JdbcTemplate jdbcTemplate;

	public static long addAndGetId(final User user) {

		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getName());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getEmail());
				ps.setString(4, user.getFullName());
				ps.setInt(5, user.getGroupId());
				ps.setInt(6, user.getActivated());
				ps.setDate(7, user.getDate());
				ps.setString(8, user.getAvatar());
				return ps;
			}
		};
		jdbcTemplate.update(psc, keyHolder);

		long id = keyHolder.getKey().longValue();
		return id;
	}

}
