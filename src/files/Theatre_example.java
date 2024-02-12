package files;

class general extends Thread {

  String str;

  general(String s) {
    str = s;
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(str + ":" + i);
      try {
        sleep(2000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}

public class Theatre_example {

  public static void main(String[] args) {
    general g1 = new general("CUT THE TICKET");
    general g2 = new general("SHOW THE TICKET");

    g1.start();
    g2.start();
  }
}
