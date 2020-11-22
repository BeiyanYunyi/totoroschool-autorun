package f;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

public abstract interface e
  extends s, ReadableByteChannel
{
  public abstract long a(byte paramByte)
    throws IOException;
  
  public abstract long a(r paramr)
    throws IOException;
  
  public abstract String a(Charset paramCharset)
    throws IOException;
  
  public abstract void a(long paramLong)
    throws IOException;
  
  public abstract void a(byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract boolean a(long paramLong, f paramf)
    throws IOException;
  
  public abstract c b();
  
  public abstract boolean b(long paramLong)
    throws IOException;
  
  public abstract f d(long paramLong)
    throws IOException;
  
  public abstract boolean e()
    throws IOException;
  
  public abstract InputStream f();
  
  public abstract String f(long paramLong)
    throws IOException;
  
  public abstract byte h()
    throws IOException;
  
  public abstract byte[] h(long paramLong)
    throws IOException;
  
  public abstract short i()
    throws IOException;
  
  public abstract void i(long paramLong)
    throws IOException;
  
  public abstract int j()
    throws IOException;
  
  public abstract short k()
    throws IOException;
  
  public abstract int l()
    throws IOException;
  
  public abstract long m()
    throws IOException;
  
  public abstract String p()
    throws IOException;
  
  public abstract byte[] r()
    throws IOException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\f\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */