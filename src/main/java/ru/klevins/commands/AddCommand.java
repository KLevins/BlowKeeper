package ru.klevins.commands;

/**
 * Created with IntelliJ IDEA.
 * User: Никита
 * Date: 25.08.13
 * Time: 17:08
 * To change this template use File | Settings | File Templates.
 */
public class AddCommand implements Command {

    @Override
    public boolean execute(String input) {
        System.out.println("add complete");
        System.out.println(input.substring(input.indexOf(" "),input.length()));

        return true;
    }
}
