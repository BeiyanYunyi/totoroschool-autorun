package e.a.e;

import f.d;
import f.f;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class j
  implements Closeable
{
  private static final Logger b = Logger.getLogger(e.class.getName());
  final d.b a;
  private final d c;
  private final boolean d;
  private final f.c e;
  private int f;
  private boolean g;
  
  j(d paramd, boolean paramBoolean)
  {
    this.c = paramd;
    this.d = paramBoolean;
    this.e = new f.c();
    this.a = new d.b(this.e);
    this.f = 16384;
  }
  
  private static void a(d paramd, int paramInt)
    throws IOException
  {
    paramd.i(paramInt >>> 16 & 0xFF);
    paramd.i(paramInt >>> 8 & 0xFF);
    paramd.i(paramInt & 0xFF);
  }
  
  private void b(int paramInt, long paramLong)
    throws IOException
  {
    while (paramLong > 0L)
    {
      int i = (int)Math.min(this.f, paramLong);
      long l = i;
      paramLong -= l;
      byte b1;
      if (paramLong == 0L) {
        b1 = 4;
      } else {
        b1 = 0;
      }
      a(paramInt, i, (byte)9, b1);
      this.c.a(this.e, l);
    }
  }
  
  public void a()
    throws IOException
  {
    try
    {
      if (!this.g)
      {
        boolean bool = this.d;
        if (!bool) {
          return;
        }
        if (b.isLoggable(Level.FINE)) {
          b.fine(e.a.c.a(">> CONNECTION %s", new Object[] { e.a.hex() }));
        }
        this.c.c(e.a.toByteArray());
        this.c.flush();
        return;
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  void a(int paramInt1, byte paramByte, f.c paramc, int paramInt2)
    throws IOException
  {
    a(paramInt1, paramInt2, (byte)0, paramByte);
    if (paramInt2 > 0) {
      this.c.a(paramc, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
    throws IOException
  {
    if (b.isLoggable(Level.FINE)) {
      b.fine(e.a(false, paramInt1, paramInt2, paramByte1, paramByte2));
    }
    if (paramInt2 <= this.f)
    {
      if ((0x80000000 & paramInt1) == 0)
      {
        a(this.c, paramInt2);
        this.c.i(paramByte1 & 0xFF);
        this.c.i(paramByte2 & 0xFF);
        this.c.g(paramInt1 & 0x7FFFFFFF);
        return;
      }
      throw e.a("reserved bit set: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    throw e.a("FRAME_SIZE_ERROR length > %d: %d", new Object[] { Integer.valueOf(this.f), Integer.valueOf(paramInt2) });
  }
  
  public void a(int paramInt1, int paramInt2, List<c> paramList)
    throws IOException
  {
    for (;;)
    {
      try
      {
        if (!this.g)
        {
          this.a.a(paramList);
          long l1 = this.e.a();
          int i = (int)Math.min(this.f - 4, l1);
          long l2 = i;
          if (l1 == l2)
          {
            b1 = 4;
            a(paramInt1, i + 4, (byte)5, b1);
            this.c.g(paramInt2 & 0x7FFFFFFF);
            this.c.a(this.e, l2);
            if (l1 > l2) {
              b(paramInt1, l1 - l2);
            }
          }
        }
        else
        {
          throw new IOException("closed");
        }
      }
      finally {}
      byte b1 = 0;
    }
  }
  
  public void a(int paramInt, long paramLong)
    throws IOException
  {
    try
    {
      if (!this.g)
      {
        if ((paramLong != 0L) && (paramLong <= 2147483647L))
        {
          a(paramInt, 4, (byte)8, (byte)0);
          this.c.g((int)paramLong);
          this.c.flush();
          return;
        }
        throw e.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[] { Long.valueOf(paramLong) });
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  public void a(int paramInt, b paramb)
    throws IOException
  {
    try
    {
      if (!this.g)
      {
        if (paramb.httpCode != -1)
        {
          a(paramInt, 4, (byte)3, (byte)0);
          this.c.g(paramb.httpCode);
          this.c.flush();
          return;
        }
        throw new IllegalArgumentException();
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  public void a(int paramInt, b paramb, byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      if (!this.g)
      {
        if (paramb.httpCode != -1)
        {
          a(0, paramArrayOfByte.length + 8, (byte)7, (byte)0);
          this.c.g(paramInt);
          this.c.g(paramb.httpCode);
          if (paramArrayOfByte.length > 0) {
            this.c.c(paramArrayOfByte);
          }
          this.c.flush();
          return;
        }
        throw e.a("errorCode.httpCode == -1", new Object[0]);
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  public void a(m paramm)
    throws IOException
  {
    try
    {
      if (!this.g)
      {
        this.f = paramm.d(this.f);
        if (paramm.c() != -1) {
          this.a.a(paramm.c());
        }
        a(0, 0, (byte)4, (byte)1);
        this.c.flush();
        return;
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
    throws IOException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, List<c> paramList)
    throws IOException
  {
    try
    {
      if (!this.g)
      {
        a(paramBoolean, paramInt1, paramList);
        return;
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, int paramInt1, f.c paramc, int paramInt2)
    throws IOException
  {
    try
    {
      if (!this.g)
      {
        byte b1 = 0;
        if (paramBoolean) {
          b1 = (byte)1;
        }
        a(paramInt1, b1, paramc, paramInt2);
        return;
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  void a(boolean paramBoolean, int paramInt, List<c> paramList)
    throws IOException
  {
    if (!this.g)
    {
      this.a.a(paramList);
      long l1 = this.e.a();
      int i = (int)Math.min(this.f, l1);
      long l2 = i;
      byte b1;
      if (l1 == l2) {
        b1 = 4;
      } else {
        b1 = 0;
      }
      byte b2 = b1;
      if (paramBoolean) {
        b2 = (byte)(b1 | 0x1);
      }
      a(paramInt, i, (byte)1, b2);
      this.c.a(this.e, l2);
      if (l1 > l2) {
        b(paramInt, l1 - l2);
      }
      return;
    }
    throw new IOException("closed");
  }
  
  public void b()
    throws IOException
  {
    try
    {
      if (!this.g)
      {
        this.c.flush();
        return;
      }
      throw new IOException("closed");
    }
    finally {}
  }
  
  public void b(m paramm)
    throws IOException
  {
    for (;;)
    {
      int j;
      int i;
      try
      {
        if (!this.g)
        {
          j = paramm.b();
          i = 0;
          a(0, j * 6, (byte)4, (byte)0);
          if (i < 10)
          {
            if (!paramm.a(i))
            {
              break label126;
              this.c.h(j);
              this.c.g(paramm.b(i));
            }
          }
          else {
            this.c.flush();
          }
        }
        else
        {
          throw new IOException("closed");
        }
      }
      finally {}
      if (i == 4)
      {
        j = 3;
      }
      else if (i == 7)
      {
        j = 4;
      }
      else
      {
        j = i;
        continue;
        label126:
        i += 1;
      }
    }
  }
  
  public int c()
  {
    return this.f;
  }
  
  public void close()
    throws IOException
  {
    try
    {
      this.g = true;
      this.c.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\e\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */