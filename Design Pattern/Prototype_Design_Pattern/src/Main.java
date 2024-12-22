import java.time.Duration;

class NetworkConnection implements Cloneable{
 private String ip;
 private String importantData;

     public void setIp(String ip)
     {
         this.ip=ip;
     }
    public void setImportantData(String importantData)
    {
        this.importantData=importantData;
    }

    public String getIp()
    {
        return ip;
    }
    public String getImportantData(){
         return importantData;
    }

    public void loadImportantData() throws InterruptedException {
        this.importantData="very very important data";
        Thread.sleep(Duration.ofMillis(2000));
    }

    @Override
    public String toString() {
        return this.ip+" : "+ this.importantData;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Object created by prototype pattern");
        NetworkConnection networkConnection=new NetworkConnection();
        networkConnection.setIp("123.23.34.222");
        networkConnection.loadImportantData();
        System.out.println(networkConnection);

        //clone a object
        try {

        NetworkConnection networkConnection1=(NetworkConnection) networkConnection.clone();
            System.out.println(networkConnection1);
        } catch (CloneNotSupportedException e) {
           e.printStackTrace();
        }
    }
}