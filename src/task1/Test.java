package task1;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Timer());
        thread1.start();
        Thread thread2=new Thread(new Message());
        thread2.start();
        thread2.join();
    }
}