package pkg_class;

//import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.io.InputStream;

//import java.awt.Image;
//import java.awt.Graphics;
//import java.awt.Frame;
//import java.awt.Graphics2D;
//import java.awt.GradientPaint;
//import java.awt.*;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
//import java.awt.Toolkit;
//import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.imageio.ImageIO;

import java.util.List;
/**
 * This class is part of the RPandaScape application. 
 * RPandaScape is a very simple, text based adventure game.  
 * 
 * This class implements a simple graphical user interface with a text entry
 * area, a text output area, an image and a button.
 * 
 * @author Michael Kolling + Elie DUBOUX
 * @version 2003.01 + 2019 + 2021.01
 * @see GameEngine
 */
public class UserInterface implements ActionListener
{
    /**
     * The game engine.
     */
    private GameEngine aEngine;
    /**
     * The game Model
     */
    private GameModel aGameModel;
    /**
     * The frame.
     */
    private JFrame     aMyFrame;
    /**
     * The entry field.
     */
    private JTextField aEntryField;
    /**
     * The text field.
     */
    private JTextArea  aLog;
    /**
     * The image for the room.
     */
    private JLabel     aImage;
    /**
     * The button look.
     */
    private JButton    aButtonIntentory;
    /**
     * The image for the background.
     */
    //private JLabel aImageBackground;
    /**
     * Construct a UserInterface. As a parameter, a Game Engine
     * (an object processing and executing the game commands) is
     * needed.
     * 
     * @param pGameEngine The GameEngine object implementing the game logic.
     * @param pGameModel The GameModel.
     */
    public UserInterface(final GameEngine pGameEngine, final GameModel pGameModel)
    {
        this.aEngine = pGameEngine;
        this.aGameModel = pGameModel;
        this.createGUI();
    } // UserInterface()

    /**
     * Print out some text into the text area.
     * @param pText The text to print.
     */
    public void print(final String pText)
    {
        this.aLog.append(pText);
        this.aLog.setCaretPosition(this.aLog.getDocument().getLength());
    } // print()

    /**
     * Print out some text into the text area, followed by a line break.
     * @param pText The text to print.
     */
    public void println(final String pText)
    {
        this.print(pText + "\n");
    } // println()

    /**
     * Show an image file in the interface.
     * @param pImageName The path and the name of the image.
     */
    public void showImage(final String pImageName)
    {
        String vImagePath = "images/" + pImageName; // to change the directory
        InputStream vImageIN = UserInterface.class.getResourceAsStream(vImagePath);
        if (vImageIN == null)
            this.println("Image not found : " + vImagePath);
        else
        {
            try
            {
                ImageIcon vIcon = new ImageIcon(ImageIO.read(vImageIN));
                this.aImage.setIcon(vIcon);
                this.aMyFrame.pack();
            }
            catch(Exception e)
            {
                this.println(e.toString());
                //this.println("Error for " + vImagePath);
            }
        }
    }//showImage()

    /**
     * Enable or disable input in the input field.
     * @param pOnOff True when you can write on the entry field,
     * false otherwise.
     */
    public void enable(final boolean pOnOff)
    {
        this.aEntryField.setEditable(pOnOff); // enable/disable
        this.aButtonIntentory.setEnabled(pOnOff);
        if (! pOnOff) 
        { // disable
            // cursor won't blink
            this.aEntryField.getCaret().setBlinkRate(0);
            // won't react to entry
            this.aEntryField.removeActionListener(this);
            this.aButtonIntentory.removeActionListener(this); 
        }
    }//enable()

    /**
     * Set up graphical user interface.
     */
    private void createGUI()
    {
        this.aMyFrame = new JFrame("RPandaScape");
        this.aEntryField = new JTextField(34);
        this.aLog = new JTextArea();
        // {  
             // public void paintComponent(Graphics g) 
             // {  
                  // Graphics2D comp2D = (Graphics2D)g;
                  // comp2D.setColor(Color.blue);
                  
                  // GradientPaint pat = new GradientPaint(0f, 0f, Color.white,100f,45f,Color.blue);
                  // comp2D.setPaint(pat);
             // }  
        // };
        this.aLog.setFont(new Font("SansSerif", Font.BOLD, 12));
        this.aLog.setEditable(false);
        this.aButtonIntentory = new JButton("inventory");
        
        //this.aLog.setOpaque(false);
        //(0,206,209) blue 
        this.aEntryField.setBackground(new Color(255,239,213));
        this.aLog.setBackground(new Color(255,239,213));
        JScrollPane vListScroller = new JScrollPane(this.aLog);
        vListScroller.setPreferredSize(new Dimension(200, 200));
        vListScroller.setMinimumSize(new Dimension(100,100));

        JPanel vPanel = new JPanel();
        this.aImage = new JLabel();
        vPanel.setLayout(new BorderLayout()); // ==> only five places
        vPanel.add(this.aImage, BorderLayout.NORTH);
        vPanel.add(vListScroller, BorderLayout.CENTER);
        vPanel.add(this.aEntryField, BorderLayout.SOUTH);
        vPanel.add(this.aButtonIntentory , BorderLayout.EAST);
        
        // JPanel contentPane = new JPanel() 
        // {  
             // public void paintComponent(Graphics g) 
             // {  
                  // Image img = Toolkit.getDefaultToolkit().getImage("images/background.jpg");  
                  // g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
             // }  
        // };
        
        // contentPane.setLayout(new BorderLayout());
        // //contentPane.setOpaque(false);
        // vPanel.add(contentPane);
        // this.aMyFrame.setContentPane(contentPane);
        
        this.aMyFrame.getContentPane().add(vPanel, BorderLayout.CENTER);
        
        // add some event listeners to some components
        this.aEntryField.addActionListener(this);
        this.aButtonIntentory.addActionListener(this);
        
        // to end program when window is closed
        this.aMyFrame.addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        
        
        this.aMyFrame.setPreferredSize(new Dimension(600, 800));
        this.aMyFrame.pack();
        this.aMyFrame.setVisible(true);
        this.aEntryField.requestFocus();
    }//createGUI()

    /**
     * Actionlistener interface for entry textfield.
     * @param pEvent The event when a button is clicked.
     */
    public void actionPerformed(final ActionEvent pEvent) 
    {
        if (pEvent.getSource() == this.aButtonIntentory)
            this.aEngine.interpretCommand("inventory");
            
        if (pEvent.getSource() == this.aEntryField)
            this.processCommand();
    }//actionPerformed(.)

    /**
     * A command has been entered. Read the command and do whatever is 
     * necessary to process it.
     */
    private void processCommand()
    {
        String vInput = this.aEntryField.getText();
        this.aEntryField.setText("");

        this.aEngine.interpretCommand(vInput);
    }//processCommand()
    
    /**
     * A command has been entered. Read the command and do whatever is 
     * necessary to process it.
     * Used in the test.
     * @param pInput A line in a test file.
     */
    public void processCommand(final String pInput)
    {
        this.aEngine.interpretCommand(pInput);
    }//processCommand()
    
    /**
     * Print the room description and change the image.
     */
    public void printLocationInfo()
    {
        if (this.aGameModel.getPlayer().getCurrentRoom().getImage() != null)
            this.showImage(this.aGameModel.getPlayer().getCurrentRoom().getImage());
        this.println(this.aGameModel.getLocationInfo());
    }//printLocationInfo()
    
    /**
     * Print the welcome menu and information about the room where the 
     * player spawn.
     */
    public void printWelcome()
    {
        this.println(this.aGameModel.getWelcomeString());
        this.printLocationInfo();
    }//printWelcome()
    
    /**
     * Method called when the player ask for help.
     */
    public void printHelp()
    {
        this.println(this.aGameModel.getHelpString());
    }//printHelp()
    
    /**
     * Methode called when the player can have access to the final speech,
     * and when he talk again with the traveller.
     */
    public void printAdviceFinalSpeech()
    {
        this.println(this.aGameModel.getAdviceFinalSpeech());
    }
    
    /**
     * Method called when the player quit the game.
     */
    public void goodBye() 
    {
        this.println(this.aGameModel.getGoodByeString());
        this.enable(false);
    }//printGoodBye()
    
    /**
     * Method called when the player lose the game.
     */
    public void gameOver()
    {
        this.println(this.aGameModel.getGameOver());
        this.enable(false);
    }//gameOver()
    
    /**
     * Method called when the player has won the game.
     */
    public void gameWon()
    {
        this.println(this.aGameModel.getVictory());
        this.showImage("victory.jpg");
        this.enable(false);
    }
    
    /**
     * Return the rooms of the game. They are given by the Game Model.
     * Used in the AleaCommand
     * @return The rooms.
     */
    public List<Room> getRooms()
    {
        return this.aGameModel.getRooms();
    }//getRooms()
    
    /**
     * Return the player in the gameModel.
     * Used in some commands.
     * @return The player.
     */
    public Player getPlayer()
    {
        return this.aGameModel.getPlayer();
    }//getPlayer
}//UserInterface 