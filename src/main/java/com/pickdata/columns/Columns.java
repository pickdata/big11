package com.pickdata.columns;

public class Columns {
	
	// 범주형 예제
	public static ColumnType c1(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { 0.5, 0.1, 2.0, -3.3, 0.2, 5.0, 6.0, 7.7, 8.0, new Double(9)};
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.getStringArea1().add("aaa");
		ct.getStringArea1().add("bbb");
		ct.getStringArea1().add("ccc");
		
		ct.getStringArea2().add("xxx");
		ct.getStringArea2().add("xxy");
		ct.getStringArea2().add("xyy");
		
		ct.getStringArea3().add("yyy");
		ct.getStringArea3().add("zzz");
		
		return ct;
	}
	
	// 수치형 예제
	public static ColumnType c5(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = {8.0, -0.2, 3.3, 3.0, 0.7, 0.3, 10.4};
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.setArea1Min((double) 0);
		ct.setArea1Max((double) 1);
		ct.setArea2Max(2.4);
		ct.setArea3Max(4.5);
		ct.setArea4Max((double) 6);
		return ct;
	}
	
	// minBeta 추출
	public static Double minBeta(Double[] beta) {
		double a = beta[0];
		double b = beta[1];
		for (int i = 0; i < beta.length; i++) {
			b = beta[i];
			if (a > b) {
				a = b;
			}
		}
		return a;
	}
}
