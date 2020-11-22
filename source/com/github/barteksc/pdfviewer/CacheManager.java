package com.github.barteksc.pdfviewer;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import com.github.barteksc.pdfviewer.model.PagePart;
import com.github.barteksc.pdfviewer.util.Constants.Cache;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

class CacheManager
{
  private final PriorityQueue<PagePart> activeCache = new PriorityQueue(Constants.Cache.CACHE_SIZE, this.comparator);
  private final PagePartComparator comparator = new PagePartComparator();
  private final Object passiveActiveLock = new Object();
  private final PriorityQueue<PagePart> passiveCache = new PriorityQueue(Constants.Cache.CACHE_SIZE, this.comparator);
  private final List<PagePart> thumbnails = new ArrayList();
  
  @Nullable
  private static PagePart find(PriorityQueue<PagePart> paramPriorityQueue, PagePart paramPagePart)
  {
    paramPriorityQueue = paramPriorityQueue.iterator();
    while (paramPriorityQueue.hasNext())
    {
      PagePart localPagePart = (PagePart)paramPriorityQueue.next();
      if (localPagePart.equals(paramPagePart)) {
        return localPagePart;
      }
    }
    return null;
  }
  
  private void makeAFreeSpace()
  {
    synchronized (this.passiveActiveLock)
    {
      while ((this.activeCache.size() + this.passiveCache.size() >= Constants.Cache.CACHE_SIZE) && (!this.passiveCache.isEmpty())) {
        ((PagePart)this.passiveCache.poll()).getRenderedBitmap().recycle();
      }
      while ((this.activeCache.size() + this.passiveCache.size() >= Constants.Cache.CACHE_SIZE) && (!this.activeCache.isEmpty())) {
        ((PagePart)this.activeCache.poll()).getRenderedBitmap().recycle();
      }
      return;
    }
  }
  
  public void cachePart(PagePart paramPagePart)
  {
    synchronized (this.passiveActiveLock)
    {
      makeAFreeSpace();
      this.activeCache.offer(paramPagePart);
      return;
    }
  }
  
  public void cacheThumbnail(PagePart paramPagePart)
  {
    synchronized (this.thumbnails)
    {
      if (this.thumbnails.size() >= Constants.Cache.THUMBNAILS_CACHE_SIZE) {
        ((PagePart)this.thumbnails.remove(0)).getRenderedBitmap().recycle();
      }
      this.thumbnails.add(paramPagePart);
      return;
    }
  }
  
  public boolean containsThumbnail(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, RectF arg5)
  {
    PagePart localPagePart = new PagePart(paramInt1, paramInt2, null, paramFloat1, paramFloat2, ???, true, 0);
    synchronized (this.thumbnails)
    {
      Iterator localIterator = this.thumbnails.iterator();
      while (localIterator.hasNext()) {
        if (((PagePart)localIterator.next()).equals(localPagePart)) {
          return true;
        }
      }
      return false;
    }
  }
  
  public List<PagePart> getPageParts()
  {
    synchronized (this.passiveActiveLock)
    {
      ArrayList localArrayList = new ArrayList(this.passiveCache);
      localArrayList.addAll(this.activeCache);
      return localArrayList;
    }
  }
  
  public List<PagePart> getThumbnails()
  {
    synchronized (this.thumbnails)
    {
      List localList2 = this.thumbnails;
      return localList2;
    }
  }
  
  public void makeANewSet()
  {
    synchronized (this.passiveActiveLock)
    {
      this.passiveCache.addAll(this.activeCache);
      this.activeCache.clear();
      return;
    }
  }
  
  public void recycle()
  {
    synchronized (this.passiveActiveLock)
    {
      Iterator localIterator = this.passiveCache.iterator();
      while (localIterator.hasNext()) {
        ((PagePart)localIterator.next()).getRenderedBitmap().recycle();
      }
      this.passiveCache.clear();
      localIterator = this.activeCache.iterator();
      while (localIterator.hasNext()) {
        ((PagePart)localIterator.next()).getRenderedBitmap().recycle();
      }
      this.activeCache.clear();
      synchronized (this.thumbnails)
      {
        localIterator = this.thumbnails.iterator();
        while (localIterator.hasNext()) {
          ((PagePart)localIterator.next()).getRenderedBitmap().recycle();
        }
        this.thumbnails.clear();
        return;
      }
    }
  }
  
  public boolean upPartIfContained(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, RectF arg5, int paramInt3)
  {
    PagePart localPagePart1 = new PagePart(paramInt1, paramInt2, null, paramFloat1, paramFloat2, ???, false, 0);
    for (;;)
    {
      synchronized (this.passiveActiveLock)
      {
        PagePart localPagePart2 = find(this.passiveCache, localPagePart1);
        bool = true;
        if (localPagePart2 != null)
        {
          this.passiveCache.remove(localPagePart2);
          localPagePart2.setCacheOrder(paramInt3);
          this.activeCache.offer(localPagePart2);
          return true;
        }
        if (find(this.activeCache, localPagePart1) != null) {
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  class PagePartComparator
    implements Comparator<PagePart>
  {
    PagePartComparator() {}
    
    public int compare(PagePart paramPagePart1, PagePart paramPagePart2)
    {
      if (paramPagePart1.getCacheOrder() == paramPagePart2.getCacheOrder()) {
        return 0;
      }
      if (paramPagePart1.getCacheOrder() > paramPagePart2.getCacheOrder()) {
        return 1;
      }
      return -1;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\github\barteksc\pdfviewer\CacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */