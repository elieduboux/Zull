package pkg_class.pkg_room;
import pkg_class.Room;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is part of the RPandaScape application. 
 * RPandaScape is a very simple, text based adventure game.
 *
 * @author Elie DUBOUX
 * @version 2021.01
 */
public class TransporterRoom extends Room
{
    /**
     * The list of the rooms in the game.
     */
    private List<Room> aRooms;
    /**
     * The randomizer, generate a random index in the aRooms.
     */
    private RoomRandomizer aRoomRandomizer;
    /**
     * The room selected, in test mode only.
     */
    private Room aTestRoom;
    /**
     * Is in test mode.
     */
    private boolean aIsTestMode;
    /**
     * Constructeur d'objets de classe TransporterRoom
     */
    public TransporterRoom(final String pName, final String pDescription, final String pImage, final List<Room> pRooms)
    {
        super(pName, pDescription, pImage);
        this.aRooms = new ArrayList<Room>();
        this.aRooms.addAll(pRooms);
        this.aRoomRandomizer = new RoomRandomizer(this.aRooms.size());
        this.aTestRoom = null;
        this.aIsTestMode = false;
    }//TransporterRoom()
    
    /**
     * Override of the getExit method herited by the Room class.
     * It returns a random room, the parameter is not needed in fact.
     * @param pDirection Unused parameter.
     * @return The random room.
     */
    @Override public Room getExit(final String pDirection)
    {
        if (this.aIsTestMode)
            return this.aTestRoom;
        if (!Arrays.asList(this.aDirectionsPossible).contains(pDirection))
            return (UNKNOWN_DIRECTION);
        return this.aRooms.get(this.aRoomRandomizer.randomIndex());
    }//getExit()
    
    /**
     * Change the value of the test room.
     * @param pNoRandomRoom The new room.
     */
    public void setTestRoom(final Room pTestRoom)
    {
        this.aTestRoom = pTestRoom;
    }//setNoRandomRoom
    
    public void setTestMode(final boolean pTestMode)
    {
        this.aIsTestMode = pTestMode;
    }
    
    public boolean isTestMode()
    {
        return this.aIsTestMode;
    }
}//TransporterRoom
