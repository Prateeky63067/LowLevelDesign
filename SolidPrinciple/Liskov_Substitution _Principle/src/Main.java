//the LSP states that in an object-oriented program,
// if we substitute a superclass object reference with an object of any of
// its subclasses, the program should not break.
// Parent class representing a Smart TV


class SmartTv{
    public void DisplayFeature(){
        System.out.println("Smart Tv Display Quality is good");
    }
    public void getOttPlateform(){
        System.out.println("Smart Tv provide all Ott Platform");
    }
    public void wifi(){
        System.out.println("Smart Tv run on wifi also");
    }
}

class Lg_Smart_TV extends SmartTv{
    public void DisplayFeature(){
        System.out.println("Lg_Smart_TV Display 4K Quality");
    }
}

class Dabba_TV extends SmartTv{
    public void DisplayFeature(){
        System.out.println("Dabba_TV Display Quality is Very Poor");
    }
    public void getOttPlateform(){
        throw new UnsupportedOperationException("Normal Dabba TV does not support OTT.");
    }
    public void wifi(){
     throw new UnsupportedOperationException("Normal Dabba TV Does not Support Wifi");
    }
}
class Main{
    public static void main(String[] args) {
      SmartTv smartTv=new SmartTv();
      smartTv.DisplayFeature();
      smartTv.wifi();
      smartTv.getOttPlateform();
        System.out.println();

//      if we replace the object of parents class to child class than
//        it also should works
//        it Works properly for lgSmartTv
        SmartTv lgSmartTv=new Lg_Smart_TV();
        lgSmartTv.DisplayFeature();
        lgSmartTv.wifi();
        lgSmartTv.getOttPlateform();
        System.out.println();
//        it does not Works  for lgSmartTv
        SmartTv dabbaTv=new Dabba_TV();
        dabbaTv.DisplayFeature();
        dabbaTv.wifi(); // it will throw error
        dabbaTv.getOttPlateform(); //  it will throw error

    }
}