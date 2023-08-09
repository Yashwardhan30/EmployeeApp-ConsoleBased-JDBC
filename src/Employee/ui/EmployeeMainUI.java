package Employee.ui;
import java.util.*;
import Employee.dao.EmployeeDaoImpl;
import Employee.entity.Employee;

public class EmployeeMainUI {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=null;
		int i=0;
		Employee etemp=null;
		EmployeeDaoImpl edao=new EmployeeDaoImpl();
		List<Employee> lst=new ArrayList<Employee>();

		do {
			System.out.println("1-Create\n2-Update\n3-Delete\n4-Search\n5-Display All\n\nEnter your choice...");
			int ch=sc.nextInt();

			switch (ch) {
			case 1:
				//create
				System.out.println("Enter Employee Id, Name, Salary");
				Employee eobj=new Employee(sc.nextInt(), sc.next(), sc.nextDouble());
				lst.add(eobj);
				i=edao.createRecord(lst);

				if(i>0) {
					System.out.println("Record Saved");
				}else {
					System.out.println("Record NOT Saved");
				}

				break;
				
			case 2:
				//update
				System.out.println("Enter Employee ID and new Salary to update Record");
				etemp=new Employee();
				etemp.setEmpId(sc.nextInt());
				etemp.setEmpSal(sc.nextDouble());
				lst.add(etemp);
				i=edao.updateRecord(lst);
				if(i>0) {
					System.out.println("Record Updated");
				}else {
					System.out.println("Record NOT Updated");
				}
				
				break;
				
			case 3:
				//delete
				System.out.println("Enter Employee ID to delete record");
				i=edao.deleteRecord(sc.nextInt());
				if(i>0) {
					System.out.println("Record Deleted");
				}else {
					System.out.println("Record NOT Deleted");
				}
				
				break;
				
			case 4:
				//search
				System.out.println("Enter Employee ID to search Record");
				lst=edao.searchRecord(sc.nextInt());
				if(lst!=null) {
					etemp=lst.get(0);
					System.out.println(etemp.getEmpId()+"\t"+etemp.getEmpName()+"\t"+etemp.getEmpSal());
				}else {
					System.out.println("Invalid Employee ID");
				}
				
				break;
				
			case 5:
				//display all
				
				break;

			}

			System.out.println("\nDo you want to continue press y/n");
			str=sc.next();		
		}while(str.equalsIgnoreCase("y"));
		System.out.println("----------TATA----------");	
	}
}
