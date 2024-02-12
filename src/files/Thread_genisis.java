package files;

class thread1 extends Thread {

  public void run() {
    System.out.println("THE THREAD WAS CREATED SUCCESFULLY");
  }
}

public class Thread_genisis {

  public static void main(String[] args) {
    thread1 t1 = new thread1();
    t1.start();
  }
}
