package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.FunctionTest;
import com.revature.util.ConnFactory;

public class FTDaoImpl {
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public FunctionTest testFun() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM dup3(42, 'roll tide')";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		FunctionTest ft = null;
		while (rs.next()) {
			ft = new FunctionTest(rs.getString(1), rs.getInt(2));
		}
		return ft;
	}	
}