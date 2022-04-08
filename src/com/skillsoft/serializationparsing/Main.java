package com.skillsoft.serializationparsing;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[]args) throws IOException {

/*
        Account account1 = new Account(101001,"Bill Gates",1555.5f,647,
                "Founder","Hi potential");

        Account account2 = new Account(2002002,"Paul Allen",1272.5f,689,
                "High income","Hi potential");
*/

       // List<Account> accountList = Arrays.asList(account1,account2);

        System.out.println("*** Reading Objects with a serializationVersionUID");

        String fileName="accounts_with_tags.txt";

        try(ObjectInputStream objOut = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(fileName)))){

           /* for(Account account : accountList){
                System.out.println("Writing: " + account);
                objOut.writeObject(account);
            }*/

            Account account1 = (Account) objOut.readObject();
            System.out.println("Account 1: " + account1);

            Account account2 = (Account) objOut.readObject();
            System.out.println("Account 1: " + account2);

            /*objOut.writeObject(account1);
            objOut.writeObject(account2);*/

        } catch(ClassNotFoundException nse){
            //nse.printStackTrace();
             System.out.println("Thrown when the class read using readObject() is not found");
        } finally {
            System.out.println("*** Completed writing objects ***");
        }
    }
}
