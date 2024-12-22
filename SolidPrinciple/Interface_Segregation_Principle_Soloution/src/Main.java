
interface DishWasher {
    void washDishes();
}

interface DishServer {
    void serveDishes();
}


interface DishCooker {
    void cookDishes();
}


class DishWasherImpl implements DishWasher {
    @Override
    public void washDishes() {
        System.out.println("Hey, I am washing the dishes...");
    }
}


class DishServerImpl implements DishServer {
    @Override
    public void serveDishes() {
        System.out.println("Hey, I am serving the dishes...");
    }
}


class DishCookerImpl implements DishCooker {
    @Override
    public void cookDishes() {
        System.out.println("Hey, I am cooking the dishes...");
    }
}


public class Main {
    public static void main(String[] args) {
        DishWasher dishWasher = new DishWasherImpl();
        DishServer dishServer = new DishServerImpl();
        DishCooker dishCooker = new DishCookerImpl();

        dishWasher.washDishes();
        System.out.println();

        dishServer.serveDishes();
        System.out.println();

        dishCooker.cookDishes();
        System.out.println();
    }
}
