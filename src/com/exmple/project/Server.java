package com.exmple.project;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {


        String finalMessage;
        System.out.println("Waiting for client's Message");


        ServerSocket s = null;
        try {
            s = new ServerSocket(9000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {

            Socket so = null;
//            DataInputStream dataInputSteam = null;
            try {

                so = s.accept();

                System.out.println("connection is established");

                System.out.println("Getting client's data");

                try (DataInputStream dataInputStream = new DataInputStream(so.getInputStream())) {
                    finalMessage = dataInputStream.readUTF();
                    System.out.println("From server: " + finalMessage);

                }

            } catch (Exception e) {
               e.printStackTrace();
            }


        }
    }
}



