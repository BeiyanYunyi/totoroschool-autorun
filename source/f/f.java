package f;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class f
  implements Serializable, Comparable<f>
{
  public static final f EMPTY = of(new byte[0]);
  static final char[] HEX_DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final long serialVersionUID = 1L;
  final byte[] data;
  transient int hashCode;
  transient String utf8;
  
  f(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }
  
  private static int a(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return paramChar - 'a' + 10;
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return paramChar - 'A' + 10;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected hex digit: ");
    localStringBuilder.append(paramChar);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private f a(String paramString)
  {
    try
    {
      paramString = of(MessageDigest.getInstance(paramString).digest(this.data));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  private f a(String paramString, f paramf)
  {
    try
    {
      Mac localMac = Mac.getInstance(paramString);
      localMac.init(new SecretKeySpec(paramf.toByteArray(), paramString));
      paramString = of(localMac.doFinal(this.data));
      return paramString;
    }
    catch (InvalidKeyException paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  static int codePointIndexToCharIndex(String paramString, int paramInt)
  {
    int k = paramString.length();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      if (j == paramInt) {
        return i;
      }
      int m = paramString.codePointAt(i);
      if (((Character.isISOControl(m)) && (m != 10) && (m != 13)) || (m == 65533)) {
        return -1;
      }
      j += 1;
      i += Character.charCount(m);
    }
    return paramString.length();
  }
  
  @Nullable
  public static f decodeBase64(String paramString)
  {
    if (paramString != null)
    {
      paramString = b.a(paramString);
      if (paramString != null) {
        return new f(paramString);
      }
      return null;
    }
    throw new IllegalArgumentException("base64 == null");
  }
  
  public static f decodeHex(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() % 2 == 0)
      {
        localObject = new byte[paramString.length() / 2];
        int i = 0;
        while (i < localObject.length)
        {
          int j = i * 2;
          localObject[i] = ((byte)((a(paramString.charAt(j)) << 4) + a(paramString.charAt(j + 1))));
          i += 1;
        }
        return of((byte[])localObject);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unexpected hex string: ");
      ((StringBuilder)localObject).append(paramString);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new IllegalArgumentException("hex == null");
  }
  
  public static f encodeString(String paramString, Charset paramCharset)
  {
    if (paramString != null)
    {
      if (paramCharset != null) {
        return new f(paramString.getBytes(paramCharset));
      }
      throw new IllegalArgumentException("charset == null");
    }
    throw new IllegalArgumentException("s == null");
  }
  
  public static f encodeUtf8(String paramString)
  {
    if (paramString != null)
    {
      f localf = new f(paramString.getBytes(u.a));
      localf.utf8 = paramString;
      return localf;
    }
    throw new IllegalArgumentException("s == null");
  }
  
  public static f of(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer != null)
    {
      byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
      paramByteBuffer.get(arrayOfByte);
      return new f(arrayOfByte);
    }
    throw new IllegalArgumentException("data == null");
  }
  
  public static f of(byte... paramVarArgs)
  {
    if (paramVarArgs != null) {
      return new f((byte[])paramVarArgs.clone());
    }
    throw new IllegalArgumentException("data == null");
  }
  
  public static f of(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      u.a(paramArrayOfByte.length, paramInt1, paramInt2);
      byte[] arrayOfByte = new byte[paramInt2];
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
      return new f(arrayOfByte);
    }
    throw new IllegalArgumentException("data == null");
  }
  
  public static f read(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    if (paramInputStream != null)
    {
      if (paramInt >= 0)
      {
        byte[] arrayOfByte = new byte[paramInt];
        int i = 0;
        while (i < paramInt)
        {
          int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
          if (j != -1) {
            i += j;
          } else {
            throw new EOFException();
          }
        }
        return new f(arrayOfByte);
      }
      paramInputStream = new StringBuilder();
      paramInputStream.append("byteCount < 0: ");
      paramInputStream.append(paramInt);
      throw new IllegalArgumentException(paramInputStream.toString());
    }
    throw new IllegalArgumentException("in == null");
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException
  {
    paramObjectInputStream = read(paramObjectInputStream, paramObjectInputStream.readInt());
    try
    {
      Field localField = f.class.getDeclaredField("data");
      localField.setAccessible(true);
      localField.set(this, paramObjectInputStream.data);
      return;
    }
    catch (NoSuchFieldException paramObjectInputStream)
    {
      for (;;) {}
    }
    catch (IllegalAccessException paramObjectInputStream)
    {
      for (;;) {}
    }
    throw new AssertionError();
    throw new AssertionError();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeInt(this.data.length);
    paramObjectOutputStream.write(this.data);
  }
  
  public ByteBuffer asByteBuffer()
  {
    return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
  }
  
  public String base64()
  {
    return b.a(this.data);
  }
  
  public String base64Url()
  {
    return b.b(this.data);
  }
  
  public int compareTo(f paramf)
  {
    int j = size();
    int k = paramf.size();
    int m = Math.min(j, k);
    int i = 0;
    while (i < m)
    {
      int n = getByte(i) & 0xFF;
      int i1 = paramf.getByte(i) & 0xFF;
      if (n == i1)
      {
        i += 1;
      }
      else
      {
        if (n < i1) {
          return -1;
        }
        return 1;
      }
    }
    if (j == k) {
      return 0;
    }
    if (j < k) {
      return -1;
    }
    return 1;
  }
  
  public final boolean endsWith(f paramf)
  {
    return rangeEquals(size() - paramf.size(), paramf, 0, paramf.size());
  }
  
  public final boolean endsWith(byte[] paramArrayOfByte)
  {
    return rangeEquals(size() - paramArrayOfByte.length, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof f))
    {
      paramObject = (f)paramObject;
      if ((((f)paramObject).size() == this.data.length) && (((f)paramObject).rangeEquals(0, this.data, 0, this.data.length))) {
        return true;
      }
    }
    return false;
  }
  
  public byte getByte(int paramInt)
  {
    return this.data[paramInt];
  }
  
  public int hashCode()
  {
    int i = this.hashCode;
    if (i != 0) {
      return i;
    }
    i = Arrays.hashCode(this.data);
    this.hashCode = i;
    return i;
  }
  
  public String hex()
  {
    char[] arrayOfChar = new char[this.data.length * 2];
    byte[] arrayOfByte = this.data;
    int k = arrayOfByte.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = arrayOfByte[i];
      int n = j + 1;
      arrayOfChar[j] = HEX_DIGITS[(m >> 4 & 0xF)];
      j = n + 1;
      arrayOfChar[n] = HEX_DIGITS[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public f hmacSha1(f paramf)
  {
    return a("HmacSHA1", paramf);
  }
  
  public f hmacSha256(f paramf)
  {
    return a("HmacSHA256", paramf);
  }
  
  public f hmacSha512(f paramf)
  {
    return a("HmacSHA512", paramf);
  }
  
  public final int indexOf(f paramf)
  {
    return indexOf(paramf.internalArray(), 0);
  }
  
  public final int indexOf(f paramf, int paramInt)
  {
    return indexOf(paramf.internalArray(), paramInt);
  }
  
  public final int indexOf(byte[] paramArrayOfByte)
  {
    return indexOf(paramArrayOfByte, 0);
  }
  
  public int indexOf(byte[] paramArrayOfByte, int paramInt)
  {
    paramInt = Math.max(paramInt, 0);
    int i = this.data.length;
    int j = paramArrayOfByte.length;
    while (paramInt <= i - j)
    {
      if (u.a(this.data, paramInt, paramArrayOfByte, 0, paramArrayOfByte.length)) {
        return paramInt;
      }
      paramInt += 1;
    }
    return -1;
  }
  
  byte[] internalArray()
  {
    return this.data;
  }
  
  public final int lastIndexOf(f paramf)
  {
    return lastIndexOf(paramf.internalArray(), size());
  }
  
  public final int lastIndexOf(f paramf, int paramInt)
  {
    return lastIndexOf(paramf.internalArray(), paramInt);
  }
  
  public final int lastIndexOf(byte[] paramArrayOfByte)
  {
    return lastIndexOf(paramArrayOfByte, size());
  }
  
  public int lastIndexOf(byte[] paramArrayOfByte, int paramInt)
  {
    paramInt = Math.min(paramInt, this.data.length - paramArrayOfByte.length);
    while (paramInt >= 0)
    {
      if (u.a(this.data, paramInt, paramArrayOfByte, 0, paramArrayOfByte.length)) {
        return paramInt;
      }
      paramInt -= 1;
    }
    return -1;
  }
  
  public f md5()
  {
    return a("MD5");
  }
  
  public boolean rangeEquals(int paramInt1, f paramf, int paramInt2, int paramInt3)
  {
    return paramf.rangeEquals(paramInt2, this.data, paramInt1, paramInt3);
  }
  
  public boolean rangeEquals(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return (paramInt1 >= 0) && (paramInt1 <= this.data.length - paramInt3) && (paramInt2 >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt3) && (u.a(this.data, paramInt1, paramArrayOfByte, paramInt2, paramInt3));
  }
  
  public f sha1()
  {
    return a("SHA-1");
  }
  
  public f sha256()
  {
    return a("SHA-256");
  }
  
  public f sha512()
  {
    return a("SHA-512");
  }
  
  public int size()
  {
    return this.data.length;
  }
  
  public final boolean startsWith(f paramf)
  {
    return rangeEquals(0, paramf, 0, paramf.size());
  }
  
  public final boolean startsWith(byte[] paramArrayOfByte)
  {
    return rangeEquals(0, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public String string(Charset paramCharset)
  {
    if (paramCharset != null) {
      return new String(this.data, paramCharset);
    }
    throw new IllegalArgumentException("charset == null");
  }
  
  public f substring(int paramInt)
  {
    return substring(paramInt, this.data.length);
  }
  
  public f substring(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 <= this.data.length)
      {
        int i = paramInt2 - paramInt1;
        if (i >= 0)
        {
          if ((paramInt1 == 0) && (paramInt2 == this.data.length)) {
            return this;
          }
          localObject = new byte[i];
          System.arraycopy(this.data, paramInt1, localObject, 0, i);
          return new f((byte[])localObject);
        }
        throw new IllegalArgumentException("endIndex < beginIndex");
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("endIndex > length(");
      ((StringBuilder)localObject).append(this.data.length);
      ((StringBuilder)localObject).append(")");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new IllegalArgumentException("beginIndex < 0");
  }
  
  public f toAsciiLowercase()
  {
    int i = 0;
    while (i < this.data.length)
    {
      int k = this.data[i];
      if ((k >= 65) && (k <= 90))
      {
        byte[] arrayOfByte = (byte[])this.data.clone();
        int j = i + 1;
        arrayOfByte[i] = ((byte)(k + 32));
        i = j;
        while (i < arrayOfByte.length)
        {
          j = arrayOfByte[i];
          if ((j >= 65) && (j <= 90)) {
            arrayOfByte[i] = ((byte)(j + 32));
          }
          i += 1;
        }
        return new f(arrayOfByte);
      }
      i += 1;
    }
    return this;
  }
  
  public f toAsciiUppercase()
  {
    int i = 0;
    while (i < this.data.length)
    {
      int k = this.data[i];
      if ((k >= 97) && (k <= 122))
      {
        byte[] arrayOfByte = (byte[])this.data.clone();
        int j = i + 1;
        arrayOfByte[i] = ((byte)(k - 32));
        i = j;
        while (i < arrayOfByte.length)
        {
          j = arrayOfByte[i];
          if ((j >= 97) && (j <= 122)) {
            arrayOfByte[i] = ((byte)(j - 32));
          }
          i += 1;
        }
        return new f(arrayOfByte);
      }
      i += 1;
    }
    return this;
  }
  
  public byte[] toByteArray()
  {
    return (byte[])this.data.clone();
  }
  
  public String toString()
  {
    if (this.data.length == 0) {
      return "[size=0]";
    }
    Object localObject2 = utf8();
    int i = codePointIndexToCharIndex((String)localObject2, 64);
    if (i == -1)
    {
      if (this.data.length <= 64)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[hex=");
        ((StringBuilder)localObject1).append(hex());
        ((StringBuilder)localObject1).append("]");
        return ((StringBuilder)localObject1).toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[size=");
      ((StringBuilder)localObject1).append(this.data.length);
      ((StringBuilder)localObject1).append(" hex=");
      ((StringBuilder)localObject1).append(substring(0, 64).hex());
      ((StringBuilder)localObject1).append("…]");
      return ((StringBuilder)localObject1).toString();
    }
    Object localObject1 = ((String)localObject2).substring(0, i).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
    if (i < ((String)localObject2).length())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[size=");
      ((StringBuilder)localObject2).append(this.data.length);
      ((StringBuilder)localObject2).append(" text=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("…]");
      return ((StringBuilder)localObject2).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[text=");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("]");
    return ((StringBuilder)localObject2).toString();
  }
  
  public String utf8()
  {
    String str = this.utf8;
    if (str != null) {
      return str;
    }
    str = new String(this.data, u.a);
    this.utf8 = str;
    return str;
  }
  
  void write(c paramc)
  {
    paramc.b(this.data, 0, this.data.length);
  }
  
  public void write(OutputStream paramOutputStream)
    throws IOException
  {
    if (paramOutputStream != null)
    {
      paramOutputStream.write(this.data);
      return;
    }
    throw new IllegalArgumentException("out == null");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\f\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */