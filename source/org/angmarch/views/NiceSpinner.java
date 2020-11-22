package org.angmarch.views;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.util.List;

public class NiceSpinner
  extends AppCompatTextView
{
  private int a;
  private Drawable b;
  private PopupWindow c;
  private ListView d;
  private c e;
  private AdapterView.OnItemClickListener f;
  private AdapterView.OnItemSelectedListener g;
  private boolean h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  @DrawableRes
  private int o;
  private e p = new d();
  private e q = new d();
  
  public NiceSpinner(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public NiceSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public NiceSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private int a(Context paramContext)
  {
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(16842806, localTypedValue, true);
    paramContext = paramContext.obtainStyledAttributes(localTypedValue.data, new int[] { 16842806 });
    int i1 = paramContext.getColor(0, -16777216);
    paramContext.recycle();
    return i1;
  }
  
  private Drawable a(int paramInt)
  {
    Drawable localDrawable2 = ContextCompat.getDrawable(getContext(), this.o);
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 != null)
    {
      localDrawable2 = DrawableCompat.wrap(localDrawable2);
      localDrawable1 = localDrawable2;
      if (paramInt != Integer.MAX_VALUE)
      {
        localDrawable1 = localDrawable2;
        if (paramInt != 0)
        {
          DrawableCompat.setTint(localDrawable2, paramInt);
          localDrawable1 = localDrawable2;
        }
      }
    }
    return localDrawable1;
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    Resources localResources = getResources();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.NiceSpinner);
    int i1 = localResources.getDimensionPixelSize(R.dimen.one_and_a_half_grid_unit);
    setGravity(8388627);
    setPadding(localResources.getDimensionPixelSize(R.dimen.three_grid_unit), i1, i1, i1);
    setClickable(true);
    this.j = paramAttributeSet.getResourceId(R.styleable.NiceSpinner_backgroundSelector, R.drawable.selector);
    setBackgroundResource(this.j);
    this.i = paramAttributeSet.getColor(R.styleable.NiceSpinner_textTint, a(paramContext));
    setTextColor(this.i);
    this.d = new ListView(paramContext);
    this.d.setId(getId());
    this.d.setDivider(null);
    this.d.setItemsCanFocus(true);
    this.d.setVerticalScrollBarEnabled(false);
    this.d.setHorizontalScrollBarEnabled(false);
    this.d.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        int i = paramAnonymousInt;
        if (paramAnonymousInt >= NiceSpinner.a(NiceSpinner.this))
        {
          i = paramAnonymousInt;
          if (paramAnonymousInt < NiceSpinner.b(NiceSpinner.this).getCount()) {
            i = paramAnonymousInt + 1;
          }
        }
        NiceSpinner.a(NiceSpinner.this, i);
        if (NiceSpinner.c(NiceSpinner.this) != null) {
          NiceSpinner.c(NiceSpinner.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, i, paramAnonymousLong);
        }
        if (NiceSpinner.d(NiceSpinner.this) != null) {
          NiceSpinner.d(NiceSpinner.this).onItemSelected(paramAnonymousAdapterView, paramAnonymousView, i, paramAnonymousLong);
        }
        NiceSpinner.b(NiceSpinner.this).b(i);
        NiceSpinner.this.setTextInternal(NiceSpinner.b(NiceSpinner.this).a(i).toString());
        NiceSpinner.this.a();
      }
    });
    this.c = new PopupWindow(paramContext);
    this.c.setContentView(this.d);
    this.c.setOutsideTouchable(true);
    this.c.setFocusable(true);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.c.setElevation(16.0F);
      this.c.setBackgroundDrawable(ContextCompat.getDrawable(paramContext, R.drawable.spinner_drawable));
    }
    else
    {
      this.c.setBackgroundDrawable(ContextCompat.getDrawable(paramContext, R.drawable.drop_down_shadow));
    }
    this.c.setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        if (!NiceSpinner.e(NiceSpinner.this)) {
          NiceSpinner.a(NiceSpinner.this, false);
        }
      }
    });
    this.h = paramAttributeSet.getBoolean(R.styleable.NiceSpinner_hideArrow, false);
    this.k = paramAttributeSet.getColor(R.styleable.NiceSpinner_arrowTint, Integer.MAX_VALUE);
    this.o = paramAttributeSet.getResourceId(R.styleable.NiceSpinner_arrowDrawable, R.drawable.arrow);
    this.n = paramAttributeSet.getDimensionPixelSize(R.styleable.NiceSpinner_dropDownListPaddingBottom, 0);
    paramAttributeSet.recycle();
    c();
  }
  
  private void a(boolean paramBoolean)
  {
    int i2 = 10000;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 10000;
    }
    if (!paramBoolean) {
      i2 = 0;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this.b, "level", new int[] { i1, i2 });
    localObjectAnimator.setInterpolator(new LinearOutSlowInInterpolator());
    localObjectAnimator.start();
  }
  
  private void c()
  {
    this.l = getContext().getResources().getDisplayMetrics().heightPixels;
  }
  
  private void d()
  {
    int i1 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    int i2 = View.MeasureSpec.makeMeasureSpec(this.l - getParentVerticalOffset() - getMeasuredHeight(), Integer.MIN_VALUE);
    this.d.measure(i1, i2);
    this.c.setWidth(this.d.getMeasuredWidth());
    this.c.setHeight(this.d.getMeasuredHeight() - this.n);
  }
  
  private int getParentVerticalOffset()
  {
    if (this.m > 0) {
      return this.m;
    }
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    int i1 = arrayOfInt[1];
    this.m = i1;
    return i1;
  }
  
  private void setAdapterInternal(c paramc)
  {
    this.a = 0;
    this.d.setAdapter(paramc);
    setTextInternal(paramc.a(this.a).toString());
  }
  
  private void setArrowDrawableOrHide(Drawable paramDrawable)
  {
    if ((!this.h) && (paramDrawable != null))
    {
      setCompoundDrawablesWithIntrinsicBounds(null, null, paramDrawable, null);
      return;
    }
    setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
  }
  
  public void a()
  {
    if (!this.h) {
      a(false);
    }
    this.c.dismiss();
  }
  
  public <T> void a(List<T> paramList)
  {
    this.e = new a(getContext(), paramList, this.i, this.j, this.p);
    setAdapterInternal(this.e);
  }
  
  public void addOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.f = paramOnItemClickListener;
  }
  
  public void b()
  {
    if (!this.h) {
      a(true);
    }
    d();
    this.c.showAsDropDown(this);
  }
  
  public int getDropDownListPaddingBottom()
  {
    return this.n;
  }
  
  public int getSelectedIndex()
  {
    return this.a;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    Parcelable localParcelable = paramParcelable;
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.a = paramParcelable.getInt("selected_index");
      if (this.e != null)
      {
        setTextInternal(this.e.a(this.a).toString());
        this.e.b(this.a);
      }
      if ((paramParcelable.getBoolean("is_popup_showing")) && (this.c != null)) {
        post(new Runnable()
        {
          public void run()
          {
            NiceSpinner.this.b();
          }
        });
      }
      this.h = paramParcelable.getBoolean("is_arrow_hidden", false);
      this.o = paramParcelable.getInt("arrow_drawable_res_id");
      localParcelable = paramParcelable.getParcelable("instance_state");
    }
    super.onRestoreInstanceState(localParcelable);
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("instance_state", super.onSaveInstanceState());
    localBundle.putInt("selected_index", this.a);
    localBundle.putBoolean("is_arrow_hidden", this.h);
    localBundle.putInt("arrow_drawable_res_id", this.o);
    if (this.c != null) {
      localBundle.putBoolean("is_popup_showing", this.c.isShowing());
    }
    return localBundle;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((isEnabled()) && (paramMotionEvent.getAction() == 1)) {
      if (!this.c.isShowing()) {
        b();
      } else {
        a();
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    this.b = a(this.k);
    setArrowDrawableOrHide(this.b);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    this.e = new b(getContext(), paramListAdapter, this.i, this.j, this.p);
    setAdapterInternal(this.e);
  }
  
  public void setArrowDrawable(@ColorRes @DrawableRes int paramInt)
  {
    this.o = paramInt;
    this.b = a(R.drawable.arrow);
    setArrowDrawableOrHide(this.b);
  }
  
  public void setArrowDrawable(Drawable paramDrawable)
  {
    this.b = paramDrawable;
    setArrowDrawableOrHide(this.b);
  }
  
  public void setArrowTintColor(int paramInt)
  {
    if ((this.b != null) && (!this.h)) {
      DrawableCompat.setTint(this.b, paramInt);
    }
  }
  
  public void setDropDownListPaddingBottom(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.g = paramOnItemSelectedListener;
  }
  
  public void setSelectedIndex(int paramInt)
  {
    if (this.e != null)
    {
      if ((paramInt >= 0) && (paramInt <= this.e.getCount()))
      {
        this.e.b(paramInt);
        this.a = paramInt;
        setTextInternal(this.e.a(paramInt).toString());
        return;
      }
      throw new IllegalArgumentException("Position must be lower than adapter count!");
    }
  }
  
  public void setSelectedTextFormatter(e parame)
  {
    this.q = parame;
  }
  
  public void setSpinnerTextFormatter(e parame)
  {
    this.p = parame;
  }
  
  public void setTextInternal(String paramString)
  {
    if (this.q != null)
    {
      setText(this.q.a(paramString));
      return;
    }
    setText(paramString);
  }
  
  public void setTintColor(@ColorRes int paramInt)
  {
    if ((this.b != null) && (!this.h)) {
      DrawableCompat.setTint(this.b, ContextCompat.getColor(getContext(), paramInt));
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\angmarch\views\NiceSpinner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */