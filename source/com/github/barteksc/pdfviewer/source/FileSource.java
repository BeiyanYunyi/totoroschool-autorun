package com.github.barteksc.pdfviewer.source;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.a;
import java.io.File;
import java.io.IOException;

public class FileSource
  implements DocumentSource
{
  private File file;
  
  public FileSource(File paramFile)
  {
    this.file = paramFile;
  }
  
  public a createDocument(Context paramContext, PdfiumCore paramPdfiumCore, String paramString)
    throws IOException
  {
    return paramPdfiumCore.a(ParcelFileDescriptor.open(this.file, 268435456), paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\github\barteksc\pdfviewer\source\FileSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */