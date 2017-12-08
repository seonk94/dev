package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import kr.ac.hansung.model.Class;
import kr.ac.hansung.model.SI;
import kr.ac.hansung.model.ysc;

@Repository
public class ClassDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int getRowCount() {
		String sqlStatement = "select count(*) from class";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}
	
	public List<ysc> getYS() {
		String sqlStatement = "select distinct year, semester from class";
		String sql = "select sum(credit) from class where year=? and semester=?";
		return jdbcTemplate.query(sqlStatement, 
				new RowMapper<ysc>() {
					@Override
					public ysc mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						ysc YSC = new ysc();
						
						YSC.setYear(rs.getInt("year"));
						int year = YSC.getYear();
						YSC.setSemester(rs.getInt("semester"));
						int semester = YSC.getSemester();
						
						jdbcTemplate.queryForObject(sql, new Object[] {year, semester}, new RowMapper<ysc>() {

							@Override
							public ysc mapRow(ResultSet rs, int arg1) throws SQLException {
								YSC.setCredit(rs.getInt("sum(credit)"));
								return null;
							}
							
						});
						
						return YSC;
					} 
				}
		);
	}
	
	
	
	
	
	public Class getClass(String code) {
		String sqlStatement = "select * from class where code=?";
		
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] {code},
				new RowMapper<Class>() {
					@Override
					public Class mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						/*
						Offer offer = new Offer();
						offer.setId(rs.getInt("id"));
						offer.setName(rs.getString("name"));
						offer.setEmail(rs.getString("email"));
						offer.setText(rs.getString("text"));
						return offer;
						*/
						
						Class Tclass = new Class();
						Tclass.setYear(rs.getInt("year"));
						Tclass.setSemester(rs.getInt("semester"));
						Tclass.setCode(rs.getString("code"));
						Tclass.setTitle(rs.getString("title"));
						Tclass.setDivision(rs.getString("division"));
						Tclass.setCredit(rs.getInt("credit"));
						
						return Tclass;
					} 
				}
		);
	}
	
	public List<Class> getClasses_year_semester(int year, int semester){
		String sqlStatement = "select * from class where year=? and semester=?";
		
		return jdbcTemplate.query(sqlStatement, new Object[] {year, semester}, new RowMapper<Class>() {

			@Override
			public Class mapRow(ResultSet rs, int rowNum) throws SQLException {
				Class Tclass = new Class();
				
				Tclass.setYear(year);
				Tclass.setSemester(semester);
				Tclass.setCode(rs.getString("code"));
				Tclass.setTitle(rs.getString("title"));
				Tclass.setDivision(rs.getString("division"));
				Tclass.setCredit(rs.getInt("credit"));
				
				return Tclass;
			}
			
		});
	}
	
	public List<SI> getSI(){
		String sqlStatement = "select distinct division from class";
		String sql = "select sum(credit) from class where division=?";
		
		return jdbcTemplate.query(sqlStatement, new RowMapper<SI>() {

			@Override
			public SI mapRow(ResultSet rs, int arg1) throws SQLException {
				SI si = new SI();
				
				si.setDivision(rs.getString("division"));
				String dv = si.getDivision();
				
				jdbcTemplate.queryForObject(sql,  new Object[] {dv}, new RowMapper<SI>() {

					@Override
					public SI mapRow(ResultSet rs, int arg1) throws SQLException {
						si.setCredit(rs.getInt("sum(credit)"));
						return null;
					}
				});
				return si;
			}
			
		});
	}
	
	public int getCountDivision() {
		String sqlStatement = "select count(distinct division) from class";
		
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}
	
	public List<String> getDivision_s(){
		String sqlStatement = "select distinct division from class";
		
		return jdbcTemplate.query(sqlStatement, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int arg1) throws SQLException {
				String d = rs.getString("division");
				return d;
			}
			
		});
	}
	
	public int getDivision(String division){
		String sqlStatement = "select sum(credit) from class where division=?";
		
		return jdbcTemplate.queryForObject(sqlStatement,  new Object[] {division}, Integer.class);
	}
	
	public List<Class> getClasses() {
		String sqlStatement = "select * from class";
		
		return jdbcTemplate.query(sqlStatement, 
				new RowMapper<Class>() {
					@Override
					public Class mapRow(ResultSet rs, int rowNum) throws SQLException {
						/*
						Offer offer = new Offer();
						
						offer.setId(rs.getInt("id"));
						offer.setName(rs.getString("name"));
						offer.setEmail(rs.getString("email"));
						offer.setText(rs.getString("text"));
						
						return offer;
						*/
						Class Tclass = new Class();
						Tclass.setYear(rs.getInt("year"));
						Tclass.setSemester(rs.getInt("semester"));
						Tclass.setCode(rs.getString("code"));
						Tclass.setTitle(rs.getString("title"));
						Tclass.setDivision(rs.getString("division"));
						Tclass.setCredit(rs.getInt("credit"));
						
						return Tclass;
					} 
				}
		);
	}
	
	public boolean insert(Class tclass) {
		/*
		String name = offer.getName();
		String email = offer.getEmail();
		String text = offer.getText();
		
		String sqlStatement = "insert into offers (name, email, text) values (?, ?, ?)";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {name, email, text} ) == 1);
		*/
		int year = tclass.getYear();
		int semester = tclass.getSemester();
		String code = tclass.getCode();
		String title = tclass.getTitle();
		String division = tclass.getDivision();
		int credit = tclass.getCredit();
		
		String sqlStatement = "insert into class (year, semester, code, title, division, credit) values (?, ?, ?, ?, ?, ?)";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, code, title, division, credit} ) == 1);
	}
	
	public boolean update(Class tclass) {
		/*
		int id = offer.getId();
		String name = offer.getName();
		String email = offer.getEmail();
		String text = offer.getText();
		
		String sqlStatement = "update offers set name=?, email=?, text=? where id=?";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {name, email, text, id} ) == 1);
		*/
		int year = tclass.getYear();
		int semester = tclass.getSemester();
		String code = tclass.getCode();
		String title = tclass.getTitle();
		String division = tclass.getDivision();
		int credit = tclass.getCredit();
		
		String sqlStatement = "update class set year=?, semester=?, code=?, title=?, division=?, credit=?";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, code, title, division, credit} ) == 1);
	}
	
	public boolean delete(String code) {
		String sqlStatement = "delete from class where code=?";
		
		return (jdbcTemplate.update(sqlStatement, new Object[] {code}) == 1);
	}
}
