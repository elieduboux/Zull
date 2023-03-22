package pkg_class.pkg_command;
import pkg_class.Player;
import pkg_class.Command;
import pkg_class.Item;
/**
 * Implementation of the 'drop' user command.
 * 
 * @author Michael Kolling and David J. Barnes + Elie DUBOUX
 * @version 2011.07.31 + 2021.01
 */
public class DropCommand extends Command
{    
    /**
     * Constructor for objects of class DropCommand.
     */
    public DropCommand()
    {
    }
    
    /**
     * The player drop an item he has X many times if present in the 
     * players'inventory.
     * 
     * Exemple :
     * >drop 'Item' X
     * or 
     * >drop 'Item'
     * with :
     *      'Item' -> the name of the item
     *      X -> the number of time 
     * @param pPlayer The player doing the action.
     */
    public void execute(final Player pPlayer)
    {
        if (!this.hasSecondWord())
        {
            this.aGui.println("Drop what?");
            return ;
        }
        
        Item vItem = pPlayer.getItem(this.getSecondWord().toLowerCase());
        if (vItem == null)
        {
            this.aGui.println("You don't have this item.");
            return;
        }
        
        int vNb = this.getThirdWordNumber();
        
        if (!pPlayer.isRemovePossible(vItem, vNb))
        {
            this.aGui.println("You don't have enough item to drop...");
            return;
        }
        
        pPlayer.getCurrentRoom().addItems(vItem, vNb);
        pPlayer.removeItems(vItem, vNb);
        this.aGui.println("You dropped the "+ this.getSecondWord() +", it felt on the ground.");
    }
}
