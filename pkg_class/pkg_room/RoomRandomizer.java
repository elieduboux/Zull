package pkg_class.pkg_room;
import java.util.Random;

/**
 * This class is part of the RPandaScape application. 
 * RPandaScape is a very simple, text based adventure game.
 *
 * @author Elie DUBOUX
 * @version 2021.01.02
 */
public class RoomRandomizer
{
    /**
     * The random class, allows to generate random numbers.
     */
    private Random aRandom;
    /**
     * The number of the rooms in the game.
     */
    private int aNumberRooms;
    /**
     * Constructor
     */
    public RoomRandomizer(final int pNumberRooms)
    {
        this.aNumberRooms = pNumberRooms;
        this.aRandom = new Random(System.currentTimeMillis());
    }//RoomRandomizer()
    
    /**
     * This method return a random integer between 0 and the number of rooms 
     * in the game -1.
     * @return A random index.
     */
    public int randomIndex()
    {
        return aRandom.nextInt(this.aNumberRooms-1);
    }
}//RoomRandomizer
