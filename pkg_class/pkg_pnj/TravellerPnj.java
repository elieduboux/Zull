package pkg_class.pkg_pnj;
import pkg_class.Item;
import pkg_class.Room;
import pkg_class.Pnj;
import pkg_class.Player;
/**
 * Décrivez votre classe TravellerPnj ici.
 *
 * @author Elie DUBOUX
 * @version 2021.01
 */
public class TravellerPnj extends Pnj
{
    /**
     * The feather.
     */
    private Item aFeather;
    /**
     * Check if the pnj has moved.
     */
    private boolean aHasMoved;
    /**
     * The room where the pnj is currently in.
     */
    private Room aCurrentRoom;
    /**
     * Constructor.
     * @param pName The name of the pnj.
     * @param pSpeech The default speech.
     * @param pStartingRoom The room where it appear first.
     * @param pFeather The item "feather".
     */
    public TravellerPnj(final String pName, final String pSpeech,final Room pStartingRoom, final Item pFeather)
    {
        super(pName, pSpeech);
        this.aFeather = pFeather;
        this.aCurrentRoom = pStartingRoom;
        this.aHasMoved = false;
    }//TravellerPnj()
    
    /**
     * Change the room of the traveller.
     * @return The message when he disappear
     */
    public String changeRoom()
    {
        this.aCurrentRoom.removePnj(this);
        this.aCurrentRoom = this.aCurrentRoom.getExit("north");
        this.aCurrentRoom.addPnj(this);
        this.aHasMoved = true;
        this.changeSpeech("OH you found be ... take this gift.");
        return "See you again hehehe. \nHe disappeared while walking through the mist";
    }//changeRoom()
    
    /**
     * Give the player the feather.
     * @param pPlayer The player.
     */
    public void giveFeather(final Player pPlayer)
    {
        if (!pPlayer.hasFeather())
        {
            pPlayer.setHasFeather();
            pPlayer.addItems(this.aFeather, 1);
            this.changeSpeech("For what I have studied, this feather might allows you to transform into something...");
        }
    }//giveFeather()
    
    /**
     * Check if the traveller is still in the starting room.
     * @return True if the traveller has already moved,
     * false otherwise.
     */
    public boolean hasMoved()
    {
        return this.aHasMoved;
    }//getRoom()
}//TravellerPnj
