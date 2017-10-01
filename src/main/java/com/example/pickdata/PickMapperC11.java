package com.example.pickdata;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.pickdata.beta.Beta;
import com.pickdata.parser.BigContestParser;

public class PickMapperC11 extends Mapper<Text, Text, Text, DoubleWritable> {
	/*
	 * 텍스트를 더블로 변환할 수 없어서 DoubleWritable로 변경
	 */
	
	Text outputKey = new Text();
	DoubleWritable outValue = new DoubleWritable();
	Beta betaClass = new Beta();
	Double beta;
	ScoreC11 scoreTable = new ScoreC11();
	int range = 0;

	 @Override
	   protected void map(Text key, Text value, Context context) throws IOException, InterruptedException {
	      BigContestParser parser = new BigContestParser(value);

	      // Paser를 통해 고객의 c11번째 범주값을 구한다.
	      /*
	       * parser의 key - value는 변수 이름 - 해당 범주값
	       * 변수 이름 c11로 해당 고객의 c11 값을 가져온다.
	       * 
	       * #### 시연이가 제기한 문제 : double 과 integer 변환에서 생기는 문제
	       * #### 예를 들어, 실제 데이터는 2인데, 파서가 double로 되어 있어서 2.0으로 인식
	       * #### 파서는 integer로 변환해도 되지 않을까?
	       */
	      Double yyy = (Double) parser.map.get("c11");
	      int c11Value = yyy.intValue();
	      
	      // 범주값을 키로 베타 값을 구함.
	      beta = betaClass.mapc11().get("b"+c11Value);
	      
	      // 옵셋값을 구함. (베타 값을 이미 알고 있음)
	      Double offset = scoreTable.offsetC11(beta);
	      
	      // 고객 번호를 매퍼의 출력 키(Text) 값으로 함.
	      outputKey.set(parser.map.get("id") + "");
	      
	      // 점수를  매퍼의 출력 밸류(Text) 값으로 함.
	      outValue.set(scoreTable.scoreCal(offset));
	      
	      context.write(outputKey, outValue);
	   }

}
