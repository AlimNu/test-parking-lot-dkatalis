package parking.lot.strategy;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import parking.lot.service.ParkingLotService;

public class ParkingLotStrategy {
	
	public Map<String, Method> strategyMaps;

	public ParkingLotStrategy() {
		strategyMaps =new HashMap<String, Method>();
		try {
			strategyMaps.put("createParkingLot", ParkingLotService.class.getMethod("createParkingLot", String.class));
			strategyMaps.put("leave", ParkingLotService.class.getMethod("leave", String.class));
			strategyMaps.put("park", ParkingLotService.class.getMethod("park", String.class));
			strategyMaps.put("status", ParkingLotService.class.getMethod("status", String.class));
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
