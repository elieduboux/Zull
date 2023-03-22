package pkg_class.pkg_command;
import pkg_class.Player;
import pkg_class.Command;
/**
 * Implementation of the 'back' user command.
 * 
 * @author Michael Kolling and David J. Barnes + Elie DUBOUX
 * @version 2011.07.31 + 2021.01
 */
public class BackCommand extends Command
{    
    /**
     * Constructor for objects of class BackCommand.
     */
    public BackCommand()
    {
    }
    
    /**
     * Go back to the previous room.
     * @param pPlayer The player doing the action.
     */
    public void execute(final Player pPlayer)
    {
        if (pPlayer.isPreviousRoomsEmpty())
        {
            this.aGui.println("You need to do a 'go' command in order to go back!");
            return;
        }
        pPlayer.loseEnergy(1);
        pPlayer.setCurrentRoom(pPlayer.popPreviousRoom());
        this.aGui.printLocationInfo();
        if (pPlayer.isEnergyEmpty())
            this.aGui.gameOver();
    }
}
