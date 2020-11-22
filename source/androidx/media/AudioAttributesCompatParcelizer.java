package androidx.media;

import android.support.annotation.RestrictTo;
import android.support.v4.media.AudioAttributesCompat;
import android.support.v4.media.AudioAttributesImpl;
import androidx.versionedparcelable.a;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public final class AudioAttributesCompatParcelizer
{
  public static AudioAttributesCompat read(a parama)
  {
    AudioAttributesCompat localAudioAttributesCompat = new AudioAttributesCompat();
    localAudioAttributesCompat.mImpl = ((AudioAttributesImpl)parama.b(localAudioAttributesCompat.mImpl, 1));
    return localAudioAttributesCompat;
  }
  
  public static void write(AudioAttributesCompat paramAudioAttributesCompat, a parama)
  {
    parama.a(false, false);
    parama.a(paramAudioAttributesCompat.mImpl, 1);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\androidx\media\AudioAttributesCompatParcelizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */