package files;

import java.io.IOException;

class thread2 extends Thread {

  boolean check = false;

  public void run() {
    for (int j = 0; j < 100000; j++) {
      System.out.println(j);
      if (check) return;
    }
  }
}

public class Thread_Termination {

  public static void main(String[] args) throws IOException {
    thread2 t2 = new thread2();
    t2.start();
    System.in.read();
    t2.check = true;
  }
}
