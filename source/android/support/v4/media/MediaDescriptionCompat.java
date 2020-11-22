package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;

public final class MediaDescriptionCompat
  implements Parcelable
{
  public static final long BT_FOLDER_TYPE_ALBUMS = 2L;
  public static final long BT_FOLDER_TYPE_ARTISTS = 3L;
  public static final long BT_FOLDER_TYPE_GENRES = 4L;
  public static final long BT_FOLDER_TYPE_MIXED = 0L;
  public static final long BT_FOLDER_TYPE_PLAYLISTS = 5L;
  public static final long BT_FOLDER_TYPE_TITLES = 1L;
  public static final long BT_FOLDER_TYPE_YEARS = 6L;
  public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator()
  {
    public MediaDescriptionCompat createFromParcel(Parcel paramAnonymousParcel)
    {
      if (Build.VERSION.SDK_INT < 21) {
        return new MediaDescriptionCompat(paramAnonymousParcel);
      }
      return MediaDescriptionCompat.fromMediaDescription(MediaDescriptionCompatApi21.fromParcel(paramAnonymousParcel));
    }
    
    public MediaDescriptionCompat[] newArray(int paramAnonymousInt)
    {
      return new MediaDescriptionCompat[paramAnonymousInt];
    }
  };
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
  public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
  public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
  public static final long STATUS_DOWNLOADED = 2L;
  public static final long STATUS_DOWNLOADING = 1L;
  public static final long STATUS_NOT_DOWNLOADED = 0L;
  private final CharSequence mDescription;
  private Object mDescriptionObj;
  private final Bundle mExtras;
  private final Bitmap mIcon;
  private final Uri mIconUri;
  private final String mMediaId;
  private final Uri mMediaUri;
  private final CharSequence mSubtitle;
  private final CharSequence mTitle;
  
  MediaDescriptionCompat(Parcel paramParcel)
  {
    this.mMediaId = paramParcel.readString();
    this.mTitle = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.mSubtitle = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.mDescription = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    ClassLoader localClassLoader = getClass().getClassLoader();
    this.mIcon = ((Bitmap)paramParcel.readParcelable(localClassLoader));
    this.mIconUri = ((Uri)paramParcel.readParcelable(localClassLoader));
    this.mExtras = paramParcel.readBundle(localClassLoader);
    this.mMediaUri = ((Uri)paramParcel.readParcelable(localClassLoader));
  }
  
  MediaDescriptionCompat(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, Bitmap paramBitmap, Uri paramUri1, Bundle paramBundle, Uri paramUri2)
  {
    this.mMediaId = paramString;
    this.mTitle = paramCharSequence1;
    this.mSubtitle = paramCharSequence2;
    this.mDescription = paramCharSequence3;
    this.mIcon = paramBitmap;
    this.mIconUri = paramUri1;
    this.mExtras = paramBundle;
    this.mMediaUri = paramUri2;
  }
  
  public static MediaDescriptionCompat fromMediaDescription(Object paramObject)
  {
    Object localObject2 = null;
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 21))
    {
      Builder localBuilder = new Builder();
      localBuilder.setMediaId(MediaDescriptionCompatApi21.getMediaId(paramObject));
      localBuilder.setTitle(MediaDescriptionCompatApi21.getTitle(paramObject));
      localBuilder.setSubtitle(MediaDescriptionCompatApi21.getSubtitle(paramObject));
      localBuilder.setDescription(MediaDescriptionCompatApi21.getDescription(paramObject));
      localBuilder.setIconBitmap(MediaDescriptionCompatApi21.getIconBitmap(paramObject));
      localBuilder.setIconUri(MediaDescriptionCompatApi21.getIconUri(paramObject));
      Bundle localBundle = MediaDescriptionCompatApi21.getExtras(paramObject);
      if (localBundle != null)
      {
        MediaSessionCompat.ensureClassLoader(localBundle);
        localObject1 = (Uri)localBundle.getParcelable("android.support.v4.media.description.MEDIA_URI");
      }
      else
      {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        if ((!localBundle.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG")) || (localBundle.size() != 2))
        {
          localBundle.remove("android.support.v4.media.description.MEDIA_URI");
          localBundle.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        }
      }
      else {
        localObject2 = localBundle;
      }
      localBuilder.setExtras((Bundle)localObject2);
      if (localObject1 != null) {
        localBuilder.setMediaUri((Uri)localObject1);
      } else if (Build.VERSION.SDK_INT >= 23) {
        localBuilder.setMediaUri(MediaDescriptionCompatApi23.getMediaUri(paramObject));
      }
      Object localObject1 = localBuilder.build();
      ((MediaDescriptionCompat)localObject1).mDescriptionObj = paramObject;
      return (MediaDescriptionCompat)localObject1;
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @Nullable
  public CharSequence getDescription()
  {
    return this.mDescription;
  }
  
  @Nullable
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  @Nullable
  public Bitmap getIconBitmap()
  {
    return this.mIcon;
  }
  
  @Nullable
  public Uri getIconUri()
  {
    return this.mIconUri;
  }
  
  public Object getMediaDescription()
  {
    if ((this.mDescriptionObj == null) && (Build.VERSION.SDK_INT >= 21))
    {
      Object localObject = MediaDescriptionCompatApi21.Builder.newInstance();
      MediaDescriptionCompatApi21.Builder.setMediaId(localObject, this.mMediaId);
      MediaDescriptionCompatApi21.Builder.setTitle(localObject, this.mTitle);
      MediaDescriptionCompatApi21.Builder.setSubtitle(localObject, this.mSubtitle);
      MediaDescriptionCompatApi21.Builder.setDescription(localObject, this.mDescription);
      MediaDescriptionCompatApi21.Builder.setIconBitmap(localObject, this.mIcon);
      MediaDescriptionCompatApi21.Builder.setIconUri(localObject, this.mIconUri);
      Bundle localBundle2 = this.mExtras;
      Bundle localBundle1 = localBundle2;
      if (Build.VERSION.SDK_INT < 23)
      {
        localBundle1 = localBundle2;
        if (this.mMediaUri != null)
        {
          localBundle1 = localBundle2;
          if (localBundle2 == null)
          {
            localBundle1 = new Bundle();
            localBundle1.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
          }
          localBundle1.putParcelable("android.support.v4.media.description.MEDIA_URI", this.mMediaUri);
        }
      }
      MediaDescriptionCompatApi21.Builder.setExtras(localObject, localBundle1);
      if (Build.VERSION.SDK_INT >= 23) {
        MediaDescriptionCompatApi23.Builder.setMediaUri(localObject, this.mMediaUri);
      }
      this.mDescriptionObj = MediaDescriptionCompatApi21.Builder.build(localObject);
      return this.mDescriptionObj;
    }
    return this.mDescriptionObj;
  }
  
  @Nullable
  public String getMediaId()
  {
    return this.mMediaId;
  }
  
  @Nullable
  public Uri getMediaUri()
  {
    return this.mMediaUri;
  }
  
  @Nullable
  public CharSequence getSubtitle()
  {
    return this.mSubtitle;
  }
  
  @Nullable
  public CharSequence getTitle()
  {
    return this.mTitle;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mTitle);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.mSubtitle);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.mDescription);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      paramParcel.writeString(this.mMediaId);
      TextUtils.writeToParcel(this.mTitle, paramParcel, paramInt);
      TextUtils.writeToParcel(this.mSubtitle, paramParcel, paramInt);
      TextUtils.writeToParcel(this.mDescription, paramParcel, paramInt);
      paramParcel.writeParcelable(this.mIcon, paramInt);
      paramParcel.writeParcelable(this.mIconUri, paramInt);
      paramParcel.writeBundle(this.mExtras);
      paramParcel.writeParcelable(this.mMediaUri, paramInt);
      return;
    }
    MediaDescriptionCompatApi21.writeToParcel(getMediaDescription(), paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    private CharSequence mDescription;
    private Bundle mExtras;
    private Bitmap mIcon;
    private Uri mIconUri;
    private String mMediaId;
    private Uri mMediaUri;
    private CharSequence mSubtitle;
    private CharSequence mTitle;
    
    public MediaDescriptionCompat build()
    {
      return new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri);
    }
    
    public Builder setDescription(@Nullable CharSequence paramCharSequence)
    {
      this.mDescription = paramCharSequence;
      return this;
    }
    
    public Builder setExtras(@Nullable Bundle paramBundle)
    {
      this.mExtras = paramBundle;
      return this;
    }
    
    public Builder setIconBitmap(@Nullable Bitmap paramBitmap)
    {
      this.mIcon = paramBitmap;
      return this;
    }
    
    public Builder setIconUri(@Nullable Uri paramUri)
    {
      this.mIconUri = paramUri;
      return this;
    }
    
    public Builder setMediaId(@Nullable String paramString)
    {
      this.mMediaId = paramString;
      return this;
    }
    
    public Builder setMediaUri(@Nullable Uri paramUri)
    {
      this.mMediaUri = paramUri;
      return this;
    }
    
    public Builder setSubtitle(@Nullable CharSequence paramCharSequence)
    {
      this.mSubtitle = paramCharSequence;
      return this;
    }
    
    public Builder setTitle(@Nullable CharSequence paramCharSequence)
    {
      this.mTitle = paramCharSequence;
      return this;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\media\MediaDescriptionCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */