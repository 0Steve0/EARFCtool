package model;

import java.util.HashMap;
import java.util.Map;



/**
 * this is the class of Downlinkfrequency you can change the float data through
 * get and set method
 * calculate the frequency though downlink earfcn 
 * @author shaoliujia
 * @Time 2016-5-3
 *
 */
public class Frequency {
	
	 private float err=0; 
     private static class Data{
		 	private float uplinkfrequency;
		 	private float downlinkfrequency;
		 	private int downlinkearfcn;
		 	public Data(float uplinkfrequency,float downlinkfrequency,int downlinkearfcn){
		 		this.uplinkfrequency = uplinkfrequency;
		 		this.downlinkfrequency = downlinkfrequency;
		 		this.downlinkearfcn = downlinkearfcn;	
		 	}		 	
		 	public int getDownlinkearfcn() {
		 		return downlinkearfcn;
		 	}
		 	public float getDownlinkfrequency() {
		 		return downlinkfrequency;
		 	}
		 	public float getUplinkfrequency() {
		 		return uplinkfrequency;
		 	}	
     }
		
	 private Map<Integer,Object> mapinfo=new HashMap<Integer,Object>();
	 {   
	 mapinfo.put(1, new Data((float)1920,(float)2110,0));  
	  mapinfo.put(2, new Data((float)1850,(float)1930,600));  
	  mapinfo.put(3, new Data((float)1710,(float)1805,1200));  
	  mapinfo.put(4, new Data((float)1710,(float)2110,1950));  
	  mapinfo.put(5, new Data((float)824,(float)869,2400));  
	  mapinfo.put(6, new Data((float)830,(float)875,2650));  
	  mapinfo.put(7, new Data((float)2500,(float)2620,2750));  
	  mapinfo.put(8, new Data((float)880,(float)925,3450));  
	  mapinfo.put(9, new Data((float)1749.9,(float)1844.9,3800));  
	  mapinfo.put(10, new Data((float)1710,(float)2110,4150));  
	  mapinfo.put(11, new Data((float)1427.9,(float)1475.9,4750));  
	  mapinfo.put(12, new Data((float)699,(float)729,5010));  
	  mapinfo.put(13, new Data((float)777,(float)746,5180));  
	  mapinfo.put(14, new Data((float)788,(float)758,5280));  
	  
	  mapinfo.put(17, new Data((float)704,(float)734,5730));  
	  mapinfo.put(18, new Data((float)815,(float)860,5850));  
	  mapinfo.put(19, new Data((float)830,(float)875,6000));  
	  mapinfo.put(20, new Data((float)832,(float)791,6150));  
	  mapinfo.put(21, new Data((float)1447.9,(float)1495.9,6450));  
	  mapinfo.put(22, new Data((float)3410,(float)3510,6600));  
	  mapinfo.put(23, new Data((float)2000,(float)2180,7500));  
	  mapinfo.put(24, new Data((float)1626.5,(float)1525,7700));  
	  mapinfo.put(25, new Data((float)1850,(float)1930,8040));  
	  mapinfo.put(26, new Data((float)814,(float)859,8690));  
	  mapinfo.put(27, new Data((float)807,(float)852,9040));  
	  mapinfo.put(28, new Data((float)703,(float)758,9210));  
	  
	  mapinfo.put(30, new Data((float)2305,(float)2350,9770));  
	  mapinfo.put(31, new Data((float)452.5,(float)462.5,9870));  
	  
	  mapinfo.put(33, new Data((float)1900,(float)1900,36000));  
	  mapinfo.put(34, new Data((float)2010,(float)2010,36200));  
	  mapinfo.put(35, new Data((float)1850,(float)1850,36350));  
	  mapinfo.put(36, new Data((float)1930,(float)1930,36950));  
	  mapinfo.put(37, new Data((float)1910,(float)1910,37550));  
	  mapinfo.put(38, new Data((float)2570,(float)2570,37750));  
	  mapinfo.put(39, new Data((float)1880,(float)1880,38250));  
	  mapinfo.put(40, new Data((float)2300,(float)2300,38650));  
	  mapinfo.put(41, new Data((float)2496,(float)2496,39650));  
	  mapinfo.put(42, new Data((float)3400,(float)3400,41590));  
	  mapinfo.put(43, new Data((float)3600,(float)3600,43590));  
	  mapinfo.put(44, new Data((float)703,(float)703,45590));  
	 }
	 /**
	 * construct the Downlinkfrequency class
	 * two constructors
	 * @param dlf
	 * @paramulf which is float type(4 bytes)
	 */
	public Frequency(){
	}
	 /**
		 * calculate downlinkfrequency thougth earfcn
		 * two constructors
		 * @param e
		 * which is EARFCN OBKECT
		 *
		 */
	public float calculatedownlinkfrequency(Earfcn e){
		OperatingBand ob =new OperatingBand();
		int band =ob.calculateoperatingband(e);
		Data test=(Data) mapinfo.get(band);
		if(band==0) return err;
		else return (float) (test.getDownlinkfrequency()+0.1*(e.getEarfcn()-test.getDownlinkearfcn()));			
	
	}
	public float calculateuplinkfrequency(Earfcn e){
		
		OperatingBand ob =new OperatingBand();
		int band =ob.calculateoperatingband(e);
		Data test=(Data) mapinfo.get(band);
		if(band==0) return err;
		else return (float) (test.getUplinkfrequency()+0.1*(e.getEarfcn()-test.getDownlinkearfcn()));		
	}
	
	
}
