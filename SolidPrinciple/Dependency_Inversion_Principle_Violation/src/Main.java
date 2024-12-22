
class AddDesigner {
    public void add() {
        System.out.println("Designer added.");
    }
}

class AddDeveloper {
    public void add() {
        System.out.println("Developer added.");
    }
}


class Manager {
    private AddDesigner addDesigner;
    private AddDeveloper addDeveloper;

    public Manager() {
        // Directly depending on concrete classes
        this.addDesigner = new AddDesigner();
        this.addDeveloper = new AddDeveloper();
    }

    public void manage() {
        addDesigner.add();
        addDeveloper.add();
    }
}


public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.manage();
    }
}
