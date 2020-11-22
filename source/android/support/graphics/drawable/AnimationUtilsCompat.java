package android.support.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.support.annotation.RestrictTo;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class AnimationUtilsCompat
{
  private static Interpolator createInterpolatorFromXml(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    int i = paramXmlPullParser.getDepth();
    paramResources = null;
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (((j == 3) && (paramXmlPullParser.getDepth() <= i)) || (j == 1)) {
        return paramResources;
      }
      if (j == 2)
      {
        paramResources = Xml.asAttributeSet(paramXmlPullParser);
        paramTheme = paramXmlPullParser.getName();
        if (!paramTheme.equals("linearInterpolator")) {
          break;
        }
        paramResources = new LinearInterpolator();
      }
    }
    if (paramTheme.equals("accelerateInterpolator")) {
      paramResources = new AccelerateInterpolator(paramContext, paramResources);
    }
    for (;;)
    {
      break;
      if (paramTheme.equals("decelerateInterpolator"))
      {
        paramResources = new DecelerateInterpolator(paramContext, paramResources);
      }
      else
      {
        if (paramTheme.equals("accelerateDecelerateInterpolator"))
        {
          paramResources = new AccelerateDecelerateInterpolator();
          break;
        }
        if (paramTheme.equals("cycleInterpolator"))
        {
          paramResources = new CycleInterpolator(paramContext, paramResources);
        }
        else if (paramTheme.equals("anticipateInterpolator"))
        {
          paramResources = new AnticipateInterpolator(paramContext, paramResources);
        }
        else if (paramTheme.equals("overshootInterpolator"))
        {
          paramResources = new OvershootInterpolator(paramContext, paramResources);
        }
        else if (paramTheme.equals("anticipateOvershootInterpolator"))
        {
          paramResources = new AnticipateOvershootInterpolator(paramContext, paramResources);
        }
        else
        {
          if (paramTheme.equals("bounceInterpolator"))
          {
            paramResources = new BounceInterpolator();
            break;
          }
          if (!paramTheme.equals("pathInterpolator")) {
            break label277;
          }
          paramResources = new PathInterpolatorCompat(paramContext, paramResources, paramXmlPullParser);
        }
      }
    }
    label277:
    paramContext = new StringBuilder();
    paramContext.append("Unknown interpolator name: ");
    paramContext.append(paramXmlPullParser.getName());
    throw new RuntimeException(paramContext.toString());
    return paramResources;
  }
  
  /* Error */
  public static Interpolator loadInterpolator(Context paramContext, int paramInt)
    throws android.content.res.Resources.NotFoundException
  {
    // Byte code:
    //   0: getstatic 126	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 21
    //   5: if_icmplt +9 -> 14
    //   8: aload_0
    //   9: iload_1
    //   10: invokestatic 130	android/view/animation/AnimationUtils:loadInterpolator	(Landroid/content/Context;I)Landroid/view/animation/Interpolator;
    //   13: areturn
    //   14: aconst_null
    //   15: astore 5
    //   17: aconst_null
    //   18: astore_2
    //   19: aconst_null
    //   20: astore 4
    //   22: iload_1
    //   23: ldc -125
    //   25: if_icmpne +11 -> 36
    //   28: new 133	android/support/v4/view/animation/FastOutLinearInInterpolator
    //   31: dup
    //   32: invokespecial 134	android/support/v4/view/animation/FastOutLinearInInterpolator:<init>	()V
    //   35: areturn
    //   36: iload_1
    //   37: ldc -121
    //   39: if_icmpne +11 -> 50
    //   42: new 137	android/support/v4/view/animation/FastOutSlowInInterpolator
    //   45: dup
    //   46: invokespecial 138	android/support/v4/view/animation/FastOutSlowInInterpolator:<init>	()V
    //   49: areturn
    //   50: iload_1
    //   51: ldc -117
    //   53: if_icmpne +11 -> 64
    //   56: new 141	android/support/v4/view/animation/LinearOutSlowInInterpolator
    //   59: dup
    //   60: invokespecial 142	android/support/v4/view/animation/LinearOutSlowInInterpolator:<init>	()V
    //   63: areturn
    //   64: aload_0
    //   65: invokevirtual 148	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   68: iload_1
    //   69: invokevirtual 154	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   72: astore_3
    //   73: aload_0
    //   74: aload_0
    //   75: invokevirtual 148	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   78: aload_0
    //   79: invokevirtual 158	android/content/Context:getTheme	()Landroid/content/res/Resources$Theme;
    //   82: aload_3
    //   83: invokestatic 160	android/support/graphics/drawable/AnimationUtilsCompat:createInterpolatorFromXml	(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;)Landroid/view/animation/Interpolator;
    //   86: astore_0
    //   87: aload_3
    //   88: ifnull +9 -> 97
    //   91: aload_3
    //   92: invokeinterface 165 1 0
    //   97: aload_0
    //   98: areturn
    //   99: astore_0
    //   100: aload_3
    //   101: astore_2
    //   102: goto +145 -> 247
    //   105: astore_2
    //   106: aload_3
    //   107: astore_0
    //   108: aload_2
    //   109: astore_3
    //   110: goto +11 -> 121
    //   113: astore_2
    //   114: aload_3
    //   115: astore_0
    //   116: aload_2
    //   117: astore_3
    //   118: goto +66 -> 184
    //   121: aload_0
    //   122: astore_2
    //   123: new 100	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   130: astore 4
    //   132: aload_0
    //   133: astore_2
    //   134: aload 4
    //   136: ldc -89
    //   138: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_0
    //   143: astore_2
    //   144: aload 4
    //   146: iload_1
    //   147: invokestatic 173	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   150: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload_0
    //   155: astore_2
    //   156: new 120	android/content/res/Resources$NotFoundException
    //   159: dup
    //   160: aload 4
    //   162: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokespecial 174	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   168: astore 4
    //   170: aload_0
    //   171: astore_2
    //   172: aload 4
    //   174: aload_3
    //   175: invokevirtual 178	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   178: pop
    //   179: aload_0
    //   180: astore_2
    //   181: aload 4
    //   183: athrow
    //   184: aload_0
    //   185: astore_2
    //   186: new 100	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   193: astore 4
    //   195: aload_0
    //   196: astore_2
    //   197: aload 4
    //   199: ldc -89
    //   201: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_0
    //   206: astore_2
    //   207: aload 4
    //   209: iload_1
    //   210: invokestatic 173	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   213: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload_0
    //   218: astore_2
    //   219: new 120	android/content/res/Resources$NotFoundException
    //   222: dup
    //   223: aload 4
    //   225: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokespecial 174	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   231: astore 4
    //   233: aload_0
    //   234: astore_2
    //   235: aload 4
    //   237: aload_3
    //   238: invokevirtual 178	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   241: pop
    //   242: aload_0
    //   243: astore_2
    //   244: aload 4
    //   246: athrow
    //   247: aload_2
    //   248: ifnull +9 -> 257
    //   251: aload_2
    //   252: invokeinterface 165 1 0
    //   257: aload_0
    //   258: athrow
    //   259: astore_0
    //   260: goto -13 -> 247
    //   263: astore_3
    //   264: aload 4
    //   266: astore_0
    //   267: goto -146 -> 121
    //   270: astore_3
    //   271: aload 5
    //   273: astore_0
    //   274: goto -90 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	paramContext	Context
    //   0	277	1	paramInt	int
    //   18	84	2	localObject1	Object
    //   105	4	2	localIOException1	IOException
    //   113	4	2	localXmlPullParserException1	XmlPullParserException
    //   122	130	2	localContext	Context
    //   72	166	3	localObject2	Object
    //   263	1	3	localIOException2	IOException
    //   270	1	3	localXmlPullParserException2	XmlPullParserException
    //   20	245	4	localObject3	Object
    //   15	257	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   73	87	99	finally
    //   73	87	105	java/io/IOException
    //   73	87	113	org/xmlpull/v1/XmlPullParserException
    //   28	36	259	finally
    //   42	50	259	finally
    //   56	64	259	finally
    //   64	73	259	finally
    //   123	132	259	finally
    //   134	142	259	finally
    //   144	154	259	finally
    //   156	170	259	finally
    //   172	179	259	finally
    //   181	184	259	finally
    //   186	195	259	finally
    //   197	205	259	finally
    //   207	217	259	finally
    //   219	233	259	finally
    //   235	242	259	finally
    //   244	247	259	finally
    //   28	36	263	java/io/IOException
    //   42	50	263	java/io/IOException
    //   56	64	263	java/io/IOException
    //   64	73	263	java/io/IOException
    //   28	36	270	org/xmlpull/v1/XmlPullParserException
    //   42	50	270	org/xmlpull/v1/XmlPullParserException
    //   56	64	270	org/xmlpull/v1/XmlPullParserException
    //   64	73	270	org/xmlpull/v1/XmlPullParserException
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\graphics\drawable\AnimationUtilsCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */