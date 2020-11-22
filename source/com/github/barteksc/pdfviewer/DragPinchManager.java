package com.github.barteksc.pdfviewer;

import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;
import com.github.barteksc.pdfviewer.scroll.ScrollHandle;
import com.github.barteksc.pdfviewer.util.Constants.Pinch;

class DragPinchManager
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener
{
  private AnimationManager animationManager;
  private GestureDetector gestureDetector;
  private boolean isSwipeEnabled;
  private PDFView pdfView;
  private ScaleGestureDetector scaleGestureDetector;
  private boolean scaling = false;
  private boolean scrolling = false;
  private boolean swipeVertical;
  
  public DragPinchManager(PDFView paramPDFView, AnimationManager paramAnimationManager)
  {
    this.pdfView = paramPDFView;
    this.animationManager = paramAnimationManager;
    this.isSwipeEnabled = false;
    this.swipeVertical = paramPDFView.isSwipeVertical();
    this.gestureDetector = new GestureDetector(paramPDFView.getContext(), this);
    this.scaleGestureDetector = new ScaleGestureDetector(paramPDFView.getContext(), this);
    paramPDFView.setOnTouchListener(this);
  }
  
  private void hideHandle()
  {
    if ((this.pdfView.getScrollHandle() != null) && (this.pdfView.getScrollHandle().shown())) {
      this.pdfView.getScrollHandle().hideDelayed();
    }
  }
  
  private boolean isPageChange(float paramFloat)
  {
    float f = Math.abs(paramFloat);
    PDFView localPDFView = this.pdfView;
    if (this.swipeVertical) {
      paramFloat = this.pdfView.getOptimalPageHeight();
    } else {
      paramFloat = this.pdfView.getOptimalPageWidth();
    }
    return f > Math.abs(localPDFView.toCurrentScale(paramFloat) / 2.0F);
  }
  
  public void enableDoubletap(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.gestureDetector.setOnDoubleTapListener(this);
      return;
    }
    this.gestureDetector.setOnDoubleTapListener(null);
  }
  
  public boolean isZooming()
  {
    return this.pdfView.isZooming();
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.pdfView.getZoom() < this.pdfView.getMidZoom()) {
      this.pdfView.zoomWithAnimation(paramMotionEvent.getX(), paramMotionEvent.getY(), this.pdfView.getMidZoom());
    } else if (this.pdfView.getZoom() < this.pdfView.getMaxZoom()) {
      this.pdfView.zoomWithAnimation(paramMotionEvent.getX(), paramMotionEvent.getY(), this.pdfView.getMaxZoom());
    } else {
      this.pdfView.resetZoomWithAnimation();
    }
    return true;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    this.animationManager.stopFling();
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    int i = (int)this.pdfView.getCurrentXOffset();
    int j = (int)this.pdfView.getCurrentYOffset();
    float f1;
    float f2;
    if (this.pdfView.isSwipeVertical())
    {
      f1 = -(this.pdfView.toCurrentScale(this.pdfView.getOptimalPageWidth()) - this.pdfView.getWidth());
      f2 = -(this.pdfView.calculateDocLength() - this.pdfView.getHeight());
    }
    else
    {
      f1 = -(this.pdfView.calculateDocLength() - this.pdfView.getWidth());
      f2 = -(this.pdfView.toCurrentScale(this.pdfView.getOptimalPageHeight()) - this.pdfView.getHeight());
    }
    this.animationManager.startFlingAnimation(i, j, (int)paramFloat1, (int)paramFloat2, (int)f1, 0, (int)f2, 0);
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f1 = paramScaleGestureDetector.getScaleFactor();
    float f2 = this.pdfView.getZoom() * f1;
    if (f2 < Constants.Pinch.MINIMUM_ZOOM) {
      f1 = Constants.Pinch.MINIMUM_ZOOM / this.pdfView.getZoom();
    } else if (f2 > Constants.Pinch.MAXIMUM_ZOOM) {
      f1 = Constants.Pinch.MAXIMUM_ZOOM / this.pdfView.getZoom();
    }
    this.pdfView.zoomCenteredRelativeTo(f1, new PointF(paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY()));
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.scaling = true;
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.pdfView.loadPages();
    hideHandle();
    this.scaling = false;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.scrolling = true;
    if ((isZooming()) || (this.isSwipeEnabled)) {
      this.pdfView.moveRelativeTo(-paramFloat1, -paramFloat2);
    }
    if ((!this.scaling) || (this.pdfView.doRenderDuringScale())) {
      this.pdfView.loadPageByOffset();
    }
    return true;
  }
  
  public void onScrollEnd(MotionEvent paramMotionEvent)
  {
    this.pdfView.loadPages();
    hideHandle();
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    OnTapListener localOnTapListener = this.pdfView.getOnTapListener();
    if ((localOnTapListener == null) || (!localOnTapListener.onTap(paramMotionEvent)))
    {
      paramMotionEvent = this.pdfView.getScrollHandle();
      if ((paramMotionEvent != null) && (!this.pdfView.documentFitsView())) {
        if (!paramMotionEvent.shown()) {
          paramMotionEvent.show();
        } else {
          paramMotionEvent.hide();
        }
      }
    }
    this.pdfView.performClick();
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = this.scaleGestureDetector.onTouchEvent(paramMotionEvent);
    if ((!this.gestureDetector.onTouchEvent(paramMotionEvent)) && (!bool)) {
      bool = false;
    } else {
      bool = true;
    }
    if ((paramMotionEvent.getAction() == 1) && (this.scrolling))
    {
      this.scrolling = false;
      onScrollEnd(paramMotionEvent);
    }
    return bool;
  }
  
  public void setSwipeEnabled(boolean paramBoolean)
  {
    this.isSwipeEnabled = paramBoolean;
  }
  
  public void setSwipeVertical(boolean paramBoolean)
  {
    this.swipeVertical = paramBoolean;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\github\barteksc\pdfviewer\DragPinchManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */