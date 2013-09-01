package ru.klevins;

import ru.klevins.commands.AddCommand;
import ru.klevins.commands.Command;
import ru.klevins.commands.HelpCommand;
import ru.klevins.commands.ReportCommand;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static boolean exitKey = true;

    public static void main (String args[])   {
        System.out.println("Добро пожаловать в BlowKeeper\n");
        System.out.println("Доступны следующие команды: add, help и report");

        DBHelper helper = DBHelper.getInstance();
        Connection connection = helper.getConnection();

        String pref = "blow_keeper>";
        Command add = new AddCommand(connection);
        Command help = new HelpCommand(connection);
        Command report = new ReportCommand(connection);

        Map<String, Command> commandMap = new HashMap<String, Command>();
        commandMap.put("add", add);
        commandMap.put("help", help);
        commandMap.put("report", report);

        Scanner scan = new Scanner(System.in);
        while (exitKey){
            System.out.print(pref);
            String input = scan.nextLine();
            if(input != null){
                if(input.length() > 0){
                    Command command = commandMap.get(input.substring(0,input.indexOf(" ")));
                    if(command != null){
                        if(command.execute(input)){
                            continue;
                        } else {
                            System.out.println("Command run error!");
                        }
                    } else {
                        System.out.println("Unknown command!");
                    }
                }
            }
        }
    }
}
