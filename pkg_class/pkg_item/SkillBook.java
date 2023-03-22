package pkg_class.pkg_item;
import pkg_class.Item;

/**
 * Décrivez votre classe PNJ ici.
 *
 * @author Elie DUBOUX
 * @version 2021.01
 */
public class SkillBook extends Item
{
    /**
     * Constructor.
     */
    public SkillBook(final String pName, final String pDescription, final int pWeight,
                final int pPrice)
    {
        super(pName,pDescription, pWeight,pPrice);
    }//SkillBook()
    /**
     * Default constructor.
     */
    public SkillBook()
    {
        super("","",0,0);
    }//SkillBook()
    
    /**
     * Change the way the item is printed.
     * @return The skill book as a String.
     */
    @Override public String toString()
    {
        return this.aName + " : {" + " Weight(" + this.aWeight + ")" + " Price(" + this.aPrice + 
               ") } -- This Item is a skill book.\n" ;
    }//toString()
}//SkillBook
