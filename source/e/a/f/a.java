package e.a.f;

import java.io.File;
import java.io.IOException;

public abstract interface a
{
  public static final a a = new a()
  {
    public void a(File paramAnonymousFile)
      throws IOException
    {
      if (!paramAnonymousFile.delete())
      {
        if (!paramAnonymousFile.exists()) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("failed to delete ");
        localStringBuilder.append(paramAnonymousFile);
        throw new IOException(localStringBuilder.toString());
      }
    }
    
    public void a(File paramAnonymousFile1, File paramAnonymousFile2)
      throws IOException
    {
      a(paramAnonymousFile2);
      if (paramAnonymousFile1.renameTo(paramAnonymousFile2)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to rename ");
      localStringBuilder.append(paramAnonymousFile1);
      localStringBuilder.append(" to ");
      localStringBuilder.append(paramAnonymousFile2);
      throw new IOException(localStringBuilder.toString());
    }
    
    public boolean b(File paramAnonymousFile)
    {
      return paramAnonymousFile.exists();
    }
    
    public long c(File paramAnonymousFile)
    {
      return paramAnonymousFile.length();
    }
  };
  
  public abstract void a(File paramFile)
    throws IOException;
  
  public abstract void a(File paramFile1, File paramFile2)
    throws IOException;
  
  public abstract boolean b(File paramFile);
  
  public abstract long c(File paramFile);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */