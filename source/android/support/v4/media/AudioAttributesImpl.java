package android.support.v4.media;

import android.os.Bundle;
import android.support.annotation.NonNull;
import androidx.versionedparcelable.c;

abstract interface AudioAttributesImpl
  extends c
{
  public abstract Object getAudioAttributes();
  
  public abstract int getContentType();
  
  public abstract int getFlags();
  
  public abstract int getLegacyStreamType();
  
  public abstract int getRawLegacyStreamType();
  
  public abstract int getUsage();
  
  public abstract int getVolumeControlStream();
  
  @NonNull
  public abstract Bundle toBundle();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\media\AudioAttributesImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */