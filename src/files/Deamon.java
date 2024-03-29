package files;

public class Deamon extends Thread {

  public void run() {
    System.out.println("Entering run method");

    try {
      System.out.println(
        "In run Method: currentThread() is" + Thread.currentThread()
      );

      while (true) {
        try {
          Thread.sleep(500);
        } catch (InterruptedException x) {}

        System.out.println("In run method: woke up again");
      }
    } finally {
      System.out.println("Leaving run Method");
    }
  }

  public static void main(String[] args) {
    System.out.println("Entering main Method");

    Deamon t = new Deamon();
    t.setDaemon(true);
    t.start();

    try {
      Thread.sleep(6000);
    } catch (InterruptedException x) {}

    System.out.println("Leaving main method");
  }
}
