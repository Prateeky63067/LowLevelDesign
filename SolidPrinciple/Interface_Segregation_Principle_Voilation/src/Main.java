//Client should not Forced to depend upon interface that they do not use
//Goal of this Principal is to reduce the side effect of using Larger Interfaces
//by breaking application interface into smaller ones

interface RestourntEmployee{
    void WashDishes();
    void ServerDishes();
    void cookedDishes();
}

class DishWaser implements RestourntEmployee{
    public void WashDishes(){
        System.out.println("Hey i am Washing the Dishes...");
    }
    public void ServerDishes(){
        System.out.println("i am a DishWasher,ServerDishes is not my job ");
    }
    public void cookedDishes(){
        System.out.println("i am a DishWasher,cookedDishes is not my job ");
    }
}

class DishServer implements RestourntEmployee{
    public void WashDishes(){
        System.out.println("i am a DishServer,WashDishes is not my job");
    }
    public void ServerDishes(){
        System.out.println("Hey i am Serving the Dishes... ");
    }
    public void cookedDishes(){
        System.out.println("i am a DishServer,cookedDishes is not my job ");
    }
}
class DishCooker implements RestourntEmployee{
    public void WashDishes(){
        System.out.println("i am a DishCooker,WashDishes is not my job");
    }
    public void ServerDishes(){
        System.out.println("i am a DishCooker,ServerDishes is not my job");
    }
    public void cookedDishes(){
        System.out.println("Hey i am Cooking the Dishes... ");
    }
}

public class Main {
    public static void main(String[] args) {
        RestourntEmployee dishWaser=new DishWaser();
        RestourntEmployee dishServer=new DishServer();
        RestourntEmployee dishCooker=new DishCooker();

        dishWaser.WashDishes();
        dishWaser.ServerDishes();
        dishWaser.cookedDishes();
        System.out.println();

        dishServer.WashDishes();
        dishServer.ServerDishes();
        dishServer.cookedDishes();
        System.out.println();

        dishCooker.WashDishes();
        dishCooker.ServerDishes();
        dishCooker.cookedDishes();
        System.out.println();
    }
}