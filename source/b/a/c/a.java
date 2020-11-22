package b.a.c;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class a
  extends RuntimeException
{
  private static final long serialVersionUID = 3026362227162912146L;
  private Throwable cause;
  private final List<Throwable> exceptions;
  private final String message;
  
  public a(Iterable<? extends Throwable> paramIterable)
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    ArrayList localArrayList = new ArrayList();
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Throwable localThrowable = (Throwable)paramIterable.next();
        if ((localThrowable instanceof a)) {
          localLinkedHashSet.addAll(((a)localThrowable).getExceptions());
        } else if (localThrowable != null) {
          localLinkedHashSet.add(localThrowable);
        } else {
          localLinkedHashSet.add(new NullPointerException("Throwable was null!"));
        }
      }
    }
    localLinkedHashSet.add(new NullPointerException("errors was null"));
    if (!localLinkedHashSet.isEmpty())
    {
      localArrayList.addAll(localLinkedHashSet);
      this.exceptions = Collections.unmodifiableList(localArrayList);
      paramIterable = new StringBuilder();
      paramIterable.append(this.exceptions.size());
      paramIterable.append(" exceptions occurred. ");
      this.message = paramIterable.toString();
      return;
    }
    throw new IllegalArgumentException("errors is empty");
  }
  
  public a(Throwable... paramVarArgs)
  {
    this(paramVarArgs);
  }
  
  private List<Throwable> a(Throwable paramThrowable)
  {
    ArrayList localArrayList = new ArrayList();
    Throwable localThrowable2 = paramThrowable.getCause();
    if (localThrowable2 != null)
    {
      Throwable localThrowable1 = localThrowable2;
      if (localThrowable2 == paramThrowable) {
        return localArrayList;
      }
      for (;;)
      {
        localArrayList.add(localThrowable1);
        paramThrowable = localThrowable1.getCause();
        if (paramThrowable == null) {
          break;
        }
        if (paramThrowable == localThrowable1) {
          return localArrayList;
        }
        localThrowable1 = paramThrowable;
      }
      return localArrayList;
    }
    return localArrayList;
  }
  
  private void a(b paramb)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(this);
    localStringBuilder.append('\n');
    Object localObject1 = getStackTrace();
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = localObject1[i];
      localStringBuilder.append("\tat ");
      localStringBuilder.append(localObject2);
      localStringBuilder.append('\n');
      i += 1;
    }
    localObject1 = this.exceptions.iterator();
    i = 1;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Throwable)((Iterator)localObject1).next();
      localStringBuilder.append("  ComposedException ");
      localStringBuilder.append(i);
      localStringBuilder.append(" :\n");
      a(localStringBuilder, (Throwable)localObject2, "\t");
      i += 1;
    }
    paramb.a(localStringBuilder.toString());
  }
  
  private void a(StringBuilder paramStringBuilder, Throwable paramThrowable, String paramString)
  {
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(paramThrowable);
    paramStringBuilder.append('\n');
    paramString = paramThrowable.getStackTrace();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      paramStringBuilder.append("\t\tat ");
      paramStringBuilder.append(localObject);
      paramStringBuilder.append('\n');
      i += 1;
    }
    if (paramThrowable.getCause() != null)
    {
      paramStringBuilder.append("\tCaused by: ");
      a(paramStringBuilder, paramThrowable.getCause(), "");
    }
  }
  
  /* Error */
  public Throwable getCause()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 183	b/a/c/a:cause	Ljava/lang/Throwable;
    //   6: ifnonnull +169 -> 175
    //   9: new 6	b/a/c/a$a
    //   12: dup
    //   13: invokespecial 184	b/a/c/a$a:<init>	()V
    //   16: astore_3
    //   17: new 186	java/util/HashSet
    //   20: dup
    //   21: invokespecial 187	java/util/HashSet:<init>	()V
    //   24: astore 4
    //   26: aload_0
    //   27: getfield 93	b/a/c/a:exceptions	Ljava/util/List;
    //   30: invokeinterface 162 1 0
    //   35: astore 5
    //   37: aload_3
    //   38: astore_1
    //   39: aload 5
    //   41: invokeinterface 50 1 0
    //   46: ifeq +124 -> 170
    //   49: aload 5
    //   51: invokeinterface 54 1 0
    //   56: checkcast 56	java/lang/Throwable
    //   59: astore_2
    //   60: aload 4
    //   62: aload_2
    //   63: invokeinterface 190 2 0
    //   68: ifeq +6 -> 74
    //   71: goto -32 -> 39
    //   74: aload 4
    //   76: aload_2
    //   77: invokeinterface 70 2 0
    //   82: pop
    //   83: aload_0
    //   84: aload_2
    //   85: invokespecial 192	b/a/c/a:a	(Ljava/lang/Throwable;)Ljava/util/List;
    //   88: invokeinterface 162 1 0
    //   93: astore 6
    //   95: aload 6
    //   97: invokeinterface 50 1 0
    //   102: ifeq +53 -> 155
    //   105: aload 6
    //   107: invokeinterface 54 1 0
    //   112: checkcast 56	java/lang/Throwable
    //   115: astore 7
    //   117: aload 4
    //   119: aload 7
    //   121: invokeinterface 190 2 0
    //   126: ifeq +16 -> 142
    //   129: new 4	java/lang/RuntimeException
    //   132: dup
    //   133: ldc -62
    //   135: invokespecial 195	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   138: astore_2
    //   139: goto -44 -> 95
    //   142: aload 4
    //   144: aload 7
    //   146: invokeinterface 70 2 0
    //   151: pop
    //   152: goto -57 -> 95
    //   155: aload_1
    //   156: aload_2
    //   157: invokevirtual 199	java/lang/Throwable:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   160: pop
    //   161: aload_0
    //   162: aload_1
    //   163: invokevirtual 202	b/a/c/a:getRootCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   166: astore_1
    //   167: goto -128 -> 39
    //   170: aload_0
    //   171: aload_3
    //   172: putfield 183	b/a/c/a:cause	Ljava/lang/Throwable;
    //   175: aload_0
    //   176: getfield 183	b/a/c/a:cause	Ljava/lang/Throwable;
    //   179: astore_1
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_1
    //   183: areturn
    //   184: astore_1
    //   185: aload_0
    //   186: monitorexit
    //   187: aload_1
    //   188: athrow
    //   189: astore_2
    //   190: goto -29 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	a
    //   38	145	1	localObject1	Object
    //   184	4	1	localObject2	Object
    //   59	98	2	localObject3	Object
    //   189	1	2	localThrowable1	Throwable
    //   16	156	3	locala	a
    //   24	119	4	localHashSet	java.util.HashSet
    //   35	15	5	localIterator1	Iterator
    //   93	13	6	localIterator2	Iterator
    //   115	30	7	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	37	184	finally
    //   39	71	184	finally
    //   74	95	184	finally
    //   95	139	184	finally
    //   142	152	184	finally
    //   155	161	184	finally
    //   161	167	184	finally
    //   170	175	184	finally
    //   175	180	184	finally
    //   155	161	189	java/lang/Throwable
  }
  
  public List<Throwable> getExceptions()
  {
    return this.exceptions;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  Throwable getRootCause(Throwable paramThrowable)
  {
    Throwable localThrowable2 = paramThrowable.getCause();
    if (localThrowable2 != null)
    {
      Throwable localThrowable1 = localThrowable2;
      if (this.cause == localThrowable2) {
        return paramThrowable;
      }
      for (;;)
      {
        paramThrowable = localThrowable1.getCause();
        if (paramThrowable == null) {
          break;
        }
        if (paramThrowable == localThrowable1) {
          return localThrowable1;
        }
        localThrowable1 = paramThrowable;
      }
      return localThrowable1;
    }
    return paramThrowable;
  }
  
  public void printStackTrace()
  {
    printStackTrace(System.err);
  }
  
  public void printStackTrace(PrintStream paramPrintStream)
  {
    a(new c(paramPrintStream));
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    a(new d(paramPrintWriter));
  }
  
  public int size()
  {
    return this.exceptions.size();
  }
  
  static final class a
    extends RuntimeException
  {
    static final String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
    private static final long serialVersionUID = 3875212506787802066L;
    
    public String getMessage()
    {
      return "Chain of Causes for CompositeException In Order Received =>";
    }
  }
  
  static abstract class b
  {
    abstract void a(Object paramObject);
  }
  
  static final class c
    extends a.b
  {
    private final PrintStream a;
    
    c(PrintStream paramPrintStream)
    {
      this.a = paramPrintStream;
    }
    
    void a(Object paramObject)
    {
      this.a.println(paramObject);
    }
  }
  
  static final class d
    extends a.b
  {
    private final PrintWriter a;
    
    d(PrintWriter paramPrintWriter)
    {
      this.a = paramPrintWriter;
    }
    
    void a(Object paramObject)
    {
      this.a.println(paramObject);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */