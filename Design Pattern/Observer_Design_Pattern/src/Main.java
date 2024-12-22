
//Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about
// any events that happen to the object they’re observing.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

interface Subject{
    void  subscribe(Observer ob);
    void  unSubscribe(Observer ob);
    void newVideoUploaded(String title);
}

interface Observer{
    void notified(String title);
}

class YoutubeChanel implements Subject{

    List<Observer>subcribers=new ArrayList<>();
    @Override
    public void subscribe(Observer ob) {
       this.subcribers.add(ob);
    }

    @Override
    public void unSubscribe(Observer ob) {
        this.subcribers.remove(ob);
    }

    @Override
    public void newVideoUploaded(String title) {
      for( Observer ob: this.subcribers)
      {
        ob.notified(title);
      }
    }
}

class Subscriber implements Observer{

    String name;
    Subscriber(String name)
    {
        this.name=name;
    }
    @Override
    public void notified(String title) {
        System.out.println("Hello "+this.name+" new Video uploaded-: "+ title);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {

        YoutubeChanel chanel=new YoutubeChanel();
        Subscriber aman=new Subscriber("Aman");
        Subscriber raman=new Subscriber("Raman");
        chanel.subscribe(aman);
        chanel.subscribe(raman);
        chanel.newVideoUploaded("Learn Design Pattern");
        chanel.newVideoUploaded("New Angluar Course");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while(true)
        {
            System.out.println("Press 1 to upload video");
            System.out.println("Press 2 add new subscriber");
            System.out.println("Press 3 exit");
            int c=Integer.parseInt(br.readLine());
            if(c==1)
            {
                System.out.println("Enter video title");
                String videoTitle=br.readLine();
                chanel.newVideoUploaded(videoTitle);
            }else if(c==2)
            {
                System.out.println("Enter name of Subscriber");
                String subsName=br.readLine();
                Subscriber subscriber3 = new Subscriber(subsName);
                 chanel.subscribe(subscriber3);
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