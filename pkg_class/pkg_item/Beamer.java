package pkg_class.pkg_item;
import pkg_class.Item;
import pkg_class.Room;

/**
 * This class is part of the RPandaScape application. 
 * RPandaScape is a very simple, text based adventure game.
 * 
 * The Beamer is an item that has special uses.
 * It has 2 functions :
 * save -> that save a room
 * fire -> that teleport the owner of the item to the room saved.
 *
 * @author Elie DUBOUX
 * @version 2021.01
 */
public class Beamer extends Item
{
    /**
     * The room saved, is null after been fired.
     */
    private Room aRoomSaved;
    
    /**
     * Constructor.
     */
    public Beamer(final String pName, final String pDescription, final int pWeight,
                final int pPrice)
    {
        super(pName,pDescription, pWeight,pPrice);
        this.aRoomSaved = null;
    }//Beamer()
    
    /**
     * Default constructor.
     */
    public Beamer()
    {
        super("","",0,0);
    }//Beamer()
    
    /**
     * Return if the beamer is charged or not.
     * @return True if the beamer is charged,
     * fals if not.
     */
    public boolean getIsCharged()
    {
        return aRoomSaved != null;
    }//getIsCharged()
    
    /**
     *  Change the room saved by the beamer.
     *  @param pRoomSaved The new room saved.
     */
    public void setRoomSaved(final Room pRoomSaved)
    {
        this.aRoomSaved = pRoomSaved;
    }//setRoomSaved()
    
    /**
     * Return the room saved by the beamer.
     * @return The room saved.
     */
    public Room getRoomSaved()
    {
        return this.aRoomSaved;
    }//getRoomSaved()
}//Beamer
