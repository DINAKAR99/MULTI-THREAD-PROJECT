package files;

class producer extends Thread {

  StringBuffer sb;

  producer() {
    this.sb = new StringBuffer();
  }

  public void run() {
    synchronized (sb) {
      for (int i = 0; i < 10; i++) {
        sb.append(i + "-");
        System.out.println("APPENDING");
      }
      sb.notify();
    }
  }
}

class consumer extends Thread {

  producer pa;

  consumer(producer p) {
    this.pa = p;
  }

  public void run() {
    try {
      pa.sb.wait();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("THE STRING IS " + pa.sb);
  }
}

public class Communicate_notify {

  public static void main(String[] args) {
    producer p1 = new producer();
    consumer c1 = new consumer(p1);
    p1.start();
    c1.start();
  }
}
