package android.support.v4.media;

import android.os.Bundle;
import android.support.annotation.NonNull;
import java.util.Arrays;

class AudioAttributesImplBase
  implements AudioAttributesImpl
{
  int mContentType = 0;
  int mFlags = 0;
  int mLegacyStream = -1;
  int mUsage = 0;
  
  AudioAttributesImplBase() {}
  
  AudioAttributesImplBase(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mContentType = paramInt1;
    this.mFlags = paramInt2;
    this.mUsage = paramInt3;
    this.mLegacyStream = paramInt4;
  }
  
  public static AudioAttributesImpl fromBundle(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    int i = paramBundle.getInt("android.support.v4.media.audio_attrs.USAGE", 0);
    return new AudioAttributesImplBase(paramBundle.getInt("android.support.v4.media.audio_attrs.CONTENT_TYPE", 0), paramBundle.getInt("android.support.v4.media.audio_attrs.FLAGS", 0), i, paramBundle.getInt("android.support.v4.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof AudioAttributesImplBase;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (AudioAttributesImplBase)paramObject;
    bool1 = bool2;
    if (this.mContentType == ((AudioAttributesImplBase)paramObject).getContentType())
    {
      bool1 = bool2;
      if (this.mFlags == ((AudioAttributesImplBase)paramObject).getFlags())
      {
        bool1 = bool2;
        if (this.mUsage == ((AudioAttributesImplBase)paramObject).getUsage())
        {
          bool1 = bool2;
          if (this.mLegacyStream == ((AudioAttributesImplBase)paramObject).mLegacyStream) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public Object getAudioAttributes()
  {
    return null;
  }
  
  public int getContentType()
  {
    return this.mContentType;
  }
  
  public int getFlags()
  {
    int j = this.mFlags;
    int k = getLegacyStreamType();
    int i;
    if (k == 6)
    {
      i = j | 0x4;
    }
    else
    {
      i = j;
      if (k == 7) {
        i = j | 0x1;
      }
    }
    return i & 0x111;
  }
  
  public int getLegacyStreamType()
  {
    if (this.mLegacyStream != -1) {
      return this.mLegacyStream;
    }
    return AudioAttributesCompat.toVolumeStreamType(false, this.mFlags, this.mUsage);
  }
  
  public int getRawLegacyStreamType()
  {
    return this.mLegacyStream;
  }
  
  public int getUsage()
  {
    return this.mUsage;
  }
  
  public int getVolumeControlStream()
  {
    return AudioAttributesCompat.toVolumeStreamType(true, this.mFlags, this.mUsage);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.mContentType), Integer.valueOf(this.mFlags), Integer.valueOf(this.mUsage), Integer.valueOf(this.mLegacyStream) });
  }
  
  @NonNull
  public Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("android.support.v4.media.audio_attrs.USAGE", this.mUsage);
    localBundle.putInt("android.support.v4.media.audio_attrs.CONTENT_TYPE", this.mContentType);
    localBundle.putInt("android.support.v4.media.audio_attrs.FLAGS", this.mFlags);
    if (this.mLegacyStream != -1) {
      localBundle.putInt("android.support.v4.media.audio_attrs.LEGACY_STREAM_TYPE", this.mLegacyStream);
    }
    return localBundle;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AudioAttributesCompat:");
    if (this.mLegacyStream != -1)
    {
      localStringBuilder.append(" stream=");
      localStringBuilder.append(this.mLegacyStream);
      localStringBuilder.append(" derived");
    }
    localStringBuilder.append(" usage=");
    localStringBuilder.append(AudioAttributesCompat.usageToString(this.mUsage));
    localStringBuilder.append(" content=");
    localStringBuilder.append(this.mContentType);
    localStringBuilder.append(" flags=0x");
    localStringBuilder.append(Integer.toHexString(this.mFlags).toUpperCase());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\media\AudioAttributesImplBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */