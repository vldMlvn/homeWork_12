package task1;

public class Timer implements Runnable{
    @Override
    public void run() {
        int counter=0;
        while (true){
            System.out.println(counter);
            counter++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}