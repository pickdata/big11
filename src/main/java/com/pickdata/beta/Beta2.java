package com.pickdata.beta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pickdata.columns.ColumnSelector;
import com.pickdata.columns.ColumnType;
import com.pickdata.columns.Columns;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

@Getter
@Setter
@ToString
@Log
public class Beta2 {
	
	private double pod = 20;
	private Map<String, Double[]> map = new HashMap<String, Double[]>();

	// Column 호출
	public ColumnType getColumn(String columnName) {
		ColumnType result = new ColumnType();
		if (columnName.equals("c1")) {
			result = Columns.c1(columnName);
		}  else if (columnName.equals("c2")) {
			result = Columns.c2(columnName);
		}  else if (columnName.equals("c3")) {
			result = Columns.c3(columnName);
		}  else if (columnName.equals("c4")) {
			result = Columns.c4(columnName);
		}  else if (columnName.equals("c9")) {
			result = Columns.c9(columnName);
		}  else if (columnName.equals("c10")) {
			result = Columns.c10(columnName);
		}  else if (columnName.equals("c11")) {
			result = Columns.c11(columnName);
		}  else if (columnName.equals("c12")) {
			result = Columns.c12(columnName);
		}  else if (columnName.equals("c13")) {
			result = Columns.c13(columnName);
		}  else if (columnName.equals("age")) {
			result = Columns.age(columnName);
		}  else if (columnName.equals("sex")) {
			result = Columns.sex(columnName);
		}  else if (columnName.equals("i9")) {
			result = Columns.i9(columnName);
		}  else if (columnName.equals("i16")) {
			result = Columns.i16(columnName);
		}  else if (columnName.equals("i19")) {
			result = Columns.i19(columnName);
		}  else if (columnName.equals("i32")) {
			result = Columns.i32(columnName);
		}  else if (columnName.equals("t11")) {
			result = Columns.t11(columnName);
		}  else if (columnName.equals("t13")) {
			result = Columns.t13(columnName);
		}  else if (columnName.equals("t14")) {
			result = Columns.t14(columnName);
		}  else if (columnName.equals("c5")) {
			result = Columns.c5(columnName);
		}  else if (columnName.equals("c6")) {
			result = Columns.c6(columnName);
		}  else if (columnName.equals("c7")) {
			result = Columns.c7(columnName);
		}  else if (columnName.equals("i30")) {
			result = Columns.i30(columnName);
		}  else if (columnName.equals("i33")) {
			result = Columns.i33(columnName);
		}  else if (columnName.equals("i36")) {
			result = Columns.i36(columnName);
		}  else if (columnName.equals("t1")) {
			result = Columns.t1(columnName);
		}  else if (columnName.equals("t2")) {
			result = Columns.t2(columnName);
		}  else if (columnName.equals("t3")) {
			result = Columns.t3(columnName);
		}  else if (columnName.equals("t4")) {
			result = Columns.t4(columnName);
		}  else if (columnName.equals("t5")) {
			result = Columns.t5(columnName);
		}  else if (columnName.equals("t7")) {
			result = Columns.t7(columnName);
		}  else if (columnName.equals("t15")) {
			result = Columns.t15(columnName);
		}  
		return result;
	}

	// 호출 될 때 베타 맵을 만들어서 사용
	public Map<String, Double> map(String columnName) {

		return mapPutter(columnName, getColumn(columnName).getBeta());
	}

	// area + 베타 값 입력
	public Map<String, Double> mapPutter(String columnName, Double[] betas) {
		Map<String, Double> map = new HashMap<String, Double>();
		for (int i = 1; i < betas.length+1; i++) {
			String key = "area" + i;
			Double value = betas[i - 1];
			map.put(key, value);
		}
		return map;
	}

	public double score(String columnName, String customerValue) {
		ColumnSelector cl = new ColumnSelector();
		Double score = null;
		Double beta = null;
		Double[] betas = new Double[10];
		Double minBeta = getColumn(columnName).getMinBeta();

		String str = "area";
		List<String> listArea = new ArrayList<String>();
		for (int i = 1; i <= 12; i++) {
			listArea.add(str + i);
		}

		for (int i = 0; i < betas.length; i++) {
			betas[i] = map(columnName).get(listArea.get(i));
		}

		if (cl.categoryData.contains(columnName)) {
			// area1~10 키로 베타 값 찾기
			if (getColumn(columnName).getStringArea1().contains(customerValue)) {
				beta = betas[0];
			} else if (getColumn(columnName).getStringArea2().contains(customerValue)) {
				beta = betas[1];
			} else if (getColumn(columnName).getStringArea3().contains(customerValue)) {
				beta = betas[2];
			} else if (getColumn(columnName).getStringArea4().contains(customerValue)) {
				beta = betas[3];
			} else if (getColumn(columnName).getStringArea5().contains(customerValue)) {
				beta = betas[4];
			} else if (getColumn(columnName).getStringArea6().contains(customerValue)) {
				beta = betas[5];
			} else if (getColumn(columnName).getStringArea7().contains(customerValue)) {
				beta = betas[6];
			} else if (getColumn(columnName).getStringArea8().contains(customerValue)) {
				beta = betas[7];
			} else if (getColumn(columnName).getStringArea9().contains(customerValue)) {
				beta = betas[8];
			} else if (getColumn(columnName).getStringArea10().contains(customerValue)) {
				beta = betas[9];
			}
		}
		if (cl.numericData.contains(columnName)) {
			Double value = Double.parseDouble(customerValue);
			if (getColumn(columnName).getArea1Min() <= value && value < getColumn(columnName).getArea1Max()) {
				beta = betas[0];
			} else if (getColumn(columnName).getArea1Max() <= value && value < getColumn(columnName).getArea2Max()) {
				beta = betas[1];
			} else if (getColumn(columnName).getArea2Max() <= value && value < getColumn(columnName).getArea3Max()) {
				beta = betas[2];
			} else if (getColumn(columnName).getArea3Max() <= value && value < getColumn(columnName).getArea4Max()) {
				beta = betas[3];
			} else if (getColumn(columnName).getArea4Max() <= value && value < getColumn(columnName).getArea5Max()) {
				beta = betas[4];
			} else if (getColumn(columnName).getArea5Max() <= value && value < getColumn(columnName).getArea6Max()) {
				beta = betas[5];
			} else if (getColumn(columnName).getArea6Max() <= value && value < getColumn(columnName).getArea7Max()) {
				beta = betas[6];
			} else if (getColumn(columnName).getArea7Max() <= value && value < getColumn(columnName).getArea8Max()) {
				beta = betas[7];
			} else if (getColumn(columnName).getArea8Max() <= value && value < getColumn(columnName).getArea9Max()) {
				beta = betas[8];
			} else if (getColumn(columnName).getArea9Max() <= value && value < getColumn(columnName).getArea10Max()) {
				beta = betas[9];
			}
		}
		log.info("beta = " + beta);
		log.info("minBeta = " + minBeta);
		score = (beta - minBeta) * getPod() / Math.log10(2);
		
		return score;
	}

}
