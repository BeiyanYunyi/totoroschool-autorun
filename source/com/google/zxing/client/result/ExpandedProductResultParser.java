package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.HashMap;
import java.util.Map;

public final class ExpandedProductResultParser
  extends ResultParser
{
  private static String findAIvalue(int paramInt, String paramString)
  {
    if (paramString.charAt(paramInt) != '(') {
      return null;
    }
    paramString = paramString.substring(paramInt + 1);
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = 0;
    while (paramInt < paramString.length())
    {
      char c = paramString.charAt(paramInt);
      if (c == ')') {
        return localStringBuilder.toString();
      }
      if ((c >= '0') && (c <= '9'))
      {
        localStringBuilder.append(c);
        paramInt += 1;
      }
      else
      {
        return null;
      }
    }
    return localStringBuilder.toString();
  }
  
  private static String findValue(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = paramString.substring(paramInt);
    paramInt = 0;
    while (paramInt < paramString.length())
    {
      char c = paramString.charAt(paramInt);
      if (c == '(')
      {
        if (findAIvalue(paramInt, paramString) != null) {
          break;
        }
        localStringBuilder.append('(');
      }
      else
      {
        localStringBuilder.append(c);
      }
      paramInt += 1;
    }
    return localStringBuilder.toString();
  }
  
  public ExpandedProductParsedResult parse(Result paramResult)
  {
    if (paramResult.getBarcodeFormat() != BarcodeFormat.RSS_EXPANDED) {
      return null;
    }
    String str = getMassagedText(paramResult);
    HashMap localHashMap = new HashMap();
    Object localObject12 = null;
    Object localObject6 = localObject12;
    Object localObject5 = localObject6;
    Object localObject4 = localObject5;
    Object localObject3 = localObject4;
    Object localObject2 = localObject3;
    Object localObject1 = localObject2;
    paramResult = (Result)localObject1;
    Object localObject7 = paramResult;
    Object localObject11 = localObject7;
    Object localObject8 = localObject11;
    Object localObject10 = localObject8;
    Object localObject9 = localObject10;
    int i = 0;
    Object localObject16 = localObject7;
    Result localResult = paramResult;
    localObject7 = localObject12;
    while (i < str.length())
    {
      localObject12 = findAIvalue(i, str);
      if (localObject12 == null) {
        return null;
      }
      int j = i + (((String)localObject12).length() + 2);
      paramResult = findValue(j, str);
      int k = paramResult.length();
      i = ((String)localObject12).hashCode();
      if (i != 1570)
      {
        if (i != 1572)
        {
          if (i != 1574)
          {
            switch (i)
            {
            default: 
              switch (i)
              {
              default: 
                switch (i)
                {
                default: 
                  switch (i)
                  {
                  default: 
                    switch (i)
                    {
                    default: 
                      switch (i)
                      {
                      default: 
                        break;
                      case 1575750: 
                        if (!((String)localObject12).equals("3933")) {
                          break;
                        }
                        i = 34;
                        break;
                      case 1575749: 
                        if (!((String)localObject12).equals("3932")) {
                          break;
                        }
                        i = 33;
                        break;
                      case 1575748: 
                        if (!((String)localObject12).equals("3931")) {
                          break;
                        }
                        i = 32;
                        break;
                      case 1575747: 
                        if (!((String)localObject12).equals("3930")) {
                          break;
                        }
                        i = 31;
                      }
                      break;
                    case 1575719: 
                      if (!((String)localObject12).equals("3923")) {
                        break;
                      }
                      i = 30;
                      break;
                    case 1575718: 
                      if (!((String)localObject12).equals("3922")) {
                        break;
                      }
                      i = 29;
                      break;
                    case 1575717: 
                      if (!((String)localObject12).equals("3921")) {
                        break;
                      }
                      i = 28;
                      break;
                    case 1575716: 
                      if (!((String)localObject12).equals("3920")) {
                        break;
                      }
                      i = 27;
                    }
                    break;
                  case 1568936: 
                    if (!((String)localObject12).equals("3209")) {
                      break;
                    }
                    i = 26;
                    break;
                  case 1568935: 
                    if (!((String)localObject12).equals("3208")) {
                      break;
                    }
                    i = 25;
                    break;
                  case 1568934: 
                    if (!((String)localObject12).equals("3207")) {
                      break;
                    }
                    i = 24;
                    break;
                  case 1568933: 
                    if (!((String)localObject12).equals("3206")) {
                      break;
                    }
                    i = 23;
                    break;
                  case 1568932: 
                    if (!((String)localObject12).equals("3205")) {
                      break;
                    }
                    i = 22;
                    break;
                  case 1568931: 
                    if (!((String)localObject12).equals("3204")) {
                      break;
                    }
                    i = 21;
                    break;
                  case 1568930: 
                    if (!((String)localObject12).equals("3203")) {
                      break;
                    }
                    i = 20;
                    break;
                  case 1568929: 
                    if (!((String)localObject12).equals("3202")) {
                      break;
                    }
                    i = 19;
                    break;
                  case 1568928: 
                    if (!((String)localObject12).equals("3201")) {
                      break;
                    }
                    i = 18;
                    break;
                  case 1568927: 
                    if (!((String)localObject12).equals("3200")) {
                      break;
                    }
                    i = 17;
                  }
                  break;
                case 1567975: 
                  if (!((String)localObject12).equals("3109")) {
                    break;
                  }
                  i = 16;
                  break;
                case 1567974: 
                  if (!((String)localObject12).equals("3108")) {
                    break;
                  }
                  i = 15;
                  break;
                case 1567973: 
                  if (!((String)localObject12).equals("3107")) {
                    break;
                  }
                  i = 14;
                  break;
                case 1567972: 
                  if (!((String)localObject12).equals("3106")) {
                    break;
                  }
                  i = 13;
                  break;
                case 1567971: 
                  if (!((String)localObject12).equals("3105")) {
                    break;
                  }
                  i = 12;
                  break;
                case 1567970: 
                  if (!((String)localObject12).equals("3104")) {
                    break;
                  }
                  i = 11;
                  break;
                case 1567969: 
                  if (!((String)localObject12).equals("3103")) {
                    break;
                  }
                  i = 10;
                  break;
                case 1567968: 
                  if (!((String)localObject12).equals("3102")) {
                    break;
                  }
                  i = 9;
                  break;
                case 1567967: 
                  if (!((String)localObject12).equals("3101")) {
                    break;
                  }
                  i = 8;
                  break;
                case 1567966: 
                  if (!((String)localObject12).equals("3100")) {
                    break;
                  }
                  i = 7;
                }
                break;
              case 1568: 
                if (!((String)localObject12).equals("11")) {
                  break;
                }
                i = 3;
                break;
              case 1567: 
                if (!((String)localObject12).equals("10")) {
                  break;
                }
                i = 2;
              }
              break;
            case 1537: 
              if (!((String)localObject12).equals("01")) {
                break;
              }
              i = 1;
              break;
            case 1536: 
              if (!((String)localObject12).equals("00")) {
                break;
              }
              i = 0;
              break;
            }
          }
          else if (((String)localObject12).equals("17"))
          {
            i = 6;
            break label947;
          }
        }
        else if (((String)localObject12).equals("15"))
        {
          i = 5;
          break label947;
        }
      }
      else if (((String)localObject12).equals("13"))
      {
        i = 4;
        break label947;
      }
      i = -1;
      label947:
      Object localObject15;
      Object localObject14;
      Object localObject13;
      switch (i)
      {
      default: 
        localHashMap.put(localObject12, paramResult);
        localObject15 = localObject1;
        localObject14 = localObject2;
        localObject13 = localObject3;
        localObject12 = localObject4;
      }
      for (;;)
      {
        paramResult = (Result)localObject8;
        localObject1 = localObject10;
        localObject2 = localObject15;
        localObject3 = localObject14;
        localObject4 = localObject13;
        for (;;)
        {
          localObject8 = localObject4;
          localObject13 = localObject3;
          localObject14 = localObject2;
          localObject10 = localObject1;
          break;
          if (paramResult.length() < 4) {
            return null;
          }
          localObject8 = paramResult.substring(3);
          localObject9 = paramResult.substring(0, 3);
          localObject10 = ((String)localObject12).substring(3);
          localObject12 = localObject4;
          localObject4 = localObject3;
          localObject3 = localObject2;
          localObject2 = localObject1;
          paramResult = (Result)localObject8;
          localObject1 = localObject10;
          continue;
          localObject8 = ((String)localObject12).substring(3);
          localObject12 = localObject4;
          localObject4 = localObject3;
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject8;
        }
        localObject11 = "LB";
        localObject12 = ((String)localObject12).substring(3);
        break label1286;
        localObject11 = "KG";
        localObject12 = ((String)localObject12).substring(3);
        label1286:
        localObject15 = localObject12;
        Object localObject17 = localObject8;
        localObject12 = localObject4;
        localObject8 = localObject3;
        localObject13 = localObject2;
        localObject14 = localObject1;
        localResult = paramResult;
        localObject16 = localObject11;
        localObject11 = localObject15;
        paramResult = (Result)localObject17;
        break;
        localObject12 = localObject4;
        localObject13 = localObject3;
        localObject14 = localObject2;
        localObject15 = paramResult;
        continue;
        localObject12 = localObject4;
        localObject13 = localObject3;
        localObject14 = paramResult;
        localObject15 = localObject1;
        continue;
        localObject12 = localObject4;
        localObject13 = paramResult;
        localObject14 = localObject2;
        localObject15 = localObject1;
        continue;
        localObject12 = paramResult;
        localObject13 = localObject3;
        localObject14 = localObject2;
        localObject15 = localObject1;
        continue;
        localObject5 = paramResult;
        localObject12 = localObject4;
        localObject13 = localObject3;
        localObject14 = localObject2;
        localObject15 = localObject1;
        continue;
        localObject7 = paramResult;
        localObject12 = localObject4;
        localObject13 = localObject3;
        localObject14 = localObject2;
        localObject15 = localObject1;
        continue;
        localObject6 = paramResult;
        localObject12 = localObject4;
        localObject13 = localObject3;
        localObject14 = localObject2;
        localObject15 = localObject1;
      }
      i = j + k;
      localObject4 = localObject12;
      localObject3 = localObject8;
      localObject2 = localObject13;
      localObject1 = localObject14;
      localObject8 = paramResult;
    }
    return new ExpandedProductParsedResult(str, (String)localObject7, (String)localObject6, (String)localObject5, (String)localObject4, (String)localObject3, (String)localObject2, (String)localObject1, localResult, (String)localObject16, (String)localObject11, (String)localObject8, (String)localObject10, (String)localObject9, localHashMap);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\ExpandedProductResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */