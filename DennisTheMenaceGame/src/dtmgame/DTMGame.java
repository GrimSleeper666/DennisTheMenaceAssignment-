/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtmgame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Student
 */
public class DTMGame {
    /*after some research i found that this is a good way to create a vintage/retro
    style game which will fit the type of game i am creating as this is 
    essentially just a dennis the menace reboot of zork.*/
    
    JFrame gameWindow;
    Container container;
    JPanel titlePanel, startPanel, mainTextPanel, choicesPanel, playerInfoPanel;
    JLabel titleName, healthLabel, healthLabelNumber, toolLabel, toolLabelName;
    JButton startButton, optionOne, optionTwo, optionThree, optionFour;
    JTextArea mainTextArea;
    int playerHealth;
    String tool;
    String location;
    
    
    Font titleFont = new Font("Bernard MT Condensed", Font.BOLD, 28);
    Font buttonFont = new Font("Times New Roman", Font.BOLD, 16);
    Font mainFont = new Font("Arial", Font.PLAIN, 20);
            
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    OptionPicker optionpicker = new OptionPicker();
    
    
    public static void main(String[] args) {
        
    new DTMGame();
}
    public DTMGame(){
        /*this section is used to create the window in which the game will be played
        as you can see i am using the imported functions to create the base 
        graphics for the game. so it will be a black background with a red tag/panel
        for the title of the game.*/
        gameWindow = new JFrame();
        gameWindow.setSize(800,600);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.getContentPane().setBackground(Color.black);
        gameWindow.setLayout(null);
        
        container = gameWindow.getContentPane();
        
        titlePanel = new JPanel();
        titlePanel.setBounds(100, 100, 600, 100);
        titlePanel.setBackground(Color.black);
        
        titleName = new JLabel("Dennis The Menace The Text Adventure");
        titleName.setForeground(Color.red);
        titleName.setFont(titleFont);
        
        startButton = new JButton("Start");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.red);
        startButton.setFont(titleFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);
        
        startPanel = new JPanel();
        startPanel.setBounds(350,300,100,50);
        startPanel.setBackground(Color.black);
        
        titlePanel.add(titleName);
        startPanel.add(startButton);
        
        container.add(titlePanel);
        container.add(startPanel);
        
        gameWindow.setVisible(true);
    }
    public void createGameScreen(){   
        
        titlePanel.setVisible(false);
        startPanel.setVisible(false);
        
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        
        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100, 100, 500, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(mainFont);
        mainTextArea.setLineWrap(true);
        
        
        
        choicesPanel = new JPanel();
        choicesPanel.setBounds(250, 350, 300, 150);
        choicesPanel.setBackground(Color.black);
        choicesPanel.setLayout(new GridLayout(4,1));
        
        optionOne = new JButton("optionOne");
        optionOne.setBackground(Color.black);
        optionOne.setForeground(Color.white);
        optionOne.setFont(buttonFont);
        optionOne.addActionListener(optionpicker);
        optionOne.setActionCommand("option1");
        
        optionTwo = new JButton("optionTwo");
        optionTwo.setBackground(Color.black);
        optionTwo.setForeground(Color.white);
        optionTwo.setFont(buttonFont);
        optionTwo.addActionListener(optionpicker);
        optionTwo.setActionCommand("option2");
        
        optionThree = new JButton("optionThree");
        optionThree.setBackground(Color.black);
        optionThree.setForeground(Color.white);
        optionThree.setFont(buttonFont);
        optionThree.addActionListener(optionpicker);
        optionThree.setActionCommand("option3");
        
        optionFour = new JButton("optionFour");
        optionFour.setBackground(Color.black);
        optionFour.setForeground(Color.white);
        optionFour.setFont(buttonFont);
        optionFour.addActionListener(optionpicker);
        optionFour.setActionCommand("option4");

        
        optionOne.setFocusPainted(false);
        optionTwo.setFocusPainted(false);
        optionThree.setFocusPainted(false);
        optionFour.setFocusPainted(false);
        
        playerInfoPanel = new JPanel();
        playerInfoPanel.setBounds(100, 15, 600, 50);
        playerInfoPanel.setBackground(Color.red);
        playerInfoPanel.setLayout(new GridLayout(1,4));
        
        
        healthLabel = new JLabel("Health: ");
        healthLabel.setFont(mainFont);
        healthLabel.setForeground(Color.white);
        
        healthLabelNumber = new JLabel();
        healthLabelNumber.setFont(mainFont);
        healthLabelNumber.setForeground(Color.white);
        
        
        toolLabel = new JLabel(" In Hands: ");
        toolLabel.setFont(mainFont);
        toolLabel.setForeground(Color.white);
        
        
        toolLabelName = new JLabel();
        toolLabelName.setFont(mainFont);
        toolLabelName.setForeground(Color.white);
        
        
        
        playerInfoPanel.add(healthLabel);
        playerInfoPanel.add(healthLabelNumber);
        playerInfoPanel.add(toolLabel);
        playerInfoPanel.add(toolLabelName);
        
        mainTextPanel.add(mainTextArea);
        container.add(mainTextPanel);
        container.add(choicesPanel);
        container.add(playerInfoPanel);
        choicesPanel.add(optionOne);
        choicesPanel.add(optionTwo);
        choicesPanel.add(optionThree);
        choicesPanel.add(optionFour);
        
        playerSetup();
        
    }
    public void playerSetup(){
        playerHealth = 15;
        tool = "slingshot";
        
        toolLabelName.setText(tool);
        healthLabelNumber.setText("♥"+ playerHealth);
        frontRoom();
    }

    
    
    
    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    
    public class TitleScreenHandler implements ActionListener{
    public void actionPerformed(ActionEvent event){
        
        createGameScreen();
    }
    }
    
    
    public void frontRoom(){
        location = "frontRoom";
        mainTextArea.setText("You have woken from a sugar crash and the room is a mess. You Haven't long \n until Mum comes back. \n \n What do you do?");
        optionOne.setText("Go Back To Sleep");
        optionTwo.setText("Clean up");
        optionThree.setText("Go To Bed");
        optionFour.setText("Shove The Mess Under The Couch");
    }
    
    
    public void goBackToSleep(){
        location = "goBackToSleep";
    mainTextArea.setText("Mum Came Home And Shouted At You... \n\n\n GROUNDED!");
        optionOne.setText("Go Back");
        optionTwo.setText("");
        optionThree.setText("");
        optionFour.setText("");
    }
    
    
    public void cleanUp(){        
    location = "cleanUp";
    mainTextArea.setText("Mum Came Home And Sees You Tidying Up.... \n \n Mum:''At Least You're Cleaning Up After Yourself...'' \n\n This is Unfortunately as far as this project has come in   terms of playability");
        optionOne.setText("Ask if you can Play Out");
        optionTwo.setText("Ask If Mum Got you Anything");
        optionThree.setText("");
        optionFour.setText("");    

    }
    
    
    public void goToBed(){        
    location = "goToBed";
    mainTextArea.setText("Mum Came Home And Shouted At You... \n\n\n GROUNDED!");
        optionOne.setText("Go Back");
        optionTwo.setText("");
        optionThree.setText("");
        optionFour.setText("");    }
    
    
    public void hideMessUnderCouch(){        
    location = "hideMessUnderCouch";
    mainTextArea.setText("Mum Came Home, Pleased At First With The Sight Of The Room. Until She Sat On The Couch And The Mess Bursted From Underneath... \n\n\n GROUNDED!");
        optionOne.setText("Go Back");
        optionTwo.setText("");
        optionThree.setText("");
        optionFour.setText("");
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    public void treeHouse(){
    
    }
    ////////////////////////////////////////////////////////////////////////////
    public void thePark(){
    
    }
    ////////////////////////////////////////////////////////////////////////////
    public void secretServiceHQ(){
    
    }
    ////////////////////////////////////////////////////////////////////////////
    public void bashStreetSchool(){
    
    }
    public class OptionPicker implements ActionListener{
        public void actionPerformed(ActionEvent event){
        String playerOption = event.getActionCommand();
        
        switch(location){
            case "frontRoom":
                switch(playerOption){
                    case "option1": goBackToSleep(); break;
                    case "option2": cleanUp(); break;
                    case "option3": goToBed(); break;
                    case "option4": hideMessUnderCouch();break;
                }
                    break;
                case  "goBackToSleep":
                switch(playerOption){
                    case "option1": frontRoom(); break;
                }
                    break;
                case  "cleanUp":
                switch(playerOption){
                    case "option1": frontRoom(); break;
                }
                    break;
                case  "goToBed":
                switch(playerOption){
                    case "option1": frontRoom(); break;
                }
                    break;
                case  "hideMessUnderCouch":
                switch(playerOption){
                    case "option1": frontRoom(); break;
                }
            
        }
        }
    }
}
