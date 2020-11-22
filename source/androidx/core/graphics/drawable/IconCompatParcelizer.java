package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.support.annotation.RestrictTo;
import android.support.v4.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class IconCompatParcelizer
{
  public static IconCompat read(a parama)
  {
    IconCompat localIconCompat = new IconCompat();
    localIconCompat.mType = parama.b(localIconCompat.mType, 1);
    localIconCompat.mData = parama.b(localIconCompat.mData, 2);
    localIconCompat.mParcelable = parama.b(localIconCompat.mParcelable, 3);
    localIconCompat.mInt1 = parama.b(localIconCompat.mInt1, 4);
    localIconCompat.mInt2 = parama.b(localIconCompat.mInt2, 5);
    localIconCompat.mTintList = ((ColorStateList)parama.b(localIconCompat.mTintList, 6));
    localIconCompat.mTintModeStr = parama.b(localIconCompat.mTintModeStr, 7);
    localIconCompat.onPostParceling();
    return localIconCompat;
  }
  
  public static void write(IconCompat paramIconCompat, a parama)
  {
    parama.a(true, true);
    paramIconCompat.onPreParceling(parama.a());
    parama.a(paramIconCompat.mType, 1);
    parama.a(paramIconCompat.mData, 2);
    parama.a(paramIconCompat.mParcelable, 3);
    parama.a(paramIconCompat.mInt1, 4);
    parama.a(paramIconCompat.mInt2, 5);
    parama.a(paramIconCompat.mTintList, 6);
    parama.a(paramIconCompat.mTintModeStr, 7);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\androidx\core\graphics\drawable\IconCompatParcelizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */