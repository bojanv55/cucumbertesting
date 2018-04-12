package me.vukas;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class MarketJdbcRepo implements MarketRepo {

	private NamedParameterJdbcTemplate jdbcTemplate;

	public MarketJdbcRepo(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public String getDataById(Integer id) {
		SqlParameterSource params = new MapSqlParameterSource()
				.addValue("id", id);
		return jdbcTemplate.queryForObject("SELECT content FROM articles WHERE id=:id", params, String.class);
	}
}
