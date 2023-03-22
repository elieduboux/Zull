package pkg_class.pkg_command;
import pkg_class.Player;
import pkg_class.Command;
import pkg_class.Item;
import pkg_class.pkg_item.SkillBook;
/**
 * Implementation of the 'learn' user command.
 * 
 * @author Michael Kolling and David J. Barnes + Elie DUBOUX
 * @version 2011.07.31 + 2021.01
 */
public class LearnCommand extends Command
{    
    /**
     * Constructor for objects of class LearnCommand.
     */
    public LearnCommand()
    {
    }
    
    /**
     * Allows a player to learn a new skill if it posses the skillBook.
     * @param pCommand The command typed by the player.
     */
    public void execute(final Player pPlayer)
    {
        if (!this.hasSecondWord())
        {
            this.aGui.println("What do you want to learn?");
            return;
        }
        
        Item vItem = pPlayer.getItem(this.getSecondWord());
        if (vItem == null)
        {
            this.aGui.println("You need to posses the skill book in order to learn it.");
            return;
        }
        
        SkillBook vSkillBookClass = new SkillBook();
        if ( vItem.getClass() != vSkillBookClass.getClass())
        {
            this.aGui.println("This Item is not a skill book...");
            return ;
        }
        
        this.aGui.println("You have learned the skill -> " + vItem.getName());
        this.aGui.println(vItem.getDescription());
        pPlayer.addSkill(vItem.getName());
        pPlayer.removeItems(vItem, 1);
        
        if (vItem.getName().equals("transform"))
        {
            if (pPlayer.hasFeather())
            {
                pPlayer.setCanHaveFinalSpeech();
                this.aGui.printAdviceFinalSpeech();
            }
        }
    }//learn()
}
