package com.autonavi.base.amap.mapcore.maploader;

import android.content.Context;
import com.amap.api.mapcore.util.cw;
import com.amap.api.mapcore.util.dx;
import com.amap.api.mapcore.util.fk;
import com.amap.api.mapcore.util.fn;
import com.amap.api.mapcore.util.fp;
import com.amap.api.mapcore.util.fv;
import com.amap.api.mapcore.util.gk;
import com.amap.api.mapcore.util.hz;
import com.amap.api.mapcore.util.hz.a;
import com.autonavi.base.ae.gmap.GLMapEngine;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

public class AMapLoader
  implements hz.a
{
  private static final int GET_METHOD = 0;
  private static String mDiu;
  private hz downloadManager;
  private volatile boolean isCanceled = false;
  public boolean isFinish = false;
  ADataRequestParam mDataRequestParam;
  private int mEngineID = 0;
  GLMapEngine mGLMapEngine;
  private boolean mRequestCancel = false;
  
  public AMapLoader(int paramInt, GLMapEngine paramGLMapEngine, ADataRequestParam paramADataRequestParam)
  {
    this.mDataRequestParam = paramADataRequestParam;
    this.mEngineID = paramInt;
    this.mGLMapEngine = paramGLMapEngine;
    this.mRequestCancel = false;
  }
  
  private String generateQueryString(Context paramContext, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramString);
    paramString = fk.f(this.mGLMapEngine.getContext());
    try
    {
      str = URLEncoder.encode(paramString, "UTF-8");
      paramString = str;
    }
    catch (Throwable localThrowable)
    {
      String str;
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    localStringBuffer.append("&key=");
    localStringBuffer.append(paramString);
    paramString = sortReEncoderParams(localStringBuffer.toString());
    str = fn.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("&ts=");
    localStringBuilder.append(str);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("&scode=");
    localStringBuilder.append(fn.a(paramContext, str, paramString));
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuffer.append("&dip=");
    localStringBuffer.append("16300");
    return localStringBuffer.toString();
  }
  
  private String getEncodeRequestParams(String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private String sortReEncoderParams(String paramString)
  {
    Object localObject = paramString.split("&");
    Arrays.sort((Object[])localObject);
    StringBuffer localStringBuffer = new StringBuffer();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append(strReEncoder(localObject[i]));
      localStringBuffer.append("&");
      i += 1;
    }
    localObject = localStringBuffer.toString();
    if (((String)localObject).length() > 1) {
      return (String)((String)localObject).subSequence(0, ((String)localObject).length() - 1);
    }
    return paramString;
  }
  
  private String strReEncoder(String paramString)
  {
    if (paramString == null) {
      return paramString;
    }
    try
    {
      paramString = URLDecoder.decode(paramString, "utf-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      gk.c(paramString, "AbstractProtocalHandler", "strReEncoderException");
    }
    catch (UnsupportedEncodingException paramString)
    {
      gk.c(paramString, "AbstractProtocalHandler", "strReEncoder");
    }
    return "";
  }
  
  public void doCancel()
  {
    this.mRequestCancel = true;
    if ((this.downloadManager != null) && (!this.isCanceled))
    {
      try
      {
        synchronized (this.downloadManager)
        {
          this.isCanceled = true;
          this.downloadManager.a();
          this.mGLMapEngine.setMapLoaderToTask(this.mEngineID, this.mDataRequestParam.handler, null);
        }
      }
      catch (Throwable localThrowable)
      {
        gk.c(localThrowable, "AMapLoader", "doCancel");
        return;
      }
      throw localThrowable;
    }
  }
  
  /* Error */
  public void doRequest()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/autonavi/base/amap/mapcore/maploader/AMapLoader:mRequestCancel	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 43	com/autonavi/base/amap/mapcore/maploader/AMapLoader:mDataRequestParam	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader$ADataRequestParam;
    //   12: getfield 188	com/autonavi/base/amap/mapcore/maploader/AMapLoader$ADataRequestParam:requestBaseUrl	Ljava/lang/String;
    //   15: astore_3
    //   16: aload_0
    //   17: getfield 43	com/autonavi/base/amap/mapcore/maploader/AMapLoader:mDataRequestParam	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader$ADataRequestParam;
    //   20: getfield 191	com/autonavi/base/amap/mapcore/maploader/AMapLoader$ADataRequestParam:requestUrl	Ljava/lang/String;
    //   23: astore 4
    //   25: aload_3
    //   26: astore_2
    //   27: aload_3
    //   28: ldc -63
    //   30: invokevirtual 197	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   33: ifne +29 -> 62
    //   36: new 96	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   43: astore_2
    //   44: aload_2
    //   45: aload_3
    //   46: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_2
    //   51: ldc -63
    //   53: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_2
    //   58: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore_2
    //   62: aload 4
    //   64: ldc -57
    //   66: aload_0
    //   67: ldc -57
    //   69: invokespecial 201	com/autonavi/base/amap/mapcore/maploader/AMapLoader:getEncodeRequestParams	(Ljava/lang/String;)Ljava/lang/String;
    //   72: invokevirtual 202	java/lang/String:toString	()Ljava/lang/String;
    //   75: invokevirtual 205	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   78: astore_3
    //   79: aload_2
    //   80: ifnull +17 -> 97
    //   83: aload_2
    //   84: ldc -49
    //   86: invokevirtual 211	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   89: ifeq +8 -> 97
    //   92: iconst_1
    //   93: istore_1
    //   94: goto +5 -> 99
    //   97: iconst_0
    //   98: istore_1
    //   99: aload_0
    //   100: aload_3
    //   101: iload_1
    //   102: aload_0
    //   103: getfield 43	com/autonavi/base/amap/mapcore/maploader/AMapLoader:mDataRequestParam	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader$ADataRequestParam;
    //   106: getfield 214	com/autonavi/base/amap/mapcore/maploader/AMapLoader$ADataRequestParam:nRequestType	I
    //   109: invokevirtual 218	com/autonavi/base/amap/mapcore/maploader/AMapLoader:getRequestParams	(Ljava/lang/String;ZI)Ljava/lang/String;
    //   112: astore_3
    //   113: new 52	java/lang/StringBuffer
    //   116: dup
    //   117: invokespecial 133	java/lang/StringBuffer:<init>	()V
    //   120: astore 4
    //   122: aload_0
    //   123: getfield 43	com/autonavi/base/amap/mapcore/maploader/AMapLoader:mDataRequestParam	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader$ADataRequestParam;
    //   126: getfield 214	com/autonavi/base/amap/mapcore/maploader/AMapLoader$ADataRequestParam:nRequestType	I
    //   129: ifne +53 -> 182
    //   132: aload 4
    //   134: aload_3
    //   135: invokevirtual 81	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   138: pop
    //   139: new 96	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   146: astore 5
    //   148: aload 5
    //   150: ldc -36
    //   152: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 5
    //   158: invokestatic 226	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   161: invokevirtual 227	java/util/UUID:toString	()Ljava/lang/String;
    //   164: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 4
    //   170: aload 5
    //   172: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokevirtual 81	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   178: pop
    //   179: goto +43 -> 222
    //   182: new 96	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   189: astore 5
    //   191: aload 5
    //   193: ldc -27
    //   195: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 5
    //   201: invokestatic 226	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   204: invokevirtual 227	java/util/UUID:toString	()Ljava/lang/String;
    //   207: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 4
    //   213: aload 5
    //   215: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokevirtual 81	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   221: pop
    //   222: new 96	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   229: astore 5
    //   231: aload 5
    //   233: aload_2
    //   234: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 5
    //   240: aload_0
    //   241: aload_0
    //   242: getfield 45	com/autonavi/base/amap/mapcore/maploader/AMapLoader:mGLMapEngine	Lcom/autonavi/base/ae/gmap/GLMapEngine;
    //   245: invokevirtual 61	com/autonavi/base/ae/gmap/GLMapEngine:getContext	()Landroid/content/Context;
    //   248: aload 4
    //   250: invokevirtual 85	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   253: invokespecial 231	com/autonavi/base/amap/mapcore/maploader/AMapLoader:generateQueryString	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   256: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 5
    //   262: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: astore_2
    //   266: new 11	com/autonavi/base/amap/mapcore/maploader/AMapLoader$AMapGridDownloadRequest
    //   269: dup
    //   270: aload_0
    //   271: getfield 45	com/autonavi/base/amap/mapcore/maploader/AMapLoader:mGLMapEngine	Lcom/autonavi/base/ae/gmap/GLMapEngine;
    //   274: invokevirtual 61	com/autonavi/base/ae/gmap/GLMapEngine:getContext	()Landroid/content/Context;
    //   277: aload_2
    //   278: aload_0
    //   279: getfield 45	com/autonavi/base/amap/mapcore/maploader/AMapLoader:mGLMapEngine	Lcom/autonavi/base/ae/gmap/GLMapEngine;
    //   282: invokevirtual 234	com/autonavi/base/ae/gmap/GLMapEngine:getUserAgent	()Ljava/lang/String;
    //   285: invokespecial 237	com/autonavi/base/amap/mapcore/maploader/AMapLoader$AMapGridDownloadRequest:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   288: astore_2
    //   289: aload_2
    //   290: ldc -18
    //   292: invokevirtual 242	com/autonavi/base/amap/mapcore/maploader/AMapLoader$AMapGridDownloadRequest:setConnectionTimeout	(I)V
    //   295: aload_2
    //   296: ldc -18
    //   298: invokevirtual 245	com/autonavi/base/amap/mapcore/maploader/AMapLoader$AMapGridDownloadRequest:setSoTimeout	(I)V
    //   301: aload_0
    //   302: getfield 43	com/autonavi/base/amap/mapcore/maploader/AMapLoader:mDataRequestParam	Lcom/autonavi/base/amap/mapcore/maploader/AMapLoader$ADataRequestParam;
    //   305: getfield 214	com/autonavi/base/amap/mapcore/maploader/AMapLoader$ADataRequestParam:nRequestType	I
    //   308: ifne +6 -> 314
    //   311: goto +13 -> 324
    //   314: aload_2
    //   315: aload_3
    //   316: ldc 69
    //   318: invokevirtual 249	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   321: invokevirtual 253	com/autonavi/base/amap/mapcore/maploader/AMapLoader$AMapGridDownloadRequest:setPostEntityBytes	([B)V
    //   324: invokestatic 258	com/amap/api/maps/MapsInitializer:getProtocol	()I
    //   327: iconst_2
    //   328: if_icmpne +57 -> 385
    //   331: iconst_1
    //   332: istore_1
    //   333: goto +3 -> 336
    //   336: aload_0
    //   337: new 171	com/amap/api/mapcore/util/hz
    //   340: dup
    //   341: aload_2
    //   342: lconst_0
    //   343: ldc2_w 259
    //   346: iload_1
    //   347: invokespecial 263	com/amap/api/mapcore/util/hz:<init>	(Lcom/amap/api/mapcore/util/ic;JJZ)V
    //   350: putfield 169	com/autonavi/base/amap/mapcore/maploader/AMapLoader:downloadManager	Lcom/amap/api/mapcore/util/hz;
    //   353: aload_0
    //   354: getfield 169	com/autonavi/base/amap/mapcore/maploader/AMapLoader:downloadManager	Lcom/amap/api/mapcore/util/hz;
    //   357: aload_0
    //   358: invokevirtual 266	com/amap/api/mapcore/util/hz:a	(Lcom/amap/api/mapcore/util/hz$a;)V
    //   361: goto +13 -> 374
    //   364: astore_2
    //   365: goto +14 -> 379
    //   368: astore_2
    //   369: aload_0
    //   370: aload_2
    //   371: invokevirtual 270	com/autonavi/base/amap/mapcore/maploader/AMapLoader:onException	(Ljava/lang/Throwable;)V
    //   374: aload_0
    //   375: invokevirtual 272	com/autonavi/base/amap/mapcore/maploader/AMapLoader:doCancel	()V
    //   378: return
    //   379: aload_0
    //   380: invokevirtual 272	com/autonavi/base/amap/mapcore/maploader/AMapLoader:doCancel	()V
    //   383: aload_2
    //   384: athrow
    //   385: iconst_0
    //   386: istore_1
    //   387: goto -51 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	this	AMapLoader
    //   93	294	1	bool	boolean
    //   26	316	2	localObject1	Object
    //   364	1	2	localObject2	Object
    //   368	16	2	localThrowable	Throwable
    //   15	301	3	str	String
    //   23	226	4	localObject3	Object
    //   146	115	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   222	311	364	finally
    //   314	324	364	finally
    //   324	331	364	finally
    //   336	361	364	finally
    //   369	374	364	finally
    //   222	311	368	java/lang/Throwable
    //   314	324	368	java/lang/Throwable
    //   324	331	368	java/lang/Throwable
    //   336	361	368	java/lang/Throwable
  }
  
  public String getDeviceId(Context paramContext)
  {
    if (paramContext != null) {
      return fp.w(paramContext);
    }
    return null;
  }
  
  protected String getRequestParams(String paramString, boolean paramBoolean, int paramInt)
  {
    if (mDiu == null) {
      mDiu = getDeviceId(this.mGLMapEngine.getContext());
    }
    paramString = new StringBuffer(paramString);
    if (paramBoolean)
    {
      paramString.append("&channel=amap7&div=GNaviMap");
      paramString.append("&diu=");
      paramString.append(mDiu);
    }
    else
    {
      paramString.append("&channel=amapapi");
      paramString.append("&div=GNaviMap");
      paramString.append("&diu=");
      paramString.append(mDiu);
    }
    return paramString.toString();
  }
  
  public void onDownload(byte[] paramArrayOfByte, long paramLong)
  {
    if ((paramArrayOfByte != null) && (this.mGLMapEngine != null) && (this.mDataRequestParam != null)) {
      this.mGLMapEngine.receiveNetData(this.mEngineID, this.mDataRequestParam.handler, paramArrayOfByte, paramArrayOfByte.length);
    }
  }
  
  public void onException(Throwable paramThrowable)
  {
    if ((this.mGLMapEngine != null) && (this.mDataRequestParam != null)) {
      this.mGLMapEngine.netError(this.mEngineID, this.mDataRequestParam.handler, -1);
    }
    gk.c(paramThrowable, "AMapLoader", "download onException");
  }
  
  public void onFinish()
  {
    if ((this.mGLMapEngine != null) && (this.mDataRequestParam != null)) {
      this.mGLMapEngine.finishDownLoad(this.mEngineID, this.mDataRequestParam.handler);
    }
  }
  
  public void onStop()
  {
    if ((this.mGLMapEngine != null) && (this.mDataRequestParam != null)) {
      this.mGLMapEngine.netError(this.mEngineID, this.mDataRequestParam.handler, -1);
    }
  }
  
  public static class ADataRequestParam
  {
    public byte[] enCodeString;
    public long handler;
    public int nCompress;
    public int nRequestType;
    public String requestBaseUrl;
    public String requestUrl;
  }
  
  public static class AMapGridDownloadRequest
    extends cw
  {
    private final Context mContext;
    private byte[] postEntityBytes;
    private String sUrl;
    private String userAgent;
    
    public AMapGridDownloadRequest(Context paramContext, String paramString1, String paramString2)
    {
      this.mContext = paramContext;
      this.sUrl = paramString1;
      this.userAgent = paramString2;
    }
    
    public byte[] getEntityBytes()
    {
      return this.postEntityBytes;
    }
    
    public Map<String, String> getParams()
    {
      return null;
    }
    
    public Map<String, String> getRequestHead()
    {
      Object localObject1 = dx.e();
      if (localObject1 != null) {
        localObject1 = ((fv)localObject1).b();
      } else {
        localObject1 = null;
      }
      Object localObject2 = fk.f(this.mContext);
      try
      {
        localObject3 = URLEncoder.encode((String)localObject2, "UTF-8");
        localObject2 = localObject3;
      }
      catch (Throwable localThrowable)
      {
        Object localObject3;
        for (;;) {}
      }
      localObject3 = new Hashtable(16);
      ((Map)localObject3).put("User-Agent", this.userAgent);
      ((Map)localObject3).put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[] { localObject1, "3dmap" }));
      ((Map)localObject3).put("x-INFO", fn.a(this.mContext));
      ((Map)localObject3).put("key", localObject2);
      ((Map)localObject3).put("logversion", "2.1");
      return (Map<String, String>)localObject3;
    }
    
    public String getURL()
    {
      return this.sUrl;
    }
    
    public void setPostEntityBytes(byte[] paramArrayOfByte)
    {
      this.postEntityBytes = paramArrayOfByte;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\maploader\AMapLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */