package files;

class example extends Thread {

  public void run() {
    System.out.println("HI IM A THREAD");
    System.out.println(
      "THE THREAD NAME IS " + Thread.currentThread().getName()
    );
  }
}

public class ThreadMethods {

  public static void main(String[] args) {
    example e1 = new example();
    e1.setPriority(10);
    System.out.println(e1.getName());
    System.out.println(e1.getPriority());

    System.out.println(e1.getState());

    System.out.println(e1.isAlive());
    System.out.println(e1.getState());
  }
}
