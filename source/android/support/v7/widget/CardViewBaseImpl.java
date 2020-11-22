package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;

class CardViewBaseImpl
  implements CardViewImpl
{
  final RectF mCornerRect = new RectF();
  
  private RoundRectDrawableWithShadow createBackground(Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return new RoundRectDrawableWithShadow(paramContext.getResources(), paramColorStateList, paramFloat1, paramFloat2, paramFloat3);
  }
  
  private RoundRectDrawableWithShadow getShadowBackground(CardViewDelegate paramCardViewDelegate)
  {
    return (RoundRectDrawableWithShadow)paramCardViewDelegate.getCardBackground();
  }
  
  public ColorStateList getBackgroundColor(CardViewDelegate paramCardViewDelegate)
  {
    return getShadowBackground(paramCardViewDelegate).getColor();
  }
  
  public float getElevation(CardViewDelegate paramCardViewDelegate)
  {
    return getShadowBackground(paramCardViewDelegate).getShadowSize();
  }
  
  public float getMaxElevation(CardViewDelegate paramCardViewDelegate)
  {
    return getShadowBackground(paramCardViewDelegate).getMaxShadowSize();
  }
  
  public float getMinHeight(CardViewDelegate paramCardViewDelegate)
  {
    return getShadowBackground(paramCardViewDelegate).getMinHeight();
  }
  
  public float getMinWidth(CardViewDelegate paramCardViewDelegate)
  {
    return getShadowBackground(paramCardViewDelegate).getMinWidth();
  }
  
  public float getRadius(CardViewDelegate paramCardViewDelegate)
  {
    return getShadowBackground(paramCardViewDelegate).getCornerRadius();
  }
  
  public void initStatic()
  {
    RoundRectDrawableWithShadow.sRoundRectHelper = new RoundRectDrawableWithShadow.RoundRectHelper()
    {
      public void drawRoundRect(Canvas paramAnonymousCanvas, RectF paramAnonymousRectF, float paramAnonymousFloat, Paint paramAnonymousPaint)
      {
        float f1 = 2.0F * paramAnonymousFloat;
        float f2 = paramAnonymousRectF.width() - f1 - 1.0F;
        float f3 = paramAnonymousRectF.height();
        if (paramAnonymousFloat >= 1.0F)
        {
          float f4 = paramAnonymousFloat + 0.5F;
          RectF localRectF = CardViewBaseImpl.this.mCornerRect;
          float f5 = -f4;
          localRectF.set(f5, f5, f4, f4);
          int i = paramAnonymousCanvas.save();
          paramAnonymousCanvas.translate(paramAnonymousRectF.left + f4, paramAnonymousRectF.top + f4);
          paramAnonymousCanvas.drawArc(CardViewBaseImpl.this.mCornerRect, 180.0F, 90.0F, true, paramAnonymousPaint);
          paramAnonymousCanvas.translate(f2, 0.0F);
          paramAnonymousCanvas.rotate(90.0F);
          paramAnonymousCanvas.drawArc(CardViewBaseImpl.this.mCornerRect, 180.0F, 90.0F, true, paramAnonymousPaint);
          paramAnonymousCanvas.translate(f3 - f1 - 1.0F, 0.0F);
          paramAnonymousCanvas.rotate(90.0F);
          paramAnonymousCanvas.drawArc(CardViewBaseImpl.this.mCornerRect, 180.0F, 90.0F, true, paramAnonymousPaint);
          paramAnonymousCanvas.translate(f2, 0.0F);
          paramAnonymousCanvas.rotate(90.0F);
          paramAnonymousCanvas.drawArc(CardViewBaseImpl.this.mCornerRect, 180.0F, 90.0F, true, paramAnonymousPaint);
          paramAnonymousCanvas.restoreToCount(i);
          paramAnonymousCanvas.drawRect(paramAnonymousRectF.left + f4 - 1.0F, paramAnonymousRectF.top, paramAnonymousRectF.right - f4 + 1.0F, paramAnonymousRectF.top + f4, paramAnonymousPaint);
          paramAnonymousCanvas.drawRect(paramAnonymousRectF.left + f4 - 1.0F, paramAnonymousRectF.bottom - f4, paramAnonymousRectF.right - f4 + 1.0F, paramAnonymousRectF.bottom, paramAnonymousPaint);
        }
        paramAnonymousCanvas.drawRect(paramAnonymousRectF.left, paramAnonymousRectF.top + paramAnonymousFloat, paramAnonymousRectF.right, paramAnonymousRectF.bottom - paramAnonymousFloat, paramAnonymousPaint);
      }
    };
  }
  
  public void initialize(CardViewDelegate paramCardViewDelegate, Context paramContext, ColorStateList paramColorStateList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramContext = createBackground(paramContext, paramColorStateList, paramFloat1, paramFloat2, paramFloat3);
    paramContext.setAddPaddingForCorners(paramCardViewDelegate.getPreventCornerOverlap());
    paramCardViewDelegate.setCardBackground(paramContext);
    updatePadding(paramCardViewDelegate);
  }
  
  public void onCompatPaddingChanged(CardViewDelegate paramCardViewDelegate) {}
  
  public void onPreventCornerOverlapChanged(CardViewDelegate paramCardViewDelegate)
  {
    getShadowBackground(paramCardViewDelegate).setAddPaddingForCorners(paramCardViewDelegate.getPreventCornerOverlap());
    updatePadding(paramCardViewDelegate);
  }
  
  public void setBackgroundColor(CardViewDelegate paramCardViewDelegate, @Nullable ColorStateList paramColorStateList)
  {
    getShadowBackground(paramCardViewDelegate).setColor(paramColorStateList);
  }
  
  public void setElevation(CardViewDelegate paramCardViewDelegate, float paramFloat)
  {
    getShadowBackground(paramCardViewDelegate).setShadowSize(paramFloat);
  }
  
  public void setMaxElevation(CardViewDelegate paramCardViewDelegate, float paramFloat)
  {
    getShadowBackground(paramCardViewDelegate).setMaxShadowSize(paramFloat);
    updatePadding(paramCardViewDelegate);
  }
  
  public void setRadius(CardViewDelegate paramCardViewDelegate, float paramFloat)
  {
    getShadowBackground(paramCardViewDelegate).setCornerRadius(paramFloat);
    updatePadding(paramCardViewDelegate);
  }
  
  public void updatePadding(CardViewDelegate paramCardViewDelegate)
  {
    Rect localRect = new Rect();
    getShadowBackground(paramCardViewDelegate).getMaxShadowAndCornerPadding(localRect);
    paramCardViewDelegate.setMinWidthHeightInternal((int)Math.ceil(getMinWidth(paramCardViewDelegate)), (int)Math.ceil(getMinHeight(paramCardViewDelegate)));
    paramCardViewDelegate.setShadowPadding(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\CardViewBaseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */