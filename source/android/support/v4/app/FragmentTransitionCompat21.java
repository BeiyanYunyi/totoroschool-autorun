package android.support.v4.app;

import android.graphics.Rect;
import android.support.annotation.RequiresApi;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.Transition.TransitionListener;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
class FragmentTransitionCompat21
  extends FragmentTransitionImpl
{
  private static boolean hasSimpleTarget(Transition paramTransition)
  {
    return (!isNullOrEmpty(paramTransition.getTargetIds())) || (!isNullOrEmpty(paramTransition.getTargetNames())) || (!isNullOrEmpty(paramTransition.getTargetTypes()));
  }
  
  public void addTarget(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((Transition)paramObject).addTarget(paramView);
    }
  }
  
  public void addTargets(Object paramObject, ArrayList<View> paramArrayList)
  {
    paramObject = (Transition)paramObject;
    if (paramObject == null) {
      return;
    }
    boolean bool = paramObject instanceof TransitionSet;
    int j = 0;
    int i = 0;
    if (bool)
    {
      paramObject = (TransitionSet)paramObject;
      j = ((TransitionSet)paramObject).getTransitionCount();
      while (i < j)
      {
        addTargets(((TransitionSet)paramObject).getTransitionAt(i), paramArrayList);
        i += 1;
      }
    }
    if ((!hasSimpleTarget((Transition)paramObject)) && (isNullOrEmpty(((Transition)paramObject).getTargets())))
    {
      int k = paramArrayList.size();
      i = j;
      while (i < k)
      {
        ((Transition)paramObject).addTarget((View)paramArrayList.get(i));
        i += 1;
      }
    }
  }
  
  public void beginDelayedTransition(ViewGroup paramViewGroup, Object paramObject)
  {
    TransitionManager.beginDelayedTransition(paramViewGroup, (Transition)paramObject);
  }
  
  public boolean canHandle(Object paramObject)
  {
    return paramObject instanceof Transition;
  }
  
  public Object cloneTransition(Object paramObject)
  {
    if (paramObject != null) {
      return ((Transition)paramObject).clone();
    }
    return null;
  }
  
  public Object mergeTransitionsInSequence(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    paramObject1 = (Transition)paramObject1;
    paramObject2 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    if ((paramObject1 != null) && (paramObject2 != null)) {
      paramObject1 = new TransitionSet().addTransition((Transition)paramObject1).addTransition((Transition)paramObject2).setOrdering(1);
    } else if (paramObject1 == null) {
      if (paramObject2 != null) {
        paramObject1 = paramObject2;
      } else {
        paramObject1 = null;
      }
    }
    if (paramObject3 != null)
    {
      paramObject2 = new TransitionSet();
      if (paramObject1 != null) {
        ((TransitionSet)paramObject2).addTransition((Transition)paramObject1);
      }
      ((TransitionSet)paramObject2).addTransition((Transition)paramObject3);
      return paramObject2;
    }
    return paramObject1;
  }
  
  public Object mergeTransitionsTogether(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    TransitionSet localTransitionSet = new TransitionSet();
    if (paramObject1 != null) {
      localTransitionSet.addTransition((Transition)paramObject1);
    }
    if (paramObject2 != null) {
      localTransitionSet.addTransition((Transition)paramObject2);
    }
    if (paramObject3 != null) {
      localTransitionSet.addTransition((Transition)paramObject3);
    }
    return localTransitionSet;
  }
  
  public void removeTarget(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((Transition)paramObject).removeTarget(paramView);
    }
  }
  
  public void replaceTargets(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    paramObject = (Transition)paramObject;
    boolean bool = paramObject instanceof TransitionSet;
    int j = 0;
    int i = 0;
    if (bool)
    {
      paramObject = (TransitionSet)paramObject;
      j = ((TransitionSet)paramObject).getTransitionCount();
      while (i < j)
      {
        replaceTargets(((TransitionSet)paramObject).getTransitionAt(i), paramArrayList1, paramArrayList2);
        i += 1;
      }
    }
    if (!hasSimpleTarget((Transition)paramObject))
    {
      List localList = ((Transition)paramObject).getTargets();
      if ((localList != null) && (localList.size() == paramArrayList1.size()) && (localList.containsAll(paramArrayList1)))
      {
        if (paramArrayList2 == null) {
          i = 0;
        } else {
          i = paramArrayList2.size();
        }
        while (j < i)
        {
          ((Transition)paramObject).addTarget((View)paramArrayList2.get(j));
          j += 1;
        }
        i = paramArrayList1.size() - 1;
        while (i >= 0)
        {
          ((Transition)paramObject).removeTarget((View)paramArrayList1.get(i));
          i -= 1;
        }
      }
    }
  }
  
  public void scheduleHideFragmentView(Object paramObject, final View paramView, final ArrayList<View> paramArrayList)
  {
    ((Transition)paramObject).addListener(new Transition.TransitionListener()
    {
      public void onTransitionCancel(Transition paramAnonymousTransition) {}
      
      public void onTransitionEnd(Transition paramAnonymousTransition)
      {
        paramAnonymousTransition.removeListener(this);
        paramView.setVisibility(8);
        int j = paramArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((View)paramArrayList.get(i)).setVisibility(0);
          i += 1;
        }
      }
      
      public void onTransitionPause(Transition paramAnonymousTransition) {}
      
      public void onTransitionResume(Transition paramAnonymousTransition) {}
      
      public void onTransitionStart(Transition paramAnonymousTransition) {}
    });
  }
  
  public void scheduleRemoveTargets(Object paramObject1, final Object paramObject2, final ArrayList<View> paramArrayList1, final Object paramObject3, final ArrayList<View> paramArrayList2, final Object paramObject4, final ArrayList<View> paramArrayList3)
  {
    ((Transition)paramObject1).addListener(new Transition.TransitionListener()
    {
      public void onTransitionCancel(Transition paramAnonymousTransition) {}
      
      public void onTransitionEnd(Transition paramAnonymousTransition) {}
      
      public void onTransitionPause(Transition paramAnonymousTransition) {}
      
      public void onTransitionResume(Transition paramAnonymousTransition) {}
      
      public void onTransitionStart(Transition paramAnonymousTransition)
      {
        if (paramObject2 != null) {
          FragmentTransitionCompat21.this.replaceTargets(paramObject2, paramArrayList1, null);
        }
        if (paramObject3 != null) {
          FragmentTransitionCompat21.this.replaceTargets(paramObject3, paramArrayList2, null);
        }
        if (paramObject4 != null) {
          FragmentTransitionCompat21.this.replaceTargets(paramObject4, paramArrayList3, null);
        }
      }
    });
  }
  
  public void setEpicenter(Object paramObject, final Rect paramRect)
  {
    if (paramObject != null) {
      ((Transition)paramObject).setEpicenterCallback(new Transition.EpicenterCallback()
      {
        public Rect onGetEpicenter(Transition paramAnonymousTransition)
        {
          if ((paramRect != null) && (!paramRect.isEmpty())) {
            return paramRect;
          }
          return null;
        }
      });
    }
  }
  
  public void setEpicenter(Object paramObject, View paramView)
  {
    if (paramView != null)
    {
      paramObject = (Transition)paramObject;
      final Rect localRect = new Rect();
      getBoundsOnScreen(paramView, localRect);
      ((Transition)paramObject).setEpicenterCallback(new Transition.EpicenterCallback()
      {
        public Rect onGetEpicenter(Transition paramAnonymousTransition)
        {
          return localRect;
        }
      });
    }
  }
  
  public void setSharedElementTargets(Object paramObject, View paramView, ArrayList<View> paramArrayList)
  {
    paramObject = (TransitionSet)paramObject;
    List localList = ((TransitionSet)paramObject).getTargets();
    localList.clear();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      bfsAddViewChildren(localList, (View)paramArrayList.get(i));
      i += 1;
    }
    localList.add(paramView);
    paramArrayList.add(paramView);
    addTargets(paramObject, paramArrayList);
  }
  
  public void swapSharedElementTargets(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    paramObject = (TransitionSet)paramObject;
    if (paramObject != null)
    {
      ((TransitionSet)paramObject).getTargets().clear();
      ((TransitionSet)paramObject).getTargets().addAll(paramArrayList2);
      replaceTargets(paramObject, paramArrayList1, paramArrayList2);
    }
  }
  
  public Object wrapTransitionInSet(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    TransitionSet localTransitionSet = new TransitionSet();
    localTransitionSet.addTransition((Transition)paramObject);
    return localTransitionSet;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\app\FragmentTransitionCompat21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */