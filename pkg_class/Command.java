package pkg_class;

/**
 * This class is part of the RPandaScape application. 
 * RPandaScape is a very simple, text based adventure game.
 * 
 * This class holds information about a command that was issued by the user.
 * A command currently consists of three strings: a command word, a second
 * word and a third one (for example, if the command was "take apple 3", then the 3 strings
 * obviously are "take", "map" and 3).
 * 
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the command word is null.
 *
 * If the command had only one word, then the second and third word are null.
 * 
 * @author Elie DUBOUX 
 * @version 2021.01
 * @see Parser
 */
public abstract class Command
{
    /**
     * The graphical user interface.
     */
    protected UserInterface aGui;
    /**
     * The second word.
     */
    private String aSecondWord;
    /**
     * The third word.
     */
    private String aThirdWord;
    
    /**
     * Constructor.
     */
    public Command()
    {
        this.aSecondWord = null;
        this.aThirdWord  = null;
    }//Command()
    
    /**
     * Return the second word of this command. If the command was not
     * understood, the result is null.
     * @return The second word.
     */
    public String getSecondWord()
    {
        return this.aSecondWord;
    }//getSecondWord()
    
    /**
     * Return the third word of this command. If the command was not
     * understood, the result is null.
     * @return The third word.
     */
    public String getThirdWord()
    {
        return this.aThirdWord;
    }//getThirdWord()
    
    /**
     * Check if the command has a second word.
     * @return True if the command has a second word,
     * false if it does not.
     */
    public boolean hasSecondWord()
    {
        return this.aSecondWord != null;
    }//hasSecondWord()
    
    /**
     * Check if the command has a third word.
     * @return True if the command has a third word,
     * false if it does not.
     */
    public boolean hasThirdWord()
    {
        return this.aThirdWord != null;
    }//hasThirdWord()
    
    /**
     * Get and transform the third word if it is a number.
     * @return The third word if it is a number, 1 if not.
     */
    public int getThirdWordNumber()
    {
        if (!this.hasThirdWord())
            return 1;
        
        int d = 1;
        try 
        {
            d = Integer.parseInt(this.aThirdWord);
        }
        catch (NumberFormatException e) 
        {
            d = 1;
        }
        finally
        {
            return d;
        }
    }//isThirdWord()
    
    /**
     * Define the second word of this command (the word
     * entered after the command word). Null indicates that 
     * there was no second word.
     * @param pSecondWord The second word
     */
    public void setSecondWord(final String pSecondWord)
    {
        this.aSecondWord = pSecondWord;
    }//setSecondWord()
    
    /**
     * Define the third word of this command (the word
     * entered after the second word). Null indicates that 
     * there was no third word.
     * @param pThirdWord The third word
     */
    public void setThirdWord(final String pThirdWord)
    {
        this.aThirdWord = pThirdWord;
    }//setThirdWord()
    
    /**
     * Define the gui for this command.
     * @param pGui The gui.
     */
    public void setGui(final UserInterface pGui)
    {
        this.aGui = pGui;
    }//setGui()
    
    /**
     * Get the corresponding room with it's name.
     * Used in Test and Alea commands.
     * @param pRoomName The name of the room.
     * @return The room, can be null.
     */
    protected Room getTpRoom(final String pRoomName)
    {
        String vRoomName = pRoomName.toLowerCase();
        for (Room vRoom : this.aGui.getRooms())
            if(vRoom.getName().toLowerCase().equals(vRoomName))
                return vRoom;
        return null;
    }
    
    /**
     * Execute this command.
     * @param pPlayer The player doing the action.
     */
    public abstract void execute(final Player pPlayer);
}//Command