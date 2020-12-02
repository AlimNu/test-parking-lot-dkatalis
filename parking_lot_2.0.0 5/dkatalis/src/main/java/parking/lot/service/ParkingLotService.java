package parking.lot.service;

public interface ParkingLotService {

	public void createParkingLot(String countLot);
	
	public void leave(String slotNo);
	
	public void park(String regNo, Integer duration);
	
	public void status();
	
	public void getRegistrationNoAndCharge(String regNo);
}
