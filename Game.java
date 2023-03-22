import pkg_class.GameEngine;
import pkg_class.UserInterface;
import pkg_class.GameModel;
/**
 * This class is part of the RPandaScape application. 
 * RPandaScape is a very simple, text based adventure game.  
 * 
 * This main class creates the Graphical User Interface,
 * the game engine and the game model.
 *
 * @author Elie DUBOUX
 * @version 2021.1
 * @see GameEngine
 * @see UserInterface
 * @see GameModel
 */
public class Game
{
    /**
     * The graphical user interface.
     */
    private UserInterface aGui;
    /**
     * The game engine.
     */
    private GameEngine aEngine;
    /**
     * The Game Model.
     */
    private GameModel aGameModel;
    
    /**
     * Create the game and initialise its internal map. Create the inerface and link to it.
     */
    public Game()
    {
        this.aGameModel = new GameModel();
        this.aEngine    = new GameEngine(this.aGameModel);
        this.aGui       = new UserInterface(this.aEngine, this.aGameModel);
        this.aEngine.setGUI(this.aGui);
    }//Game()
    
    /**
     * 
     * @param args The args, not used here.
     */
    public static void main(String[] args)
    {
        Game vGame = new Game();
    }
}//Game