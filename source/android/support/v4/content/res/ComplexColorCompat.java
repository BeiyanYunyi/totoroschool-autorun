package android.support.v4.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class ComplexColorCompat
{
  private static final String LOG_TAG = "ComplexColorCompat";
  private int mColor;
  private final ColorStateList mColorStateList;
  private final Shader mShader;
  
  private ComplexColorCompat(Shader paramShader, ColorStateList paramColorStateList, @ColorInt int paramInt)
  {
    this.mShader = paramShader;
    this.mColorStateList = paramColorStateList;
    this.mColor = paramInt;
  }
  
  @NonNull
  private static ComplexColorCompat createFromXml(@NonNull Resources paramResources, @ColorRes int paramInt, @Nullable Resources.Theme paramTheme)
    throws IOException, XmlPullParserException
  {
    XmlResourceParser localXmlResourceParser = paramResources.getXml(paramInt);
    AttributeSet localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
    int i;
    do
    {
      i = localXmlResourceParser.next();
      paramInt = 1;
    } while ((i != 2) && (i != 1));
    if (i == 2)
    {
      String str = localXmlResourceParser.getName();
      i = str.hashCode();
      if (i != 89650992)
      {
        if ((i == 1191572447) && (str.equals("selector")))
        {
          paramInt = 0;
          break label102;
        }
      }
      else {
        if (str.equals("gradient")) {
          break label102;
        }
      }
      paramInt = -1;
      switch (paramInt)
      {
      default: 
        paramResources = new StringBuilder();
        paramResources.append(localXmlResourceParser.getPositionDescription());
        paramResources.append(": unsupported complex color tag ");
        paramResources.append(str);
        throw new XmlPullParserException(paramResources.toString());
      case 1: 
        label102:
        return from(GradientColorInflaterCompat.createFromXmlInner(paramResources, localXmlResourceParser, localAttributeSet, paramTheme));
      }
      return from(ColorStateListInflaterCompat.createFromXmlInner(paramResources, localXmlResourceParser, localAttributeSet, paramTheme));
    }
    throw new XmlPullParserException("No start tag found");
  }
  
  static ComplexColorCompat from(@ColorInt int paramInt)
  {
    return new ComplexColorCompat(null, null, paramInt);
  }
  
  static ComplexColorCompat from(@NonNull ColorStateList paramColorStateList)
  {
    return new ComplexColorCompat(null, paramColorStateList, paramColorStateList.getDefaultColor());
  }
  
  static ComplexColorCompat from(@NonNull Shader paramShader)
  {
    return new ComplexColorCompat(paramShader, null, 0);
  }
  
  @Nullable
  public static ComplexColorCompat inflate(@NonNull Resources paramResources, @ColorRes int paramInt, @Nullable Resources.Theme paramTheme)
  {
    try
    {
      paramResources = createFromXml(paramResources, paramInt, paramTheme);
      return paramResources;
    }
    catch (Exception paramResources)
    {
      Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", paramResources);
    }
    return null;
  }
  
  @ColorInt
  public int getColor()
  {
    return this.mColor;
  }
  
  @Nullable
  public Shader getShader()
  {
    return this.mShader;
  }
  
  public boolean isGradient()
  {
    return this.mShader != null;
  }
  
  public boolean isStateful()
  {
    return (this.mShader == null) && (this.mColorStateList != null) && (this.mColorStateList.isStateful());
  }
  
  public boolean onStateChanged(int[] paramArrayOfInt)
  {
    if (isStateful())
    {
      int i = this.mColorStateList.getColorForState(paramArrayOfInt, this.mColorStateList.getDefaultColor());
      if (i != this.mColor)
      {
        this.mColor = i;
        return true;
      }
    }
    return false;
  }
  
  public void setColor(@ColorInt int paramInt)
  {
    this.mColor = paramInt;
  }
  
  public boolean willDraw()
  {
    return (isGradient()) || (this.mColor != 0);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\content\res\ComplexColorCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */