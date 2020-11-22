package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;

public class DefaultPlacement
{
  private final byte[] bits;
  private final CharSequence codewords;
  private final int numcols;
  private final int numrows;
  
  public DefaultPlacement(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    this.codewords = paramCharSequence;
    this.numcols = paramInt1;
    this.numrows = paramInt2;
    this.bits = new byte[paramInt1 * paramInt2];
    Arrays.fill(this.bits, (byte)-1);
  }
  
  private void corner1(int paramInt)
  {
    module(this.numrows - 1, 0, paramInt, 1);
    module(this.numrows - 1, 1, paramInt, 2);
    module(this.numrows - 1, 2, paramInt, 3);
    module(0, this.numcols - 2, paramInt, 4);
    module(0, this.numcols - 1, paramInt, 5);
    module(1, this.numcols - 1, paramInt, 6);
    module(2, this.numcols - 1, paramInt, 7);
    module(3, this.numcols - 1, paramInt, 8);
  }
  
  private void corner2(int paramInt)
  {
    module(this.numrows - 3, 0, paramInt, 1);
    module(this.numrows - 2, 0, paramInt, 2);
    module(this.numrows - 1, 0, paramInt, 3);
    module(0, this.numcols - 4, paramInt, 4);
    module(0, this.numcols - 3, paramInt, 5);
    module(0, this.numcols - 2, paramInt, 6);
    module(0, this.numcols - 1, paramInt, 7);
    module(1, this.numcols - 1, paramInt, 8);
  }
  
  private void corner3(int paramInt)
  {
    module(this.numrows - 3, 0, paramInt, 1);
    module(this.numrows - 2, 0, paramInt, 2);
    module(this.numrows - 1, 0, paramInt, 3);
    module(0, this.numcols - 2, paramInt, 4);
    module(0, this.numcols - 1, paramInt, 5);
    module(1, this.numcols - 1, paramInt, 6);
    module(2, this.numcols - 1, paramInt, 7);
    module(3, this.numcols - 1, paramInt, 8);
  }
  
  private void corner4(int paramInt)
  {
    module(this.numrows - 1, 0, paramInt, 1);
    module(this.numrows - 1, this.numcols - 1, paramInt, 2);
    module(0, this.numcols - 3, paramInt, 3);
    module(0, this.numcols - 2, paramInt, 4);
    module(0, this.numcols - 1, paramInt, 5);
    module(1, this.numcols - 3, paramInt, 6);
    module(1, this.numcols - 2, paramInt, 7);
    module(1, this.numcols - 1, paramInt, 8);
  }
  
  private void module(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt1;
    int j = paramInt2;
    if (paramInt1 < 0)
    {
      i = paramInt1 + this.numrows;
      j = paramInt2 + (4 - (this.numrows + 4) % 8);
    }
    paramInt2 = i;
    paramInt1 = j;
    if (j < 0)
    {
      paramInt1 = j + this.numcols;
      paramInt2 = i + (4 - (this.numcols + 4) % 8);
    }
    paramInt3 = this.codewords.charAt(paramInt3);
    boolean bool = true;
    if ((paramInt3 & 1 << 8 - paramInt4) == 0) {
      bool = false;
    }
    setBit(paramInt1, paramInt2, bool);
  }
  
  private void utah(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = paramInt1 - 2;
    int i = paramInt2 - 2;
    module(k, i, paramInt3, 1);
    int j = paramInt2 - 1;
    module(k, j, paramInt3, 2);
    k = paramInt1 - 1;
    module(k, i, paramInt3, 3);
    module(k, j, paramInt3, 4);
    module(k, paramInt2, paramInt3, 5);
    module(paramInt1, i, paramInt3, 6);
    module(paramInt1, j, paramInt3, 7);
    module(paramInt1, paramInt2, paramInt3, 8);
  }
  
  public final boolean getBit(int paramInt1, int paramInt2)
  {
    return this.bits[(paramInt2 * this.numcols + paramInt1)] == 1;
  }
  
  final byte[] getBits()
  {
    return this.bits;
  }
  
  final int getNumcols()
  {
    return this.numcols;
  }
  
  final int getNumrows()
  {
    return this.numrows;
  }
  
  final boolean hasBit(int paramInt1, int paramInt2)
  {
    return this.bits[(paramInt2 * this.numcols + paramInt1)] >= 0;
  }
  
  public final void place()
  {
    int j = 4;
    int i = 0;
    int m = 0;
    int n;
    do
    {
      int k;
      int i1;
      do
      {
        k = m;
        if (j == this.numrows)
        {
          k = m;
          if (i == 0)
          {
            corner1(m);
            k = m + 1;
          }
        }
        n = k;
        if (j == this.numrows - 2)
        {
          n = k;
          if (i == 0)
          {
            n = k;
            if (this.numcols % 4 != 0)
            {
              corner2(k);
              n = k + 1;
            }
          }
        }
        m = n;
        if (j == this.numrows - 2)
        {
          m = n;
          if (i == 0)
          {
            m = n;
            if (this.numcols % 8 == 4)
            {
              corner3(n);
              m = n + 1;
            }
          }
        }
        n = j;
        i1 = i;
        k = m;
        if (j == this.numrows + 4)
        {
          n = j;
          i1 = i;
          k = m;
          if (i == 2)
          {
            n = j;
            i1 = i;
            k = m;
            if (this.numcols % 8 == 0)
            {
              corner4(m);
              k = m + 1;
              i1 = i;
              n = j;
            }
          }
        }
        do
        {
          i = k;
          if (n < this.numrows)
          {
            i = k;
            if (i1 >= 0)
            {
              i = k;
              if (!hasBit(i1, n))
              {
                utah(n, i1, k);
                i = k + 1;
              }
            }
          }
          m = n - 2;
          j = i1 + 2;
          if (m < 0) {
            break;
          }
          n = m;
          i1 = j;
          k = i;
        } while (j < this.numcols);
        m += 1;
        k = j + 3;
        j = i;
        i = k;
        do
        {
          k = j;
          if (m >= 0)
          {
            k = j;
            if (i < this.numcols)
            {
              k = j;
              if (!hasBit(i, m))
              {
                utah(m, i, j);
                k = j + 1;
              }
            }
          }
          i1 = m + 2;
          n = i - 2;
          if (i1 >= this.numrows) {
            break;
          }
          m = i1;
          i = n;
          j = k;
        } while (n >= 0);
        i1 += 3;
        n += 1;
        j = i1;
        i = n;
        m = k;
      } while (i1 < this.numrows);
      j = i1;
      i = n;
      m = k;
    } while (n < this.numcols);
    if (!hasBit(this.numcols - 1, this.numrows - 1))
    {
      setBit(this.numcols - 1, this.numrows - 1, true);
      setBit(this.numcols - 2, this.numrows - 2, true);
    }
  }
  
  final void setBit(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\datamatrix\encoder\DefaultPlacement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */