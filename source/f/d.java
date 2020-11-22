package f;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

public abstract interface d
  extends r, WritableByteChannel
{
  public abstract long a(s params)
    throws IOException;
  
  public abstract c b();
  
  public abstract d b(f paramf)
    throws IOException;
  
  public abstract d b(String paramString)
    throws IOException;
  
  public abstract d c(byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract d c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void flush()
    throws IOException;
  
  public abstract d g(int paramInt)
    throws IOException;
  
  public abstract d h(int paramInt)
    throws IOException;
  
  public abstract d i(int paramInt)
    throws IOException;
  
  public abstract d l(long paramLong)
    throws IOException;
  
  public abstract d m(long paramLong)
    throws IOException;
  
  public abstract d v()
    throws IOException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\f\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */