package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;

public class er
  extends ContextThemeWrapper
{
  private static final String[] d = { "android.widget", "android.webkit", "android.app" };
  private Resources a = es.a();
  private LayoutInflater b;
  private ClassLoader c;
  private a e = new a();
  private LayoutInflater.Factory f = new LayoutInflater.Factory()
  {
    public View onCreateView(String paramAnonymousString, Context paramAnonymousContext, AttributeSet paramAnonymousAttributeSet)
    {
      return er.a(er.this, paramAnonymousString, paramAnonymousContext, paramAnonymousAttributeSet);
    }
  };
  
  public er(Context paramContext, int paramInt, ClassLoader paramClassLoader)
  {
    super(paramContext, paramInt);
    this.c = paramClassLoader;
  }
  
  /* Error */
  private final View a(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/amap/api/mapcore/util/er:e	Lcom/amap/api/mapcore/util/er$a;
    //   4: getfield 64	com/amap/api/mapcore/util/er$a:a	Ljava/util/HashSet;
    //   7: aload_1
    //   8: invokevirtual 70	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: getfield 43	com/amap/api/mapcore/util/er:e	Lcom/amap/api/mapcore/util/er$a;
    //   20: getfield 73	com/amap/api/mapcore/util/er$a:b	Ljava/util/HashMap;
    //   23: aload_1
    //   24: invokevirtual 79	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 81	java/lang/reflect/Constructor
    //   30: astore 7
    //   32: aload 7
    //   34: astore 6
    //   36: aload 7
    //   38: ifnonnull +227 -> 265
    //   41: aload_1
    //   42: ldc 83
    //   44: invokevirtual 86	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   47: ifeq +16 -> 63
    //   50: aload_0
    //   51: getfield 55	com/amap/api/mapcore/util/er:c	Ljava/lang/ClassLoader;
    //   54: aload_1
    //   55: invokevirtual 92	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   58: astore 6
    //   60: goto +95 -> 155
    //   63: getstatic 32	com/amap/api/mapcore/util/er:d	[Ljava/lang/String;
    //   66: astore 8
    //   68: aload 8
    //   70: arraylength
    //   71: istore 5
    //   73: iconst_0
    //   74: istore 4
    //   76: iload 4
    //   78: iload 5
    //   80: if_icmpge +72 -> 152
    //   83: aload 8
    //   85: iload 4
    //   87: aaload
    //   88: astore 6
    //   90: aload_0
    //   91: getfield 55	com/amap/api/mapcore/util/er:c	Ljava/lang/ClassLoader;
    //   94: astore 9
    //   96: new 94	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   103: astore 10
    //   105: aload 10
    //   107: aload 6
    //   109: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 10
    //   115: ldc 102
    //   117: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 10
    //   123: aload_1
    //   124: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 9
    //   130: aload 10
    //   132: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokevirtual 92	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   138: astore 6
    //   140: goto +15 -> 155
    //   143: iload 4
    //   145: iconst_1
    //   146: iadd
    //   147: istore 4
    //   149: goto -73 -> 76
    //   152: aconst_null
    //   153: astore 6
    //   155: aload 6
    //   157: ifnonnull +6 -> 163
    //   160: goto +33 -> 193
    //   163: aload 6
    //   165: ldc 108
    //   167: if_acmpne +6 -> 173
    //   170: goto +23 -> 193
    //   173: aload 6
    //   175: invokevirtual 114	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   178: astore 8
    //   180: aload_0
    //   181: getfield 55	com/amap/api/mapcore/util/er:c	Ljava/lang/ClassLoader;
    //   184: astore 9
    //   186: aload 8
    //   188: aload 9
    //   190: if_acmpeq +6 -> 196
    //   193: goto +12 -> 205
    //   196: iconst_1
    //   197: istore 4
    //   199: goto +9 -> 208
    //   202: aconst_null
    //   203: astore 6
    //   205: iconst_0
    //   206: istore 4
    //   208: iload 4
    //   210: ifne +17 -> 227
    //   213: aload_0
    //   214: getfield 43	com/amap/api/mapcore/util/er:e	Lcom/amap/api/mapcore/util/er$a;
    //   217: getfield 64	com/amap/api/mapcore/util/er$a:a	Ljava/util/HashSet;
    //   220: aload_1
    //   221: invokevirtual 117	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   224: pop
    //   225: aconst_null
    //   226: areturn
    //   227: aload 6
    //   229: iconst_2
    //   230: anewarray 110	java/lang/Class
    //   233: dup
    //   234: iconst_0
    //   235: ldc 119
    //   237: aastore
    //   238: dup
    //   239: iconst_1
    //   240: ldc 121
    //   242: aastore
    //   243: invokevirtual 125	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   246: astore 6
    //   248: aload_0
    //   249: getfield 43	com/amap/api/mapcore/util/er:e	Lcom/amap/api/mapcore/util/er$a;
    //   252: getfield 73	com/amap/api/mapcore/util/er$a:b	Ljava/util/HashMap;
    //   255: aload_1
    //   256: aload 6
    //   258: invokevirtual 129	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   261: pop
    //   262: goto +3 -> 265
    //   265: aload 6
    //   267: ifnull +26 -> 293
    //   270: aload 6
    //   272: iconst_2
    //   273: anewarray 131	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: aload_2
    //   279: aastore
    //   280: dup
    //   281: iconst_1
    //   282: aload_3
    //   283: aastore
    //   284: invokevirtual 135	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   287: checkcast 137	android/view/View
    //   290: astore_1
    //   291: aload_1
    //   292: areturn
    //   293: aconst_null
    //   294: areturn
    //   295: astore 6
    //   297: goto -95 -> 202
    //   300: astore 6
    //   302: goto -159 -> 143
    //   305: astore 8
    //   307: goto -102 -> 205
    //   310: astore_1
    //   311: aload 7
    //   313: astore 6
    //   315: goto -50 -> 265
    //   318: astore_1
    //   319: goto -57 -> 262
    //   322: astore_1
    //   323: aconst_null
    //   324: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	this	er
    //   0	325	1	paramString	String
    //   0	325	2	paramContext	Context
    //   0	325	3	paramAttributeSet	AttributeSet
    //   74	135	4	i	int
    //   71	10	5	j	int
    //   34	237	6	localObject1	Object
    //   295	1	6	localThrowable1	Throwable
    //   300	1	6	localThrowable2	Throwable
    //   313	1	6	localConstructor1	Constructor
    //   30	282	7	localConstructor2	Constructor
    //   66	121	8	localObject2	Object
    //   305	1	8	localThrowable3	Throwable
    //   94	95	9	localClassLoader	ClassLoader
    //   103	28	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   41	60	295	java/lang/Throwable
    //   63	73	295	java/lang/Throwable
    //   90	140	300	java/lang/Throwable
    //   173	186	305	java/lang/Throwable
    //   227	248	310	java/lang/Throwable
    //   248	262	318	java/lang/Throwable
    //   270	291	322	java/lang/Throwable
  }
  
  public Resources getResources()
  {
    if (this.a != null) {
      return this.a;
    }
    return super.getResources();
  }
  
  public Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (this.b == null)
      {
        paramString = (LayoutInflater)super.getSystemService(paramString);
        if (paramString != null) {
          this.b = paramString.cloneInContext(this);
        }
        this.b.setFactory(this.f);
        this.b = this.b.cloneInContext(this);
      }
      return this.b;
    }
    return super.getSystemService(paramString);
  }
  
  public class a
  {
    public HashSet<String> a = new HashSet();
    public HashMap<String, Constructor<?>> b = new HashMap();
    
    public a() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\er.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */