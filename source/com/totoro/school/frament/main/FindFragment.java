package com.totoro.school.frament.main;

import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.totoro.school.activity.MainFragmentActivity;
import com.totoro.school.c.a;

public class FindFragment
  extends Fragment
  implements a
{
  private View a;
  private WebChromeClient.CustomViewCallback b;
  @BindView(2131296727)
  WebView mWebView;
  
  private void b()
  {
    this.mWebView.getSettings().setJavaScriptEnabled(true);
    this.mWebView.getSettings().setDomStorageEnabled(true);
    this.mWebView.requestFocus();
    this.mWebView.getSettings().setUseWideViewPort(true);
    this.mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    this.mWebView.getSettings().setLoadWithOverviewMode(true);
    this.mWebView.getSettings().setSupportZoom(true);
    this.mWebView.getSettings().setBuiltInZoomControls(true);
    this.mWebView.getSettings().setDisplayZoomControls(false);
    if (Build.VERSION.SDK_INT >= 21) {
      this.mWebView.getSettings().setMixedContentMode(0);
    }
    this.mWebView.setWebViewClient(new b());
    this.mWebView.setWebChromeClient(new a());
    this.mWebView.loadUrl("https://www.baidu.com/");
  }
  
  public boolean a()
  {
    if (this.mWebView.canGoBack())
    {
      this.mWebView.goBack();
      return true;
    }
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131492944, paramViewGroup, false);
    ButterKnife.bind(this, paramLayoutInflater);
    b();
    if ((getActivity() instanceof MainFragmentActivity))
    {
      paramViewGroup = (MainFragmentActivity)getActivity();
      MainFragmentActivity.a = this;
    }
    return paramLayoutInflater;
  }
  
  public class a
    extends WebChromeClient
  {
    private View b;
    
    public a() {}
    
    public View getVideoLoadingProgressView()
    {
      if (this.b == null) {
        LayoutInflater.from(FindFragment.this.getActivity());
      }
      return this.b;
    }
    
    public void onHideCustomView()
    {
      if (FindFragment.a(FindFragment.this) == null) {
        return;
      }
      FindFragment.this.getActivity().setRequestedOrientation(1);
      FindFragment.a(FindFragment.this).setVisibility(8);
      FindFragment.a(FindFragment.this, null);
      FindFragment.b(FindFragment.this).onCustomViewHidden();
      FindFragment.this.mWebView.setVisibility(0);
    }
    
    public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      FindFragment.this.getActivity().setRequestedOrientation(0);
      FindFragment.this.mWebView.setVisibility(4);
      if (FindFragment.a(FindFragment.this) != null)
      {
        paramCustomViewCallback.onCustomViewHidden();
        return;
      }
      FindFragment.a(FindFragment.this, paramView);
      FindFragment.a(FindFragment.this, paramCustomViewCallback);
    }
  }
  
  class b
    extends WebViewClient
  {
    b() {}
    
    public void onPageFinished(WebView paramWebView, String paramString) {}
    
    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      paramSslErrorHandler.proceed();
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if ((paramString.startsWith("http:")) || (paramString.startsWith("https:"))) {
        paramWebView.loadUrl(paramString);
      }
      return true;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\frament\main\FindFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */