package c.e.a;

import c.b.c;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

class af
  implements aa
{
  private static c a = c.a(af.class);
  private File b;
  private RandomAccessFile c;
  
  public af(File paramFile)
    throws IOException
  {
    this.b = File.createTempFile("jxl", ".tmp", paramFile);
    this.b.deleteOnExit();
    this.c = new RandomAccessFile(this.b, "rw");
  }
  
  public int a()
    throws IOException
  {
    return (int)this.c.getFilePointer();
  }
  
  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte['Ѐ'];
    this.c.seek(0L);
    for (;;)
    {
      int i = this.c.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
    throws IOException
  {
    this.c.write(paramArrayOfByte);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    long l = this.c.getFilePointer();
    this.c.seek(paramInt);
    this.c.write(paramArrayOfByte);
    this.c.seek(l);
  }
  
  public void b()
    throws IOException
  {
    this.c.close();
    this.b.delete();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */