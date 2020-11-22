package com.github.barteksc.pdfviewer.util;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtils
{
  public static String arrayToString(int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("[");
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      localStringBuilder.append(paramArrayOfInt[i]);
      if (i != paramArrayOfInt.length - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static int[] calculateIndexesInDuplicateArray(int[] paramArrayOfInt)
  {
    int[] arrayOfInt = new int[paramArrayOfInt.length];
    if (paramArrayOfInt.length == 0) {
      return arrayOfInt;
    }
    int j = 0;
    arrayOfInt[0] = 0;
    int i = 1;
    while (i < paramArrayOfInt.length)
    {
      int k = j;
      if (paramArrayOfInt[i] != paramArrayOfInt[(i - 1)]) {
        k = j + 1;
      }
      arrayOfInt[i] = k;
      i += 1;
      j = k;
    }
    return arrayOfInt;
  }
  
  public static int[] deleteDuplicatedPages(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    int m = paramArrayOfInt.length;
    int k = 0;
    int i = 0;
    int j = -1;
    while (i < m)
    {
      Integer localInteger = Integer.valueOf(paramArrayOfInt[i]);
      if (j != localInteger.intValue()) {
        localArrayList.add(localInteger);
      }
      j = localInteger.intValue();
      i += 1;
    }
    paramArrayOfInt = new int[localArrayList.size()];
    i = k;
    while (i < localArrayList.size())
    {
      paramArrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    return paramArrayOfInt;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\github\barteksc\pdfviewer\util\ArrayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */