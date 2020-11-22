package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract interface WrappedDrawable
{
  public abstract Drawable getWrappedDrawable();
  
  public abstract void setWrappedDrawable(Drawable paramDrawable);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\graphics\drawable\WrappedDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */