package com.company;



import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        // write your code here
        Socket socket ;
        InputStreamReader inputStreamReader ;
        OutputStreamWriter outputStreamWriter ;
        BufferedReader bufferedReader ;
        BufferedWriter bufferedWriter ;
        ServerSocket serversocket ;

        serversocket = new ServerSocket(1234);
        System.out.println("Connected");

        while (true) {
            try {
                socket = serversocket.accept();

                // takes input from terminal
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                //sends output to the socket
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter = new BufferedWriter(outputStreamWriter);

                //this loop is for constantly sending messages until "BYE" is entered by client
                while (true) {
                    //this will read what the client has sent
                    String msgFromClient = bufferedReader.readLine();

                    System.out.println("Client: " + msgFromClient);

                    //used to send text back to client to show that message has been received
                    bufferedWriter.write(" Message Received");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    if (msgFromClient.equalsIgnoreCase("BYE"))
                        break;

                }
                System.out.print("Closing connection");
                // close connection
                socket.close();
                inputStreamReader.close();
                outputStreamWriter.close();
                bufferedReader.close();
                bufferedWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
