package com.autonavi.base.amap.mapcore.tools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.nio.ByteBuffer;

public class TextTextureGenerator
{
  private static final int ALIGNCENTER = 51;
  private static final int ALIGNLEFT = 49;
  private static final int ALIGNRIGHT = 50;
  static final int AN_LABEL_MAXCHARINLINE = 7;
  static final int AN_LABEL_MULITYLINE_SPAN = 2;
  public static final int CHAR_MAX = 256;
  public static final int MIN_DIFF_SIZE = 4;
  private float baseLine = 0.0F;
  private float startX = 0.0F;
  private int textFontsize = -1;
  private int textFontsizeTrue = -1;
  private Paint textPaint = null;
  
  public TextTextureGenerator()
  {
    createTextParam();
  }
  
  private void createTextParam()
  {
    this.textFontsizeTrue = (this.textFontsize - 2);
    this.textPaint = newPaint(null, this.textFontsizeTrue, 49);
    float f3 = (this.textFontsize - this.textFontsizeTrue) / 2.0F;
    this.startX = f3;
    for (;;)
    {
      try
      {
        localFontMetrics = this.textPaint.getFontMetrics();
        f1 = localFontMetrics.descent;
      }
      catch (Exception localException1)
      {
        Paint.FontMetrics localFontMetrics;
        float f1;
        float f2;
        continue;
      }
      try
      {
        f2 = localFontMetrics.ascent;
      }
      catch (Exception localException2) {}
    }
    f1 = 7.3242188F;
    f2 = -27.832031F;
    this.baseLine = ((this.textFontsizeTrue - (f1 + f2)) / 2.0F + f3 + 0.5F);
  }
  
  public static float getFontHeight(Paint paramPaint)
  {
    paramPaint = paramPaint.getFontMetrics();
    return paramPaint.descent - paramPaint.ascent;
  }
  
  public static float getFontlength(Paint paramPaint, String paramString)
  {
    return paramPaint.measureText(paramString);
  }
  
  public static int getNearstSize2N(int paramInt)
  {
    int i = 1;
    for (;;)
    {
      if (paramInt <= i) {
        return i;
      }
      i *= 2;
    }
  }
  
  private static Paint newPaint(String paramString, int paramInt1, int paramInt2)
  {
    paramString = new TextPaint();
    paramString.setColor(-1);
    paramString.setTextSize(paramInt1);
    paramString.setAntiAlias(true);
    paramString.setFilterBitmap(true);
    paramString.setTypeface(Typeface.DEFAULT);
    switch (paramInt2)
    {
    default: 
      paramString.setTextAlign(Paint.Align.LEFT);
      return paramString;
    case 51: 
      paramString.setTextAlign(Paint.Align.CENTER);
      return paramString;
    case 50: 
      paramString.setTextAlign(Paint.Align.RIGHT);
      return paramString;
    }
    paramString.setTextAlign(Paint.Align.LEFT);
    return paramString;
  }
  
  public byte[] getCharsWidths(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    byte[] arrayOfByte = new byte[j];
    float[] arrayOfFloat = new float[1];
    int i = 0;
    while (i < j)
    {
      Paint localPaint = this.textPaint;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((char)paramArrayOfInt[i]);
      localStringBuilder.append("");
      arrayOfFloat[0] = localPaint.measureText(localStringBuilder.toString());
      arrayOfByte[i] = ((byte)(int)(arrayOfFloat[0] + (this.textFontsize - this.textFontsizeTrue)));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public byte[] getTextPixelBuffer(int paramInt1, int paramInt2)
  {
    if (this.textFontsize != paramInt2)
    {
      this.textFontsize = paramInt2;
      createTextParam();
    }
    try
    {
      char[] arrayOfChar = new char[1];
      char c = (char)paramInt1;
      arrayOfChar[0] = c;
      float f2 = this.baseLine;
      Bitmap localBitmap = Bitmap.createBitmap(this.textFontsize, this.textFontsize, Bitmap.Config.ALPHA_8);
      Canvas localCanvas = new Canvas(localBitmap);
      byte[] arrayOfByte = new byte[this.textFontsize * this.textFontsize];
      ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
      float f3 = this.textPaint.measureText(String.valueOf(c));
      float f1 = f2;
      if (arrayOfChar[0] > 0)
      {
        f1 = f2;
        if (arrayOfChar[0] < 'Ā') {
          f1 = f2 - 1.5F;
        }
      }
      Paint.Align localAlign = this.textPaint.getTextAlign();
      f2 = f3 - this.textFontsizeTrue;
      if ((localAlign != Paint.Align.CENTER) && (f2 >= 4.0F))
      {
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        this.textPaint.setTextSize(this.textFontsizeTrue - f2);
        localCanvas.drawText(arrayOfChar, 0, 1, (this.textFontsizeTrue - f2) / 2.0F, f1, this.textPaint);
        this.textPaint.setTextAlign(localAlign);
      }
      else
      {
        localCanvas.drawText(arrayOfChar, 0, 1, this.startX, f1, this.textPaint);
      }
      localBitmap.copyPixelsToBuffer(localByteBuffer);
      localBitmap.recycle();
      return arrayOfByte;
    }
    catch (OutOfMemoryError|Exception localOutOfMemoryError)
    {
      for (;;) {}
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\tools\TextTextureGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */