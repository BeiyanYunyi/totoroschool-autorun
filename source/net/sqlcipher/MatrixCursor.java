package net.sqlcipher;

import java.util.ArrayList;
import java.util.Iterator;

public class MatrixCursor
  extends AbstractCursor
{
  private final int columnCount;
  private final String[] columnNames;
  private Object[] data;
  private int rowCount = 0;
  
  public MatrixCursor(String[] paramArrayOfString)
  {
    this(paramArrayOfString, 16);
  }
  
  public MatrixCursor(String[] paramArrayOfString, int paramInt)
  {
    this.columnNames = paramArrayOfString;
    this.columnCount = paramArrayOfString.length;
    int i = 1;
    if (paramInt < 1) {
      paramInt = i;
    }
    this.data = new Object[this.columnCount * paramInt];
  }
  
  private void addRow(ArrayList<?> paramArrayList, int paramInt)
  {
    int j = paramArrayList.size();
    if (j == this.columnCount)
    {
      this.rowCount += 1;
      Object[] arrayOfObject = this.data;
      int i = 0;
      while (i < j)
      {
        arrayOfObject[(paramInt + i)] = paramArrayList.get(i);
        i += 1;
      }
      return;
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append("columnNames.length = ");
    paramArrayList.append(this.columnCount);
    paramArrayList.append(", columnValues.size() = ");
    paramArrayList.append(j);
    throw new IllegalArgumentException(paramArrayList.toString());
  }
  
  private void ensureCapacity(int paramInt)
  {
    if (paramInt > this.data.length)
    {
      Object[] arrayOfObject = this.data;
      int i = this.data.length * 2;
      if (i >= paramInt) {
        paramInt = i;
      }
      this.data = new Object[paramInt];
      System.arraycopy(arrayOfObject, 0, this.data, 0, arrayOfObject.length);
    }
  }
  
  private Object get(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.columnCount))
    {
      if (this.mPos >= 0)
      {
        if (this.mPos < this.rowCount) {
          return this.data[(this.mPos * this.columnCount + paramInt)];
        }
        throw new CursorIndexOutOfBoundsException("After last row.");
      }
      throw new CursorIndexOutOfBoundsException("Before first row.");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Requested column: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", # of columns: ");
    localStringBuilder.append(this.columnCount);
    throw new CursorIndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public void addRow(Iterable<?> paramIterable)
  {
    int i = this.rowCount * this.columnCount;
    int j = this.columnCount + i;
    ensureCapacity(j);
    if ((paramIterable instanceof ArrayList))
    {
      addRow((ArrayList)paramIterable, i);
      return;
    }
    Object[] arrayOfObject = this.data;
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (i != j)
      {
        arrayOfObject[i] = localObject;
        i += 1;
      }
      else
      {
        throw new IllegalArgumentException("columnValues.size() > columnNames.length");
      }
    }
    if (i == j)
    {
      this.rowCount += 1;
      return;
    }
    throw new IllegalArgumentException("columnValues.size() < columnNames.length");
  }
  
  public void addRow(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length == this.columnCount)
    {
      int i = this.rowCount;
      this.rowCount = (i + 1);
      i *= this.columnCount;
      ensureCapacity(this.columnCount + i);
      System.arraycopy(paramArrayOfObject, 0, this.data, i, this.columnCount);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("columnNames.length = ");
    localStringBuilder.append(this.columnCount);
    localStringBuilder.append(", columnValues.length = ");
    localStringBuilder.append(paramArrayOfObject.length);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public String[] getColumnNames()
  {
    return this.columnNames;
  }
  
  public int getCount()
  {
    return this.rowCount;
  }
  
  public double getDouble(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0.0D;
    }
    if ((localObject instanceof Number)) {
      return ((Number)localObject).doubleValue();
    }
    return Double.parseDouble(localObject.toString());
  }
  
  public float getFloat(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0.0F;
    }
    if ((localObject instanceof Number)) {
      return ((Number)localObject).floatValue();
    }
    return Float.parseFloat(localObject.toString());
  }
  
  public int getInt(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0;
    }
    if ((localObject instanceof Number)) {
      return ((Number)localObject).intValue();
    }
    return Integer.parseInt(localObject.toString());
  }
  
  public long getLong(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0L;
    }
    if ((localObject instanceof Number)) {
      return ((Number)localObject).longValue();
    }
    return Long.parseLong(localObject.toString());
  }
  
  public short getShort(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return 0;
    }
    if ((localObject instanceof Number)) {
      return ((Number)localObject).shortValue();
    }
    return Short.parseShort(localObject.toString());
  }
  
  public String getString(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return null;
    }
    return localObject.toString();
  }
  
  public int getType(int paramInt)
  {
    return DatabaseUtils.getTypeOfObject(get(paramInt));
  }
  
  public boolean isNull(int paramInt)
  {
    return get(paramInt) == null;
  }
  
  public RowBuilder newRow()
  {
    this.rowCount += 1;
    int i = this.rowCount * this.columnCount;
    ensureCapacity(i);
    return new RowBuilder(i - this.columnCount, i);
  }
  
  public class RowBuilder
  {
    private final int endIndex;
    private int index;
    
    RowBuilder(int paramInt1, int paramInt2)
    {
      this.index = paramInt1;
      this.endIndex = paramInt2;
    }
    
    public RowBuilder add(Object paramObject)
    {
      if (this.index != this.endIndex)
      {
        Object[] arrayOfObject = MatrixCursor.this.data;
        int i = this.index;
        this.index = (i + 1);
        arrayOfObject[i] = paramObject;
        return this;
      }
      throw new CursorIndexOutOfBoundsException("No more columns left.");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\net\sqlcipher\MatrixCursor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */