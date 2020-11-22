package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.graphics.BitmapCompat;
import android.support.v4.view.GravityCompat;
import android.util.Log;
import java.io.InputStream;

public final class RoundedBitmapDrawableFactory
{
  private static final String TAG = "RoundedBitmapDrawableFa";
  
  @NonNull
  public static RoundedBitmapDrawable create(@NonNull Resources paramResources, @Nullable Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new RoundedBitmapDrawable21(paramResources, paramBitmap);
    }
    return new DefaultRoundedBitmapDrawable(paramResources, paramBitmap);
  }
  
  @NonNull
  public static RoundedBitmapDrawable create(@NonNull Resources paramResources, @NonNull InputStream paramInputStream)
  {
    paramResources = create(paramResources, BitmapFactory.decodeStream(paramInputStream));
    if (paramResources.getBitmap() == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RoundedBitmapDrawable cannot decode ");
      localStringBuilder.append(paramInputStream);
      Log.w("RoundedBitmapDrawableFa", localStringBuilder.toString());
    }
    return paramResources;
  }
  
  @NonNull
  public static RoundedBitmapDrawable create(@NonNull Resources paramResources, @NonNull String paramString)
  {
    paramResources = create(paramResources, BitmapFactory.decodeFile(paramString));
    if (paramResources.getBitmap() == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RoundedBitmapDrawable cannot decode ");
      localStringBuilder.append(paramString);
      Log.w("RoundedBitmapDrawableFa", localStringBuilder.toString());
    }
    return paramResources;
  }
  
  private static class DefaultRoundedBitmapDrawable
    extends RoundedBitmapDrawable
  {
    DefaultRoundedBitmapDrawable(Resources paramResources, Bitmap paramBitmap)
    {
      super(paramBitmap);
    }
    
    void gravityCompatApply(int paramInt1, int paramInt2, int paramInt3, Rect paramRect1, Rect paramRect2)
    {
      GravityCompat.apply(paramInt1, paramInt2, paramInt3, paramRect1, paramRect2, 0);
    }
    
    public boolean hasMipMap()
    {
      return (this.mBitmap != null) && (BitmapCompat.hasMipMap(this.mBitmap));
    }
    
    public void setMipMap(boolean paramBoolean)
    {
      if (this.mBitmap != null)
      {
        BitmapCompat.setHasMipMap(this.mBitmap, paramBoolean);
        invalidateSelf();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\graphics\drawable\RoundedBitmapDrawableFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */