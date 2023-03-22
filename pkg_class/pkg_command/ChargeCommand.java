package pkg_class.pkg_command;
import pkg_class.Player;
import pkg_class.Command;
import pkg_class.Item;
import pkg_class.pkg_item.Beamer;
/**
 * Implementation of the 'charge' user command.
 * 
 * @author Michael Kolling and David J. Barnes + Elie DUBOUX
 * @version 2011.07.31 + 2021.01
 */
public class ChargeCommand extends Command
{    
    /**
     * Constructor for objects of class ChargeCommand.
     */
    public ChargeCommand()
    {
    }
    
    /**
     * Check if the beamer is in the player inventory. 
     * Then, it saves the room where the player is currently in.
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
        
        Beamer vBeamer = new Beamer();
        if ( vItem.getClass() != vBeamer.getClass())
        {
            this.aGui.println("This Item is not a Beamer...");
            return ;
        }
        
        //this.aGui.println(vBeamerSameObject.get);
        Beamer vBeamerSameObject = (Beamer)vItem;
        vBeamerSameObject.setRoomSaved(pPlayer.getCurrentRoom());
        this.aGui.println("This room has been saved in the beamer.");
    }
}
