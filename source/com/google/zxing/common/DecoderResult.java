package com.google.zxing.common;

import java.util.List;

public final class DecoderResult
{
  private final List<byte[]> byteSegments;
  private final String ecLevel;
  private Integer erasures;
  private Integer errorsCorrected;
  private Object other;
  private final byte[] rawBytes;
  private final int structuredAppendParity;
  private final int structuredAppendSequenceNumber;
  private final String text;
  
  public DecoderResult(byte[] paramArrayOfByte, String paramString1, List<byte[]> paramList, String paramString2)
  {
    this(paramArrayOfByte, paramString1, paramList, paramString2, -1, -1);
  }
  
  public DecoderResult(byte[] paramArrayOfByte, String paramString1, List<byte[]> paramList, String paramString2, int paramInt1, int paramInt2)
  {
    this.rawBytes = paramArrayOfByte;
    this.text = paramString1;
    this.byteSegments = paramList;
    this.ecLevel = paramString2;
    this.structuredAppendParity = paramInt2;
    this.structuredAppendSequenceNumber = paramInt1;
  }
  
  public List<byte[]> getByteSegments()
  {
    return this.byteSegments;
  }
  
  public String getECLevel()
  {
    return this.ecLevel;
  }
  
  public Integer getErasures()
  {
    return this.erasures;
  }
  
  public Integer getErrorsCorrected()
  {
    return this.errorsCorrected;
  }
  
  public Object getOther()
  {
    return this.other;
  }
  
  public byte[] getRawBytes()
  {
    return this.rawBytes;
  }
  
  public int getStructuredAppendParity()
  {
    return this.structuredAppendParity;
  }
  
  public int getStructuredAppendSequenceNumber()
  {
    return this.structuredAppendSequenceNumber;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public boolean hasStructuredAppend()
  {
    return (this.structuredAppendParity >= 0) && (this.structuredAppendSequenceNumber >= 0);
  }
  
  public void setErasures(Integer paramInteger)
  {
    this.erasures = paramInteger;
  }
  
  public void setErrorsCorrected(Integer paramInteger)
  {
    this.errorsCorrected = paramInteger;
  }
  
  public void setOther(Object paramObject)
  {
    this.other = paramObject;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\common\DecoderResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */