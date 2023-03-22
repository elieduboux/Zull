package pkg_class;

/**
 * This class is part of the RPandaScape application. 
 * RPandaScape is a very simple, text based adventure game. 
 * 
 * It interpret the command given by the parser and execute it.
 * 
 * @author  Michael Kolling and David J. Barnes + Elie DUBOUX
 * @version 2003.01 + 2019 + 2021.01
 */
public class GameEngine
{
    /**
     * The parser used to catch the commands typed by the player.
     */
    private Parser aParser;
    /**
     * The graphical user interface.
     */
    private UserInterface aGui;
    /**
     * The game model.
     */
    private GameModel aGameModel;

    /**
     * Constructor for objects of class GameEngine.
     * @param pGameModel The game model.
     */
    public GameEngine(final GameModel pGameModel)
    {
        this.aGameModel = pGameModel;
        this.aParser = new Parser();
    }//GameEngine()

    /**
     * Initialise the graphical user interface.
     * @param pUserInterface The user interface.
     */
    public void setGUI(final UserInterface pUserInterface)
    {
        this.aGui = pUserInterface;
        this.aGui.printWelcome();
    }//setGUI()
    
    /**
     * Given a command, process (that is: execute) the command.
     * 
     * @param pCommandLine The line typed by the player.
     */
    public void interpretCommand(final String pCommandLine) 
    {
        this.aGui.println("> " + pCommandLine);
        Command vCommand = this.aParser.getCommand(pCommandLine);
        
        if (vCommand == null) 
        {
            this.aGui.println("I don't know what you mean...");
            return;
        }
        
        vCommand.setGui(this.aGui);
        vCommand.execute(this.aGameModel.getPlayer());
    }//interpretCommand()
}//GameEngine
