package pkg_class;

/**
 * This class is part of the RPandaScape application. 
 * RPandaScape is a very simple, text based adventure game. 
 * 
 * Describe an Item by it's name, description, weight and price.
 * An Item can be either carried/used/taken/dropped by a player.
 * By default all items are in Rooms.
 * 
 * The class Item contains methods in order to get and set it's attributes.
 * 
 * A list of Item is an ItemList.
 * 
 * @author Elie DUBOUX
 * @version 2021.12.12
 * @see pkg_class.pkg_item.ItemList
 */
public class Item
{
    /**
     * The name.
     */
    protected String aName;
    /**
     * The description.
     */
    protected String aDescription;
    /**
     * The weight.
     */
    protected int aWeight;
    /**
     * The price.
     */
    protected int aPrice;
    /**
     * Constructor.
     * @param pName The name of the item.
     * @param pDescription The description of the item.
     * @param pWeight The weight of the item.
     * @param pPrice The price of the item.
     */
    public Item(final String pName, final String pDescription, final int pWeight,
                final int pPrice)
    {
        this.aName = pName;
        this.aDescription = pDescription;
        this.aWeight = pWeight;
        this.aPrice = pPrice;
    }//Item()
    
    /**
     * Set the weight to a given int.
     * @param pWeight The given int.
     */
    public void setWeight(final int pWeight)
    {
        this.aWeight = pWeight;
    }//setWeight()
    
    /**
     * Return the name of the item.
     * @return The name.
     */
    public String getName()
    {
        return this.aName;
    }//getName()
    
    /**
     * Return the description of the item.
     * @return The description.
     */
    public String getDescription()
    {
        return this.aDescription;
    }//getDescription()
    
    /**
     * Return the weight of the item.
     * @return The weight.
     */
    public int getWeight()
    {
        return this.aWeight;
    }//getWeight()
    
    /**
     * NOT USED NOW (but will be useful in the futur)
     * Return the price of the item.
     * @return The price.
     */
    public int getPrice()
    {
        return this.aPrice;
    }//getPrice()

    
    @Override public String toString()
    {
        return this.aName + " : {" + " Weight(" + this.aWeight + ")" + " Price(" + this.aPrice+ ") }\n";
    }
}//Item