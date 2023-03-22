package pkg_class.pkg_command;
import pkg_class.Player;
import pkg_class.Command;
import pkg_class.pkg_room.DarkRoom;
/**
 * Implementation of the 'light' user command.
 * 
 * @author Elie DUBOUX
 * @version 2021.01
 */
public class LightCommand extends Command
{    
    /**
     * Constructor for objects of class LightCommand.
     */
    public LightCommand()
    {
    }
    
    /**
     * If used in a dark room, will light it up.
     * @param pPlayer The player doing the action.
     */
    public void execute(final Player pPlayer)
    {
        if (!pPlayer.hasSkill("light"))
        {
            this.aGui.println("You need the skill 'light' to use this. Can be bought in the shop.");
        }
        DarkRoom vDarkRoomClass = new DarkRoom();
        if (pPlayer.getCurrentRoom().getClass() != vDarkRoomClass.getClass())
        {
            this.aGui.println("You emit a light ... nothing append.");
            return;
        }
        this.aGui.println("Now you can see your surronding.");
        DarkRoom vDarkRoom = (DarkRoom) pPlayer.getCurrentRoom();
        vDarkRoom.setNotDark();
        this.aGui.printLocationInfo();
    }

}
