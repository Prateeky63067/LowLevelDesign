// Step 1: Define the Employee interface
interface Employee {
    int salary();
}

// Step 2: Implement Concrete Employee classes
class AndroidDeveloper implements Employee {
    public int salary() {
        System.out.println("Salary of an Android Developer");
        return 4000000;
    }
}

class WebDeveloper implements Employee {
    public int salary() {
        System.out.println("Salary of a Web Developer");
        return 5000000;
    }
}

// Step 3: Define Abstract Factory Interface
interface EmployeeFactory {
    Employee getEmployee();
}

// Step 4: Implement Concrete Factories for specific employee types
class AndroidDeveloperFactory implements EmployeeFactory {
    public Employee getEmployee() {
        return new AndroidDeveloper();
    }
}

class WebDeveloperFactory implements EmployeeFactory {
    public Employee getEmployee() {
        return new WebDeveloper();
    }
}

// Step 5: Create a Factory Producer to generate factories
class FactoryProducer {
    public static EmployeeFactory getFactory(String factoryType) {
        if (factoryType.trim().equalsIgnoreCase("ANDROID DEVELOPER")) {
            return new AndroidDeveloperFactory();
        } else if (factoryType.trim().equalsIgnoreCase("WEB DEVELOPER")) {
            return new WebDeveloperFactory();
        }
        return null;
    }
}

// Step 6: Main Class to test the Abstract Factory Design Pattern
public class Main {
    public static void main(String[] args) {
        // Use Factory Producer to get the factory
        EmployeeFactory androidFactory = FactoryProducer.getFactory("Android Developer");
        Employee androidDev = androidFactory.getEmployee();
        System.out.println(androidDev.salary());

        EmployeeFactory webFactory = FactoryProducer.getFactory("Web Developer");
        Employee webDev = webFactory.getEmployee();
        System.out.println(webDev.salary());
    }
}
