package e.a.b;

import e.a.c;
import java.io.IOException;

public final class e
  extends RuntimeException
{
  private IOException firstException;
  private IOException lastException;
  
  public e(IOException paramIOException)
  {
    super(paramIOException);
    this.firstException = paramIOException;
    this.lastException = paramIOException;
  }
  
  public void addConnectException(IOException paramIOException)
  {
    c.a(this.firstException, paramIOException);
    this.lastException = paramIOException;
  }
  
  public IOException getFirstConnectException()
  {
    return this.firstException;
  }
  
  public IOException getLastConnectException()
  {
    return this.lastException;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */