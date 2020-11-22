package com.google.zxing.datamatrix.encoder;

abstract interface Encoder
{
  public abstract void encode(EncoderContext paramEncoderContext);
  
  public abstract int getEncodingMode();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\datamatrix\encoder\Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */