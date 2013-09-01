package ru.klevins.commands;

import java.sql.Connection;

/**
 * Created with IntelliJ IDEA.
 * User: Никита
 * Date: 25.08.13
 * Time: 17:07
 * To change this template use File | Settings | File Templates.
 */
public interface Command {

    public boolean execute(String input);
}
