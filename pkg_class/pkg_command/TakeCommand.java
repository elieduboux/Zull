package pkg_class.pkg_command;
import pkg_class.Player;
import pkg_class.Command;
import pkg_class.pkg_room.DarkRoom;
import pkg_class.Item;
/**
 * Implementation of the 'take' user command.
 * 
 * @author Michael Kolling and David J. Barnes + Elie DUBOUX
 * @version 2011.07.31 + 2021.01
 */
public class TakeCommand extends Command
{    
    /**
     * Constructor for objects of class TakeCommand.
     */
    public TakeCommand()
    {
    }
    
    /**
     * The player take an item X many time if present in the room.
     * 
     * Exemple :
     * >take 'Item' X
     * or 
     * >take 'Item'
     * with :
     *      'Item' -> the name of the item
     *      X -> the number of time 
     * 
     * @param pPlayer The player asking for help.
     */
    public void execute(final Player pPlayer)
    {
        if (!this.hasSecondWord())
        {
            this.aGui.println("Take what?");
            return ;
        }
        
        DarkRoom vDarkRoomClass = new DarkRoom();
        
        if (pPlayer.getCurrentRoom().getClass() == vDarkRoomClass.getClass())
        {
            DarkRoom vDarkRoom = (DarkRoom)pPlayer.getCurrentRoom();
            if (vDarkRoom.getIsDark())
            {
                this.aGui.println("You can't take anything because it's too dark.");
                return;
            }
        }
        
        Item vItem = pPlayer.getCurrentRoom().getItem(this.getSecondWord().toLowerCase());
        
        if (vItem == null)
        {
            this.aGui.println("This item is not in the room.");
            return ;
        }
            
        int vNb = this.getThirdWordNumber();
        
        if (!pPlayer.isAddPossible(vItem, vNb))
        {
            this.aGui.println("You have too much things on you...");
            return;
        }
        
        if (!pPlayer.getCurrentRoom().isRemovePossible(vItem, vNb))
        {
            this.aGui.println("There are not enough items in the room...");
            return;
        }
            
        pPlayer.addItems(vItem, vNb);
        pPlayer.getCurrentRoom().removeItems(vItem, vNb);
        this.aGui.println("The "+ this.getSecondWord() +" was added to your inventory.");
    }
}
