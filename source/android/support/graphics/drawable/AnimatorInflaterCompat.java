package android.support.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build.VERSION;
import android.support.annotation.AnimatorRes;
import android.support.annotation.RestrictTo;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.support.v4.graphics.PathParser.PathDataNode;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class AnimatorInflaterCompat
{
  private static final boolean DBG_ANIMATOR_INFLATER = false;
  private static final int MAX_NUM_POINTS = 100;
  private static final String TAG = "AnimatorInflater";
  private static final int TOGETHER = 0;
  private static final int VALUE_TYPE_COLOR = 3;
  private static final int VALUE_TYPE_FLOAT = 0;
  private static final int VALUE_TYPE_INT = 1;
  private static final int VALUE_TYPE_PATH = 2;
  private static final int VALUE_TYPE_UNDEFINED = 4;
  
  private static Animator createAnimatorFromXml(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, float paramFloat)
    throws XmlPullParserException, IOException
  {
    return createAnimatorFromXml(paramContext, paramResources, paramTheme, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser), null, 0, paramFloat);
  }
  
  private static Animator createAnimatorFromXml(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, AnimatorSet paramAnimatorSet, int paramInt, float paramFloat)
    throws XmlPullParserException, IOException
  {
    int k = paramXmlPullParser.getDepth();
    Object localObject3 = null;
    Object localObject2 = null;
    int j;
    int i;
    for (;;)
    {
      int m = paramXmlPullParser.next();
      j = 0;
      i = 0;
      if (((m == 3) && (paramXmlPullParser.getDepth() <= k)) || (m == 1)) {
        break label342;
      }
      if (m == 2)
      {
        Object localObject1 = paramXmlPullParser.getName();
        if (((String)localObject1).equals("objectAnimator")) {
          localObject1 = loadObjectAnimator(paramContext, paramResources, paramTheme, paramAttributeSet, paramFloat, paramXmlPullParser);
        }
        for (;;)
        {
          break;
          if (((String)localObject1).equals("animator"))
          {
            localObject1 = loadAnimator(paramContext, paramResources, paramTheme, paramAttributeSet, null, paramFloat, paramXmlPullParser);
          }
          else if (((String)localObject1).equals("set"))
          {
            localObject1 = new AnimatorSet();
            localObject3 = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_ANIMATOR_SET);
            j = TypedArrayUtils.getNamedInt((TypedArray)localObject3, paramXmlPullParser, "ordering", 0, 0);
            createAnimatorFromXml(paramContext, paramResources, paramTheme, paramXmlPullParser, paramAttributeSet, (AnimatorSet)localObject1, j, paramFloat);
            ((TypedArray)localObject3).recycle();
          }
          else
          {
            if (!((String)localObject1).equals("propertyValuesHolder")) {
              break label304;
            }
            localObject1 = loadValues(paramContext, paramResources, paramTheme, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser));
            if ((localObject1 != null) && (localObject3 != null) && ((localObject3 instanceof ValueAnimator))) {
              ((ValueAnimator)localObject3).setValues((PropertyValuesHolder[])localObject1);
            }
            i = 1;
            localObject1 = localObject3;
          }
        }
        localObject3 = localObject1;
        if (paramAnimatorSet != null)
        {
          localObject3 = localObject1;
          if (i == 0)
          {
            Object localObject4 = localObject2;
            if (localObject2 == null) {
              localObject4 = new ArrayList();
            }
            ((ArrayList)localObject4).add(localObject1);
            localObject3 = localObject1;
            localObject2 = localObject4;
          }
        }
      }
    }
    label304:
    paramContext = new StringBuilder();
    paramContext.append("Unknown animator name: ");
    paramContext.append(paramXmlPullParser.getName());
    throw new RuntimeException(paramContext.toString());
    label342:
    if ((paramAnimatorSet != null) && (localObject2 != null))
    {
      paramContext = new Animator[((ArrayList)localObject2).size()];
      paramResources = ((ArrayList)localObject2).iterator();
      i = j;
      while (paramResources.hasNext())
      {
        paramContext[i] = ((Animator)paramResources.next());
        i += 1;
      }
      if (paramInt == 0)
      {
        paramAnimatorSet.playTogether(paramContext);
        return (Animator)localObject3;
      }
      paramAnimatorSet.playSequentially(paramContext);
    }
    return (Animator)localObject3;
  }
  
  private static Keyframe createNewKeyframe(Keyframe paramKeyframe, float paramFloat)
  {
    if (paramKeyframe.getType() == Float.TYPE) {
      return Keyframe.ofFloat(paramFloat);
    }
    if (paramKeyframe.getType() == Integer.TYPE) {
      return Keyframe.ofInt(paramFloat);
    }
    return Keyframe.ofObject(paramFloat);
  }
  
  private static void distributeKeyframes(Keyframe[] paramArrayOfKeyframe, float paramFloat, int paramInt1, int paramInt2)
  {
    paramFloat /= (paramInt2 - paramInt1 + 2);
    while (paramInt1 <= paramInt2)
    {
      paramArrayOfKeyframe[paramInt1].setFraction(paramArrayOfKeyframe[(paramInt1 - 1)].getFraction() + paramFloat);
      paramInt1 += 1;
    }
  }
  
  private static void dumpKeyframes(Object[] paramArrayOfObject, String paramString)
  {
    if (paramArrayOfObject != null)
    {
      if (paramArrayOfObject.length == 0) {
        return;
      }
      Log.d("AnimatorInflater", paramString);
      int j = paramArrayOfObject.length;
      int i = 0;
      while (i < j)
      {
        Keyframe localKeyframe = (Keyframe)paramArrayOfObject[i];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Keyframe ");
        localStringBuilder.append(i);
        localStringBuilder.append(": fraction ");
        if (localKeyframe.getFraction() < 0.0F) {
          paramString = "null";
        } else {
          paramString = Float.valueOf(localKeyframe.getFraction());
        }
        localStringBuilder.append(paramString);
        localStringBuilder.append(", ");
        localStringBuilder.append(", value : ");
        if (localKeyframe.hasValue()) {
          paramString = localKeyframe.getValue();
        } else {
          paramString = "null";
        }
        localStringBuilder.append(paramString);
        Log.d("AnimatorInflater", localStringBuilder.toString());
        i += 1;
      }
      return;
    }
  }
  
  private static PropertyValuesHolder getPVH(TypedArray paramTypedArray, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Object localObject1 = paramTypedArray.peekValue(paramInt2);
    int j;
    if (localObject1 != null) {
      j = 1;
    } else {
      j = 0;
    }
    int m;
    if (j != 0) {
      m = ((TypedValue)localObject1).type;
    } else {
      m = 0;
    }
    localObject1 = paramTypedArray.peekValue(paramInt3);
    int k;
    if (localObject1 != null) {
      k = 1;
    } else {
      k = 0;
    }
    int n;
    if (k != 0) {
      n = ((TypedValue)localObject1).type;
    } else {
      n = 0;
    }
    int i = paramInt1;
    if (paramInt1 == 4) {
      if (((j != 0) && (isColorType(m))) || ((k != 0) && (isColorType(n)))) {
        i = 3;
      } else {
        i = 0;
      }
    }
    if (i == 0) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    localObject1 = null;
    String str = null;
    Object localObject2;
    if (i == 2)
    {
      localObject2 = paramTypedArray.getString(paramInt2);
      str = paramTypedArray.getString(paramInt3);
      PathParser.PathDataNode[] arrayOfPathDataNode1 = PathParser.createNodesFromPathData((String)localObject2);
      PathParser.PathDataNode[] arrayOfPathDataNode2 = PathParser.createNodesFromPathData(str);
      if (arrayOfPathDataNode1 == null)
      {
        paramTypedArray = (TypedArray)localObject1;
        if (arrayOfPathDataNode2 == null) {}
      }
      else
      {
        if (arrayOfPathDataNode1 != null)
        {
          paramTypedArray = new PathDataEvaluator();
          if (arrayOfPathDataNode2 != null)
          {
            if (PathParser.canMorph(arrayOfPathDataNode1, arrayOfPathDataNode2))
            {
              paramTypedArray = PropertyValuesHolder.ofObject(paramString, paramTypedArray, new Object[] { arrayOfPathDataNode1, arrayOfPathDataNode2 });
            }
            else
            {
              paramTypedArray = new StringBuilder();
              paramTypedArray.append(" Can't morph from ");
              paramTypedArray.append((String)localObject2);
              paramTypedArray.append(" to ");
              paramTypedArray.append(str);
              throw new InflateException(paramTypedArray.toString());
            }
          }
          else {
            paramTypedArray = PropertyValuesHolder.ofObject(paramString, paramTypedArray, new Object[] { arrayOfPathDataNode1 });
          }
          return paramTypedArray;
        }
        paramTypedArray = (TypedArray)localObject1;
        if (arrayOfPathDataNode2 != null) {
          return PropertyValuesHolder.ofObject(paramString, new PathDataEvaluator(), new Object[] { arrayOfPathDataNode2 });
        }
      }
    }
    else
    {
      if (i == 3) {
        localObject2 = ArgbEvaluator.getInstance();
      } else {
        localObject2 = null;
      }
      if (paramInt1 != 0)
      {
        float f1;
        if (j != 0)
        {
          if (m == 5) {
            f1 = paramTypedArray.getDimension(paramInt2, 0.0F);
          } else {
            f1 = paramTypedArray.getFloat(paramInt2, 0.0F);
          }
          if (k != 0)
          {
            float f2;
            if (n == 5) {
              f2 = paramTypedArray.getDimension(paramInt3, 0.0F);
            } else {
              f2 = paramTypedArray.getFloat(paramInt3, 0.0F);
            }
            paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1, f2 });
          }
          else
          {
            paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1 });
          }
        }
        else
        {
          if (n == 5) {
            f1 = paramTypedArray.getDimension(paramInt3, 0.0F);
          } else {
            f1 = paramTypedArray.getFloat(paramInt3, 0.0F);
          }
          paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1 });
        }
        localObject1 = paramTypedArray;
      }
      else if (j != 0)
      {
        if (m == 5) {
          paramInt1 = (int)paramTypedArray.getDimension(paramInt2, 0.0F);
        } else if (isColorType(m)) {
          paramInt1 = paramTypedArray.getColor(paramInt2, 0);
        } else {
          paramInt1 = paramTypedArray.getInt(paramInt2, 0);
        }
        if (k != 0)
        {
          if (n == 5) {
            paramInt2 = (int)paramTypedArray.getDimension(paramInt3, 0.0F);
          } else if (isColorType(n)) {
            paramInt2 = paramTypedArray.getColor(paramInt3, 0);
          } else {
            paramInt2 = paramTypedArray.getInt(paramInt3, 0);
          }
          localObject1 = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1, paramInt2 });
        }
        else
        {
          localObject1 = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1 });
        }
      }
      else
      {
        localObject1 = str;
        if (k != 0)
        {
          if (n == 5) {
            paramInt1 = (int)paramTypedArray.getDimension(paramInt3, 0.0F);
          } else if (isColorType(n)) {
            paramInt1 = paramTypedArray.getColor(paramInt3, 0);
          } else {
            paramInt1 = paramTypedArray.getInt(paramInt3, 0);
          }
          localObject1 = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1 });
        }
      }
      paramTypedArray = (TypedArray)localObject1;
      if (localObject1 != null)
      {
        paramTypedArray = (TypedArray)localObject1;
        if (localObject2 != null)
        {
          ((PropertyValuesHolder)localObject1).setEvaluator((TypeEvaluator)localObject2);
          paramTypedArray = (TypedArray)localObject1;
        }
      }
    }
    return paramTypedArray;
  }
  
  private static int inferValueTypeFromValues(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    TypedValue localTypedValue = paramTypedArray.peekValue(paramInt1);
    int j = 1;
    int k = 0;
    if (localTypedValue != null) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    int i;
    if (paramInt1 != 0) {
      i = localTypedValue.type;
    } else {
      i = 0;
    }
    paramTypedArray = paramTypedArray.peekValue(paramInt2);
    if (paramTypedArray != null) {
      paramInt2 = j;
    } else {
      paramInt2 = 0;
    }
    if (paramInt2 != 0) {
      j = paramTypedArray.type;
    } else {
      j = 0;
    }
    if ((paramInt1 == 0) || (!isColorType(i)))
    {
      paramInt1 = k;
      if (paramInt2 != 0)
      {
        paramInt1 = k;
        if (!isColorType(j)) {}
      }
    }
    else
    {
      paramInt1 = 3;
    }
    return paramInt1;
  }
  
  private static int inferValueTypeOfKeyframe(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser)
  {
    paramResources = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_KEYFRAME);
    int k = 0;
    paramTheme = TypedArrayUtils.peekNamedValue(paramResources, paramXmlPullParser, "value", 0);
    int i;
    if (paramTheme != null) {
      i = 1;
    } else {
      i = 0;
    }
    int j = k;
    if (i != 0)
    {
      j = k;
      if (isColorType(paramTheme.type)) {
        j = 3;
      }
    }
    paramResources.recycle();
    return j;
  }
  
  private static boolean isColorType(int paramInt)
  {
    return (paramInt >= 28) && (paramInt <= 31);
  }
  
  public static Animator loadAnimator(Context paramContext, @AnimatorRes int paramInt)
    throws Resources.NotFoundException
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return AnimatorInflater.loadAnimator(paramContext, paramInt);
    }
    return loadAnimator(paramContext, paramContext.getResources(), paramContext.getTheme(), paramInt);
  }
  
  public static Animator loadAnimator(Context paramContext, Resources paramResources, Resources.Theme paramTheme, @AnimatorRes int paramInt)
    throws Resources.NotFoundException
  {
    return loadAnimator(paramContext, paramResources, paramTheme, paramInt, 1.0F);
  }
  
  /* Error */
  public static Animator loadAnimator(Context paramContext, Resources paramResources, Resources.Theme paramTheme, @AnimatorRes int paramInt, float paramFloat)
    throws Resources.NotFoundException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 5
    //   9: aload_1
    //   10: iload_3
    //   11: invokevirtual 362	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   14: astore 6
    //   16: aload_0
    //   17: aload_1
    //   18: aload_2
    //   19: aload 6
    //   21: fload 4
    //   23: invokestatic 364	android/support/graphics/drawable/AnimatorInflaterCompat:createAnimatorFromXml	(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;F)Landroid/animation/Animator;
    //   26: astore_0
    //   27: aload 6
    //   29: ifnull +10 -> 39
    //   32: aload 6
    //   34: invokeinterface 369 1 0
    //   39: aload_0
    //   40: areturn
    //   41: astore_0
    //   42: aload 6
    //   44: astore 5
    //   46: goto +151 -> 197
    //   49: astore_1
    //   50: aload 6
    //   52: astore_0
    //   53: goto +18 -> 71
    //   56: astore_1
    //   57: aload 6
    //   59: astore_0
    //   60: goto +74 -> 134
    //   63: astore_0
    //   64: goto +133 -> 197
    //   67: astore_1
    //   68: aload 7
    //   70: astore_0
    //   71: aload_0
    //   72: astore 5
    //   74: new 131	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   81: astore_2
    //   82: aload_0
    //   83: astore 5
    //   85: aload_2
    //   86: ldc_w 371
    //   89: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_0
    //   94: astore 5
    //   96: aload_2
    //   97: iload_3
    //   98: invokestatic 374	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   101: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_0
    //   106: astore 5
    //   108: new 329	android/content/res/Resources$NotFoundException
    //   111: dup
    //   112: aload_2
    //   113: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokespecial 375	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   119: astore_2
    //   120: aload_0
    //   121: astore 5
    //   123: aload_2
    //   124: aload_1
    //   125: invokevirtual 379	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   128: pop
    //   129: aload_0
    //   130: astore 5
    //   132: aload_2
    //   133: athrow
    //   134: aload_0
    //   135: astore 5
    //   137: new 131	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   144: astore_2
    //   145: aload_0
    //   146: astore 5
    //   148: aload_2
    //   149: ldc_w 371
    //   152: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_0
    //   157: astore 5
    //   159: aload_2
    //   160: iload_3
    //   161: invokestatic 374	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   164: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_0
    //   169: astore 5
    //   171: new 329	android/content/res/Resources$NotFoundException
    //   174: dup
    //   175: aload_2
    //   176: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokespecial 375	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   182: astore_2
    //   183: aload_0
    //   184: astore 5
    //   186: aload_2
    //   187: aload_1
    //   188: invokevirtual 379	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   191: pop
    //   192: aload_0
    //   193: astore 5
    //   195: aload_2
    //   196: athrow
    //   197: aload 5
    //   199: ifnull +10 -> 209
    //   202: aload 5
    //   204: invokeinterface 369 1 0
    //   209: aload_0
    //   210: athrow
    //   211: astore_1
    //   212: aload 8
    //   214: astore_0
    //   215: goto -81 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramContext	Context
    //   0	218	1	paramResources	Resources
    //   0	218	2	paramTheme	Resources.Theme
    //   0	218	3	paramInt	int
    //   0	218	4	paramFloat	float
    //   7	196	5	localObject1	Object
    //   14	44	6	localXmlResourceParser	android.content.res.XmlResourceParser
    //   1	68	7	localObject2	Object
    //   4	209	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   16	27	41	finally
    //   16	27	49	java/io/IOException
    //   16	27	56	org/xmlpull/v1/XmlPullParserException
    //   9	16	63	finally
    //   74	82	63	finally
    //   85	93	63	finally
    //   96	105	63	finally
    //   108	120	63	finally
    //   123	129	63	finally
    //   132	134	63	finally
    //   137	145	63	finally
    //   148	156	63	finally
    //   159	168	63	finally
    //   171	183	63	finally
    //   186	192	63	finally
    //   195	197	63	finally
    //   9	16	67	java/io/IOException
    //   9	16	211	org/xmlpull/v1/XmlPullParserException
  }
  
  private static ValueAnimator loadAnimator(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, ValueAnimator paramValueAnimator, float paramFloat, XmlPullParser paramXmlPullParser)
    throws Resources.NotFoundException
  {
    TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_ANIMATOR);
    paramTheme = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_PROPERTY_ANIMATOR);
    paramResources = paramValueAnimator;
    if (paramValueAnimator == null) {
      paramResources = new ValueAnimator();
    }
    parseAnimatorFromTypeArray(paramResources, localTypedArray, paramTheme, paramFloat, paramXmlPullParser);
    int i = TypedArrayUtils.getNamedResourceId(localTypedArray, paramXmlPullParser, "interpolator", 0, 0);
    if (i > 0) {
      paramResources.setInterpolator(AnimationUtilsCompat.loadInterpolator(paramContext, i));
    }
    localTypedArray.recycle();
    if (paramTheme != null) {
      paramTheme.recycle();
    }
    return paramResources;
  }
  
  private static Keyframe loadKeyframe(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int paramInt, XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException
  {
    paramTheme = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_KEYFRAME);
    float f = TypedArrayUtils.getNamedFloat(paramTheme, paramXmlPullParser, "fraction", 3, -1.0F);
    paramResources = TypedArrayUtils.peekNamedValue(paramTheme, paramXmlPullParser, "value", 0);
    int j;
    if (paramResources != null) {
      j = 1;
    } else {
      j = 0;
    }
    int i = paramInt;
    if (paramInt == 4) {
      if ((j != 0) && (isColorType(paramResources.type))) {
        i = 3;
      } else {
        i = 0;
      }
    }
    if (j != 0)
    {
      if (i != 3) {
        switch (i)
        {
        default: 
          paramResources = null;
          break;
        case 0: 
          paramResources = Keyframe.ofFloat(f, TypedArrayUtils.getNamedFloat(paramTheme, paramXmlPullParser, "value", 0, 0.0F));
          break;
        }
      } else {
        paramResources = Keyframe.ofInt(f, TypedArrayUtils.getNamedInt(paramTheme, paramXmlPullParser, "value", 0, 0));
      }
    }
    else if (i == 0) {
      paramResources = Keyframe.ofFloat(f);
    } else {
      paramResources = Keyframe.ofInt(f);
    }
    paramInt = TypedArrayUtils.getNamedResourceId(paramTheme, paramXmlPullParser, "interpolator", 1, 0);
    if (paramInt > 0) {
      paramResources.setInterpolator(AnimationUtilsCompat.loadInterpolator(paramContext, paramInt));
    }
    paramTheme.recycle();
    return paramResources;
  }
  
  private static ObjectAnimator loadObjectAnimator(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, float paramFloat, XmlPullParser paramXmlPullParser)
    throws Resources.NotFoundException
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator();
    loadAnimator(paramContext, paramResources, paramTheme, paramAttributeSet, localObjectAnimator, paramFloat, paramXmlPullParser);
    return localObjectAnimator;
  }
  
  private static PropertyValuesHolder loadPvh(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, String paramString, int paramInt)
    throws XmlPullParserException, IOException
  {
    Object localObject3 = null;
    Object localObject1 = null;
    int j = paramInt;
    for (;;)
    {
      paramInt = paramXmlPullParser.next();
      if ((paramInt == 3) || (paramInt == 1)) {
        break;
      }
      if (paramXmlPullParser.getName().equals("keyframe"))
      {
        paramInt = j;
        if (j == 4) {
          paramInt = inferValueTypeOfKeyframe(paramResources, paramTheme, Xml.asAttributeSet(paramXmlPullParser), paramXmlPullParser);
        }
        Keyframe localKeyframe = loadKeyframe(paramContext, paramResources, paramTheme, Xml.asAttributeSet(paramXmlPullParser), paramInt, paramXmlPullParser);
        Object localObject2 = localObject1;
        if (localKeyframe != null)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add(localKeyframe);
        }
        paramXmlPullParser.next();
        j = paramInt;
        localObject1 = localObject2;
      }
    }
    paramContext = (Context)localObject3;
    if (localObject1 != null)
    {
      int k = ((ArrayList)localObject1).size();
      paramContext = (Context)localObject3;
      if (k > 0)
      {
        int i = 0;
        paramContext = (Keyframe)((ArrayList)localObject1).get(0);
        paramResources = (Keyframe)((ArrayList)localObject1).get(k - 1);
        float f = paramResources.getFraction();
        paramInt = k;
        if (f < 1.0F) {
          if (f < 0.0F)
          {
            paramResources.setFraction(1.0F);
            paramInt = k;
          }
          else
          {
            ((ArrayList)localObject1).add(((ArrayList)localObject1).size(), createNewKeyframe(paramResources, 1.0F));
            paramInt = k + 1;
          }
        }
        f = paramContext.getFraction();
        k = paramInt;
        if (f != 0.0F) {
          if (f < 0.0F)
          {
            paramContext.setFraction(0.0F);
            k = paramInt;
          }
          else
          {
            ((ArrayList)localObject1).add(0, createNewKeyframe(paramContext, 0.0F));
            k = paramInt + 1;
          }
        }
        paramContext = new Keyframe[k];
        ((ArrayList)localObject1).toArray(paramContext);
        paramInt = i;
        while (paramInt < k)
        {
          paramResources = paramContext[paramInt];
          if (paramResources.getFraction() < 0.0F) {
            if (paramInt == 0)
            {
              paramResources.setFraction(0.0F);
            }
            else
            {
              int n = k - 1;
              if (paramInt == n)
              {
                paramResources.setFraction(1.0F);
              }
              else
              {
                i = paramInt + 1;
                int m = paramInt;
                while ((i < n) && (paramContext[i].getFraction() < 0.0F))
                {
                  m = i;
                  i += 1;
                }
                distributeKeyframes(paramContext, paramContext[(m + 1)].getFraction() - paramContext[(paramInt - 1)].getFraction(), paramInt, m);
              }
            }
          }
          paramInt += 1;
        }
        paramResources = PropertyValuesHolder.ofKeyframe(paramString, paramContext);
        paramContext = paramResources;
        if (j == 3)
        {
          paramResources.setEvaluator(ArgbEvaluator.getInstance());
          paramContext = paramResources;
        }
      }
    }
    return paramContext;
  }
  
  private static PropertyValuesHolder[] loadValues(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
    throws XmlPullParserException, IOException
  {
    Object localObject4 = null;
    Object localObject1 = null;
    int j;
    int i;
    for (;;)
    {
      j = paramXmlPullParser.getEventType();
      i = 0;
      if ((j == 3) || (j == 1)) {
        break;
      }
      if (j != 2)
      {
        paramXmlPullParser.next();
      }
      else
      {
        if (paramXmlPullParser.getName().equals("propertyValuesHolder"))
        {
          TypedArray localTypedArray = TypedArrayUtils.obtainAttributes(paramResources, paramTheme, paramAttributeSet, AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER);
          String str = TypedArrayUtils.getNamedString(localTypedArray, paramXmlPullParser, "propertyName", 3);
          i = TypedArrayUtils.getNamedInt(localTypedArray, paramXmlPullParser, "valueType", 2, 4);
          Object localObject2 = loadPvh(paramContext, paramResources, paramTheme, paramXmlPullParser, str, i);
          Object localObject3 = localObject2;
          if (localObject2 == null) {
            localObject3 = getPVH(localTypedArray, i, 0, 1, str);
          }
          localObject2 = localObject1;
          if (localObject3 != null)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localObject3);
          }
          localTypedArray.recycle();
          localObject1 = localObject2;
        }
        paramXmlPullParser.next();
      }
    }
    paramContext = (Context)localObject4;
    if (localObject1 != null)
    {
      j = ((ArrayList)localObject1).size();
      paramResources = new PropertyValuesHolder[j];
      for (;;)
      {
        paramContext = paramResources;
        if (i >= j) {
          break;
        }
        paramResources[i] = ((PropertyValuesHolder)((ArrayList)localObject1).get(i));
        i += 1;
      }
    }
    return paramContext;
  }
  
  private static void parseAnimatorFromTypeArray(ValueAnimator paramValueAnimator, TypedArray paramTypedArray1, TypedArray paramTypedArray2, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    long l1 = TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "duration", 1, 300);
    long l2 = TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "startOffset", 2, 0);
    int j = TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "valueType", 7, 4);
    int k = j;
    if (TypedArrayUtils.hasAttribute(paramXmlPullParser, "valueFrom"))
    {
      k = j;
      if (TypedArrayUtils.hasAttribute(paramXmlPullParser, "valueTo"))
      {
        int i = j;
        if (j == 4) {
          i = inferValueTypeFromValues(paramTypedArray1, 5, 6);
        }
        PropertyValuesHolder localPropertyValuesHolder = getPVH(paramTypedArray1, i, 5, 6, "");
        k = i;
        if (localPropertyValuesHolder != null)
        {
          paramValueAnimator.setValues(new PropertyValuesHolder[] { localPropertyValuesHolder });
          k = i;
        }
      }
    }
    paramValueAnimator.setDuration(l1);
    paramValueAnimator.setStartDelay(l2);
    paramValueAnimator.setRepeatCount(TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "repeatCount", 3, 0));
    paramValueAnimator.setRepeatMode(TypedArrayUtils.getNamedInt(paramTypedArray1, paramXmlPullParser, "repeatMode", 4, 1));
    if (paramTypedArray2 != null) {
      setupObjectAnimator(paramValueAnimator, paramTypedArray2, k, paramFloat, paramXmlPullParser);
    }
  }
  
  private static void setupObjectAnimator(ValueAnimator paramValueAnimator, TypedArray paramTypedArray, int paramInt, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    paramValueAnimator = (ObjectAnimator)paramValueAnimator;
    String str1 = TypedArrayUtils.getNamedString(paramTypedArray, paramXmlPullParser, "pathData", 1);
    if (str1 != null)
    {
      String str2 = TypedArrayUtils.getNamedString(paramTypedArray, paramXmlPullParser, "propertyXName", 2);
      paramXmlPullParser = TypedArrayUtils.getNamedString(paramTypedArray, paramXmlPullParser, "propertyYName", 3);
      if ((paramInt == 2) || ((str2 == null) && (paramXmlPullParser == null)))
      {
        paramValueAnimator = new StringBuilder();
        paramValueAnimator.append(paramTypedArray.getPositionDescription());
        paramValueAnimator.append(" propertyXName or propertyYName is needed for PathData");
        throw new InflateException(paramValueAnimator.toString());
      }
      setupPathMotion(PathParser.createPathFromPathData(str1), paramValueAnimator, paramFloat * 0.5F, str2, paramXmlPullParser);
      return;
    }
    paramValueAnimator.setPropertyName(TypedArrayUtils.getNamedString(paramTypedArray, paramXmlPullParser, "propertyName", 0));
  }
  
  private static void setupPathMotion(Path paramPath, ObjectAnimator paramObjectAnimator, float paramFloat, String paramString1, String paramString2)
  {
    PathMeasure localPathMeasure = new PathMeasure(paramPath, false);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Float.valueOf(0.0F));
    float f1 = 0.0F;
    float f2;
    do
    {
      f2 = f1 + localPathMeasure.getLength();
      localArrayList.add(Float.valueOf(f2));
      f1 = f2;
    } while (localPathMeasure.nextContour());
    paramPath = new PathMeasure(paramPath, false);
    int n = Math.min(100, (int)(f2 / paramFloat) + 1);
    float[] arrayOfFloat2 = new float[n];
    float[] arrayOfFloat1 = new float[n];
    float[] arrayOfFloat3 = new float[2];
    f1 = f2 / (n - 1);
    int i = 0;
    paramFloat = 0.0F;
    int k;
    for (int j = 0;; j = k)
    {
      localPathMeasure = null;
      if (i >= n) {
        break;
      }
      paramPath.getPosTan(paramFloat - ((Float)localArrayList.get(j)).floatValue(), arrayOfFloat3, null);
      arrayOfFloat2[i] = arrayOfFloat3[0];
      arrayOfFloat1[i] = arrayOfFloat3[1];
      paramFloat += f1;
      int m = j + 1;
      k = j;
      if (m < localArrayList.size())
      {
        k = j;
        if (paramFloat > ((Float)localArrayList.get(m)).floatValue())
        {
          paramPath.nextContour();
          k = m;
        }
      }
      i += 1;
    }
    if (paramString1 != null) {
      paramPath = PropertyValuesHolder.ofFloat(paramString1, arrayOfFloat2);
    } else {
      paramPath = null;
    }
    paramString1 = localPathMeasure;
    if (paramString2 != null) {
      paramString1 = PropertyValuesHolder.ofFloat(paramString2, arrayOfFloat1);
    }
    if (paramPath == null)
    {
      paramObjectAnimator.setValues(new PropertyValuesHolder[] { paramString1 });
      return;
    }
    if (paramString1 == null)
    {
      paramObjectAnimator.setValues(new PropertyValuesHolder[] { paramPath });
      return;
    }
    paramObjectAnimator.setValues(new PropertyValuesHolder[] { paramPath, paramString1 });
  }
  
  private static class PathDataEvaluator
    implements TypeEvaluator<PathParser.PathDataNode[]>
  {
    private PathParser.PathDataNode[] mNodeArray;
    
    PathDataEvaluator() {}
    
    PathDataEvaluator(PathParser.PathDataNode[] paramArrayOfPathDataNode)
    {
      this.mNodeArray = paramArrayOfPathDataNode;
    }
    
    public PathParser.PathDataNode[] evaluate(float paramFloat, PathParser.PathDataNode[] paramArrayOfPathDataNode1, PathParser.PathDataNode[] paramArrayOfPathDataNode2)
    {
      if (PathParser.canMorph(paramArrayOfPathDataNode1, paramArrayOfPathDataNode2))
      {
        if ((this.mNodeArray == null) || (!PathParser.canMorph(this.mNodeArray, paramArrayOfPathDataNode1))) {
          this.mNodeArray = PathParser.deepCopyNodes(paramArrayOfPathDataNode1);
        }
        int i = 0;
        while (i < paramArrayOfPathDataNode1.length)
        {
          this.mNodeArray[i].interpolatePathDataNode(paramArrayOfPathDataNode1[i], paramArrayOfPathDataNode2[i], paramFloat);
          i += 1;
        }
        return this.mNodeArray;
      }
      throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\graphics\drawable\AnimatorInflaterCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */