package task2;

public class FizzBuzzTests {
    public static void main(String[] args) throws InterruptedException {
        int n = 15;
        FizzBuzz fizzBuzz = new FizzBuzz(n);
        fizzBuzz.runThreads();
    }
}

