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
public class Beta {

	private double pdo = 20;
	private Map<String, Double[]> map = new HashMap<String, Double[]>();

	

	// 호출 될 때 베타 맵을 만들어서 사용
	public Map<String, Double> map(String columnName) {

		return mapPutter(columnName, Columns.getColumn(columnName).getBeta());
	}

	// area + 베타 값 입력
	public Map<String, Double> mapPutter(String columnName, Double[] betas) {
		Map<String, Double> map = new HashMap<String, Double>();
		for (int i = 1; i < betas.length + 1; i++) {
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
		Double[] betas = new Double[15];
		Double minBeta = Columns.getColumn(columnName).getMinBeta();

		String str = "area";
		List<String> listArea = new ArrayList<String>();
		for (int i = 1; i <= 15; i++) {
			listArea.add(str + i);
		}

		for (int i = 0; i < betas.length; i++) {
			betas[i] = map(columnName).get(listArea.get(i));
		}

		if (cl.categoryData.contains(columnName)) {
			// area1~10 키로 베타 값 찾기
			if (Columns.getColumn(columnName).getStringArea1().contains(customerValue)) {
//				System.out.println(betas[0]);
				beta = betas[0];
			} else if (Columns.getColumn(columnName).getStringArea2().contains(customerValue)) {
				beta = betas[1];
			} else if (Columns.getColumn(columnName).getStringArea3().contains(customerValue)) {
				beta = betas[2];
			} else if (Columns.getColumn(columnName).getStringArea4().contains(customerValue)) {
				beta = betas[3];
			} else if (Columns.getColumn(columnName).getStringArea5().contains(customerValue)) {
				beta = betas[4];
			} else if (Columns.getColumn(columnName).getStringArea6().contains(customerValue)) {
				beta = betas[5];
			} else if (Columns.getColumn(columnName).getStringArea7().contains(customerValue)) {
				beta = betas[6];
			} else if (Columns.getColumn(columnName).getStringArea8().contains(customerValue)) {
				beta = betas[7];
			} else if (Columns.getColumn(columnName).getStringArea9().contains(customerValue)) {
				beta = betas[8];
			} else if (Columns.getColumn(columnName).getStringArea10().contains(customerValue)) {
				beta = betas[9];
			} else if (Columns.getColumn(columnName).getStringArea11().contains(customerValue)) {
				beta = betas[10];
			} else if (Columns.getColumn(columnName).getStringArea12().contains(customerValue)) {
				beta = betas[11];
			} else if (Columns.getColumn(columnName).getStringArea13().contains(customerValue)) {
				beta = betas[12];
			} else if (Columns.getColumn(columnName).getStringArea14().contains(customerValue)) {
				beta = betas[13];
			} else if (Columns.getColumn(columnName).getStringArea15().contains(customerValue)) {
				beta = betas[14];
			}
		}
		if (cl.numericData.contains(columnName)) {
			Double value = Double.parseDouble(customerValue);
			if (Columns.getColumn(columnName).getArea1Min() <= value && value < Columns.getColumn(columnName).getArea1Max()) {
				beta = betas[0];
			} else if (Columns.getColumn(columnName).getArea1Max() <= value && value < Columns.getColumn(columnName).getArea2Max()) {
				beta = betas[1];
			} else if (Columns.getColumn(columnName).getArea2Max() <= value && value < Columns.getColumn(columnName).getArea3Max()) {
				beta = betas[2];
			} else if (Columns.getColumn(columnName).getArea3Max() <= value && value < Columns.getColumn(columnName).getArea4Max()) {
				beta = betas[3];
			} else if (Columns.getColumn(columnName).getArea4Max() <= value && value < Columns.getColumn(columnName).getArea5Max()) {
				beta = betas[4];
			} else if (Columns.getColumn(columnName).getArea5Max() <= value && value < Columns.getColumn(columnName).getArea6Max()) {
				beta = betas[5];
			} else if (Columns.getColumn(columnName).getArea6Max() <= value && value < Columns.getColumn(columnName).getArea7Max()) {
				beta = betas[6];
			} else if (Columns.getColumn(columnName).getArea7Max() <= value && value < Columns.getColumn(columnName).getArea8Max()) {
				beta = betas[7];
			} else if (Columns.getColumn(columnName).getArea8Max() <= value && value < Columns.getColumn(columnName).getArea9Max()) {
				beta = betas[8];
			} else if (Columns.getColumn(columnName).getArea9Max() <= value && value < Columns.getColumn(columnName).getArea10Max()) {
				beta = betas[9];
			} else if (Columns.getColumn(columnName).getArea10Max() <= value && value < Columns.getColumn(columnName).getArea11Max()) {
				beta = betas[10];
			} else if (Columns.getColumn(columnName).getArea11Max() <= value && value < Columns.getColumn(columnName).getArea12Max()) {
				beta = betas[11];
			} else if (Columns.getColumn(columnName).getArea12Max() <= value && value < Columns.getColumn(columnName).getArea13Max()) {
				beta = betas[12];
			} else if (Columns.getColumn(columnName).getArea13Max() <= value && value < Columns.getColumn(columnName).getArea14Max()) {
				beta = betas[13];
			} else if (Columns.getColumn(columnName).getArea14Max() <= value && value < Columns.getColumn(columnName).getArea15Max()) {
				beta = betas[14];
			}

		}
		log.info("beta = " + beta);
		log.info("minBeta = " + minBeta);
		score = (beta - minBeta) * getPdo() / Math.log10(2);
		return score;

	}
}