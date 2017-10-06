package com.example.pickdata;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Before;
import org.junit.Test;

import com.example.pickdata.PickMapperC11;

public class Mapper1Test {

	MapDriver<Text, Text, Text, DoubleWritable> map;
//							c1,2,3,4,5,   6,   7,  8,9,10,11
	String record1 = "1,0,1,0,0,0,9001,9001,9001,0,1,0,2,13,3,420001,공무원,5400,7700,4,1,24,주부,0,0,0,0,0,0,0,0,0,0,12,20미만,0,0,0,0,190000,0,190000,0,190000,20000000,20000000,0,0,10,0,0,0,50,1,450,493,,30000,80000,N,800000,20111,0,0,0,0,O,U,580000";
	String record2 = "2,0,1,0,0,0,24001,0,24001,0,0,0,2,121,0,0,자영업,5500,8100,4,2,29,주부,0,0,0,0,0,0,0,0,0,0,13,0,0,0,0,0,0,0,110000,0,0,7000000,36000000,0,0,0,300000,2,5,50,1,81,22,,30000,40000,N,500000,20143,0,0,0,0,O,U,90000";
	String record3 = "3,0,0,1,3,2,15001,9001,0,3001,1,25,4,121,0,0,주부,0,4900,4,1,34,2차산업 종사자,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,100000,11000000,11000000,0,0,0,0,0,2,60,2,139,17,,30000,40000,Y,500000,20103,0,0,0,0,O,U,120000";
	String record4 = "4,1,0,2,4,2,6001,3001,0,3001,1,25,4,61,0,0,학생,0,10100,2,1,0,무직,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,0,0,0,0,0,4000000,4000000,0,0,0,0,0,1,35,1,1118,0,,30000,80000,N,900000,20144,0,540000,0,630000,G,S,320000";
	String record5 = "5,0,4,0,0,0,21001,15001,21001,0,1,0,1,97,0,0,공무원,4800,4800,4,1,14,주부,0,0,0,0,0,0,0,0,0,0,0,0,95,2000000,0,0,0,0,0,0,300000,4000000,4000000,0,0,0,500000,2,1,45,1,396,354,W,50000,80000,Y,800000,20131,0,130000,0,90000,G,U,410000";

	@Before
	public void setUp() throws Exception {
		map = MapDriver.newMapDriver(new PickMapperC11()); // 초기화
	}
	
	@Test
	public void test() throws IOException {
		map.withInput(new Text(), new Text(record1));
		map.withOutput(new Text("1"), new DoubleWritable(175.06477974885388));
	
		map.runTest();
	}

}
