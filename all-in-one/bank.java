package com.java;
import java.util.Scanner;
interface structure {
    public void input();
    public void disp();
}
interface first {
    public void despositamount();
    public void withdraw();
}
abstract class second {
    void outer() {};
    void calculate() {};
}

class customer implements structure {
    protected static Scanner sc = new Scanner(System.in);
    public static String customername, city, bankname;
    static int initalamount, i, loan_amount, debt = 0;
    private static long account;
    customer(String bankname) {
        this.bankname = bankname;
    }
//    for accessing the account in other classes
//    long getaccount(){
//        return account;
//    }
//    long setaccount(long acc){
//        account = acc;
//        return account;
//    }
    public void input() {
        System.out.println("Enter customer's name = ");
        customername = sc.next();
        System.out.println("Enter customer's city name = ");
        city = sc.next();
        System.out.println("Enter customer's account number = ");
        account = sc.nextLong();
        System.out.println("Enter customer's inital amount = ");
        try{
            initalamount = sc.nextInt();
        }
        catch (Exception e){
            System.out.println("Aquaat dekh kar aao");
            System.exit(0);
        }
    }
    public void disp() {
        System.out.println("Customer name = " + customername);
        System.out.println("City name = " + city);
        System.out.println("Bank name = " + bankname);
        System.out.println("Account number = " + account);
        System.out.println("Inital amount = " + initalamount);
        System.out.println("Loan amount = " + debt);
    }
}
class calc extends customer implements first, structure {
    calc(String t) {
        super(t);
    }
    public void input() {
        super.input();
    }
    public void disp() {
        super.disp();
    }
    public void despositamount() {
        int deposit;
        String choice;
        System.out.println("Enter the as which form you want to deposit \nNORMAL \nRD (you will get 3% interest at the end of the year) \nFD (you will get actual amount + 6% interest at the end of the year) \nLOAN ( deposit loan amount if any) ");
        choice = sc.next();
        if (choice.equals("NORMAL")) {
            System.out.println("enter the amount you want to deposit = ");
            deposit = sc.nextInt();
            if(deposit>0){
            initalamount = initalamount + deposit;
            System.out.println("initial amount = " + initalamount);}
            else {
                System.out.println("Enter valid amount");
            }
        }
        if (choice.equals("RD")) {
            System.out.println("enter the amount you want to deposit = ");
            deposit = sc.nextInt();
            if(deposit>0){
                initalamount = initalamount + deposit;
                System.out.println("initial amount = " + initalamount);
                int f = (3 * deposit) / 100;
                System.out.println("You will get Rs" + f + " as a interest on " + deposit + " at the end of the year");}
            else {
                System.out.println("Enter valid amount");
            }
        }
        if (choice.equals("FD")) {
            System.out.println("enter the amount you want to deposit = ");
            deposit = sc.nextInt();
            if(deposit>0){
                int f = deposit + (6 * deposit) / 100;
                System.out.println(" you will get Rs" + f + " at the end of the year");}
            else {
                System.out.println("Enter valid amount");
            }
        }
        if (choice.equals("LOAN")) {
            System.out.println("enter the amount you want to deposit = ");
            deposit = sc.nextInt();
            if (debt!=0){
                if(deposit>0){
                debt = debt - deposit;
                System.out.println("Remaining loan amount is = " + debt);}
                else {
                System.out.println("Enter valid amount");
                }
            }
            else {
                System.out.println("You don't have any loan debt");
            }
        }
    }
    public void withdraw() {
        int withdraw;
        System.out.println("enter the amount you want to withdraw = ");
        withdraw = sc.nextInt();
        if(withdraw>0){
            if (withdraw <= initalamount) {
            initalamount = initalamount - withdraw;
            System.out.println("initial amount = " + initalamount);
            }
            else {
            System.out.println("your account does not sufficient balance \nDo you want to take take loan \nYou will be charged 10% as a interest \nIf yes press 1 otherwise press other keys ");
                int x = sc.nextInt();
                if (x == 1) {
                System.out.println("Enter the amount you want as loan");
                loan_amount = sc.nextInt();
                debt = (loan_amount + (loan_amount / 10));
                // initalamount = initalamount - (loan_amount + (loan_amount / 10));
                System.out.println("Your loan has been approved \nDebt amount with interest = " + debt);}
            }
        }
        else {
                    System.out.println("Enter valid amount");
        }
    }

    final static class out extends second {
        public void outer() {
            System.out.println("enter number to perform opertion");
            System.out.println(" press 1 to display information");
            System.out.println(" press 2 to deposit money");
            System.out.println(" press 3 to withdraw money");
            System.out.println(" press 4 to exit");
            i = sc.nextInt();
        }
        public void calculate() {
            outer();
            calc p = new calc("boi");
            while (i < 4) {
                switch (i) {
                    case 1:
                        p.disp();
                        break;
                    case 2:
                        p.despositamount();
                        break;
                    case 3:
                        p.withdraw();
                        break;
                }
                outer();
            }
        }
    }
}
public class bank {
    public static void main(String[] args) {
        customer q = new customer("boi");
        calc person = new calc("BOI");
        person.input();
        calc.out p = new calc.out();
        p.calculate();
    }
}
