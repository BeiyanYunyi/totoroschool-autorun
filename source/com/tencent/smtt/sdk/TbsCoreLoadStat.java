package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.util.Arrays;

public class TbsCoreLoadStat
{
  private static TbsCoreLoadStat d;
  public static volatile int mLoadErrorCode = -1;
  private TbsSequenceQueue a = null;
  private boolean b = false;
  private final int c = 3;
  
  public static TbsCoreLoadStat getInstance()
  {
    if (d == null) {
      d = new TbsCoreLoadStat();
    }
    return d;
  }
  
  void a()
  {
    if (this.a != null) {
      this.a.clear();
    }
    this.b = false;
  }
  
  void a(Context paramContext, int paramInt)
  {
    a(paramContext, paramInt, null);
    paramContext = new StringBuilder();
    paramContext.append("");
    paramContext.append(paramInt);
    TbsLog.e("loaderror", paramContext.toString());
  }
  
  void a(Context paramContext, int paramInt, Throwable paramThrowable)
  {
    try
    {
      if (mLoadErrorCode == -1)
      {
        mLoadErrorCode = paramInt;
        TbsLog.addLog(998, "code=%d,desc=%s", new Object[] { Integer.valueOf(paramInt), String.valueOf(paramThrowable) });
        if (paramThrowable != null)
        {
          TbsLogReport.a(paramContext).b(paramInt, paramThrowable);
        }
        else
        {
          paramContext = new StringBuilder();
          paramContext.append("setLoadErrorCode :: error is null with errorCode: ");
          paramContext.append(paramInt);
          paramContext.append("; Check & correct it!");
          TbsLog.e("TbsCoreLoadStat", paramContext.toString());
        }
        return;
      }
      paramContext = new StringBuilder("setLoadErrorCode :: error(");
      paramContext.append(mLoadErrorCode);
      paramContext.append(") was already reported; ");
      paramContext.append(paramInt);
      paramContext.append(" is duplicated. Try to remove it!");
      TbsLog.w("TbsCoreLoadStat", paramContext.toString());
      return;
    }
    finally {}
  }
  
  public class TbsSequenceQueue
  {
    private int b = 10;
    private int c;
    private int[] d;
    private int e = 0;
    private int f = 0;
    
    public TbsSequenceQueue()
    {
      this.c = this.b;
      this.d = new int[this.c];
    }
    
    public TbsSequenceQueue(int paramInt1, int paramInt2)
    {
      this.c = paramInt2;
      this.d = new int[this.c];
      this.d[0] = paramInt1;
      this.f += 1;
    }
    
    public void add(int paramInt)
    {
      if (this.f <= this.c - 1)
      {
        int[] arrayOfInt = this.d;
        int i = this.f;
        this.f = (i + 1);
        arrayOfInt[i] = paramInt;
        return;
      }
      throw new IndexOutOfBoundsException("sequeue is full");
    }
    
    public void clear()
    {
      Arrays.fill(this.d, 0);
      this.e = 0;
      this.f = 0;
    }
    
    public int element()
    {
      if (!empty()) {
        return this.d[this.e];
      }
      throw new IndexOutOfBoundsException("sequeue is null");
    }
    
    public boolean empty()
    {
      return this.f == this.e;
    }
    
    public int length()
    {
      return this.f - this.e;
    }
    
    public int remove()
    {
      if (!empty())
      {
        int i = this.d[this.e];
        int[] arrayOfInt = this.d;
        int j = this.e;
        this.e = (j + 1);
        arrayOfInt[j] = 0;
        return i;
      }
      throw new IndexOutOfBoundsException("sequeue is null");
    }
    
    public String toString()
    {
      if (empty()) {
        return "";
      }
      StringBuilder localStringBuilder1 = new StringBuilder("[");
      int i = this.e;
      while (i < this.f)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(String.valueOf(this.d[i]));
        localStringBuilder2.append(",");
        localStringBuilder1.append(localStringBuilder2.toString());
        i += 1;
      }
      i = localStringBuilder1.length();
      localStringBuilder1 = localStringBuilder1.delete(i - 1, i);
      localStringBuilder1.append("]");
      return localStringBuilder1.toString();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\TbsCoreLoadStat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */