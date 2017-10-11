package com.pickdata.columns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColumnType {
	private Map<String, Double[]> map = new HashMap<String, Double[]>();
	private Double[] beta;
	private Double minBeta;

	private ArrayList<String> stringArea1 = new ArrayList<String>();
	private ArrayList<String> stringArea2 = new ArrayList<String>();
	private ArrayList<String> stringArea3 = new ArrayList<String>();
	private ArrayList<String> stringArea4 = new ArrayList<String>();
	private ArrayList<String> stringArea5 = new ArrayList<String>();
	private ArrayList<String> stringArea6 = new ArrayList<String>();
	private ArrayList<String> stringArea7 = new ArrayList<String>();
	private ArrayList<String> stringArea8 = new ArrayList<String>();
	private ArrayList<String> stringArea9 = new ArrayList<String>();
	private ArrayList<String> stringArea10 = new ArrayList<String>();
	private ArrayList<String> stringArea11 = new ArrayList<String>();
	private ArrayList<String> stringArea12 = new ArrayList<String>();
	
	private Double area1Min;
	private Double area1Max;
	private Double area2Max;
	private Double area3Max;
	private Double area4Max;
	private Double area5Max;
	private Double area6Max;
	private Double area7Max;
	private Double area8Max;
	private Double area9Max;
	private Double area10Max;
	
	
	
}
