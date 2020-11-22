package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

@Deprecated
public final class ParcelableCompat
{
  @Deprecated
  public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> paramParcelableCompatCreatorCallbacks)
  {
    return new ParcelableCompatCreatorHoneycombMR2(paramParcelableCompatCreatorCallbacks);
  }
  
  static class ParcelableCompatCreatorHoneycombMR2<T>
    implements Parcelable.ClassLoaderCreator<T>
  {
    private final ParcelableCompatCreatorCallbacks<T> mCallbacks;
    
    ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> paramParcelableCompatCreatorCallbacks)
    {
      this.mCallbacks = paramParcelableCompatCreatorCallbacks;
    }
    
    public T createFromParcel(Parcel paramParcel)
    {
      return (T)this.mCallbacks.createFromParcel(paramParcel, null);
    }
    
    public T createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      return (T)this.mCallbacks.createFromParcel(paramParcel, paramClassLoader);
    }
    
    public T[] newArray(int paramInt)
    {
      return this.mCallbacks.newArray(paramInt);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\os\ParcelableCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */