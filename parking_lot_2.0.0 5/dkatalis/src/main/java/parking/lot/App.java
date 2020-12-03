package parking.lot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import parking.lot.controller.InputParser;

public class App {
    public static void main(String[] args) {
       InputParser inputParser = new InputParser();
       switch (args.length) {
		case 0:
			System.out.println("type 'exit' to quit the sistem");
			System.out.println("Input:");
			for(;;) {
				try {
					BufferedReader bufferRead = new BufferedReader(new  InputStreamReader(System.in));
					String inputString = bufferRead.readLine();
					if(inputString.equalsIgnoreCase("exit")) {
						break;
					} else if((inputString == null) || (inputString.isEmpty())) {
						// do nothing
					} else {
						inputParser.parseTextInput(inputString);
					}
				} catch (IOException e) {
					System.out.println("Error while reading the input");
				}
			}
			
			break;
		case 1:
			inputParser.parseFileInput(args[0]);
			break;
		default:
			System.out.println("Invalid Input");
	}
    }
}