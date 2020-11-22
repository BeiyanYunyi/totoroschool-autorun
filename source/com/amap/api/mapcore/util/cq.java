package com.amap.api.mapcore.util;

import android.text.TextUtils;

public class cq
{
  int a;
  int[] b;
  int c;
  int d;
  String e;
  String f;
  String g;
  
  public cq(int paramInt, int[] paramArrayOfInt, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramInt;
    this.b = paramArrayOfInt;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramString3;
    paramString3 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString3 = paramString2;
    }
    this.c = 64536;
    if ("regions".equals(paramString3)) {
      this.c = 1001;
    } else if ("water".equals(paramString3)) {
      this.c = 1002;
    } else if ("buildings".equals(paramString3)) {
      this.c = 1003;
    } else if ("roads".equals(paramString3)) {
      this.c = 1004;
    } else if ("labels".equals(paramString3)) {
      this.c = 1005;
    } else if ("borders".equals(paramString3)) {
      this.c = 1006;
    }
    this.d = (paramInt * 1000 + paramArrayOfInt.hashCode());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */