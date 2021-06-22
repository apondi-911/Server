package com.company;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    //constructor with port

        public Server(int port)
        {
            // starts server and waits for a connection
            Socket socket = null;
            ServerSocket server = null;
            DataInputStream in = null;
            while(true){

            }
            try {
                //server instantiates an object to denote the port number
                server = new ServerSocket(port);
                System.out.println("Server started");
                System.out.println("Waiting for client...");

                // accept method is used to wait until client connects to server
                socket = server.accept();
                System.out.println("Client accepted");

                //takes input from client socket
                in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));


                // reads message from client until "Over" is read
                while(true)
                {

                    String line = in.readUTF();
                    System.out.println(line);


            }
            catch(IOException e)
            {
                System.out.println();

            }
            try {
                assert server != null;
                server.close();
                assert in != null;
                in.close();
                socket.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public static void main(String []args) throws IOException {

            @SuppressWarnings({ "unused", "resource" })
            ServerSocket server = new ServerSocket (5000);


        }


    }




