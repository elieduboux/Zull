package pkg_class;
import pkg_class.pkg_command.CommandWords;

import java.util.StringTokenizer;

/**
 * This class is part of the RPandaScape application. 
 * RPandaScape is a very simple, text based adventure game.   
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a three word command. It returns the command
 * as an object of class Command.
 *  
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Michael Kolling and David J. Barnes + D.Bureau + Elie Duboux
 * @version 2008.03.30 + 2013.09.15 + 20201.12.12
 * @see Command
 * @see CommandWords
 */
public class Parser 
{
    /**
     * Holds all valid command words.
     */
    private CommandWords aValidCommands;    
    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() 
    {
        this.aValidCommands = new CommandWords();
    } // Parser()

    /**
     * @return The next command from the user.
     * @param pInputLine The string typed by the user.
     */
    public Command getCommand(final String pInputLine) 
    {
        String vWord1 = null;
        String vWord2 = null;
        String vWord3 = null;

        // find up to two words on the line.
        StringTokenizer vTokenizer = new StringTokenizer( pInputLine );
        
        if ( vTokenizer.hasMoreTokens() )
            vWord1 = vTokenizer.nextToken();      // get first word
        else
            vWord1 = null;

        if ( vTokenizer.hasMoreTokens() )
            vWord2 = vTokenizer.nextToken();      // get second word
        else
            vWord2 = null;

        if ( vTokenizer.hasMoreTokens() )
            vWord3 = vTokenizer.nextToken();      // get third word
        else
            vWord3 = null;
        
        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).
        
        Command vCommand = this.aValidCommands.get(vWord1);
        if ( vCommand!= null) 
        {
            vCommand.setSecondWord(vWord2);
            vCommand.setThirdWord(vWord3);
        }
        
        return vCommand;
    }//getCommand()
    
    /**
     * Get a list of valid command words.
     * @return The String of the valid commands.
     */
    public String getCommandList()
    {
        return this.aValidCommands.getCommandList();
    }//getCommandList()
} // Parser