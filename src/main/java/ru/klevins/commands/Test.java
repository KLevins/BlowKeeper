package ru.klevins.commands;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 27.08.13
 * Time: 22:09
 * To change this template use File | Settings | File Templates.
 */
import java.util.Scanner;
public class Test {
    public static void main (String args[])  {
        System.out.println("Введите строку");
        Scanner in = new Scanner(System.in);
        String c = in.nextLine();
        System.out.println(c.substring(0,c.indexOf(" ")));
                }
}

