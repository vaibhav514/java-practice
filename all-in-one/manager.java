//trying using file handling for id and password
//*******************************************************************************************************************************************

package com.java;
import java.io.*;
import java.util.Scanner;
public class manager {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("file1.txt");
        BufferedReader br = new BufferedReader(fr);
        String s;
        String p = "";
        FileReader fo = new FileReader("file2.txt");
        BufferedReader bo = new BufferedReader(fo);
        String o;
        String q = "";
        int count = 0;
        int lineCount = 0;
        int line = 0;
        while((s = br.readLine()) != null) {
            if (lineCount==0)p=s;
            else p= p +"\n" +s;
            lineCount++;
            if (s.equals("Manan")) {
                line = lineCount;
                System.out.println(s);
            }
        }
        while ((o = bo.readLine()) != null){
            if (count==0)q=o;
            else q= q +"\n" +o;
            count ++;
            if (count == line){
                System.out.println(o);
            }
        }
        String source = p +"\n" + "Mohan";
        char buffer[] = new char[source.length()];
        source.getChars(0, source.length(), buffer, 0);
        FileWriter f0 = new FileWriter("file1.txt");
        f0.write(buffer);
        String sourc = q +"\n" + "Mohan@126";
        char buffe[] = new char[sourc.length()];
        sourc.getChars(0, sourc.length(), buffe, 0);
        FileWriter f1 = new FileWriter("file2.txt");
        f1.write(buffe);
        fr.close();
        fo.close();
        f0.close();
        f1.close();
    }
}
