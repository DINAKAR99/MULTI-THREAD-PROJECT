package files;

public class CurrentThread {

  public static void main(String[] args) {
    Thread t1 = Thread.currentThread();
    System.out.println("CURRENT THREAD IS " + t1);
    System.out.println("CURRENT THREAD NAME  IS " + t1.getName());
  }
}
