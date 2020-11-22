package e;

import e.a.a.d;
import e.a.a.e;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public final class c
  implements Closeable, Flushable
{
  final e a;
  final d b;
  
  public void close()
    throws IOException
  {
    this.b.close();
  }
  
  public void flush()
    throws IOException
  {
    this.b.flush();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */