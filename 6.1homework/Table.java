import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Table {

  public static void main(String[] args) throws InterruptedException {
    Chopsticks[] chopsticks = new Chopsticks[5];
    chopsticks[0] = new Chopsticks(1);
    chopsticks[1] = new Chopsticks(2);
    chopsticks[2] = new Chopsticks(3);
    chopsticks[3] = new Chopsticks(4);
    chopsticks[4] = new Chopsticks(5);

    Philosopher[] philosophers = new Philosopher[5];
    ExecutorService executorService = Executors.newFixedThreadPool(5);

    philosophers[0] = new Philosopher(1, chopsticks);
    philosophers[1] = new Philosopher(2, chopsticks);
    philosophers[2] = new Philosopher(3, chopsticks);
    philosophers[3] = new Philosopher(4, chopsticks);
    philosophers[4] = new Philosopher(5, chopsticks);

    for (Philosopher philosopher : philosophers) {
      executorService.submit(philosopher);
    }
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    executorService.shutdownNow();
    System.out.println("线程关闭");
    executorService.awaitTermination(1000, TimeUnit.SECONDS);
    System.out.println(Arrays.toString(philosophers));
    for (Philosopher philosopher : philosophers
    ) {
      philosopher.results();
    }
    Philosopher philosopher = new Philosopher(1, chopsticks);
    ExecutorService executorService1 = Executors.newSingleThreadExecutor();
    executorService1.submit(philosopher);
  }
}
