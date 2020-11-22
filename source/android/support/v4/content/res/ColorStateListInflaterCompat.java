package android.support.v4.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.compat.R.attr;
import android.support.compat.R.styleable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class ColorStateListInflaterCompat
{
  private static final int DEFAULT_COLOR = -65536;
  
  @NonNull
  public static ColorStateList createFromXml(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @Nullable Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    AttributeSet localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i == 2) {
      return createFromXmlInner(paramResources, paramXmlPullParser, localAttributeSet, paramTheme);
    }
    throw new XmlPullParserException("No start tag found");
  }
  
  @NonNull
  public static ColorStateList createFromXmlInner(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    String str = paramXmlPullParser.getName();
    if (str.equals("selector")) {
      return inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    }
    paramResources = new StringBuilder();
    paramResources.append(paramXmlPullParser.getPositionDescription());
    paramResources.append(": invalid color state list tag ");
    paramResources.append(str);
    throw new XmlPullParserException(paramResources.toString());
  }
  
  private static ColorStateList inflate(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    int i1 = paramXmlPullParser.getDepth() + 1;
    int[][] arrayOfInt = new int[20][];
    int[] arrayOfInt1 = new int[arrayOfInt.length];
    int i = 0;
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (j == 1) {
        break;
      }
      int k = paramXmlPullParser.getDepth();
      if ((k < i1) && (j == 3)) {
        break;
      }
      if ((j == 2) && (k <= i1) && (paramXmlPullParser.getName().equals("item")))
      {
        Object localObject = obtainAttributes(paramResources, paramTheme, paramAttributeSet, R.styleable.ColorStateListItem);
        int i2 = ((TypedArray)localObject).getColor(R.styleable.ColorStateListItem_android_color, -65281);
        float f = 1.0F;
        if (((TypedArray)localObject).hasValue(R.styleable.ColorStateListItem_android_alpha)) {
          f = ((TypedArray)localObject).getFloat(R.styleable.ColorStateListItem_android_alpha, 1.0F);
        } else if (((TypedArray)localObject).hasValue(R.styleable.ColorStateListItem_alpha)) {
          f = ((TypedArray)localObject).getFloat(R.styleable.ColorStateListItem_alpha, 1.0F);
        }
        ((TypedArray)localObject).recycle();
        int i3 = paramAttributeSet.getAttributeCount();
        localObject = new int[i3];
        j = 0;
        int m;
        for (k = 0; j < i3; k = m)
        {
          int n = paramAttributeSet.getAttributeNameResource(j);
          m = k;
          if (n != 16843173)
          {
            m = k;
            if (n != 16843551)
            {
              m = k;
              if (n != R.attr.alpha)
              {
                if (paramAttributeSet.getAttributeBooleanValue(j, false)) {
                  m = n;
                } else {
                  m = -n;
                }
                localObject[k] = m;
                m = k + 1;
              }
            }
          }
          j += 1;
        }
        localObject = StateSet.trimStateSet((int[])localObject, k);
        j = modulateColorAlpha(i2, f);
        if (i != 0) {
          k = localObject.length;
        }
        arrayOfInt1 = GrowingArrayUtils.append(arrayOfInt1, i, j);
        arrayOfInt = (int[][])GrowingArrayUtils.append(arrayOfInt, i, localObject);
        i += 1;
      }
    }
    paramResources = new int[i];
    paramXmlPullParser = new int[i][];
    System.arraycopy(arrayOfInt1, 0, paramResources, 0, i);
    System.arraycopy(arrayOfInt, 0, paramXmlPullParser, 0, i);
    return new ColorStateList(paramXmlPullParser, paramResources);
  }
  
  @ColorInt
  private static int modulateColorAlpha(@ColorInt int paramInt, @FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    return paramInt & 0xFFFFFF | Math.round(Color.alpha(paramInt) * paramFloat) << 24;
  }
  
  private static TypedArray obtainAttributes(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    if (paramTheme == null) {
      return paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
    }
    return paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\content\res\ColorStateListInflaterCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */