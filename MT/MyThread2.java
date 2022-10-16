package MT;

//Thread using Thread Class
public class MyThread2 extends Thread{

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 10; i>= 0; i--) {
            System.out.print(i + " ");
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        Thread thr = new Thread(t1);
        thr.start();

        MyThread2 t2=new MyThread2();
        t2.start();
    }

}
