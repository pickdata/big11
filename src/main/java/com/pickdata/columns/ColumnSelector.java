package com.pickdata.columns;

import java.util.ArrayList;
import java.util.List;

public class ColumnSelector {
	public List<String> categoryData = new ArrayList<String>();
	public List<String> numericData = new ArrayList<String>();
	public ColumnSelector(){
		// 범주형
		categoryData.add("c1");
		categoryData.add("c2");
		categoryData.add("c3");
		categoryData.add("c4");
		categoryData.add("c9");
		categoryData.add("c10");
		categoryData.add("c11");
		categoryData.add("c12");
		categoryData.add("c13");
		categoryData.add("age");
		categoryData.add("sex");
		categoryData.add("i9");
		categoryData.add("i16");
		categoryData.add("ci19");
		categoryData.add("i32");
		categoryData.add("t11");
		categoryData.add("t13");
		categoryData.add("t14");
		
		
		// 수치형
		numericData.add("c5");
		numericData.add("c6");
		numericData.add("c7");
		numericData.add("i30");
		numericData.add("ci33");
		numericData.add("ci36");
		numericData.add("t1");
		numericData.add("t2");
		numericData.add("t3");
		numericData.add("t4");
		numericData.add("t5");
		numericData.add("t7");
		numericData.add("t15");
		
	}

}
