package parking.lot.strategy;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import parking.lot.service.impl.ParkingLotServiceImpl;

public class ParkingLotStrategy {
	
	public Map<String, Method> strategyMaps;

	public ParkingLotStrategy() {
		strategyMaps =new HashMap<String, Method>();
		try {
			strategyMaps.put("createParkingLot", ParkingLotServiceImpl.class.getMethod("createParkingLot", String.class));
			strategyMaps.put("leave", ParkingLotServiceImpl.class.getMethod("leave", String.class));
			strategyMaps.put("park", ParkingLotServiceImpl.class.getMethod("park", String.class));
			strategyMaps.put("status", ParkingLotServiceImpl.class.getMethod("status", String.class));
			strategyMaps.put("getRegistrationNoAndCharge", ParkingLotServiceImpl.class.getMethod("getRegistrationNoAndCharge", String.class));
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
