package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class ParcelImpl
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelImpl> CREATOR = new Parcelable.Creator()
  {
    public ParcelImpl a(Parcel paramAnonymousParcel)
    {
      return new ParcelImpl(paramAnonymousParcel);
    }
    
    public ParcelImpl[] a(int paramAnonymousInt)
    {
      return new ParcelImpl[paramAnonymousInt];
    }
  };
  private final c a;
  
  protected ParcelImpl(Parcel paramParcel)
  {
    this.a = new b(paramParcel).h();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    new b(paramParcel).a(this.a);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\androidx\versionedparcelable\ParcelImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */