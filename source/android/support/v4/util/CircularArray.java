package android.support.v4.util;

public final class CircularArray<E>
{
  private int mCapacityBitmask;
  private E[] mElements;
  private int mHead;
  private int mTail;
  
  public CircularArray()
  {
    this(8);
  }
  
  public CircularArray(int paramInt)
  {
    if (paramInt >= 1)
    {
      if (paramInt <= 1073741824)
      {
        int i = paramInt;
        if (Integer.bitCount(paramInt) != 1) {
          i = Integer.highestOneBit(paramInt - 1) << 1;
        }
        this.mCapacityBitmask = (i - 1);
        this.mElements = ((Object[])new Object[i]);
        return;
      }
      throw new IllegalArgumentException("capacity must be <= 2^30");
    }
    throw new IllegalArgumentException("capacity must be >= 1");
  }
  
  private void doubleCapacity()
  {
    int i = this.mElements.length;
    int j = i - this.mHead;
    int k = i << 1;
    if (k >= 0)
    {
      Object[] arrayOfObject = new Object[k];
      System.arraycopy(this.mElements, this.mHead, arrayOfObject, 0, j);
      System.arraycopy(this.mElements, 0, arrayOfObject, j, this.mHead);
      this.mElements = ((Object[])arrayOfObject);
      this.mHead = 0;
      this.mTail = i;
      this.mCapacityBitmask = (k - 1);
      return;
    }
    throw new RuntimeException("Max array capacity exceeded");
  }
  
  public void addFirst(E paramE)
  {
    this.mHead = (this.mHead - 1 & this.mCapacityBitmask);
    this.mElements[this.mHead] = paramE;
    if (this.mHead == this.mTail) {
      doubleCapacity();
    }
  }
  
  public void addLast(E paramE)
  {
    this.mElements[this.mTail] = paramE;
    this.mTail = (this.mTail + 1 & this.mCapacityBitmask);
    if (this.mTail == this.mHead) {
      doubleCapacity();
    }
  }
  
  public void clear()
  {
    removeFromStart(size());
  }
  
  public E get(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < size()))
    {
      Object[] arrayOfObject = this.mElements;
      int i = this.mHead;
      return (E)arrayOfObject[(this.mCapacityBitmask & i + paramInt)];
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public E getFirst()
  {
    if (this.mHead != this.mTail) {
      return (E)this.mElements[this.mHead];
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public E getLast()
  {
    if (this.mHead != this.mTail) {
      return (E)this.mElements[(this.mTail - 1 & this.mCapacityBitmask)];
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public boolean isEmpty()
  {
    return this.mHead == this.mTail;
  }
  
  public E popFirst()
  {
    if (this.mHead != this.mTail)
    {
      Object localObject = this.mElements[this.mHead];
      this.mElements[this.mHead] = null;
      this.mHead = (this.mHead + 1 & this.mCapacityBitmask);
      return (E)localObject;
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public E popLast()
  {
    if (this.mHead != this.mTail)
    {
      int i = this.mTail - 1 & this.mCapacityBitmask;
      Object localObject = this.mElements[i];
      this.mElements[i] = null;
      this.mTail = i;
      return (E)localObject;
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public void removeFromEnd(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    if (paramInt <= size())
    {
      int i = 0;
      if (paramInt < this.mTail) {
        i = this.mTail - paramInt;
      }
      int j = i;
      while (j < this.mTail)
      {
        this.mElements[j] = null;
        j += 1;
      }
      i = this.mTail - i;
      paramInt -= i;
      this.mTail -= i;
      if (paramInt > 0)
      {
        this.mTail = this.mElements.length;
        i = this.mTail - paramInt;
        paramInt = i;
        while (paramInt < this.mTail)
        {
          this.mElements[paramInt] = null;
          paramInt += 1;
        }
        this.mTail = i;
      }
      return;
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public void removeFromStart(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    if (paramInt <= size())
    {
      int j = this.mElements.length;
      int i = j;
      if (paramInt < j - this.mHead) {
        i = this.mHead + paramInt;
      }
      j = this.mHead;
      while (j < i)
      {
        this.mElements[j] = null;
        j += 1;
      }
      j = i - this.mHead;
      i = paramInt - j;
      paramInt = this.mHead;
      this.mHead = (this.mCapacityBitmask & paramInt + j);
      if (i > 0)
      {
        paramInt = 0;
        while (paramInt < i)
        {
          this.mElements[paramInt] = null;
          paramInt += 1;
        }
        this.mHead = i;
      }
      return;
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public int size()
  {
    return this.mTail - this.mHead & this.mCapacityBitmask;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\util\CircularArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */