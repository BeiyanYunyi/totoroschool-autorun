package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.browse.MediaBrowser.SubscriptionCallback;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.List;

@RequiresApi(26)
class MediaBrowserCompatApi26
{
  static Object createSubscriptionCallback(SubscriptionCallback paramSubscriptionCallback)
  {
    return new SubscriptionCallbackProxy(paramSubscriptionCallback);
  }
  
  public static void subscribe(Object paramObject1, String paramString, Bundle paramBundle, Object paramObject2)
  {
    ((MediaBrowser)paramObject1).subscribe(paramString, paramBundle, (MediaBrowser.SubscriptionCallback)paramObject2);
  }
  
  public static void unsubscribe(Object paramObject1, String paramString, Object paramObject2)
  {
    ((MediaBrowser)paramObject1).unsubscribe(paramString, (MediaBrowser.SubscriptionCallback)paramObject2);
  }
  
  static abstract interface SubscriptionCallback
    extends MediaBrowserCompatApi21.SubscriptionCallback
  {
    public abstract void onChildrenLoaded(@NonNull String paramString, List<?> paramList, @NonNull Bundle paramBundle);
    
    public abstract void onError(@NonNull String paramString, @NonNull Bundle paramBundle);
  }
  
  static class SubscriptionCallbackProxy<T extends MediaBrowserCompatApi26.SubscriptionCallback>
    extends MediaBrowserCompatApi21.SubscriptionCallbackProxy<T>
  {
    SubscriptionCallbackProxy(T paramT)
    {
      super();
    }
    
    public void onChildrenLoaded(@NonNull String paramString, List<MediaBrowser.MediaItem> paramList, @NonNull Bundle paramBundle)
    {
      MediaSessionCompat.ensureClassLoader(paramBundle);
      ((MediaBrowserCompatApi26.SubscriptionCallback)this.mSubscriptionCallback).onChildrenLoaded(paramString, paramList, paramBundle);
    }
    
    public void onError(@NonNull String paramString, @NonNull Bundle paramBundle)
    {
      MediaSessionCompat.ensureClassLoader(paramBundle);
      ((MediaBrowserCompatApi26.SubscriptionCallback)this.mSubscriptionCallback).onError(paramString, paramBundle);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\media\MediaBrowserCompatApi26.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */