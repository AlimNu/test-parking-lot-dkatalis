package parking.lot.util;

public class CommonUtil {

	private static int TWOHOUR = 2;
	private static int TWOHOURCHARGE = 10;
	
	public int countParkingCharge(int duration) {
		int result=0;
		if(duration <= TWOHOUR) {
			result = duration * 5;
		} else {
			result = TWOHOURCHARGE + ((duration-TWOHOUR)*TWOHOURCHARGE);
		}
		return result;
	}
}
