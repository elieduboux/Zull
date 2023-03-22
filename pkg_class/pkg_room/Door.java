package pkg_class.pkg_room;
/**
 * Décrivez votre classe PNJ ici.
 *
 * @author Elie DUBOUX
 * @version 2021.01
 */
public class Door
{
    /**
     * The skill the player need to learn to pass the door.
     */
    private String aSkill;
    /**
     * If the door is locked or not.
     */
    private boolean aIsLocked;
    /**
     * Constructor
     */
    public Door(final String pSkill)
    {
        this.aSkill = pSkill;
        this.aIsLocked = true;
    }//Door()
    
    /**
     * Return the skill needed to pass the door.
     * @return The skill.
     */
    public String getSkill()
    {
        return this.aSkill;
    }//getSkill()
    
    /**
     * Check if the door is locked or not.
     */
    public boolean getIsLocked()
    {
        return this.aIsLocked;
    }//getIsLocked()
    
    public void unlock()
    {
        this.aIsLocked = false;
    }//unlock()
}//Door
