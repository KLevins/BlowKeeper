package commands;

/**
 * Created with IntelliJ IDEA.
 * User: Никита
 * Date: 25.08.13
 * Time: 17:08
 * To change this template use File | Settings | File Templates.
 */
public class AddCommand implements Command {

    @Override
    public boolean execute() {
        System.out.println("add complete");
        return true;
    }
}
