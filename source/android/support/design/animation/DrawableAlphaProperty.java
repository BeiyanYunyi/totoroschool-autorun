package android.support.design.animation;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Property;
import java.util.WeakHashMap;

public class DrawableAlphaProperty
  extends Property<Drawable, Integer>
{
  public static final Property<Drawable, Integer> DRAWABLE_ALPHA_COMPAT = new DrawableAlphaProperty();
  private final WeakHashMap<Drawable, Integer> alphaCache = new WeakHashMap();
  
  private DrawableAlphaProperty()
  {
    super(Integer.class, "drawableAlphaCompat");
  }
  
  public Integer get(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return Integer.valueOf(paramDrawable.getAlpha());
    }
    if (this.alphaCache.containsKey(paramDrawable)) {
      return (Integer)this.alphaCache.get(paramDrawable);
    }
    return Integer.valueOf(255);
  }
  
  public void set(Drawable paramDrawable, Integer paramInteger)
  {
    if (Build.VERSION.SDK_INT < 19) {
      this.alphaCache.put(paramDrawable, paramInteger);
    }
    paramDrawable.setAlpha(paramInteger.intValue());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\animation\DrawableAlphaProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */