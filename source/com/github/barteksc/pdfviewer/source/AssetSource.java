package com.github.barteksc.pdfviewer.source;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.github.barteksc.pdfviewer.util.FileUtils;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.a;
import java.io.IOException;

public class AssetSource
  implements DocumentSource
{
  private final String assetName;
  
  public AssetSource(String paramString)
  {
    this.assetName = paramString;
  }
  
  public a createDocument(Context paramContext, PdfiumCore paramPdfiumCore, String paramString)
    throws IOException
  {
    return paramPdfiumCore.a(ParcelFileDescriptor.open(FileUtils.fileFromAsset(paramContext, this.assetName), 268435456), paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\github\barteksc\pdfviewer\source\AssetSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */