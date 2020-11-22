package com.github.barteksc.pdfviewer.source;

import android.content.Context;
import com.github.barteksc.pdfviewer.util.Util;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.a;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamSource
  implements DocumentSource
{
  private InputStream inputStream;
  
  public InputStreamSource(InputStream paramInputStream)
  {
    this.inputStream = paramInputStream;
  }
  
  public a createDocument(Context paramContext, PdfiumCore paramPdfiumCore, String paramString)
    throws IOException
  {
    return paramPdfiumCore.a(Util.toByteArray(this.inputStream), paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\github\barteksc\pdfviewer\source\InputStreamSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */