package android.support.v4.media;

import android.media.Rating;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.RestrictTo;
import android.util.Log;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class RatingCompat
  implements Parcelable
{
  public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator()
  {
    public RatingCompat createFromParcel(Parcel paramAnonymousParcel)
    {
      return new RatingCompat(paramAnonymousParcel.readInt(), paramAnonymousParcel.readFloat());
    }
    
    public RatingCompat[] newArray(int paramAnonymousInt)
    {
      return new RatingCompat[paramAnonymousInt];
    }
  };
  public static final int RATING_3_STARS = 3;
  public static final int RATING_4_STARS = 4;
  public static final int RATING_5_STARS = 5;
  public static final int RATING_HEART = 1;
  public static final int RATING_NONE = 0;
  private static final float RATING_NOT_RATED = -1.0F;
  public static final int RATING_PERCENTAGE = 6;
  public static final int RATING_THUMB_UP_DOWN = 2;
  private static final String TAG = "Rating";
  private Object mRatingObj;
  private final int mRatingStyle;
  private final float mRatingValue;
  
  RatingCompat(int paramInt, float paramFloat)
  {
    this.mRatingStyle = paramInt;
    this.mRatingValue = paramFloat;
  }
  
  public static RatingCompat fromRating(Object paramObject)
  {
    if ((paramObject != null) && (Build.VERSION.SDK_INT >= 19))
    {
      Object localObject = (Rating)paramObject;
      int i = ((Rating)localObject).getRatingStyle();
      if (((Rating)localObject).isRated()) {
        switch (i)
        {
        default: 
          return null;
        case 6: 
          localObject = newPercentageRating(((Rating)localObject).getPercentRating());
          break;
        case 3: 
        case 4: 
        case 5: 
          localObject = newStarRating(i, ((Rating)localObject).getStarRating());
          break;
        case 2: 
          localObject = newThumbRating(((Rating)localObject).isThumbUp());
          break;
        case 1: 
          localObject = newHeartRating(((Rating)localObject).hasHeart());
          break;
        }
      } else {
        localObject = newUnratedRating(i);
      }
      ((RatingCompat)localObject).mRatingObj = paramObject;
      return (RatingCompat)localObject;
    }
    return null;
  }
  
  public static RatingCompat newHeartRating(boolean paramBoolean)
  {
    float f;
    if (paramBoolean) {
      f = 1.0F;
    } else {
      f = 0.0F;
    }
    return new RatingCompat(1, f);
  }
  
  public static RatingCompat newPercentageRating(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 100.0F)) {
      return new RatingCompat(6, paramFloat);
    }
    Log.e("Rating", "Invalid percentage-based rating value");
    return null;
  }
  
  public static RatingCompat newStarRating(int paramInt, float paramFloat)
  {
    float f;
    switch (paramInt)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid rating style (");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(") for a star rating");
      Log.e("Rating", localStringBuilder.toString());
      return null;
    case 5: 
      f = 5.0F;
      break;
    case 4: 
      f = 4.0F;
      break;
    case 3: 
      f = 3.0F;
    }
    if ((paramFloat >= 0.0F) && (paramFloat <= f)) {
      return new RatingCompat(paramInt, paramFloat);
    }
    Log.e("Rating", "Trying to set out of range star-based rating");
    return null;
  }
  
  public static RatingCompat newThumbRating(boolean paramBoolean)
  {
    float f;
    if (paramBoolean) {
      f = 1.0F;
    } else {
      f = 0.0F;
    }
    return new RatingCompat(2, f);
  }
  
  public static RatingCompat newUnratedRating(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new RatingCompat(paramInt, -1.0F);
  }
  
  public int describeContents()
  {
    return this.mRatingStyle;
  }
  
  public float getPercentRating()
  {
    if ((this.mRatingStyle == 6) && (isRated())) {
      return this.mRatingValue;
    }
    return -1.0F;
  }
  
  public Object getRating()
  {
    if ((this.mRatingObj == null) && (Build.VERSION.SDK_INT >= 19)) {
      if (isRated()) {
        switch (this.mRatingStyle)
        {
        default: 
          return null;
        case 6: 
          this.mRatingObj = Rating.newPercentageRating(getPercentRating());
          break;
        case 3: 
        case 4: 
        case 5: 
          this.mRatingObj = Rating.newStarRating(this.mRatingStyle, getStarRating());
          break;
        case 2: 
          this.mRatingObj = Rating.newThumbRating(isThumbUp());
          break;
        case 1: 
          this.mRatingObj = Rating.newHeartRating(hasHeart());
          break;
        }
      } else {
        this.mRatingObj = Rating.newUnratedRating(this.mRatingStyle);
      }
    }
    return this.mRatingObj;
  }
  
  public int getRatingStyle()
  {
    return this.mRatingStyle;
  }
  
  public float getStarRating()
  {
    switch (this.mRatingStyle)
    {
    default: 
      break;
    case 3: 
    case 4: 
    case 5: 
      if (isRated()) {
        return this.mRatingValue;
      }
      break;
    }
    return -1.0F;
  }
  
  public boolean hasHeart()
  {
    int i = this.mRatingStyle;
    boolean bool = false;
    if (i != 1) {
      return false;
    }
    if (this.mRatingValue == 1.0F) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isRated()
  {
    return this.mRatingValue >= 0.0F;
  }
  
  public boolean isThumbUp()
  {
    int i = this.mRatingStyle;
    boolean bool = false;
    if (i != 2) {
      return false;
    }
    if (this.mRatingValue == 1.0F) {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Rating:style=");
    localStringBuilder.append(this.mRatingStyle);
    localStringBuilder.append(" rating=");
    String str;
    if (this.mRatingValue < 0.0F) {
      str = "unrated";
    } else {
      str = String.valueOf(this.mRatingValue);
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mRatingStyle);
    paramParcel.writeFloat(this.mRatingValue);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface StarStyle {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface Style {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\media\RatingCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */