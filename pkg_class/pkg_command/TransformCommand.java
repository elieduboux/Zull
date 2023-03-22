package pkg_class.pkg_command;
import pkg_class.Player;
import pkg_class.Command;

/**
 * Implementation of the 'transform' user command.
 * 
 * @author Elie DUBOUX
 * @version 2021.01
 */
public class TransformCommand extends Command
{    
    /**
     * Constructor for objects of class TransformCommand.
     */
    public TransformCommand()
    {
    }
    
    /**
     * If used in a dark room, will light it up.
     * @param pPlayer The player doing the action.
     */
    public void execute(final Player pPlayer)
    {
        if (!pPlayer.hasSkill("transform"))
        {
            this.aGui.println("You need the skill 'transform' to use this. You might found it in a very dark room.");
            return ;
        }
        
        if (!pPlayer.hasFeather())
        {
            this.aGui.println("You feel that if you had a feather you could do something incredible... Try to find the traveller.");
            return;
        }
        
        if (!pPlayer.hadFinalSpeech())
        {
            this.aGui.printAdviceFinalSpeech();
            return;
        }
        
        this.aGui.gameWon();
    }

}
