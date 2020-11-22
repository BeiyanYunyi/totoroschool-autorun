package com.bumptech.glide.f.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import com.bumptech.glide.f.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class k<T extends View, Z>
  extends a<Z>
{
  private static boolean b = false;
  private static Integer c;
  protected final T a;
  private final a d;
  
  public k(T paramT)
  {
    if (paramT != null)
    {
      this.a = paramT;
      this.d = new a(paramT);
      return;
    }
    throw new NullPointerException("View must not be null!");
  }
  
  private void a(Object paramObject)
  {
    if (c == null)
    {
      b = true;
      this.a.setTag(paramObject);
      return;
    }
    this.a.setTag(c.intValue(), paramObject);
  }
  
  private Object g()
  {
    if (c == null) {
      return this.a.getTag();
    }
    return this.a.getTag(c.intValue());
  }
  
  public T a()
  {
    return this.a;
  }
  
  public void a(h paramh)
  {
    this.d.a(paramh);
  }
  
  public void a(b paramb)
  {
    a(paramb);
  }
  
  public b c()
  {
    Object localObject = g();
    if (localObject != null)
    {
      if ((localObject instanceof b)) {
        return (b)localObject;
      }
      throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Target for: ");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
  
  private static class a
  {
    private final View a;
    private final List<h> b = new ArrayList();
    private a c;
    private Point d;
    
    public a(View paramView)
    {
      this.a = paramView;
    }
    
    private int a(int paramInt, boolean paramBoolean)
    {
      if (paramInt == -2)
      {
        Point localPoint = d();
        if (paramBoolean) {
          return localPoint.y;
        }
        return localPoint.x;
      }
      return paramInt;
    }
    
    private void a()
    {
      if (this.b.isEmpty()) {
        return;
      }
      int i = c();
      int j = b();
      if (a(i))
      {
        if (!a(j)) {
          return;
        }
        a(i, j);
        ViewTreeObserver localViewTreeObserver = this.a.getViewTreeObserver();
        if (localViewTreeObserver.isAlive()) {
          localViewTreeObserver.removeOnPreDrawListener(this.c);
        }
        this.c = null;
        return;
      }
    }
    
    private void a(int paramInt1, int paramInt2)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).a(paramInt1, paramInt2);
      }
      this.b.clear();
    }
    
    private boolean a(int paramInt)
    {
      return (paramInt > 0) || (paramInt == -2);
    }
    
    private int b()
    {
      ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
      if (a(this.a.getHeight())) {
        return this.a.getHeight();
      }
      if (localLayoutParams != null) {
        return a(localLayoutParams.height, true);
      }
      return 0;
    }
    
    private int c()
    {
      ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
      if (a(this.a.getWidth())) {
        return this.a.getWidth();
      }
      if (localLayoutParams != null) {
        return a(localLayoutParams.width, false);
      }
      return 0;
    }
    
    @TargetApi(13)
    private Point d()
    {
      if (this.d != null) {
        return this.d;
      }
      Display localDisplay = ((WindowManager)this.a.getContext().getSystemService("window")).getDefaultDisplay();
      if (Build.VERSION.SDK_INT >= 13)
      {
        this.d = new Point();
        localDisplay.getSize(this.d);
      }
      else
      {
        this.d = new Point(localDisplay.getWidth(), localDisplay.getHeight());
      }
      return this.d;
    }
    
    public void a(h paramh)
    {
      int i = c();
      int j = b();
      if ((a(i)) && (a(j)))
      {
        paramh.a(i, j);
        return;
      }
      if (!this.b.contains(paramh)) {
        this.b.add(paramh);
      }
      if (this.c == null)
      {
        paramh = this.a.getViewTreeObserver();
        this.c = new a(this);
        paramh.addOnPreDrawListener(this.c);
      }
    }
    
    private static class a
      implements ViewTreeObserver.OnPreDrawListener
    {
      private final WeakReference<k.a> a;
      
      public a(k.a parama)
      {
        this.a = new WeakReference(parama);
      }
      
      public boolean onPreDraw()
      {
        if (Log.isLoggable("ViewTarget", 2))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("OnGlobalLayoutListener called listener=");
          ((StringBuilder)localObject).append(this);
          Log.v("ViewTarget", ((StringBuilder)localObject).toString());
        }
        Object localObject = (k.a)this.a.get();
        if (localObject != null) {
          k.a.a((k.a)localObject);
        }
        return true;
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\f\b\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */