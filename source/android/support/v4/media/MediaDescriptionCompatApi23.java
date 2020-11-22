package android.support.v4.media;

import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.support.annotation.RequiresApi;

@RequiresApi(23)
class MediaDescriptionCompatApi23
{
  public static Uri getMediaUri(Object paramObject)
  {
    return ((MediaDescription)paramObject).getMediaUri();
  }
  
  static class Builder
  {
    public static void setMediaUri(Object paramObject, Uri paramUri)
    {
      ((MediaDescription.Builder)paramObject).setMediaUri(paramUri);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\media\MediaDescriptionCompatApi23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */