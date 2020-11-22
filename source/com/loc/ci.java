package com.loc;

import android.content.Context;
import android.text.TextUtils;

public final class ci
  extends cj
{
  private int b;
  private long c;
  private String d;
  private Context e;
  
  public ci(Context paramContext, int paramInt, String paramString, cj paramcj)
  {
    super(paramcj);
    this.b = paramInt;
    this.d = paramString;
    this.e = paramContext;
  }
  
  public final void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      String str = this.d;
      long l = System.currentTimeMillis();
      this.c = l;
      ah.a(this.e, str, String.valueOf(l));
    }
  }
  
  protected final boolean a()
  {
    long l2 = this.c;
    long l1 = 0L;
    if (l2 == 0L)
    {
      String str = this.d;
      str = ah.a(this.e, str);
      if (!TextUtils.isEmpty(str)) {
        l1 = Long.parseLong(str);
      }
      this.c = l1;
    }
    return System.currentTimeMillis() - this.c >= this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */