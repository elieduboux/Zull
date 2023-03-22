package pkg_class.pkg_command;
import pkg_class.Player;
import pkg_class.Command;
/**
 * Implementation of the 'look' user command.
 * 
 * @author Michael Kolling and David J. Barnes + Elie DUBOUX
 * @version 2011.07.31 + 2021.01
 */
public class LookCommand extends Command
{    
    /**
     * Constructor for objects of class LookCommand.
     */
    public LookCommand()
    {
    }
    
    /**
     * Print the description of the room and it's exits if nothing is typed after.
     * If the thing typed after is an item, print the desciption of the item.
     * 
     * Exemple :
     * > look
     * or
     * > look 'Item'
     * with :
     *      'Item' The name of the item
     * @param pPlayer The player doing the action.
     */
    public void execute(final Player pPlayer)
    {
        if (!this.hasSecondWord())
        {
           this.aGui.println(pPlayer.getCurrentRoom().getLongDescription());
           return;
        }
        
        String vItemName = this.getSecondWord();
        String vPnjName = this.getSecondWord();
        if (pPlayer.getItem(vItemName) == null)
        {
            if (pPlayer.getCurrentRoom().getPnj(vPnjName) != null)
            {
                this.aGui.print(pPlayer.getCurrentRoom().getPnj(vPnjName).getSpeechsString());
                return ;
            }
            if (pPlayer.getCurrentRoom().getItem(vItemName) == null)
            {
                this.aGui.println("This is not an item nor a pnj present in the room or your inventory...");
                return;
            }
            
            this.aGui.print(pPlayer.getCurrentRoom().getItem(vItemName).toString());
            this.aGui.println(pPlayer.getCurrentRoom().getItem(vItemName).getDescription());
            return;
        }
        
        this.aGui.print(pPlayer.getItem(vItemName).toString());
        this.aGui.println(pPlayer.getItem(vItemName).getDescription());
    }
}
