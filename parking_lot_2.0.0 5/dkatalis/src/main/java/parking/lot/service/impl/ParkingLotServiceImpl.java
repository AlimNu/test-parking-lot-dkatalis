package parking.lot.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import parking.lot.model.Car;
import parking.lot.service.ParkingLotService;

public class ParkingLotServiceImpl implements ParkingLotService{
	
	int PARKING_LOT_SIZE=0;
	
	ArrayList<Integer> avaibleSlotList;
	
	Map<String, Car> mapCar;
	Map<String, String> mapRegNoAndSlot;

	@SuppressWarnings("serial")
	public void createParkingLot(String countLot) {
		
		try {
			this.PARKING_LOT_SIZE = Integer.parseInt(countLot);
		} catch (NumberFormatException e) {
			System.out.println("invalid lot count");
			System.out.println();
		}
		
		this.avaibleSlotList = new ArrayList<Integer>() {};
		for(int i=1; i<= this.PARKING_LOT_SIZE; i++) {
			avaibleSlotList.add(i);
		}
		
		this.mapCar = new HashMap<String, Car>();
		this.mapRegNoAndSlot = new HashMap<String, String>();
		System.out.println("Created parking lot with "+countLot+" slots");
		System.out.println();
		
		
	}

	public void leave(String slotNo) {
		if(this.PARKING_LOT_SIZE == 0) {
			System.out.println("Sorry, parking lot is not created");
			System.out.println();
		} else if (this.mapCar.size() > 0) {
			Car carWantToLeave = this.mapCar.get(slotNo);
			if(carWantToLeave != null) {
				this.mapCar.remove(slotNo);
				this.mapRegNoAndSlot.remove(carWantToLeave.getRegNo());
				this.avaibleSlotList.add(Integer.parseInt(slotNo));
				System.out.println("Slot number "+slotNo+" is free");
				System.out.println();
			} else {
				System.out.println("Slot number "+slotNo+" is already empty");
				System.out.println();
			}
		} else {
			System.out.println("Parking lot is empty");
			System.out.println();
		}
		
	}

	public void park(String regNo, Integer duration) {
		if(this.PARKING_LOT_SIZE == 0) {
			System.out.println("Sorry, parking lot is not created");
			System.out.println();
		} else if (this.mapCar.size() == this.PARKING_LOT_SIZE) {
			System.out.println("Sorry, parking lotis full");
			System.out.println();
		} else {
			Collections.sort(avaibleSlotList);
			String slot = avaibleSlotList.get(0).toString();
			Car car = new Car(regNo, duration);
			this.mapCar.put(slot, car);
			this.mapRegNoAndSlot.put(regNo, slot);			
			System.out.println("Alocated slot number: "+slot);
			System.out.println();
			avaibleSlotList.remove(0);
		}
		
	}

	public void status() {
		if(this.PARKING_LOT_SIZE == 0) {
			System.out.println("Sorry, parking lot is not created");
			System.out.println();
		} else if (this.mapCar.size() > 0) {
			System.out.println("Slot No.\tRegistration No.\tDuration");
			Car car;
			for(int i=1; i<= this.PARKING_LOT_SIZE; i++) {
				String key = Integer.toString(i);
				if(this.mapCar.containsKey(key)) {
					car= this.mapCar.get(key);
					System.out.println(i+"\t"+car.getRegNo()+"\t"+car.getDuration());
				}
			}
			System.out.println();
		} else {
			System.out.println("parking lot is empty");
			System.out.println();
		}
	}

	@Override
	public void getRegistrationNoAndCharge(String regNo) {
		// TODO Auto-generated method stub
		
	}

}
