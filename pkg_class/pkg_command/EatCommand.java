package pkg_class.pkg_command;
import pkg_class.Player;
import pkg_class.Command;
import pkg_class.pkg_item.ItemEdible;
/**
 * Implementation of the 'eat' user command.
 * 
 * @author Michael Kolling and David J. Barnes + Elie DUBOUX
 * @version 2011.07.31 + 2021.01
 */
public class EatCommand extends Command
{    
    /**
     * Constructor for objects of class HelpCommand.
     */
    public EatCommand()
    {
    }
    
    /**
     * Do a specific action when the caracter eat an item a certain
     * number of time.
     * Exemple :
     * > eat 'Item' 'X'
     * with :
     *      'Item' -> The name of the Item
     *      'X'    -> The number of time
     * @param pPlayer The player doing the action.
     */
    public void execute(final Player pPlayer)
    {
        if (!this.hasSecondWord())
        {
            this.aGui.println("Eat what ?");
            return ;
        }

        ItemEdible vItem = (ItemEdible)pPlayer.getItem(this.getSecondWord().toLowerCase());
        
        if (vItem == null)
        {
            this.aGui.println("I don't understand what you want to eat...");
            return ;
        }
        
        int vNb = this.getThirdWordNumber();
        
        if (!pPlayer.isRemovePossible(vItem, vNb))
        {
            this.aGui.println("You don't have enough items to eat...");
            return;
        }
        
        switch (vItem.getName())
        {
            case "cookie":
                pPlayer.gainEnergy(vNb);
                pPlayer.setMaxWeight(pPlayer.getMaxWeight()*2);
                pPlayer.removeItems(vItem, vNb);
                this.aGui.println("You feel stronger!!! (and appreciated greatly this divine gift)");
                break;
            case "apple" :
                pPlayer.gainEnergy(vNb);
                this.aGui.println("Huuuum yummy and sweet! +"+ vNb +" energy");
                pPlayer.removeItems(vItem, vNb);
                break;
            case "bamboo":
                pPlayer.gainEnergy(vNb);
                this.aGui.println("*nom nom nom* +"+ vNb +" energy");
                pPlayer.removeItems(vItem, vNb);
                break;
            case "root":
                pPlayer.gainEnergy(vNb);
                this.aGui.println("... Not that good but it's better than nothing... +"+ vNb +" energy");
                pPlayer.removeItems(vItem, vNb);
                break;
            default :
                this.aGui.println("I know that you are hungry but this Item is not edible...");
        }
        this.aGui.println("The energy you have now : " + pPlayer.getCurrentEnergy());
    }
}
