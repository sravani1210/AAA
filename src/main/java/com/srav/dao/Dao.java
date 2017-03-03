package com.srav.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.srav.pojo.Pojo;

public class Dao {
JdbcTemplate jdbcTemplate;

public Dao(JdbcTemplate jdbcTemplate) {
	super();
	this.jdbcTemplate = jdbcTemplate;
}

public JdbcTemplate getJdbcTemplate() {
	return jdbcTemplate;
}

public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}
public Dao() {
	// TODO Auto-generated constructor stub
}
public int save(Pojo p) {
	String sql="insert into Pojo (age,name) values("+p.getAge()+",'"+p.getName()+"')";
	return jdbcTemplate.update(sql);
}
public List<Pojo> getDetails() {
	String sql="select * from Pojo";
	return jdbcTemplate.query(sql, new RowMapper<Pojo>() {

		public Pojo mapRow(ResultSet rs, int rowNum) throws SQLException {
			Pojo p=new Pojo();
			p.setAge(rs.getInt(1));
			p.setName(rs.getString(2));
			return p;
		}
	});
}
public void delete(int id) {
	String sql="delete from Pojo where age="+id+"";
	jdbcTemplate.update(sql);
}
public Pojo getById(int id) {
	String sql="select * from Pojo where age=?";
	return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Pojo>(Pojo.class));
}

public void update(Pojo p) {
	String sql="update Pojo set name='"+p.getName()+"' where age="+p.getAge()+"";
	jdbcTemplate.update(sql);
	System.out.println("updated");
}

public int search(int id) {
	String sql="select * from Pojo where age="+id+"";
	return jdbcTemplate.update(sql);
	
}

}
