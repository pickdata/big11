package com.pickdata.beta;

public class Score {
   private int pod = 20;

   // scoreCal 메소드에서 매개변수로 입력받은 컬럼명과 고객 범주값을 가지고
   // 베타값과 최소베타값을 찾아 옵셋계산 후 반환한다.
   public double offset(String columnName,String customerValue) {
      Double minBeta;
      Double beta;
      Beta betaClass = new Beta();
      
      beta = betaClass.map(columnName).get(customerValue);
      // 컬럼명을 매개변수로 하여 베타맵을 호출한 뒤에 리턴된 해당 컬럼맵을 
      // minbeta 메소드의 매개변수로 입력하여 min값 구하기
      minBeta = betaClass.minBeta(betaClass.map(columnName));
      return (beta) - (minBeta);
   }
   
   // 매퍼에서 넘겨받은 컬럼명과, 고객의 범주값을 옵셋의 매개변수로 전달한다.
   // 옵셋에서 처리한뒤 결과값만 받아서 계산식에 적용한 후 총점 값을 반환한다.
   public double scoreCal(String columnName,String customerValue) {
      return offset(columnName,customerValue) * pod / Math.log(2);
   }

   public int getPod() {
      return pod;
   }
   
   public void setPod(int pod) {
      this.pod = pod;
   }
}