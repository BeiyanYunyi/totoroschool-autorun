package com.github.barteksc.pdfviewer;

import android.content.Context;
import android.os.AsyncTask;
import com.github.barteksc.pdfviewer.source.DocumentSource;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.a;

class DecodingAsyncTask
  extends AsyncTask<Void, Void, Throwable>
{
  private boolean cancelled;
  private Context context;
  private DocumentSource docSource;
  private int firstPageIdx;
  private int pageHeight;
  private int pageWidth;
  private String password;
  private a pdfDocument;
  private PDFView pdfView;
  private PdfiumCore pdfiumCore;
  
  DecodingAsyncTask(DocumentSource paramDocumentSource, String paramString, PDFView paramPDFView, PdfiumCore paramPdfiumCore, int paramInt)
  {
    this.docSource = paramDocumentSource;
    this.firstPageIdx = paramInt;
    this.cancelled = false;
    this.pdfView = paramPDFView;
    this.password = paramString;
    this.pdfiumCore = paramPdfiumCore;
    this.context = paramPDFView.getContext();
  }
  
  protected Throwable doInBackground(Void... paramVarArgs)
  {
    try
    {
      this.pdfDocument = this.docSource.createDocument(this.context, this.pdfiumCore, this.password);
      this.pdfiumCore.a(this.pdfDocument, this.firstPageIdx);
      this.pageWidth = this.pdfiumCore.b(this.pdfDocument, this.firstPageIdx);
      this.pageHeight = this.pdfiumCore.c(this.pdfDocument, this.firstPageIdx);
      return null;
    }
    catch (Throwable paramVarArgs) {}
    return paramVarArgs;
  }
  
  protected void onCancelled()
  {
    this.cancelled = true;
  }
  
  protected void onPostExecute(Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      this.pdfView.loadError(paramThrowable);
      return;
    }
    if (!this.cancelled) {
      this.pdfView.loadComplete(this.pdfDocument, this.pageWidth, this.pageHeight);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\github\barteksc\pdfviewer\DecodingAsyncTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */