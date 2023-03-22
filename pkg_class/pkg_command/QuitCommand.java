package pkg_class.pkg_command;
import pkg_class.Player;
import pkg_class.Command;
/**
 * Implementation of the 'quit' user command.
 * 
 * @author Michael Kolling and David J. Barnes + Elie DUBOUX
 * @version 2011.07.31 + 2021.01
 */
public class QuitCommand extends Command
{    
    /**
     * Constructor for objects of class QuitCommand.
     */
    public QuitCommand()
    {
    }
    
    /**
     * Quit the games. Cannot have a second word.
     * @param pPlayer The player doing the action.
     */
    public void execute(final Player pPlayer)
    {
        if (this.hasSecondWord())
        {
            this.aGui.println("Quit what?");
            return ;
        }
        this.aGui.goodBye();
    }
}
