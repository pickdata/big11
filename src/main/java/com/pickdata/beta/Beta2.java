package com.pickdata.beta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Beta2 {
	private double pod = 20;

	Map<String, Double[]> map = new HashMap<String, Double[]>();

	List<String> area1 = new ArrayList<String>();
	List<String> area2 = new ArrayList<String>();
	List<String> area3 = new ArrayList<String>();

	public double getPod() {
		return pod;
	}

	public void setPod(double pod) {
		this.pod = pod;
	}

	public ColumnType c1() {
		ColumnType ct = new ColumnType();
		Double[] beta = {};
		ct.map.put("c1", beta);
		ct.area1.add("aaa");
		ct.area1.add("bbb");
		ct.area1.add("ccc");
		ct.area2.add("xxx");
		ct.area2.add("xxy");
		ct.area2.add("xyy");
		ct.area3.add("yyy");
		ct.area3.add("zzz");
		return ct;
	}
	public ColumnType c2() {
		ColumnType ct = new ColumnType();
		Double[] beta = {};
		ct.map.put("c1", beta);
		ct.area1.add("aaa");
		ct.area1.add("bbb");
		ct.area1.add("ccc");
		ct.area2.add("xxx");
		ct.area2.add("xxy");
		ct.area2.add("xyy");
		ct.area3.add("yyy");
		ct.area3.add("zzz");
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

	public void getCategory(String columnName, String customerValue) {
		Map<String, Double> cateMap = new HashMap<String, Double>();
		cateMap = map(columnName);

	}

	public double getScore(String columnName,String customerValue) {
		double score = 0;
		ColumnList2 cl = new ColumnList2();
		if (cl.categoryData.contains(columnName)) {
			if(getColumn(columnName).area1.contains(customerValue)){
				// area1 키로 베타 값 찾기
			}
			if(getColumn(columnName).area2.contains(customerValue)){
				// area2 키로 베타 값 찾기
			}
			if(getColumn(columnName).area3.contains(customerValue)){
				// area3 키로 베타 값 찾기
			}
			score = 0;
		}
		if (cl.nemericData.contains(columnName)) {

			score = 0;
		}
		return score;
	}


}
