package com.totoro.school.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build.VERSION;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class ShapedImageView
  extends AppCompatImageView
{
  float a;
  float b;
  
  public ShapedImageView(Context paramContext)
  {
    this(paramContext, null);
    a(paramContext, null);
  }
  
  public ShapedImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    a(paramContext, paramAttributeSet);
  }
  
  public ShapedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT < 18) {
      setLayerType(1, null);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.a >= 12.0F) && (this.b > 12.0F))
    {
      Path localPath = new Path();
      localPath.moveTo(12.0F, 0.0F);
      localPath.lineTo(this.a - 12.0F, 0.0F);
      localPath.quadTo(this.a, 0.0F, this.a, 12.0F);
      localPath.lineTo(this.a, this.b - 12.0F);
      localPath.quadTo(this.a, this.b, this.a - 12.0F, this.b);
      localPath.lineTo(12.0F, this.b);
      localPath.quadTo(0.0F, this.b, 0.0F, this.b - 12.0F);
      localPath.lineTo(0.0F, 12.0F);
      localPath.quadTo(0.0F, 0.0F, 12.0F, 0.0F);
      paramCanvas.clipPath(localPath);
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.a = getWidth();
    this.b = getHeight();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\ShapedImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */