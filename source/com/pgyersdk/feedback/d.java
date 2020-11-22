package com.pgyersdk.feedback;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.pgyersdk.PgyerProvider;
import com.pgyersdk.f.h;
import java.io.File;

public class d
  extends RelativeLayout
  implements View.OnClickListener
{
  private static String a = "#ffffff";
  public static String b = "#2E2D2D";
  public static String c = "#2E2D2D";
  public static String d = "#272828";
  public static String e;
  ColorDrawable A;
  private String f;
  public com.pgyersdk.feedback.a.b g;
  com.pgyersdk.feedback.a.e h;
  com.pgyersdk.feedback.a.a i;
  com.pgyersdk.feedback.a.a j;
  com.pgyersdk.feedback.a.a k;
  private com.pgyersdk.feedback.a.a l;
  private com.pgyersdk.feedback.a.a m;
  public View n;
  private View o;
  private Context p;
  int q;
  int r;
  ObjectAnimator s;
  ObjectAnimator t;
  TranslateAnimation u;
  TranslateAnimation v;
  private boolean w = false;
  private ImageView x;
  private String y = "#ED3A3A";
  LinearLayout.LayoutParams z;
  
  public d(Context paramContext, String paramString)
  {
    super(paramContext);
    this.p = paramContext;
    this.f = paramString;
    if (this.p.getResources().getConfiguration().orientation == 1)
    {
      b(this.p);
      return;
    }
    c(this.p);
  }
  
  private View a(Context paramContext)
  {
    LinearLayout.LayoutParams localLayoutParams1 = getDefaultLayoutParams1();
    localLayoutParams1.gravity = 16;
    LinearLayout localLinearLayout1 = new LinearLayout(paramContext);
    localLinearLayout1.setOrientation(0);
    localLinearLayout1.setBackgroundColor(Color.parseColor(c));
    LinearLayout localLinearLayout2 = new LinearLayout(paramContext);
    localLinearLayout2.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams2 = getDefaultLayoutParams();
    localLayoutParams2.gravity = 17;
    this.i = new com.pgyersdk.feedback.a.a(paramContext);
    this.i.setImageBitmap(com.pgyersdk.f.e.a(com.pgyersdk.f.e.a("iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAMAAAANIilAAAAAq1BMVEUAAAD////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////Nr6iZAAAAOHRSTlMAMlEu/fKAVlPa0GJbLBv69+uRXjs2BwPVzLmklXjdoZtybEQ+JRgRtnVpKSEN5sjEv7CNh3sBqutKTB8AAAHpSURBVEjH7VbZdqowFAUUEESRQWYUB+rQ1jq2+/+/7ILQhtV7APvQp7IfkpBkrzNyTrgOHf4W3nkrCtSZ4m9NrfdD7lTy+iihqzH/ONPZewC8+c0ShOEtVACow/fHuMMDkMgbtrGR58BMe4D6fIQYl0yGJ6mP4KWNKwDmK3XwNMdk3aIyIHx99E6Rk8/jwt0aMGziDmCM2JcHLLLJFrEvQgA/H0c0dwQxvS/2Ozcbj4WoBDiU52OOkxGQXFeBfV8sADNXN9lxn5KZbiJt+QLXYhECb2w7t5n5s09r7YiGW94++d+uMG5NsmmQuGYMMKnh9o4YN3NliDmXtljJp6VydWvlZsZPZYc4+0CSmwvArrM3d9wJVJa+4ZaNGwP9lJar33U2QanuYXn/MSS70V6JVEzFssnPYhnsC3hS7biey3LjTNq8xSUbW3PDOFDBkKDWxpflxjNCsoQEsHh5FyXS6j9fseQ2sSIFpDpKfDjfc+MTr/qMozG6RMtVL7XP2FaKcJEbJUK01sEz1l+iJgZf9ZzPtUFgIV9VyyGPybiVfGVeqVo/1bFu7xiGQcXSYpW1UesFUbdD6GuuHTtYVMfYvnAPIO0jGmwqTI31qnYIPgAljPMuGc+LLun+Yn+mXwZB/jLo0KHDD/APMKg3IQLxv2kAAAAASUVORK5CYII="), com.pgyersdk.f.b.a(paramContext, 40.0F), com.pgyersdk.f.b.a(paramContext, 40.0F)));
    this.i.setOnClickListener(this);
    localLinearLayout2.addView(this.i, localLayoutParams2);
    this.A = new ColorDrawable(Color.parseColor(this.y));
    LinearLayout.LayoutParams localLayoutParams3 = getDefaultLayoutParams();
    localLayoutParams3.setMargins(0, -com.pgyersdk.f.b.a(paramContext, 10.0F), 0, 0);
    localLayoutParams3.gravity = 1;
    localLayoutParams3.height = com.pgyersdk.f.b.a(paramContext, 4.0F);
    localLayoutParams3.width = com.pgyersdk.f.b.a(paramContext, 20.0F);
    this.x = new ImageView(paramContext);
    this.x.setImageDrawable(this.A);
    this.x.setBackgroundColor(-1);
    this.x.setPadding(1, 1, 1, 1);
    localLinearLayout2.addView(this.x, localLayoutParams3);
    localLayoutParams3 = getDefaultLayoutParams1();
    localLayoutParams3.gravity = 16;
    localLinearLayout1.addView(localLinearLayout2, localLayoutParams3);
    localLinearLayout2 = new LinearLayout(paramContext);
    this.j = new com.pgyersdk.feedback.a.a(paramContext);
    this.j.setImageBitmap(com.pgyersdk.f.e.a(com.pgyersdk.f.e.a(com.pgyersdk.c.a.o), com.pgyersdk.f.b.a(paramContext, 40.0F), com.pgyersdk.f.b.a(paramContext, 40.0F)));
    this.j.setOnClickListener(this);
    localLinearLayout2.addView(this.j, localLayoutParams2);
    localLinearLayout1.addView(localLinearLayout2, localLayoutParams1);
    localLinearLayout2 = new LinearLayout(paramContext);
    this.k = new com.pgyersdk.feedback.a.a(paramContext);
    this.k.setImageBitmap(com.pgyersdk.f.e.a(com.pgyersdk.f.e.a("iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAMAAAANIilAAAAAq1BMVEUAAAD////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////Nr6iZAAAAOHRSTlMAY1IE3JsX+uzo18GRVk80Eb25qH5oYFouDQj1x7CsiHNDJRry4tLNtqWgjEk9OCEcAe6FeW0pMjZ5GTkAAAF+SURBVEjH7ZXHkoJQEEVbJYNIUBFUkjln5/7/lw1VDkUpQ5i3mQ1n10UdoLr7vkcNDf+FPomY3c5OdFjdkQIMGN0QMNFiUmcW5LjHJnfn2Aiks8gGj3GXiNoM8mEB80xsch+4E73k7t/U5wTLHqVyaLiX+m4L0DppMUSCrGqtU60B+ZD0rPziN1OVQwIXzqrc/Ri+m+/9qGUBCNzSVQ6K19EYyJDKumfCFKgQLwRuVIgF9VwalBX44t++AQ8qw0JQ0rA5pgZlXDx6ZwW92BZsXNtZGSkcN/G1YZxO/oyxQcUMAc1LCwdzTkSCvIvSxzyVEKtQsvUckif0BlsZWL4GpeBUFYx+Kjs/vTzYwOpIRDoCKuW4gHr6jGTMv94pSVSOy0N0cnk+KJh2iEePKmhfYeeOIc/G5HJEvzIjwhrSM3cAasm3x+s9VfIA1E+Ztthw3J2qGS1/SZkJcaHVvG5yKXRlSFuqhdChTyKINjFjYc0ujxSf2HHa1NDQ0PDONzsAKUS0GwsiAAAAAElFTkSuQmCC"), com.pgyersdk.f.b.a(paramContext, 40.0F), com.pgyersdk.f.b.a(paramContext, 40.0F)));
    this.k.setOnClickListener(this);
    localLinearLayout2.addView(this.k, localLayoutParams2);
    localLinearLayout1.addView(localLinearLayout2, localLayoutParams1);
    return localLinearLayout1;
  }
  
  private View a(Context paramContext, a parama, int paramInt, Paint paramPaint)
  {
    Object localObject2 = new ShapeDrawable(new a(this, paramPaint, paramContext, paramInt));
    paramPaint = new FrameLayout(paramContext);
    Object localObject1 = new BitmapDrawable(com.pgyersdk.f.e.a("iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAMAAAANIilAAAAAV1BMVEUAAAD///////////////////////////////////////////////////////////////////////////////////////////////////////////////+ORg7oAAAAHHRSTlMA+8MbFQ/vP8molVVIBtB88+S+QrSzrqVzcN99O8Pg/gAAASJJREFUSMe111mOgzAQBNC2wWbfIQtT9z/nSBESIiFgupT3X5J3d8s+VzZZ2rVA26VZUzoJFj2swYaxjygomkwGO8yUnEctvrLH8eiOQ/eDwRceJ3wh+6ocAfJqL+t6BLHxZzZOEaj+SLsawWr3Nt8eF/Tbeee4JN/sES4q1mzkcZFfT8sNl91kMUBhWMIWCna5SFBJXuEJKtPrXBqomFhEnlB6rsulWjJnoGSclFArpYHan2RQyySFWiod1DppodYKCEzYMMP2zILN1FZRh4Q6ntTFoK4k8xhQzxD7AMoIlZF69JnvhvromC+W+tyZsoIpaIhSylayEdeAqgRc0oosUbgSJTNRrBNtgqZBGeRMMu63RmPy66ZsbQdnb4yfD9rBf/ksMN7cBHqMAAAAAElFTkSuQmCC"));
    if (Build.VERSION.SDK_INT >= 16) {
      paramPaint.setBackground((Drawable)localObject1);
    }
    localObject1 = new TextView(paramContext);
    ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
    ((TextView)localObject1).setClickable(true);
    ((TextView)localObject1).setTag(parama);
    ((TextView)localObject1).setOnClickListener(new b(this));
    ((TextView)localObject1).setGravity(17);
    paramPaint.addView((View)localObject1);
    parama = new ImageView(paramContext);
    parama.setImageBitmap(com.pgyersdk.f.e.a("iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAYAAAA6/NlyAAAAAXNSR0IArs4c6QAA ABxpRE9UAAAAAgAAAAAAAAAeAAAAKAAAAB4AAAAeAAABamLW3/kAAAE2SURBVGgF 1JlbC8IwDIWnvqgPCuJt4OX//8qZ8xAoQ9xMs5y0EDqVtvly2tR2XbdcWUvXO7Gj 2FnsLvYQe4m9xbphGMIN43qWjXR2EAMcoH5ZOCwC7FW20tF1AnAM3yQwQOeoOYbF 56aAMXWxLr+BzP2uGeC9gD4rYZtQeCWQJwdQnQGpFcYWc3OETa0w1mvvDJsWGMou AZsSGGvWexrr+k0J7JmgSlB9TpW0sPWoY0vVaYCRpDz22alApQG+BKiLYKQAxn/j KWW8fk8BbD0IWIJAB45UN8WU/vc8a1G1bENVGJm5dCbimQqMa5kIyHIMKnBkslJo GjAOCOpEZE0DxlVqJKiORQPGvbE6EVnTgGsv46xBogEzEhaCRAPG6w+rSjXtaMD6 rqfGeUtbGrDFWY82FOAPAAAA//+Fw8fAAAAA9UlEQVTl2ckOAjEIgGFcDupBE+O+ vv9TVn7j3F1aoNKETK9fmMLQERG5O4WUUsxDrXLLBr5kAx+ygTfZwKts4Hk28Dgb WL3iUbjMezB9f1hL3Vh/gLiCJ9nAZHpnjHbNMOBZNjBoy+LlnmHAllkOAQa91bCo 2GHAVOyrAToMWK2yyAYGvW6MDpVhwCONfUN0ODBoBotTI3RIMGiK2LEBOiwYNJmu /XqHBoPmTNcsZOHBoFm0rBp9uhswaM71r5d/XYFBs/j2/nbg6BL8VL/gn87TXYMH +FQ3XBe9k/W/AA9wnrQyroC592YCo5efNSh4/M9yAT8APkf75B/DphwAAAAASUVO RK5CYII="));
    localObject2 = new ImageView(paramContext);
    FrameLayout.LayoutParams localLayoutParams = getDefaultFrameLayoutParams();
    localLayoutParams.width = com.pgyersdk.f.b.a(paramContext, 10.0F);
    localLayoutParams.height = localLayoutParams.width;
    localLayoutParams.gravity = 17;
    ((ImageView)localObject2).setImageBitmap(com.pgyersdk.f.e.a("iVBORw0KGgoAAAANSUhEUgAAACQAAAAcCAYAAAAJKR1YAAAAAXNSR0IArs4c6QAA AAlwSFlzAAAWJQAAFiUBSVIk8AAAABxpRE9UAAAAAgAAAAAAAAAOAAAAKAAAAA4A AAAOAAABhhAbPSQAAAFSSURBVFgJvJU9SgRBEIUnEhVFEQTBQDDxFN7BQMRANhED MRENxMTbGBgaiCAGIiIGipFgIhgIHmAx8f97sE962t6ZRpwJHjXVVfXqg53eKV66 3aJFDbBrHy3229k2zCEgX+gdLaeg2gIaYvkxEowlqA4qMZSSuPhP+TA+p8ggYfzg fC3c0zTQKMvO+8AY7JP6hqGaBBpjyWUNTAi1LaimgCYwv86EMZTibhXQAg0HSFe1 qi+uTdJ/i8JFuc97sZnzJQxfe6ZHxEHkWlWcou+uN5cL4b4d7UiZr1DQlXSj4gnS bUn1+2ya+j0K53Ke9VJv2dtmjqsUYhibnlEb8WAUZ8gfkHtzY+mGydMgiutIDVVm F9R1e8K5WfLHmrmU56//IPnaeJOkDsamV/SOaxjNoSfkWm7Ur9BB3v8T9aCXKdfI fTfMzKPnP8y+MZP8jnFefAMAAP//TmVJhgAAARVJREFUvZO9agJBFIV9DMFCsBGs RAkWEcRCBLEQi1RWaaxSWvl2PoWNYBEIBILKKv4gmu8WC7PLnXVm17X42Jk7955z mGUKhyCYw/1FnPEZQ8FGeDB7QaATHkNbkLAeBpLvF9wgj9s6oNsH009dx4vTHELt 0ey6hJGeeCDZf8IVnnFTO3TaoPmoNbWIwASyhtqi0fIJI722QFL/gAukuak/5pqQ pK+eqUVDaMRanqpPqF/664bGI4/IeWRjERlQP4JLqB/6ahYdF6/EX2YK9DCRp5sU 6pvzapYwMmuaPlp3GAhAC7WmXhHBrPgKvGMor8cMtWJfzhoknPcNJP1vsAEJtYQS pNFRZ9Sig0GDngUUHXq9PP4B62fQcqx0J7wAAAAASUVORK5CYII="));
    ((ImageView)localObject2).setVisibility(8);
    ((a)((TextView)localObject1).getTag()).b = ((ImageView)localObject2);
    if (this.y.equals(((a)((TextView)localObject1).getTag()).a)) {
      ((ImageView)localObject2).setVisibility(0);
    }
    paramPaint.addView(parama);
    paramPaint.addView((View)localObject2, localLayoutParams);
    return paramPaint;
  }
  
  private com.pgyersdk.feedback.a.e a(Context paramContext, int paramInt)
  {
    this.h = new com.pgyersdk.feedback.a.e(paramContext, Color.parseColor(d));
    this.h.setGravity(16);
    Object localObject = this.h;
    int i2 = com.pgyersdk.f.b.a(paramContext, 5.0F);
    int i1 = 0;
    ((LinearLayout)localObject).setPadding(0, 0, 0, i2);
    LinearLayout.LayoutParams localLayoutParams = getDefaultLayoutParams1();
    localLayoutParams.setMargins(com.pgyersdk.f.b.a(paramContext, 10.0F), 0, com.pgyersdk.f.b.a(paramContext, 10.0F), 0);
    localLayoutParams.gravity = 16;
    localLayoutParams.height = com.pgyersdk.f.b.a(paramContext, 30.0F);
    while (i1 < 6)
    {
      Paint localPaint = new Paint();
      localPaint.setStyle(Paint.Style.FILL);
      localObject = "#ED3A3A";
      switch (i1)
      {
      default: 
        break;
      case 5: 
        localObject = "#E5E5E5";
        break;
      case 4: 
        localObject = "#F77A00";
        break;
      case 3: 
        localObject = "#F1B600";
        break;
      case 2: 
        localObject = "#5CC500";
        break;
      case 1: 
        localObject = "#006AA1";
        break;
      case 0: 
        localObject = "#ED3A3A";
      }
      localPaint.setColor(Color.parseColor((String)localObject));
      a locala = new a();
      locala.a = ((String)localObject);
      this.h.addView(a(paramContext, locala, paramInt, localPaint), localLayoutParams);
      i1 += 1;
    }
    return this.h;
  }
  
  private void a()
  {
    com.pgyersdk.feedback.a.m localm = new com.pgyersdk.feedback.a.m(this.p).a(true).setCancelable(true);
    AlertDialog localAlertDialog = localm.create();
    localAlertDialog.setOnDismissListener(new c(this, localm));
    localAlertDialog.show();
  }
  
  private void a(View paramView)
  {
    int i1 = 0;
    while (i1 < this.h.getChildCount())
    {
      FrameLayout localFrameLayout = (FrameLayout)this.h.getChildAt(i1);
      int i2 = 0;
      while (i2 < localFrameLayout.getChildCount())
      {
        View localView = localFrameLayout.getChildAt(i2);
        if (((localView instanceof TextView)) && ((localView.getTag() instanceof a)))
        {
          a locala = (a)localView.getTag();
          if (localView.equals(paramView))
          {
            locala.b.setVisibility(0);
            this.y = locala.a;
            this.A = new ColorDrawable(Color.parseColor(this.y));
            this.x.setImageDrawable(this.A);
          }
          else
          {
            locala.b.setVisibility(8);
          }
        }
        i2 += 1;
      }
      i1 += 1;
    }
  }
  
  private void a(com.pgyersdk.feedback.a.m paramm)
  {
    h.a("selfmail", paramm.d().getText().toString().trim());
    h.a("feedback_des", paramm.c().getText().toString().trim());
  }
  
  @TargetApi(14)
  private void b(Context paramContext)
  {
    Object localObject1 = new LinearLayout(paramContext);
    ((LinearLayout)localObject1).setBackgroundColor(-1);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setFitsSystemWindows(true);
    ((LinearLayout)localObject1).setClipToPadding(false);
    Object localObject2 = getDefaultLayoutParams();
    this.o = d(paramContext);
    ((LinearLayout)localObject1).addView(this.o, (ViewGroup.LayoutParams)localObject2);
    this.z = getDefaultLayoutParams();
    localObject2 = new LinearLayout(paramContext);
    ((LinearLayout)localObject2).setGravity(17);
    this.z.setMargins(com.pgyersdk.f.b.a(paramContext, 40.0F), 0, com.pgyersdk.f.b.a(paramContext, 40.0F), 0);
    this.z.gravity = 17;
    this.g = new com.pgyersdk.feedback.a.b(paramContext);
    this.g.setScaleType(ImageView.ScaleType.FIT_XY);
    this.q = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.r = paramContext.getResources().getDisplayMetrics().heightPixels;
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.o.measure(i1, i2);
    i1 = this.o.getMeasuredHeight();
    this.z.height = (this.r - i1 - com.pgyersdk.f.b.a(paramContext, 70.0F));
    Object localObject3 = this.z;
    ((LinearLayout.LayoutParams)localObject3).width = (((LinearLayout.LayoutParams)localObject3).height * this.q / this.r);
    this.g.setImageBitmap(com.pgyersdk.f.e.a(paramContext, this.f, this.z.width, this.z.height));
    ((LinearLayout)localObject2).addView(this.g, this.z);
    ((LinearLayout)localObject1).addView((View)localObject2, getDefaultLayoutParams1());
    addView((View)localObject1);
    i1 = com.pgyersdk.f.b.a(paramContext, 30.0F);
    i2 = com.pgyersdk.f.b.a(paramContext, 120.0F);
    localObject1 = getRelativeLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
    ((RelativeLayout.LayoutParams)localObject1).width = (i2 + i1 * 6);
    ((RelativeLayout.LayoutParams)localObject1).height = com.pgyersdk.f.b.a(paramContext, 45.0F);
    ((RelativeLayout.LayoutParams)localObject1).setMargins(com.pgyersdk.f.b.a(paramContext, 5.0F), 0, 0, 0);
    this.h = a(paramContext, i1);
    addView(this.h, (ViewGroup.LayoutParams)localObject1);
    localObject2 = getRelativeLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    localObject3 = new LinearLayout(paramContext);
    ((LinearLayout)localObject3).setLayoutParams(getDefaultLayoutParams());
    ((LinearLayout)localObject3).setOrientation(1);
    localObject1 = getDefaultLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).height = com.pgyersdk.f.b.a(paramContext, 45.0F);
    ((LinearLayout.LayoutParams)localObject1).gravity = 16;
    ((LinearLayout)localObject3).addView(a(paramContext), (ViewGroup.LayoutParams)localObject1);
    addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
    this.n = new View(paramContext);
    localObject2 = getRelativeLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).height = this.r;
    ((RelativeLayout.LayoutParams)localObject2).width = this.q;
    this.n.setBackgroundColor(Color.parseColor("#9f000000"));
    addView(this.n, (ViewGroup.LayoutParams)localObject2);
    this.n.setVisibility(8);
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.s = ObjectAnimator.ofFloat(this.h, "translationY", new float[] { 0.0F, -(((LinearLayout.LayoutParams)localObject1).height + com.pgyersdk.f.b.a(paramContext, 2.0F)) });
      this.s.setDuration(300L);
      this.t = ObjectAnimator.ofFloat(this.h, "translationY", new float[] { -(((LinearLayout.LayoutParams)localObject1).height + com.pgyersdk.f.b.a(paramContext, 2.0F)), 0.0F });
      this.t.setDuration(300L);
      return;
    }
    this.u = new TranslateAnimation(0.0F, 0.0F, 0.0F, -com.pgyersdk.f.b.a(paramContext, 45.0F));
    this.u.setDuration(300L);
    this.u.setFillAfter(true);
    this.u.setFillEnabled(true);
    this.v = new TranslateAnimation(0.0F, 0.0F, com.pgyersdk.f.b.a(paramContext, 45.0F), 0.0F);
    this.v.setDuration(300L);
    this.v.setFillAfter(true);
    this.v.setFillEnabled(true);
  }
  
  @TargetApi(14)
  private void c(Context paramContext)
  {
    Object localObject1 = new LinearLayout(paramContext);
    ((LinearLayout)localObject1).setBackgroundColor(-1);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setFitsSystemWindows(true);
    ((LinearLayout)localObject1).setClipToPadding(false);
    Object localObject2 = getDefaultLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).width = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.o = d(paramContext);
    ((LinearLayout)localObject1).addView(this.o, (ViewGroup.LayoutParams)localObject2);
    this.z = getDefaultLayoutParams();
    localObject2 = new LinearLayout(paramContext);
    ((LinearLayout)localObject2).setGravity(17);
    this.z.setMargins(com.pgyersdk.f.b.a(paramContext, 40.0F), 0, com.pgyersdk.f.b.a(paramContext, 40.0F), 0);
    this.z.gravity = 49;
    this.g = new com.pgyersdk.feedback.a.b(paramContext);
    this.g.setScaleType(ImageView.ScaleType.FIT_XY);
    this.q = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.r = paramContext.getResources().getDisplayMetrics().heightPixels;
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.o.measure(i1, i2);
    i1 = this.o.getMeasuredHeight();
    this.z.height = (this.r - i1 - com.pgyersdk.f.b.a(paramContext, 70.0F));
    Object localObject3 = this.z;
    ((LinearLayout.LayoutParams)localObject3).width = (((LinearLayout.LayoutParams)localObject3).height * this.q / this.r);
    this.g.setImageBitmap(com.pgyersdk.f.e.a(paramContext, this.f, this.z.width, this.z.height));
    ((LinearLayout)localObject2).addView(this.g, this.z);
    ((LinearLayout)localObject1).addView((View)localObject2, getDefaultLayoutParams1());
    addView((View)localObject1);
    i1 = com.pgyersdk.f.b.a(paramContext, 30.0F);
    i2 = com.pgyersdk.f.b.a(paramContext, 120.0F);
    localObject1 = getRelativeLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
    ((RelativeLayout.LayoutParams)localObject1).width = (i2 + i1 * 6);
    ((RelativeLayout.LayoutParams)localObject1).height = com.pgyersdk.f.b.a(paramContext, 45.0F);
    ((RelativeLayout.LayoutParams)localObject1).setMargins(com.pgyersdk.f.b.a(paramContext, 5.0F), 0, 0, 0);
    this.h = a(paramContext, i1);
    addView(this.h, (ViewGroup.LayoutParams)localObject1);
    localObject2 = getRelativeLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    localObject3 = new LinearLayout(paramContext);
    ((LinearLayout)localObject3).setLayoutParams(getDefaultLayoutParams());
    ((LinearLayout)localObject3).setOrientation(1);
    localObject1 = getDefaultLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).height = com.pgyersdk.f.b.a(paramContext, 45.0F);
    ((LinearLayout.LayoutParams)localObject1).gravity = 16;
    ((LinearLayout)localObject3).addView(a(paramContext), (ViewGroup.LayoutParams)localObject1);
    addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
    this.n = new View(paramContext);
    localObject2 = getRelativeLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).height = this.r;
    ((RelativeLayout.LayoutParams)localObject2).width = this.q;
    this.n.setBackgroundColor(Color.parseColor("#9f000000"));
    addView(this.n, (ViewGroup.LayoutParams)localObject2);
    this.n.setVisibility(8);
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.s = ObjectAnimator.ofFloat(this.h, "translationY", new float[] { 0.0F, -(((LinearLayout.LayoutParams)localObject1).height + com.pgyersdk.f.b.a(paramContext, 2.0F)) });
      this.s.setDuration(300L);
      this.t = ObjectAnimator.ofFloat(this.h, "translationY", new float[] { -(((LinearLayout.LayoutParams)localObject1).height + com.pgyersdk.f.b.a(paramContext, 2.0F)), 0.0F });
      this.t.setDuration(300L);
      return;
    }
    this.u = new TranslateAnimation(0.0F, 0.0F, 0.0F, -com.pgyersdk.f.b.a(paramContext, 45.0F));
    this.u.setDuration(300L);
    this.u.setFillAfter(true);
    this.u.setFillEnabled(true);
    this.v = new TranslateAnimation(0.0F, 0.0F, com.pgyersdk.f.b.a(paramContext, 45.0F), 0.0F);
    this.v.setDuration(300L);
    this.v.setFillAfter(true);
    this.v.setFillEnabled(true);
  }
  
  private View d(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setBackgroundColor(Color.parseColor(b));
    this.l = new com.pgyersdk.feedback.a.a(paramContext);
    this.l.setImageBitmap(com.pgyersdk.f.e.a(com.pgyersdk.f.e.a("iVBORw0KGgoAAAANSUhEUgAAADwAAAA8BAMAAADI0sRBAAAAIVBMVEUAAAD////////////////////////////////////////PIev5AAAACnRSTlMA90eSsOpoKxoI1urS1QAAAJpJREFUOMvtz7sJhEAAhGE54R7phRedYAEmJoaGpjZgCZZgCbYgWqgwBrPs8hcgOtHOLt/CZHcumU8btnKOnp/L3+XxG2LefH0u1uT3/OAHrnxvDtjcGLgxcOOEGxMXRi7MXJi5MHNhTLfhkzZrO6VYtR1xlTPXZubaLI5YnLE4YnPA4oDNAZsDNk8w8lcftnqM+RSWd3bnpNkB6m8e8+TpDLMAAAAASUVORK5CYII="), com.pgyersdk.f.b.a(paramContext, 40.0F), com.pgyersdk.f.b.a(paramContext, 40.0F)));
    LinearLayout.LayoutParams localLayoutParams1 = getDefaultLayoutParams();
    localLayoutParams1.width = com.pgyersdk.f.b.a(paramContext, 50.0F);
    localLayoutParams1.height = localLayoutParams1.width;
    localLayoutParams1.setMargins(0, 0, 0, 0);
    localLayoutParams1.gravity = 16;
    this.l.setOnClickListener(this);
    localLinearLayout.addView(this.l, localLayoutParams1);
    LinearLayout.LayoutParams localLayoutParams2 = getDefaultLayoutParams1();
    TextView localTextView = new TextView(paramContext);
    localTextView.setTextSize(22.0F);
    localTextView.setText(com.pgyersdk.c.b.a(1062));
    localTextView.setTextColor(Color.parseColor(a));
    localTextView.setPadding(30, 20, 0, 20);
    localTextView.setBackgroundColor(Color.parseColor(b));
    localTextView.setGravity(17);
    localLinearLayout.addView(localTextView, localLayoutParams2);
    this.m = new com.pgyersdk.feedback.a.a(paramContext);
    this.m.setImageBitmap(com.pgyersdk.f.e.a(com.pgyersdk.f.e.a("iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAMAAAANIilAAAAApVBMVEUAAAD///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////+4/eNVAAAANnRSTlMA++b07hUN+N6lcDsJ1s0c8OqcSyjRwryqiXY0LAPbysW1sJiWaSQGBIN9ZWJgW1BEMBjioJBbXN1rAAABxUlEQVRIx+2Tx3LbQBAFZwmQyBBAMeecaSrY/f+f5tUaBcgHkQAvLqvYB/LNoWtRU/PkwYPvwmhG5041bDqg7nOPKcoiuUcdxhDZEFdX657C9iNqeJVd30b9bHSpdfErqkEE05EssVouw0rq20JRO4usUc875YwrqOO9hbMKRV4UAwmYVHCfXehsdGjZNEUGzEurT114v4im4ZrT6rEvqW77FlZ/Z3KMG+q/Ns/l3B/vMH8Sg0dqUkKjjNrqwOQlGw44gWg21MpUYOmQHPJvUJxNODG77Z5SVK+eX7VFXwwrVqUqEBRHkrLI4ozzdbVhKlDMYUS8y3KNTYkKSIFuQz2LDZKbFXiVT6ywRvm50b5yUAtFepKCP23Ihz29r2UHlqEUZG3ImevhS2ywm8VKsjYUTAiuLPowATU9msrmbcgZO2on1wgW1sfzLTNMTRtyhrhyg8YgAmLdgz62/i3wS5U56Fn2WN4cLvIZj76UIdSb+UVX/iLmImVxP4q/HklOQr20rCy9AId4vc1OiLS0W6emhZ4FiTcyrWZWSdaEfgS0/a3eQbOabHj1zPNtjlVlw9ZvA7Qqy/nz7lKqywX/g/zgwb/nN0WyL+YC26DcAAAAAElFTkSuQmCC"), com.pgyersdk.f.b.a(paramContext, 40.0F), com.pgyersdk.f.b.a(paramContext, 40.0F)));
    localLayoutParams2 = getDefaultLayoutParams();
    localLayoutParams2.width = com.pgyersdk.f.b.a(paramContext, 50.0F);
    localLayoutParams2.height = localLayoutParams1.width;
    localLayoutParams2.setMargins(0, 0, 0, 0);
    localLayoutParams2.gravity = 16;
    this.m.setOnClickListener(this);
    localLinearLayout.addView(this.m, localLayoutParams2);
    return localLinearLayout;
  }
  
  private FrameLayout.LayoutParams getDefaultFrameLayoutParams()
  {
    return new FrameLayout.LayoutParams(-1, -2);
  }
  
  private LinearLayout.LayoutParams getDefaultLayoutParams()
  {
    return new LinearLayout.LayoutParams(-1, -2);
  }
  
  private LinearLayout.LayoutParams getDefaultLayoutParams1()
  {
    return new LinearLayout.LayoutParams(-1, -2, 1.0F);
  }
  
  private RelativeLayout.LayoutParams getRelativeLayoutParams()
  {
    return new RelativeLayout.LayoutParams(-1, -2);
  }
  
  @TargetApi(11)
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView.equals(this.i))
    {
      if (this.w)
      {
        localObject = this.t;
        if (localObject != null)
        {
          ((ObjectAnimator)localObject).start();
        }
        else
        {
          localObject = this.v;
          if (localObject != null)
          {
            this.h.setAnimation((Animation)localObject);
            this.v.start();
          }
        }
      }
      else
      {
        localObject = this.s;
        if (localObject != null)
        {
          ((ObjectAnimator)localObject).start();
        }
        else
        {
          localObject = this.u;
          if (localObject != null) {
            this.h.startAnimation((Animation)localObject);
          }
        }
      }
      this.w ^= true;
    }
    if (paramView.equals(this.k)) {
      this.g.a();
    }
    if (paramView.equals(this.j))
    {
      this.n.setVisibility(0);
      a();
    }
    if (paramView.equals(this.l))
    {
      com.pgyersdk.b.e.a(e);
      if ((this.p instanceof Activity))
      {
        localObject = this.g;
        if (localObject != null) {
          ((com.pgyersdk.feedback.a.b)localObject).b();
        }
        ((Activity)this.p).finish();
      }
    }
    if (paramView.equals(this.m))
    {
      e = com.pgyersdk.f.c.a().e(this.p);
      com.pgyersdk.f.e.a(this.g.c(), e);
      localObject = h.a(getContext(), "selfmail");
      String str = h.a(getContext(), "feedback_des");
      paramView = null;
      if (!com.pgyersdk.f.k.a(h.a(getContext(), "voicefile"))) {
        paramView = new File(h.a(getContext(), "voicefile"));
      }
      if (com.pgyersdk.f.k.a((String)localObject))
      {
        a();
        Toast.makeText(PgyerProvider.a, com.pgyersdk.c.b.a(1063), 0).show();
        return;
      }
      if (!com.pgyersdk.f.m.a((String)localObject))
      {
        a();
        Toast.makeText(PgyerProvider.a, com.pgyersdk.c.b.a(1046), 0).show();
        return;
      }
      PgyerFeedbackManager.getInstance().b().a((String)localObject, str, e, paramView, null);
    }
  }
  
  static class a
  {
    String a;
    ImageView b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\feedback\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */