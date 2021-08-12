package model.dao;

import db.DB;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	public static SellerDao creatteSellerDao() {
		
		return new SellerDaoJDBC(DB.getConnection());
	}
	public static DepartmentDao creatteDepartmentDao() {
		
		return new DepartmentDaoJDBC(DB.getConnection());
	}

}
