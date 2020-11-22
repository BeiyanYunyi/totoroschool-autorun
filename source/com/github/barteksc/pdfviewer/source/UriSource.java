package com.github.barteksc.pdfviewer.source;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.a;
import java.io.IOException;

public class UriSource
  implements DocumentSource
{
  private Uri uri;
  
  public UriSource(Uri paramUri)
  {
    this.uri = paramUri;
  }
  
  public a createDocument(Context paramContext, PdfiumCore paramPdfiumCore, String paramString)
    throws IOException
  {
    return paramPdfiumCore.a(paramContext.getContentResolver().openFileDescriptor(this.uri, "r"), paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\github\barteksc\pdfviewer\source\UriSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */