// Abstraction for adding team members
interface TeamMember {
    void add();
}

// Low-level modules implementing the abstraction
class AddDesigner implements TeamMember {
    @Override
    public void add() {
        System.out.println("Designer added.");
    }
}

class AddDeveloper implements TeamMember {
    @Override
    public void add() {
        System.out.println("Developer added.");
    }
}

// Manager class depending on the abstraction
class Manager {
    private TeamMember teamMember;

    // Constructor Injection
    public Manager(TeamMember teamMember) {
        this.teamMember = teamMember;
    }

    public void manage() {
        teamMember.add();
    }
}

// Main class to demonstrate compliance with DIP
public class Main {
    public static void main(String[] args) {
        // Injecting specific implementations of TeamMember
        TeamMember designer = new AddDesigner();
        Manager managerWithDesigner = new Manager(designer);
        managerWithDesigner.manage();

        TeamMember developer = new AddDeveloper();
        Manager managerWithDeveloper = new Manager(developer);
        managerWithDeveloper.manage();
    }
}
