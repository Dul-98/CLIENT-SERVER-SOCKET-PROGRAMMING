package com.exmple.project;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) {


        String CMessage;
        Scanner sc = null;

        while (true) {
            try (Socket so = new Socket("localhost", 9000)) {
                sc = new Scanner(System.in);

                System.out.println("Enter your Message:");
                CMessage = sc.nextLine();


                //send message to the server
                try (DataOutputStream outServer = new DataOutputStream(so.getOutputStream())) {
                    outServer.writeUTF(CMessage);
                }
                sc = null;
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}


