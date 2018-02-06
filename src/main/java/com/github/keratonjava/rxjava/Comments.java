package com.github.keratonjava.rxjava;

public class Comments {

    public static void $(String s) {
        System.out.println(" ");
        if (s.contains("TODO")) {
            System.out.println((char)27 + "[31m" + s);
        }
        else {
            System.out.println("#### " + s + " ####");
        }
    }
}
