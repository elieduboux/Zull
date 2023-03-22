package pkg_class.pkg_command;
import pkg_class.Player;
import pkg_class.Command;
import pkg_class.Pnj;
import pkg_class.pkg_pnj.TravellerPnj;
import pkg_class.pkg_pnj.GuidePnj;
/**
 * Implementation of the 'talk' user command.
 * 
 * @author Michael Kolling and David J. Barnes + Elie DUBOUX
 * @version 2011.07.31 + 2021.01
 */
public class TalkCommand extends Command
{    
    /**
     * Constructor for objects of class TalkCommand.
     */
    public TalkCommand()
    {
    }
    
    /**
     * Allows the player to talk to a PNJ.
     * @param pPlayer The player doing the action.
     */
    public void execute(final Player pPlayer)
    {
        if (pPlayer.getCurrentRoom().isPnjsEmpty())
        {
            this.aGui.println("There is no one to talk to here...");
            return ;
        }
        
        Pnj vPnj = pPlayer.getCurrentRoom().getPnj();
        if (pPlayer.getCurrentRoom().isOnePnj())
        {
            this.discussion(vPnj.getSpeechIndex(this.getThirdWordNumber()), vPnj, pPlayer);
            return;
        }
        
        if (!this.hasSecondWord())
        {
            this.aGui.println("Who do you want to talk to ?");
            return;
        }
        
        vPnj = pPlayer.getCurrentRoom().getPnj(this.getSecondWord());
        if (vPnj == null)
        {
            this.aGui.println("There is no pnj with that name here...");
            return;
        }
        
        this.discussion(vPnj.getSpeechIndex(this.getThirdWordNumber()), vPnj, pPlayer);
    }
    
    private void discussion(final String pString, final Pnj pPnj, final Player pPlayer)
    {
        this.aGui.println("You engage the conversation...");
        
        this.aGui.println(pString);
        
        GuidePnj vGuidePnjClass = new GuidePnj(null,null);
        if (pPnj.getClass() == vGuidePnjClass.getClass())
        {    
            if (pPlayer.canHaveFinalSpeech())
                pPlayer.setHadFinalSpeech();
        }
        
        TravellerPnj vTravellerPnjClass = new TravellerPnj(null, null, null, null);
        if (pPnj.getClass() == vTravellerPnjClass.getClass())
        {
            TravellerPnj vTravellerPnj = (TravellerPnj) pPnj;
            if (!vTravellerPnj.hasMoved())
                this.aGui.println(vTravellerPnj.changeRoom());
            else if (!pPlayer.hasFeather())
            {
                vTravellerPnj.giveFeather(pPlayer);
                vTravellerPnj.changeSpeech("I found it in a really dark room, maybe there is something usefull there.");
                this.aGui.println("<<< You obteined a very beautiful feather. >>>");;
            }
            if (pPlayer.canHaveFinalSpeech())
                this.aGui.printAdviceFinalSpeech();
        }
    }
    
    @Override public int getThirdWordNumber()
    {
        if (!this.hasThirdWord())
            return 0;
        
        int d = 0;
        try 
        {
            d = Integer.parseInt(this.getThirdWord());
        }
        catch (NumberFormatException e) 
        {
            d = 0;
        }
        finally
        {
            return d;
        }
    }
}
