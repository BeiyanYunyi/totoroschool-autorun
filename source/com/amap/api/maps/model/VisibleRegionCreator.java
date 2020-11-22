package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class VisibleRegionCreator
  implements Parcelable.Creator<VisibleRegion>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  static void a(VisibleRegion paramVisibleRegion, Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(paramVisibleRegion.a());
    paramParcel.writeParcelable(paramVisibleRegion.nearLeft, paramInt);
    paramParcel.writeParcelable(paramVisibleRegion.nearRight, paramInt);
    paramParcel.writeParcelable(paramVisibleRegion.farLeft, paramInt);
    paramParcel.writeParcelable(paramVisibleRegion.farRight, paramInt);
    paramParcel.writeParcelable(paramVisibleRegion.latLngBounds, paramInt);
  }
  
  /* Error */
  public VisibleRegion createFromParcel(Parcel paramParcel)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 56	android/os/Parcel:readInt	()I
    //   4: istore_2
    //   5: aload_1
    //   6: ldc 58
    //   8: invokevirtual 64	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   11: invokevirtual 68	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   14: checkcast 58	com/amap/api/maps/model/LatLng
    //   17: astore_3
    //   18: aload_1
    //   19: ldc 58
    //   21: invokevirtual 64	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   24: invokevirtual 68	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   27: checkcast 58	com/amap/api/maps/model/LatLng
    //   30: astore 4
    //   32: aload_1
    //   33: ldc 58
    //   35: invokevirtual 64	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   38: invokevirtual 68	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   41: checkcast 58	com/amap/api/maps/model/LatLng
    //   44: astore 5
    //   46: aload_1
    //   47: ldc 58
    //   49: invokevirtual 64	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   52: invokevirtual 68	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   55: checkcast 58	com/amap/api/maps/model/LatLng
    //   58: astore 6
    //   60: aload_1
    //   61: ldc 70
    //   63: invokevirtual 64	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   66: invokevirtual 68	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   69: checkcast 70	com/amap/api/maps/model/LatLngBounds
    //   72: astore_1
    //   73: aload_1
    //   74: astore 7
    //   76: goto +67 -> 143
    //   79: astore 7
    //   81: aload 6
    //   83: astore_1
    //   84: goto +48 -> 132
    //   87: astore 7
    //   89: aconst_null
    //   90: astore_1
    //   91: goto +41 -> 132
    //   94: astore 7
    //   96: aconst_null
    //   97: astore_1
    //   98: aload_3
    //   99: astore 6
    //   101: aload_1
    //   102: astore_3
    //   103: goto +21 -> 124
    //   106: astore 7
    //   108: aload_3
    //   109: astore 6
    //   111: goto +8 -> 119
    //   114: astore 7
    //   116: aconst_null
    //   117: astore 6
    //   119: aconst_null
    //   120: astore 4
    //   122: aconst_null
    //   123: astore_3
    //   124: aload_3
    //   125: astore_1
    //   126: aload_3
    //   127: astore 5
    //   129: aload 6
    //   131: astore_3
    //   132: aload 7
    //   134: invokevirtual 73	android/os/BadParcelableException:printStackTrace	()V
    //   137: aconst_null
    //   138: astore 7
    //   140: aload_1
    //   141: astore 6
    //   143: new 19	com/amap/api/maps/model/VisibleRegion
    //   146: dup
    //   147: iload_2
    //   148: aload_3
    //   149: aload 4
    //   151: aload 5
    //   153: aload 6
    //   155: aload 7
    //   157: invokespecial 76	com/amap/api/maps/model/VisibleRegion:<init>	(ILcom/amap/api/maps/model/LatLng;Lcom/amap/api/maps/model/LatLng;Lcom/amap/api/maps/model/LatLng;Lcom/amap/api/maps/model/LatLng;Lcom/amap/api/maps/model/LatLngBounds;)V
    //   160: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	VisibleRegionCreator
    //   0	161	1	paramParcel	Parcel
    //   4	144	2	i	int
    //   17	132	3	localObject1	Object
    //   30	120	4	localLatLng	LatLng
    //   44	108	5	localObject2	Object
    //   58	96	6	localObject3	Object
    //   74	1	7	localParcel	Parcel
    //   79	1	7	localBadParcelableException1	android.os.BadParcelableException
    //   87	1	7	localBadParcelableException2	android.os.BadParcelableException
    //   94	1	7	localBadParcelableException3	android.os.BadParcelableException
    //   106	1	7	localBadParcelableException4	android.os.BadParcelableException
    //   114	19	7	localBadParcelableException5	android.os.BadParcelableException
    //   138	18	7	localLatLngBounds	LatLngBounds
    // Exception table:
    //   from	to	target	type
    //   60	73	79	android/os/BadParcelableException
    //   46	60	87	android/os/BadParcelableException
    //   32	46	94	android/os/BadParcelableException
    //   18	32	106	android/os/BadParcelableException
    //   5	18	114	android/os/BadParcelableException
  }
  
  public VisibleRegion[] newArray(int paramInt)
  {
    return new VisibleRegion[paramInt];
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\VisibleRegionCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */