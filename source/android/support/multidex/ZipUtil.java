package android.support.multidex;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

final class ZipUtil
{
  private static final int BUFFER_SIZE = 16384;
  private static final int ENDHDR = 22;
  private static final int ENDSIG = 101010256;
  
  static long computeCrcOfCentralDir(RandomAccessFile paramRandomAccessFile, CentralDirectory paramCentralDirectory)
    throws IOException
  {
    CRC32 localCRC32 = new CRC32();
    long l = paramCentralDirectory.size;
    paramRandomAccessFile.seek(paramCentralDirectory.offset);
    int i = (int)Math.min(16384L, l);
    paramCentralDirectory = new byte['䀀'];
    for (i = paramRandomAccessFile.read(paramCentralDirectory, 0, i); i != -1; i = paramRandomAccessFile.read(paramCentralDirectory, 0, (int)Math.min(16384L, l)))
    {
      localCRC32.update(paramCentralDirectory, 0, i);
      l -= i;
      if (l == 0L) {
        break;
      }
    }
    return localCRC32.getValue();
  }
  
  static CentralDirectory findCentralDirectory(RandomAccessFile paramRandomAccessFile)
    throws IOException, ZipException
  {
    long l2 = paramRandomAccessFile.length() - 22L;
    long l1 = 0L;
    if (l2 >= 0L)
    {
      long l3 = l2 - 65536L;
      if (l3 >= 0L) {
        l1 = l3;
      }
      int i = Integer.reverseBytes(101010256);
      do
      {
        paramRandomAccessFile.seek(l2);
        if (paramRandomAccessFile.readInt() == i)
        {
          paramRandomAccessFile.skipBytes(2);
          paramRandomAccessFile.skipBytes(2);
          paramRandomAccessFile.skipBytes(2);
          paramRandomAccessFile.skipBytes(2);
          localObject = new CentralDirectory();
          ((CentralDirectory)localObject).size = (Integer.reverseBytes(paramRandomAccessFile.readInt()) & 0xFFFFFFFF);
          ((CentralDirectory)localObject).offset = (Integer.reverseBytes(paramRandomAccessFile.readInt()) & 0xFFFFFFFF);
          return (CentralDirectory)localObject;
        }
        l2 -= 1L;
      } while (l2 >= l1);
      throw new ZipException("End Of Central Directory signature not found");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("File too short to be a zip file: ");
    ((StringBuilder)localObject).append(paramRandomAccessFile.length());
    throw new ZipException(((StringBuilder)localObject).toString());
  }
  
  static long getZipCrc(File paramFile)
    throws IOException
  {
    paramFile = new RandomAccessFile(paramFile, "r");
    try
    {
      long l = computeCrcOfCentralDir(paramFile, findCentralDirectory(paramFile));
      return l;
    }
    finally
    {
      paramFile.close();
    }
  }
  
  static class CentralDirectory
  {
    long offset;
    long size;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\multidex\ZipUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */