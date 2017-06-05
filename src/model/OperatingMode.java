package model;

/**
 * this is the class of OperatingMode 
 * the calcaulateopeartingmode method caculate the mode through earfcn
 * @author shaoliujia
 * @Time 2016-5-3
 *
 */
public class OperatingMode {
	private String operatingmode;
	private String t="TDD";
	private String f="FDD";
	private String err="cannotfindmode";
	/**
	 * construct the Operatingmode class
	 * two different constructors
	 * @param otm          
	 */
	public OperatingMode(){	
		
	}
	public OperatingMode(String otm) {
		operatingmode = otm;
	}

	public String getopeartingmode() {
		return operatingmode;
	}

	/**
	 * calculate the mode thorough downlink earfcn
	 * @param e
	 *          
	 */
	public String calculateopeartingmode(Earfcn e){
		   if(isFDD(e)) return f;
	       if(isTDD(e)) return t;
	  	   else return err;
	}
	/**
	 *  get whether isFDD mode
	 * refer to ETSI TS 136 101 V12.10.1 (2016-04)
	 * @param e         
	 */
	protected static boolean isFDD(Earfcn e){
		   if(e.getEarfcn()>=0&&e.getEarfcn()<=4949) return true;//band 1 to band 11
	  	   if(e.getEarfcn()>=5010&&e.getEarfcn()<=5379) return true;//band 12 to band 14,band 15 and 16 is reserved 
	  	   if(e.getEarfcn()>=5730&&e.getEarfcn()<=7399) return true; //band 17 to band 22
	  	   if (e.getEarfcn()>=7500&&e.getEarfcn()<=9659) return true; //band 23 to band 28
	  	   if (e.getEarfcn()>=9770&&e.getEarfcn()<=9919) return true; //band 30 to band 31
	  	   else return false;
	}
	/**
	 * get whether isTDD mode
	 * refer to ETSI TS 136 101 V12.10.1 (2016-04)
	 * @param e         
	 */
	protected static boolean isTDD(Earfcn e){
		 if (e.getEarfcn()>=36000&&e.getEarfcn()<=46589) return true; //band 33 to band 44
	  	   else return false;
	}
}
