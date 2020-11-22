package com.totoro.school.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.totoro.school.R.styleable;

public class RingLoadButton
  extends View
{
  private float a;
  private int b;
  private int c;
  private int d;
  private Paint e = new Paint();
  private Paint f = new Paint();
  private Paint g = new Paint();
  private float h;
  private float i;
  private float j;
  private float k;
  private GestureDetectorCompat l;
  private boolean m;
  private float n = -90.0F;
  private float o = 0.0F;
  private float p = 360.0F;
  private float q;
  private int r;
  private Context s;
  private AnimatorSet t;
  private a u;
  
  public RingLoadButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RingLoadButton(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RingLoadButton(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.s = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RingLoadButton);
    this.b = paramAttributeSet.getColor(2, Color.parseColor("#E0E0E0"));
    this.c = paramAttributeSet.getColor(0, -1);
    this.d = paramAttributeSet.getColor(3, -16711936);
    this.r = paramAttributeSet.getInteger(1, 10);
    this.l = new GestureDetectorCompat(paramContext, new GestureDetector.SimpleOnGestureListener()
    {
      public void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        RingLoadButton.a(RingLoadButton.this, true);
        RingLoadButton.this.postInvalidate();
        if (RingLoadButton.a(RingLoadButton.this) != null) {
          RingLoadButton.a(RingLoadButton.this).b(RingLoadButton.this);
        }
      }
      
      public boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        RingLoadButton.a(RingLoadButton.this, false);
        if (RingLoadButton.a(RingLoadButton.this) != null) {
          RingLoadButton.a(RingLoadButton.this).a(RingLoadButton.this);
        }
        return super.onSingleTapConfirmed(paramAnonymousMotionEvent);
      }
    });
    this.l.setIsLongpressEnabled(true);
  }
  
  private void b()
  {
    this.h = getWidth();
    this.i = getHeight();
    this.a = (this.h * 0.1F);
    this.j = (Math.min(this.h, this.i) / 2.0F);
    this.k = (this.j - this.a);
  }
  
  public void a()
  {
    ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { this.o, this.p });
    localValueAnimator1.setInterpolator(new LinearInterpolator());
    localValueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        RingLoadButton.a(RingLoadButton.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        RingLoadButton.this.invalidate();
      }
    });
    ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { this.r, 0 });
    localValueAnimator2.setInterpolator(new LinearInterpolator());
    localValueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
      }
    });
    if (this.t != null) {
      this.t.removeAllListeners();
    }
    this.t = new AnimatorSet();
    this.t.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
    this.t.setDuration(this.r * 200);
    this.t.setInterpolator(new LinearInterpolator());
    this.t.start();
    this.t.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        super.onAnimationEnd(paramAnonymousAnimator);
        RingLoadButton.this.clearAnimation();
        RingLoadButton.a(RingLoadButton.this, false);
        RingLoadButton.this.postInvalidate();
        if (RingLoadButton.a(RingLoadButton.this) != null) {
          RingLoadButton.a(RingLoadButton.this).a();
        }
      }
    });
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    b();
    this.e.setAntiAlias(true);
    this.e.setColor(this.b);
    if (this.m)
    {
      setMinimumWidth((int)(this.h * 1.0F));
      paramCanvas.scale(1.0F, 1.0F, this.h / 2.0F, this.h / 2.0F);
    }
    else
    {
      setMinimumWidth((int)this.h);
    }
    if (this.m)
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(this.s.getResources(), 2131558465);
      paramCanvas.drawBitmap(localBitmap, (this.h - localBitmap.getWidth()) / 2.0F, (this.i - localBitmap.getHeight()) / 2.0F, this.g);
      this.f.setAntiAlias(true);
      this.f.setColor(this.d);
      this.f.setStyle(Paint.Style.STROKE);
      this.f.setStrokeWidth(this.a / 2.0F);
      paramCanvas.drawArc(new RectF(this.a + 0.0F, this.a + 0.0F, this.h - this.a, this.i - this.a), this.n, this.q, false, this.f);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    Bitmap localBitmap = BitmapFactory.decodeResource(this.s.getResources(), 2131558465);
    paramInt1 = localBitmap.getWidth() * 1;
    paramInt2 = localBitmap.getHeight() * 1;
    if (paramInt1 > paramInt2)
    {
      setMeasuredDimension(paramInt2, paramInt2);
      return;
    }
    setMeasuredDimension(paramInt1, paramInt1);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.l.onTouchEvent(paramMotionEvent);
    int i1 = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i1 != 3)
    {
      switch (i1)
      {
      default: 
        break;
      case 0: 
        this.m = false;
        break;
      }
    }
    else if (this.m)
    {
      this.m = false;
      postInvalidate();
      if (this.t != null) {
        this.t.removeAllListeners();
      }
      if (this.u != null) {
        this.u.c(this);
      }
    }
    return true;
  }
  
  public void setOnProgressTouchListener(a parama)
  {
    this.u = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(RingLoadButton paramRingLoadButton);
    
    public abstract void b(RingLoadButton paramRingLoadButton);
    
    public abstract void c(RingLoadButton paramRingLoadButton);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\RingLoadButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */