# 데이터 저장 및 처리 (맵리듀스)
- 하둡 파일 시스템 (HDFS)에 업로드한 데이터 파일을 읽은 후 매퍼,리듀서 작업 결과를 출력
- 복합키(ID와 변수명)를 사용하여 ID 기준 정렬 및 그룹화하여 잡의 성능을 향상
- 매퍼에서 ID, 변수별로 점수를 계산하고 리듀서에서 ID 그룹에 대하여 점수를 합산
- 리듀서 작업 결과는 HDFS에 저장, CSV파일로 다운로드 받음

# 클래스 요약
### [<ColumnType.class>](https://github.com/pickdata/hadoop/blob/master/src/main/java/com/pickdata/columns/ColumnType.java)
- 평가에 필요한 값들을 저장할 수 있는 데이터 타입 클래스를 설계(컬럼명, 통계 베타값 저장, 값 범위 저장)
### [<ColumnSelector.class>](https://github.com/pickdata/hadoop/blob/master/src/main/java/com/pickdata/columns/ColumnSelector.java)
- 데이터 분석 과정에서 파악한 변수의 성질을 2가지 종류로 분류한 리스트를 갖고 있으며, <br/>
  Beta.score()에 의하여 호출시 현재 변수가 어떤 타입의 변수인지 판단 가능
### [<ColumnList.class>](https://github.com/pickdata/hadoop/blob/master/src/main/java/com/pickdata/columns/ColumnList.java)
- 매퍼가 인덱스로 참조할 수 있도록 배열 형태를 취하고 있으며 <br/>
리스트에 있는 변수명만 루프를 돌기 때문에 취급 변수 갯수 변화에 편리하도록 유지 보수성을 고려함
### [<Columns.class>](https://github.com/pickdata/hadoop/blob/master/src/main/java/com/pickdata/columns/Columns.java)
- 각각의 변수에 대한 정보를 담고 있는 클래스
- Beta.score()에 의하여 호출시 현재 사용변수를 찾아 해당 변수의 저장된 정보값을 컬럼 타입으로 반환
### [<Beta.class>](https://github.com/pickdata/hadoop/blob/master/src/main/java/com/pickdata/beta/Beta.java)
- 변수의 점수 계산에 필요한 식을 담고 있는 클래스
- 점수 계산식 : score = (beta - minBeta) * getPdo() / Math.log10(2);
- beta값 : Columns.getColumn(변수명)을 통해 해당 변수의 구간을 불러오고, if 문으로 해당 구간을 찾아 베타값 저장
- minbeta값 : Columns.getColumn(변수명).getMinbeta() 함수를 통해 값을 저장
- Pdo 값 : Beta Class 내에서 선언한 값 ( 이항 분기 테스트를 통하여 구한 값 )
- Math.log10(2) : 상수 로그 값

