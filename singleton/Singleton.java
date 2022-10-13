package singleton;

public class Singleton {
    private Singleton(){

    } 
    private static Singleton instance;

    static public  Singleton getinstance(){
        //check if only 1 obj is created 
        if(instance==null){
            instance=new Singleton();
        }
        return instance;
    }
}
