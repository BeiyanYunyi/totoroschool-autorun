package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.ConnectionCallback;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.browse.MediaBrowser.SubscriptionCallback;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import java.util.List;

@RequiresApi(21)
class MediaBrowserCompatApi21
{
  static final String NULL_MEDIA_ITEM_ID = "android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM";
  
  public static void connect(Object paramObject)
  {
    ((MediaBrowser)paramObject).connect();
  }
  
  public static Object createBrowser(Context paramContext, ComponentName paramComponentName, Object paramObject, Bundle paramBundle)
  {
    return new MediaBrowser(paramContext, paramComponentName, (MediaBrowser.ConnectionCallback)paramObject, paramBundle);
  }
  
  public static Object createConnectionCallback(ConnectionCallback paramConnectionCallback)
  {
    return new ConnectionCallbackProxy(paramConnectionCallback);
  }
  
  public static Object createSubscriptionCallback(SubscriptionCallback paramSubscriptionCallback)
  {
    return new SubscriptionCallbackProxy(paramSubscriptionCallback);
  }
  
  public static void disconnect(Object paramObject)
  {
    ((MediaBrowser)paramObject).disconnect();
  }
  
  public static Bundle getExtras(Object paramObject)
  {
    return ((MediaBrowser)paramObject).getExtras();
  }
  
  public static String getRoot(Object paramObject)
  {
    return ((MediaBrowser)paramObject).getRoot();
  }
  
  public static ComponentName getServiceComponent(Object paramObject)
  {
    return ((MediaBrowser)paramObject).getServiceComponent();
  }
  
  public static Object getSessionToken(Object paramObject)
  {
    return ((MediaBrowser)paramObject).getSessionToken();
  }
  
  public static boolean isConnected(Object paramObject)
  {
    return ((MediaBrowser)paramObject).isConnected();
  }
  
  public static void subscribe(Object paramObject1, String paramString, Object paramObject2)
  {
    ((MediaBrowser)paramObject1).subscribe(paramString, (MediaBrowser.SubscriptionCallback)paramObject2);
  }
  
  public static void unsubscribe(Object paramObject, String paramString)
  {
    ((MediaBrowser)paramObject).unsubscribe(paramString);
  }
  
  static abstract interface ConnectionCallback
  {
    public abstract void onConnected();
    
    public abstract void onConnectionFailed();
    
    public abstract void onConnectionSuspended();
  }
  
  static class ConnectionCallbackProxy<T extends MediaBrowserCompatApi21.ConnectionCallback>
    extends MediaBrowser.ConnectionCallback
  {
    protected final T mConnectionCallback;
    
    public ConnectionCallbackProxy(T paramT)
    {
      this.mConnectionCallback = paramT;
    }
    
    public void onConnected()
    {
      this.mConnectionCallback.onConnected();
    }
    
    public void onConnectionFailed()
    {
      this.mConnectionCallback.onConnectionFailed();
    }
    
    public void onConnectionSuspended()
    {
      this.mConnectionCallback.onConnectionSuspended();
    }
  }
  
  static class MediaItem
  {
    public static Object getDescription(Object paramObject)
    {
      return ((MediaBrowser.MediaItem)paramObject).getDescription();
    }
    
    public static int getFlags(Object paramObject)
    {
      return ((MediaBrowser.MediaItem)paramObject).getFlags();
    }
  }
  
  static abstract interface SubscriptionCallback
  {
    public abstract void onChildrenLoaded(@NonNull String paramString, List<?> paramList);
    
    public abstract void onError(@NonNull String paramString);
  }
  
  static class SubscriptionCallbackProxy<T extends MediaBrowserCompatApi21.SubscriptionCallback>
    extends MediaBrowser.SubscriptionCallback
  {
    protected final T mSubscriptionCallback;
    
    public SubscriptionCallbackProxy(T paramT)
    {
      this.mSubscriptionCallback = paramT;
    }
    
    public void onChildrenLoaded(@NonNull String paramString, List<MediaBrowser.MediaItem> paramList)
    {
      this.mSubscriptionCallback.onChildrenLoaded(paramString, paramList);
    }
    
    public void onError(@NonNull String paramString)
    {
      this.mSubscriptionCallback.onError(paramString);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\media\MediaBrowserCompatApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */