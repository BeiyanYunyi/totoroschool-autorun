package org.litepal.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import org.litepal.LitePalApplication;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.parser.LitePalAttr;

public class BaseUtility
{
  public static String capitalize(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.substring(0, 1).toUpperCase(Locale.US));
      localStringBuilder.append(paramString.substring(1));
      return localStringBuilder.toString();
    }
    if (paramString == null) {
      return null;
    }
    return "";
  }
  
  public static String changeCase(String paramString)
  {
    if (paramString != null)
    {
      String str = LitePalAttr.getInstance().getCases();
      if ("keep".equals(str)) {
        return paramString;
      }
      if ("upper".equals(str)) {
        return paramString.toUpperCase(Locale.US);
      }
      return paramString.toLowerCase(Locale.US);
    }
    return null;
  }
  
  public static void checkConditionsCorrect(String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      int i = paramVarArgs.length;
      if (i > 0)
      {
        if (i == count(paramVarArgs[0], "?") + 1) {
          return;
        }
        throw new LitePalSupportException("The parameters in conditions are incorrect.");
      }
    }
  }
  
  public static boolean containsIgnoreCases(Collection<String> paramCollection, String paramString)
  {
    boolean bool2 = false;
    if (paramCollection == null) {
      return false;
    }
    if (paramString == null) {
      return paramCollection.contains(null);
    }
    paramCollection = paramCollection.iterator();
    do
    {
      bool1 = bool2;
      if (!paramCollection.hasNext()) {
        break;
      }
    } while (!paramString.equalsIgnoreCase((String)paramCollection.next()));
    boolean bool1 = true;
    return bool1;
  }
  
  public static int count(String paramString1, String paramString2)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    int j = 0;
    if ((!bool) && (!TextUtils.isEmpty(paramString2)))
    {
      for (int i = paramString1.indexOf(paramString2); i != -1; i = paramString1.indexOf(paramString2))
      {
        j += 1;
        paramString1 = paramString1.substring(i + paramString2.length());
      }
      return j;
    }
    return 0;
  }
  
  public static boolean isClassAndMethodExist(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = Class.forName(paramString1).getMethods();
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        boolean bool = paramString2.equals(paramString1[i].getName());
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static boolean isFieldTypeSupported(String paramString)
  {
    if (!"boolean".equals(paramString))
    {
      if ("java.lang.Boolean".equals(paramString)) {
        return true;
      }
      if (!"float".equals(paramString))
      {
        if ("java.lang.Float".equals(paramString)) {
          return true;
        }
        if (!"double".equals(paramString))
        {
          if ("java.lang.Double".equals(paramString)) {
            return true;
          }
          if (!"int".equals(paramString))
          {
            if ("java.lang.Integer".equals(paramString)) {
              return true;
            }
            if (!"long".equals(paramString))
            {
              if ("java.lang.Long".equals(paramString)) {
                return true;
              }
              if (!"short".equals(paramString))
              {
                if ("java.lang.Short".equals(paramString)) {
                  return true;
                }
                if (!"char".equals(paramString))
                {
                  if ("java.lang.Character".equals(paramString)) {
                    return true;
                  }
                  if (!"[B".equals(paramString))
                  {
                    if ("[Ljava.lang.Byte;".equals(paramString)) {
                      return true;
                    }
                    if (!"java.lang.String".equals(paramString)) {
                      return "java.util.Date".equals(paramString);
                    }
                    return true;
                  }
                  return true;
                }
                return true;
              }
              return true;
            }
            return true;
          }
          return true;
        }
        return true;
      }
      return true;
    }
    return true;
  }
  
  public static boolean isGenericTypeSupported(String paramString)
  {
    if ("java.lang.String".equals(paramString)) {
      return true;
    }
    if ("java.lang.Integer".equals(paramString)) {
      return true;
    }
    if ("java.lang.Float".equals(paramString)) {
      return true;
    }
    if ("java.lang.Double".equals(paramString)) {
      return true;
    }
    if ("java.lang.Long".equals(paramString)) {
      return true;
    }
    if ("java.lang.Short".equals(paramString)) {
      return true;
    }
    if ("java.lang.Boolean".equals(paramString)) {
      return true;
    }
    return "java.lang.Character".equals(paramString);
  }
  
  public static boolean isLitePalXMLExists()
  {
    try
    {
      String[] arrayOfString = LitePalApplication.getContext().getAssets().list("");
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          boolean bool = "litepal.xml".equalsIgnoreCase(arrayOfString[i]);
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (IOException localIOException) {}
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\util\BaseUtility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */