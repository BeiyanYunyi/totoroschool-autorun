package com.github.barteksc.pdfviewer;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseBooleanArray;
import com.github.barteksc.pdfviewer.exception.PageRenderingException;
import com.github.barteksc.pdfviewer.model.PagePart;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.a;

class RenderingHandler
  extends Handler
{
  static final int MSG_RENDER_TASK = 1;
  private static final String TAG = "com.github.barteksc.pdfviewer.RenderingHandler";
  private final SparseBooleanArray openedPages = new SparseBooleanArray();
  private a pdfDocument;
  private PDFView pdfView;
  private PdfiumCore pdfiumCore;
  private RectF renderBounds = new RectF();
  private Matrix renderMatrix = new Matrix();
  private Rect roundedRenderBounds = new Rect();
  private boolean running = false;
  
  RenderingHandler(Looper paramLooper, PDFView paramPDFView, PdfiumCore paramPdfiumCore, a parama)
  {
    super(paramLooper);
    this.pdfView = paramPDFView;
    this.pdfiumCore = paramPdfiumCore;
    this.pdfDocument = parama;
  }
  
  private void calculateBounds(int paramInt1, int paramInt2, RectF paramRectF)
  {
    this.renderMatrix.reset();
    Matrix localMatrix = this.renderMatrix;
    float f1 = -paramRectF.left;
    float f2 = paramInt1;
    float f3 = -paramRectF.top;
    float f4 = paramInt2;
    localMatrix.postTranslate(f1 * f2, f3 * f4);
    this.renderMatrix.postScale(1.0F / paramRectF.width(), 1.0F / paramRectF.height());
    this.renderBounds.set(0.0F, 0.0F, f2, f4);
    this.renderMatrix.mapRect(this.renderBounds);
    this.renderBounds.round(this.roundedRenderBounds);
  }
  
  private PagePart proceed(RenderingTask paramRenderingTask)
    throws PageRenderingException
  {
    if (this.openedPages.indexOfKey(paramRenderingTask.page) < 0) {
      try
      {
        this.pdfiumCore.a(this.pdfDocument, paramRenderingTask.page);
        this.openedPages.put(paramRenderingTask.page, true);
      }
      catch (Exception localException)
      {
        this.openedPages.put(paramRenderingTask.page, false);
        throw new PageRenderingException(paramRenderingTask.page, localException);
      }
    }
    int i = Math.round(paramRenderingTask.width);
    int j = Math.round(paramRenderingTask.height);
    try
    {
      if (paramRenderingTask.bestQuality) {
        localObject = Bitmap.Config.ARGB_8888;
      } else {
        localObject = Bitmap.Config.RGB_565;
      }
      Object localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      calculateBounds(i, j, paramRenderingTask.bounds);
      if (this.openedPages.get(paramRenderingTask.page)) {
        this.pdfiumCore.a(this.pdfDocument, (Bitmap)localObject, paramRenderingTask.page, this.roundedRenderBounds.left, this.roundedRenderBounds.top, this.roundedRenderBounds.width(), this.roundedRenderBounds.height(), paramRenderingTask.annotationRendering);
      } else {
        ((Bitmap)localObject).eraseColor(this.pdfView.getInvalidPageColor());
      }
      return new PagePart(paramRenderingTask.userPage, paramRenderingTask.page, (Bitmap)localObject, paramRenderingTask.width, paramRenderingTask.height, paramRenderingTask.bounds, paramRenderingTask.thumbnail, paramRenderingTask.cacheOrder);
    }
    catch (IllegalArgumentException paramRenderingTask)
    {
      paramRenderingTask.printStackTrace();
    }
    return null;
  }
  
  void addRenderingTask(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, RectF paramRectF, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3)
  {
    sendMessage(obtainMessage(1, new RenderingTask(paramFloat1, paramFloat2, paramRectF, paramInt1, paramInt2, paramBoolean1, paramInt3, paramBoolean2, paramBoolean3)));
  }
  
  public void handleMessage(final Message paramMessage)
  {
    paramMessage = (RenderingTask)paramMessage.obj;
    try
    {
      paramMessage = proceed(paramMessage);
      if (paramMessage != null)
      {
        if (this.running)
        {
          this.pdfView.post(new Runnable()
          {
            public void run()
            {
              RenderingHandler.this.pdfView.onBitmapRendered(paramMessage);
            }
          });
          return;
        }
        paramMessage.getRenderedBitmap().recycle();
        return;
      }
    }
    catch (PageRenderingException paramMessage)
    {
      this.pdfView.post(new Runnable()
      {
        public void run()
        {
          RenderingHandler.this.pdfView.onPageError(paramMessage);
        }
      });
    }
  }
  
  void start()
  {
    this.running = true;
  }
  
  void stop()
  {
    this.running = false;
  }
  
  private class RenderingTask
  {
    boolean annotationRendering;
    boolean bestQuality;
    RectF bounds;
    int cacheOrder;
    float height;
    int page;
    boolean thumbnail;
    int userPage;
    float width;
    
    RenderingTask(float paramFloat1, float paramFloat2, RectF paramRectF, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.page = paramInt2;
      this.width = paramFloat1;
      this.height = paramFloat2;
      this.bounds = paramRectF;
      this.userPage = paramInt1;
      this.thumbnail = paramBoolean1;
      this.cacheOrder = paramInt3;
      this.bestQuality = paramBoolean2;
      this.annotationRendering = paramBoolean3;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\github\barteksc\pdfviewer\RenderingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */