package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

  public static void main(String[] args) {
    Socket socket = null;
    InputStreamReader inputStreamReader = null;
    OutputStreamWriter outputStreamWriter = null;

    BufferedReader bufferedReader = null;
    BufferedWriter bufferedWriter = null;

    try {
      socket = new Socket("localhost", 111);
      inputStreamReader = new InputStreamReader(socket.getInputStream());
      outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

      bufferedReader = new BufferedReader(inputStreamReader);
      bufferedWriter = new BufferedWriter(outputStreamWriter);
      try (Scanner sc = new Scanner(System.in)) {
        while (true) {
          String msgtosend = sc.nextLine();
          bufferedWriter.write(msgtosend);
          bufferedWriter.newLine();
          bufferedWriter.flush();

          System.out.println("server : " + bufferedReader.readLine());

          if (msgtosend.equalsIgnoreCase("BYE")) {
            break;
          }
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
      // TODO: handle exception
    }
    // finally {
    //   try {
    //     if (socket != null) {
    //       socket.close();
    //     }
    //     if (inputStreamReader != null) {
    //       inputStreamReader.close();
    //     }
    //     if (outputStreamWriter != null) {
    //       outputStreamWriter.close();
    //     }
    //     if (bufferedReader != null) {
    //       bufferedReader.close();
    //     }
    //     if (bufferedWriter != null) {
    //       bufferedWriter.close();
    //     }
    //   } catch (Exception e) {
    //     // TODO: handle exception
    //   }
    // }
  }
}
