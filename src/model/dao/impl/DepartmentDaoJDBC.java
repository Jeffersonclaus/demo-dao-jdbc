package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection conn;

	public DepartmentDaoJDBC(Connection conn) {

		this.conn = conn;

	}

	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		;
		try {
			st = conn.prepareStatement(
			"INSERT INTO department (Name) "
	        + "VALUES " + "(?)",Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getName());
		 
			int arqu = st.executeUpdate();
			
			if(arqu < 0) {
			ResultSet rs= st.getGeneratedKeys();
			if(rs.next()) {
				
				int id =  rs.getInt(1);
				obj.setId(id);
				
			}
			
			DB.closeResultSet(rs);

			}
			
			
			
			
			

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} catch (NullPointerException e){
			
			System.out.println("erro: " + e.getMessage());
		}

		finally {
			DB.closeStatement(st);

		}


	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement(
			"update department set name=? WHERE Id = ?");
			st.setString(1, obj.getName());
		 	st.setInt(2, obj.getId());
			st.executeUpdate();
			
			System.out.println("alterado");
			
			
			

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} catch (NullPointerException e){
			
			throw new DbException(e.getMessage());
		}

		finally {
			DB.closeStatement(st);

		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("delete from department where id = ?");

			st.setInt(1, id);
			int result = st.executeUpdate();
			if (result > 0) {

				System.out.println("Deletado com sucesso!!!");
			} else {

				System.out.println("Não deletado!!!");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

		finally {
			DB.closeStatement(st);

		}

	}

	@Override
	public Department findByid(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
	//	Department dep1 = new Department(null , "erro id não econtrado");
		try {
			st = conn.prepareStatement("select * from department where id = ?");

			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Department dep = instantiateDep(rs);

				return dep;

			}
			
		
			
		 return   null ;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Department> list = new ArrayList<>();
		try {
			st = conn.prepareStatement("SELECT * FROM department");

			rs = st.executeQuery();
			while (rs.next()) {
				Department dep = instantiateDep(rs);

				list.add(dep);
			}

			return list;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

		finally {
			DB.closeStatement(st);
		}

	}

	// auxilar metodo
	private Department instantiateDep(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("Id"));
		dep.setName(rs.getString("Name"));
		return dep;
	}

}
