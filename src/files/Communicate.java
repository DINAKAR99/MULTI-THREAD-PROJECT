package files;

class producer extends Thread {

  StringBuffer sb;
  boolean dataproducer = false;

  producer() {
    this.sb = new StringBuffer();
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      sb.append(i + "-");
      System.out.println("APPENDING");
    }
    dataproducer = true;
  }
}

class consumer extends Thread {

  producer pa;

  consumer(producer p) {
    this.pa = p;
  }

  public void run() {
    while (!pa.dataproducer) {
      try {
        sleep(10);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    System.out.println("THE STRING IS " + pa.sb);
  }
}

public class Communicate {

  public static void main(String[] args) {
    producer p1 = new producer();
    consumer c1 = new consumer(p1);
    p1.start();
    c1.start();
  }
}
