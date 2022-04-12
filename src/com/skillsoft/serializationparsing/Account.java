package com.skillsoft.serializationparsing;


import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;

public class Account implements Externalizable {

    private static final long serialVersionUID=1L;

    public static String accountType="LOAN";

    private long accountNumber;
    private String customerName;
    private double loanBalance;
    private int creditScore;
    private String[]tags;

    //private String additionalNotes;
    //private CreditCard creditCard;

    public Account(){
    }
    //int creditScore, String...tags
    public Account(long accountNumber, String customerName, double loanBalance){
        this.accountNumber=accountNumber;
        this.customerName=customerName;
        this.loanBalance=loanBalance;
        //this.creditScore=creditScore;
        //this.tags=tags;

       // this.creditCard= new CreditCard(cardType);
    }

    public static String getAccountType() {
        return accountType;
    }

    public double getLoanBalance() {
        return loanBalance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

/*    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }*/

    @Override
    public String toString() {
        return String.format("Account type: %s, Number: %d, Name: %s, Balance: %.1f, Credit score: %d, Tags: %s",
               accountType,accountNumber,customerName,loanBalance,creditScore, Arrays.asList(tags));
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeLong(accountNumber);
        out.writeUTF(customerName);
        out.writeDouble(loanBalance);
        out.writeUTF(Arrays.toString(tags));
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        this.accountNumber=in.readLong();
        this.customerName= in.readUTF();
        this.loanBalance=in.readDouble();

        String tagString= in.readUTF();
        tagString=tagString.substring(1, tagString.length()-1);

        this.tags=tagString.split(", ");
    }
}
