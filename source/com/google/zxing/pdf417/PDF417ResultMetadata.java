package com.google.zxing.pdf417;

public final class PDF417ResultMetadata
{
  private String fileId;
  private boolean lastSegment;
  private int[] optionalData;
  private int segmentIndex;
  
  public String getFileId()
  {
    return this.fileId;
  }
  
  public int[] getOptionalData()
  {
    return this.optionalData;
  }
  
  public int getSegmentIndex()
  {
    return this.segmentIndex;
  }
  
  public boolean isLastSegment()
  {
    return this.lastSegment;
  }
  
  public void setFileId(String paramString)
  {
    this.fileId = paramString;
  }
  
  public void setLastSegment(boolean paramBoolean)
  {
    this.lastSegment = paramBoolean;
  }
  
  public void setOptionalData(int[] paramArrayOfInt)
  {
    this.optionalData = paramArrayOfInt;
  }
  
  public void setSegmentIndex(int paramInt)
  {
    this.segmentIndex = paramInt;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\pdf417\PDF417ResultMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */