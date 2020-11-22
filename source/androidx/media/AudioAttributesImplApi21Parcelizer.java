package androidx.media;

import android.media.AudioAttributes;
import android.support.annotation.RestrictTo;
import android.support.v4.media.AudioAttributesImplApi21;
import androidx.versionedparcelable.a;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public final class AudioAttributesImplApi21Parcelizer
{
  public static AudioAttributesImplApi21 read(a parama)
  {
    AudioAttributesImplApi21 localAudioAttributesImplApi21 = new AudioAttributesImplApi21();
    localAudioAttributesImplApi21.mAudioAttributes = ((AudioAttributes)parama.b(localAudioAttributesImplApi21.mAudioAttributes, 1));
    localAudioAttributesImplApi21.mLegacyStreamType = parama.b(localAudioAttributesImplApi21.mLegacyStreamType, 2);
    return localAudioAttributesImplApi21;
  }
  
  public static void write(AudioAttributesImplApi21 paramAudioAttributesImplApi21, a parama)
  {
    parama.a(false, false);
    parama.a(paramAudioAttributesImplApi21.mAudioAttributes, 1);
    parama.a(paramAudioAttributesImplApi21.mLegacyStreamType, 2);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\androidx\media\AudioAttributesImplApi21Parcelizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */