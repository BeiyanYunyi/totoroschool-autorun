package android.support.transition;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

abstract interface ViewOverlayImpl
{
  public abstract void add(@NonNull Drawable paramDrawable);
  
  public abstract void clear();
  
  public abstract void remove(@NonNull Drawable paramDrawable);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\transition\ViewOverlayImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */