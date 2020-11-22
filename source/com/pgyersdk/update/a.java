package com.pgyersdk.update;

import android.os.AsyncTask;
import com.pgyersdk.c.b;
import com.pgyersdk.f.f;
import com.pgyersdk.f.m;
import com.pgyersdk.update.javabean.AppBean;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends AsyncTask<Void, String, HashMap<String, String>>
{
  protected UpdateManagerListener a;
  private boolean b;
  
  a(UpdateManagerListener paramUpdateManagerListener)
  {
    this.a = paramUpdateManagerListener;
  }
  
  private AppBean a(JSONObject paramJSONObject)
    throws JSONException
  {
    AppBean localAppBean = new AppBean();
    localAppBean.setDownloadURL(paramJSONObject.getString("downloadURL"));
    localAppBean.setVersionName(paramJSONObject.getString("version"));
    localAppBean.setReleaseNote(paramJSONObject.getString("releaseNote"));
    localAppBean.setVersionCode(paramJSONObject.getString("build"));
    localAppBean.setShouldForceToUpdate(Boolean.parseBoolean(paramJSONObject.getString("needForceUpdate")));
    return localAppBean;
  }
  
  /* Error */
  private HashMap<String, String> a()
  {
    // Byte code:
    //   0: new 68	java/util/HashMap
    //   3: dup
    //   4: invokespecial 69	java/util/HashMap:<init>	()V
    //   7: astore 6
    //   9: new 68	java/util/HashMap
    //   12: dup
    //   13: invokespecial 69	java/util/HashMap:<init>	()V
    //   16: astore_3
    //   17: aload_3
    //   18: ldc 71
    //   20: getstatic 77	com/pgyersdk/c/a:l	Ljava/lang/String;
    //   23: invokeinterface 83 3 0
    //   28: pop
    //   29: aload_3
    //   30: ldc 37
    //   32: getstatic 86	com/pgyersdk/c/a:d	Ljava/lang/String;
    //   35: invokeinterface 83 3 0
    //   40: pop
    //   41: aload_3
    //   42: ldc 47
    //   44: getstatic 88	com/pgyersdk/c/a:b	Ljava/lang/String;
    //   47: invokeinterface 83 3 0
    //   52: pop
    //   53: new 90	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   60: astore 4
    //   62: aload 4
    //   64: getstatic 97	android/os/Build$VERSION:SDK_INT	I
    //   67: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 4
    //   73: ldc 103
    //   75: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_3
    //   80: ldc 108
    //   82: aload 4
    //   84: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokeinterface 83 3 0
    //   92: pop
    //   93: aload_3
    //   94: ldc 114
    //   96: ldc 116
    //   98: invokeinterface 83 3 0
    //   103: pop
    //   104: new 118	com/pgyersdk/f/d
    //   107: dup
    //   108: ldc 120
    //   110: invokespecial 122	com/pgyersdk/f/d:<init>	(Ljava/lang/String;)V
    //   113: astore 4
    //   115: aload 4
    //   117: ldc 124
    //   119: invokevirtual 127	com/pgyersdk/f/d:a	(Ljava/lang/String;)Lcom/pgyersdk/f/d;
    //   122: aload_3
    //   123: getstatic 132	com/pgyersdk/PgyerProvider:a	Landroid/content/Context;
    //   126: aconst_null
    //   127: aconst_null
    //   128: invokevirtual 135	com/pgyersdk/f/d:a	(Ljava/util/Map;Landroid/content/Context;Ljava/io/File;Ljava/util/List;)Lcom/pgyersdk/f/d;
    //   131: invokevirtual 138	com/pgyersdk/f/d:a	()Ljava/net/HttpURLConnection;
    //   134: astore 4
    //   136: aload 4
    //   138: astore_3
    //   139: aload 4
    //   141: invokevirtual 144	java/net/HttpURLConnection:getResponseCode	()I
    //   144: istore_1
    //   145: iload_1
    //   146: sipush 202
    //   149: if_icmpeq +162 -> 311
    //   152: iload_1
    //   153: sipush 200
    //   156: if_icmpne +150 -> 306
    //   159: goto +152 -> 311
    //   162: aload 4
    //   164: astore_3
    //   165: aload_0
    //   166: iload_2
    //   167: putfield 146	com/pgyersdk/update/a:b	Z
    //   170: aload 4
    //   172: astore_3
    //   173: aload 6
    //   175: ldc -108
    //   177: aload 4
    //   179: invokevirtual 144	java/net/HttpURLConnection:getResponseCode	()I
    //   182: invokestatic 154	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   185: invokevirtual 155	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   188: pop
    //   189: aload 4
    //   191: astore_3
    //   192: aload 6
    //   194: ldc -99
    //   196: aload 4
    //   198: invokestatic 162	com/pgyersdk/f/j:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   201: invokevirtual 155	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   204: pop
    //   205: aload 4
    //   207: astore_3
    //   208: ldc -99
    //   210: aload 6
    //   212: ldc -99
    //   214: invokevirtual 166	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   217: checkcast 150	java/lang/String
    //   220: invokestatic 172	com/pgyersdk/f/f:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload 4
    //   225: ifnull +67 -> 292
    //   228: aload 4
    //   230: invokevirtual 175	java/net/HttpURLConnection:disconnect	()V
    //   233: aload 6
    //   235: areturn
    //   236: astore 4
    //   238: goto +57 -> 295
    //   241: astore 5
    //   243: goto +15 -> 258
    //   246: astore 4
    //   248: aconst_null
    //   249: astore_3
    //   250: goto +45 -> 295
    //   253: astore 5
    //   255: aconst_null
    //   256: astore 4
    //   258: aload 4
    //   260: astore_3
    //   261: aload_0
    //   262: getfield 16	com/pgyersdk/update/a:a	Lcom/pgyersdk/update/UpdateManagerListener;
    //   265: ifnull +17 -> 282
    //   268: aload 4
    //   270: astore_3
    //   271: aload_0
    //   272: getfield 16	com/pgyersdk/update/a:a	Lcom/pgyersdk/update/UpdateManagerListener;
    //   275: aload 5
    //   277: invokeinterface 181 2 0
    //   282: aload 4
    //   284: ifnull +8 -> 292
    //   287: aload 4
    //   289: invokevirtual 175	java/net/HttpURLConnection:disconnect	()V
    //   292: aload 6
    //   294: areturn
    //   295: aload_3
    //   296: ifnull +7 -> 303
    //   299: aload_3
    //   300: invokevirtual 175	java/net/HttpURLConnection:disconnect	()V
    //   303: aload 4
    //   305: athrow
    //   306: iconst_0
    //   307: istore_2
    //   308: goto -146 -> 162
    //   311: iconst_1
    //   312: istore_2
    //   313: goto -151 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	this	a
    //   144	13	1	i	int
    //   166	147	2	bool	boolean
    //   16	284	3	localObject1	Object
    //   60	169	4	localObject2	Object
    //   236	1	4	localObject3	Object
    //   246	1	4	localObject4	Object
    //   256	48	4	localObject5	Object
    //   241	1	5	localException1	Exception
    //   253	23	5	localException2	Exception
    //   7	286	6	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   139	145	236	finally
    //   165	170	236	finally
    //   173	189	236	finally
    //   192	205	236	finally
    //   208	223	236	finally
    //   261	268	236	finally
    //   271	282	236	finally
    //   139	145	241	java/lang/Exception
    //   165	170	241	java/lang/Exception
    //   173	189	241	java/lang/Exception
    //   192	205	241	java/lang/Exception
    //   208	223	241	java/lang/Exception
    //   9	17	246	finally
    //   17	29	246	finally
    //   29	41	246	finally
    //   41	53	246	finally
    //   53	71	246	finally
    //   71	93	246	finally
    //   93	104	246	finally
    //   104	115	246	finally
    //   115	136	246	finally
    //   9	17	253	java/lang/Exception
    //   17	29	253	java/lang/Exception
    //   29	41	253	java/lang/Exception
    //   41	53	253	java/lang/Exception
    //   53	71	253	java/lang/Exception
    //   71	93	253	java/lang/Exception
    //   93	104	253	java/lang/Exception
    //   104	115	253	java/lang/Exception
    //   115	136	253	java/lang/Exception
  }
  
  protected HashMap<String, String> a(Void... paramVarArgs)
  {
    if (!m.b())
    {
      this.a.checkUpdateFailed(new Exception(b.a(518)));
      f.a("PgyerSDK", "Check update failed");
    }
    return a();
  }
  
  protected void a(HashMap<String, String> paramHashMap)
  {
    if (!this.b)
    {
      paramHashMap = this.a;
      if (paramHashMap != null)
      {
        paramHashMap.checkUpdateFailed(new RuntimeException(b.a(517)));
        f.a("PgyerSDK", "Check update failed");
      }
      return;
    }
    paramHashMap = (String)paramHashMap.get("response");
    try
    {
      paramHashMap = new JSONObject(paramHashMap);
      paramHashMap = paramHashMap.getJSONObject("data");
      if (paramHashMap.getBoolean("updateDeny"))
      {
        this.a.checkUpdateFailed(new RuntimeException(b.a(517)));
        f.a("PgyerSDK", "Check update failed. Please go to wwww.pgyer.com to get more detail");
        return;
      }
      if (paramHashMap.getBoolean("haveNewVersion"))
      {
        paramHashMap = a(paramHashMap);
        if (this.a != null) {
          this.a.onUpdateAvailable(paramHashMap);
        }
        f.a("PgyerSDK", "There is a new version");
        return;
      }
      if (this.a != null) {
        this.a.onNoUpdateAvailable();
      }
      f.a("PgyerSDK", "It's the latest version");
      return;
    }
    catch (Exception paramHashMap)
    {
      localUpdateManagerListener = this.a;
      if (localUpdateManagerListener != null) {
        localUpdateManagerListener.checkUpdateFailed(paramHashMap);
      }
      f.a("PgyerSDK", "Please check you config of PGY SDK. ", paramHashMap);
      return;
    }
    catch (JSONException paramHashMap)
    {
      paramHashMap.printStackTrace();
      UpdateManagerListener localUpdateManagerListener = this.a;
      if (localUpdateManagerListener != null) {
        localUpdateManagerListener.checkUpdateFailed(paramHashMap);
      }
      f.a("PgyerSDK", "JSONException", paramHashMap);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\update\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */