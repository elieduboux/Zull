package pkg_class.pkg_command;
import pkg_class.Player;
import pkg_class.Command;
/**
 * Implementation of the 'inventory' user command.
 * 
 * @author Michael Kolling and David J. Barnes + Elie DUBOUX
 * @version 2011.07.31 + 2021.01
 */
public class InventoryCommand extends Command
{    
    /**
     * Constructor for objects of class InventoryCommand.
     */
    public InventoryCommand()
    {
    }
    
    /**
     * Print the inventory of the player.
     * @param pPlayer The player doing the action.
     */
    public void execute(final Player pPlayer)
    {
        this.aGui.println(pPlayer.getItemsString());
    }
}
