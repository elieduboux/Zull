package pkg_class.pkg_command;
import pkg_class.Player;
import pkg_class.Command;
import pkg_class.pkg_room.TransporterRoom;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * Implementation of the 'test' user command.
 * 
 * @author Michael Kolling and David J. Barnes + Elie DUBOUX
 * @version 2011.07.31 + 2021.01
 */
public class TestCommand extends Command
{    
    /**
     * Constructor for objects of class TestCommand.
     */
    public TestCommand()
    {
    }
    
    /**
     * Test a file with commands in it.
     * 
     * Exemple :
     * >test 'file'
     * with :
     *      'file' -> the name of the test file without the extension
     *                (.txt)
     * @param pPlayer The player doing the action.
     */
    public void execute(final Player pPlayer)
    {
        if (!this.hasSecondWord())
        {
            this.aGui.println("What do you want to test ?");
            return;
        }
        
        TransporterRoom vTransporterRoom = (TransporterRoom)this.getTpRoom("Transporter");
        vTransporterRoom.setTestMode(true);
        String vNomFichier = "test/" + this.getSecondWord() + ".txt";
        
        try (Scanner vScanner = new Scanner(new BufferedReader( 
            new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(vNomFichier)))))
        {
            this.aGui.println("\n**** Lancement des tests. ****");
            while(vScanner.hasNextLine())
            {
                String vCommand = vScanner.nextLine();
                this.aGui.processCommand(vCommand);
            }
            vScanner.close();
        }
        catch(NullPointerException e)
        {
            this.aGui.println("--- The file was not found ---");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            this.aGui.processCommand("alea");
            vTransporterRoom.setTestMode(false);
            this.aGui.println("**** Fin des tests. ****");
        }
    }
}
