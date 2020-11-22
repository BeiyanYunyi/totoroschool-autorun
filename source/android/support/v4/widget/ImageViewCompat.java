package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

public class ImageViewCompat
{
  @Nullable
  public static ColorStateList getImageTintList(@NonNull ImageView paramImageView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramImageView.getImageTintList();
    }
    if ((paramImageView instanceof TintableImageSourceView)) {
      return ((TintableImageSourceView)paramImageView).getSupportImageTintList();
    }
    return null;
  }
  
  @Nullable
  public static PorterDuff.Mode getImageTintMode(@NonNull ImageView paramImageView)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramImageView.getImageTintMode();
    }
    if ((paramImageView instanceof TintableImageSourceView)) {
      return ((TintableImageSourceView)paramImageView).getSupportImageTintMode();
    }
    return null;
  }
  
  public static void setImageTintList(@NonNull ImageView paramImageView, @Nullable ColorStateList paramColorStateList)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramImageView.setImageTintList(paramColorStateList);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramColorStateList = paramImageView.getDrawable();
        int i;
        if ((paramImageView.getImageTintList() != null) && (paramImageView.getImageTintMode() != null)) {
          i = 1;
        } else {
          i = 0;
        }
        if ((paramColorStateList != null) && (i != 0))
        {
          if (paramColorStateList.isStateful()) {
            paramColorStateList.setState(paramImageView.getDrawableState());
          }
          paramImageView.setImageDrawable(paramColorStateList);
        }
      }
    }
    else if ((paramImageView instanceof TintableImageSourceView))
    {
      ((TintableImageSourceView)paramImageView).setSupportImageTintList(paramColorStateList);
    }
  }
  
  public static void setImageTintMode(@NonNull ImageView paramImageView, @Nullable PorterDuff.Mode paramMode)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramImageView.setImageTintMode(paramMode);
      if (Build.VERSION.SDK_INT == 21)
      {
        paramMode = paramImageView.getDrawable();
        int i;
        if ((paramImageView.getImageTintList() != null) && (paramImageView.getImageTintMode() != null)) {
          i = 1;
        } else {
          i = 0;
        }
        if ((paramMode != null) && (i != 0))
        {
          if (paramMode.isStateful()) {
            paramMode.setState(paramImageView.getDrawableState());
          }
          paramImageView.setImageDrawable(paramMode);
        }
      }
    }
    else if ((paramImageView instanceof TintableImageSourceView))
    {
      ((TintableImageSourceView)paramImageView).setSupportImageTintMode(paramMode);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\widget\ImageViewCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */