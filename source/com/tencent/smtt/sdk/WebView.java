package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.d;
import com.tencent.smtt.utils.r;
import com.tencent.smtt.utils.w;
import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WebView
  extends FrameLayout
  implements View.OnLongClickListener
{
  public static final int GETPVERROR = -1;
  public static int NIGHT_MODE_ALPHA = 153;
  public static final int NIGHT_MODE_COLOR = -16777216;
  public static final int NORMAL_MODE_ALPHA = 255;
  public static final String SCHEME_GEO = "geo:0,0?q=";
  public static final String SCHEME_MAILTO = "mailto:";
  public static final String SCHEME_TEL = "tel:";
  private static final Lock c = new ReentrantLock();
  private static OutputStream d = null;
  private static Context j = null;
  private static w l;
  private static Method m;
  public static boolean mSysWebviewCreated;
  public static boolean mWebViewCreated = false;
  private static String p;
  private static Paint v;
  private static boolean w;
  int a = 0;
  private final String b = "WebView";
  private boolean e = false;
  private IX5WebViewBase f;
  private a g;
  private WebSettings h = null;
  private Context i = null;
  private boolean k = false;
  public WebViewCallbackClient mWebViewCallbackClient;
  private WebViewClient n = null;
  private WebChromeClient o = null;
  private final int q = 1;
  private final int r = 2;
  private final int s = 3;
  private final String t = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
  private final String u = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
  private Object x = null;
  private View.OnLongClickListener y = null;
  
  static
  {
    l = null;
    m = null;
    p = null;
    mSysWebviewCreated = false;
    v = null;
    w = true;
  }
  
  public WebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, false);
  }
  
  @TargetApi(11)
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, Map<String, Object> paramMap, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt);
    mWebViewCreated = true;
    if ((QbSdk.getIsSysWebViewForcedByOuter()) && (TbsShareManager.isThirdPartyApp(paramContext)))
    {
      this.i = paramContext;
      this.f = null;
      this.e = false;
      QbSdk.a(paramContext, "failed to createTBSWebview!");
      this.g = new a(paramContext, paramAttributeSet);
      CookieManager.getInstance().a(paramContext, true, false);
      CookieSyncManager.createInstance(this.i).startSync();
    }
    try
    {
      paramAttributeSet = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
      paramAttributeSet.setAccessible(true);
      ((Handler)paramAttributeSet.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new p());
      mSysWebviewCreated = true;
      CookieManager.getInstance().a();
      this.g.setFocusableInTouchMode(true);
      addView(this.g, new FrameLayout.LayoutParams(-1, -1));
      TbsLog.i("WebView", "SystemWebView Created Success! #3");
      TbsLog.e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
      TbsCoreLoadStat.getInstance().a(paramContext, 402, new Throwable());
      return;
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        TbsLog.setWriteLogJIT(true);
      } else {
        TbsLog.setWriteLogJIT(false);
      }
      TbsLog.initIfNeed(paramContext);
      if (paramContext != null)
      {
        if (l == null) {
          l = w.a(paramContext);
        }
        if (l.a)
        {
          TbsLog.e("WebView", "sys WebView: debug.conf force syswebview", true);
          QbSdk.a(paramContext, "debug.conf force syswebview!");
        }
        c(paramContext);
        this.i = paramContext;
        if (paramContext != null) {
          j = paramContext.getApplicationContext();
        }
        if ((this.e) && (!QbSdk.a))
        {
          this.f = bt.a().a(true).a(paramContext);
          if ((this.f != null) && (this.f.getView() != null))
          {
            TbsLog.i("WebView", "X5 WebView Created Success!!");
            this.f.getView().setFocusableInTouchMode(true);
            a(paramAttributeSet);
            addView(this.f.getView(), new FrameLayout.LayoutParams(-1, -1));
            this.f.setDownloadListener(new b(this, null, this.e));
            this.f.getX5WebViewExtension().setWebViewClientExtension(new bl(this, bt.a().a(true).k()));
          }
          else
          {
            TbsLog.e("WebView", "sys WebView: failed to createTBSWebview", true);
            this.f = null;
            this.e = false;
            QbSdk.a(paramContext, "failed to createTBSWebview!");
            c(paramContext);
            if (TbsShareManager.isThirdPartyApp(this.i)) {
              this.g = new a(paramContext, paramAttributeSet);
            } else {
              this.g = new a(paramContext);
            }
            TbsLog.i("WebView", "SystemWebView Created Success! #1");
            CookieManager.getInstance().a(paramContext, true, false);
            CookieManager.getInstance().a();
            this.g.setFocusableInTouchMode(true);
            addView(this.g, new FrameLayout.LayoutParams(-1, -1));
            try
            {
              if (Build.VERSION.SDK_INT >= 11)
              {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
              }
            }
            catch (Throwable paramAttributeSet)
            {
              paramAttributeSet.printStackTrace();
            }
            TbsLog.writeLogToDisk();
            am.a(paramContext);
          }
        }
        else
        {
          this.f = null;
          if (TbsShareManager.isThirdPartyApp(this.i)) {
            this.g = new a(paramContext, paramAttributeSet);
          } else {
            this.g = new a(paramContext);
          }
          TbsLog.i("WebView", "SystemWebView Created Success! #2");
          CookieManager.getInstance().a(paramContext, true, false);
          CookieManager.getInstance().a();
          this.g.setFocusableInTouchMode(true);
          addView(this.g, new FrameLayout.LayoutParams(-1, -1));
          setDownloadListener(null);
          TbsLog.writeLogToDisk();
          am.a(paramContext);
        }
        try
        {
          if (Build.VERSION.SDK_INT >= 11)
          {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
          }
        }
        catch (Throwable paramAttributeSet)
        {
          paramAttributeSet.printStackTrace();
        }
        if ((("com.tencent.mobileqq".equals(this.i.getApplicationInfo().packageName)) || ("com.tencent.mm".equals(this.i.getApplicationInfo().packageName))) && (o.a(true).i()) && (Build.VERSION.SDK_INT >= 11)) {
          setLayerType(1, null);
        }
        if (this.f != null)
        {
          TbsLog.writeLogToDisk();
          if (!TbsShareManager.isThirdPartyApp(paramContext))
          {
            paramInt = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
            if ((paramInt > 0) && (paramInt != am.a().i(paramContext)) && (paramInt == am.a().j(paramContext)))
            {
              am.a().o(paramContext);
            }
            else
            {
              paramAttributeSet = new StringBuilder();
              paramAttributeSet.append("webview construction #1 deCoupleCoreVersion is ");
              paramAttributeSet.append(paramInt);
              paramAttributeSet.append(" getTbsCoreShareDecoupleCoreVersion is ");
              paramAttributeSet.append(am.a().i(paramContext));
              paramAttributeSet.append(" getTbsCoreInstalledVerInNolock is ");
              paramAttributeSet.append(am.a().j(paramContext));
              TbsLog.i("WebView", paramAttributeSet.toString());
            }
          }
        }
        QbSdk.continueLoadSo(paramContext);
        return;
      }
      throw new IllegalArgumentException("Invalid context argument");
    }
    catch (Exception paramAttributeSet)
    {
      for (;;) {}
    }
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    this(paramContext, paramAttributeSet, paramInt, null, paramBoolean);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null) {
      try
      {
        int i2 = paramAttributeSet.getAttributeCount();
        int i1 = 0;
        while (i1 < i2)
        {
          if (paramAttributeSet.getAttributeName(i1).equalsIgnoreCase("scrollbars"))
          {
            Object localObject = getResources().getIntArray(16842974);
            int i3 = paramAttributeSet.getAttributeIntValue(i1, -1);
            if (i3 == localObject[1]) {
              this.f.getView().setVerticalScrollBarEnabled(false);
            }
            for (localObject = this.f.getView();; localObject = this.f.getView())
            {
              ((View)localObject).setHorizontalScrollBarEnabled(false);
              break;
              if (i3 == localObject[2])
              {
                this.f.getView().setVerticalScrollBarEnabled(false);
                break;
              }
              if (i3 != localObject[3]) {
                break;
              }
            }
          }
          i1 += 1;
        }
        return;
      }
      catch (Exception paramAttributeSet)
      {
        paramAttributeSet.printStackTrace();
      }
    }
  }
  
  private boolean a(View paramView)
  {
    if ((this.i != null) && (getTbsCoreVersion(this.i) > 36200)) {
      return false;
    }
    paramView = r.a(this.x, "onLongClick", new Class[] { View.class }, new Object[] { paramView });
    if (paramView != null) {
      return ((Boolean)paramView).booleanValue();
    }
    return false;
  }
  
  private boolean b(Context paramContext)
  {
    try
    {
      int i1 = paramContext.getPackageName().indexOf("com.tencent.mobileqq");
      if (i1 >= 0) {
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private void c(Context paramContext)
  {
    if ((QbSdk.i) && (TbsShareManager.isThirdPartyApp(paramContext))) {
      TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(paramContext);
    }
    bt localbt = bt.a();
    localbt.a(paramContext);
    this.e = localbt.b();
  }
  
  /* Error */
  private int d(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: ldc_w 583
    //   5: invokestatic 588	com/tencent/smtt/utils/k:b	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   8: astore 7
    //   10: aload 7
    //   12: ifnull +497 -> 509
    //   15: aload_1
    //   16: aload 7
    //   18: invokestatic 591	com/tencent/smtt/utils/k:a	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   21: astore 8
    //   23: aload 8
    //   25: ifnonnull +5 -> 30
    //   28: iconst_m1
    //   29: ireturn
    //   30: getstatic 88	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   33: invokeinterface 596 1 0
    //   38: ifeq +464 -> 502
    //   41: aconst_null
    //   42: astore 6
    //   44: aconst_null
    //   45: astore 5
    //   47: aload 5
    //   49: astore 4
    //   51: aload_1
    //   52: ldc_w 598
    //   55: iconst_0
    //   56: invokevirtual 602	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   59: astore_1
    //   60: aload 5
    //   62: astore 4
    //   64: new 466	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 467	java/lang/StringBuilder:<init>	()V
    //   71: astore 9
    //   73: aload 5
    //   75: astore 4
    //   77: aload 9
    //   79: aload_1
    //   80: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 5
    //   86: astore 4
    //   88: aload 9
    //   90: getstatic 610	java/io/File:separator	Ljava/lang/String;
    //   93: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 5
    //   99: astore 4
    //   101: aload 9
    //   103: ldc_w 612
    //   106: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 5
    //   112: astore 4
    //   114: new 607	java/io/File
    //   117: dup
    //   118: aload 9
    //   120: invokevirtual 484	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: ldc_w 614
    //   126: invokespecial 616	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: astore_1
    //   130: aload 5
    //   132: astore 4
    //   134: aload_1
    //   135: invokevirtual 619	java/io/File:exists	()Z
    //   138: istore_3
    //   139: iload_3
    //   140: ifne +20 -> 160
    //   143: getstatic 88	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   146: invokeinterface 622 1 0
    //   151: aload 8
    //   153: aload 7
    //   155: invokestatic 625	com/tencent/smtt/utils/k:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   158: iconst_m1
    //   159: ireturn
    //   160: aload 5
    //   162: astore 4
    //   164: new 627	java/util/Properties
    //   167: dup
    //   168: invokespecial 628	java/util/Properties:<init>	()V
    //   171: astore 9
    //   173: aload 5
    //   175: astore 4
    //   177: new 630	java/io/FileInputStream
    //   180: dup
    //   181: aload_1
    //   182: invokespecial 633	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   185: astore_1
    //   186: aload 9
    //   188: aload_1
    //   189: invokevirtual 637	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   192: aload_1
    //   193: invokevirtual 640	java/io/FileInputStream:close	()V
    //   196: aload 9
    //   198: ldc_w 642
    //   201: invokevirtual 646	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   204: astore 4
    //   206: aload 4
    //   208: ifnonnull +51 -> 259
    //   211: aload_1
    //   212: invokevirtual 640	java/io/FileInputStream:close	()V
    //   215: goto -72 -> 143
    //   218: astore 4
    //   220: new 466	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 467	java/lang/StringBuilder:<init>	()V
    //   227: astore_1
    //   228: aload_1
    //   229: ldc_w 648
    //   232: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_1
    //   237: aload 4
    //   239: invokevirtual 649	java/io/IOException:toString	()Ljava/lang/String;
    //   242: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: ldc_w 651
    //   249: aload_1
    //   250: invokevirtual 484	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 653	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: goto -113 -> 143
    //   259: aload 4
    //   261: invokestatic 658	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   264: istore_2
    //   265: aload_1
    //   266: invokevirtual 640	java/io/FileInputStream:close	()V
    //   269: goto +43 -> 312
    //   272: astore_1
    //   273: new 466	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 467	java/lang/StringBuilder:<init>	()V
    //   280: astore 4
    //   282: aload 4
    //   284: ldc_w 648
    //   287: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload 4
    //   293: aload_1
    //   294: invokevirtual 649	java/io/IOException:toString	()Ljava/lang/String;
    //   297: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: ldc_w 651
    //   304: aload 4
    //   306: invokevirtual 484	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 653	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: getstatic 88	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   315: invokeinterface 622 1 0
    //   320: aload 8
    //   322: aload 7
    //   324: invokestatic 625	com/tencent/smtt/utils/k:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   327: iload_2
    //   328: ireturn
    //   329: astore 5
    //   331: aload_1
    //   332: astore 4
    //   334: aload 5
    //   336: astore_1
    //   337: goto +93 -> 430
    //   340: astore 5
    //   342: goto +12 -> 354
    //   345: astore_1
    //   346: goto +84 -> 430
    //   349: astore 5
    //   351: aload 6
    //   353: astore_1
    //   354: aload_1
    //   355: astore 4
    //   357: new 466	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 467	java/lang/StringBuilder:<init>	()V
    //   364: astore 6
    //   366: aload_1
    //   367: astore 4
    //   369: aload 6
    //   371: ldc_w 660
    //   374: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload_1
    //   379: astore 4
    //   381: aload 6
    //   383: aload 5
    //   385: invokevirtual 661	java/lang/Exception:toString	()Ljava/lang/String;
    //   388: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload_1
    //   393: astore 4
    //   395: ldc_w 651
    //   398: aload 6
    //   400: invokevirtual 484	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 653	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   406: aload_1
    //   407: ifnull -264 -> 143
    //   410: aload_1
    //   411: invokevirtual 640	java/io/FileInputStream:close	()V
    //   414: goto -271 -> 143
    //   417: astore 4
    //   419: new 466	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 467	java/lang/StringBuilder:<init>	()V
    //   426: astore_1
    //   427: goto -199 -> 228
    //   430: aload 4
    //   432: ifnull +53 -> 485
    //   435: aload 4
    //   437: invokevirtual 640	java/io/FileInputStream:close	()V
    //   440: goto +45 -> 485
    //   443: astore 4
    //   445: new 466	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 467	java/lang/StringBuilder:<init>	()V
    //   452: astore 5
    //   454: aload 5
    //   456: ldc_w 648
    //   459: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload 5
    //   465: aload 4
    //   467: invokevirtual 649	java/io/IOException:toString	()Ljava/lang/String;
    //   470: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: ldc_w 651
    //   477: aload 5
    //   479: invokevirtual 484	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokestatic 653	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   485: getstatic 88	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   488: invokeinterface 622 1 0
    //   493: aload 8
    //   495: aload 7
    //   497: invokestatic 625	com/tencent/smtt/utils/k:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   500: aload_1
    //   501: athrow
    //   502: aload 8
    //   504: aload 7
    //   506: invokestatic 625	com/tencent/smtt/utils/k:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   509: iconst_m1
    //   510: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	this	WebView
    //   0	511	1	paramContext	Context
    //   264	64	2	i1	int
    //   138	2	3	bool	boolean
    //   49	158	4	localObject1	Object
    //   218	42	4	localIOException1	java.io.IOException
    //   280	114	4	localObject2	Object
    //   417	19	4	localIOException2	java.io.IOException
    //   443	23	4	localIOException3	java.io.IOException
    //   45	129	5	localObject3	Object
    //   329	6	5	localObject4	Object
    //   340	1	5	localException1	Exception
    //   349	35	5	localException2	Exception
    //   452	26	5	localStringBuilder1	StringBuilder
    //   42	357	6	localStringBuilder2	StringBuilder
    //   8	497	7	localFileOutputStream	java.io.FileOutputStream
    //   21	482	8	localFileLock	java.nio.channels.FileLock
    //   71	126	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   211	215	218	java/io/IOException
    //   265	269	272	java/io/IOException
    //   186	206	329	finally
    //   259	265	329	finally
    //   186	206	340	java/lang/Exception
    //   259	265	340	java/lang/Exception
    //   51	60	345	finally
    //   64	73	345	finally
    //   77	84	345	finally
    //   88	97	345	finally
    //   101	110	345	finally
    //   114	130	345	finally
    //   134	139	345	finally
    //   164	173	345	finally
    //   177	186	345	finally
    //   357	366	345	finally
    //   369	378	345	finally
    //   381	392	345	finally
    //   395	406	345	finally
    //   51	60	349	java/lang/Exception
    //   64	73	349	java/lang/Exception
    //   77	84	349	java/lang/Exception
    //   88	97	349	java/lang/Exception
    //   101	110	349	java/lang/Exception
    //   114	130	349	java/lang/Exception
    //   134	139	349	java/lang/Exception
    //   164	173	349	java/lang/Exception
    //   177	186	349	java/lang/Exception
    //   410	414	417	java/io/IOException
    //   435	440	443	java/io/IOException
  }
  
  static void d()
  {
    new bs().start();
  }
  
  @Deprecated
  public static void disablePlatformNotifications()
  {
    if (!bt.a().b()) {
      r.a("android.webkit.WebView", "disablePlatformNotifications");
    }
  }
  
  private void e(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getDir("tbs", 0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("core_private");
      paramContext = new File(localStringBuilder.toString(), "pv.db");
      if (!paramContext.exists()) {
        return;
      }
      paramContext.delete();
      return;
    }
    catch (Exception paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TbsInstaller--getTbsCorePV Exception=");
      localStringBuilder.append(paramContext.toString());
      TbsLog.i("getTbsCorePV", localStringBuilder.toString());
    }
  }
  
  @Deprecated
  public static void enablePlatformNotifications()
  {
    if (!bt.a().b()) {
      r.a("android.webkit.WebView", "enablePlatformNotifications");
    }
  }
  
  public static String findAddress(String paramString)
  {
    if (!bt.a().b()) {
      return android.webkit.WebView.findAddress(paramString);
    }
    return null;
  }
  
  public static String getCrashExtraMessage(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tbs_core_version:");
    localStringBuilder.append(QbSdk.getTbsVersionForCrash(paramContext));
    localStringBuilder.append(";");
    localStringBuilder.append("tbs_sdk_version:");
    localStringBuilder.append(43612);
    localStringBuilder.append(";");
    String str = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(o.a(true).f());
    localStringBuilder.append("\n");
    localStringBuilder.append(str);
    if ((!TbsShareManager.isThirdPartyApp(paramContext)) && (QbSdk.n != null) && (QbSdk.n.containsKey("weapp_id")) && (QbSdk.n.containsKey("weapp_name")))
    {
      paramContext = new StringBuilder();
      paramContext.append("weapp_id:");
      paramContext.append(QbSdk.n.get("weapp_id"));
      paramContext.append(";");
      paramContext.append("weapp_name");
      paramContext.append(":");
      paramContext.append(QbSdk.n.get("weapp_name"));
      paramContext.append(";");
      paramContext = paramContext.toString();
      localStringBuilder.append("\n");
      localStringBuilder.append(paramContext);
    }
    if (localStringBuilder.length() > 8192) {
      return localStringBuilder.substring(localStringBuilder.length() - 8192);
    }
    return localStringBuilder.toString();
  }
  
  public static PackageInfo getCurrentWebViewPackage()
  {
    if (!bt.a().b())
    {
      if (Build.VERSION.SDK_INT < 26) {
        return null;
      }
      try
      {
        PackageInfo localPackageInfo = (PackageInfo)r.a("android.webkit.WebView", "getCurrentWebViewPackage");
        return localPackageInfo;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return null;
  }
  
  @Deprecated
  public static Object getPluginList()
  {
    try
    {
      if (!bt.a().b())
      {
        Object localObject1 = r.a("android.webkit.WebView", "getPluginList");
        return localObject1;
      }
      return null;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public static int getTbsCoreVersion(Context paramContext)
  {
    return QbSdk.getTbsVersion(paramContext);
  }
  
  public static boolean getTbsNeedReboot()
  {
    d();
    return o.a(true).g();
  }
  
  public static int getTbsSDKVersion(Context paramContext)
  {
    return 43612;
  }
  
  private long h()
  {
    synchronized (QbSdk.h)
    {
      if (QbSdk.e)
      {
        QbSdk.g += System.currentTimeMillis() - QbSdk.f;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=");
        localStringBuilder.append(QbSdk.g);
        TbsLog.d("sdkreport", localStringBuilder.toString());
      }
      long l1 = QbSdk.g / 1000L;
      QbSdk.g = 0L;
      QbSdk.f = System.currentTimeMillis();
      return l1;
    }
  }
  
  public static void setSysDayOrNight(boolean paramBoolean)
  {
    try
    {
      boolean bool = w;
      if (paramBoolean == bool) {
        return;
      }
      w = paramBoolean;
      if (v == null)
      {
        v = new Paint();
        v.setColor(-16777216);
      }
      Paint localPaint;
      int i1;
      if (!paramBoolean)
      {
        if (v.getAlpha() != NIGHT_MODE_ALPHA)
        {
          localPaint = v;
          i1 = NIGHT_MODE_ALPHA;
        }
      }
      else {
        for (;;)
        {
          localPaint.setAlpha(i1);
          break;
          int i2 = v.getAlpha();
          i1 = 255;
          if (i2 == 255) {
            break;
          }
          localPaint = v;
        }
      }
      return;
    }
    finally {}
  }
  
  public static void setWebContentsDebuggingEnabled(boolean paramBoolean)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      localbt.c().a(paramBoolean);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      try
      {
        m = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", new Class[] { Boolean.TYPE });
        if (m != null)
        {
          m.setAccessible(true);
          m.invoke(null, new Object[] { Boolean.valueOf(paramBoolean) });
          return;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Exception:");
        localStringBuilder.append(localException.getStackTrace());
        TbsLog.e("QbSdk", localStringBuilder.toString());
        localException.printStackTrace();
      }
    }
  }
  
  protected void a()
  {
    if ((!this.k) && (this.a != 0))
    {
      this.k = true;
      String str4 = "";
      String str5 = "";
      String str6 = "";
      String str3 = str4;
      String str2 = str5;
      String str1 = str6;
      if (this.e)
      {
        Bundle localBundle = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo();
        str3 = str4;
        str2 = str5;
        str1 = str6;
        if (localBundle != null)
        {
          str3 = localBundle.getString("guid");
          str2 = localBundle.getString("qua2");
          str1 = localBundle.getString("lc");
        }
      }
      if ("com.qzone".equals(this.i.getApplicationInfo().packageName))
      {
        int i2 = d(this.i);
        int i1 = i2;
        if (i2 == -1) {
          i1 = this.a;
        }
        this.a = i1;
        e(this.i);
      }
      com.tencent.smtt.sdk.a.b.a(this.i, str3, str2, str1, this.a, this.e, h());
      this.a = 0;
      this.k = false;
    }
    super.onDetachedFromWindow();
  }
  
  /* Error */
  void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 827	com/tencent/smtt/sdk/WebView:d	(Landroid/content/Context;)I
    //   5: istore_2
    //   6: iload_2
    //   7: iconst_m1
    //   8: if_icmpeq +38 -> 46
    //   11: new 466	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 467	java/lang/StringBuilder:<init>	()V
    //   18: astore_3
    //   19: aload_3
    //   20: ldc_w 841
    //   23: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_3
    //   28: iload_2
    //   29: iconst_1
    //   30: iadd
    //   31: invokestatic 843	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   34: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_3
    //   39: invokevirtual 484	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore_3
    //   43: goto +7 -> 50
    //   46: ldc_w 845
    //   49: astore_3
    //   50: aload_1
    //   51: ldc_w 598
    //   54: iconst_0
    //   55: invokevirtual 602	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   58: astore_1
    //   59: new 466	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 467	java/lang/StringBuilder:<init>	()V
    //   66: astore 4
    //   68: aload 4
    //   70: aload_1
    //   71: invokevirtual 605	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 4
    //   77: getstatic 610	java/io/File:separator	Ljava/lang/String;
    //   80: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 4
    //   86: ldc_w 612
    //   89: invokevirtual 473	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: new 607	java/io/File
    //   96: dup
    //   97: aload 4
    //   99: invokevirtual 484	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: ldc_w 614
    //   105: invokespecial 616	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: astore_1
    //   109: aload_1
    //   110: invokevirtual 849	java/io/File:getParentFile	()Ljava/io/File;
    //   113: invokevirtual 852	java/io/File:mkdirs	()Z
    //   116: pop
    //   117: aload_1
    //   118: invokevirtual 855	java/io/File:isFile	()Z
    //   121: ifeq +10 -> 131
    //   124: aload_1
    //   125: invokevirtual 619	java/io/File:exists	()Z
    //   128: ifne +8 -> 136
    //   131: aload_1
    //   132: invokevirtual 858	java/io/File:createNewFile	()Z
    //   135: pop
    //   136: new 860	java/io/FileOutputStream
    //   139: dup
    //   140: aload_1
    //   141: iconst_0
    //   142: invokespecial 863	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   145: putstatic 90	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   148: getstatic 90	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   151: aload_3
    //   152: invokevirtual 867	java/lang/String:getBytes	()[B
    //   155: invokevirtual 873	java/io/OutputStream:write	([B)V
    //   158: getstatic 90	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   161: ifnull +25 -> 186
    //   164: getstatic 90	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   167: invokevirtual 876	java/io/OutputStream:flush	()V
    //   170: return
    //   171: astore_1
    //   172: getstatic 90	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   175: ifnull +9 -> 184
    //   178: getstatic 90	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   181: invokevirtual 876	java/io/OutputStream:flush	()V
    //   184: aload_1
    //   185: athrow
    //   186: return
    //   187: astore_1
    //   188: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	WebView
    //   0	189	1	paramContext	Context
    //   5	26	2	i1	int
    //   18	134	3	localObject	Object
    //   66	32	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   109	131	171	finally
    //   131	136	171	finally
    //   136	158	171	finally
    //   158	170	187	java/lang/Throwable
    //   172	184	187	java/lang/Throwable
    //   184	186	187	java/lang/Throwable
  }
  
  void a(android.webkit.WebView paramWebView)
  {
    boolean bool = this.e;
  }
  
  void a(IX5WebViewBase paramIX5WebViewBase)
  {
    this.f = paramIX5WebViewBase;
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    if (!this.e)
    {
      this.g.addJavascriptInterface(paramObject, paramString);
      return;
    }
    this.f.addJavascriptInterface(paramObject, paramString);
  }
  
  public void addView(View paramView)
  {
    if (!this.e)
    {
      this.g.addView(paramView);
      return;
    }
    View localView = this.f.getView();
    try
    {
      Method localMethod = r.a(localView, "addView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      return;
    }
    catch (Throwable paramView) {}
  }
  
  android.webkit.WebView b()
  {
    if (!this.e) {
      return this.g;
    }
    return null;
  }
  
  IX5WebViewBase c()
  {
    return this.f;
  }
  
  public boolean canGoBack()
  {
    if (!this.e) {
      return this.g.canGoBack();
    }
    return this.f.canGoBack();
  }
  
  public boolean canGoBackOrForward(int paramInt)
  {
    if (!this.e) {
      return this.g.canGoBackOrForward(paramInt);
    }
    return this.f.canGoBackOrForward(paramInt);
  }
  
  public boolean canGoForward()
  {
    if (!this.e) {
      return this.g.canGoForward();
    }
    return this.f.canGoForward();
  }
  
  @Deprecated
  public boolean canZoomIn()
  {
    if (!this.e)
    {
      int i1 = Build.VERSION.SDK_INT;
      boolean bool = false;
      if (i1 >= 11)
      {
        Object localObject = r.a(this.g, "canZoomIn");
        if (localObject == null) {
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
      }
      return bool;
    }
    return this.f.canZoomIn();
  }
  
  @Deprecated
  public boolean canZoomOut()
  {
    if (!this.e)
    {
      int i1 = Build.VERSION.SDK_INT;
      boolean bool = false;
      if (i1 >= 11)
      {
        Object localObject = r.a(this.g, "canZoomOut");
        if (localObject == null) {
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
      }
      return bool;
    }
    return this.f.canZoomOut();
  }
  
  @Deprecated
  public Picture capturePicture()
  {
    if (!this.e)
    {
      Object localObject = r.a(this.g, "capturePicture");
      if (localObject == null) {
        return null;
      }
      return (Picture)localObject;
    }
    return this.f.capturePicture();
  }
  
  public void clearCache(boolean paramBoolean)
  {
    if (!this.e)
    {
      this.g.clearCache(paramBoolean);
      return;
    }
    this.f.clearCache(paramBoolean);
  }
  
  public void clearFormData()
  {
    if (!this.e)
    {
      this.g.clearFormData();
      return;
    }
    this.f.clearFormData();
  }
  
  public void clearHistory()
  {
    if (!this.e)
    {
      this.g.clearHistory();
      return;
    }
    this.f.clearHistory();
  }
  
  @TargetApi(3)
  public void clearMatches()
  {
    if (!this.e)
    {
      this.g.clearMatches();
      return;
    }
    this.f.clearMatches();
  }
  
  public void clearSslPreferences()
  {
    if (!this.e)
    {
      this.g.clearSslPreferences();
      return;
    }
    this.f.clearSslPreferences();
  }
  
  @Deprecated
  public void clearView()
  {
    if (!this.e)
    {
      r.a(this.g, "clearView");
      return;
    }
    this.f.clearView();
  }
  
  public int computeHorizontalScrollExtent()
  {
    try
    {
      if (this.e)
      {
        localMethod = r.a(this.f.getView(), "computeHorizontalScrollExtent", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.f.getView(), null)).intValue();
      }
      Method localMethod = r.a(this.g, "computeHorizontalScrollExtent", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, null)).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public int computeHorizontalScrollOffset()
  {
    try
    {
      if (this.e)
      {
        localMethod = r.a(this.f.getView(), "computeHorizontalScrollOffset", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.f.getView(), null)).intValue();
      }
      Method localMethod = r.a(this.g, "computeHorizontalScrollOffset", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, null)).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public int computeHorizontalScrollRange()
  {
    try
    {
      if (this.e) {
        return ((Integer)r.a(this.f.getView(), "computeHorizontalScrollRange", new Class[0], new Object[0])).intValue();
      }
      Method localMethod = r.a(this.g, "computeHorizontalScrollRange", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, null)).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public void computeScroll()
  {
    if (!this.e)
    {
      this.g.computeScroll();
      return;
    }
    this.f.computeScroll();
  }
  
  public int computeVerticalScrollExtent()
  {
    try
    {
      if (this.e)
      {
        localMethod = r.a(this.f.getView(), "computeVerticalScrollExtent", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.f.getView(), null)).intValue();
      }
      Method localMethod = r.a(this.g, "computeVerticalScrollExtent", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, null)).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public int computeVerticalScrollOffset()
  {
    try
    {
      if (this.e)
      {
        localMethod = r.a(this.f.getView(), "computeVerticalScrollOffset", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.f.getView(), null)).intValue();
      }
      Method localMethod = r.a(this.g, "computeVerticalScrollOffset", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, null)).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public int computeVerticalScrollRange()
  {
    try
    {
      if (this.e) {
        return ((Integer)r.a(this.f.getView(), "computeVerticalScrollRange", new Class[0], new Object[0])).intValue();
      }
      Method localMethod = r.a(this.g, "computeVerticalScrollRange", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, null)).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public WebBackForwardList copyBackForwardList()
  {
    if (this.e) {
      return WebBackForwardList.a(this.f.copyBackForwardList());
    }
    return WebBackForwardList.a(this.g.copyBackForwardList());
  }
  
  public Object createPrintDocumentAdapter(String paramString)
  {
    if (this.e) {
      try
      {
        paramString = this.f.createPrintDocumentAdapter(paramString);
        return paramString;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    if (Build.VERSION.SDK_INT < 21) {
      return null;
    }
    return r.a(this.g, "createPrintDocumentAdapter", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public void customDiskCachePathEnabled(boolean paramBoolean, String paramString)
  {
    if ((this.e) && (getX5WebViewExtension() != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("enabled", paramBoolean);
      localBundle.putString("path", paramString);
      getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", localBundle);
    }
  }
  
  public void destroy()
  {
    try
    {
      if ("com.xunmeng.pinduoduo".equals(this.i.getApplicationInfo().packageName))
      {
        new bm(this, "WebviewDestroy").start();
        if (this.e)
        {
          this.f.destroy();
          return;
        }
        this.g.destroy();
        return;
      }
      tbsWebviewDestroy(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    tbsWebviewDestroy(true);
  }
  
  public void documentHasImages(Message paramMessage)
  {
    if (!this.e)
    {
      this.g.documentHasImages(paramMessage);
      return;
    }
    this.f.documentHasImages(paramMessage);
  }
  
  public void dumpViewHierarchyWithProperties(BufferedWriter paramBufferedWriter, int paramInt)
  {
    if (!this.e)
    {
      r.a(this.g, "dumpViewHierarchyWithProperties", new Class[] { BufferedWriter.class, Integer.TYPE }, new Object[] { paramBufferedWriter, Integer.valueOf(paramInt) });
      return;
    }
    this.f.dumpViewHierarchyWithProperties(paramBufferedWriter, paramInt);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    Method localMethod;
    if (this.e) {
      try
      {
        localMethod = r.a(this.f.getView(), "evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class });
        localMethod.setAccessible(true);
        localMethod.invoke(this.f.getView(), new Object[] { paramString, paramValueCallback });
        return;
      }
      catch (Exception paramValueCallback)
      {
        paramValueCallback.printStackTrace();
        loadUrl(paramString);
        return;
      }
    }
    if (Build.VERSION.SDK_INT >= 19) {
      try
      {
        localMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class });
        localMethod.setAccessible(true);
        localMethod.invoke(this.g, new Object[] { paramString, paramValueCallback });
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  @Deprecated
  public int findAll(String paramString)
  {
    if (!this.e)
    {
      paramString = r.a(this.g, "findAll", new Class[] { String.class }, new Object[] { paramString });
      if (paramString == null) {
        return 0;
      }
      return ((Integer)paramString).intValue();
    }
    return this.f.findAll(paramString);
  }
  
  @TargetApi(16)
  public void findAllAsync(String paramString)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        r.a(this.g, "findAllAsync", new Class[] { String.class }, new Object[] { paramString });
      }
    }
    else {
      this.f.findAllAsync(paramString);
    }
  }
  
  public View findHierarchyView(String paramString, int paramInt)
  {
    if (!this.e) {
      return (View)r.a(this.g, "findHierarchyView", new Class[] { String.class, Integer.TYPE }, new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    return this.f.findHierarchyView(paramString, paramInt);
  }
  
  @TargetApi(3)
  public void findNext(boolean paramBoolean)
  {
    if (!this.e)
    {
      this.g.findNext(paramBoolean);
      return;
    }
    this.f.findNext(paramBoolean);
  }
  
  public void flingScroll(int paramInt1, int paramInt2)
  {
    if (!this.e)
    {
      this.g.flingScroll(paramInt1, paramInt2);
      return;
    }
    this.f.flingScroll(paramInt1, paramInt2);
  }
  
  @Deprecated
  public void freeMemory()
  {
    if (!this.e)
    {
      r.a(this.g, "freeMemory");
      return;
    }
    this.f.freeMemory();
  }
  
  public SslCertificate getCertificate()
  {
    if (!this.e) {
      return this.g.getCertificate();
    }
    return this.f.getCertificate();
  }
  
  public int getContentHeight()
  {
    if (!this.e) {
      return this.g.getContentHeight();
    }
    return this.f.getContentHeight();
  }
  
  public int getContentWidth()
  {
    if (!this.e)
    {
      Object localObject = r.a(this.g, "getContentWidth");
      if (localObject == null) {
        return 0;
      }
      return ((Integer)localObject).intValue();
    }
    return this.f.getContentWidth();
  }
  
  public Bitmap getFavicon()
  {
    if (!this.e) {
      return this.g.getFavicon();
    }
    return this.f.getFavicon();
  }
  
  public HitTestResult getHitTestResult()
  {
    if (!this.e) {
      return new HitTestResult(this.g.getHitTestResult());
    }
    return new HitTestResult(this.f.getHitTestResult());
  }
  
  public String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    if (!this.e) {
      return this.g.getHttpAuthUsernamePassword(paramString1, paramString2);
    }
    return this.f.getHttpAuthUsernamePassword(paramString1, paramString2);
  }
  
  @TargetApi(3)
  public String getOriginalUrl()
  {
    if (!this.e) {
      return this.g.getOriginalUrl();
    }
    return this.f.getOriginalUrl();
  }
  
  public int getProgress()
  {
    if (!this.e) {
      return this.g.getProgress();
    }
    return this.f.getProgress();
  }
  
  public boolean getRendererPriorityWaivedWhenNotVisible()
  {
    boolean bool = false;
    try
    {
      if (!this.e)
      {
        if (Build.VERSION.SDK_INT < 26) {
          return false;
        }
        Object localObject = r.a(this.g, "getRendererPriorityWaivedWhenNotVisible");
        if (localObject == null) {
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
      }
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public int getRendererRequestedPriority()
  {
    int i1 = 0;
    try
    {
      if (!this.e)
      {
        if (Build.VERSION.SDK_INT < 26) {
          return 0;
        }
        Object localObject = r.a(this.g, "getRendererRequestedPriority");
        if (localObject == null) {
          return 0;
        }
        i1 = ((Integer)localObject).intValue();
      }
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  @Deprecated
  public float getScale()
  {
    if (!this.e)
    {
      Object localObject = r.a(this.g, "getScale");
      if (localObject == null) {
        return 0.0F;
      }
      return ((Float)localObject).floatValue();
    }
    return this.f.getScale();
  }
  
  public int getScrollBarDefaultDelayBeforeFade()
  {
    if (getView() == null) {
      return 0;
    }
    return getView().getScrollBarDefaultDelayBeforeFade();
  }
  
  public int getScrollBarFadeDuration()
  {
    if (getView() == null) {
      return 0;
    }
    return getView().getScrollBarFadeDuration();
  }
  
  public int getScrollBarSize()
  {
    if (getView() == null) {
      return 0;
    }
    return getView().getScrollBarSize();
  }
  
  public int getScrollBarStyle()
  {
    if (getView() == null) {
      return 0;
    }
    return getView().getScrollBarStyle();
  }
  
  public WebSettings getSettings()
  {
    if (this.h != null) {
      return this.h;
    }
    if (this.e) {}
    for (WebSettings localWebSettings = new WebSettings(this.f.getSettings());; localWebSettings = new WebSettings(this.g.getSettings()))
    {
      this.h = localWebSettings;
      return localWebSettings;
    }
  }
  
  public IX5WebSettingsExtension getSettingsExtension()
  {
    if (!this.e) {
      return null;
    }
    return this.f.getX5WebViewExtension().getSettingsExtension();
  }
  
  public int getSysNightModeAlpha()
  {
    return NIGHT_MODE_ALPHA;
  }
  
  public String getTitle()
  {
    if (!this.e) {
      return this.g.getTitle();
    }
    return this.f.getTitle();
  }
  
  public String getUrl()
  {
    if (!this.e) {
      return this.g.getUrl();
    }
    return this.f.getUrl();
  }
  
  public View getView()
  {
    if (!this.e) {
      return this.g;
    }
    return this.f.getView();
  }
  
  public int getVisibleTitleHeight()
  {
    if (!this.e)
    {
      Object localObject = r.a(this.g, "getVisibleTitleHeight");
      if (localObject == null) {
        return 0;
      }
      return ((Integer)localObject).intValue();
    }
    return this.f.getVisibleTitleHeight();
  }
  
  public WebChromeClient getWebChromeClient()
  {
    return this.o;
  }
  
  public IX5WebChromeClientExtension getWebChromeClientExtension()
  {
    if (!this.e) {
      return null;
    }
    return this.f.getX5WebViewExtension().getWebChromeClientExtension();
  }
  
  public int getWebScrollX()
  {
    if (this.e) {
      return this.f.getView().getScrollX();
    }
    return this.g.getScrollX();
  }
  
  public int getWebScrollY()
  {
    if (this.e) {
      return this.f.getView().getScrollY();
    }
    return this.g.getScrollY();
  }
  
  public WebViewClient getWebViewClient()
  {
    return this.n;
  }
  
  public IX5WebViewClientExtension getWebViewClientExtension()
  {
    if (!this.e) {
      return null;
    }
    return this.f.getX5WebViewExtension().getWebViewClientExtension();
  }
  
  public IX5WebViewBase.HitTestResult getX5HitTestResult()
  {
    if (!this.e) {
      return null;
    }
    return this.f.getHitTestResult();
  }
  
  public IX5WebViewExtension getX5WebViewExtension()
  {
    if (!this.e) {
      return null;
    }
    return this.f.getX5WebViewExtension();
  }
  
  @Deprecated
  public View getZoomControls()
  {
    if (!this.e) {
      return (View)r.a(this.g, "getZoomControls");
    }
    return this.f.getZoomControls();
  }
  
  public void goBack()
  {
    if (!this.e)
    {
      this.g.goBack();
      return;
    }
    this.f.goBack();
  }
  
  public void goBackOrForward(int paramInt)
  {
    if (!this.e)
    {
      this.g.goBackOrForward(paramInt);
      return;
    }
    this.f.goBackOrForward(paramInt);
  }
  
  public void goForward()
  {
    if (!this.e)
    {
      this.g.goForward();
      return;
    }
    this.f.goForward();
  }
  
  public void invokeZoomPicker()
  {
    if (!this.e)
    {
      this.g.invokeZoomPicker();
      return;
    }
    this.f.invokeZoomPicker();
  }
  
  public boolean isDayMode()
  {
    return w;
  }
  
  public boolean isPrivateBrowsingEnabled()
  {
    if (!this.e)
    {
      int i1 = Build.VERSION.SDK_INT;
      boolean bool = false;
      if (i1 >= 11)
      {
        Object localObject = r.a(this.g, "isPrivateBrowsingEnabled");
        if (localObject == null) {
          return false;
        }
        bool = ((Boolean)localObject).booleanValue();
      }
      return bool;
    }
    return this.f.isPrivateBrowsingEnable();
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    if (!this.e)
    {
      this.g.loadData(paramString1, paramString2, paramString3);
      return;
    }
    this.f.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!this.e)
    {
      this.g.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
      return;
    }
    this.f.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    boolean bool = this.e;
    if (paramString != null)
    {
      if (showDebugView(paramString)) {
        return;
      }
      if (!this.e)
      {
        this.g.loadUrl(paramString);
        return;
      }
      this.f.loadUrl(paramString);
    }
  }
  
  @TargetApi(8)
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    boolean bool = this.e;
    if (paramString != null)
    {
      if (showDebugView(paramString)) {
        return;
      }
      if (!this.e)
      {
        if (Build.VERSION.SDK_INT >= 8) {
          this.g.loadUrl(paramString, paramMap);
        }
      }
      else {
        this.f.loadUrl(paramString, paramMap);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    try
    {
      if ("com.xunmeng.pinduoduo".equals(this.i.getApplicationInfo().packageName))
      {
        new br(this, "onDetachedFromWindow").start();
        return;
      }
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    a();
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.y != null)
    {
      if (!this.y.onLongClick(paramView)) {
        return a(paramView);
      }
      return true;
    }
    return a(paramView);
  }
  
  public void onPause()
  {
    if (!this.e)
    {
      r.a(this.g, "onPause");
      return;
    }
    this.f.onPause();
  }
  
  public void onResume()
  {
    if (!this.e)
    {
      r.a(this.g, "onResume");
      return;
    }
    this.f.onResume();
  }
  
  @TargetApi(11)
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((Build.VERSION.SDK_INT >= 21) && (b(this.i)) && (isHardwareAccelerated()) && (paramInt1 > 0) && (paramInt2 > 0)) {
      getLayerType();
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (this.i == null)
    {
      super.onVisibilityChanged(paramView, paramInt);
      return;
    }
    if (p == null) {
      p = this.i.getApplicationInfo().packageName;
    }
    if ((p != null) && ((p.equals("com.tencent.mm")) || (p.equals("com.tencent.mobileqq"))))
    {
      super.onVisibilityChanged(paramView, paramInt);
      return;
    }
    if ((paramInt != 0) && (!this.k) && (this.a != 0))
    {
      this.k = true;
      String str4 = "";
      String str5 = "";
      String str6 = "";
      String str3 = str4;
      String str2 = str5;
      String str1 = str6;
      if (this.e)
      {
        Bundle localBundle = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo();
        str3 = str4;
        str2 = str5;
        str1 = str6;
        if (localBundle != null)
        {
          str3 = localBundle.getString("guid");
          str2 = localBundle.getString("qua2");
          str1 = localBundle.getString("lc");
        }
      }
      if ("com.qzone".equals(this.i.getApplicationInfo().packageName))
      {
        int i2 = d(this.i);
        int i1 = i2;
        if (i2 == -1) {
          i1 = this.a;
        }
        this.a = i1;
        e(this.i);
      }
      com.tencent.smtt.sdk.a.b.a(this.i, str3, str2, str1, this.a, this.e, h());
      this.a = 0;
      this.k = false;
    }
    super.onVisibilityChanged(paramView, paramInt);
  }
  
  public boolean overlayHorizontalScrollbar()
  {
    if (!this.e) {
      return this.g.overlayHorizontalScrollbar();
    }
    return this.f.overlayHorizontalScrollbar();
  }
  
  public boolean overlayVerticalScrollbar()
  {
    if (this.e) {
      return this.f.overlayVerticalScrollbar();
    }
    return this.g.overlayVerticalScrollbar();
  }
  
  public boolean pageDown(boolean paramBoolean)
  {
    if (!this.e) {
      return this.g.pageDown(paramBoolean);
    }
    return this.f.pageDown(paramBoolean, -1);
  }
  
  public boolean pageUp(boolean paramBoolean)
  {
    if (!this.e) {
      return this.g.pageUp(paramBoolean);
    }
    return this.f.pageUp(paramBoolean, -1);
  }
  
  public void pauseTimers()
  {
    if (!this.e)
    {
      this.g.pauseTimers();
      return;
    }
    this.f.pauseTimers();
  }
  
  @TargetApi(5)
  public void postUrl(String paramString, byte[] paramArrayOfByte)
  {
    if (!this.e)
    {
      this.g.postUrl(paramString, paramArrayOfByte);
      return;
    }
    this.f.postUrl(paramString, paramArrayOfByte);
  }
  
  @Deprecated
  public void refreshPlugins(boolean paramBoolean)
  {
    if (!this.e)
    {
      r.a(this.g, "refreshPlugins", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    this.f.refreshPlugins(paramBoolean);
  }
  
  public void reload()
  {
    if (!this.e)
    {
      this.g.reload();
      return;
    }
    this.f.reload();
  }
  
  @TargetApi(11)
  public void removeJavascriptInterface(String paramString)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        r.a(this.g, "removeJavascriptInterface", new Class[] { String.class }, new Object[] { paramString });
        return;
      }
      this.f.removeJavascriptInterface(paramString);
    }
  }
  
  public void removeView(View paramView)
  {
    if (!this.e)
    {
      this.g.removeView(paramView);
      return;
    }
    View localView = this.f.getView();
    try
    {
      Method localMethod = r.a(localView, "removeView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      return;
    }
    catch (Throwable paramView) {}
  }
  
  public void reportInitPerformance(long paramLong1, int paramInt, long paramLong2, long paramLong3) {}
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    if (this.e)
    {
      localObject2 = this.f.getView();
      if ((localObject2 instanceof ViewGroup))
      {
        ViewGroup localViewGroup = (ViewGroup)localObject2;
        localObject1 = paramView;
        if (paramView == this) {
          localObject1 = localObject2;
        }
        return localViewGroup.requestChildRectangleOnScreen((View)localObject1, paramRect, paramBoolean);
      }
      return false;
    }
    Object localObject2 = this.g;
    Object localObject1 = paramView;
    if (paramView == this) {
      localObject1 = this.g;
    }
    return ((android.webkit.WebView)localObject2).requestChildRectangleOnScreen((View)localObject1, paramRect, paramBoolean);
  }
  
  public void requestFocusNodeHref(Message paramMessage)
  {
    if (!this.e)
    {
      this.g.requestFocusNodeHref(paramMessage);
      return;
    }
    this.f.requestFocusNodeHref(paramMessage);
  }
  
  public void requestImageRef(Message paramMessage)
  {
    if (!this.e)
    {
      this.g.requestImageRef(paramMessage);
      return;
    }
    this.f.requestImageRef(paramMessage);
  }
  
  @Deprecated
  public boolean restorePicture(Bundle paramBundle, File paramFile)
  {
    if (!this.e)
    {
      paramBundle = r.a(this.g, "restorePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null) {
        return false;
      }
      return ((Boolean)paramBundle).booleanValue();
    }
    return this.f.restorePicture(paramBundle, paramFile);
  }
  
  public WebBackForwardList restoreState(Bundle paramBundle)
  {
    if (!this.e) {
      return WebBackForwardList.a(this.g.restoreState(paramBundle));
    }
    return WebBackForwardList.a(this.f.restoreState(paramBundle));
  }
  
  public void resumeTimers()
  {
    if (!this.e)
    {
      this.g.resumeTimers();
      return;
    }
    this.f.resumeTimers();
  }
  
  @Deprecated
  public void savePassword(String paramString1, String paramString2, String paramString3)
  {
    if (!this.e)
    {
      r.a(this.g, "savePassword", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
      return;
    }
    this.f.savePassword(paramString1, paramString2, paramString3);
  }
  
  @Deprecated
  public boolean savePicture(Bundle paramBundle, File paramFile)
  {
    if (!this.e)
    {
      paramBundle = r.a(this.g, "savePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null) {
        return false;
      }
      return ((Boolean)paramBundle).booleanValue();
    }
    return this.f.savePicture(paramBundle, paramFile);
  }
  
  public WebBackForwardList saveState(Bundle paramBundle)
  {
    if (!this.e) {
      return WebBackForwardList.a(this.g.saveState(paramBundle));
    }
    return WebBackForwardList.a(this.f.saveState(paramBundle));
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        r.a(this.g, "saveWebArchive", new Class[] { String.class }, new Object[] { paramString });
      }
    }
    else {
      this.f.saveWebArchive(paramString);
    }
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString, boolean paramBoolean, ValueCallback<String> paramValueCallback)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        r.a(this.g, "saveWebArchive", new Class[] { String.class, Boolean.TYPE, android.webkit.ValueCallback.class }, new Object[] { paramString, Boolean.valueOf(paramBoolean), paramValueCallback });
      }
    }
    else {
      this.f.saveWebArchive(paramString, paramBoolean, paramValueCallback);
    }
  }
  
  public void setARModeEnable(boolean paramBoolean)
  {
    try
    {
      if (this.e)
      {
        getSettingsExtension().setARModeEnable(paramBoolean);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (!this.e) {
      this.g.setBackgroundColor(paramInt);
    } else {
      this.f.setBackgroundColor(paramInt);
    }
    super.setBackgroundColor(paramInt);
  }
  
  @Deprecated
  public void setCertificate(SslCertificate paramSslCertificate)
  {
    if (!this.e)
    {
      this.g.setCertificate(paramSslCertificate);
      return;
    }
    this.f.setCertificate(paramSslCertificate);
  }
  
  public void setDayOrNight(boolean paramBoolean)
  {
    try
    {
      if (this.e) {
        getSettingsExtension().setDayOrNight(paramBoolean);
      }
      setSysDayOrNight(paramBoolean);
      getView().postInvalidate();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setDownloadListener(DownloadListener paramDownloadListener)
  {
    if (!this.e)
    {
      this.g.setDownloadListener(new bo(this, paramDownloadListener));
      return;
    }
    this.f.setDownloadListener(new b(this, paramDownloadListener, this.e));
  }
  
  @TargetApi(16)
  public void setFindListener(IX5WebViewBase.FindListener paramFindListener)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.g.setFindListener(new bn(this, paramFindListener));
      }
    }
    else {
      this.f.setFindListener(paramFindListener);
    }
  }
  
  public void setHorizontalScrollbarOverlay(boolean paramBoolean)
  {
    if (!this.e)
    {
      this.g.setHorizontalScrollbarOverlay(paramBoolean);
      return;
    }
    this.f.setHorizontalScrollbarOverlay(paramBoolean);
  }
  
  public void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!this.e)
    {
      this.g.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
      return;
    }
    this.f.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void setInitialScale(int paramInt)
  {
    if (!this.e)
    {
      this.g.setInitialScale(paramInt);
      return;
    }
    this.f.setInitialScale(paramInt);
  }
  
  @Deprecated
  public void setMapTrackballToArrowKeys(boolean paramBoolean)
  {
    if (!this.e)
    {
      r.a(this.g, "setMapTrackballToArrowKeys", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    this.f.setMapTrackballToArrowKeys(paramBoolean);
  }
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 3) {
        this.g.setNetworkAvailable(paramBoolean);
      }
    }
    else {
      this.f.setNetworkAvailable(paramBoolean);
    }
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    if (!this.e)
    {
      this.g.setOnLongClickListener(paramOnLongClickListener);
      return;
    }
    Object localObject1 = this.f.getView();
    try
    {
      if (this.x == null)
      {
        Object localObject2 = r.a(localObject1, "getListenerInfo", new Class[0]);
        ((Method)localObject2).setAccessible(true);
        localObject1 = ((Method)localObject2).invoke(localObject1, (Object[])null);
        localObject2 = localObject1.getClass().getDeclaredField("mOnLongClickListener");
        ((Field)localObject2).setAccessible(true);
        this.x = ((Field)localObject2).get(localObject1);
      }
      this.y = paramOnLongClickListener;
      getView().setOnLongClickListener(this);
      return;
    }
    catch (Throwable paramOnLongClickListener) {}
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    getView().setOnTouchListener(paramOnTouchListener);
  }
  
  public void setPictureListener(PictureListener paramPictureListener)
  {
    if (!this.e)
    {
      if (paramPictureListener == null)
      {
        this.g.setPictureListener(null);
        return;
      }
      this.g.setPictureListener(new bp(this, paramPictureListener));
      return;
    }
    if (paramPictureListener == null)
    {
      this.f.setPictureListener(null);
      return;
    }
    this.f.setPictureListener(new bq(this, paramPictureListener));
  }
  
  public void setRendererPriorityPolicy(int paramInt, boolean paramBoolean)
  {
    try
    {
      if (!this.e)
      {
        if (Build.VERSION.SDK_INT < 26) {
          return;
        }
        r.a(this.g, "setRendererPriorityPolicy", new Class[] { Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setScrollBarStyle(int paramInt)
  {
    if (this.e)
    {
      this.f.getView().setScrollBarStyle(paramInt);
      return;
    }
    this.g.setScrollBarStyle(paramInt);
  }
  
  public void setSysNightModeAlpha(int paramInt)
  {
    NIGHT_MODE_ALPHA = paramInt;
  }
  
  public void setVerticalScrollbarOverlay(boolean paramBoolean)
  {
    if (!this.e)
    {
      this.g.setVerticalScrollbarOverlay(paramBoolean);
      return;
    }
    this.f.setVerticalScrollbarOverlay(paramBoolean);
  }
  
  public boolean setVideoFullScreen(Context paramContext, boolean paramBoolean)
  {
    if ((paramContext.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader")) && (this.f != null))
    {
      paramContext = new Bundle();
      if (paramBoolean) {
        paramContext.putInt("DefaultVideoScreen", 2);
      } else {
        paramContext.putInt("DefaultVideoScreen", 1);
      }
      this.f.getX5WebViewExtension().invokeMiscMethod("setVideoParams", paramContext);
      return true;
    }
    return false;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (getView() == null) {
      return;
    }
    getView().setVisibility(paramInt);
  }
  
  public void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    boolean bool = this.e;
    IX5WebViewBase localIX5WebViewBase = null;
    Object localObject = null;
    if (bool)
    {
      localIX5WebViewBase = this.f;
      if (paramWebChromeClient != null) {
        localObject = new q(bt.a().a(true).i(), this, paramWebChromeClient);
      }
      localIX5WebViewBase.setWebChromeClient((IX5WebChromeClient)localObject);
    }
    else
    {
      a locala = this.g;
      if (paramWebChromeClient == null) {
        localObject = localIX5WebViewBase;
      } else {
        localObject = new SystemWebChromeClient(this, paramWebChromeClient);
      }
      locala.setWebChromeClient((android.webkit.WebChromeClient)localObject);
    }
    this.o = paramWebChromeClient;
  }
  
  public void setWebChromeClientExtension(IX5WebChromeClientExtension paramIX5WebChromeClientExtension)
  {
    if (!this.e) {
      return;
    }
    this.f.getX5WebViewExtension().setWebChromeClientExtension(paramIX5WebChromeClientExtension);
  }
  
  public void setWebViewCallbackClient(WebViewCallbackClient paramWebViewCallbackClient)
  {
    this.mWebViewCallbackClient = paramWebViewCallbackClient;
    if ((this.e) && (getX5WebViewExtension() != null))
    {
      paramWebViewCallbackClient = new Bundle();
      paramWebViewCallbackClient.putBoolean("flag", true);
      getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", paramWebViewCallbackClient);
    }
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    boolean bool = this.e;
    IX5WebViewBase localIX5WebViewBase = null;
    Object localObject = null;
    if (bool)
    {
      localIX5WebViewBase = this.f;
      if (paramWebViewClient != null) {
        localObject = new v(bt.a().a(true).j(), this, paramWebViewClient);
      }
      localIX5WebViewBase.setWebViewClient((IX5WebViewClient)localObject);
    }
    else
    {
      a locala = this.g;
      if (paramWebViewClient == null) {
        localObject = localIX5WebViewBase;
      } else {
        localObject = new ad(this, paramWebViewClient);
      }
      locala.setWebViewClient((android.webkit.WebViewClient)localObject);
    }
    this.n = paramWebViewClient;
  }
  
  public void setWebViewClientExtension(IX5WebViewClientExtension paramIX5WebViewClientExtension)
  {
    if (!this.e) {
      return;
    }
    this.f.getX5WebViewExtension().setWebViewClientExtension(paramIX5WebViewClientExtension);
  }
  
  @SuppressLint({"NewApi"})
  public boolean showDebugView(String paramString)
  {
    paramString = paramString.toLowerCase();
    if (paramString.startsWith("http://debugtbs.qq.com"))
    {
      getView().setVisibility(4);
      d.a(this.i).a(paramString, this, this.i, al.a().getLooper());
      return true;
    }
    if ((paramString.startsWith("http://debugx5.qq.com")) && (!this.e))
    {
      paramString = new StringBuilder();
      paramString.append("<!DOCTYPE html><html><body>");
      paramString.append("<head>");
      paramString.append("<title>无法打开debugx5</title>");
      paramString.append("<meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" />");
      paramString.append("</head>");
      paramString.append("<br/><br /><h2>debugx5页面仅在使用了X5内核时有效，由于当前没有使用X5内核，无法打开debugx5！</h2><br />");
      paramString.append("尝试<a href=\"http://debugtbs.qq.com?10000\">进入DebugTbs安装或打开X5内核</a>");
      paramString.append("</body></html>");
      loadDataWithBaseURL(null, paramString.toString(), "text/html", "utf-8", null);
      return true;
    }
    return false;
  }
  
  public boolean showFindDialog(String paramString, boolean paramBoolean)
  {
    return false;
  }
  
  public void stopLoading()
  {
    if (!this.e)
    {
      this.g.stopLoading();
      return;
    }
    this.f.stopLoading();
  }
  
  public void super_computeScroll()
  {
    if (!this.e)
    {
      this.g.a();
      return;
    }
    View localView = this.f.getView();
    try
    {
      r.a(localView, "super_computeScroll");
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.e) {
      return this.g.b(paramMotionEvent);
    }
    View localView = this.f.getView();
    try
    {
      paramMotionEvent = r.a(localView, "super_dispatchTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null) {
        return false;
      }
      boolean bool = ((Boolean)paramMotionEvent).booleanValue();
      return bool;
    }
    catch (Throwable paramMotionEvent) {}
    return false;
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.e) {
      return this.g.c(paramMotionEvent);
    }
    View localView = this.f.getView();
    try
    {
      paramMotionEvent = r.a(localView, "super_onInterceptTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null) {
        return false;
      }
      boolean bool = ((Boolean)paramMotionEvent).booleanValue();
      return bool;
    }
    catch (Throwable paramMotionEvent) {}
    return false;
  }
  
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.e)
    {
      this.g.a(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      return;
    }
    View localView = this.f.getView();
    try
    {
      r.a(localView, "super_onOverScrolled", new Class[] { Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.e)
    {
      this.g.a(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    View localView = this.f.getView();
    try
    {
      r.a(localView, "super_onScrollChanged", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.e) {
      return this.g.a(paramMotionEvent);
    }
    View localView = this.f.getView();
    try
    {
      paramMotionEvent = r.a(localView, "super_onTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null) {
        return false;
      }
      boolean bool = ((Boolean)paramMotionEvent).booleanValue();
      return bool;
    }
    catch (Throwable paramMotionEvent) {}
    return false;
  }
  
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if (!this.e) {
      return this.g.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    }
    Object localObject = this.f.getView();
    try
    {
      localObject = r.a(localObject, "super_overScrollBy", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Boolean.valueOf(paramBoolean) });
      if (localObject == null) {
        return false;
      }
      paramBoolean = ((Boolean)localObject).booleanValue();
      return paramBoolean;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public void switchNightMode(boolean paramBoolean)
  {
    if (paramBoolean == w) {
      return;
    }
    w = paramBoolean;
    if (w) {
      TbsLog.e("QB_SDK", "deleteNightMode");
    }
    for (String str = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";; str = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);")
    {
      loadUrl(str);
      return;
      TbsLog.e("QB_SDK", "nightMode");
    }
  }
  
  public void switchToNightMode()
  {
    TbsLog.e("QB_SDK", "switchToNightMode 01");
    if (!w)
    {
      TbsLog.e("QB_SDK", "switchToNightMode");
      loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
    }
  }
  
  public void tbsWebviewDestroy(boolean paramBoolean)
  {
    Object localObject4;
    Object localObject1;
    int i1;
    if ((!this.k) && (this.a != 0))
    {
      this.k = true;
      String str1 = "";
      String str2 = "";
      String str3 = "";
      localObject4 = str1;
      ??? = str2;
      localObject1 = str3;
      if (this.e)
      {
        Bundle localBundle = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo();
        localObject4 = str1;
        ??? = str2;
        localObject1 = str3;
        if (localBundle != null)
        {
          localObject4 = localBundle.getString("guid");
          ??? = localBundle.getString("qua2");
          localObject1 = localBundle.getString("lc");
        }
      }
      if ("com.qzone".equals(this.i.getApplicationInfo().packageName))
      {
        int i2 = d(this.i);
        i1 = i2;
        if (i2 == -1) {
          i1 = this.a;
        }
        this.a = i1;
        e(this.i);
      }
      com.tencent.smtt.sdk.a.b.a(this.i, (String)localObject4, (String)???, (String)localObject1, this.a, this.e, h());
      this.a = 0;
      this.k = false;
    }
    if (!this.e) {}
    try
    {
      localObject1 = Class.forName("android.webkit.WebViewClassic");
      ??? = ((Class)localObject1).getMethod("fromWebView", new Class[] { android.webkit.WebView.class });
      ((Method)???).setAccessible(true);
      ??? = ((Method)???).invoke(null, new Object[] { this.g });
      if (??? != null)
      {
        localObject1 = ((Class)localObject1).getDeclaredField("mListBoxDialog");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((Field)localObject1).get(???);
        if (localObject1 != null)
        {
          localObject1 = (Dialog)localObject1;
          ((Dialog)localObject1).setOnCancelListener(null);
          ??? = Class.forName("android.app.Dialog");
          localObject4 = ((Class)???).getDeclaredField("CANCEL");
          ((Field)localObject4).setAccessible(true);
          i1 = ((Integer)((Field)localObject4).get(localObject1)).intValue();
          ??? = ((Class)???).getDeclaredField("mListenersHandler");
          ((Field)???).setAccessible(true);
          ((Handler)((Field)???).get(localObject1)).removeMessages(i1);
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;) {}
    }
    if (paramBoolean) {
      this.g.destroy();
    }
    try
    {
      ??? = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
      ((Field)???).setAccessible(true);
      localObject1 = (ComponentCallbacks)((Field)???).get(null);
      if (localObject1 != null)
      {
        ((Field)???).set(null, null);
        ??? = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
        ((Field)???).setAccessible(true);
        ??? = ((Field)???).get(null);
        if (??? != null)
        {
          synchronized ((List)???)
          {
            ((List)???).remove(localObject1);
          }
          if (paramBoolean) {
            this.f.destroy();
          }
        }
      }
    }
    catch (Exception localException2)
    {
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("X5 GUID = ");
    localStringBuilder.append(QbSdk.b());
    TbsLog.i("WebView", localStringBuilder.toString());
  }
  
  public boolean zoomIn()
  {
    if (!this.e) {
      return this.g.zoomIn();
    }
    return this.f.zoomIn();
  }
  
  public boolean zoomOut()
  {
    if (!this.e) {
      return this.g.zoomOut();
    }
    return this.f.zoomOut();
  }
  
  public static class HitTestResult
  {
    @Deprecated
    public static final int ANCHOR_TYPE = 1;
    public static final int EDIT_TEXT_TYPE = 9;
    public static final int EMAIL_TYPE = 4;
    public static final int GEO_TYPE = 3;
    @Deprecated
    public static final int IMAGE_ANCHOR_TYPE = 6;
    public static final int IMAGE_TYPE = 5;
    public static final int PHONE_TYPE = 2;
    public static final int SRC_ANCHOR_TYPE = 7;
    public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
    public static final int UNKNOWN_TYPE = 0;
    private IX5WebViewBase.HitTestResult a;
    private android.webkit.WebView.HitTestResult b = null;
    
    public HitTestResult()
    {
      this.a = null;
      this.b = null;
    }
    
    public HitTestResult(android.webkit.WebView.HitTestResult paramHitTestResult)
    {
      this.a = null;
      this.b = paramHitTestResult;
    }
    
    public HitTestResult(IX5WebViewBase.HitTestResult paramHitTestResult)
    {
      this.a = paramHitTestResult;
      this.b = null;
    }
    
    public String getExtra()
    {
      String str = "";
      if (this.a != null) {
        return this.a.getExtra();
      }
      if (this.b != null) {
        str = this.b.getExtra();
      }
      return str;
    }
    
    public int getType()
    {
      if (this.a != null) {
        return this.a.getType();
      }
      if (this.b != null) {
        return this.b.getType();
      }
      return 0;
    }
  }
  
  public static abstract interface PictureListener
  {
    public abstract void onNewPicture(WebView paramWebView, Picture paramPicture);
  }
  
  public class WebViewTransport
  {
    private WebView b;
    
    public WebViewTransport() {}
    
    public WebView getWebView()
    {
      try
      {
        WebView localWebView = this.b;
        return localWebView;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void setWebView(WebView paramWebView)
    {
      try
      {
        this.b = paramWebView;
        return;
      }
      finally
      {
        paramWebView = finally;
        throw paramWebView;
      }
    }
  }
  
  private class a
    extends android.webkit.WebView
  {
    public a(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public a(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      if ((QbSdk.getIsSysWebViewForcedByOuter()) && (TbsShareManager.isThirdPartyApp(paramContext))) {
        return;
      }
      CookieSyncManager.createInstance(WebView.a(WebView.this)).startSync();
      try
      {
        this$1 = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
        WebView.this.setAccessible(true);
        ((Handler)WebView.this.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new p());
        WebView.mSysWebviewCreated = true;
        return;
      }
      catch (Exception this$1) {}
    }
    
    public void a()
    {
      super.computeScroll();
    }
    
    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    @TargetApi(9)
    public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      }
    }
    
    @TargetApi(9)
    public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      }
      return false;
    }
    
    public boolean a(MotionEvent paramMotionEvent)
    {
      return super.onTouchEvent(paramMotionEvent);
    }
    
    public boolean b(MotionEvent paramMotionEvent)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    
    public boolean c(MotionEvent paramMotionEvent)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    public void computeScroll()
    {
      if (WebView.this.mWebViewCallbackClient != null)
      {
        WebView.this.mWebViewCallbackClient.computeScroll(this);
        return;
      }
      super.computeScroll();
    }
    
    protected void dispatchDraw(Canvas paramCanvas)
    {
      try
      {
        super.dispatchDraw(paramCanvas);
        if ((!WebView.e()) && (WebView.f() != null))
        {
          paramCanvas.save();
          paramCanvas.drawPaint(WebView.f());
          paramCanvas.restore();
          return;
        }
      }
      catch (Throwable paramCanvas)
      {
        paramCanvas.printStackTrace();
      }
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.dispatchTouchEvent(paramMotionEvent, this);
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    
    public android.webkit.WebSettings getSettings()
    {
      try
      {
        android.webkit.WebSettings localWebSettings = super.getSettings();
        return localWebSettings;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return null;
    }
    
    public void invalidate()
    {
      super.invalidate();
      if (WebView.this.mWebViewCallbackClient != null) {
        WebView.this.mWebViewCallbackClient.invalidate();
      }
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.onInterceptTouchEvent(paramMotionEvent, this);
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    @TargetApi(9)
    public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (WebView.this.mWebViewCallbackClient != null)
      {
        WebView.this.mWebViewCallbackClient.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, this);
        return;
      }
      if (Build.VERSION.SDK_INT >= 9) {
        super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      }
    }
    
    protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (WebView.this.mWebViewCallbackClient != null)
      {
        WebView.this.mWebViewCallbackClient.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, this);
        return;
      }
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      WebView.b(WebView.this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      if (!hasFocus()) {
        requestFocus();
      }
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.onTouchEvent(paramMotionEvent, this);
      }
      try
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
      return false;
    }
    
    @TargetApi(9)
    public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, this);
      }
      if (Build.VERSION.SDK_INT >= 9) {
        return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      }
      return false;
    }
    
    public void setOverScrollMode(int paramInt)
    {
      try
      {
        super.setOverScrollMode(paramInt);
        return;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\WebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */