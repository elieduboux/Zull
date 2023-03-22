package pkg_class.pkg_room;
import pkg_class.Room;

/**
 * This class is part of the RPandaScape application. 
 * RPandaScape is a very simple, text based adventure game.
 *
 * @author Elie DUBOUX
 * @version 2021.01
 */
public class DarkRoom extends Room
{
    /**
     * If the room is dark or not.
     */
    private boolean aIsDark;
    /**
     * The description of the room when there is light.
     */
    private String aDescriptionNew;
    /**
     * The image of the room when there is light.
     */
    private String aImageNew;
    /**
     * Constructeur d'objets de classe TransporterRoom
     */
    public DarkRoom(final String pName, final String pDescription, final String pImage)
    {
        super(pName, "it's too dark to see anything. You must follow the wall.", "black.jpg");
        this.aIsDark = true;
        this.aDescriptionNew = pDescription;
        this.aImageNew = pImage;
    }//DarkRoom()x
    
    /**
     * Default Constructor.
     */
    public DarkRoom()
    {
        super("","","");
    }//DarkRoom()
    
    /**
     * If the room is in the dark, the image is black.
     * Else the image of the room is the normal one.
     */
    public void changeImage()
    {
        if (this.aIsDark)
            this.aImage = "images/black.jpg";
        else
            this.aImage = this.aImageNew;
    }//changeImage()
    
    // @Override public StringetImage()
    // {
        // return this.aImage;
    // }
    
    /**
     * Change the dark of the room to false and change the Image.
     */
    public void setNotDark()
    {
        this.aIsDark = false;
        this.changeImage();
    }//setIsNotDark()
    
    /**
     * Check if the room is in the dark.
     * @return True if the room is in the dark,
     * false if not.
     */
    public boolean getIsDark()
    {
        return this.aIsDark;
    }//getIsDark()
    
    /**
     * Return a long description of this room, of the form :
     *      You are near a little lake with a waterfall.
     *      Item(s) : seaweed(2) daisy(10)
     *      Exits : south west
     * 
     * @return A description of the room, including exits and items.
     */
    @Override public String getLongDescription()
    {
        StringBuilder vChaine = new StringBuilder("You are in the " + this.aName + " room.\n");
        if (this.aIsDark)
            vChaine.append(this.aDescription + "\n");
        else
        {
            vChaine.append(this.aDescriptionNew + "\n");
            vChaine.append(this.getItemsString() + "\n");
        }
        vChaine.append(this.getExitString());
        return vChaine.toString();
    }//getLongDescription()
}//DarkRoom
