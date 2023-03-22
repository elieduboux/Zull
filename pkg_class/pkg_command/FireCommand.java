package pkg_class.pkg_command;
import pkg_class.Player;
import pkg_class.Command;
import pkg_class.Item;
import pkg_class.pkg_item.Beamer;
/**
 * Implementation of the 'fire' user command.
 * 
 * @author Michael Kolling and David J. Barnes + Elie DUBOUX
 * @version 2011.07.31 + 2021.01
 */
public class FireCommand extends Command
{    
    /**
     * Constructor for objects of class FireCommand.
     */
    public FireCommand()
    {
    }
    
    /**
     * Check if the beamer is in the player inventory. 
     * Then, if the beamer has previously been charged, teleport the player there.
     * @param pPlayer The player doing the action.
     */
    public void execute(final Player pPlayer)
    {
        Item vItem = pPlayer.getItem("beamer");
        if (vItem == null)
        {
            this.aGui.println("You need to posses a Beamer in order to charge it, can be found somewhere in the giant tree.");
            return ;
        }
        
        Beamer vBeamerClass = new Beamer();
        if ( vItem.getClass() != vBeamerClass.getClass())
        {
            this.aGui.println("This Item is not a Beamer...");
            return ;
        }
        
        Beamer vBeamer = (Beamer)vItem;
        if (!vBeamer.getIsCharged())
        {
            this.aGui.println("The beamer is not charged...");
            return ;
        }
        
        pPlayer.setCurrentRoom(vBeamer.getRoomSaved());
        vBeamer.setRoomSaved(null);
        pPlayer.clearPreviousRooms();
        
        this.aGui.println("You have succesfully been teleported to the room saved in the beamer.");
        this.aGui.println("The side effect is that you don't remember the rooms you have passed by.");
        this.aGui.println("You need to charge the beamer again in order to reuse it.\n");
        this.aGui.printLocationInfo();
    }
}
