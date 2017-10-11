package com.pickdata.test;

import static org.junit.Assert.*;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

import old.pickdata.mapper.PickdataMapper;

public class MapperTest {

	MapDriver<Text, Text, Text, Text> mapDriver;
	ReduceDriver<Text, Text, Text, Text> reduceDriver;
	MapReduceDriver<Text, Text, Text, Text, Text, Text> mapReduceDriver;

	
	@Before
	public void setup() {
		PickdataMapper mapper = new PickdataMapper();
//		PickReducer reducer = new PickReducer();
		
		mapDriver = new MapDriver<Text, Text, Text, Text>(); 
//		mapDriver.setMapper(mapper);
		
	}
	
	@Test
	public void mapperTest() {
		mapDriver.withInput(new Text("1"), 
		new Text("1,0,1,0,0,0,9001,9001,9001,0,1,0,2,13,3,420001,공무원,5400,7700,4,1,24,주부,"
				+ "0,0,0,0,0,0,0,0,0,0,12,10미만,0,0,0,0,190000,0,190000,0,190000,20000000,20000000,"
				+ "0,0,10,0,0,0,50,1,450,493,X,30000,80000,N,800000,20111,0,0,0,0,O,U,580000"));
		mapDriver.withInput(new Text("1"),
		new Text("400,0,1,0,0,0,9001,9001,9001,0,25,0,3,121,0,0,주부,0,11000,3,2,24,자영업,"
				+ "6300,0,0,0,0,0,0,0,0,0,11,90이상,0,0,0,0,30000,0,130000,340000,30000,2000000,2000000,"
				+ "0,0,12,200000,2,0,50,1,0,1,X,0,0,N,900000,20132,1020,0,0,0,K,S,0"));
		
//		10미만
		mapDriver.withOutput(new Text("1"), new Text("0.0"));
//		90이상 
		mapDriver.withOutput(new Text("400"), new Text("61.36070547908939"));
		
		try {
			mapDriver.runTest();
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

}
