package b.a.e.j;

public final class p<T>
{
  final float a;
  int b;
  int c;
  int d;
  T[] e;
  
  public p()
  {
    this(16, 0.75F);
  }
  
  public p(int paramInt, float paramFloat)
  {
    this.a = paramFloat;
    paramInt = q.a(paramInt);
    this.b = (paramInt - 1);
    this.d = ((int)(paramFloat * paramInt));
    this.e = ((Object[])new Object[paramInt]);
  }
  
  static int a(int paramInt)
  {
    paramInt *= -1640531527;
    return paramInt ^ paramInt >>> 16;
  }
  
  void a()
  {
    Object[] arrayOfObject1 = this.e;
    int i = arrayOfObject1.length;
    int n = i << 1;
    int i1 = n - 1;
    Object[] arrayOfObject2 = (Object[])new Object[n];
    int j = this.c;
    while (j != 0)
    {
      do
      {
        i -= 1;
      } while (arrayOfObject1[i] == null);
      int k = a(arrayOfObject1[i].hashCode()) & i1;
      int m = k;
      if (arrayOfObject2[k] != null) {
        do
        {
          m = k + 1 & i1;
          k = m;
        } while (arrayOfObject2[m] != null);
      }
      arrayOfObject2[m] = arrayOfObject1[i];
      j -= 1;
    }
    this.b = i1;
    this.d = ((int)(n * this.a));
    this.e = arrayOfObject2;
  }
  
  boolean a(int paramInt1, T[] paramArrayOfT, int paramInt2)
  {
    this.c -= 1;
    int i = paramInt1;
    for (paramInt1 = i + 1 & paramInt2;; paramInt1 = paramInt1 + 1 & paramInt2)
    {
      T ? = paramArrayOfT[paramInt1];
      if (? == null)
      {
        paramArrayOfT[i] = null;
        return true;
      }
      int j = a(?.hashCode()) & paramInt2;
      if (i <= paramInt1 ? (i >= j) || (j > paramInt1) : (i >= j) && (j > paramInt1))
      {
        paramArrayOfT[i] = ?;
        i = paramInt1;
        break;
      }
    }
  }
  
  public boolean a(T paramT)
  {
    Object[] arrayOfObject = this.e;
    int k = this.b;
    int i = a(paramT.hashCode()) & k;
    Object localObject = arrayOfObject[i];
    int j = i;
    if (localObject != null)
    {
      if (localObject.equals(paramT)) {
        return false;
      }
      do
      {
        i = i + 1 & k;
        localObject = arrayOfObject[i];
        if (localObject == null)
        {
          j = i;
          break;
        }
      } while (!localObject.equals(paramT));
      return false;
    }
    arrayOfObject[j] = paramT;
    i = this.c + 1;
    this.c = i;
    if (i >= this.d) {
      a();
    }
    return true;
  }
  
  public boolean b(T paramT)
  {
    Object[] arrayOfObject = this.e;
    int k = this.b;
    int j = a(paramT.hashCode()) & k;
    Object localObject = arrayOfObject[j];
    if (localObject == null) {
      return false;
    }
    int i = j;
    if (localObject.equals(paramT)) {
      return a(j, arrayOfObject, k);
    }
    do
    {
      j = i + 1 & k;
      localObject = arrayOfObject[j];
      if (localObject == null) {
        return false;
      }
      i = j;
    } while (!localObject.equals(paramT));
    return a(j, arrayOfObject, k);
  }
  
  public Object[] b()
  {
    return this.e;
  }
  
  public int c()
  {
    return this.c;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\j\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */