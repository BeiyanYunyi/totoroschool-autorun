package com.totoro.school.utils;

import c.e.d;
import c.e.m;
import java.io.File;
import java.util.List;

public class e
{
  public static int a(String paramString, List<List<Object>> paramList)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString = c.l.a(new File(paramString));
        c.e.l locall = paramString.a("sheet1", 0);
        i = 0;
        if (i < paramList.size())
        {
          List localList = (List)paramList.get(i);
          int j = 0;
          if (j < localList.size())
          {
            locall.a(new d(j, i, localList.get(j).toString()));
            j += 1;
            continue;
          }
        }
        else
        {
          paramString.c();
          paramString.b();
          return 0;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return -1;
      }
      i += 1;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utils\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */