package pkg_class;

import pkg_class.pkg_command.CommandWords;
import pkg_class.pkg_item.ItemEdible;
import pkg_class.pkg_item.SkillBook;
import pkg_class.pkg_item.Beamer;
import pkg_class.pkg_room.DarkRoom;
import pkg_class.pkg_room.TransporterRoom;
import pkg_class.pkg_room.Door;
import pkg_class.pkg_pnj.TravellerPnj;
import pkg_class.pkg_pnj.GuidePnj;
import java.util.List;
import java.util.ArrayList;

/**
 * Décrivez votre classe GameModel ici.
 *
 * @author Poul Henriksen + Elie DUBOUX
 * @version 2005.02 + 2021.01
 */
public class GameModel
{
    /**
     * The player.
     */
    private Player aPlayer;
    /**
     * The rooms of the game.
     */
    private List<Room> aRooms;
    /**
     * The items of the game.
     */
    private List<Item> aItems;
    /**
     * The command words.
     */
    private CommandWords aCommandWords;
    /**
     * Constructeur d'objets de classe GameModel
     */
    public GameModel()
    {
        this.aPlayer       = new Player("", 10, 20);
        this.aRooms        = new ArrayList<Room>();
        this.aItems        = new ArrayList<Item>();
        this.aCommandWords = new CommandWords();
        this.initialiseRoomsAndItems();
    }
    
    /**
     * This method create the rooms and set their exits.
     * Is called in the constructor.
     */
    private void initialiseRoomsAndItems()
    {
        //Create the items as (name, description, weight, price)
        Item vFeather  = new Item("feather","A mysterious feather, you feel a strange power coming from it.",
                                        0, 20);
        Item vDaisy    = new Item("daisy","Common flower that you can find near water.",
                                        1, 1);
        Item vMoss     = new Item("moss","Common plant that grows on the Spawn.",
                                        1, 1);
        Item vSeaWeed  = new Item("seaweed", "Plant that you can find underwater.",
                                        1, 4);
        //Edible Items
        ItemEdible vBamboo   = new ItemEdible("bamboo","Edible, given by the humans near the fence.",
                                        2, 0);
        ItemEdible vApple    = new ItemEdible("apple","Edible, you can buy some in the shop.",
                                        2, 5);
        ItemEdible vRoot     = new ItemEdible("root","Edible, you can find those near trees.",
                                        2, 1);
        ItemEdible vCookie   = new ItemEdible("cookie", "Edible, increase the maximum weight you can carry.",
                                        0, 10);
        //Skill books
        SkillBook vSkillBookClimb     = new SkillBook("climb","Allows you to climb the giant tree.",
                                        1, 0);
        SkillBook vSkillBookShrink    = new SkillBook("shrink","Allows you to slip through little holes.",
                                        1, 0);
        SkillBook vSkillBookSwim      = new SkillBook("swim","Allows you to swim without drowing.",
                                        1, 0);
        SkillBook vSkillBookLight     = new SkillBook("light","Allows you to emit light when you are in a dark room.",
                                        1, 0);
        SkillBook vSkillBookTransform = new SkillBook("transform","Allows you to transform in an other animal.",
                                        1, 0);
        //Special items              
        Beamer vBeamer = new Beamer("beamer","Allows you to 'charge' a room and 'fire' to teleport the player there.",
                                        1, 0);
        //Complete the list of items
        this.aItems.add(vFeather);       this.aItems.add(vDaisy);
        this.aItems.add(vMoss);          this.aItems.add(vSeaWeed);
        this.aItems.add(vBamboo);        this.aItems.add(vApple);
        this.aItems.add(vRoot);          this.aItems.add(vCookie);
        this.aItems.add(vSkillBookClimb);this.aItems.add(vSkillBookShrink);
        this.aItems.add(vSkillBookSwim); this.aItems.add(vSkillBookTransform);
        this.aItems.add(vBeamer);
        
        //Create the rooms
        Room vSpawnRoom        = new Room("Spawn","A flat space in the middle of the cage.", 
                                "spawn.jpg");
        Room vFenceRoom        = new Room("Fence", "A tall fence covered with barbed wire is in front of you.",
                                "fence.jpg");
        Room vLakeRoom         = new Room("Lake","A peacefull little lake with a waterfall that goes underground.", 
                                "lake_ext.jpg");
        Room vRockRoom         = new Room("Rock","A giant rock covered with moss.", 
                                "rock.jpg");
        Room vHutRoom          = new Room("Hut","next to an old hut, the door is close and no body seems to live here.",
                                "old_hut.jpg");
        Room vTreeRoom         = new Room("Tree","in front of a giant tree covered with vines that fall to the ground.",
                                "tree.jpg");
        Room vTreePlatformRoom = new Room("Platform","at the upper part of the tree.",
                                "platform.jpg");
        Room vShopRoom         = new Room("Shop","in the shop of the red pandas.", 
                                "hut_1_ext.jpg");
        Room vHouseRoom        = new Room("House","in one of the house of the red pandas.", 
                                "hut_2.jpg");
        Room vHoleRoom         = new Room("Hole","inside the hole, you can't go up but you see a dark tunnel.",
                                "hole.jpg");
        Room vWaterfallRoom    = new Room("Waterfall","in front of a waterfall, you seem to see the surface though it.",
                                "waterfall.jpg");
        DarkRoom vTunnelRoom   = new DarkRoom("Tunnel","It looks like ruins from an ancient civilisation.",
                                "tunnel.jpg");
        
        //Complete the list of the rooms
        this.aRooms.add(vSpawnRoom);       this.aRooms.add(vFenceRoom);
        this.aRooms.add(vLakeRoom);        this.aRooms.add(vRockRoom);
        this.aRooms.add(vHutRoom);         this.aRooms.add(vTreeRoom);
        this.aRooms.add(vTreePlatformRoom);this.aRooms.add(vShopRoom);
        this.aRooms.add(vHouseRoom);       this.aRooms.add(vHoleRoom);
        this.aRooms.add(vTunnelRoom);      this.aRooms.add(vWaterfallRoom);
        
        //The TeleporterRoom
        TransporterRoom vTransporterRoom = new TransporterRoom("Transporter", "surronded by an heavy mist that came suddenly as if it was magical.",
                                "transporter.jpg",  this.aRooms);
        this.aRooms.add(vTransporterRoom);
        
        //Create the PNJs
        Pnj vMerchant  = new Pnj("merchant", "Hey wanna get some new stuff ^^");
        TravellerPnj vTraveller = new TravellerPnj("traveller","Congratulation you fond me, if you can catch me once more ... you'll give you something.",
                                        vTransporterRoom, vFeather);
        GuidePnj vGuide     = new GuidePnj("guide","Hello... blah, blah, blah");
        this.aPlayer.setGuide(vGuide);
        
        //Initialise the items in the rooms
        vSpawnRoom.addItems(vMoss, 3);
        vLakeRoom.addItems(vDaisy, 10);
        vLakeRoom.addItems(vSeaWeed, 3);
        vFenceRoom.addItems(vBamboo, 10);
        vFenceRoom.addItems(vRoot, 2);
        vRockRoom.addItems(vCookie, 1);
        vHutRoom.addItems(vRoot, 2);
        vTreeRoom.addItems(vRoot, 2);
        vTreeRoom.addItems(vSkillBookClimb, 1);
        vShopRoom.addItems(vApple, 100);
        vShopRoom.addItems(vSkillBookShrink, 1);
        vShopRoom.addItems(vSkillBookLight, 1);
        vHouseRoom.addItems(vBeamer,1);
        vHoleRoom.addItems(vSkillBookSwim, 1);
        vTunnelRoom.addItems(vSkillBookTransform, 1);
        vWaterfallRoom.addItems(vSeaWeed, 5);
        
        //Add the pnjs
        vSpawnRoom.addPnj(vGuide);
        vShopRoom.addPnj(vMerchant);
        vTransporterRoom.addPnj(vTraveller);
        
        //Initialise room exits
        vSpawnRoom.setExit("north", vLakeRoom);
        vSpawnRoom.setExit("south", vFenceRoom);
        vSpawnRoom.setExit("east", vRockRoom);
        vSpawnRoom.setExit("west",vTreeRoom);
        vFenceRoom.setExit("north", vSpawnRoom);
        vLakeRoom.setExit("south", vSpawnRoom);
        vLakeRoom.setExit("west", vHutRoom);
        vLakeRoom.setExit("down", vWaterfallRoom);
        vRockRoom.setExit("west", vSpawnRoom);
        vRockRoom.setExit("down", vHoleRoom);
        vHutRoom.setExit("south", vTreeRoom);
        vHutRoom.setExit("east", vLakeRoom);
        vTreeRoom.setExit("north", vHutRoom);
        vTreeRoom.setExit("east", vSpawnRoom);
        vTreeRoom.setExit("up", vTreePlatformRoom);
        vTreePlatformRoom.setExit("down", vTreeRoom);
        vTreePlatformRoom.setExit("north", vHouseRoom);
        vTreePlatformRoom.setExit("east", vShopRoom);
        vShopRoom.setExit("west", vTreePlatformRoom);
        vHouseRoom.setExit("south", vTreePlatformRoom);
        vHouseRoom.setExit("east", vTransporterRoom);
        vHoleRoom.setExit("west", vTunnelRoom);
        vTunnelRoom.setExit("east", vHoleRoom);
        vTunnelRoom.setExit("north", vWaterfallRoom);
        vWaterfallRoom.setExit("south", vTunnelRoom);
        vWaterfallRoom.setExit("up", vLakeRoom);
        
        //Create the Doors
        Door vDoorClimb = new Door("climb");
        Door vDoorPush = new Door("shrink");
        Door vDoorSwim = new Door("swim");
        
        //Initialise the doors
        vTreeRoom.setDoor("up", vDoorClimb );
        vTreePlatformRoom.setDoor("down", vDoorClimb);
        vRockRoom.setDoor("down", vDoorPush);
        vWaterfallRoom.setDoor("up", vDoorSwim);
        vLakeRoom.setDoor("down", vDoorSwim);
        
        // the game start at the spawn
        this.aPlayer.setCurrentRoom(vSpawnRoom);
    }//initialiseRoomsAndItems()
    
    /**
     * Return the player.
     * @return The player
     */
    public Player getPlayer()
    {
        return this.aPlayer;
    }//getPlayer()
    
    /**
     * Return the rooms.
     * @return The rooms.
     */
    public List<Room> getRooms()
    {
        return this.aRooms;
    }//getRooms()
    
    /**
     * Return the welcome string.
     * @return The welcome string.
     */
    public String getWelcomeString() 
    {
        return "\n\nWelcome to RPandaScape!\n" +
                "RPandaScape is a new, fantastic adventure. enjoy :)\n"+
                "Type 'help' if you need help.\n";
    }//getWelcomeString()
    
    /**
     * Return the goodbye string.
     * @return The goodbye string. 
     */
    public String getGoodByeString()
    {
        return "Thank you for playing.  Good bye.";
    }//getGoodByeString()
    
    /**
     * Return the help string.
     * @return The help string. 
     */
    public String getHelpString()
    {
        return "You don't really know what to do...\n" +
               "Here are the commands that you can type.\n" +
               "Your command words are: \n" + this.aCommandWords.getCommandList();
    }//getHelpString()
    
    /**
     * Return the game over string.
     * @return The game over string. 
     */
    public String getGameOver()
    {
        return "\n\n\n\n*********** You are dead ***********\n\n\n\n";
    }//getGameOver()
    
    /**
     * Return the victory string.
     * @return The victory string.
     */
    public String getVictory()
    {
        return "\n\n\n\n*********** You won ***********\n\n\n\n";
    }
    
    /**
     * The string to tell the player to go talk to the guide.
     * @return The final advice speech.
     */
    public String getAdviceFinalSpeech()
    {
        return "\n*** It feels like the guide has something to tell you... ***\n";
    }
    
    /**
     * Return the room description string.
     * @return The room description string. 
     */
    public String getLocationInfo() 
    {
        return this.aPlayer.getCurrentRoom().getLongDescription() + "\n" +
               "The energy you have now : " + this.aPlayer.getCurrentEnergy();
    }//getLocationInfo()
}//GameModel