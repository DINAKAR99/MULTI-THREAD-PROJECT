package files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  public static void main(String[] args) throws IOException {
    Socket socket = null;
    ServerSocket serversock = null;
    InputStreamReader inputStreamReader = null;
    OutputStreamWriter outputStreamWriter = null;

    BufferedReader bufferedReader = null;
    BufferedWriter bufferedWriter = null;

    serversock = new ServerSocket(111);

    while (true) {
      try {
        socket = serversock.accept();
        inputStreamReader = new InputStreamReader(socket.getInputStream());
        outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

        bufferedReader = new BufferedReader(inputStreamReader);
        bufferedWriter = new BufferedWriter(outputStreamWriter);

        while (true) {
          String MsgFromClient = bufferedReader.readLine();
          System.out.println("client : " + MsgFromClient);
          bufferedWriter.write("msg recieved");
          bufferedWriter.newLine();
          bufferedWriter.flush();

          if (MsgFromClient.equalsIgnoreCase("BYE")) {
            break;
          }

          socket.close();
          inputStreamReader.close();
          outputStreamWriter.close();
          bufferedReader.close();
          bufferedWriter.close();
        }
      } catch (Exception e) {
        // TODO: handle exception
      }
    }
  }
}
