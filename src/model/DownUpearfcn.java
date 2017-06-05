package model;

/**
 * this is the class of DownUpearfcn you can change the int data through get and
 * set method
 * calculate the downlink and uplink earfcn through earfcn object
 * @author shaoliujia
 * @Time 2016-5-3
 *
 */
public class DownUpearfcn {
	private int downlinkearfcn;
	private int uplinkearfcn;
    //error earfcn equals -1
	private int err=-1;
	/**
	 * construct the Earfcn class
	 * two constructors
	 * @param dle
	 * @param ule
	 *            which is int type(4 bytes)
	 */
	public DownUpearfcn(){
		
	}
	public DownUpearfcn(int dle, int ule) {
		downlinkearfcn = dle;
		uplinkearfcn = ule;
	}

	public int getDownlinkearfcn() {
		return downlinkearfcn;
	}
	public int getUplinkearfcn() {
		return uplinkearfcn;
	}
	/**
	 * calculate the downlinkearfcn thorough earfcn
	 * @param e
	 *          
	 */
	public int calculatedownlinkearfcn(Earfcn e){
       if(OperatingMode.isFDD(e)) return e.getEarfcn();
       if(OperatingMode.isTDD(e)) return e.getEarfcn();
  	   else return err;
    }
	/**
	 * calculate the uplinkearfcn thorough earfcn
	 * @param e          
	 */
	public int calculateuplinkearfcn(Earfcn e){
		   if(OperatingMode.isFDD(e)) return e.getEarfcn()+18000;
	       if(OperatingMode.isTDD(e)) return e.getEarfcn();
	  	   else return err;
	    }
	
}
