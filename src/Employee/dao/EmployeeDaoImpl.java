package Employee.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Employee.DataSource.DBConnection;
import Employee.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	public int createRecord(List<Employee> lst) {
		int i=0;
		Connection con=DBConnection.getConnection();

		try {
			PreparedStatement psatat=con.prepareStatement("insert into employeedb values(?,?,?)");
			Employee eobj=lst.get(0);
			psatat.setInt(1, eobj.getEmpId());
			psatat.setString(2, eobj.getEmpName());
			psatat.setDouble(3, eobj.getEmpSal());
			i=psatat.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	public int updateRecord(List<Employee> lst) {
		int i=0;
		Connection con=DBConnection.getConnection();

		try {
			PreparedStatement psatat=con.prepareStatement("update employeedb set empSal=? where empId=?");
			Employee etemp=lst.get(0);
			psatat.setDouble(1, etemp.getEmpSal());
			psatat.setInt(2, etemp.getEmpId());
			i=psatat.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public int deleteRecord(int empId) {
		int i=0;
		Connection con=DBConnection.getConnection();
		try {
			PreparedStatement pstate=con.prepareStatement("delete from employeedb where empId=?");
			pstate.setInt(1, empId);
			i=pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public List<Employee> searchRecord(int empId) {
		int i=0;
		Connection con=DBConnection.getConnection();
		List<Employee> lst=null;
		try {
			PreparedStatement pstate=con.prepareStatement("select * from employeedb where empId=?");
			pstate.setInt(1, empId);
			ResultSet rs=pstate.executeQuery();
			
			if(rs.next()) {
				lst=new ArrayList<Employee>();
				empId=rs.getInt(1);
				String empName=rs.getString(2);
				double empSal=rs.getDouble(3);
				Employee etemp=new Employee(empId, empName, empSal);
				lst.add(etemp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}

	public List<Employee> displayAll() {
		return null;
	}

}
