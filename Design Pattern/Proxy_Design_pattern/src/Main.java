


//The Proxy Design Pattern is a structural design pattern that provides a surrogate or placeholder object to control access
// to another object. It is commonly used to control access, manage resources, or add additional functionality without
// changing the actual object.


 class EmployeeDo {
    private int id;
    private String name;
    private String department;
    private double salary;

    public EmployeeDo(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeDo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

 interface EmployeeDao {
    void create(String client, EmployeeDo obj) throws Exception;
    void delete(String client, int employeeId) throws Exception;
    EmployeeDo get(String client, int employeeId) throws Exception;
}


 class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void create(String client, EmployeeDo obj) {
        System.out.println("Created a new row in Employee Table: " + obj);
    }

    @Override
    public void delete(String client, int employeeId) {
        System.out.println("Deleted row with employeeId: " + employeeId);
    }

    @Override
    public EmployeeDo get(String client, int employeeId) {
        System.out.println("Fetching data from the DB for employeeId: " + employeeId);
        return new EmployeeDo(employeeId, "John Doe", "Engineering", 75000.00);
    }
}


 class EmployeeDaoProxy implements EmployeeDao {
    private EmployeeDao employeeDaoObj;

    public EmployeeDaoProxy() {
        this.employeeDaoObj = new EmployeeDaoImpl();
    }

    @Override
    public void create(String client, EmployeeDo obj) throws Exception {
        if (client.equals("Admin")) {
            employeeDaoObj.create(client, obj);
            return;
        }
        throw new Exception("Access Denied");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        if (client.equals("Admin")) {
            employeeDaoObj.delete(client, employeeId);
            return;
        }
        throw new Exception("Access Denied");
    }

    @Override
    public EmployeeDo get(String client, int employeeId) throws Exception {
        if (client.equals("Admin") || client.equals("User")) {
            return employeeDaoObj.get(client, employeeId);
        }
        throw new Exception("Access Denied");
    }
}


public class Main {
    public static void main(String[] args) {
        try {
            EmployeeDao empTableObj = new EmployeeDaoProxy();
            EmployeeDo newEmployee = new EmployeeDo(1, "Alice", "HR", 50000.00);
            empTableObj.create("Admin", newEmployee);
            System.out.println("Operation Successful");

            EmployeeDo fetchedEmployee = empTableObj.get("User", 1);
            System.out.println("Fetched Employee: " + fetchedEmployee);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
