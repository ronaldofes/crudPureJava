package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Departament;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{
	
	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,departament.Name as DepName "
					+ "FROM seller INNER JOIN departament "
					+"ON seller.DepartamentId = departament.Id "
					+"WHERE seller.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Departament dep = instantiateDepartament(rs);
				Seller obj = insntantiateSeller(rs,dep);
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException (e.getMessage());
		} finally {
			
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Seller insntantiateSeller(ResultSet rs, Departament dep) throws SQLException {
		Seller obj = new Seller ();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setBirthDate (rs.getDate("BirthDate"));
		obj.setDepartament(dep);	
		return obj;
	}

	private Departament instantiateDepartament(ResultSet rs) throws SQLException  {
		Departament dep = new Departament();
		dep.setId(rs.getInt("DepartamentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> findByDepartament(Departament departament) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,departament.Name as DepName "
					+"FROM seller INNER JOIN departament "
					+"ON seller.DepartamentId = departament.Id "
					+"WHERE DepartamentId = ? "
					+"ORDER BY Name");
			
			st.setInt(1, departament.getId());
			rs = st.executeQuery();
			
			List<Seller> list = new ArrayList<>();
			Map<Integer,Departament> map = new HashMap<>();
			
			while (rs.next()) {
				Departament dep = map.get(rs.getInt("DepartamentId"));
				
				if (dep ==null) {
				dep = instantiateDepartament(rs);
				map.put(rs.getInt("DepartamentId"), dep);
				}
				Seller obj = insntantiateSeller(rs,dep);
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException (e.getMessage());
		} finally {
			
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
