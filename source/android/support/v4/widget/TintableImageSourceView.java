package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract interface TintableImageSourceView
{
  @Nullable
  public abstract ColorStateList getSupportImageTintList();
  
  @Nullable
  public abstract PorterDuff.Mode getSupportImageTintMode();
  
  public abstract void setSupportImageTintList(@Nullable ColorStateList paramColorStateList);
  
  public abstract void setSupportImageTintMode(@Nullable PorterDuff.Mode paramMode);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\widget\TintableImageSourceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */