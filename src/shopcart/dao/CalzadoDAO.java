package shopcart.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;

import java.sql.Connection;

public class CalzadoDAO {


	 public List selectData(String filter) throws Exception {
		 List calzadosList = new ArrayList();
		 	String filterdata = "'%"+filter+"%'";
	        System.out.println("jdbc connection");
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost/prachibernate", "root", "");
	        
	        try {
	 
	            try {
	             //   Statement st = con.createStatement();
	                PreparedStatement  st = con.prepareStatement("select name from calzado_code where name like ? ");
	                st.setString(1, "%" +filter+ "%");
	               ResultSet rs = st.executeQuery();
	               
	               while(rs.next()){
	            	   calzadosList.add(rs.getString(1));
	               }
	               st.close();
	            } catch (SQLException ex) {
	                System.out.println("SQL statement is not executed!" + ex);
	            }
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return calzadosList;
	    }
	 
	 public void insertData(String firstName, String lastName, String userName,
	            String password, String email, String phone) throws Exception {
	        System.out.println("jdbc connection");
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost/strutsdb", "root", "mukesh");
	 
	        try {
	 
	            try {
	                Statement st = con.createStatement();
	                int value = st
	                        .executeUpdate("INSERT INTO USER_DETAILS(FIRST_NAME,LAST_NAME,USER_NAME,PASSWORD,EMAIL,PHONE) "
	                                + "VALUES('"
	                                + firstName
	                                + "','"
	                                + lastName
	                                + "','"
	                                + userName
	                                + "','"
	                                + password
	                                + "','"
	                                + email + "','" + phone + "')");
	                System.out.println("1 row affected" + value);
	            } catch (SQLException ex) {
	                System.out.println("SQL statement is not executed!" + ex);
	            }
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
