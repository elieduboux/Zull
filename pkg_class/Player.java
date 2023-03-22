package pkg_class;
import pkg_class.pkg_item.ItemList;
import pkg_class.pkg_room.Door;
import pkg_class.pkg_pnj.GuidePnj;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
/**
 * This class is part of the RPandaScape application. 
 * RPandaScape is a very simple, text based adventure game.
 * 
 * The player is defined by his name. 
 * He can carry items (up to a certain weight) and can have money.
 * 
 * The Player class also contains the rooms where he has passed by.
 * 
 * A player also need a certain amont of energy to survie,
 * this ernergie can be replenish with food (edible items).
 *
 * @author Elie DUBOUX
 * @version 2021.12.12
 * @see ItemList
 * @see Room
 */
public class Player
{
    /**
     * The name of the player.
     */
    private String aName;
    /**
     * The maximum weight a player can carry.
     */
    private int aMaxWeight;
    /**
     * The money the player currently have.
     */
    private int aMoney;
    /**
     * The room where the player currently is.
     */
    private Room aCurrentRoom;
    /**
     * The rooms where the player passed by during the game.
     */
    private Stack<Room> aPreviousRooms;
    /**
     * The items that the player carry.
     */
    private ItemList aItems;
    /**
     * The current level of energy.
     */
    private int aCurrentEnergy;
    /**
     * The skills a player has.
     */
    private List<String> aSkills;
    /**
     * Check if the player has already received the feather.
     */
    private boolean aHasFeather;
    /**
     * Check if the player can access to the final dialog.
     */
    private boolean aCanHaveFinalSpeech;
    /**
     * Check if the player has the final dialog.
     */
    private boolean aHadFinalSpeech;
    /**
     * The Guide.
     */
    private GuidePnj aGuide;
    /**
     * Constructor.
     * @param pName The name of the player.
     * @param pWeightMax The maximum weight he can carry.
     * @param pStartingEnergy The energy at the begining.
     */
    public Player(final String pName, final int pWeightMax, final int pStartingEnergy)
    {
        this.aName = pName;
        this.aMaxWeight = pWeightMax;
        this.aMoney = 0;
        this.aPreviousRooms = new Stack<Room>();
        this.aItems = new ItemList();
        this.aCurrentEnergy = pStartingEnergy;
        this.aSkills = new ArrayList<String>();
        this.aHasFeather = false;
        this.aCanHaveFinalSpeech = false;
        this.aHadFinalSpeech = false;
    }//Player()
    
    /**
     * Try to walk in a given direction. If there is a door
     * this will change the player's location.
     * @param pDirection The direction.
     * @return The message that will be printed by the gui.
     */
    public String walk(String pDirection)
    {
        // Try to leave current room.
        Room vNextRoom = this.aCurrentRoom.getExit(pDirection);
        
        if (vNextRoom == null)
            return "It is impossible to go there.";
        if (vNextRoom == Room.UNKNOWN_DIRECTION)
            return "Unknown direction !";
        
        StringBuilder vMessage = new StringBuilder();
        
        //Check if there is a door
        Door vDoor = this.aCurrentRoom.getDoor(pDirection);
        if (vDoor != null)
        {
            if (!this.hasSkill(vDoor.getSkill()))
                return "A skill is needed to pass through here.";
            vMessage.append("You use the skill '" + vDoor.getSkill() + "' to go there.\n");
        }
        
        this.loseEnergy(1);
        if (!vNextRoom.isBackPossible(this.aCurrentRoom))
        {
            vMessage.append("You can't go back from this exit.\n");
            this.clearPreviousRooms();
        }
        else
        {
            vMessage.append("You are going towards "+ pDirection);
            this.pushPreviousRoom(this.aCurrentRoom);
        }
        
        this.setCurrentRoom(vNextRoom);
        
        return vMessage.toString();
    }//walk()
    
    /**
     * The player learn a new skill.
     * @param pSkill The name of the skill.
     */
    public void addSkill(final String pSkill)
    {
        this.aSkills.add(pSkill);
    }//addSkill()
    
    /**
     * Check if the player has learned the skill given in parameter.
     * @param pSkill The skill.
     * @return True if the player has this skill,
     * false if not.
     */
    public boolean hasSkill(final String pSkill)
    {
        return this.aSkills.contains(pSkill);
    }//hasSkill()
    
    /**
     *  Reduce the current level of energy.
     *  @param pEnergyLost The amont of energy lost.
     */
    public void loseEnergy(final int pEnergyLost)
    {
        this.aCurrentEnergy -= pEnergyLost;
    }//loseEnergy()
    
    /**
     *  Replenish some energy.
     *  @param pEnergyGain The amont of energy gained.
     */
    public void gainEnergy(final int pEnergyGain)
    {
        this.aCurrentEnergy += pEnergyGain;
    }//loseEnergy()
    
    /**
     * Check if the current energy of the player is equal to 0.
     * return True if the the energy equals 0,
     * false if not.
     * @return True if the player has no energy left,
     * false otherwise.
     */
    public boolean isEnergyEmpty()
    {
        return this.aCurrentEnergy == 0;
    }//isEnergyEmpty()
    
    /**
     * Add a room in the previousRooms list.
     * @param pPreviousRoom The rooms the player was previously.
     */
    public void pushPreviousRoom(final Room pPreviousRoom)
    {
        this.aPreviousRooms.push(pPreviousRoom);
    }//pushPreviousRoom()
    
    /**
     * Remove the last a room in the previousRooms list.
     * @return The last room the player was previously.
     */
    public Room popPreviousRoom()
    {
        return this.aPreviousRooms.pop();
    }//popPreviousRoom()
    
    /**
     * Check if there is previous rooms.
     * @return True if the previousRooms is empty,
     * false if not.
     */
    public boolean isPreviousRoomsEmpty()
    {
        return this.aPreviousRooms.empty();
    }//isPreviousRoomsEmpty()
    
    /**
     * Remove all the previous room the player went before.
     */
    public void clearPreviousRooms()
    {
        this.aPreviousRooms.clear();
    }//clearPreviousRooms()
    
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
     * Check if it's possible to add the item X time(s).
     * @param pItem The Item.
     * @param pItemNb The number of time.
     * @return True if the items can be added,
     * false if not.
     */
    public boolean isAddPossible(final Item pItem, final int pItemNb)
    {
        return (this.aItems.getWeightTotal()+ pItem.getWeight()*pItemNb) <= this.aMaxWeight;
    }//isAddPossible()
    
    /**
     * Add one item X time(s) in the player inventory.
     * @param pItem The item.
     * @param pItemNb The number of time.
     */
    public void addItems(final Item pItem, final int pItemNb)
    {
        this.aItems.addItems(pItem, pItemNb);
    }//addItems()
    
    /**
     * Remove one item X time(s) in the player inventory.
     * @param pItem The item.
     * @param pItemNb The number of time.
     */
    public void removeItems(final Item pItem, final int pItemNb)
    {
        this.aItems.removeItems(pItem, pItemNb);
    }//removeItems()
    
    /**
     * Change the name of the player.
     * @param pName The new player's name.
     */
    public void setName(final String pName)
    {
        this.aName = pName;
    }//setName()
    
    /**
     * Allow the player to have acces to the guide.
     * Used when it needs to change it's final speech.
     * @param pGuidePnj The guide.
     */
    public void setGuide(final GuidePnj pGuidePnj)
    {
        this.aGuide = pGuidePnj;
    }
    
    /**
     * Change the maximum weight the player can carry.
     * @param pMaxWeight The new maximum weight.
     */
    public void setMaxWeight(final int pMaxWeight)
    {
        this.aMaxWeight = pMaxWeight;
    }//setMaxWeight()
    
    /**
     * Change the room where the player is currently in.
     * @param pCurrentRoom The new room.
     */
    public void setCurrentRoom(final Room pCurrentRoom)
    {
        this.aCurrentRoom = pCurrentRoom;
    }//setCurrentRoom()
    
    /**
     * When the traveller give the feather to the player.
     */
    public void setHasFeather()
    {
        this.aHasFeather = true;
    }//giveFeather
    
    /**
     * The player can now have access to the final speech.
     * It also set the final speech for the guide.
     */
    public void setCanHaveFinalSpeech()
    {
        this.aCanHaveFinalSpeech = true;
        this.aGuide.changeSpeechFinal();
    }
    
    /**
     * Method called when the played has ended the final speech,
     * he can now finish the game.
     */
    public void setHadFinalSpeech()
    {
        this.aHadFinalSpeech = true;
    }

    /**
     * Return the name of the player.
     * @return The player's name.
     */
    public String getName()
    {
        return this.aName;
    }//gteName()
    
    /**
     * Return the room where the player currently is.
     * @return The player's name.
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    }//getCurrentRoom()
    
    /**
     * Return the player's max weight.
     * @return The player's max weight.
     */
    public int getMaxWeight()
    {
        return this.aMaxWeight;
    }//getMaxWeight()
    
    /**
     * Return the item with the name given in parameter.
     * @param pItemName The name of the item.
     * @return The item.
     */
    public Item getItem(final String pItemName)
    {
        return this.aItems.getItem(pItemName);
    }//getItem()
    
    /**
     *  Return the current level of energy.
     *  @return The current energy.
     */
    public int getCurrentEnergy()
    {
        return this.aCurrentEnergy;
    }//getEnergyMax()
    
    /**
     *  Check if the traveller has given the feather to the player.
     *  @return True if the player has already recieved the feather,
     *  false otherwise.
     */
    public boolean hasFeather()
    {
        return this.aHasFeather;
    }//hasFeather()
    
    /**
     * Check if the player can have access to the final speech.
     * @return True if The player can have the final speech,
     * false otherwise.
     */
    public boolean canHaveFinalSpeech()
    {
        return this.aCanHaveFinalSpeech;
    }
    
    /**
     * Check if the player has already had the final speech.
     * @return True if the player had already done it,
     * false otherwise.
     */
    public boolean hadFinalSpeech()
    {
        return this.aHadFinalSpeech;
    }
       
    /**
     * Return the inventory of the player as a String.
     * @return The items with their number.
     */
    public String getItemsString()
    {
        return "The items you carry :\n" + this.aItems.toString() +
               "The weight you carry / The max you can have: " + this.aItems.getWeightTotal() +" / " + this.aMaxWeight + "\n" + 
               "The money you have : "+ this.aMoney + "\n";
    }//getItemsString()
}//Player
