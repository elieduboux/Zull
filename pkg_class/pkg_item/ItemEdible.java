package pkg_class.pkg_item;
import pkg_class.Item;

/**
 * Décrivez votre classe ItemEdible ici.
 *
 * @author Elie DUBOUX
 * @version 2021.01
 */
public class ItemEdible extends Item
{
    /**
     * Constructor.
     */
    public ItemEdible(final String pName, final String pDescription, final int pWeight,
                final int pPrice)
    {
        super(pName,pDescription, pWeight, pPrice);
    }//ItemEdible()

    /**
     * Change the way the item is printed.
     * @return The edible item as a String.
     */
    @Override public String toString()
    {
        return this.aName + " : {" + " Weight(" + this.aWeight + ")" + " Price(" + this.aPrice + 
               ") } -- This Item is edible.\n" ;
    }
}//ItemEdible()
