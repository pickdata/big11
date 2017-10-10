package com.pickdata.test;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.pickdata.beta.Beta;
import com.pickdata.beta.Beta2;
import com.pickdata.beta.Score;

public class ScoreBetaTest {
	
	@Test
	public void beta2Test(){
		
		Beta2 bt = new Beta2();
		
		bt.c1();
	}
	
	@Test
	public void betaTest(){
		
		Score scoreClass = new Score();
		Beta betaClass = new Beta(); 
		
		
		Map<String,Double> map = betaClass.map("c9");
		System.out.println("map(\"c9\") = "+map);
		map = betaClass.map("c10");
		System.out.println("map(\"c10\") = "+map);
		map = betaClass.map("c12");
		System.out.println("map(\"c12\") = "+map);
		map = betaClass.map("age");
		System.out.println("map(\"age\") = "+map);
		map = betaClass.map("t7");
		System.out.println("map(\"t7\") = "+map);
		
//		double offset = scoreClass.offset("i19", "90이상");
//		System.out.println("offset ="+offset);
	}
	
	@Test
	public void scoreTest() {
		Double score;
		Score scoreClass = new Score();
		
		score = scoreClass.offset("i19", "10미만");
		System.out.println("score = "+score);
	}

	
}
