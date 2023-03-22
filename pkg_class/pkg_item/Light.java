package pkg_class.pkg_item;
/**
 * Décrivez votre classe PNJ ici.
 *
 * @author Elie DUBOUX
 * @version 2021.01
 */
public class Light extends SkillBook
{
    /**
     * Constructor.
     */
    public Light(final String pName, final String pDescription, final int pWeight,
                final int pPrice)
    {
        super(pName,pDescription, pWeight,pPrice);
    }//SkillBook()
    
    /**
     * Default constructor.
     */
    public Light()
    {
        super("","",0,0);
    }//SkillBook()
}//SkillBook
