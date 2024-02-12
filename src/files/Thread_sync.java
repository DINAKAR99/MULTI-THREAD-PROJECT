package files;

class Reserve implements Runnable {

  int available = 1;
  int wanted;
  String nam;

  Reserve(int i) {
    wanted = i;
  }

  public void run() {
    synchronized (this) {
      System.out.println("THE AVAILABLE BIRTHS ARE " + available);
      if (available >= wanted) {
        String s1 = Thread.currentThread().getName();
        System.out.println("ALLOCATED " + wanted + " BIRTHS FOR " + s1);
        try {
          Thread.sleep(1500);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        available = available - wanted;
      } else {
        System.out.println("SORRY NO BIRTHS AVAILABLE");
      }
    }
  }
}

public class Thread_sync {

  public static void main(String[] args) {
    Reserve r1 = new Reserve(1);

    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r1);
    t1.start();
    t2.start();
  }
}
