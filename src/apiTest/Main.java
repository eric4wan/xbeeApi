package apiTest;

import com.rapplogic.xbee.api.ApiId;
import com.rapplogic.xbee.api.AtCommandResponse;
import com.rapplogic.xbee.api.XBee;
import com.rapplogic.xbee.api.XBeeException;
import com.rapplogic.xbee.api.XBeeResponse;
import com.rapplogic.xbee.api.XBeeTimeoutException;
import com.rapplogic.xbee.util.ByteUtils;

public class Main {

	public static void main(String[] args) throws XBeeException {
		// TODO Auto-generated method stub
		XBee xbee = new XBee();
		System.out.println("newXBee");
		xbee.open("COM1", 9600);
		while (true) {
    		try {
    			XBeeResponse r = xbee.getResponse(10000);
    			if (r.getApiId() == ApiId.AT_RESPONSE) {
    				AtCommandResponse atResponse = (AtCommandResponse) r;
    				
    				if (atResponse.isOk()) {
    					System.out.println(ByteUtils.toBase16(atResponse.getValue()));
    				}
    			}
    		} catch (XBeeTimeoutException e) {
    			System.out.println(e);
    			System.out.println("TIMEOUT");
    		}
    	}
	}

}
