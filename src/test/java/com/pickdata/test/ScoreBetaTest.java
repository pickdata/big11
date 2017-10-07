package com.pickdata.test;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.pickdata.beta.Beta;
import com.pickdata.beta.Score;

public class ScoreBetaTest {

	
	@Test
	public void betaTest(){
		
		Score scoreClass = new Score();
		Beta betaClass = new Beta(); 
		
		
		Map<String,Double> map = betaClass.map("i19");
		System.out.println("map(\"i19\") = "+map);
		double offset = scoreClass.offset("i19", "90이상");
		System.out.println("offset ="+offset);
	}
	
	@Test
	public void scoreTest() {
		Double score;
		Score scoreClass = new Score();
		
		score = scoreClass.offset("i19", "10미만");
		System.out.println("score = "+score);
	}

	
}
