package com.loc;

public final class ca
  extends cd
{
  private StringBuilder a = new StringBuilder();
  private boolean b = true;
  
  public ca() {}
  
  public ca(cd paramcd)
  {
    super(paramcd);
  }
  
  protected final byte[] a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = w.a(this.a.toString());
    this.d = paramArrayOfByte;
    this.b = true;
    this.a.delete(0, this.a.length());
    return paramArrayOfByte;
  }
  
  public final void b(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = w.a(paramArrayOfByte);
    if (this.b) {
      this.b = false;
    } else {
      this.a.append(",");
    }
    StringBuilder localStringBuilder = this.a;
    localStringBuilder.append("{\"log\":\"");
    localStringBuilder.append(paramArrayOfByte);
    localStringBuilder.append("\"}");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */