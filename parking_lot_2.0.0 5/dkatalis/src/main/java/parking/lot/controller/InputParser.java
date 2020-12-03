package parking.lot.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import parking.lot.service.impl.ParkingLotServiceImpl;
import parking.lot.strategy.ParkingLotStrategy;

public class InputParser {

	ParkingLotStrategy parkingLotStrategy;
	static ParkingLotServiceImpl parkingLotServiceImpl;
	
	public InputParser() {
		parkingLotServiceImpl = new ParkingLotServiceImpl();
		parkingLotStrategy = new ParkingLotStrategy();
	}
	
	public void parseTextInput(String inputString) {
		String[] input = inputString.split(" ");
		switch (input.length) {
		case 1:
				
			try {
				Method method = parkingLotStrategy.strategyMaps.get(inputString);
				if (method != null) {
					method.invoke(parkingLotServiceImpl);
				} else {
					System.out.println("Invalid Input");
				}
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case 2:
			try {
				Method method = parkingLotStrategy.strategyMaps.get(input[0]);
				if (method != null) {
					method.invoke(parkingLotServiceImpl, input[1]);
				} else {
					System.out.println("Invalid Input");
				}
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				Method method = parkingLotStrategy.strategyMaps.get(input[0]);
				if (method != null) {
					method.invoke(parkingLotServiceImpl, input[1], input[2]);
				} else {
					System.out.println("Invalid Input");
				}
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			System.out.println("Invalid Input");
		}
	}
	
	public void parseFileInput(String filePath) {
		File inputFile = new File(filePath);
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			String line;
			try {
				while((line=br.readLine())!=null) {
					parseTextInput(line.trim());
				}
			} catch (IOException e) {
				System.out.println("File not IOException");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
}
