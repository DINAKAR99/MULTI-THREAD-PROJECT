package files;

class bro1 implements Runnable {

  public void run() {
    System.out.println("HEY IM bro1 THREAD");
  }
}

class bro2 implements Runnable {

  public void run() {
    System.out.println("HEY IM bro2 THREAD");
  }
}

public class ThreadGroups {

  public static void main(String[] args) {
    ThreadGroup tg = new ThreadGroup("BROTHERS");
    bro1 b1 = new bro1();
    Thread t1 = new Thread(tg, b1, "brother 1");
    bro2 b2 = new bro2();
    Thread t2 = new Thread(tg, b2, "brother 2");
    ThreadGroup tg1 = new ThreadGroup(tg, "second brothers group");
    Thread t3 = new Thread(tg, b2, "brother  3");
    Thread t4 = new Thread(tg, b2, "brother 4");

    System.out.println("THE PARENT OF TG1 = " + tg1.getParent());

    tg1.setMaxPriority(7);
    t1.start();
    t2.start();
    // System.out.println("THE NO OF ACTIVE THREADS IN TG == " + tg.activeCount());
    t3.start();
    t4.start();
    System.out.println("the group of t1 is " + t1.getThreadGroup());
    System.out.println("THE NO OF ACTIVE THREADS IN TG == " + tg.activeCount());
    System.out.println(t4.getState());
  }
}
