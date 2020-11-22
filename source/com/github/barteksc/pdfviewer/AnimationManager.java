package com.github.barteksc.pdfviewer;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import android.view.animation.DecelerateInterpolator;
import android.widget.OverScroller;
import com.github.barteksc.pdfviewer.scroll.ScrollHandle;

class AnimationManager
{
  private ValueAnimator animation;
  private boolean flinging = false;
  private PDFView pdfView;
  private OverScroller scroller;
  
  public AnimationManager(PDFView paramPDFView)
  {
    this.pdfView = paramPDFView;
    this.scroller = new OverScroller(paramPDFView.getContext());
  }
  
  private void hideHandle()
  {
    if (this.pdfView.getScrollHandle() != null) {
      this.pdfView.getScrollHandle().hideDelayed();
    }
  }
  
  void computeFling()
  {
    if (this.scroller.computeScrollOffset())
    {
      this.pdfView.moveTo(this.scroller.getCurrX(), this.scroller.getCurrY());
      this.pdfView.loadPageByOffset();
      return;
    }
    if (this.flinging)
    {
      this.flinging = false;
      this.pdfView.loadPages();
      hideHandle();
    }
  }
  
  public void startFlingAnimation(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    stopAll();
    this.flinging = true;
    this.scroller.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public void startXAnimation(float paramFloat1, float paramFloat2)
  {
    stopAll();
    this.animation = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    XAnimation localXAnimation = new XAnimation();
    this.animation.setInterpolator(new DecelerateInterpolator());
    this.animation.addUpdateListener(localXAnimation);
    this.animation.addListener(localXAnimation);
    this.animation.setDuration(400L);
    this.animation.start();
  }
  
  public void startYAnimation(float paramFloat1, float paramFloat2)
  {
    stopAll();
    this.animation = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    YAnimation localYAnimation = new YAnimation();
    this.animation.setInterpolator(new DecelerateInterpolator());
    this.animation.addUpdateListener(localYAnimation);
    this.animation.addListener(localYAnimation);
    this.animation.setDuration(400L);
    this.animation.start();
  }
  
  public void startZoomAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    stopAll();
    this.animation = ValueAnimator.ofFloat(new float[] { paramFloat3, paramFloat4 });
    this.animation.setInterpolator(new DecelerateInterpolator());
    ZoomAnimation localZoomAnimation = new ZoomAnimation(paramFloat1, paramFloat2);
    this.animation.addUpdateListener(localZoomAnimation);
    this.animation.addListener(localZoomAnimation);
    this.animation.setDuration(400L);
    this.animation.start();
  }
  
  public void stopAll()
  {
    if (this.animation != null)
    {
      this.animation.cancel();
      this.animation = null;
    }
    stopFling();
  }
  
  public void stopFling()
  {
    this.flinging = false;
    this.scroller.forceFinished(true);
  }
  
  class XAnimation
    extends AnimatorListenerAdapter
    implements ValueAnimator.AnimatorUpdateListener
  {
    XAnimation() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      AnimationManager.this.pdfView.loadPages();
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      AnimationManager.this.pdfView.loadPages();
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      AnimationManager.this.pdfView.moveTo(f, AnimationManager.this.pdfView.getCurrentYOffset());
      AnimationManager.this.pdfView.loadPageByOffset();
    }
  }
  
  class YAnimation
    extends AnimatorListenerAdapter
    implements ValueAnimator.AnimatorUpdateListener
  {
    YAnimation() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      AnimationManager.this.pdfView.loadPages();
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      AnimationManager.this.pdfView.loadPages();
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      AnimationManager.this.pdfView.moveTo(AnimationManager.this.pdfView.getCurrentXOffset(), f);
      AnimationManager.this.pdfView.loadPageByOffset();
    }
  }
  
  class ZoomAnimation
    implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
  {
    private final float centerX;
    private final float centerY;
    
    public ZoomAnimation(float paramFloat1, float paramFloat2)
    {
      this.centerX = paramFloat1;
      this.centerY = paramFloat2;
    }
    
    public void onAnimationCancel(Animator paramAnimator) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      AnimationManager.this.pdfView.loadPages();
      AnimationManager.this.hideHandle();
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      AnimationManager.this.pdfView.zoomCenteredTo(f, new PointF(this.centerX, this.centerY));
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\github\barteksc\pdfviewer\AnimationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */