package com.github.barteksc.pdfviewer.source;

import android.content.Context;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.a;
import java.io.IOException;

public abstract interface DocumentSource
{
  public abstract a createDocument(Context paramContext, PdfiumCore paramPdfiumCore, String paramString)
    throws IOException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\github\barteksc\pdfviewer\source\DocumentSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */