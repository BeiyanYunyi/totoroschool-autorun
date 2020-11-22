package com.github.barteksc.pdfviewer;

import android.graphics.RectF;
import android.util.Pair;
import com.github.barteksc.pdfviewer.util.Constants;
import com.github.barteksc.pdfviewer.util.Constants.Cache;
import com.github.barteksc.pdfviewer.util.MathUtils;

class PagesLoader
{
  private int cacheOrder;
  private float colWidth;
  private Pair<Integer, Integer> colsRows;
  private float pageRelativePartHeight;
  private float pageRelativePartWidth;
  private float partRenderHeight;
  private float partRenderWidth;
  private PDFView pdfView;
  private float rowHeight;
  private float scaledHeight;
  private float scaledSpacingPx;
  private float scaledWidth;
  private int thumbnailHeight;
  private final RectF thumbnailRect = new RectF(0.0F, 0.0F, 1.0F, 1.0F);
  private int thumbnailWidth;
  private float xOffset;
  private float yOffset;
  
  PagesLoader(PDFView paramPDFView)
  {
    this.pdfView = paramPDFView;
  }
  
  private int documentPage(int paramInt)
  {
    int i;
    if (this.pdfView.getOriginalUserPages() != null)
    {
      if (paramInt >= 0)
      {
        if (paramInt >= this.pdfView.getOriginalUserPages().length) {
          return -1;
        }
        i = this.pdfView.getOriginalUserPages()[paramInt];
      }
      else
      {
        return -1;
      }
    }
    else {
      i = paramInt;
    }
    if (i >= 0)
    {
      if (paramInt >= this.pdfView.getDocumentPageCount()) {
        return -1;
      }
      return i;
    }
    return -1;
  }
  
  private Holder getPageAndCoordsByOffset(float paramFloat, boolean paramBoolean)
  {
    Holder localHolder = new Holder(null);
    paramFloat = -MathUtils.max(paramFloat, 0.0F);
    float f;
    if (this.pdfView.isSwipeVertical())
    {
      localHolder.page = MathUtils.floor(paramFloat / (this.scaledHeight + this.scaledSpacingPx));
      f = Math.abs(paramFloat - (this.scaledHeight + this.scaledSpacingPx) * localHolder.page) / this.rowHeight;
      paramFloat = this.xOffset / this.colWidth;
    }
    else
    {
      localHolder.page = MathUtils.floor(paramFloat / (this.scaledWidth + this.scaledSpacingPx));
      paramFloat = Math.abs(paramFloat - (this.scaledWidth + this.scaledSpacingPx) * localHolder.page) / this.colWidth;
      f = this.yOffset / this.rowHeight;
    }
    if (paramBoolean)
    {
      localHolder.row = MathUtils.ceil(f);
      localHolder.col = MathUtils.ceil(paramFloat);
      return localHolder;
    }
    localHolder.row = MathUtils.floor(f);
    localHolder.col = MathUtils.floor(paramFloat);
    return localHolder;
  }
  
  private Pair<Integer, Integer> getPageColsRows()
  {
    float f1 = 1.0F / this.pdfView.getOptimalPageWidth();
    float f2 = 1.0F / this.pdfView.getOptimalPageHeight();
    f2 = Constants.PART_SIZE * f2 / this.pdfView.getZoom();
    f1 = Constants.PART_SIZE * f1 / this.pdfView.getZoom();
    int i = MathUtils.ceil(1.0F / f2);
    return new Pair(Integer.valueOf(MathUtils.ceil(1.0F / f1)), Integer.valueOf(i));
  }
  
  private boolean loadCell(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2)
  {
    float f1 = paramInt4 * paramFloat1;
    float f2 = paramInt3 * paramFloat2;
    float f4 = this.partRenderWidth;
    float f3 = this.partRenderHeight;
    if (f1 + paramFloat1 > 1.0F) {
      paramFloat1 = 1.0F - f1;
    }
    if (f2 + paramFloat2 > 1.0F) {
      paramFloat2 = 1.0F - f2;
    }
    f4 *= paramFloat1;
    f3 *= paramFloat2;
    RectF localRectF = new RectF(f1, f2, paramFloat1 + f1, paramFloat2 + f2);
    if ((f4 > 0.0F) && (f3 > 0.0F))
    {
      if (!this.pdfView.cacheManager.upPartIfContained(paramInt1, paramInt2, f4, f3, localRectF, this.cacheOrder)) {
        this.pdfView.renderingHandler.addRenderingTask(paramInt1, paramInt2, f4, f3, localRectF, false, this.cacheOrder, this.pdfView.isBestQuality(), this.pdfView.isAnnotationRendering());
      }
      this.cacheOrder += 1;
      return true;
    }
    return false;
  }
  
  private int loadRelative(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = this.pdfView.isSwipeVertical();
    int j = 0;
    int i = 0;
    float f1;
    float f2;
    float f3;
    if (bool)
    {
      f1 = this.rowHeight;
      f2 = paramInt1;
      f3 = this.pdfView.getCurrentYOffset();
      if (paramBoolean) {
        paramInt1 = this.pdfView.getHeight();
      } else {
        paramInt1 = 0;
      }
      f1 = f3 - paramInt1 - (f1 * f2 + 1.0F);
    }
    else
    {
      f1 = this.colWidth;
      f2 = paramInt1;
      f3 = this.pdfView.getCurrentXOffset();
      if (paramBoolean) {
        paramInt1 = this.pdfView.getWidth();
      } else {
        paramInt1 = 0;
      }
      f1 = f3 - paramInt1 - f1 * f2;
    }
    Holder localHolder = getPageAndCoordsByOffset(f1, false);
    int k = documentPage(localHolder.page);
    if (k < 0) {
      return 0;
    }
    loadThumbnail(localHolder.page, k);
    if (this.pdfView.isSwipeVertical())
    {
      j = MathUtils.min(MathUtils.floor(this.xOffset / this.colWidth) - 1, 0);
      m = MathUtils.max(MathUtils.ceil((this.xOffset + this.pdfView.getWidth()) / this.colWidth) + 1, ((Integer)this.colsRows.first).intValue());
      for (paramInt1 = i;; paramInt1 = i)
      {
        i = paramInt1;
        if (j > m) {
          break;
        }
        i = paramInt1;
        if (loadCell(localHolder.page, k, localHolder.row, j, this.pageRelativePartWidth, this.pageRelativePartHeight)) {
          i = paramInt1 + 1;
        }
        if (i >= paramInt2) {
          return i;
        }
        j += 1;
      }
    }
    i = MathUtils.min(MathUtils.floor(this.yOffset / this.rowHeight) - 1, 0);
    int m = MathUtils.max(MathUtils.ceil((this.yOffset + this.pdfView.getHeight()) / this.rowHeight) + 1, ((Integer)this.colsRows.second).intValue());
    paramInt1 = j;
    j = i;
    for (;;)
    {
      i = paramInt1;
      if (j > m) {
        break;
      }
      i = paramInt1;
      if (loadCell(localHolder.page, k, j, localHolder.col, this.pageRelativePartWidth, this.pageRelativePartHeight)) {
        i = paramInt1 + 1;
      }
      if (i >= paramInt2) {
        return i;
      }
      j += 1;
      paramInt1 = i;
    }
    return i;
  }
  
  private void loadThumbnail(int paramInt1, int paramInt2)
  {
    if (!this.pdfView.cacheManager.containsThumbnail(paramInt1, paramInt2, this.thumbnailWidth, this.thumbnailHeight, this.thumbnailRect)) {
      this.pdfView.renderingHandler.addRenderingTask(paramInt1, paramInt2, this.thumbnailWidth, this.thumbnailHeight, this.thumbnailRect, true, 0, this.pdfView.isBestQuality(), this.pdfView.isAnnotationRendering());
    }
  }
  
  public void loadPages()
  {
    this.scaledHeight = this.pdfView.toCurrentScale(this.pdfView.getOptimalPageHeight());
    this.scaledWidth = this.pdfView.toCurrentScale(this.pdfView.getOptimalPageWidth());
    this.thumbnailWidth = ((int)(this.pdfView.getOptimalPageWidth() * Constants.THUMBNAIL_RATIO));
    this.thumbnailHeight = ((int)(this.pdfView.getOptimalPageHeight() * Constants.THUMBNAIL_RATIO));
    this.colsRows = getPageColsRows();
    this.xOffset = (-MathUtils.max(this.pdfView.getCurrentXOffset(), 0.0F));
    this.yOffset = (-MathUtils.max(this.pdfView.getCurrentYOffset(), 0.0F));
    this.rowHeight = (this.scaledHeight / ((Integer)this.colsRows.second).intValue());
    this.colWidth = (this.scaledWidth / ((Integer)this.colsRows.first).intValue());
    this.pageRelativePartWidth = (1.0F / ((Integer)this.colsRows.first).intValue());
    this.pageRelativePartHeight = (1.0F / ((Integer)this.colsRows.second).intValue());
    this.partRenderWidth = (Constants.PART_SIZE / this.pageRelativePartWidth);
    this.partRenderHeight = (Constants.PART_SIZE / this.pageRelativePartHeight);
    this.cacheOrder = 1;
    this.scaledSpacingPx = this.pdfView.toCurrentScale(this.pdfView.getSpacingPx());
    this.scaledSpacingPx -= this.scaledSpacingPx / this.pdfView.getPageCount();
    int i = loadVisible();
    boolean bool = this.pdfView.getScrollDir().equals(PDFView.ScrollDir.END);
    int j = 0;
    if (bool) {
      while ((j < Constants.PRELOAD_COUNT) && (i < Constants.Cache.CACHE_SIZE))
      {
        i += loadRelative(j, i, true);
        j += 1;
      }
    }
    int k = 0;
    j = i;
    i = k;
    while ((i > -Constants.PRELOAD_COUNT) && (j < Constants.Cache.CACHE_SIZE))
    {
      j += loadRelative(i, j, false);
      i -= 1;
    }
  }
  
  public int loadVisible()
  {
    int k;
    int j;
    if (this.pdfView.isSwipeVertical())
    {
      localHolder2 = getPageAndCoordsByOffset(this.pdfView.getCurrentYOffset(), false);
      localHolder1 = getPageAndCoordsByOffset(this.pdfView.getCurrentYOffset() - this.pdfView.getHeight() + 1.0F, true);
      if (localHolder2.page == localHolder1.page)
      {
        k = localHolder1.row - localHolder2.row + 1;
      }
      else
      {
        j = ((Integer)this.colsRows.second).intValue() - localHolder2.row + 0;
        i = localHolder2.page + 1;
        while (i < localHolder1.page)
        {
          j += ((Integer)this.colsRows.second).intValue();
          i += 1;
        }
        k = localHolder1.row + 1 + j;
      }
      m = 0;
      i = 0;
      for (;;)
      {
        localHolder1 = localHolder2;
        j = i;
        if (m >= k) {
          break;
        }
        localHolder1 = localHolder2;
        j = i;
        if (i >= Constants.Cache.CACHE_SIZE) {
          break;
        }
        i += loadRelative(m, Constants.Cache.CACHE_SIZE - i, false);
        m += 1;
      }
    }
    Holder localHolder2 = getPageAndCoordsByOffset(this.pdfView.getCurrentXOffset(), false);
    Holder localHolder1 = getPageAndCoordsByOffset(this.pdfView.getCurrentXOffset() - this.pdfView.getWidth() + 1.0F, true);
    if (localHolder2.page == localHolder1.page)
    {
      k = localHolder1.col - localHolder2.col + 1;
    }
    else
    {
      j = ((Integer)this.colsRows.first).intValue() - localHolder2.col + 0;
      i = localHolder2.page + 1;
      while (i < localHolder1.page)
      {
        j += ((Integer)this.colsRows.first).intValue();
        i += 1;
      }
      k = localHolder1.col + 1 + j;
    }
    int m = 0;
    int i = 0;
    for (;;)
    {
      localHolder1 = localHolder2;
      j = i;
      if (m >= k) {
        break;
      }
      localHolder1 = localHolder2;
      j = i;
      if (i >= Constants.Cache.CACHE_SIZE) {
        break;
      }
      i += loadRelative(m, Constants.Cache.CACHE_SIZE - i, false);
      m += 1;
    }
    i = documentPage(localHolder1.page - 1);
    if (i >= 0) {
      loadThumbnail(localHolder1.page - 1, i);
    }
    i = documentPage(localHolder1.page + 1);
    if (i >= 0) {
      loadThumbnail(localHolder1.page + 1, i);
    }
    return j;
  }
  
  private class Holder
  {
    int col;
    int page;
    int row;
    
    private Holder() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\github\barteksc\pdfviewer\PagesLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */