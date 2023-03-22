package pkg_class;
import java.util.List;
import java.util.ArrayList;
/**
 * ...
 *
 * @author Elie DUBOUX
 * @version (un numéro de version ou une date)
 */
public class Pnj
{
    /**
     * The name of the pnj.
     */
    private String aName;
    /**
     * His speech when the player talk to him.
     */
    protected List<String> aSpeechs;
    /**
     * Constructor
     * @param pName The name of the pnj.
     * @param pSpeech The text the pnj will tell to the player.
     */
    public Pnj(final String pName, final String pSpeech)
    {
        this.aName = pName;
        this.aSpeechs = new ArrayList<String>();
        this.aSpeechs.add(pSpeech);
    }//PNJ()
    
    /**
     * Constructor with a basic speech.
     * @param pName The name of the pnj.
     */
    public Pnj(final String pName)
    {
        this(pName,"blah, blah, blah...");
    }//PNJ()
    
    /**
     * Remove the speech at this index.
     * @param pIndex The index of the speech.
     */
    public void removeSpeech(final int pIndex)
    {
        this.aSpeechs.remove(pIndex);
    }//removeSpeech()
    
    /**
     * Add a new speech to the pnj.
     * @param pNewSpeech The new speech.
     */
    public void addSpeech(final String pNewSpeech)
    {
        this.aSpeechs.add(pNewSpeech);
    }//setSpeech()
    
    /**
     * Change the String 
     * @param pString The new string.
     */
    public void changeSpeech(final String pString)
    {
        this.removeSpeech(0);
        this.addSpeech(pString);
    }//changeSpeech()
    
    /**
     * Return the first speech of the pnj.
     * @return The speech.
     */
    public String getFirstSpeech()
    {
        return this.aSpeechs.get(0);
    }//getSpeech()
    
    /**
     * Try to look for the corresponding speech in the pnj's
     * speech list.
     * Return a message error if no speech has been found for this index.
     * @param pIndex The index.
     * @return The speech or message error.
     */
    public String getSpeechIndex(final int pIndex)
    {
        String vChaine = "";
        try
        {
            vChaine = this.aSpeechs.get(pIndex);
        }
        catch(Exception e)
        {
            vChaine = "No speech found for this number... try the \"look <PNJ name>\" command to see them. ";
        }
        finally
        {
            return vChaine;
        }
    }//getSpeechIndex()
    
    /**
     * Return the name of the pnj.
     * @return The name.
     */
    public String getName()
    {
        return this.aName;
    }//getName()
    
    /**
     * Return the speechs of the pnj.
     * @return The speechs of the pnj.
     */
    public String getSpeechsString()
    {
        StringBuilder vSpeechs = new StringBuilder("Speechs of "+this.aName+" :\n");
        for (int i=0; i<this.aSpeechs.size();i++)
            vSpeechs.append(i+" -> "+this.aSpeechs.get(i)+"\n");
        return vSpeechs.toString();
    }//getSpeechs()
}//Pnj
