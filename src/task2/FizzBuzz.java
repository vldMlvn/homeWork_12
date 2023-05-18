package task2;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class FizzBuzz {
    private int n;
    private BlockingQueue<String> number;
    private BlockingQueue<String> fizz;
    private BlockingQueue<String> buzz;
    private BlockingQueue<String> fizzBuzz;
    public FizzBuzz(int n) {
        this.n = n;
        this.number = new LinkedBlockingQueue<>();
        this.fizz = new LinkedBlockingQueue<>();
        this.buzz = new LinkedBlockingQueue<>();
        this.fizzBuzz = new LinkedBlockingQueue<>();
    }
    public void fizz() {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                fizz.add("fizz");
            } else {
                fizz.add(Integer.toString(i));
            }
        }
    }
    public void buzz() {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0) {
                buzz.add("buzz");
            } else {
                buzz.add(Integer.toString(i));
            }
        }
    }
    public void fizzBuzz() {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzBuzz.add("fizzbuzz");
            } else {
                fizzBuzz.add(Integer.toString(i));
            }
        }
    }
    public void number() {
        for (int i = 1; i <= n; i++) {
            String fizz = this.fizz.poll();
            String buzz = this.buzz.poll();
            String fizzBuzz = this.fizzBuzz.poll();
            String output = "";
            if ("fizz".equals(fizz)) {
                output += fizz;
            }
            if ("buzz".equals(buzz)) {
                output += buzz;
            }
            if ("fizzbuzz".equals(fizzBuzz)) {
                output += fizzBuzz;
            }

            if (output.isEmpty()) {
                output = Integer.toString(i);
            }
            number.add(output);
        }
    }
    public void runThreads() throws InterruptedException {
        Thread fizzThread = new Thread(() -> fizz());
        Thread buzzThread = new Thread(() -> buzz());
        Thread fizzBuzzThread = new Thread(() -> fizzBuzz());
        Thread numberThread = new Thread(() -> number());

        fizzThread.start();
        buzzThread.start();
        fizzBuzzThread.start();
        numberThread.start();

        fizzThread.join();
        buzzThread.join();
        fizzBuzzThread.join();
        numberThread.join();

        while (!number.isEmpty()) {
            System.out.print(number.poll() + ", ");
        }
        System.out.println();
    }
}