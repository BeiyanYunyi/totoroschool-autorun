package com.totoro.school.activity.common;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.totoro.school.R.id;
import com.totoro.school.utilpub.network.BaseActivity;
import d.c.b.h;
import d.g.m;
import java.util.HashMap;

public final class HTMLActivity
  extends BaseActivity
{
  private View a;
  private boolean b;
  private String c = "";
  private ValueCallback<Uri[]> d;
  private final int e = 10000;
  private HashMap f;
  
  private final void b()
  {
    Object localObject = (WebView)a(R.id.webView);
    if (localObject != null)
    {
      localObject = ((WebView)localObject).getSettings();
      if (localObject != null) {
        ((WebSettings)localObject).setJavaScriptEnabled(true);
      }
    }
    localObject = (WebView)a(R.id.webView);
    if (localObject != null)
    {
      localObject = ((WebView)localObject).getSettings();
      if (localObject != null) {
        ((WebSettings)localObject).setDomStorageEnabled(true);
      }
    }
    localObject = (WebView)a(R.id.webView);
    if (localObject != null) {
      ((WebView)localObject).requestFocus();
    }
    localObject = (WebView)a(R.id.webView);
    if (localObject != null)
    {
      localObject = ((WebView)localObject).getSettings();
      if (localObject != null) {
        ((WebSettings)localObject).setUseWideViewPort(true);
      }
    }
    localObject = (WebView)a(R.id.webView);
    if (localObject != null)
    {
      localObject = ((WebView)localObject).getSettings();
      if (localObject != null) {
        ((WebSettings)localObject).setLoadWithOverviewMode(true);
      }
    }
    localObject = (WebView)a(R.id.webView);
    if (localObject != null)
    {
      localObject = ((WebView)localObject).getSettings();
      if (localObject != null) {
        ((WebSettings)localObject).setAllowFileAccess(true);
      }
    }
    localObject = (WebView)a(R.id.webView);
    if (localObject != null)
    {
      localObject = ((WebView)localObject).getSettings();
      if (localObject != null) {
        ((WebSettings)localObject).setAllowFileAccessFromFileURLs(true);
      }
    }
    localObject = (WebView)a(R.id.webView);
    if (localObject != null)
    {
      localObject = ((WebView)localObject).getSettings();
      if (localObject != null) {
        ((WebSettings)localObject).setAllowUniversalAccessFromFileURLs(true);
      }
    }
    localObject = (WebView)a(R.id.webView);
    if (localObject != null)
    {
      localObject = ((WebView)localObject).getSettings();
      if (localObject != null) {
        ((WebSettings)localObject).setSupportZoom(true);
      }
    }
    localObject = (WebView)a(R.id.webView);
    if (localObject != null)
    {
      localObject = ((WebView)localObject).getSettings();
      if (localObject != null) {
        ((WebSettings)localObject).setCacheMode(2);
      }
    }
    localObject = (WebView)a(R.id.webView);
    if (localObject != null)
    {
      localObject = ((WebView)localObject).getSettings();
      if (localObject != null) {
        ((WebSettings)localObject).setBuiltInZoomControls(true);
      }
    }
    localObject = (WebView)a(R.id.webView);
    if (localObject != null)
    {
      localObject = ((WebView)localObject).getSettings();
      if (localObject != null) {
        ((WebSettings)localObject).setDisplayZoomControls(false);
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = (WebView)a(R.id.webView);
      if (localObject != null)
      {
        localObject = ((WebView)localObject).getSettings();
        if (localObject != null) {
          ((WebSettings)localObject).setMixedContentMode(0);
        }
      }
    }
    localObject = (WebView)a(R.id.webView);
    if (localObject != null) {
      ((WebView)localObject).setWebViewClient((WebViewClient)new c());
    }
    localObject = (WebView)a(R.id.webView);
    if (localObject != null) {
      ((WebView)localObject).setWebChromeClient((WebChromeClient)new b());
    }
  }
  
  private final void c()
  {
    this.b = getIntent().getBooleanExtra("canComment", false);
    ((WebView)a(R.id.webView)).loadUrl(getIntent().getStringExtra("url"));
    TextView localTextView = (TextView)a(R.id.title_text);
    h.a(localTextView, "title_text");
    localTextView.setText((CharSequence)getIntent().getStringExtra("title"));
    ((LinearLayout)a(R.id.back)).setOnClickListener((View.OnClickListener)new a(this));
  }
  
  private final void d()
  {
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.addCategory("android.intent.category.OPENABLE");
    localIntent.setType("image/*");
    startActivityForResult(Intent.createChooser(localIntent, (CharSequence)"Image Chooser"), this.e);
  }
  
  public View a(int paramInt)
  {
    if (this.f == null) {
      this.f = new HashMap();
    }
    View localView2 = (View)this.f.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.f.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == this.e)
    {
      if (this.d == null) {
        return;
      }
      Uri[] arrayOfUri = new Uri[0];
      if (paramInt2 == -1)
      {
        Object localObject = arrayOfUri;
        if (getIntent() != null)
        {
          String str;
          if (paramIntent != null) {
            str = paramIntent.getDataString();
          } else {
            str = null;
          }
          if (paramIntent != null) {
            paramIntent = paramIntent.getClipData();
          } else {
            paramIntent = null;
          }
          if (paramIntent != null)
          {
            paramInt2 = paramIntent.getItemCount();
            paramInt1 = 0;
            while (paramInt1 < paramInt2)
            {
              localObject = paramIntent.getItemAt(paramInt1);
              h.a(localObject, "item");
              localObject = ((ClipData.Item)localObject).getUri();
              h.a(localObject, "item.uri");
              arrayOfUri[paramInt1] = localObject;
              paramInt1 += 1;
            }
          }
          localObject = arrayOfUri;
          if (str != null)
          {
            localObject = new Uri[1];
            paramIntent = Uri.parse(str);
            h.a(paramIntent, "Uri.parse(dataString)");
            localObject[0] = paramIntent;
          }
        }
        paramIntent = this.d;
        if (paramIntent != null) {
          paramIntent.onReceiveValue(localObject);
        }
        this.d = ((ValueCallback)null);
      }
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492902);
    c();
    b();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (((WebView)a(R.id.webView)).canGoBack()))
    {
      paramKeyEvent = (WebView)a(R.id.webView);
      if (paramKeyEvent == null) {
        h.a();
      }
      paramKeyEvent.goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  static final class a
    implements View.OnClickListener
  {
    a(HTMLActivity paramHTMLActivity) {}
    
    public final void onClick(View paramView)
    {
      try
      {
        this.a.onKeyDown(4, null);
        return;
      }
      catch (Exception paramView)
      {
        for (;;) {}
      }
      this.a.finish();
    }
  }
  
  public final class b
    extends WebChromeClient
  {
    private final View b;
    
    public View getVideoLoadingProgressView()
    {
      if (this.b == null) {
        LayoutInflater.from((Context)this.a);
      }
      return this.b;
    }
    
    public void onHideCustomView()
    {
      if (HTMLActivity.b(this.a) == null) {
        return;
      }
      this.a.setRequestedOrientation(1);
      Object localObject = HTMLActivity.b(this.a);
      if (localObject == null) {
        h.a();
      }
      ((View)localObject).setVisibility(8);
      HTMLActivity.a(this.a, (View)null);
      localObject = (WebView)this.a.a(R.id.webView);
      if (localObject == null) {
        h.a();
      }
      ((WebView)localObject).setVisibility(0);
    }
    
    public boolean onShowFileChooser(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
    {
      HTMLActivity.a(this.a, paramValueCallback);
      HTMLActivity.a(this.a);
      return true;
    }
  }
  
  public final class c
    extends WebViewClient
  {
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      h.b(paramWebView, "view");
      h.b(paramString, "url");
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      h.b(paramWebView, "view");
      h.b(paramString, "url");
      if ((!m.b(paramString, "http:", false, 2, null)) && (!m.b(paramString, "https:", false, 2, null)))
      {
        paramWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        this.b.startActivity(paramWebView);
      }
      else
      {
        paramWebView.loadUrl(paramString);
      }
      return true;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\common\HTMLActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */