package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.appcompat.R.attr;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class AppCompatSeekBar
  extends SeekBar
{
  private final AppCompatSeekBarHelper mAppCompatSeekBarHelper = new AppCompatSeekBarHelper(this);
  
  public AppCompatSeekBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.seekBarStyle);
  }
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mAppCompatSeekBarHelper.loadFromAttributes(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    this.mAppCompatSeekBarHelper.drawableStateChanged();
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    this.mAppCompatSeekBarHelper.jumpDrawablesToCurrentState();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      this.mAppCompatSeekBarHelper.drawTickMarks(paramCanvas);
      return;
    }
    finally
    {
      paramCanvas = finally;
      throw paramCanvas;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\AppCompatSeekBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */