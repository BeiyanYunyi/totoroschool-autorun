package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaController;
import android.media.session.MediaController.Callback;
import android.media.session.MediaController.PlaybackInfo;
import android.media.session.MediaController.TransportControls;
import android.media.session.MediaSession.QueueItem;
import android.media.session.MediaSession.Token;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.annotation.RequiresApi;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiresApi(21)
class MediaControllerCompatApi21
{
  public static void adjustVolume(Object paramObject, int paramInt1, int paramInt2)
  {
    ((MediaController)paramObject).adjustVolume(paramInt1, paramInt2);
  }
  
  public static Object createCallback(Callback paramCallback)
  {
    return new CallbackProxy(paramCallback);
  }
  
  public static boolean dispatchMediaButtonEvent(Object paramObject, KeyEvent paramKeyEvent)
  {
    return ((MediaController)paramObject).dispatchMediaButtonEvent(paramKeyEvent);
  }
  
  public static Object fromToken(Context paramContext, Object paramObject)
  {
    return new MediaController(paramContext, (MediaSession.Token)paramObject);
  }
  
  public static Bundle getExtras(Object paramObject)
  {
    return ((MediaController)paramObject).getExtras();
  }
  
  public static long getFlags(Object paramObject)
  {
    return ((MediaController)paramObject).getFlags();
  }
  
  public static Object getMediaController(Activity paramActivity)
  {
    return paramActivity.getMediaController();
  }
  
  public static Object getMetadata(Object paramObject)
  {
    return ((MediaController)paramObject).getMetadata();
  }
  
  public static String getPackageName(Object paramObject)
  {
    return ((MediaController)paramObject).getPackageName();
  }
  
  public static Object getPlaybackInfo(Object paramObject)
  {
    return ((MediaController)paramObject).getPlaybackInfo();
  }
  
  public static Object getPlaybackState(Object paramObject)
  {
    return ((MediaController)paramObject).getPlaybackState();
  }
  
  public static List<Object> getQueue(Object paramObject)
  {
    paramObject = ((MediaController)paramObject).getQueue();
    if (paramObject == null) {
      return null;
    }
    return new ArrayList((Collection)paramObject);
  }
  
  public static CharSequence getQueueTitle(Object paramObject)
  {
    return ((MediaController)paramObject).getQueueTitle();
  }
  
  public static int getRatingType(Object paramObject)
  {
    return ((MediaController)paramObject).getRatingType();
  }
  
  public static PendingIntent getSessionActivity(Object paramObject)
  {
    return ((MediaController)paramObject).getSessionActivity();
  }
  
  public static Object getSessionToken(Object paramObject)
  {
    return ((MediaController)paramObject).getSessionToken();
  }
  
  public static Object getTransportControls(Object paramObject)
  {
    return ((MediaController)paramObject).getTransportControls();
  }
  
  public static void registerCallback(Object paramObject1, Object paramObject2, Handler paramHandler)
  {
    ((MediaController)paramObject1).registerCallback((MediaController.Callback)paramObject2, paramHandler);
  }
  
  public static void sendCommand(Object paramObject, String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    ((MediaController)paramObject).sendCommand(paramString, paramBundle, paramResultReceiver);
  }
  
  public static void setMediaController(Activity paramActivity, Object paramObject)
  {
    paramActivity.setMediaController((MediaController)paramObject);
  }
  
  public static void setVolumeTo(Object paramObject, int paramInt1, int paramInt2)
  {
    ((MediaController)paramObject).setVolumeTo(paramInt1, paramInt2);
  }
  
  public static void unregisterCallback(Object paramObject1, Object paramObject2)
  {
    ((MediaController)paramObject1).unregisterCallback((MediaController.Callback)paramObject2);
  }
  
  public static abstract interface Callback
  {
    public abstract void onAudioInfoChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
    
    public abstract void onExtrasChanged(Bundle paramBundle);
    
    public abstract void onMetadataChanged(Object paramObject);
    
    public abstract void onPlaybackStateChanged(Object paramObject);
    
    public abstract void onQueueChanged(List<?> paramList);
    
    public abstract void onQueueTitleChanged(CharSequence paramCharSequence);
    
    public abstract void onSessionDestroyed();
    
    public abstract void onSessionEvent(String paramString, Bundle paramBundle);
  }
  
  static class CallbackProxy<T extends MediaControllerCompatApi21.Callback>
    extends MediaController.Callback
  {
    protected final T mCallback;
    
    public CallbackProxy(T paramT)
    {
      this.mCallback = paramT;
    }
    
    public void onAudioInfoChanged(MediaController.PlaybackInfo paramPlaybackInfo)
    {
      this.mCallback.onAudioInfoChanged(paramPlaybackInfo.getPlaybackType(), MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(paramPlaybackInfo), paramPlaybackInfo.getVolumeControl(), paramPlaybackInfo.getMaxVolume(), paramPlaybackInfo.getCurrentVolume());
    }
    
    public void onExtrasChanged(Bundle paramBundle)
    {
      MediaSessionCompat.ensureClassLoader(paramBundle);
      this.mCallback.onExtrasChanged(paramBundle);
    }
    
    public void onMetadataChanged(MediaMetadata paramMediaMetadata)
    {
      this.mCallback.onMetadataChanged(paramMediaMetadata);
    }
    
    public void onPlaybackStateChanged(PlaybackState paramPlaybackState)
    {
      this.mCallback.onPlaybackStateChanged(paramPlaybackState);
    }
    
    public void onQueueChanged(List<MediaSession.QueueItem> paramList)
    {
      this.mCallback.onQueueChanged(paramList);
    }
    
    public void onQueueTitleChanged(CharSequence paramCharSequence)
    {
      this.mCallback.onQueueTitleChanged(paramCharSequence);
    }
    
    public void onSessionDestroyed()
    {
      this.mCallback.onSessionDestroyed();
    }
    
    public void onSessionEvent(String paramString, Bundle paramBundle)
    {
      MediaSessionCompat.ensureClassLoader(paramBundle);
      this.mCallback.onSessionEvent(paramString, paramBundle);
    }
  }
  
  public static class PlaybackInfo
  {
    private static final int FLAG_SCO = 4;
    private static final int STREAM_BLUETOOTH_SCO = 6;
    private static final int STREAM_SYSTEM_ENFORCED = 7;
    
    public static AudioAttributes getAudioAttributes(Object paramObject)
    {
      return ((MediaController.PlaybackInfo)paramObject).getAudioAttributes();
    }
    
    public static int getCurrentVolume(Object paramObject)
    {
      return ((MediaController.PlaybackInfo)paramObject).getCurrentVolume();
    }
    
    public static int getLegacyAudioStream(Object paramObject)
    {
      return toLegacyStreamType(getAudioAttributes(paramObject));
    }
    
    public static int getMaxVolume(Object paramObject)
    {
      return ((MediaController.PlaybackInfo)paramObject).getMaxVolume();
    }
    
    public static int getPlaybackType(Object paramObject)
    {
      return ((MediaController.PlaybackInfo)paramObject).getPlaybackType();
    }
    
    public static int getVolumeControl(Object paramObject)
    {
      return ((MediaController.PlaybackInfo)paramObject).getVolumeControl();
    }
    
    private static int toLegacyStreamType(AudioAttributes paramAudioAttributes)
    {
      if ((paramAudioAttributes.getFlags() & 0x1) == 1) {
        return 7;
      }
      if ((paramAudioAttributes.getFlags() & 0x4) == 4) {
        return 6;
      }
      switch (paramAudioAttributes.getUsage())
      {
      default: 
        return 3;
      case 13: 
        return 1;
      case 6: 
        return 2;
      case 5: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
        return 5;
      case 4: 
        return 4;
      case 3: 
        return 8;
      case 2: 
        return 0;
      }
      return 3;
    }
  }
  
  public static class TransportControls
  {
    public static void fastForward(Object paramObject)
    {
      ((MediaController.TransportControls)paramObject).fastForward();
    }
    
    public static void pause(Object paramObject)
    {
      ((MediaController.TransportControls)paramObject).pause();
    }
    
    public static void play(Object paramObject)
    {
      ((MediaController.TransportControls)paramObject).play();
    }
    
    public static void playFromMediaId(Object paramObject, String paramString, Bundle paramBundle)
    {
      ((MediaController.TransportControls)paramObject).playFromMediaId(paramString, paramBundle);
    }
    
    public static void playFromSearch(Object paramObject, String paramString, Bundle paramBundle)
    {
      ((MediaController.TransportControls)paramObject).playFromSearch(paramString, paramBundle);
    }
    
    public static void rewind(Object paramObject)
    {
      ((MediaController.TransportControls)paramObject).rewind();
    }
    
    public static void seekTo(Object paramObject, long paramLong)
    {
      ((MediaController.TransportControls)paramObject).seekTo(paramLong);
    }
    
    public static void sendCustomAction(Object paramObject, String paramString, Bundle paramBundle)
    {
      ((MediaController.TransportControls)paramObject).sendCustomAction(paramString, paramBundle);
    }
    
    public static void setRating(Object paramObject1, Object paramObject2)
    {
      ((MediaController.TransportControls)paramObject1).setRating((Rating)paramObject2);
    }
    
    public static void skipToNext(Object paramObject)
    {
      ((MediaController.TransportControls)paramObject).skipToNext();
    }
    
    public static void skipToPrevious(Object paramObject)
    {
      ((MediaController.TransportControls)paramObject).skipToPrevious();
    }
    
    public static void skipToQueueItem(Object paramObject, long paramLong)
    {
      ((MediaController.TransportControls)paramObject).skipToQueueItem(paramLong);
    }
    
    public static void stop(Object paramObject)
    {
      ((MediaController.TransportControls)paramObject).stop();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\media\session\MediaControllerCompatApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */