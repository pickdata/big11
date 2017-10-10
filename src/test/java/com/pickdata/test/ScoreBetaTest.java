package com.pickdata.test;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.pickdata.beta.Beta;
import com.pickdata.beta.Beta2;
import com.pickdata.beta.Score;

public class ScoreBetaTest {
	@Test
	public void getScoreTest() {
		Beta2 bt = new Beta2();

		System.out.println("c1 customer \"aaa\" score = " + bt.getScore("c1", "aaa"));
		System.out.println("area#1 = " + bt.c1("c1").getStringArea1());
		System.out.print("c1 betas = {");
		for (Double d : bt.c1("c1").getBeta()) {
			System.out.print(d + " ");
		}
		System.out.println("}");
		System.out.println("area#1 beta = " + bt.map("c1").get("area1"));
		System.out.println("minbeta = " + bt.getColumn("c1").getMinBeta());
		System.out.println(bt.map("c1"));
		System.out.println(
				"(beta - minBeta) * getPod() / Math.log10(2) = "
				+ (bt.map("c1").get("area1") 
				- bt.getColumn("c1").getMinBeta()) 
				* 20 / Math.log10(2));
	}

	@Test
	public void mapTest() {
		Beta2 bt = new Beta2();
		System.out.print("c1 betas = {");
		for (Double d : bt.c1("c1").getBeta()) {
			System.out.print(d + " ");
		}
		System.out.println("}");
		System.out.println(bt.map("c1"));

		System.out.print("c5 betas = {");
		for (Double d : bt.c5("c5").getBeta()) {
			System.out.print(d + " ");
		}
		System.out.println("}");
		System.out.println(bt.map("c5"));
	}

	@Test // ok
	public void getColumnTest() {
		Beta2 bt = new Beta2();
		System.out.println(bt.getColumn("c1").getMinBeta());
		System.out.println(bt.getColumn("c5").getMinBeta());
	}

	@Test // ok
	public void beta2Test() {

		Beta2 bt = new Beta2();

		bt.c1("c1");
		System.out.println("############### 범주형 Test ################");
		System.out.print("betas = {");
		for (Double d : bt.c1("c1").getBeta()) {
			System.out.print(d + " ");
		}
		System.out.println("}");

		System.out.println("minbeta = " + bt.c1("c1").getMinBeta());
		System.out.println("area#1 = " + bt.c1("c1").getStringArea1());
		System.out.println("area#2 = " + bt.c1("c1").getStringArea2());
		System.out.println("area#3 = " + bt.c1("c1").getStringArea3());

		bt.c5("c5");
		System.out.println("############### 수치형 Test ################");
		System.out.print("betas = {");
		for (Double d : bt.c5("c5").getBeta()) {
			System.out.print(d + " ");
		}
		System.out.println("}");

		System.out.println("minbeta = " + bt.c5("c5").getMinBeta());
		System.out.println(bt.c5("c5").getArea1Min() + " <= area#1 < " + bt.c5("c5").getArea1Max());
		System.out.println(bt.c5("c5").getArea1Max() + " <= area#2 < " + bt.c5("c5").getArea2Max());
		System.out.println(bt.c5("c5").getArea2Max() + " <= area#3 < " + bt.c5("c5").getArea3Max());
		System.out.println(bt.c5("c5").getArea3Max() + " <= area#4 < " + bt.c5("c5").getArea4Max());

	}

	@Test
	public void betaTest() {

		Score scoreClass = new Score();
		Beta betaClass = new Beta();

		Map<String, Double> map = betaClass.map("c9");
		System.out.println("map(\"c9\") = " + map);
		map = betaClass.map("c10");
		System.out.println("map(\"c10\") = " + map);
		map = betaClass.map("c12");
		System.out.println("map(\"c12\") = " + map);
		map = betaClass.map("age");
		System.out.println("map(\"age\") = " + map);
		map = betaClass.map("t7");
		System.out.println("map(\"t7\") = " + map);

		// double offset = scoreClass.offset("i19", "90이상");
		// System.out.println("offset ="+offset);
	}

	@Test
	public void scoreTest() {
		Double score;
		Score scoreClass = new Score();

		score = scoreClass.offset("i19", "10미만");
		System.out.println("score = " + score);
	}

}
