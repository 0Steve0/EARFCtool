package test;




import java.util.Arrays;




import model.Calculatefrequency;
import model.Earfcn;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DownlinkfrequencyTest {
   
  private float expected;
  private float target;
  
@Parameters
  public static Iterable<Object[]> prepareData(){
	//Downlinkfrequency dof=new Downlinkfrequency();
	  Calculatefrequency dof=new Calculatefrequency();
	 // float a=(float) 1900.0;
	  //float b=(float) 1900.0;
	  return   Arrays.asList(new Object[][]{
			//{a,b}
			{(float)2110,(float)dof.calculatedownlinkfrequency(new Earfcn(0))},
			//{1930.0,dof.calculatedownlinkfrequency(new Earfcn(600))}		
	});
	  
  }

  public DownlinkfrequencyTest(float expected, float target){
	  this.expected=expected;
	  this.target=target;
  }
	@Test
public void test() {
	 //Downlinkfrequency dof=new Downlinkfrequency();
     //Earfcn e=new Earfcn(36000);
     //float result= dof.calculatedownlinkfrequency(e);
	 //System.out.println(result);
	 //float test=(float) 1900.0;
		//System.out.println(expected);
     Assert.assertEquals(expected,target,0);
}
    
}
