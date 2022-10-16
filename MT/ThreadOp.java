package MT;
class UserThread extends Thread{
    public void run(){
        System.out.println("This is user defined thread.");
    }
}

public class ThreadOp {
    public static void main(String[] args) {
        System.out.println("Program Started,....");
        int x=10+26;
        System.out.println("sum is "+x);
        Thread t=Thread.currentThread();
        String tname=t.getName();
        System.out.println("Current running thread is "+tname);
        // set name
        t.setName("Sourav");
        System.out.println(t.getName());
        System.out.println("Program ended..");
        UserThread t1=new UserThread();
        t1.start();
    }
}
