package android.support.v4.media;

import android.os.Bundle;
import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class MediaBrowserCompatUtils
{
  public static boolean areSameOptions(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1 == paramBundle2) {
      return true;
    }
    if (paramBundle1 == null) {
      return (paramBundle2.getInt("android.media.browse.extra.PAGE", -1) == -1) && (paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1);
    }
    if (paramBundle2 == null) {
      return (paramBundle1.getInt("android.media.browse.extra.PAGE", -1) == -1) && (paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1);
    }
    return (paramBundle1.getInt("android.media.browse.extra.PAGE", -1) == paramBundle2.getInt("android.media.browse.extra.PAGE", -1)) && (paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1) == paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1));
  }
  
  public static boolean hasDuplicatedItems(Bundle paramBundle1, Bundle paramBundle2)
  {
    int k;
    if (paramBundle1 == null) {
      k = -1;
    } else {
      k = paramBundle1.getInt("android.media.browse.extra.PAGE", -1);
    }
    int i;
    if (paramBundle2 == null) {
      i = -1;
    } else {
      i = paramBundle2.getInt("android.media.browse.extra.PAGE", -1);
    }
    int m;
    if (paramBundle1 == null) {
      m = -1;
    } else {
      m = paramBundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1);
    }
    int j;
    if (paramBundle2 == null) {
      j = -1;
    } else {
      j = paramBundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1);
    }
    int n = Integer.MAX_VALUE;
    if ((k != -1) && (m != -1))
    {
      k *= m;
      m = m + k - 1;
    }
    else
    {
      m = Integer.MAX_VALUE;
      k = 0;
    }
    if ((i != -1) && (j != -1))
    {
      i = j * i;
      j = j + i - 1;
    }
    else
    {
      i = 0;
      j = n;
    }
    return (m >= i) && (j >= k);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\media\MediaBrowserCompatUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */