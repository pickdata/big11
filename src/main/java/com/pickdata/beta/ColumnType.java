package com.pickdata.beta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ColumnType {
	Map<String, Double[]> map = new HashMap<String, Double[]>();
	private Double[] beta;

	public Map<String, Double[]> getMap() {
		return map;
	}

	public void setMap(Map<String, Double[]> map) {
		this.map = map;
	}

	public Double[] getBeta() {
		return beta;
	}

	public void setBeta(Double[] beta) {
		this.beta = beta;
	}

	public ArrayList<String> getArea1() {
		return area1;
	}

	public void setArea1(ArrayList<String> area1) {
		this.area1 = area1;
	}

	public ArrayList<String> getArea2() {
		return area2;
	}

	public void setArea2(ArrayList<String> area2) {
		this.area2 = area2;
	}

	public ArrayList<String> getArea3() {
		return area3;
	}

	public void setArea3(ArrayList<String> area3) {
		this.area3 = area3;
	}

	ArrayList<String> area1 = new ArrayList<String>();
	ArrayList<String> area2 = new ArrayList<String>();
	ArrayList<String> area3 = new ArrayList<String>();
}
