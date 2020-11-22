package com.totoro.school.activity.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.PDFView.Configurator;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageScrollListener;
import com.totoro.school.R.id;
import com.totoro.school.utilpub.network.BaseActivity;
import com.totoro.school.utils.g;
import com.totoro.school.utils.g.a;
import d.c.b.h;
import java.io.File;
import java.util.HashMap;

public final class PDFActivity
  extends BaseActivity
  implements OnLoadCompleteListener, OnPageChangeListener
{
  private HashMap a;
  
  private final void b()
  {
    Object localObject = (TextView)a(R.id.title_text);
    h.a(localObject, "title_text");
    ((TextView)localObject).setVisibility(0);
    localObject = (TextView)a(R.id.title_text);
    h.a(localObject, "title_text");
    ((TextView)localObject).setText((CharSequence)getIntent().getStringExtra("title"));
    localObject = getIntent().getStringExtra("url");
    new g(getIntent().getStringExtra("fileName"), (g.a)new a(this)).execute(new String[] { localObject });
    ((LinearLayout)a(R.id.back)).setOnClickListener((View.OnClickListener)new b(this));
  }
  
  public View a(int paramInt)
  {
    if (this.a == null) {
      this.a = new HashMap();
    }
    View localView2 = (View)this.a.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.a.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void loadComplete(int paramInt) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492909);
    b();
  }
  
  public void onPageChanged(int paramInt1, int paramInt2) {}
  
  public static final class a
    implements g.a
  {
    public void a() {}
    
    public void a(File paramFile)
    {
      h.b(paramFile, "file");
      ((PDFView)this.a.a(R.id.pdfView)).fromFile(paramFile).enableSwipe(true).spacing(5).defaultPage(0).swipeHorizontal(false).enableAntialiasing(true).enableDoubletap(true).enableAnnotationRendering(true).onLoad((OnLoadCompleteListener)new a(this)).onError((OnErrorListener)new b(this)).onPageChange((OnPageChangeListener)new c(this)).onPageScroll((OnPageScrollListener)d.a).load();
    }
    
    public void a(Integer paramInteger1, Integer paramInteger2) {}
    
    static final class a
      implements OnLoadCompleteListener
    {
      a(PDFActivity.a parama) {}
      
      public final void loadComplete(int paramInt)
      {
        Toast.makeText((Context)this.a.a, (CharSequence)"加载完成", 0).show();
      }
    }
    
    public static final class b
      implements OnErrorListener
    {
      public void onError(Throwable paramThrowable)
      {
        h.b(paramThrowable, "t");
        Toast.makeText((Context)this.a.a, (CharSequence)"加载错误", 0).show();
      }
    }
    
    static final class c
      implements OnPageChangeListener
    {
      c(PDFActivity.a parama) {}
      
      public final void onPageChanged(int paramInt1, int paramInt2)
      {
        Context localContext = (Context)this.a.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(String.valueOf(paramInt1 + 1));
        localStringBuilder.append("/");
        localStringBuilder.append(paramInt2);
        Toast.makeText(localContext, (CharSequence)localStringBuilder.toString(), 0).show();
      }
    }
    
    static final class d
      implements OnPageScrollListener
    {
      public static final d a = new d();
      
      public final void onPageScrolled(int paramInt, float paramFloat) {}
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(PDFActivity paramPDFActivity) {}
    
    public final void onClick(View paramView)
    {
      this.a.finish();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\common\PDFActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */