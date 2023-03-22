package pkg_class.pkg_pnj;
import pkg_class.Pnj;

/**
 * Décrivez votre classe GuidePnj ici.
 *
 * @author Duboux Elie
 * @version 2021.01
 */
public class GuidePnj extends Pnj
{
    /**
     * Constructor
     * @param pName The name of the pnj.
     * @param pSpeech The text the pnj will tell to the player.
     */
    public GuidePnj(final String pName, final String pSpeech)
    {
        super(pName,pSpeech);
    }
    
    public void changeSpeechFinal()
    {
        this.aSpeechs.clear();
        this.addSpeech("If you have the goldly feather in your inventory...\nYou can now transform into a phoenix and fly away from here !!!");
    }
}
