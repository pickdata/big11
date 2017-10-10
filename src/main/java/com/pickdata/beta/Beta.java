package com.pickdata.beta;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Beta {

   String key = null;
   Double beta = 0.0;
   Double minBeta = 0.0;

   public Map<String, Double> mapPutter(Double[] betas) {
      Map<String, Double> map = new HashMap<String, Double>();
      for (int i = 0; i < betas.length; i++) {
         String name = i + "";
         Double value = betas[i];
         map.put(name, value);
      }
      return map;
   }

   public Map<String, Double> mapPutter(Double[] betas, int initialValue, int columnPlusValue) {
      Map<String, Double> map = new HashMap<String, Double>();
      for (int i = initialValue; i < betas.length; i++) {
         String name = i + columnPlusValue + "";
         Double value = betas[i];
         map.put(name, value);
      }
      return map;
   }

   public Map<String, Double> mapPutter(Double[] betas, int initialValue, String logisticName) {
      Map<String, Double> map = new HashMap<String, Double>();
      for (int i = initialValue; i < betas.length; i++) {
         String name = i + logisticName + "";
         Double value = betas[i];
         map.put(name, value);
      }
      return map;
   }

   public Map<String, Double> map(String columnName) {
      Map<String, Double> returnMap = new HashMap<String, Double>();

      // C1 범주값 0 ~ 5 증가값(+1)
      Map<String, Double> mapC1 = new HashMap<String, Double>();
      Double[] betasC1 = new Double[] { -2.348, -2.143, -1.7439, -1.1048, -1.7593, 0.0 };
      mapC1 = mapPutter(betasC1);

      // C3 범주값 0 ~ 7 증가값(+1)
      Map<String, Double> mapC3 = new HashMap<String, Double>();
      Double[] betasC3 = new Double[] { -5.2991, -3.9259, -3.1696, -2.5002, -1.893, -1.4402, -1.0237, 0.0 };
      mapC3 = mapPutter(betasC3);

      // C4 범주값 0 ~ 6 증가값(+1)
      Map<String, Double> mapC4 = new HashMap<String, Double>();
      Double[] betasC4 = new Double[] { 2.074, 1.4146, 1.3322, 1.1, 0.8249, -0.1597, 0.0 };
      mapC4 = mapPutter(betasC4);

      // C5 범주값 1
      Map<String, Double> mapC5 = new HashMap<String, Double>();
      String betasC5 = new String();
      mapC5.put(betasC5, -0.00000264);

      // C6 범주값 1
      Map<String, Double> mapC6 = new HashMap<String, Double>();
      String betasC6 = new String();
      mapC6.put(betasC6, 0.000001341);

      // C7 범주값 1
      Map<String, Double> mapC7 = new HashMap<String, Double>();
      String betasC7 = new String();
      mapC7.put(betasC7, -0.00000476);

      // C9 범주값 0, 1 ~ 121 증가값(+12)
      Map<String, Double> mapC9 = new HashMap<String, Double>();
      Double[] betasC9 = new Double[] { -0.3144, -0.3187, 0.1469, 0.1506, 0.4251, 0.5429, 0.7831, 0.7734, -0.2115,
            0.3215, -0.0464, 0.0 };
      // method overloading
      mapC9 = mapPutter(betasC9, 1, 12);
      mapC9.put("0", betasC9[0]);

      // C10 범주값 0, 1 ~ 121 증가값(+12)
      Map<String, Double> mapC10 = new HashMap<String, Double>();
      Double[] betasC10 = new Double[] { -0.026, -0.3472, 0.0402, 0.426, 0.6313, 0.7274, 0.6087, 0.157, 0.1364,
            -0.0446, 0.283, 0.0 };
      // method overloading
      mapC10 = mapPutter(betasC10, 1, 12);
      mapC10.put("0", betasC10[0]);

      // C11 범주값 0 ~ 11 증가값(+1)
      Map<String, Double> mapC11 = new HashMap<String, Double>();
      Double[] betasC11 = new Double[] { 7.9255, 1.6394, 1.0109, 0.3683, 0.0954, -0.2687, -0.3181, -1.3516, -0.6678,
            -0.4496, -0.4752, 0.0 };
      mapC11 = mapPutter(betasC11);

      // C12 범주값 0, 1 ~ 121 증가값(+12)
      Map<String, Double> mapC12 = new HashMap<String, Double>();
      Double[] betasC12 = new Double[] { -5.0047, -1.323, -0.2899, 0.4136, 0.4339, 0.3615, 0.0637, -0.0598, 0.2322,
            0.1051, -0.0442, 0.0 };
      mapC12 = mapPutter(betasC12, 1, 12);
      mapC12.put("0", betasC12[0]);

      // C13 범주값 0 ~ 10 증가값(+1)
      Map<String, Double> mapC13 = new HashMap<String, Double>();
      Double[] betasC13 = new Double[] { 5.643, 6.0564, 6.2273, 6.2523, 5.0692, 5.1747, 5.5321, 3.9058, 1.1619,
            -0.1376, 0.0 };
      mapC13 = mapPutter(betasC13);

      // C14
      Map<String, Double> mapC14 = new HashMap<String, Double>();
      String betasC14 = new String();
      mapC14.put(betasC14, 0.000001963);

      // I13
      Map<String, Double> mapI13 = new HashMap<String, Double>();
      String betasI13 = new String();
      mapI13.put(betasI13, -0.00535);

      // I16 범주값 0 ~ 7 증가값(+1)
      Map<String, Double> mapI16 = new HashMap<String, Double>();
      Double[] betasI16 = new Double[] { -0.445, 0.489, -0.621, -0.3011, -0.3735, -0.4128, 0.0218, 0.0 };
      mapI16 = mapPutter(betasI16);

      // I19 범주값 0,10미만,20미만,30미만,40미만,50미만,60미만,70마만, 80미만, 90미만,90이상
      Map<String, Double> mapI19 = new HashMap<String, Double>();
      Double[] betasI19 = new Double[] { -2.6013, -2.3938, -2.2092, -1.9705, -1.8395, -1.5484, -1.4247, 0.0, 0.0,-0.8939, 0.0 };
      // method overloading
      mapI19 = mapPutter(betasI19, 1, "0미만");
      // mapI19.put("90이상", betasI19[betasI19.length]);
      mapI19.put("90이상", betasI19[10]);
      mapI19.put("0", betasI19[0]);

      // I32 범주값 0 ~ 6, 증가값(+1)
      Map<String, Double> mapI32 = new HashMap<String, Double>();
      Double[] betasI32 = new Double[] { -1.9051, -1.2602, -0.7835, -0.9299, -2.0971, -1.0724, 0.0 };
      mapI32 = mapPutter(betasI32);

      // I36 연속형
      Map<String, Double> mapI36 = new HashMap<String, Double>();
      String betasI36 = new String();
      mapI36.put(betasI36, -0.0678);

      // age 범주값 0, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70
      Map<String, Double> mapAge = new HashMap<String, Double>();
      Double[] betasAge = new Double[] { 0.0, -0.5675, -0.4438, -0.1262, 0.2786, 0.1947, 0.2117, 0.1288, 0.0302,
            -0.2002, -0.3647, 0.0 };
      mapAge = mapPutter(betasAge, 1, 5);
      mapAge.put("0", betasAge[0]);

      // T3 범주값 E, Q, R, W
      Map<String, Double> mapT3 = new HashMap<String, Double>();
      mapT3.put("E", -0.0387);
      mapT3.put("Q", -0.0134);
      mapT3.put("R", -0.1467);
      mapT3.put("W", 0.0);

      // T4 연속형
      Map<String, Double> mapT4 = new HashMap<String, Double>();
      String betasT4 = new String();
      mapT4.put(betasT4, 0.000004689);

      // T5 연속형
      Map<String, Double> mapT5 = new HashMap<String, Double>();
      String betasT5 = new String();
      mapT5.put(betasT5, -0.00000143);

      // T7 범주값 0 ~ 1200000, 증가값(+100000)
      Map<String, Double> mapT7 = new HashMap<String, Double>();
      Double[] betasT7 = new Double[] { 4.0782, -0.9712, 3.1302, 3.6544, 3.4787, 3.5755, 3.4595, 3.6322, 3.7544,
            3.6875, 3.7613, 4.6255, 0.0 };
      mapT7 = mapPutter(betasT7, 1, 100000);
      mapT7.put("0", betasT7[0]);

      // T10 연속형
      Map<String, Double> mapT10 = new HashMap<String, Double>();
      String betasT10 = new String();
      mapT10.put(betasT10, 0.000001323);

      // T11 범주값 0 ~ 2, 증가값(+1)
      Map<String, Double> mapT11 = new HashMap<String, Double>();
      Double[] betasT11 = new Double[] { 0.1684, 1.3092, 0.0 };
      mapT11 = mapPutter(betasT11);

      // T12 연속형
      Map<String, Double> mapT12 = new HashMap<String, Double>();
      String betasT12 = new String();
      mapT12.put(betasT12, 0.000002006);

      // T13 범주값 G, K, O, R
      Map<String, Double> mapT13 = new HashMap<String, Double>();
      mapT13.put("G", 0.6372);
      mapT13.put("K", -0.9395);
      mapT13.put("O", -0.5939);
      mapT13.put("R", 0.0);

      // T14 범주값 S, U
      Map<String, Double> mapT14 = new HashMap<String, Double>();
      mapT14.put("S", 0.5336);
      mapT14.put("U", 0.0);

      // T15 연속형
      Map<String, Double> mapT15 = new HashMap<String, Double>();
      String betasT15 = new String();
      mapT15.put(betasT15, -0.00000121);

      if (columnName.equals("c1") || columnName.equals("C1")) {
         returnMap = mapC1;
      } else if (columnName.equals("c3") || columnName.equals("C3")) {
         returnMap = mapC3;
      } else if (columnName.equals("c4") || columnName.equals("C4")) {
         returnMap = mapC4;
      } else if (columnName.equals("c5") || columnName.equals("C5")) {
         returnMap = mapC5;
      } else if (columnName.equals("c6") || columnName.equals("C6")) {
         returnMap = mapC6;
      } else if (columnName.equals("c7") || columnName.equals("C7")) {
         returnMap = mapC7;
      } else if (columnName.equals("c9") || columnName.equals("C9")) {
         returnMap = mapC9;
      } else if (columnName.equals("c10") || columnName.equals("C10")) {
         returnMap = mapC10;
      } else if (columnName.equals("c11") || columnName.equals("C11")) {
         returnMap = mapC11;
      } else if (columnName.equals("c12") || columnName.equals("C12")) {
         returnMap = mapC12;
      } else if (columnName.equals("c13") || columnName.equals("C13")) {
         returnMap = mapC13;
      } else if (columnName.equals("c14") || columnName.equals("C14")) {
         returnMap = mapC14;
      } else if (columnName.equals("i13") || columnName.equals("I13")) {
         returnMap = mapI13;
      } else if (columnName.equals("i16") || columnName.equals("I16")) {
         returnMap = mapI16;
      } else if (columnName.equals("i19") || columnName.equals("I19")) {
         returnMap = mapI19;
      } else if (columnName.equals("i32") || columnName.equals("I32")) {
         returnMap = mapI32;
      } else if (columnName.equals("i36") || columnName.equals("I36")) {
         returnMap = mapI36;
      } else if (columnName.equals("age") || columnName.equals("AGE")) {
         returnMap = mapAge;
      } else if (columnName.equals("t3") || columnName.equals("T3")) {
         returnMap = mapT3;
      } else if (columnName.equals("t4") || columnName.equals("T4")) {
         returnMap = mapT4;
      } else if (columnName.equals("t5") || columnName.equals("T5")) {
         returnMap = mapT5;
      } else if (columnName.equals("t7") || columnName.equals("T7")) {
         returnMap = mapT7;
      } else if (columnName.equals("t10") || columnName.equals("T10")) {
         returnMap = mapT10;
      } else if (columnName.equals("t11") || columnName.equals("T11")) {
         returnMap = mapT11;
      } else if (columnName.equals("t12") || columnName.equals("T12")) {
         returnMap = mapT12;
      } else if (columnName.equals("t13") || columnName.equals("T13")) {
         returnMap = mapT13;
      } else if (columnName.equals("t14") || columnName.equals("T14")) {
         returnMap = mapT14;
      } else if (columnName.equals("t15") || columnName.equals("T15")) {
         returnMap = mapT15;
      }
      return returnMap;
   }

   public Double minBeta(Map<String, Double> map) {

      Set<Map.Entry<String, Double>> entrySet = map.entrySet();
      Iterator<Map.Entry<String, Double>> entryIterator = entrySet.iterator();

      while (entryIterator.hasNext()) {
         Map.Entry<String, Double> entry = entryIterator.next();
         beta = entry.getValue();
         if (beta <= minBeta) {
            minBeta = beta;
         }
      }

      return minBeta;
   }
}