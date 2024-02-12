package files;

class thread3 extends Thread {

  public void run() {
    System.out.println("THE THREAD WAS CREATED SUCCESFULLY");
    task1();
    task2();
    task3();
  }

  void task1() {
    System.out.println("THIS IS RANGER 1 ");
  }

  void task2() {
    System.out.println("THIS IS RANGER 2 ");
  }

  void task3() {
    System.out.println("THIS IS RANGER 3 ");
  }
}

public class Multi_task {

  public static void main(String[] args) {
    thread3 t3 = new thread3();
    t3.start();
  }
}
