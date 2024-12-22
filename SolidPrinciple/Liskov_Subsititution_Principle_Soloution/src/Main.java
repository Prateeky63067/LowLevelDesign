
//This improved code works for the Liskov Substitution Principle (LSP)
// because each subclass (LG_Smart_TV and Normal_Dabba_TV) can be used
// in place of its parent class (SmartTV or BasicTV) without causing
// any unexpected behavior or errors.
class BasicTV {
    void display() {
        System.out.println("Displaying content on TV.");
    }
}


class SmartTV extends BasicTV {
    void wifi() {
        System.out.println("Connecting to WiFi.");
    }

    void ottPlatform() {
        System.out.println("Accessing OTT platforms.");
    }
}


class LG_Smart_TV extends SmartTV {
    @Override
    void display() {
        System.out.println("LG Smart TV display with 4K resolution.");
    }
}


class Normal_Dabba_TV extends BasicTV {
    @Override
    void display() {
        System.out.println("Normal Dabba TV display with standard resolution.");
    }
}


public class Main {
    public static void main(String[] args) {

        SmartTV lgTV = new LG_Smart_TV();
        BasicTV dabbaTV = new Normal_Dabba_TV();


        lgTV.display();
        dabbaTV.display();


        lgTV.wifi();
        lgTV.ottPlatform();
    }
}
