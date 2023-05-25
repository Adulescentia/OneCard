package Util;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.out;

public class Util {
    public static void printf(String format,Object... args){ out.printf(format,args); }
    public static void println(Object o){ out.println(o); }
    public static void print(Object o){ out.print(o); }

    public static <T> ArrayList<T> addAll (T... elements){
        return new ArrayList<T>(Arrays.asList(elements));
    }
}
