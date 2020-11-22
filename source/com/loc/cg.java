package com.loc;

import android.content.Context;
import android.text.TextUtils;

public final class cg
  extends cj
{
  private String b = "iKey";
  private Context c;
  private boolean d;
  private int e;
  private int f;
  
  public cg(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    this.c = paramContext;
    this.d = paramBoolean;
    this.e = paramInt1;
    this.f = paramInt2;
    this.b = paramString;
  }
  
  public final void a(int paramInt)
  {
    if (p.s(this.c) == 1) {
      return;
    }
    String str1 = w.a(System.currentTimeMillis(), "yyyyMMdd");
    Object localObject = ah.a(this.c, this.b);
    int i = paramInt;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject != null) && (localObject.length >= 2))
      {
        i = paramInt;
        if (str1.equals(localObject[0])) {
          i = paramInt + Integer.parseInt(localObject[1]);
        }
      }
      else
      {
        ah.b(this.c, this.b);
        i = paramInt;
      }
    }
    localObject = this.c;
    String str2 = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1);
    localStringBuilder.append("|");
    localStringBuilder.append(i);
    ah.a((Context)localObject, str2, localStringBuilder.toString());
  }
  
  protected final boolean a()
  {
    if (p.s(this.c) == 1) {
      return true;
    }
    if (!this.d) {
      return false;
    }
    Object localObject1 = ah.a(this.c, this.b);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return true;
    }
    localObject1 = ((String)localObject1).split("\\|");
    if ((localObject1 != null) && (localObject1.length >= 2))
    {
      Object localObject2 = localObject1[0];
      return (!w.a(System.currentTimeMillis(), "yyyyMMdd").equals(localObject2)) || (Integer.parseInt(localObject1[1]) < this.f);
    }
    ah.b(this.c, this.b);
    return true;
  }
  
  public final int b()
  {
    int i;
    if ((p.s(this.c) != 1) && (this.e > 0)) {
      i = this.e;
    } else {
      i = Integer.MAX_VALUE;
    }
    int j = i;
    if (this.a != null) {
      j = Math.max(i, this.a.b());
    }
    return j;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */