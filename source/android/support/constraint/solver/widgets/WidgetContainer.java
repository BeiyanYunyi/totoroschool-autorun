package android.support.constraint.solver.widgets;

import android.support.constraint.solver.Cache;
import java.util.ArrayList;

public class WidgetContainer
  extends ConstraintWidget
{
  protected ArrayList<ConstraintWidget> mChildren = new ArrayList();
  
  public WidgetContainer() {}
  
  public WidgetContainer(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public WidgetContainer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static Rectangle getBounds(ArrayList<ConstraintWidget> paramArrayList)
  {
    Rectangle localRectangle = new Rectangle();
    if (paramArrayList.size() == 0) {
      return localRectangle;
    }
    int i5 = paramArrayList.size();
    int i3 = Integer.MAX_VALUE;
    int j = 0;
    int n = Integer.MAX_VALUE;
    int k = 0;
    int i4;
    for (int i = 0; j < i5; i = i4)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)paramArrayList.get(j);
      int m = i3;
      if (localConstraintWidget.getX() < i3) {
        m = localConstraintWidget.getX();
      }
      int i1 = n;
      if (localConstraintWidget.getY() < n) {
        i1 = localConstraintWidget.getY();
      }
      int i2 = k;
      if (localConstraintWidget.getRight() > k) {
        i2 = localConstraintWidget.getRight();
      }
      i4 = i;
      if (localConstraintWidget.getBottom() > i) {
        i4 = localConstraintWidget.getBottom();
      }
      j += 1;
      i3 = m;
      n = i1;
      k = i2;
    }
    localRectangle.setBounds(i3, n, k - i3, i - n);
    return localRectangle;
  }
  
  public void add(ConstraintWidget paramConstraintWidget)
  {
    this.mChildren.add(paramConstraintWidget);
    if (paramConstraintWidget.getParent() != null) {
      ((WidgetContainer)paramConstraintWidget.getParent()).remove(paramConstraintWidget);
    }
    paramConstraintWidget.setParent(this);
  }
  
  public void add(ConstraintWidget... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      add(paramVarArgs[i]);
      i += 1;
    }
  }
  
  public ConstraintWidget findWidget(float paramFloat1, float paramFloat2)
  {
    int i = getDrawX();
    int j = getDrawY();
    int k = getWidth();
    int m = getHeight();
    Object localObject1;
    if ((paramFloat1 >= i) && (paramFloat1 <= k + i) && (paramFloat2 >= j) && (paramFloat2 <= m + j)) {
      localObject1 = this;
    } else {
      localObject1 = null;
    }
    i = 0;
    j = this.mChildren.size();
    while (i < j)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
      if ((localConstraintWidget instanceof WidgetContainer))
      {
        localConstraintWidget = ((WidgetContainer)localConstraintWidget).findWidget(paramFloat1, paramFloat2);
        localObject2 = localObject1;
        if (localConstraintWidget == null) {
          break label224;
        }
        localObject1 = localConstraintWidget;
      }
      else
      {
        k = localConstraintWidget.getDrawX();
        m = localConstraintWidget.getDrawY();
        int n = localConstraintWidget.getWidth();
        int i1 = localConstraintWidget.getHeight();
        localObject2 = localObject1;
        if (paramFloat1 < k) {
          break label224;
        }
        localObject2 = localObject1;
        if (paramFloat1 > n + k) {
          break label224;
        }
        localObject2 = localObject1;
        if (paramFloat2 < m) {
          break label224;
        }
        localObject2 = localObject1;
        if (paramFloat2 > i1 + m) {
          break label224;
        }
        localObject1 = localConstraintWidget;
      }
      Object localObject2 = localObject1;
      label224:
      i += 1;
      localObject1 = localObject2;
    }
    return (ConstraintWidget)localObject1;
  }
  
  public ArrayList<ConstraintWidget> findWidgets(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ArrayList localArrayList = new ArrayList();
    Rectangle localRectangle1 = new Rectangle();
    localRectangle1.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt2 = this.mChildren.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(paramInt1);
      Rectangle localRectangle2 = new Rectangle();
      localRectangle2.setBounds(localConstraintWidget.getDrawX(), localConstraintWidget.getDrawY(), localConstraintWidget.getWidth(), localConstraintWidget.getHeight());
      if (localRectangle1.intersects(localRectangle2)) {
        localArrayList.add(localConstraintWidget);
      }
      paramInt1 += 1;
    }
    return localArrayList;
  }
  
  public ArrayList<ConstraintWidget> getChildren()
  {
    return this.mChildren;
  }
  
  public ConstraintWidgetContainer getRootConstraintContainer()
  {
    Object localObject = getParent();
    ConstraintWidgetContainer localConstraintWidgetContainer;
    if ((this instanceof ConstraintWidgetContainer)) {
      localConstraintWidgetContainer = (ConstraintWidgetContainer)this;
    } else {
      localConstraintWidgetContainer = null;
    }
    while (localObject != null)
    {
      ConstraintWidget localConstraintWidget = ((ConstraintWidget)localObject).getParent();
      if ((localObject instanceof ConstraintWidgetContainer)) {
        localConstraintWidgetContainer = (ConstraintWidgetContainer)localObject;
      }
      localObject = localConstraintWidget;
    }
    return localConstraintWidgetContainer;
  }
  
  public void layout()
  {
    updateDrawPosition();
    if (this.mChildren == null) {
      return;
    }
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
      if ((localConstraintWidget instanceof WidgetContainer)) {
        ((WidgetContainer)localConstraintWidget).layout();
      }
      i += 1;
    }
  }
  
  public void remove(ConstraintWidget paramConstraintWidget)
  {
    this.mChildren.remove(paramConstraintWidget);
    paramConstraintWidget.setParent(null);
  }
  
  public void removeAllChildren()
  {
    this.mChildren.clear();
  }
  
  public void reset()
  {
    this.mChildren.clear();
    super.reset();
  }
  
  public void resetSolverVariables(Cache paramCache)
  {
    super.resetSolverVariables(paramCache);
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      ((ConstraintWidget)this.mChildren.get(i)).resetSolverVariables(paramCache);
      i += 1;
    }
  }
  
  public void setOffset(int paramInt1, int paramInt2)
  {
    super.setOffset(paramInt1, paramInt2);
    paramInt2 = this.mChildren.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      ((ConstraintWidget)this.mChildren.get(paramInt1)).setOffset(getRootX(), getRootY());
      paramInt1 += 1;
    }
  }
  
  public void updateDrawPosition()
  {
    super.updateDrawPosition();
    if (this.mChildren == null) {
      return;
    }
    int j = this.mChildren.size();
    int i = 0;
    while (i < j)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)this.mChildren.get(i);
      localConstraintWidget.setOffset(getDrawX(), getDrawY());
      if (!(localConstraintWidget instanceof ConstraintWidgetContainer)) {
        localConstraintWidget.updateDrawPosition();
      }
      i += 1;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\constraint\solver\widgets\WidgetContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */