package ru.klevins;

import ru.klevins.commands.AddCommand;
import ru.klevins.commands.Command;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static boolean exitKey = true;

    public static void main (String args[])   {

        String pref = "blow_keeper>";
        Command add = new AddCommand();
        Map<String, Command> commandMap = new HashMap<String, Command>();
        commandMap.put("add", add);

        Scanner scan = new Scanner(System.in);
        while (exitKey){
            System.out.print(pref);
            String s = scan.nextLine();
            if(s != null){
                if(s.length() > 0){
                    Command command = commandMap.get(s);
                    if(command != null){
                        if(command.execute()){
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
/*
        ru.klevins.commands.DBHelper helper = new ru.klevins.commands.DBHelper();

        Connection con = helper.getConnection();

        try {
            Statement statement = con.createStatement();
            //statement.execute("create table tbl2(id simpleint, name varchar(30))");
            //statement.execute("insert into tbl2 values(1, 'Nik')");
            //statement.execute("insert into tbl2 values(2, 'Vas')");
            //statement.execute("insert into tbl2 values(3, 'Yur')");
            //statement.execute("select name from tbl2 where id = 1");
            statement.execute("select category, style from categories");
            System.out.println(statement.getResultSet().getString("category"));

        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
