package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;

final class FieldParser
{
  private static final Object[][] FOUR_DIGIT_DATA_LENGTH;
  private static final Object[][] THREE_DIGIT_DATA_LENGTH;
  private static final Object[][] THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH;
  private static final Object[][] TWO_DIGIT_DATA_LENGTH;
  private static final Object VARIABLE_LENGTH = new Object();
  
  static
  {
    Object localObject3 = { "00", Integer.valueOf(18) };
    Object localObject4 = { "01", Integer.valueOf(14) };
    Object localObject5 = { "10", VARIABLE_LENGTH, Integer.valueOf(20) };
    Object localObject6 = { "11", Integer.valueOf(6) };
    Object localObject7 = { "12", Integer.valueOf(6) };
    Object localObject8 = { "13", Integer.valueOf(6) };
    Object localObject9 = { "15", Integer.valueOf(6) };
    Object[] arrayOfObject1 = { "17", Integer.valueOf(6) };
    Object[] arrayOfObject2 = { "20", Integer.valueOf(2) };
    Object[] arrayOfObject3 = { "21", VARIABLE_LENGTH, Integer.valueOf(20) };
    Object[] arrayOfObject4 = { "22", VARIABLE_LENGTH, Integer.valueOf(29) };
    Object localObject1 = VARIABLE_LENGTH;
    Object[] arrayOfObject5 = { "37", VARIABLE_LENGTH, Integer.valueOf(8) };
    Object[] arrayOfObject6 = { "90", VARIABLE_LENGTH, Integer.valueOf(30) };
    Object[] arrayOfObject7 = { "91", VARIABLE_LENGTH, Integer.valueOf(30) };
    Object[] arrayOfObject8 = { "92", VARIABLE_LENGTH, Integer.valueOf(30) };
    Object localObject2 = VARIABLE_LENGTH;
    Object[] arrayOfObject9 = { "94", VARIABLE_LENGTH, Integer.valueOf(30) };
    Object[] arrayOfObject10 = { "95", VARIABLE_LENGTH, Integer.valueOf(30) };
    Object[] arrayOfObject11 = { "96", VARIABLE_LENGTH, Integer.valueOf(30) };
    Object[] arrayOfObject12 = { "97", VARIABLE_LENGTH, Integer.valueOf(30) };
    Object[] arrayOfObject13 = { "98", VARIABLE_LENGTH, Integer.valueOf(30) };
    Object[] arrayOfObject14 = { "99", VARIABLE_LENGTH, Integer.valueOf(30) };
    TWO_DIGIT_DATA_LENGTH = new Object[][] { localObject3, localObject4, { "02", Integer.valueOf(14) }, localObject5, localObject6, localObject7, localObject8, localObject9, arrayOfObject1, arrayOfObject2, arrayOfObject3, arrayOfObject4, { "30", localObject1, Integer.valueOf(8) }, arrayOfObject5, arrayOfObject6, arrayOfObject7, arrayOfObject8, { "93", localObject2, Integer.valueOf(30) }, arrayOfObject9, arrayOfObject10, arrayOfObject11, arrayOfObject12, arrayOfObject13, arrayOfObject14 };
    localObject3 = new Object[] { "240", VARIABLE_LENGTH, Integer.valueOf(30) };
    localObject4 = new Object[] { "241", VARIABLE_LENGTH, Integer.valueOf(30) };
    localObject5 = new Object[] { "242", VARIABLE_LENGTH, Integer.valueOf(6) };
    localObject6 = new Object[] { "250", VARIABLE_LENGTH, Integer.valueOf(30) };
    localObject7 = new Object[] { "251", VARIABLE_LENGTH, Integer.valueOf(30) };
    localObject8 = new Object[] { "253", VARIABLE_LENGTH, Integer.valueOf(17) };
    localObject9 = new Object[] { "254", VARIABLE_LENGTH, Integer.valueOf(20) };
    arrayOfObject1 = new Object[] { "400", VARIABLE_LENGTH, Integer.valueOf(30) };
    localObject1 = VARIABLE_LENGTH;
    arrayOfObject2 = new Object[] { "402", Integer.valueOf(17) };
    arrayOfObject3 = new Object[] { "403", VARIABLE_LENGTH, Integer.valueOf(30) };
    arrayOfObject4 = new Object[] { "410", Integer.valueOf(13) };
    arrayOfObject5 = new Object[] { "411", Integer.valueOf(13) };
    arrayOfObject6 = new Object[] { "412", Integer.valueOf(13) };
    arrayOfObject7 = new Object[] { "413", Integer.valueOf(13) };
    arrayOfObject8 = new Object[] { "414", Integer.valueOf(13) };
    localObject2 = VARIABLE_LENGTH;
    arrayOfObject9 = new Object[] { "421", VARIABLE_LENGTH, Integer.valueOf(15) };
    arrayOfObject10 = new Object[] { "422", Integer.valueOf(3) };
    arrayOfObject11 = new Object[] { "423", VARIABLE_LENGTH, Integer.valueOf(15) };
    arrayOfObject12 = new Object[] { "424", Integer.valueOf(3) };
    arrayOfObject13 = new Object[] { "425", Integer.valueOf(3) };
    arrayOfObject14 = new Object[] { "426", Integer.valueOf(3) };
    THREE_DIGIT_DATA_LENGTH = new Object[][] { localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, arrayOfObject1, { "401", localObject1, Integer.valueOf(30) }, arrayOfObject2, arrayOfObject3, arrayOfObject4, arrayOfObject5, arrayOfObject6, arrayOfObject7, arrayOfObject8, { "420", localObject2, Integer.valueOf(20) }, arrayOfObject9, arrayOfObject10, arrayOfObject11, arrayOfObject12, arrayOfObject13, arrayOfObject14 };
    localObject3 = new Object[] { "310", Integer.valueOf(6) };
    localObject4 = new Object[] { "311", Integer.valueOf(6) };
    localObject5 = new Object[] { "314", Integer.valueOf(6) };
    localObject6 = new Object[] { "320", Integer.valueOf(6) };
    localObject7 = new Object[] { "321", Integer.valueOf(6) };
    localObject8 = new Object[] { "323", Integer.valueOf(6) };
    localObject9 = new Object[] { "324", Integer.valueOf(6) };
    arrayOfObject1 = new Object[] { "325", Integer.valueOf(6) };
    arrayOfObject2 = new Object[] { "326", Integer.valueOf(6) };
    arrayOfObject3 = new Object[] { "327", Integer.valueOf(6) };
    arrayOfObject4 = new Object[] { "328", Integer.valueOf(6) };
    arrayOfObject5 = new Object[] { "329", Integer.valueOf(6) };
    arrayOfObject6 = new Object[] { "330", Integer.valueOf(6) };
    arrayOfObject7 = new Object[] { "333", Integer.valueOf(6) };
    arrayOfObject8 = new Object[] { "334", Integer.valueOf(6) };
    arrayOfObject9 = new Object[] { "335", Integer.valueOf(6) };
    arrayOfObject10 = new Object[] { "336", Integer.valueOf(6) };
    arrayOfObject11 = new Object[] { "342", Integer.valueOf(6) };
    arrayOfObject12 = new Object[] { "348", Integer.valueOf(6) };
    arrayOfObject13 = new Object[] { "350", Integer.valueOf(6) };
    arrayOfObject14 = new Object[] { "351", Integer.valueOf(6) };
    Object[] arrayOfObject15 = { "352", Integer.valueOf(6) };
    Object[] arrayOfObject16 = { "355", Integer.valueOf(6) };
    Object[] arrayOfObject17 = { "356", Integer.valueOf(6) };
    Object[] arrayOfObject18 = { "363", Integer.valueOf(6) };
    Object[] arrayOfObject19 = { "365", Integer.valueOf(6) };
    Object[] arrayOfObject20 = { "366", Integer.valueOf(6) };
    Object[] arrayOfObject21 = { "369", Integer.valueOf(6) };
    localObject1 = VARIABLE_LENGTH;
    Object[] arrayOfObject22 = { "391", VARIABLE_LENGTH, Integer.valueOf(18) };
    localObject2 = VARIABLE_LENGTH;
    Object[] arrayOfObject23 = { "393", VARIABLE_LENGTH, Integer.valueOf(18) };
    Object[] arrayOfObject24 = { "703", VARIABLE_LENGTH, Integer.valueOf(30) };
    THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH = new Object[][] { localObject3, localObject4, { "312", Integer.valueOf(6) }, { "313", Integer.valueOf(6) }, localObject5, { "315", Integer.valueOf(6) }, { "316", Integer.valueOf(6) }, localObject6, localObject7, { "322", Integer.valueOf(6) }, localObject8, localObject9, arrayOfObject1, arrayOfObject2, arrayOfObject3, arrayOfObject4, arrayOfObject5, arrayOfObject6, { "331", Integer.valueOf(6) }, { "332", Integer.valueOf(6) }, arrayOfObject7, arrayOfObject8, arrayOfObject9, arrayOfObject10, { "340", Integer.valueOf(6) }, { "341", Integer.valueOf(6) }, arrayOfObject11, { "343", Integer.valueOf(6) }, { "344", Integer.valueOf(6) }, { "345", Integer.valueOf(6) }, { "346", Integer.valueOf(6) }, { "347", Integer.valueOf(6) }, arrayOfObject12, { "349", Integer.valueOf(6) }, arrayOfObject13, arrayOfObject14, arrayOfObject15, { "353", Integer.valueOf(6) }, { "354", Integer.valueOf(6) }, arrayOfObject16, arrayOfObject17, { "357", Integer.valueOf(6) }, { "360", Integer.valueOf(6) }, { "361", Integer.valueOf(6) }, { "362", Integer.valueOf(6) }, arrayOfObject18, { "364", Integer.valueOf(6) }, arrayOfObject19, arrayOfObject20, { "367", Integer.valueOf(6) }, { "368", Integer.valueOf(6) }, arrayOfObject21, { "390", localObject1, Integer.valueOf(15) }, arrayOfObject22, { "392", localObject2, Integer.valueOf(15) }, arrayOfObject23, arrayOfObject24 };
    localObject1 = VARIABLE_LENGTH;
    localObject2 = VARIABLE_LENGTH;
    localObject3 = VARIABLE_LENGTH;
    localObject4 = VARIABLE_LENGTH;
    localObject5 = VARIABLE_LENGTH;
    localObject6 = VARIABLE_LENGTH;
    localObject7 = VARIABLE_LENGTH;
    localObject8 = VARIABLE_LENGTH;
    localObject9 = VARIABLE_LENGTH;
    FOUR_DIGIT_DATA_LENGTH = new Object[][] { { "7001", Integer.valueOf(13) }, { "7002", localObject1, Integer.valueOf(30) }, { "7003", Integer.valueOf(10) }, { "8001", Integer.valueOf(14) }, { "8002", localObject2, Integer.valueOf(20) }, { "8003", localObject3, Integer.valueOf(30) }, { "8004", localObject4, Integer.valueOf(30) }, { "8005", Integer.valueOf(6) }, { "8006", Integer.valueOf(18) }, { "8007", localObject5, Integer.valueOf(30) }, { "8008", localObject6, Integer.valueOf(12) }, { "8018", Integer.valueOf(18) }, { "8020", localObject7, Integer.valueOf(25) }, { "8100", Integer.valueOf(6) }, { "8101", Integer.valueOf(10) }, { "8102", Integer.valueOf(2) }, { "8110", localObject8, Integer.valueOf(70) }, { "8200", localObject9, Integer.valueOf(70) } };
  }
  
  static String parseFieldsInGeneralPurpose(String paramString)
    throws NotFoundException
  {
    if (paramString.isEmpty()) {
      return null;
    }
    if (paramString.length() >= 2)
    {
      String str = paramString.substring(0, 2);
      Object[][] arrayOfObject = TWO_DIGIT_DATA_LENGTH;
      int j = arrayOfObject.length;
      int i = 0;
      Object[] arrayOfObject1;
      while (i < j)
      {
        arrayOfObject1 = arrayOfObject[i];
        if (arrayOfObject1[0].equals(str))
        {
          if (arrayOfObject1[1] == VARIABLE_LENGTH) {
            return processVariableAI(2, ((Integer)arrayOfObject1[2]).intValue(), paramString);
          }
          return processFixedAI(2, ((Integer)arrayOfObject1[1]).intValue(), paramString);
        }
        i += 1;
      }
      if (paramString.length() >= 3)
      {
        str = paramString.substring(0, 3);
        arrayOfObject = THREE_DIGIT_DATA_LENGTH;
        j = arrayOfObject.length;
        i = 0;
        while (i < j)
        {
          arrayOfObject1 = arrayOfObject[i];
          if (arrayOfObject1[0].equals(str))
          {
            if (arrayOfObject1[1] == VARIABLE_LENGTH) {
              return processVariableAI(3, ((Integer)arrayOfObject1[2]).intValue(), paramString);
            }
            return processFixedAI(3, ((Integer)arrayOfObject1[1]).intValue(), paramString);
          }
          i += 1;
        }
        arrayOfObject = THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH;
        j = arrayOfObject.length;
        i = 0;
        while (i < j)
        {
          arrayOfObject1 = arrayOfObject[i];
          if (arrayOfObject1[0].equals(str))
          {
            if (arrayOfObject1[1] == VARIABLE_LENGTH) {
              return processVariableAI(4, ((Integer)arrayOfObject1[2]).intValue(), paramString);
            }
            return processFixedAI(4, ((Integer)arrayOfObject1[1]).intValue(), paramString);
          }
          i += 1;
        }
        if (paramString.length() >= 4)
        {
          str = paramString.substring(0, 4);
          arrayOfObject = FOUR_DIGIT_DATA_LENGTH;
          j = arrayOfObject.length;
          i = 0;
          while (i < j)
          {
            arrayOfObject1 = arrayOfObject[i];
            if (arrayOfObject1[0].equals(str))
            {
              if (arrayOfObject1[1] == VARIABLE_LENGTH) {
                return processVariableAI(4, ((Integer)arrayOfObject1[2]).intValue(), paramString);
              }
              return processFixedAI(4, ((Integer)arrayOfObject1[1]).intValue(), paramString);
            }
            i += 1;
          }
          throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
      }
      throw NotFoundException.getNotFoundInstance();
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static String processFixedAI(int paramInt1, int paramInt2, String paramString)
    throws NotFoundException
  {
    if (paramString.length() >= paramInt1)
    {
      String str = paramString.substring(0, paramInt1);
      int i = paramString.length();
      paramInt2 += paramInt1;
      if (i >= paramInt2)
      {
        Object localObject = paramString.substring(paramInt1, paramInt2);
        paramString = paramString.substring(paramInt2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append('(');
        localStringBuilder.append(str);
        localStringBuilder.append(')');
        localStringBuilder.append((String)localObject);
        str = localStringBuilder.toString();
        paramString = parseFieldsInGeneralPurpose(paramString);
        if (paramString == null) {
          return str;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(paramString);
        return ((StringBuilder)localObject).toString();
      }
      throw NotFoundException.getNotFoundInstance();
    }
    throw NotFoundException.getNotFoundInstance();
  }
  
  private static String processVariableAI(int paramInt1, int paramInt2, String paramString)
    throws NotFoundException
  {
    String str = paramString.substring(0, paramInt1);
    int j = paramString.length();
    int i = paramInt2 + paramInt1;
    paramInt2 = i;
    if (j < i) {
      paramInt2 = paramString.length();
    }
    Object localObject = paramString.substring(paramInt1, paramInt2);
    paramString = paramString.substring(paramInt2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('(');
    localStringBuilder.append(str);
    localStringBuilder.append(')');
    localStringBuilder.append((String)localObject);
    str = localStringBuilder.toString();
    paramString = parseFieldsInGeneralPurpose(paramString);
    if (paramString == null) {
      return str;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(paramString);
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\FieldParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */