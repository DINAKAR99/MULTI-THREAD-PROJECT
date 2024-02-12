package files;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Multiclient {

  public static void main(String[] args)
    throws UnknownHostException, IOException {
    //create a client sockett with port 999

    Socket s = new Socket("localhost", 999);

    //to accept data from server
    BufferedReader br = new BufferedReader(
      new InputStreamReader(s.getInputStream())
    );

    //recieve data as long as server does nt close client socket

    String str;
    while ((str = br.readLine()) != null) {
      System.out.println(str);
    }

    //close conn
    br.close();
    s.close();
  }
}
