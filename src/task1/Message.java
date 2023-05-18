package task1;

public class Message implements Runnable {
    @Override
    public void run() {
        int counter=0;
        while (true){
            if(counter%5==0 && counter!=0){
                System.out.println("Минуло 5 секунд");
            }
            counter++;
            try {
                Thread.sleep(1000);
                counter++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}