package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.RequiresApi;

@RequiresApi(17)
class CardViewApi17Impl
  extends CardViewBaseImpl
{
  public void initStatic()
  {
    RoundRectDrawableWithShadow.sRoundRectHelper = new RoundRectDrawableWithShadow.RoundRectHelper()
    {
      public void drawRoundRect(Canvas paramAnonymousCanvas, RectF paramAnonymousRectF, float paramAnonymousFloat, Paint paramAnonymousPaint)
      {
        paramAnonymousCanvas.drawRoundRect(paramAnonymousRectF, paramAnonymousFloat, paramAnonymousFloat, paramAnonymousPaint);
      }
    };
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\CardViewApi17Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */