package com.github.barteksc.pdfviewer.source;

import android.content.Context;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.a;
import java.io.IOException;

public class ByteArraySource
  implements DocumentSource
{
  private byte[] data;
  
  public ByteArraySource(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }
  
  public a createDocument(Context paramContext, PdfiumCore paramPdfiumCore, String paramString)
    throws IOException
  {
    return paramPdfiumCore.a(this.data, paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\github\barteksc\pdfviewer\source\ByteArraySource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */