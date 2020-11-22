package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;

public final class BitmapCompat
{
  public static int getAllocationByteCount(@NonNull Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramBitmap.getAllocationByteCount();
    }
    return paramBitmap.getByteCount();
  }
  
  public static boolean hasMipMap(@NonNull Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramBitmap.hasMipMap();
    }
    return false;
  }
  
  public static void setHasMipMap(@NonNull Bitmap paramBitmap, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      paramBitmap.setHasMipMap(paramBoolean);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\graphics\BitmapCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */