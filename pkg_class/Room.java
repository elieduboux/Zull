package pkg_class;
import pkg_class.pkg_room.Door;
import pkg_class.pkg_item.ItemList;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Arrays;

/**
 * This class is part of the RPandaScape application. 
 * RPandaScape is a very simple, text based adventure game.  
 * 
 * A "Room" represents one location in the scenery of the game. It is 
 * connected to other rooms via exits. For each existing exit, the room 
 * stores a reference to the neighboring room.
 * All the rooms have an ItemList that can be composed of Items.
 * 
 * @author Elie DUBOUX
 * @version 2021.12.12
 * @see ItemList
 */
public class Room
{
    /**
     * The name.
     */
    protected String aName;
    /**
     * The description.
     */
    protected String aDescription;
    /**
     * The exits.
     */
    private HashMap<String, Room> aExits;
    /**
     * The doors.
     */
    private HashMap<String, Door> aDoors;
    /**
     * The path to the image.
     */
    protected String aImage;
    /**
     * The items.
     */
    protected ItemList aItems;
    /**
     * The Pnjs
     */
    private HashMap<String,Pnj> aPnjs;
    /**
     * The directions possible.
     */
    protected String[] aDirectionsPossible;
    /**
     * Room empty.
     */
    public static final Room UNKNOWN_DIRECTION = new Room("", "", null);

    /**
     * Create a room described "description" with an image. Initially, it has
     * no exits.
     * @param pName The name of the room.
     * @param pDescription The room's description.
     * @param pImage The path to the image of the room.
     */
    public Room(final String pName, final String pDescription, final String pImage)
    {
        this.aName        = pName;
        this.aDescription = pDescription;
        this.aExits       = new HashMap<String, Room>();
        this.aDoors       = new HashMap<String, Door>();
        this.aPnjs        = new HashMap<String, Pnj >();
        this.aImage       = pImage;
        this.aItems       = new ItemList();
        this.aDirectionsPossible = new String[]{"north", "south", "east", "west", "up", "down"};
    }//Room()
    
    /**
     * Check if there are pnj in the room.
     * @return True if there is no pnj in the room,
     * false otherwise.
     */
    public boolean isPnjsEmpty()
    {
        return this.aPnjs.isEmpty();
    }//isPnjsEmpty()
    
    /**
     * Check if there is only one pnj in the room.
     * @return True if there is only one,
     * false otherwise.
     */
    public boolean isOnePnj()
    {
        return this.aPnjs.size() == 1;
    }//isOnePnj()
    
    /**
     * Add a new pnj to the room.
     * @param pPnj The pnj.
     */
    public void addPnj(final Pnj pPnj)
    {
        this.aPnjs.put(pPnj.getName(), pPnj);
    }//addPnj()
    
    /**
     * Remove a given pnj from the room.
     * @param pPnj The pnj.
     */
    public void removePnj(final Pnj pPnj)
    {
        this.aPnjs.remove(pPnj.getName());
    }//removePnj()
    
    /**
     * Check if the room is a trap door.
     * @param pPreviousRoom The previous room.
     * @return True if the player can go back to the previous room,
     * false otherwise.
     */
    public boolean isBackPossible(final Room pPreviousRoom)
    {
        for (Room vRoom : this.aExits.values())
            if (vRoom == pPreviousRoom)
                return true;
        return false;
    }//isBackPossible()
    
    /**
     * Check if it's possible to remove the item X time(s).
     * @param pItem The Item.
     * @param pItemNb The number of time.
     * @return True if the items can be removed,
     * false if not.
     */
    public boolean isRemovePossible(final Item pItem, final int pItemNb)
    {
        return this.aItems.hasEnough(pItem, pItemNb);
    }//isRemovePossible()
    
    /**
     * Add an item X time(s) to the room.
     * @param pItem The item.
     * @param pItemNb The number of the item added.
     */
    public void addItems(final Item pItem, final int pItemNb)
    {
        this.aItems.addItems(pItem, pItemNb);
    }//addItem()
    
    /**
     * Remove an item X time(s) to the room.
     * @param pItem The item.
     * @param pItemNb The number of the item added.
     */
    public void removeItems(final Item pItem, final int pItemNb)
    {
        this.aItems.removeItems(pItem, pItemNb);
    }//removeItems()
    
    /**
     * Get the item by giving his name.
     * @param pItemName The name of the item.
     * @return The item.
     */
    public Item getItem(final String pItemName)
    {
        return this.aItems.getItem(pItemName);
    }//getItem()
    
    /**
     * Add the given neighbor room in the given direction.
     * @param pDirection The direction.
     * @param pNeighbor The neighbor.
     */
    public void setExit(final String pDirection, final Room pNeighbor)
    {
        this.aExits.put(pDirection, pNeighbor);
    }//setExit()
    
    /**
     * Add a door in the given direction.
     * @param pDirection The direction.
     * @param pDoor The Door.
     */
    public void setDoor(final String pDirection, final Door pDoor)
    {
        this.aDoors.put(pDirection, pDoor);
    }//setExit()
    
    /**
     * Allows other classes to get the exit of the room in the given direction.
     * @param pDirection The direction.
     * @return The exit is a room but can be also UNKNOWN_DIRECTION or null.
     */
    public Room getExit(final String pDirection)
    {
        // the case where the direction is not "north", "south", "east", "west", "up" or "down".
        if (!Arrays.asList(this.aDirectionsPossible).contains(pDirection))
            return UNKNOWN_DIRECTION;
            
        return this.aExits.get(pDirection);
    }//getExit
    
    /**
     * Return the door in the given direction.
     * @param pDirection The given direction.
     * @return The door.
     */
    public Door getDoor(final String pDirection)
    {
        return this.aDoors.get(pDirection);
    }
    
    /**
     * Return the short description of the room.
     * @return The short description.
     */
    public String getShortDescription()
    {
        return this.aDescription;
    }//getShortDescription()
    
    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    public String getExitString()
    {
        StringBuilder vExits = new StringBuilder("Exits:");
        for (String vOneExit : this.aExits.keySet())
            vExits.append(" " + vOneExit);
            
        return vExits.toString();
    }//getExitString()
    
    /**
     * Return a string describing the items in the room.
     * @return Details of the room's items.
     */
    public String getItemsString()
    {
        return "Items in the room :\n" + this.aItems.toString();
    }//getItemString()
    
    /**
     * Return the room"s pnjs.
     * @return Details of the room's pnjs
     */
    public String getPnjsString()
    {
        if (this.isPnjsEmpty())
            return "There is no pnj in this room.";
        
        StringBuilder vPnjs = new StringBuilder("Pnj(s) in the room:");
        for (String vPnjName : this.aPnjs.keySet())
            vPnjs.append(" " + vPnjName);
            
        return vPnjs.toString();
    }//getPnjsString()
    
    /**
     * Return a long description of this room, of the form :
     *      You are near a little lake with a waterfall.
     *      Item(s) : seaweed(2) daisy(10)
     *      Exits : south west
     * 
     * @return A description of the room, including exits and items.
     */
    public String getLongDescription()
    {
        return ("You are at the " + this.aName + " room." +
                "\n" + this.aDescription + 
                "\n" + this.getItemsString() +
                "\n" + this.getPnjsString()+
                "\n" + this.getExitString()) ;
    }//getLongDescription()
    
    /**
     * Return a string describing the room's image name
     * @return The path to the image.
     */
    public String getImage()
    {
        return this.aImage;
    }//getImageName()
    
    /**
     * Return the name of the room.
     * @return The name of the room.
     */
    public String getName()
    {
        return this.aName;
    }//getName()
    
    /**
     * Return the pnj with the name given.
     * Can be null.
     * @param pPnjName The given name.
     * @return The pnj.
     */
    public Pnj getPnj(final String pPnjName)
    {
        return this.aPnjs.get(pPnjName);
    }//getPnj()
    
    /**
     * Method called when there is only one pnj.
     * Return the pnj.
     * @return The pnj.
     */
    public Pnj getPnj()
    {
        Entry<String,Pnj> vEntry = this.aPnjs.entrySet().iterator().next();
        return vEntry.getValue();
    }//getPnj()
} // Room
