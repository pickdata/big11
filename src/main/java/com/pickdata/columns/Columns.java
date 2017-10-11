package com.pickdata.columns;

public class Columns {

	// 범주형 예제
	public static ColumnType c1(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { -0.018, -0.0201, -0.00216, 0.00861, new Double(0) };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.getStringArea1().add("1");
		ct.getStringArea2().add("0");
		ct.getStringArea3().add("2");
		ct.getStringArea4().add("3");
		ct.getStringArea5().add("4");
		ct.getStringArea5().add("5");
		return ct;
	}

	public static ColumnType c2(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { -0.1261, -0.1115, -0.0884, -0.0755, -0.0393, new Double(0) };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.getStringArea1().add("0");
		ct.getStringArea2().add("1");
		ct.getStringArea3().add("2");
		ct.getStringArea4().add("3");
		ct.getStringArea5().add("4");
		ct.getStringArea6().add("5");
		return ct;
	}

	public static ColumnType c3(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { -0.0234, -0.0183, -0.00536, 0.000788, 0.00723, 0.000013, new Double(0) };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.getStringArea1().add("0");
		ct.getStringArea2().add("1");
		ct.getStringArea3().add("2");
		ct.getStringArea4().add("3");
		ct.getStringArea5().add("4");
		ct.getStringArea6().add("5");
		ct.getStringArea7().add("6");
		ct.getStringArea7().add("7");
		return ct;
	}

	public static ColumnType c4(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { -0.0742, -0.0747, -0.0501, -0.0282, new Double(0) };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.getStringArea1().add("0");
		ct.getStringArea2().add("1");
		ct.getStringArea3().add("2");
		ct.getStringArea4().add("3");
		ct.getStringArea5().add("4");
		ct.getStringArea5().add("5");
		ct.getStringArea5().add("6");

		return ct;
	}

	public static ColumnType c9(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { -0.00683, -0.0126, 0.00957, 0.00755, 0.0189, 0.0211, -0.00795, 0.03, 0.0219, 0.000483,
				0.00793, 0.0 };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.getStringArea1().add("1");
		ct.getStringArea2().add("0");
		ct.getStringArea3().add("13");
		ct.getStringArea4().add("25");
		ct.getStringArea5().add("37");
		ct.getStringArea6().add("49");
		ct.getStringArea7().add("121");
		ct.getStringArea8().add("61");
		ct.getStringArea9().add("73");
		ct.getStringArea10().add("85");
		ct.getStringArea11().add("97");
		ct.getStringArea12().add("109");

		return ct;
	}

	public static ColumnType c10(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { -0.021, -0.0211, -0.0119, 0.0131, 0.0455, -0.0116, 0.0581, 0.0669, 0.014, -0.0048, -0.0103,
				new Double(0) };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.getStringArea1().add("0");
		ct.getStringArea2().add("1");
		ct.getStringArea3().add("13");
		ct.getStringArea4().add("25");
		ct.getStringArea5().add("37");
		ct.getStringArea6().add("121");
		ct.getStringArea7().add("49");
		ct.getStringArea8().add("61");
		ct.getStringArea9().add("73");
		ct.getStringArea10().add("85");
		ct.getStringArea11().add("97");
		ct.getStringArea12().add("109");
		return ct;
	}

	public static ColumnType c11(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { 0.0138, 0.0285, 0.00941, 0.0544, 0.0049, 0.2406, 0.00437, -0.00608, -0.00254, new Double(0) };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.getStringArea1().add("3");
		ct.getStringArea2().add("2");
		ct.getStringArea3().add("4");
		ct.getStringArea4().add("1");
		ct.getStringArea5().add("5");
		ct.getStringArea6().add("0");
		ct.getStringArea7().add("6");
		ct.getStringArea8().add("7");
		ct.getStringArea9().add("8");
		ct.getStringArea10().add("9");
		ct.getStringArea10().add("10");
		ct.getStringArea10().add("11");
		return ct;
	}

	public static ColumnType c12(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { 0.0332, -0.0281, 0.0342, 0.0339, 0.0315, 0.045, 0.0368, 0.0499, 0.0298, 0.0509, 0.0197,
				new Double(0) };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.getStringArea1().add("121");
		ct.getStringArea2().add("0");
		ct.getStringArea3().add("97");
		ct.getStringArea4().add("61");
		ct.getStringArea5().add("109");
		ct.getStringArea6().add("49");
		ct.getStringArea7().add("85");
		ct.getStringArea8().add("37");
		ct.getStringArea9().add("73");
		ct.getStringArea10().add("25");
		ct.getStringArea11().add("13");
		ct.getStringArea12().add("1");
		return ct;
	}

	public static ColumnType c13(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { -0.0234, -0.00399, 0.0145, new Double(0) };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.getStringArea1().add("0");
		ct.getStringArea2().add("1");
		ct.getStringArea3().add("2");
		ct.getStringArea4().add("3");
		ct.getStringArea4().add("4");
		ct.getStringArea4().add("5");
		ct.getStringArea4().add("6");
		ct.getStringArea4().add("7");
		ct.getStringArea4().add("8");
		ct.getStringArea4().add("9");
		ct.getStringArea4().add("10");

		return ct;
	}

	public static ColumnType age(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { -0.00317, 0.0458, 0.0422, 0.0379, 0.0453, 0.0485, 0.0301, 0.0254, 0.025, -0.00861,
				new Double(0) };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getStringArea1().add("0");
		ct.getStringArea2().add("45");
		ct.getStringArea3().add("50");
		ct.getStringArea4().add("55");
		ct.getStringArea5().add("40");
		ct.getStringArea6().add("35");
		ct.getStringArea7().add("60");
		ct.getStringArea8().add("30");
		ct.getStringArea9().add("65");
		ct.getStringArea10().add("25");
		ct.getStringArea11().add("20");
		ct.getStringArea11().add("70");

		return ct;
	}
	
	public static ColumnType sex(String columnName) {
	      ColumnType ct = new ColumnType();
	      Double[] beta = { 0.0, -0.00642, 0.0};
	      ct.setBeta(beta);
	      ct.setMinBeta(minBeta(beta));
	      ct.getMap().put(columnName, beta);
	      ct.getStringArea1().add("0");
	      ct.getStringArea2().add("1");
	      ct.getStringArea3().add("2");
	      
	      return ct;
	   }

	public static ColumnType i9(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { -0.0124, -0.0075, -0.00662, -0.00446, 0.0 };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.getStringArea1().add("0");
		ct.getStringArea2().add("1");
		ct.getStringArea3().add("2");
		ct.getStringArea4().add("3");
		ct.getStringArea5().add("4");
		ct.getStringArea5().add("5");
		ct.getStringArea5().add("6");
		ct.getStringArea5().add("7");
		ct.getStringArea5().add("8");
		ct.getStringArea5().add("9");
		ct.getStringArea5().add("11");

		return ct;
	}

	public static ColumnType i16(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { -0.0423, -0.0339, -0.0311, -0.0306, -0.0359, -0.0159, 0.0 };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.getStringArea1().add("0");
		ct.getStringArea2().add("5");
		ct.getStringArea3().add("4");
		ct.getStringArea4().add("3");
		ct.getStringArea5().add("2");
		ct.getStringArea6().add("6");
		ct.getStringArea7().add("1");
		ct.getStringArea7().add("7");

		return ct;
	}

	public static ColumnType i19(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { -0.2266, -0.2245, -0.2193, -0.209, -0.2066, -0.1815, -0.1058, -0.1808, 0.0 };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.getStringArea1().add("0");
		ct.getStringArea2().add("10미만");
		ct.getStringArea3().add("20미만");
		ct.getStringArea4().add("30미만");
		ct.getStringArea5().add("40미만");
		ct.getStringArea6().add("50미만");
		ct.getStringArea7().add("90미만");
		ct.getStringArea8().add("60미만");
		ct.getStringArea9().add("90이상");

		return ct;
	}

	public static ColumnType i32(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { -0.0699, -0.0299, 0.0 };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.getStringArea1().add("0");
		ct.getStringArea2().add("1");
		ct.getStringArea3().add("2");
		ct.getStringArea3().add("3");
		ct.getStringArea3().add("4");
		ct.getStringArea3().add("5");
		ct.getStringArea3().add("6");

		return ct;
	}

	public static ColumnType t11(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { -0.0716, 0.0, -0.0716 };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.getStringArea1().add("0");
		ct.getStringArea2().add("1");
		ct.getStringArea2().add("2");

		return ct;
	}

	public static ColumnType t13(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { -0.0408, -0.0518, -0.0587, 0.1193, 0.0 };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.getStringArea1().add("missing");
		ct.getStringArea2().add("O");
		ct.getStringArea3().add("K");
		ct.getStringArea4().add("G");
		ct.getStringArea5().add("R");

		return ct;
	}

	public static ColumnType t14(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { -0.0613, 0.0 };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.getStringArea1().add("U");
		ct.getStringArea2().add("S");

		return ct;
	}

	// 수치형 예제
	public static ColumnType c5(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { 0.0555, 0.0336, 0.02, 0.00779, new Double(0) };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.setArea1Min((double) 0);
		ct.setArea2Max((double) 9001);
		ct.setArea2Max((double) 24001);
		ct.setArea3Max((double) 57001);
		ct.setArea4Max((double) 129001);
		ct.setArea5Max(Double.MAX_VALUE);

		return ct;
	}

	public static ColumnType c6(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { 0.0555, 0.0336, 0.02, 0.00779, new Double(0) };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.setArea1Min((double) 0);
		ct.setArea1Max((double) 15001);
		ct.setArea2Max((double) 15001);
		ct.setArea3Max((double) 39001);
		ct.setArea4Max(Double.MAX_VALUE);

		return ct;
	}

	public static ColumnType c7(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { -0.0124, -0.00603, -0.00474, 0.0 };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.setArea1Min((double) 0);
		ct.setArea1Max((double) 3001);
		ct.setArea2Max((double) 24001);
		ct.setArea3Max((double) 87001);
		ct.setArea4Max(Double.MAX_VALUE);
		return ct;
	}

	public static ColumnType i30(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { 0.00754, 0.00196, 0.00197, 0.00449, 0.0 };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.setArea1Min((double) 0);
		ct.setArea1Max((double) 5000000);
		ct.setArea2Max((double) 11000000);
		ct.setArea3Max((double) 21000000);
		ct.setArea4Max((double) 41000000);
		ct.setArea5Max(Double.MAX_VALUE);
		return ct;
	}

	public static ColumnType i33(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { -0.00524, -0.00286, 0.0 };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.setArea1Min((double) 0);
		ct.setArea1Max((double) 1);
		ct.setArea2Max((double) 3);
		ct.setArea3Max(Double.MAX_VALUE);
		return ct;
	}

	public static ColumnType i36(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { 0.0104, -0.00382, 0.0 };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.setArea1Min((double) 0);
		ct.setArea1Max((double) 1);
		ct.setArea2Max((double) 2);
		ct.setArea3Max(Double.MAX_VALUE);
		return ct;
	}

	public static ColumnType t1(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { -0.0124, -0.0075, -0.00662, -0.00446, new Double(0) };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.setArea1Min((double) 0);
		ct.setArea2Max((double) 49);
		ct.setArea2Max((double) 126);
		ct.setArea3Max((double) 228);
		ct.setArea4Max((double) 431);
		ct.setArea5Max(Double.MAX_VALUE);

		return ct;
	}

	public static ColumnType t2(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { 0.00538, 0.00991, 0.00844, 0.00445, 0.0 };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.setArea1Min(Double.MIN_VALUE);
		ct.setArea1Max((double) 15);
		ct.setArea2Max((double) 100);
		ct.setArea3Max((double) 172);
		ct.setArea4Max((double) 276);
		ct.setArea5Max(Double.MAX_VALUE);
		return ct;
	}

	public static ColumnType t3(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { -0.0012, 0.000234, 0.00758, 0.00427, 0.0 };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.getStringArea1().add("MISSING");
		ct.getStringArea2().add("R");
		ct.getStringArea3().add("W");
		ct.getStringArea4().add("Q");
		ct.getStringArea5().add("E");

		return ct;
	}

	public static ColumnType t4(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { 0.00072, 0.00285, -0.00325, -0.0048, 0.0 };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.setArea1Min(Double.MIN_VALUE);
		ct.setArea1Max((double) 30000);
		ct.setArea2Max((double) 40000);
		ct.setArea3Max((double) 50000);
		ct.setArea4Max((double) 60000);
		ct.setArea5Max(Double.MAX_VALUE);
		return ct;
	}

	public static ColumnType t5(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { -0.0227, -0.015, -0.00214, -0.00087, 0.0 };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.setArea1Min(Double.MIN_VALUE);
		ct.setArea1Max((double) 40000);
		ct.setArea2Max((double) 50000);
		ct.setArea3Max((double) 70000);
		ct.setArea4Max((double) 100000);
		ct.setArea5Max(Double.MAX_VALUE);
		return ct;
	}

	public static ColumnType t7(String columnName) {
		ColumnType ct = new ColumnType();
		Double[] beta = { 0.013, -0.00691, -0.00452, -0.00577, -0.00482, -0.00898, -0.00758, -0.0101, -0.0112, -0.0156,
				0.0 };
		ct.setBeta(beta);
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put(columnName, beta);
		ct.getStringArea1().add("0");
		ct.getStringArea2().add("100000");
		ct.getStringArea3().add("200000");
		ct.getStringArea4().add("300000");
		ct.getStringArea5().add("400000");
		ct.getStringArea6().add("500000");
		ct.getStringArea7().add("600000");
		ct.getStringArea8().add("700000");
		ct.getStringArea9().add("800000");
		ct.getStringArea10().add("900000");
		ct.getStringArea11().add("1000000");
		ct.getStringArea11().add("1100000");
		ct.getStringArea11().add("1200000");

		return ct;
	}

	   public static ColumnType t15(String columnName) {
		      ColumnType ct = new ColumnType();
		      Double[] beta = {0.0267, 0.0166, 0.00914, 0.0};
		      ct.setBeta(beta);
		      ct.setMinBeta(minBeta(beta));
		      ct.getMap().put(columnName, beta);
		      ct.setArea1Min((double) 0);
		      ct.setArea1Max((double) 30000);
		      ct.setArea2Max((double) 160000);
		      ct.setArea3Max((double) 390000);
		      ct.setArea4Max(Double.MAX_VALUE);
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
