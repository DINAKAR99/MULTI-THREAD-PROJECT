package files;

import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import javax.print.PrintService;

public class Multiserve implements Runnable {

  static ServerSocket ss;
  static Socket s;

  @Override
  public void run() {
    // TODO Auto-generated method stub

    String name = Thread.currentThread().getName();
    for (;;) {
      try {
        System.out.println("thread " + name + "ready to accept...");
        s = ss.accept();
        System.out.println("thread" + name + "accepted a connection");
        //for sending msg
        PrintStream ps = new PrintStream(s.getOutputStream());
        ps.println("thread" + name + "contacted u");

        //close conn
        ps.close();
        s.close();
        //dont close serversocket

      } catch (Exception e) {}
    }
  }

  public static void main(String[] args) throws IOException {
    Multiserve ms = new Multiserve();
    //create server socket with 999 as port num
    ss = new ServerSocket(999);
    //create 2 threads
    Thread t1 = new Thread(ms, "one");
    Thread t2 = new Thread(ms, "two");

    //start the threads

    t1.start();
    t2.start();
  }
}
