package com.example.oop.employeeController;

import com.example.oop.employeeDb.EmployeeDb;
import com.example.oop.model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Surya.N
 */
public class EmployeeDAOIm {
    Connection con;
	PreparedStatement ps;
	String sql;
	
	public void save(Employee employees) {
		
		 try {
		    con =  EmployeeDb.getConnection();
	            sql = "INSERT INTO employee(empname,salary,phone) VALUES (?,?,?)";
	            ps = con.prepareStatement(sql);
	            ps.setString(1, employees.getEmpname());
	            ps.setInt(2, employees.getSalary());
	            ps.setInt(3, employees.getPhone());
	            ps.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Saved!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error");
	        }

	}


	public void update(Employee employees) {
	   try 
             {  
             Connection con = EmployeeDb.getConnection();
             String sql = "UPDATE employee SET empname=?,salary=?,phone=? WHERE id=?";
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1, employees.getEmpname());
	     ps.setInt(2, employees.getSalary());
	     ps.setInt(3, employees.getPhone());
             ps.setInt(4, employees.getId());
             ps.executeUpdate();

        
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
		
		
	}

	
	public void delete(Employee employees) {
		 try {
	           
	            Connection con = EmployeeDb.getConnection();
	            String sql = "delete from employee  WHERE id=?";
	            PreparedStatement ps = con.prepareStatement(sql);  
	            ps.setInt(1, employees.getId());
	            ps.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Deleted!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error");
	        }
		
	}


	public Employee get(int id) {
		
		 Employee st = new Employee();
	        try {
	            Connection con = EmployeeDb.getConnection();
	            String sql = "SELECT * FROM employee WHERE id=?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	                
	                 st.setId(rs.getInt("id"));
	                st.setEmpname(rs.getString("empname"));
	                st.setSalary(rs.getInt("salary"));
	                st.setPhone(rs.getInt("phone"));

	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error");
	        }
	        return st;
	}

	
	public List<Employee> list() 
        {	
            List<Employee> list = new ArrayList<>();
        try
        {
            Connection con = EmployeeDb.getConnection();
            String sql = "SELECT * FROM employee ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
            	Employee st = new Employee();
                st.setId(rs.getInt("id"));
                st.setEmpname(rs.getString("empname"));
	        st.setSalary(rs.getInt("salary"));
	        st.setPhone(rs.getInt("phone"));
                list.add(st);
            } 
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
	}

}
