package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.ItemCallback;
import android.media.browse.MediaBrowser.MediaItem;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

@RequiresApi(23)
class MediaBrowserCompatApi23
{
  public static Object createItemCallback(ItemCallback paramItemCallback)
  {
    return new ItemCallbackProxy(paramItemCallback);
  }
  
  public static void getItem(Object paramObject1, String paramString, Object paramObject2)
  {
    ((MediaBrowser)paramObject1).getItem(paramString, (MediaBrowser.ItemCallback)paramObject2);
  }
  
  static abstract interface ItemCallback
  {
    public abstract void onError(@NonNull String paramString);
    
    public abstract void onItemLoaded(Parcel paramParcel);
  }
  
  static class ItemCallbackProxy<T extends MediaBrowserCompatApi23.ItemCallback>
    extends MediaBrowser.ItemCallback
  {
    protected final T mItemCallback;
    
    public ItemCallbackProxy(T paramT)
    {
      this.mItemCallback = paramT;
    }
    
    public void onError(@NonNull String paramString)
    {
      this.mItemCallback.onError(paramString);
    }
    
    public void onItemLoaded(MediaBrowser.MediaItem paramMediaItem)
    {
      if (paramMediaItem == null)
      {
        this.mItemCallback.onItemLoaded(null);
        return;
      }
      Parcel localParcel = Parcel.obtain();
      paramMediaItem.writeToParcel(localParcel, 0);
      this.mItemCallback.onItemLoaded(localParcel);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\media\MediaBrowserCompatApi23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */