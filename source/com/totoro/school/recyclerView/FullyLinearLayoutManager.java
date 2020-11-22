package com.totoro.school.recyclerView;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.view.View.MeasureSpec;

public class FullyLinearLayoutManager
  extends LinearLayoutManager
{
  private static final String a = "FullyLinearLayoutManager";
  private int[] b = new int[2];
  
  public FullyLinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
  }
  
  /* Error */
  private void a(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: invokevirtual 28	android/support/v7/widget/RecyclerView$Recycler:getViewForPosition	(I)Landroid/view/View;
    //   5: astore 6
    //   7: aload 6
    //   9: ifnull +113 -> 122
    //   12: aload 6
    //   14: invokevirtual 34	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   17: checkcast 36	android/support/v7/widget/RecyclerView$LayoutParams
    //   20: astore 7
    //   22: aload 6
    //   24: iload_3
    //   25: aload_0
    //   26: invokevirtual 40	com/totoro/school/recyclerView/FullyLinearLayoutManager:getPaddingLeft	()I
    //   29: aload_0
    //   30: invokevirtual 43	com/totoro/school/recyclerView/FullyLinearLayoutManager:getPaddingRight	()I
    //   33: iadd
    //   34: aload 7
    //   36: getfield 47	android/support/v7/widget/RecyclerView$LayoutParams:width	I
    //   39: invokestatic 53	android/view/ViewGroup:getChildMeasureSpec	(III)I
    //   42: iload 4
    //   44: aload_0
    //   45: invokevirtual 56	com/totoro/school/recyclerView/FullyLinearLayoutManager:getPaddingTop	()I
    //   48: aload_0
    //   49: invokevirtual 59	com/totoro/school/recyclerView/FullyLinearLayoutManager:getPaddingBottom	()I
    //   52: iadd
    //   53: aload 7
    //   55: getfield 62	android/support/v7/widget/RecyclerView$LayoutParams:height	I
    //   58: invokestatic 53	android/view/ViewGroup:getChildMeasureSpec	(III)I
    //   61: invokevirtual 66	android/view/View:measure	(II)V
    //   64: aload 5
    //   66: iconst_0
    //   67: aload 6
    //   69: invokevirtual 69	android/view/View:getMeasuredWidth	()I
    //   72: aload 7
    //   74: getfield 72	android/support/v7/widget/RecyclerView$LayoutParams:leftMargin	I
    //   77: iadd
    //   78: aload 7
    //   80: getfield 75	android/support/v7/widget/RecyclerView$LayoutParams:rightMargin	I
    //   83: iadd
    //   84: iastore
    //   85: aload 5
    //   87: iconst_1
    //   88: aload 6
    //   90: invokevirtual 78	android/view/View:getMeasuredHeight	()I
    //   93: aload 7
    //   95: getfield 81	android/support/v7/widget/RecyclerView$LayoutParams:bottomMargin	I
    //   98: iadd
    //   99: aload 7
    //   101: getfield 84	android/support/v7/widget/RecyclerView$LayoutParams:topMargin	I
    //   104: iadd
    //   105: iastore
    //   106: aload_1
    //   107: aload 6
    //   109: invokevirtual 88	android/support/v7/widget/RecyclerView$Recycler:recycleView	(Landroid/view/View;)V
    //   112: return
    //   113: astore_1
    //   114: goto +9 -> 123
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 91	java/lang/Exception:printStackTrace	()V
    //   122: return
    //   123: aload_1
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	FullyLinearLayoutManager
    //   0	125	1	paramRecycler	RecyclerView.Recycler
    //   0	125	2	paramInt1	int
    //   0	125	3	paramInt2	int
    //   0	125	4	paramInt3	int
    //   0	125	5	paramArrayOfInt	int[]
    //   5	103	6	localView	android.view.View
    //   20	80	7	localLayoutParams	android.support.v7.widget.RecyclerView.LayoutParams
    // Exception table:
    //   from	to	target	type
    //   0	7	113	finally
    //   12	112	113	finally
    //   118	122	113	finally
    //   0	7	117	java/lang/Exception
    //   12	112	117	java/lang/Exception
  }
  
  public void onMeasure(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    int i = 0;
    paramInt2 = 0;
    paramInt1 = 0;
    while (i < getItemCount())
    {
      a(paramRecycler, i, View.MeasureSpec.makeMeasureSpec(i, 0), View.MeasureSpec.makeMeasureSpec(i, 0), this.b);
      int m;
      if (getOrientation() == 0)
      {
        m = paramInt2 + this.b[0];
        paramInt2 = m;
        if (i == 0)
        {
          paramInt1 = this.b[1];
          paramInt2 = m;
        }
      }
      else
      {
        m = paramInt1 + this.b[1];
        paramInt1 = m;
        if (i == 0)
        {
          paramInt2 = this.b[0];
          paramInt1 = m;
        }
      }
      i += 1;
    }
    i = k;
    if (i1 != 1073741824) {
      i = paramInt2;
    }
    paramInt2 = j;
    if (n != 1073741824) {
      paramInt2 = paramInt1;
    }
    setMeasuredDimension(i, paramInt2);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\recyclerView\FullyLinearLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */