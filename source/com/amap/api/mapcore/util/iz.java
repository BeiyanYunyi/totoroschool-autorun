package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;

public class iz
  extends jc
{
  private Context b;
  private boolean c;
  private int d;
  private int e;
  
  public iz(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.b = paramContext;
    this.c = paramBoolean;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public void a(int paramInt)
  {
    if (fp.s(this.b) == 1) {
      return;
    }
    String str = fw.a(System.currentTimeMillis(), "yyyyMMdd");
    Object localObject = gh.a(this.b, "iKey");
    int i;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      i = paramInt;
    }
    else
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject != null) && (localObject.length >= 2))
      {
        i = paramInt;
        if (str.equals(localObject[0])) {
          i = paramInt + Integer.parseInt(localObject[1]);
        }
      }
      else
      {
        gh.b(this.b, "iKey");
        i = paramInt;
      }
    }
    localObject = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("|");
    localStringBuilder.append(i);
    gh.a((Context)localObject, "iKey", localStringBuilder.toString());
  }
  
  protected boolean a()
  {
    if (fp.s(this.b) == 1) {
      return true;
    }
    if (!this.c) {
      return false;
    }
    Object localObject1 = gh.a(this.b, "iKey");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return true;
    }
    localObject1 = ((String)localObject1).split("\\|");
    if ((localObject1 != null) && (localObject1.length >= 2))
    {
      Object localObject2 = localObject1[0];
      if (fw.a(System.currentTimeMillis(), "yyyyMMdd").equals(localObject2)) {
        return Integer.parseInt(localObject1[1]) < this.e;
      }
      return true;
    }
    gh.b(this.b, "iKey");
    return true;
  }
  
  public int b()
  {
    int i;
    if ((fp.s(this.b) != 1) && (this.d > 0)) {
      i = this.d;
    } else {
      i = Integer.MAX_VALUE;
    }
    if (this.a != null) {
      return Math.max(i, this.a.b());
    }
    return i;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\iz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */