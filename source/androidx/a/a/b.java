package androidx.a.a;

import android.content.Context;
import android.database.sqlite.SQLiteException;

public abstract interface b
{
  public static abstract class a
  {
    public final int a;
    
    public void a(a parama) {}
    
    public abstract void a(a parama, int paramInt1, int paramInt2);
    
    public abstract void b(a parama);
    
    public void b(a parama, int paramInt1, int paramInt2)
    {
      parama = new StringBuilder();
      parama.append("Can't downgrade database from version ");
      parama.append(paramInt1);
      parama.append(" to ");
      parama.append(paramInt2);
      throw new SQLiteException(parama.toString());
    }
    
    public void c(a parama) {}
  }
  
  public static class b
  {
    public final Context a;
    public final String b;
    public final b.a c;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\androidx\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */