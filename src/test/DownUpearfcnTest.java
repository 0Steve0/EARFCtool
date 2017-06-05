package test;


import java.util.Arrays;

import model.DownUpearfcn;
import model.Earfcn;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DownUpearfcnTest {
   
  private int expected;
  private int target;
  
@Parameters
  public static Iterable<Object[]> prepareData(){
	
	  DownUpearfcn due=new DownUpearfcn();
	
	  return   Arrays.asList(new Object[][]{
			{0,due.calculatedownlinkearfcn(new Earfcn(0))},
			{600,due.calculatedownlinkearfcn(new Earfcn(600))},
			{36000,due.calculatedownlinkearfcn(new Earfcn(36000))},
			{-1,due.calculatedownlinkearfcn(new Earfcn(35999))}	
	});
	  
  }

  public DownUpearfcnTest(int expected, int target){
	  this.expected=expected;
	  this.target=target;
  }
	@Test
public void test() {
	
     Assert.assertEquals(expected,target,0);
}
    
}
