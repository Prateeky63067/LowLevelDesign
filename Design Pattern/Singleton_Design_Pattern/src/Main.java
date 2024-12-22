//The Singleton method or Singleton Design pattern is one of the simplest design patterns.
// It ensures a class only has one instance, and provides a global point of access to it.
//Early Initialization
class EarlySinglaton{
    private static EarlySinglaton obj=new EarlySinglaton();

    private EarlySinglaton(){}

    //    static because it can be called without object creation,
    //    i mean with className itself
    public static EarlySinglaton getInstance(){
        return obj;
    }

}

//Lazy Initialization

class LazySinglaton{
    private static LazySinglaton obj;

    LazySinglaton(){};

    public static LazySinglaton getInstance()
    {
        if(obj==null)
        {
            obj=new LazySinglaton();
        }
        return obj;
    }
}

//Thread-Safe Singleton (Synchronized)

class ThreadSafeSinglaton{
    private static ThreadSafeSinglaton obj;

    private ThreadSafeSinglaton(){};

    public static synchronized ThreadSafeSinglaton getInstance(){
        if(obj==null)
        {
            obj=new ThreadSafeSinglaton();
        }
        return obj;
    }
}

//Improves performance by reducing the overhead of synchronization.

class ImprovesSingleton {
    private static  ImprovesSingleton obj;

    private ImprovesSingleton() {}

    public static ImprovesSingleton getInstance() {
        if (obj == null) {
            synchronized (ImprovesSingleton.class) {
                if (obj == null) {
                    obj = new ImprovesSingleton();
                }
            }
        }
        return obj;
    }
}


public class Main {
    public static void main(String[] args) {
        //Early Initialization
        EarlySinglaton Earlyinstance1=  EarlySinglaton.getInstance();
        System.out.println("hascode of first instance "+Earlyinstance1.hashCode());
        EarlySinglaton Earlyinstance2=  EarlySinglaton.getInstance();
        System.out.println("hascode of Second instance "+Earlyinstance2.hashCode());
        System.out.println();

        //Lazy Initialization

        LazySinglaton Lazyinstance1=LazySinglaton.getInstance();
        System.out.println("hascode of first instance "+Lazyinstance1.hashCode());
        LazySinglaton Lazyinstance2=LazySinglaton.getInstance();
        System.out.println("hascode of first instance "+Lazyinstance2.hashCode());
        System.out.println();
        //Thread-Safe Singleton (Synchronized)

        ThreadSafeSinglaton ThreadSafeinstance1=ThreadSafeSinglaton.getInstance();
        System.out.println("hascode of first instance "+ThreadSafeinstance1.hashCode());
        ThreadSafeSinglaton ThreadSafeinstance2=ThreadSafeSinglaton.getInstance();
        System.out.println("hascode of first instance "+ThreadSafeinstance2.hashCode());
        System.out.println();
        //Improves performance by reducing the overhead of synchronization.

        ImprovesSingleton Improveinstance1=ImprovesSingleton.getInstance();
        System.out.println("hascode of first instance "+Improveinstance1.hashCode());
        ImprovesSingleton Improveinstance2=ImprovesSingleton.getInstance();
        System.out.println("hascode of first instance "+Improveinstance2.hashCode());

    }
}