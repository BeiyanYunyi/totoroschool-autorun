package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class GeoResultParser
  extends ResultParser
{
  private static final Pattern GEO_URL_PATTERN = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);
  
  public GeoParsedResult parse(Result paramResult)
  {
    paramResult = getMassagedText(paramResult);
    paramResult = GEO_URL_PATTERN.matcher(paramResult);
    if (!paramResult.matches()) {
      return null;
    }
    String str1 = paramResult.group(4);
    try
    {
      double d2 = Double.parseDouble(paramResult.group(1));
      if (d2 <= 90.0D)
      {
        if (d2 < -90.0D) {
          return null;
        }
        double d3 = Double.parseDouble(paramResult.group(2));
        if (d3 <= 180.0D)
        {
          if (d3 < -180.0D) {
            return null;
          }
          String str2 = paramResult.group(3);
          double d1 = 0.0D;
          if (str2 != null)
          {
            d1 = Double.parseDouble(paramResult.group(3));
            if (d1 < 0.0D) {
              return null;
            }
          }
          return new GeoParsedResult(d2, d3, d1, str1);
        }
        return null;
      }
      return null;
    }
    catch (NumberFormatException paramResult) {}
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\client\result\GeoResultParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */