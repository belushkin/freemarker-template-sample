package com.app01;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main1 {

    public static void main(String[] args) {
        String content = readContent("/app01/template01.html");
        System.out.println(content);
        System.out.println("-------------------");
        String res = String.format(content, "MY APPLICATION TITLE", "Denis", 33);
        System.out.println(res);
        System.out.println("-------------------");
        String content2 = readContent("/app01/template01.txt");
        String res2 = String.format(content2, "MY APPLICATION TITLE", "Denis", 33);
        System.out.println(res2);
        System.out.println("-------------------");
        System.out.println(makeValue("Denis", 33));
        System.out.println(makeValue2("Denis", 33));
    }

    private static String makeValue(String name, int age){
        String s = "name: "+name+"; age="+age;
        return s;
    }

    private static String makeValue2(String name, int age){
        return String.format("name: %s; age=%s", name, age);
    }

    private static String readContent(String filePath){
        try(InputStream in  = Main1.class.getResourceAsStream(filePath)){
            byte[] data = new byte[in.available()];
            in.read(data);
            return new String(data);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
