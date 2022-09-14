package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner gamble = new Scanner(System.in);
		System.out.println("What is your starting amount?");
		double startAmount = gamble.nextDouble();
		double startAmountReset = startAmount;
		System.out.println("What is your win probability? (# between 0 and 1)");
		double winChance = gamble.nextDouble();
		System.out.println("At what amount of money will you pull out?");
		double winLimit = gamble.nextDouble();
		System.out.println("How many days will you play for?");
		int totalSimulations = gamble.nextInt();
		int day = 0;
		int dubs = 0;
		int ells = 0;
		double dubs2 = 0;
		double ells2 = 0;
		int plays = 0;
		double ruinRate;
		
		double expectedRuinRate;
		double a = (1 - (startAmount/winChance));
		if (winChance == 0.5) {
			expectedRuinRate = (1 - (startAmount/winLimit));
		}
		else {
			expectedRuinRate = (Math.pow(a, startAmount) - Math.pow(a, winLimit)) / (1 - Math.pow(a, winLimit));
		}
		
		for (int i = 0; i < totalSimulations; i++) {
			while (startAmount > 0 && startAmount < winLimit) {
			double game = Math.random();
			if (game <= winChance) {
				startAmount ++;
				dubs++;
				dubs2 ++;
				
			}
			else {
				startAmount --;
				ells++;
				ells2++;
				
			}
			plays ++;
		}
		day++;	
		if (startAmount <= 0) {
			System.out.println("Day " + day + ": RUIN with " + dubs + " wins and " + ells + " losses.");
		}
		else {
			System.out.println("Day " + day + ": WIN with  " + dubs + " wins and " + ells + " losses.");
		}
		startAmount = startAmountReset;
		dubs = 0;
		ells = 0;

		}
		ruinRate = ells2 / (double) plays;
		System.out.println(ruinRate);
		System.out.println(expectedRuinRate);
		
		
		
	}
	
}
