

interface Employee{
    int salary();
}

class AndriodDeveloper implements Employee{
    public int salary(){
        System.out.println("Salary of a Andriod Developer");
        return 4000000;
    }
}

class WebDeveloper implements Employee{

    public int salary()
    {
        System.out.println("Salary of a Web developer");
        return 5000000;
    }
}

class  EmployeeFactory{
    public static Employee getEmployee(String empType)
    {
        if(empType.trim().equalsIgnoreCase("ANDRIOD DEVELOPER"))
        {
            return new AndriodDeveloper();
        } else if (empType.trim().equalsIgnoreCase("WEB DEVELOPER")) {
            return new WebDeveloper();
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
      Employee employee1=EmployeeFactory.getEmployee("Andriod Developer");
      System.out.println(employee1.salary());
      Employee employee2=EmployeeFactory.getEmployee("Web Developer");
      System.out.println(employee2.salary());
    }
}