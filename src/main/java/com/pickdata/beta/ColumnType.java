package com.pickdata.beta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColumnType {
	private Map<String, Double[]> map = new HashMap<String, Double[]>();
	private Double[] beta;
	private Double minBeta;

	private ArrayList<String> area1 = new ArrayList<String>();
	private ArrayList<String> area2 = new ArrayList<String>();
	private ArrayList<String> area3 = new ArrayList<String>();
}
