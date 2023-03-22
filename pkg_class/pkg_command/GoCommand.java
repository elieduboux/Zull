package pkg_class.pkg_command;
import pkg_class.Player;
import pkg_class.Command;
/**
 * Implementation of the 'go' user command.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2011.07.31
 */
public class GoCommand extends Command 
{
    /**
     * Constructor for objects of class GoCommand.
     */
    public GoCommand()
    {
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     * Exemple :
     * go 'direction'
     * with:
     *      'direction' -> one of the directions (north,south,east...)
     * @param pPlayer The player doing the action.
     */
    public void execute(final Player pPlayer)
    {
        if(!this.hasSecondWord()) 
        {
            this.aGui.println("Go where?");
            return;
        }
        
        String vDirection = this.getSecondWord();
        String vMessage = pPlayer.walk(vDirection);
        this.aGui.println(vMessage);
        
        if (vMessage.charAt(0) == 'Y')
            this.aGui.printLocationInfo();
        
        if (pPlayer.isEnergyEmpty())
            this.aGui.gameOver();
    }
}
