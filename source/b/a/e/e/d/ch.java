package b.a.e.e.d;

import b.a.e.d.b;
import b.a.l;
import b.a.s;

public final class ch
  extends l<Integer>
{
  private final int a;
  private final long b;
  
  public ch(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = (paramInt1 + paramInt2);
  }
  
  protected void subscribeActual(s<? super Integer> params)
  {
    a locala = new a(params, this.a, this.b);
    params.onSubscribe(locala);
    locala.run();
  }
  
  static final class a
    extends b<Integer>
  {
    private static final long serialVersionUID = 396518478098735504L;
    final s<? super Integer> actual;
    final long end;
    boolean fused;
    long index;
    
    a(s<? super Integer> params, long paramLong1, long paramLong2)
    {
      this.actual = params;
      this.index = paramLong1;
      this.end = paramLong2;
    }
    
    public void clear()
    {
      this.index = this.end;
      lazySet(1);
    }
    
    public void dispose()
    {
      set(1);
    }
    
    public boolean isDisposed()
    {
      return get() != 0;
    }
    
    public boolean isEmpty()
    {
      return this.index == this.end;
    }
    
    public Integer poll()
      throws Exception
    {
      long l = this.index;
      if (l != this.end)
      {
        this.index = (1L + l);
        return Integer.valueOf((int)l);
      }
      lazySet(1);
      return null;
    }
    
    public int requestFusion(int paramInt)
    {
      if ((paramInt & 0x1) != 0)
      {
        this.fused = true;
        return 1;
      }
      return 0;
    }
    
    void run()
    {
      if (this.fused) {
        return;
      }
      s locals = this.actual;
      long l2 = this.end;
      for (long l1 = this.index; (l1 != l2) && (get() == 0); l1 += 1L) {
        locals.onNext(Integer.valueOf((int)l1));
      }
      if (get() == 0)
      {
        lazySet(1);
        locals.onComplete();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\e\d\ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */