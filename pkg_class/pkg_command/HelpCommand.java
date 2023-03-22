package pkg_class.pkg_command;
import pkg_class.Player;
import pkg_class.Command;
/**
 * Implementation of the 'help' user command.
 * 
 * @author Michael Kolling and David J. Barnes + Elie DUBOUX
 * @version 2011.07.31 + 2021.01
 */
public class HelpCommand extends Command
{
    private CommandWords aCommandWords;
    
    /**
     * Constructor for objects of class HelpCommand.
     */
    public HelpCommand(CommandWords pWords)
    {
        this.aCommandWords = pWords;
    }
    
    /**
     * Print all the actions that the player can do.
     * @param pPlayer The player asking for help.
     */
    public void execute(final Player pPlayer)
    {
        this.aGui.println("You don't really know what to do..");
        this.aGui.println("Here are the commands that you can type.");
        this.aGui.println("Your command words are: \n" + this.aCommandWords.getCommandList());
    }
}
