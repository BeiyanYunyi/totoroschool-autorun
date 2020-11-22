package com.pgyersdk.feedback.a;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.pgyersdk.c.a;
import com.pgyersdk.c.b;
import com.pgyersdk.f.k;
import com.pgyersdk.feedback.FeedbackActivity;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class r
  extends AsyncTask<Void, Void, HashMap<String, String>>
{
  private Context a;
  private Handler b;
  private String c;
  private String d;
  private List<String> e;
  private File f;
  private ProgressDialog g;
  private boolean h;
  private String i;
  private String j;
  
  public r(Context paramContext, String paramString1, String paramString2, String paramString3, List<String> paramList, File paramFile, Handler paramHandler, String paramString4)
  {
    this.a = paramContext;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramList;
    this.f = paramFile;
    this.b = paramHandler;
    this.h = true;
    this.i = paramString1;
    this.j = paramString4;
    if (paramContext != null) {
      a.c(paramContext);
    }
  }
  
  /* Error */
  private HashMap<String, String> a()
  {
    // Byte code:
    //   0: new 59	java/util/HashMap
    //   3: dup
    //   4: invokespecial 60	java/util/HashMap:<init>	()V
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_3
    //   11: invokestatic 65	com/pgyersdk/a/a:b	()Ljava/util/Map;
    //   14: astore_2
    //   15: aload_2
    //   16: ldc 67
    //   18: aload_0
    //   19: getfield 34	com/pgyersdk/feedback/a/r:d	Ljava/lang/String;
    //   22: invokeinterface 73 3 0
    //   27: pop
    //   28: aload_2
    //   29: ldc 75
    //   31: aload_0
    //   32: getfield 44	com/pgyersdk/feedback/a/r:i	Ljava/lang/String;
    //   35: invokeinterface 73 3 0
    //   40: pop
    //   41: aload_2
    //   42: ldc 77
    //   44: aload_0
    //   45: getfield 46	com/pgyersdk/feedback/a/r:j	Ljava/lang/String;
    //   48: invokeinterface 73 3 0
    //   53: pop
    //   54: new 79	java/util/ArrayList
    //   57: dup
    //   58: invokespecial 80	java/util/ArrayList:<init>	()V
    //   61: astore 4
    //   63: aload_0
    //   64: getfield 36	com/pgyersdk/feedback/a/r:e	Ljava/util/List;
    //   67: invokeinterface 86 1 0
    //   72: astore 6
    //   74: aload 6
    //   76: invokeinterface 92 1 0
    //   81: istore_1
    //   82: iload_1
    //   83: ifeq +38 -> 121
    //   86: aload 4
    //   88: new 94	java/io/File
    //   91: dup
    //   92: aload 6
    //   94: invokeinterface 98 1 0
    //   99: checkcast 100	java/lang/String
    //   102: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: invokestatic 109	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   108: invokeinterface 113 2 0
    //   113: pop
    //   114: goto -40 -> 74
    //   117: astore_2
    //   118: goto +117 -> 235
    //   121: new 115	com/pgyersdk/f/d
    //   124: dup
    //   125: aload_0
    //   126: getfield 32	com/pgyersdk/feedback/a/r:c	Ljava/lang/String;
    //   129: invokespecial 116	com/pgyersdk/f/d:<init>	(Ljava/lang/String;)V
    //   132: astore 6
    //   134: aload 6
    //   136: ldc 118
    //   138: invokevirtual 121	com/pgyersdk/f/d:a	(Ljava/lang/String;)Lcom/pgyersdk/f/d;
    //   141: aload_2
    //   142: aload_0
    //   143: getfield 30	com/pgyersdk/feedback/a/r:a	Landroid/content/Context;
    //   146: aload_0
    //   147: getfield 38	com/pgyersdk/feedback/a/r:f	Ljava/io/File;
    //   150: aload 4
    //   152: invokevirtual 124	com/pgyersdk/f/d:a	(Ljava/util/Map;Landroid/content/Context;Ljava/io/File;Ljava/util/List;)Lcom/pgyersdk/f/d;
    //   155: invokevirtual 127	com/pgyersdk/f/d:a	()Ljava/net/HttpURLConnection;
    //   158: astore_2
    //   159: aload_2
    //   160: astore_3
    //   161: aload_2
    //   162: invokevirtual 132	java/net/HttpURLConnection:connect	()V
    //   165: aload_2
    //   166: astore_3
    //   167: aload 5
    //   169: ldc -122
    //   171: aload_2
    //   172: invokevirtual 138	java/net/HttpURLConnection:getResponseCode	()I
    //   175: invokestatic 142	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   178: invokevirtual 143	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   181: pop
    //   182: aload_2
    //   183: astore_3
    //   184: aload 5
    //   186: ldc -111
    //   188: aload_2
    //   189: invokestatic 150	com/pgyersdk/f/j:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   192: invokevirtual 143	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   195: pop
    //   196: aload_2
    //   197: ifnull +34 -> 231
    //   200: goto +27 -> 227
    //   203: astore 4
    //   205: goto +11 -> 216
    //   208: astore_2
    //   209: goto +26 -> 235
    //   212: astore 4
    //   214: aconst_null
    //   215: astore_2
    //   216: aload_2
    //   217: astore_3
    //   218: aload 4
    //   220: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   223: aload_2
    //   224: ifnull +7 -> 231
    //   227: aload_2
    //   228: invokevirtual 156	java/net/HttpURLConnection:disconnect	()V
    //   231: aload 5
    //   233: areturn
    //   234: astore_2
    //   235: aload_3
    //   236: ifnull +7 -> 243
    //   239: aload_3
    //   240: invokevirtual 156	java/net/HttpURLConnection:disconnect	()V
    //   243: aload_2
    //   244: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	r
    //   81	2	1	bool	boolean
    //   14	28	2	localMap1	java.util.Map
    //   117	25	2	localMap2	java.util.Map
    //   158	39	2	localHttpURLConnection	java.net.HttpURLConnection
    //   208	1	2	localObject1	Object
    //   215	13	2	localObject2	Object
    //   234	10	2	localObject3	Object
    //   10	230	3	localObject4	Object
    //   61	90	4	localArrayList	java.util.ArrayList
    //   203	1	4	localException1	Exception
    //   212	7	4	localException2	Exception
    //   7	225	5	localHashMap	HashMap
    //   72	63	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   86	114	117	finally
    //   161	165	203	java/lang/Exception
    //   167	182	203	java/lang/Exception
    //   184	196	203	java/lang/Exception
    //   11	15	208	finally
    //   15	28	208	finally
    //   28	41	208	finally
    //   41	74	208	finally
    //   74	82	208	finally
    //   121	134	208	finally
    //   134	159	208	finally
    //   11	15	212	java/lang/Exception
    //   15	28	212	java/lang/Exception
    //   28	41	212	java/lang/Exception
    //   41	74	212	java/lang/Exception
    //   74	82	212	java/lang/Exception
    //   86	114	212	java/lang/Exception
    //   121	134	212	java/lang/Exception
    //   134	159	212	java/lang/Exception
    //   161	165	234	finally
    //   167	182	234	finally
    //   184	196	234	finally
    //   218	223	234	finally
  }
  
  protected HashMap<String, String> a(Void... paramVarArgs)
  {
    return a();
  }
  
  protected void a(HashMap<String, String> paramHashMap)
  {
    ProgressDialog localProgressDialog = this.g;
    if (localProgressDialog != null) {
      try
      {
        localProgressDialog.dismiss();
        this.g = null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    Object localObject = this.a;
    if ((localObject instanceof FeedbackActivity)) {
      ((Activity)localObject).finish();
    }
    try
    {
      localObject = (String)paramHashMap.get("response");
      paramHashMap = new Message();
      if (!k.a((String)localObject))
      {
        localObject = new JSONObject((String)localObject);
        if (((JSONObject)localObject).getInt("code") == 0) {
          paramHashMap.what = 20001;
        } else {
          paramHashMap.what = 20002;
        }
      }
      else
      {
        paramHashMap.what = 20002;
      }
      this.b.sendMessage(paramHashMap);
      return;
    }
    catch (Exception paramHashMap)
    {
      for (;;) {}
    }
    paramHashMap = new Message();
    paramHashMap.what = 20002;
    this.b.sendMessage(paramHashMap);
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  protected void onPreExecute()
  {
    String str = b.a(1061);
    ProgressDialog localProgressDialog = this.g;
    if (((localProgressDialog == null) || (!localProgressDialog.isShowing())) && (this.h)) {
      this.g = ProgressDialog.show(this.a, "", str, true, false);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\a\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */