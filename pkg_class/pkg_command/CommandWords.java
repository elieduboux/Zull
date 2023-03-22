package pkg_class.pkg_command;
import pkg_class.Command;

import java.util.HashMap;
/**
 * This class is part of the RPandaScape application. 
 * RPandaScape is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau + Elie Duboux
 * @version 2008.03.30 + 2019.09.25 + 2021.01
 * @see Parser
 */
public class CommandWords
{
    /**
     * A hashmap that holds all the valids command words
     */
    private HashMap<String, Command> aValidCommands;
    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        this.aValidCommands = new HashMap<String, Command>();
        
        this.aValidCommands.put("alea",new AleaCommand());
        this.aValidCommands.put("back",new BackCommand());
        this.aValidCommands.put("charge",new ChargeCommand());
        this.aValidCommands.put("drop",new DropCommand());
        this.aValidCommands.put("eat",new EatCommand());
        this.aValidCommands.put("fire",new FireCommand());
        this.aValidCommands.put("go",new GoCommand());
        this.aValidCommands.put("help",new HelpCommand(this));
        this.aValidCommands.put("inventory",new InventoryCommand());
        this.aValidCommands.put("learn",new LearnCommand());
        this.aValidCommands.put("light",new LightCommand());     
        this.aValidCommands.put("look",new LookCommand());
        this.aValidCommands.put("quit",new QuitCommand());
        this.aValidCommands.put("take",new TakeCommand());
        this.aValidCommands.put("talk",new TalkCommand());
        this.aValidCommands.put("test",new TestCommand());
        this.aValidCommands.put("transform",new TransformCommand());
    }//CommandWords()
    
    /**
     * Given a command word, find and return the matching command object.
     * Return null if there is no command with this name.
     */
    public Command get(String word)
    {
        return (Command)this.aValidCommands.get(word);
    }//get()
    
    /**
     * Get the allowed commands.
     * @return The String of the allowed commands.
     */
    public String getCommandList()
    {
        StringBuilder vValidCommands = new StringBuilder();
        for(String vCommand : this.aValidCommands.keySet())
            vValidCommands.append(vCommand + " ");
        
        return vValidCommands.toString();
    }//getCommandList()
}//CommandWords