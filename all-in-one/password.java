//adding password ,admin and employee
//******************************************************************************************************************************************************


package com.java;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import com.java.BANK;
public class password {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println("Date : " +now);
        Scanner sc = new Scanner(System.in);
        ArrayList<String> Name = new ArrayList<>();
        ArrayList<String> password = new ArrayList<>();
        ArrayList<String> admin = new ArrayList<>();
        ArrayList<String> adpass = new ArrayList<>();
        admin.add("Shivam");
        admin.add("Pulkit");
        adpass.add("Shivam@456");
        adpass.add("Jain@689");
        Name.add("Vaibhav");
        Name.add("Priyam");
        Name.add("Ajinkya");
        Name.add("Manan");
        password.add("Vaibhav@12");
        password.add("Mumbai12");
        password.add("java12");
        password.add("Vit836");
        System.out.println(" enter 1 for manager \n enter 2 for employee \n enter 3 to exit");
        int y = sc.nextInt();
        while (y < 3) {
            switch (y) {
                case 1:
                    System.out.println("ENTER YOUR USERNAME");
                    String s = sc.next();
                    System.out.println("ENTER YOUR PASSWORD");
                    String z = sc.next();
                    if (admin.contains(s)) {
                        int g = admin.indexOf(s);
                        String f = adpass.get(g);
                        if (z.equals(f)) {
                            System.out.println(
                                    "enter 1 to add employee \nenter 2 to remove employee\nenter 3 to show all employee detail");
                            int j = sc.nextInt();
                            switch (j) {
                                case 1:
                                    System.out.println("enter employee username to add");
                                    String l = sc.next();
                                    Name.add(l);
                                    System.out.println("enter employee password to add");
                                    String m = sc.next();
                                    password.add(m);
                                    break;
                                case 2:
                                    System.out.println("enter employee username to remove");
                                    String n = sc.next();
                                    int i = Name.indexOf(n);
                                    password.remove(i);
                                    Name.remove(n);

                                    break;
                                case 3:
                                    System.out.println(Name + " \n" + password);
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("ENTER YOUR USERNAME");
                    String Y = sc.next();
                    System.out.println("ENTER YOUR PASSWORD");
                    String X = sc.next();
                    if (Name.contains(Y)) {
                        int i = Name.indexOf(Y);
                        String w = password.get(i);
                        if (X.equals(w)) {
                            calc person = new calc("BOI");
                            person.input();
                            calc.out p = new calc.out();
                            p.calculate();
                        } else {
                            System.out.println("YOU HAVE ENTERED WRONG PASSWORD");
                        }
                    } else {
                        System.out.println("YOU HAVE ENTERED WRONG USER NAME");
                    }
                    break;
            }
            System.out.println(" enter 1 for manager \n enter 2 for employee \n enter 3 to exit");
            y = sc.nextInt();
        }
        for (y = 3; y < 4; y++) {
            System.out.println("Thank you for giving us opportunity to serve you");
        }
    }
}
