package pkg_class.pkg_item;
import pkg_class.Item;

import java.util.HashMap;
/**
 * This class is part of the RPandaScape application. 
 * RPandaScape is a very simple, text based adventure game.
 * 
 * It exists 2 list of items in the current game.
 * One in each room and the other is used as the player inventory.
 * 
 * A list of items have certains methods in order to manage the items better.
 * It is composed of a hashMap with :
 * Item as key
 * Integer as value (the number of the item present in the list)
 *
 * @author Elie DUBOUX
 * @version 2021.12.12
 * @see Item
 * @see Room
 * @see Player
 */
public class ItemList
{
    /**
     * The list of items.
     */
    private HashMap<Item,Integer> aItems;
    /**
     * The total price of the items in the list.
     */
    private int aWeightTotal;
    /**
     * The total price of the items in the list.
     */
    private int aPriceTotal;
    /**
     * Constructor.
     */
    public ItemList()
    {
        this.aItems = new HashMap<Item,Integer>();
        this.aWeightTotal = 0;
        this.aPriceTotal = 0;
    }//ItemList()
    
    /**
     * Add an item X times in the list.
     * @param pItem The item.
     * @param pItemNb The number of times.
     */
    public void addItems(final Item pItem, final int pItemNb)
    {
        if (this.containItem(pItem.getName()))
        {
            int vNumber = this.aItems.get(pItem);
            this.aItems.replace(pItem, vNumber, vNumber+pItemNb);
        }
        else
            this.aItems.put(pItem, pItemNb);
        
        this.aWeightTotal += pItem.getWeight()*pItemNb;
        this.aPriceTotal += pItem.getPrice()*pItemNb;
    }//addItems()
    
    /**
     * Remove an item X times from the list.
     * @param pItem The item.
     * @param pItemNb The number of times.
     */
    public void removeItems(final Item pItem, final int pItemNb)
    {     
        int vNumber = this.aItems.get(pItem);
        if (vNumber == pItemNb)
            this.aItems.remove(pItem);
        else
            this.aItems.replace(pItem, vNumber, vNumber-pItemNb);
        
        this.aWeightTotal -= pItem.getWeight()*pItemNb;
        this.aPriceTotal -= pItem.getPrice()*pItemNb;
    }//removeItem()
    
    /**
     * Check if an item is in the list with his name.
     * @param pItemName The name of the item.
     * @return True if the list contains the item,
     * false if not.
     */
    public boolean containItem(final String pItemName)
    {
        return this.getItem(pItemName) != null;
    }//containItem()
    
    /**
     * Return the item of the list with the given name, 
     * is null if it is not in the list.
     * @param pItemName The name of the item.
     * @return The item.
     */
    public Item getItem(final String pItemName)
    {
        for (Item vItem : this.aItems.keySet())
            if (vItem.getName().equals(pItemName))
                return vItem;
        return null;
    }//getItem()
    
    /**
     * Check the item is present enough times in the list of items.
     * @param pItem The item.
     * @param pItemNb The number of the item.
     * @return true if the list of items has enough time the item,
     * false if not.
     */
    public boolean hasEnough(final Item pItem, final int pItemNb)
    {
        return this.aItems.get(pItem) >= pItemNb;
    }//hasEnough()
    
    /**
     * Return the weight of all the items in the list.
     * @return The total weight of the list.
     */
    public int getWeightTotal()
    {
        return this.aWeightTotal;
    }

    /**
     * Return the price of all the items in the list.
     * @return The total price of the list.
     **/
    public int getPriceTotal()
    {
        return this.aPriceTotal;
    }
    
    /**
     * Override the toString methode in order to get the list of items with their
     * number in () in a String format.
     * @return The list of items in a String format.
     */
    @Override public String toString()
    {
        StringBuilder vItems = new StringBuilder("");
        
        if (this.aItems.isEmpty())
        {
            vItems.append("No item.\n");
            return vItems.toString();
        }

        for (Item vItem : this.aItems.keySet())
            vItems.append("\t"+ this.aItems.get(vItem) +"  x  " + vItem.toString());
        return vItems.toString();
    }//toString()
}//ItemList
