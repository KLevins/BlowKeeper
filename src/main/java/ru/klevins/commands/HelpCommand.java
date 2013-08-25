package ru.klevins.commands;

import ru.klevins.DBHelper;

public class HelpCommand implements Command {

    @Override
    public boolean execute() {

        DBHelper helper = new DBHelper();
        return true;
    }
}
