package files;

class counter extends Thread {

  int count = 0;

  public void run() {
    for (int i = 0; i < 10000; i++) {
      count++;
    }

    System.out.println(
      "THE COMPLETED THREAD IS " +
      Thread.currentThread().getName() +
      " THE THREAD PRIORITY IS " +
      Thread.currentThread().getPriority()
    );
  }
}

public class Priority {

  public static void main(String[] args) {
    counter c1 = new counter();
    counter c2 = new counter();

    c1.setPriority(Thread.MAX_PRIORITY);
    c2.setPriority(Thread.MIN_PRIORITY);
    c1.start();
    c2.start();
  }
}
