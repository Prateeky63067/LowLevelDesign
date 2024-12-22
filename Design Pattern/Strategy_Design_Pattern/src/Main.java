//he Strategy Design Pattern is a behavioral design pattern that allows you
// to define a family of algorithms, encapsulate each one, and make them
// interchangeable. The Strategy Pattern lets the algorithm vary independently
// from the clients that use it.

//It is particularly useful when you have multiple algorithms (strategies) for a
// specific task and want to switch between them dynamically at runtime.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface paymentStrategy{
    void pay(int amount);
}

class creditCardPayment implements paymentStrategy{
     private String cardNumber;
     public creditCardPayment(String cardNumber)
     {
         this.cardNumber=cardNumber;
     }
    @Override
    public void pay(int amount) {
        System.out.println("payment of " +amount+ " is done using "+this.cardNumber+" card number ");
    }
}

class upiPayment implements paymentStrategy{
    private String upiNumber;
    public upiPayment(String upiNumber)
    {
        this.upiNumber=upiNumber;
    }
    @Override
    public void pay(int amount) {
        System.out.println(amount);
        System.out.println("payment of " +amount+ " is done using "+this.upiNumber+" upi number ");
    }
}

class ShoppingCart {
    private paymentStrategy paymentStrategy;

    public void setPaymentStrategy(paymentStrategy paymentStrategy)
    {
        this.paymentStrategy=paymentStrategy;
    }
    public void checkout(int amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set.");
        }
        paymentStrategy.pay(amount);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        ShoppingCart cart = new ShoppingCart();

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            System.out.println("Press 1 for pay using card");
            System.out.println("Press 2 for pay using upi");
            System.out.println("Press 3 exit");
            int c=Integer.parseInt(br.readLine());
            if(c==1)
            {
                System.out.println("Enter card number");
                String cardNumber=br.readLine();
                cart.setPaymentStrategy(new creditCardPayment(cardNumber));
                System.out.println("Enter Amount to pay");
                int amount=Integer.parseInt(br.readLine());
                cart.checkout(amount);
            }else if(c==2)
            {
                System.out.println("Enter Upi number");
                String upiNumber=br.readLine();
                cart.setPaymentStrategy(new upiPayment(upiNumber));
                System.out.println("Enter Amount to pay");
                int amount=Integer.parseInt(br.readLine());
                cart.checkout(amount);
            }else if(c==3)
            {
                System.out.println("Thank You for using App");
                break;
            }else{
                System.out.println("Wrong Input");
            }
        }
    }
}