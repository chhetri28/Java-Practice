package MT;

//Thread using Runnable
public class MyThread implements Runnable{

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for(int i=1;i<=10;i++){
            System.out.print(i+" ");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        MyThread t1=new MyThread(); 
        Thread thr=new Thread(t1);
        thr.start();
    }
    
}
