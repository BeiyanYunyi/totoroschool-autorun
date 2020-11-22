package com.pgyersdk.feedback.a;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.pgyersdk.b.e;
import com.pgyersdk.c.a;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class m
  extends AlertDialog.Builder
  implements View.OnClickListener
{
  private static String a = "#ffffff";
  private static String b = "#2E2D2D";
  private static String c = "#56bc94";
  private static String d = "#cccccc";
  private boolean A;
  private int B = Color.rgb(245, 245, 245);
  private int C = Color.rgb(255, 255, 255);
  private Context D;
  private Handler E = new g(this, Looper.getMainLooper());
  View.OnTouchListener F = new h(this);
  View.OnTouchListener G = new i(this);
  private TextView e;
  private EditText f;
  private EditText g;
  private CheckBox h;
  private c i;
  q j;
  private LinearLayout k;
  private f l;
  private LinearLayout m;
  private int n = 120000;
  private MediaRecorder o;
  private MediaPlayer p;
  public File q;
  private long r;
  private long s;
  private long t;
  private boolean u = false;
  PopupWindow v;
  n w;
  Timer x;
  TimerTask y;
  private int z = 1;
  
  public m(Context paramContext)
  {
    this(paramContext, 3);
  }
  
  public m(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.D = new ContextThemeWrapper(paramContext, 16973934);
  }
  
  private View a(LinearLayout paramLinearLayout)
  {
    Object localObject1 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject1).gravity = 3;
    ((LinearLayout.LayoutParams)localObject1).setMargins(com.pgyersdk.f.b.a(this.D, 15.0F), 0, com.pgyersdk.f.b.a(this.D, 20.0F), com.pgyersdk.f.b.a(this.D, 20.0F));
    this.h = new CheckBox(this.D);
    this.h.setText(com.pgyersdk.c.b.a(1064));
    this.h.setTextColor(Color.parseColor(c));
    this.h.setChecked(true);
    paramLinearLayout.addView(this.h, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new TextView(this.D);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(com.pgyersdk.c.b.a(1065));
    ((StringBuilder)localObject2).append(a.g);
    ((StringBuilder)localObject2).append("\t");
    ((StringBuilder)localObject2).append(a.f);
    ((StringBuilder)localObject2).append("（");
    ((StringBuilder)localObject2).append(a.e);
    ((StringBuilder)localObject2).append("）");
    ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
    ((TextView)localObject1).setTextColor(Color.parseColor(c));
    ((TextView)localObject1).setTextSize(12.0F);
    localObject2 = k();
    ((TextView)localObject1).setPadding(com.pgyersdk.f.b.a(this.D, 20.0F), 0, com.pgyersdk.f.b.a(this.D, 20.0F), com.pgyersdk.f.b.a(this.D, 20.0F));
    paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return paramLinearLayout;
  }
  
  private View a(CharSequence paramCharSequence)
  {
    this.e = new TextView(this.D);
    this.e.setText(paramCharSequence.toString());
    this.e.setTextSize(22.0F);
    this.e.setTextColor(Color.parseColor(a));
    this.e.setPadding(30, 20, 0, 20);
    this.e.setBackgroundColor(Color.parseColor(b));
    this.e.setGravity(17);
    this.e.setSingleLine(true);
    return this.e;
  }
  
  private void a(View paramView)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.D.getSystemService("input_method");
    if (Build.VERSION.SDK_INT >= 3) {
      localInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 2);
    }
  }
  
  public static void a(String paramString)
  {
    a = paramString;
  }
  
  private void b(LinearLayout paramLinearLayout)
  {
    this.k = new LinearLayout(this.D);
    LinearLayout.LayoutParams localLayoutParams1 = k();
    localLayoutParams1.setMargins(com.pgyersdk.f.b.a(this.D, 20.0F), com.pgyersdk.f.b.a(this.D, 20.0F), com.pgyersdk.f.b.a(this.D, 20.0F), com.pgyersdk.f.b.a(this.D, 20.0F));
    this.k.setGravity(16);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-2, com.pgyersdk.f.b.a(this.D, 40.0F));
    localLayoutParams2.weight = 1.0F;
    localLayoutParams2.setMargins(0, 0, com.pgyersdk.f.b.a(this.D, 20.0F), 0);
    this.j = new q(this.D);
    this.j.setPadding(0, 0, com.pgyersdk.f.b.a(this.D, 10.0F), 0);
    this.j.setGravity(21);
    this.j.setOnClickListener(this);
    this.j.setTag("tagBtnPlay");
    this.k.addView(this.j, localLayoutParams2);
    this.l = new f(this.D);
    this.l.setTag("tagBtnDelete");
    this.l.setOnClickListener(this);
    localLayoutParams2 = k();
    localLayoutParams2.width = com.pgyersdk.f.b.a(this.D, 30.0F);
    localLayoutParams2.height = com.pgyersdk.f.b.a(this.D, 30.0F);
    this.k.addView(this.l, localLayoutParams2);
    this.k.setVisibility(8);
    paramLinearLayout.addView(this.k, localLayoutParams1);
    localLayoutParams1 = k();
    localLayoutParams1.height = com.pgyersdk.f.b.a(this.D, 40.0F);
    localLayoutParams1.setMargins(com.pgyersdk.f.b.a(this.D, 20.0F), com.pgyersdk.f.b.a(this.D, 20.0F), com.pgyersdk.f.b.a(this.D, 20.0F), com.pgyersdk.f.b.a(this.D, 20.0F));
    this.i = new c(this.D);
    this.i.setText(com.pgyersdk.c.b.a(1072));
    this.i.setOnTouchListener(this.G);
    paramLinearLayout.addView(this.i, localLayoutParams1);
  }
  
  public static void b(String paramString)
  {
    b = paramString;
  }
  
  private void c(LinearLayout paramLinearLayout)
  {
    LinearLayout.LayoutParams localLayoutParams = k();
    paramLinearLayout.addView(i(), localLayoutParams);
    paramLinearLayout.addView(j(), localLayoutParams);
    paramLinearLayout.addView(h(), localLayoutParams);
    b(paramLinearLayout);
    o();
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private View f()
  {
    this.m = new LinearLayout(this.D);
    LinearLayout.LayoutParams localLayoutParams = k();
    this.m.setOrientation(1);
    this.m.setBackgroundColor(-1);
    this.m.setOnTouchListener(this.F);
    if (!this.A)
    {
      this.e = ((TextView)a(com.pgyersdk.c.b.a(1062)));
      this.e = ((TextView)a(com.pgyersdk.c.b.a(1062)));
      this.m.addView(this.e, localLayoutParams);
    }
    c(this.m);
    if (!this.A) {
      a(this.m);
    }
    return this.m;
  }
  
  private void g()
  {
    this.y = new l(this);
    this.x = new Timer();
    this.x.schedule(this.y, 0L, 400L);
  }
  
  private View h()
  {
    this.f = new EditText(this.D);
    this.f.setHint(com.pgyersdk.c.b.a(1044));
    this.f.setPadding(com.pgyersdk.f.b.a(this.D, 20.0F), com.pgyersdk.f.b.a(this.D, 10.0F), com.pgyersdk.f.b.a(this.D, 20.0F), 0);
    this.f.setHintTextColor(Color.parseColor(d));
    if (this.D.getResources().getConfiguration().orientation == 1) {
      this.f.setMinLines(8);
    } else {
      this.f.setMinLines(2);
    }
    this.f.setTextSize(14.0F);
    this.f.setGravity(51);
    this.f.setBackgroundColor(this.C);
    return this.f;
  }
  
  private View i()
  {
    this.g = new EditText(this.D);
    this.g.setHint(com.pgyersdk.c.b.a(1045));
    this.g.setSingleLine(true);
    this.g.setPadding(com.pgyersdk.f.b.a(this.D, 20.0F), com.pgyersdk.f.b.a(this.D, 10.0F), com.pgyersdk.f.b.a(this.D, 20.0F), com.pgyersdk.f.b.a(this.D, 10.0F));
    this.g.setHintTextColor(Color.parseColor(d));
    this.g.setMinLines(1);
    this.g.setTextSize(14.0F);
    this.g.setGravity(19);
    this.g.setBackgroundColor(this.C);
    this.g.setFocusable(true);
    this.g.setFocusableInTouchMode(true);
    this.g.requestFocus();
    if (!com.pgyersdk.f.k.a("selfmail")) {
      this.g.setText(com.pgyersdk.f.h.a(this.D, "selfmail"));
    }
    return this.g;
  }
  
  private TextView j()
  {
    TextView localTextView = new TextView(this.D);
    localTextView.setBackgroundColor(Color.parseColor("#f0f0f0"));
    localTextView.setHeight(com.pgyersdk.f.b.a(this.D, 1.0F));
    return localTextView;
  }
  
  private LinearLayout.LayoutParams k()
  {
    return new LinearLayout.LayoutParams(-1, -2);
  }
  
  private void l()
  {
    try
    {
      File localFile = new File(com.pgyersdk.f.c.a().d(this.D));
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      if (this.o == null) {
        this.o = new MediaRecorder();
      }
      this.o.setAudioSource(1);
      this.o.setOutputFormat(2);
      this.o.setAudioEncoder(3);
      this.o.setMaxDuration(this.n);
      this.q = File.createTempFile("recorder_", ".wav", localFile);
      this.o.setOutputFile(this.q.getAbsolutePath());
      return;
    }
    catch (Exception localException) {}
  }
  
  private void m()
  {
    this.w = new n(this.D);
    this.v = new PopupWindow(this.w);
    this.v.setWidth(com.pgyersdk.f.b.a(this.D, 80.0F));
    this.v.setHeight(com.pgyersdk.f.b.a(this.D, 80.0F));
    if (this.D.getResources().getConfiguration().orientation % 2 == 1) {
      this.v.showAtLocation(this.f, 48, 0, com.pgyersdk.f.b.a(this.D, 115.0F));
    } else {
      this.v.showAtLocation(this.f, 48, 0, com.pgyersdk.f.b.a(this.D, 70.0F));
    }
    r();
  }
  
  private void n()
  {
    this.E.removeMessages(20005);
    PopupWindow localPopupWindow = this.v;
    if ((localPopupWindow != null) && (localPopupWindow.isShowing())) {
      this.v.dismiss();
    }
  }
  
  private void o()
  {
    if (!com.pgyersdk.f.k.a(com.pgyersdk.f.h.a(this.D, "selfmail"))) {
      this.g.setText(com.pgyersdk.f.h.a(this.D, "selfmail"));
    }
    if (!com.pgyersdk.f.k.a(com.pgyersdk.f.h.a(this.D, "feedback_des"))) {
      this.f.setText(com.pgyersdk.f.h.a(this.D, "feedback_des"));
    }
    if (!com.pgyersdk.f.k.a(com.pgyersdk.f.h.a(this.D, "voicefile")))
    {
      this.q = new File(com.pgyersdk.f.h.a(this.D, "voicefile"));
      if (this.q.exists())
      {
        this.i.setVisibility(8);
        this.k.setVisibility(0);
        this.j.setText(com.pgyersdk.f.h.a(this.D, "voiceTime"));
        return;
      }
      this.q = null;
      com.pgyersdk.f.h.a("voicefile", "");
      com.pgyersdk.f.h.a("voiceTime", "");
    }
  }
  
  private void p()
  {
    try
    {
      l();
      if ((this.o != null) && (!this.u))
      {
        this.o.prepare();
        this.o.start();
        this.r = new Date().getTime();
        this.u = true;
        m();
        return;
      }
    }
    catch (Exception localException)
    {
      com.pgyersdk.f.f.a("PgyerSDK", "starting record error ", localException);
    }
  }
  
  private void q()
  {
    try
    {
      if ((this.u) && (this.o != null))
      {
        this.o.reset();
        this.u = false;
        this.s = new Date().getTime();
        q localq = this.j;
        StringBuilder localStringBuilder = new StringBuilder();
        long l1 = this.s;
        long l2 = this.r;
        double d1 = l1 - l2;
        Double.isNaN(d1);
        d1 /= 1000.0D;
        localStringBuilder.append(String.format("%.0f", new Object[] { Double.valueOf(Math.ceil(d1)) }));
        localStringBuilder.append("\"");
        localq.setText(localStringBuilder.toString());
        this.E.removeMessages(20006);
        n();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void r()
  {
    int i1 = this.o.getMaxAmplitude();
    if (i1 < 800)
    {
      i1 = 0;
      this.z = 1;
    }
    else if ((i1 >= 800) && (i1 < 2000))
    {
      this.z = 2;
    }
    else if ((i1 >= 2000) && (i1 < 4000))
    {
      this.z = 3;
    }
    else if ((i1 >= 4000) && (i1 < 7000))
    {
      this.z = 4;
    }
    else if ((i1 >= 7000) && (i1 < 10000))
    {
      this.z = 5;
    }
    else if ((i1 >= 10000) && (i1 < 15000))
    {
      this.z = 6;
    }
    else
    {
      this.z = 7;
    }
    if (i1 > 32768) {
      this.z = 7;
    }
    Message localMessage = new Message();
    localMessage.what = 20005;
    localMessage.obj = Integer.valueOf(this.z);
    this.E.sendMessageDelayed(localMessage, 100L);
  }
  
  public m a(boolean paramBoolean)
  {
    this.A = paramBoolean;
    return this;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void a()
  {
    try
    {
      this.m.setOnTouchListener(null);
      this.i.setOnTouchListener(null);
      this.l.setOnClickListener(null);
      this.j.setOnClickListener(null);
      if ((this.p != null) && (this.p.isPlaying()))
      {
        this.p.stop();
        this.p.release();
      }
      if (this.o != null) {
        this.o.release();
      }
      if (this.D != null) {
        this.D = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public CheckBox b()
  {
    return this.h;
  }
  
  public EditText c()
  {
    return this.f;
  }
  
  public AlertDialog create()
  {
    setView(f());
    return super.create();
  }
  
  public EditText d()
  {
    return this.g;
  }
  
  public void e()
  {
    Object localObject = this.x;
    if (localObject != null) {
      ((Timer)localObject).cancel();
    }
    localObject = this.y;
    if (localObject != null) {
      ((TimerTask)localObject).cancel();
    }
    if (this.p == null)
    {
      this.p = new MediaPlayer();
      this.p.setOnCompletionListener(new j(this));
      this.p.setOnPreparedListener(new k(this));
    }
    if (this.p.isPlaying()) {
      this.p.reset();
    }
    this.p.setAudioStreamType(2);
    if (this.q.exists()) {}
    try
    {
      localObject = new FileInputStream(this.q);
      this.p.reset();
      this.p.setDataSource(((FileInputStream)localObject).getFD());
      this.p.prepare();
      this.p.start();
      g();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void onClick(View paramView)
  {
    if ("tagBtnPlay".equals(paramView.getTag().toString())) {
      e();
    }
    if ("tagBtnDelete".equals(paramView.getTag().toString()))
    {
      this.k.setVisibility(8);
      this.i.setVisibility(0);
      e.a(this.q);
      com.pgyersdk.f.h.a("voicefile", "");
      com.pgyersdk.f.h.a("voiceTime", "");
      this.q = null;
    }
  }
  
  public m setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    return this;
  }
  
  public m setCustomTitle(View paramView)
  {
    return this;
  }
  
  public m setTitle(CharSequence paramCharSequence)
  {
    return this;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */