package com.loc;

public final class ae
{
  private final int a = 37;
  private int b = 0;
  
  private ae a(long paramLong)
  {
    this.b = (this.b * this.a + (int)(paramLong ^ paramLong >> 32));
    return this;
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final ae a(Object paramObject)
  {
    if (paramObject == null) {}
    int i;
    do
    {
      int i3;
      do
      {
        int i2;
        do
        {
          int j;
          int i1;
          do
          {
            int n;
            do
            {
              int m;
              do
              {
                int k;
                do
                {
                  do
                  {
                    this.b *= this.a;
                    return this;
                    if (!paramObject.getClass().isArray()) {
                      break label492;
                    }
                    boolean bool = paramObject instanceof long[];
                    j = 0;
                    k = 0;
                    m = 0;
                    n = 0;
                    i1 = 0;
                    i2 = 0;
                    i3 = 0;
                    i = 0;
                    if (!bool) {
                      break;
                    }
                    paramObject = (long[])paramObject;
                  } while (paramObject == null);
                  while (i < paramObject.length)
                  {
                    a(paramObject[i]);
                    i += 1;
                  }
                  if (!(paramObject instanceof int[])) {
                    break;
                  }
                  paramObject = (int[])paramObject;
                  i = j;
                } while (paramObject == null);
                while (i < paramObject.length)
                {
                  j = paramObject[i];
                  this.b = (this.b * this.a + j);
                  i += 1;
                }
                if (!(paramObject instanceof short[])) {
                  break;
                }
                paramObject = (short[])paramObject;
                i = k;
              } while (paramObject == null);
              while (i < paramObject.length)
              {
                j = paramObject[i];
                this.b = (this.b * this.a + j);
                i += 1;
              }
              if (!(paramObject instanceof char[])) {
                break;
              }
              paramObject = (char[])paramObject;
              i = m;
            } while (paramObject == null);
            while (i < paramObject.length)
            {
              j = paramObject[i];
              this.b = (this.b * this.a + j);
              i += 1;
            }
            if (!(paramObject instanceof byte[])) {
              break;
            }
            paramObject = (byte[])paramObject;
            i = n;
          } while (paramObject == null);
          while (i < paramObject.length)
          {
            j = paramObject[i];
            this.b = (this.b * this.a + j);
            i += 1;
          }
          if (!(paramObject instanceof double[])) {
            break;
          }
          paramObject = (double[])paramObject;
          i = i1;
        } while (paramObject == null);
        while (i < paramObject.length)
        {
          a(Double.doubleToLongBits(paramObject[i]));
          i += 1;
        }
        if (!(paramObject instanceof float[])) {
          break;
        }
        paramObject = (float[])paramObject;
        i = i2;
      } while (paramObject == null);
      while (i < paramObject.length)
      {
        float f = paramObject[i];
        this.b = (this.b * this.a + Float.floatToIntBits(f));
        i += 1;
      }
      if (!(paramObject instanceof boolean[])) {
        break;
      }
      paramObject = (boolean[])paramObject;
      i = i3;
    } while (paramObject == null);
    while (i < paramObject.length)
    {
      int i4 = paramObject[i];
      this.b = (this.b * this.a + (i4 ^ 0x1));
      i += 1;
    }
    a((Object[])paramObject);
    return this;
    label492:
    this.b = (this.b * this.a + paramObject.hashCode());
    return this;
  }
  
  public final ae a(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null)
    {
      this.b *= this.a;
      return this;
    }
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      a(paramArrayOfObject[i]);
      i += 1;
    }
    return this;
  }
  
  public final int hashCode()
  {
    return this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */