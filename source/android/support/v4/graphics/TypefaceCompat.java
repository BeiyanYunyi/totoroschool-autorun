package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.content.res.FontResourcesParserCompat.FamilyResourceEntry;
import android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import android.support.v4.content.res.FontResourcesParserCompat.ProviderResourceEntry;
import android.support.v4.content.res.ResourcesCompat.FontCallback;
import android.support.v4.provider.FontsContractCompat;
import android.support.v4.provider.FontsContractCompat.FontInfo;
import android.support.v4.util.LruCache;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TypefaceCompat
{
  private static final String TAG = "TypefaceCompat";
  private static final LruCache<String, Typeface> sTypefaceCache = new LruCache(16);
  private static final TypefaceCompatBaseImpl sTypefaceCompatImpl;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 28) {
      sTypefaceCompatImpl = new TypefaceCompatApi28Impl();
    } else if (Build.VERSION.SDK_INT >= 26) {
      sTypefaceCompatImpl = new TypefaceCompatApi26Impl();
    } else if ((Build.VERSION.SDK_INT >= 24) && (TypefaceCompatApi24Impl.isUsable())) {
      sTypefaceCompatImpl = new TypefaceCompatApi24Impl();
    } else if (Build.VERSION.SDK_INT >= 21) {
      sTypefaceCompatImpl = new TypefaceCompatApi21Impl();
    } else {
      sTypefaceCompatImpl = new TypefaceCompatBaseImpl();
    }
  }
  
  @Nullable
  public static Typeface createFromFontInfo(@NonNull Context paramContext, @Nullable CancellationSignal paramCancellationSignal, @NonNull FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    return sTypefaceCompatImpl.createFromFontInfo(paramContext, paramCancellationSignal, paramArrayOfFontInfo, paramInt);
  }
  
  @Nullable
  public static Typeface createFromResourcesFamilyXml(@NonNull Context paramContext, @NonNull FontResourcesParserCompat.FamilyResourceEntry paramFamilyResourceEntry, @NonNull Resources paramResources, int paramInt1, int paramInt2, @Nullable ResourcesCompat.FontCallback paramFontCallback, @Nullable Handler paramHandler, boolean paramBoolean)
  {
    if ((paramFamilyResourceEntry instanceof FontResourcesParserCompat.ProviderResourceEntry))
    {
      paramFamilyResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry)paramFamilyResourceEntry;
      boolean bool = false;
      if (paramBoolean)
      {
        if (paramFamilyResourceEntry.getFetchStrategy() != 0) {}
      }
      else {
        while (paramFontCallback == null)
        {
          bool = true;
          break;
        }
      }
      int i;
      if (paramBoolean) {
        i = paramFamilyResourceEntry.getTimeout();
      } else {
        i = -1;
      }
      paramContext = FontsContractCompat.getFontSync(paramContext, paramFamilyResourceEntry.getRequest(), paramFontCallback, paramHandler, bool, i, paramInt2);
    }
    else
    {
      paramFamilyResourceEntry = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(paramContext, (FontResourcesParserCompat.FontFamilyFilesResourceEntry)paramFamilyResourceEntry, paramResources, paramInt2);
      paramContext = paramFamilyResourceEntry;
      if (paramFontCallback != null) {
        if (paramFamilyResourceEntry != null)
        {
          paramFontCallback.callbackSuccessAsync(paramFamilyResourceEntry, paramHandler);
          paramContext = paramFamilyResourceEntry;
        }
        else
        {
          paramFontCallback.callbackFailAsync(-3, paramHandler);
          paramContext = paramFamilyResourceEntry;
        }
      }
    }
    if (paramContext != null) {
      sTypefaceCache.put(createResourceUid(paramResources, paramInt1, paramInt2), paramContext);
    }
    return paramContext;
  }
  
  @Nullable
  public static Typeface createFromResourcesFontFile(@NonNull Context paramContext, @NonNull Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    paramContext = sTypefaceCompatImpl.createFromResourcesFontFile(paramContext, paramResources, paramInt1, paramString, paramInt2);
    if (paramContext != null)
    {
      paramResources = createResourceUid(paramResources, paramInt1, paramInt2);
      sTypefaceCache.put(paramResources, paramContext);
    }
    return paramContext;
  }
  
  private static String createResourceUid(Resources paramResources, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramResources.getResourcePackageName(paramInt1));
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
  }
  
  @Nullable
  public static Typeface findFromCache(@NonNull Resources paramResources, int paramInt1, int paramInt2)
  {
    return (Typeface)sTypefaceCache.get(createResourceUid(paramResources, paramInt1, paramInt2));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\graphics\TypefaceCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */