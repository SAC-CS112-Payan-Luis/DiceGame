/*Luis Payan
 * CS 112
 * Homework 6 Week 6
 */

import java.util.Scanner;
import javax.swing.JOptionPane;

public class DiceGame {

	public static void main(String[] args) {	
		Scanner input = new Scanner (System.in);
		DiceGameObjects classObject = new DiceGameObjects();
		//declares for variables
		int playAgain, roll, userInput, gameCount=1;
		String userChoice = null;
		double win =0, evenWin=0, oddWin=0;
		double evenGuess=0, oddDice = 0;
		//has user enter name
		String name = JOptionPane.showInputDialog("Please enter name: ");
		classObject.setName(name);
		//Displays message to user
		String welcomeMessage = String.format("Hi %s! Welcome to the Dice Game.\nGuess if the dice will be odd or even.\n", classObject.getName());
		JOptionPane.showMessageDialog(null, welcomeMessage);
		//do while
		do
		{
			int diceNum = classObject.getDiceNum();
			
			gameCount++;
			classObject.setGameCount(gameCount);
			
			userInput = Integer.parseInt(JOptionPane.showInputDialog("\nPress 1 for odd or 2 for even: "));
			if (userInput ==1) userChoice="Odd";
			if (userInput ==2) userChoice="Even";
			
			JOptionPane.showMessageDialog(null,"You chose "+ userChoice);
			
			roll = Integer.parseInt(JOptionPane.showInputDialog("\n\nPress 1 to role the dice: "));
			
			JOptionPane.showMessageDialog(null,"Dice number is "+ diceNum);
			
			if (userInput ==1)
			{
				if (diceNum == 1 || diceNum==3 || diceNum ==5)
				{
					JOptionPane.showMessageDialog(null,"Congratulations! You guessed it.\nThe dice rolled an odd number.");
					win++; oddWin++; oddDice++;
					classObject.setWin(win); classObject.setOddWin(oddWin); classObject.setOddDice(oddDice);
				}
				else
					JOptionPane.showMessageDialog(null,"Sorry, you lose.\nThe dice rolled an even number.");
			}
			else if (userInput ==2)
			{	
				evenGuess++;
				classObject.setEvenGuess(evenGuess);
				if (diceNum == 2 || diceNum ==4 || diceNum == 6)
				{
					JOptionPane.showMessageDialog(null,"Congratulations! You guessed it. The dice rolled an even number.");
					win++; evenWin++;
					classObject.setWin(win); classObject.setEvenWin(evenWin);
				}
				else
				{	
					JOptionPane.showMessageDialog(null,"Sorry, you lose. The dice rolled an odd number.");
					oddDice++;
					classObject.setOddDice(oddDice++);
				}
			}
			//lets user decide if he/she wants to play again
			playAgain = Integer.parseInt(JOptionPane.showInputDialog("\n\nPress 1 to play again or 2 to exit and calculate results: "));
			
		}while (playAgain ==1);
			//if no longer wishes to play it will display results
			JOptionPane.showMessageDialog(null,"-- Game Stats --\n\nGames won: "+ classObject.getWin() + 
					"\nGame played: "+ classObject.getGameCount() + "\nWinning percentage: "+ classObject.getWinPercent()+
					"\n% player chose even: "+ classObject.getEvenGuessPercent()+
					"\n% dice rolled an odd number: "+ classObject.getOddDicePercent()+
					"\n# of times player won when choosing even: "+ classObject.getEvenWin()+
					"\n# of times player won when choosing odd: "+ classObject.getOddWin()); 
			//displays message to user after saying no to the game		
			JOptionPane.showMessageDialog(null,"Thank you! Have a nice day.");
	}
}