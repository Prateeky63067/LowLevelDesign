//The Builder Design Pattern is a creational design pattern in Java that is used
// to construct complex objects step-by-step. It allows you to create an object
// without having to use a telescoping constructor, which can be hard to manage
// and read when many optional parameters are involved.

//Key Idea
//1. It is particularly useful when an object has numerous parameters (both mandatory and optional).
//2. Instead of creating multiple overloaded constructors, a builder class is used to incrementally build the object.
class Car{
    private final String model;
    private final String engin;
    private final String color;
    private final int airbag;


    public Car(CarBuilder builder)
    {
        this.model=builder.model;
        this.engin=builder.engin;
        this.color=builder.color;
        this.airbag=builder.airbag;
    }


    public String getModel() {
        return model;
    }
    public String getEngin(){
        return engin;
    }
    public String getColor(){
        return color;
    }
    public int getAirbag(){
        return airbag;
    }

    public String toString() {
        return "Car [Model=" + model + ", Engine=" + engin +
                ", Color=" + color + ", Airbags=" + airbag + "]";
    }

//    builder class
    public static class CarBuilder{

    private final String model;
    private final String engin;
    private  String color;
    private  int airbag;

    public CarBuilder(String model,String engin)
    {
        this.model=model;
        this.engin=engin;
    }

    public CarBuilder setColor(String color)
    {
        this.color=color;
        return this;
    }

    public CarBuilder setAirbag(int airbag)
    {
        this.airbag=airbag;
        return this;
    }

    public Car build() {
        return new Car(this);
    }

}


}

public class Main {
    public static void main(String[] args) {
        Car car=new Car.CarBuilder("Sedan","v8-Engine")
                .setColor("red")
                .setAirbag(2)
                .build();
        System.out.println(car.toString());

        Car car1=new Car.CarBuilder("Mahendra","v1-Engine")
                .build();
        System.out.println(car1.toString());
    }
}