package f;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class l
{
  static final Logger a = Logger.getLogger(l.class.getName());
  
  public static d a(r paramr)
  {
    return new m(paramr);
  }
  
  public static e a(s params)
  {
    return new n(params);
  }
  
  private static r a(final OutputStream paramOutputStream, t paramt)
  {
    if (paramOutputStream != null)
    {
      if (paramt != null) {
        new r()
        {
          public void a(c paramAnonymousc, long paramAnonymousLong)
            throws IOException
          {
            u.a(paramAnonymousc.b, 0L, paramAnonymousLong);
            while (paramAnonymousLong > 0L)
            {
              l.this.g();
              o localo = paramAnonymousc.a;
              int i = (int)Math.min(paramAnonymousLong, localo.c - localo.b);
              paramOutputStream.write(localo.a, localo.b, i);
              localo.b += i;
              long l2 = i;
              long l1 = paramAnonymousLong - l2;
              paramAnonymousc.b -= l2;
              paramAnonymousLong = l1;
              if (localo.b == localo.c)
              {
                paramAnonymousc.a = localo.b();
                p.a(localo);
                paramAnonymousLong = l1;
              }
            }
          }
          
          public void close()
            throws IOException
          {
            paramOutputStream.close();
          }
          
          public void flush()
            throws IOException
          {
            paramOutputStream.flush();
          }
          
          public t timeout()
          {
            return l.this;
          }
          
          public String toString()
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("sink(");
            localStringBuilder.append(paramOutputStream);
            localStringBuilder.append(")");
            return localStringBuilder.toString();
          }
        };
      }
      throw new IllegalArgumentException("timeout == null");
    }
    throw new IllegalArgumentException("out == null");
  }
  
  public static r a(Socket paramSocket)
    throws IOException
  {
    if (paramSocket != null)
    {
      if (paramSocket.getOutputStream() != null)
      {
        a locala = c(paramSocket);
        return locala.a(a(paramSocket.getOutputStream(), locala));
      }
      throw new IOException("socket's output stream == null");
    }
    throw new IllegalArgumentException("socket == null");
  }
  
  public static s a(File paramFile)
    throws FileNotFoundException
  {
    if (paramFile != null) {
      return a(new FileInputStream(paramFile));
    }
    throw new IllegalArgumentException("file == null");
  }
  
  public static s a(InputStream paramInputStream)
  {
    return a(paramInputStream, new t());
  }
  
  private static s a(final InputStream paramInputStream, t paramt)
  {
    if (paramInputStream != null)
    {
      if (paramt != null) {
        new s()
        {
          public void close()
            throws IOException
          {
            paramInputStream.close();
          }
          
          public long read(c paramAnonymousc, long paramAnonymousLong)
            throws IOException
          {
            if (paramAnonymousLong >= 0L)
            {
              if (paramAnonymousLong == 0L) {
                return 0L;
              }
              try
              {
                l.this.g();
                o localo = paramAnonymousc.e(1);
                int i = (int)Math.min(paramAnonymousLong, 8192 - localo.c);
                i = paramInputStream.read(localo.a, localo.c, i);
                if (i == -1) {
                  return -1L;
                }
                localo.c += i;
                paramAnonymousLong = paramAnonymousc.b;
                long l = i;
                paramAnonymousc.b = (paramAnonymousLong + l);
                return l;
              }
              catch (AssertionError paramAnonymousc)
              {
                if (l.a(paramAnonymousc)) {
                  throw new IOException(paramAnonymousc);
                }
                throw paramAnonymousc;
              }
            }
            paramAnonymousc = new StringBuilder();
            paramAnonymousc.append("byteCount < 0: ");
            paramAnonymousc.append(paramAnonymousLong);
            throw new IllegalArgumentException(paramAnonymousc.toString());
          }
          
          public t timeout()
          {
            return l.this;
          }
          
          public String toString()
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("source(");
            localStringBuilder.append(paramInputStream);
            localStringBuilder.append(")");
            return localStringBuilder.toString();
          }
        };
      }
      throw new IllegalArgumentException("timeout == null");
    }
    throw new IllegalArgumentException("in == null");
  }
  
  static boolean a(AssertionError paramAssertionError)
  {
    return (paramAssertionError.getCause() != null) && (paramAssertionError.getMessage() != null) && (paramAssertionError.getMessage().contains("getsockname failed"));
  }
  
  public static s b(Socket paramSocket)
    throws IOException
  {
    if (paramSocket != null)
    {
      if (paramSocket.getInputStream() != null)
      {
        a locala = c(paramSocket);
        return locala.a(a(paramSocket.getInputStream(), locala));
      }
      throw new IOException("socket's input stream == null");
    }
    throw new IllegalArgumentException("socket == null");
  }
  
  private static a c(Socket paramSocket)
  {
    new a()
    {
      protected IOException a(@Nullable IOException paramAnonymousIOException)
      {
        SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
        if (paramAnonymousIOException != null) {
          localSocketTimeoutException.initCause(paramAnonymousIOException);
        }
        return localSocketTimeoutException;
      }
      
      protected void a()
      {
        try
        {
          l.this.close();
          return;
        }
        catch (AssertionError localAssertionError)
        {
          if (l.a(localAssertionError))
          {
            localLogger = l.a;
            localLevel = Level.WARNING;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Failed to close timed out socket ");
            localStringBuilder.append(l.this);
            localLogger.log(localLevel, localStringBuilder.toString(), localAssertionError);
            return;
          }
          throw localAssertionError;
        }
        catch (Exception localException)
        {
          Logger localLogger = l.a;
          Level localLevel = Level.WARNING;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Failed to close timed out socket ");
          localStringBuilder.append(l.this);
          localLogger.log(localLevel, localStringBuilder.toString(), localException);
        }
      }
    };
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\f\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */