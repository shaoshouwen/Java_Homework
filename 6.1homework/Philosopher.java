import java.util.Random;

// 运行一分钟之后，哲学家线程退出
// 统计哲学家一共吃了多少次饭，多少次吃饭成功，一共进行了多少次思考
public class Philosopher extends AbstractPhilosopher {

  private Chopsticks[] chopsticks;
  private int code;
  private int eatTimes;
  private int thinkTimes;
  private int eatSuccessTimes;

  public Philosopher(int code, Chopsticks[] chopsticks) {
    this.code = code;
    this.setName("哲学家" + code + "");
    this.chopsticks = chopsticks;
    setLeft(chopsticks[code - 1]);
    setRight(chopsticks[code % 5]);
  }

  public boolean eat() {
    eatTimes++;
    if (super.eat()) {
      eatSuccessTimes++;
      return true;
    } else {
      return false;
    }
  }

  public void thinking() {
    thinkTimes++;
    super.thinking();
  }

  @Override
  public void run() {
    Random random = new Random();

    while (!interrupted()) {
      if (random.nextBoolean()) {
        eat();
      } else {
        thinking();
      }
    }

  }

  public void results() {
    System.out.println(
        getName() + ":一共吃饭" + eatTimes + "次,成功" + eatSuccessTimes + "次,思考" + thinkTimes + "次");
  }
}


