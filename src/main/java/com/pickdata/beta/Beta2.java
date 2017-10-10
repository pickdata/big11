package com.pickdata.beta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Beta2 {
	private double pod = 20;
	private Map<String, Double[]> map = new HashMap<String, Double[]>();

	List<String> area1 = new ArrayList<String>();
	List<String> area2 = new ArrayList<String>();
	List<String> area3 = new ArrayList<String>();

public Double minBeta(Double[] beta){

	double a = beta[0];
	double b=0;
	for(int i=0;i<beta.length;i++)
		b = beta[i];
		if(a<b){
			a = b;
		}
	return a;
}

	public ColumnType c1() {
		ColumnType ct = new ColumnType();
		Double[] beta = {};
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put("c1", beta);
		ct.getArea1().add("aaa");
		ct.getArea1().add("bbb");
		ct.getArea1().add("ccc");
		ct.getArea2().add("xxx");
		ct.getArea2().add("xxy");
		ct.getArea2().add("xyy");
		ct.getArea3().add("yyy");
		ct.getArea3().add("zzz");
		return ct;
	}
	public ColumnType c2() {
		ColumnType ct = new ColumnType();
		Double[] beta = {};
		ct.setMinBeta(minBeta(beta));
		ct.getMap().put("c2", beta);
		ct.getArea1().add("aaa");
		ct.getArea1().add("bbb");
		ct.getArea1().add("ccc");
		ct.getArea2().add("xxx");
		ct.getArea2().add("xxy");
		ct.getArea2().add("xyy");
		ct.getArea3().add("yyy");
		ct.getArea3().add("zzz");
		return ct;
	}

	// ColumnData 호출
	public ColumnType getColumn(String columnName) {
		ColumnType result = new ColumnType();
		if (columnName.equals("c1") || columnName.equals("C1")) {
			result = c1();
		}
		if (columnName.equals("c2") || columnName.equals("C2")) {
			result = c2();
		}
		return result;
	}

	// area + 베타 값 입력
	public Map<String, Double> mapPutter(String columnName, Double[] betas) {
		Map<String, Double> map = new HashMap<String, Double>();
		for (int i = 1; i < betas.length; i++) {
			String key = "area" + i;
			Double value = betas[i - 1];
			map.put(key, value);
		}
		return map;
	}

	// 호출 될 때 베타 맵을 만들어서 사용
	public Map<String, Double> map(String columnName) {

		return mapPutter(columnName, getColumn(columnName).getBeta());
	}

	public Map<String, Double> getCategory(String columnName, String customerValue) {
		Map<String, Double> cateMap = new HashMap<String, Double>();
		cateMap = map(columnName);
		
		return cateMap;
	}

	public double getScore(String columnName,String customerValue) {
		double score = 0;
		double beta = 0;
		double minBeta = getColumn(columnName).getMinBeta();
		ColumnList2 cl = new ColumnList2();
		
		if (cl.categoryData.contains(columnName)) {
			if(getColumn(columnName).getArea1().contains(customerValue)){
				// area1 키로 베타 값 찾기
				beta = getCategory(columnName, customerValue).get(area1);
			}
			if(getColumn(columnName).getArea2().contains(customerValue)){
				// area2 키로 베타 값 찾기
				beta = getCategory(columnName, customerValue).get(area2);
			}
			if(getColumn(columnName).getArea3().contains(customerValue)){
				// area3 키로 베타 값 찾기
				beta = getCategory(columnName, customerValue).get(area3);
			}
		}
		if (cl.nemericData.contains(columnName)) {

		}
		score = (beta - minBeta) * getPod() / Math.log10(2);
		return score;
	}


}
