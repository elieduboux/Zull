package pkg_class.pkg_command;
import pkg_class.Player;
import pkg_class.Command;
import pkg_class.pkg_room.TransporterRoom;
import pkg_class.Room;
/**
 * Implementation of the 'alea' test command.
 * 
 * @author Michael Kolling and David J. Barnes + Elie DUBOUX
 * @version 2011.07.31 + 2021.01
 */
public class AleaCommand extends Command
{    
    /**
     * Constructor for objects of class AleaCommand.
     */
    public AleaCommand()
    {
    }
    
    /**
     * This command is only avaliable in the test mode.
     * It allows to teleport to a specific room even if the player enter the
     * teleport Room.
     * @param pPlayer The player doing the action.
     */
    public void execute(final Player pPlayer)
    {
        TransporterRoom vTransporterRoom = (TransporterRoom)this.getTpRoom("Transporter");    
        if (!vTransporterRoom.isTestMode())
        {
            this.aGui.println("You need to be in the test mode to use this.");
            return;
        }
            
        if (!this.hasSecondWord())
        {
            this.aGui.println("The teleporter's exit is back to normal.");
            vTransporterRoom.setTestRoom(null);
            return;
        }
        
        Room vRoom = this.getTpRoom(this.getSecondWord());

        if (vRoom == null)
        {
            this.aGui.println("This room does not exist in the game.");
            return;
        }
        
        vTransporterRoom.setTestRoom(vRoom);
        this.aGui.println("You will be teleported to "+ vRoom.getName() +
                          " after leaving the teleport room.");
    }
}//AleaCommand()