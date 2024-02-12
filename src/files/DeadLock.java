package files;

class BookTickets extends Thread {

  Object train, comp;

  BookTickets(Object train, Object comp) {
    this.train = train;
    this.comp = comp;
  }

  public void run() {
    synchronized (train) {
      System.out.println("BOOK TICKET LOCKED ON TRAIN");
      try {
        sleep(150);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      System.out.println("BOOK TICKET NOW WAITING TO LOCK ON COMPARTMENT");
      synchronized (comp) {
        System.out.println("BOOK TICKET LOCKED ON COMPARTMENT");
      }
    }
  }
}

class cancleTickets extends Thread {

  Object train, comp;

  cancleTickets(Object train, Object comp) {
    this.train = train;
    this.comp = comp;
  }

  public void run() {
    synchronized (train) {
      System.out.println("CANCLE TICKET LOCKED ON COMPARTMENT");
      try {
        sleep(200);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      System.out.println("CANCLE TICKET NOW WAITING TO LOCK ON TRAIN");
      synchronized (comp) {
        System.out.println("CANCLE TICKET LOCKED ON TRAIN");
      }
    }
  }
}

public class DeadLock {

  public static void main(String[] args) {
    Object train = new Object();
    Object comp = new Object();
    BookTickets t1 = new BookTickets(train, comp);
    cancleTickets t2 = new cancleTickets(train, comp);
    t1.start();
    t2.start();
  }
}
