package Employee.dao;
import java.util.List;
import Employee.entity.Employee;

public interface EmployeeDao {

	public int createRecord(List<Employee> lst);
	public int updateRecord(List<Employee> lst);
	public int deleteRecord(int n);
	public List<Employee> searchRecord(int n);
	public List<Employee> displayAll();

}
