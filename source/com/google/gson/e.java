package com.google.gson;

import com.google.gson.b.a.b;
import com.google.gson.b.a.g;
import com.google.gson.b.a.h;
import com.google.gson.b.a.n;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class e
{
  private static final com.google.gson.c.a<?> a = com.google.gson.c.a.b(Object.class);
  private final ThreadLocal<Map<com.google.gson.c.a<?>, a<?>>> b = new ThreadLocal();
  private final Map<com.google.gson.c.a<?>, t<?>> c = new ConcurrentHashMap();
  private final List<u> d;
  private final com.google.gson.b.c e;
  private final com.google.gson.b.d f;
  private final d g;
  private final boolean h;
  private final boolean i;
  private final boolean j;
  private final boolean k;
  private final boolean l;
  private final com.google.gson.b.a.d m;
  
  public e()
  {
    this(com.google.gson.b.d.a, c.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, s.DEFAULT, Collections.emptyList());
  }
  
  e(com.google.gson.b.d paramd, d paramd1, Map<Type, f<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, s params, List<u> paramList)
  {
    this.e = new com.google.gson.b.c(paramMap);
    this.f = paramd;
    this.g = paramd1;
    this.h = paramBoolean1;
    this.j = paramBoolean3;
    this.i = paramBoolean4;
    this.k = paramBoolean5;
    this.l = paramBoolean6;
    paramMap = new ArrayList();
    paramMap.add(n.Y);
    paramMap.add(h.a);
    paramMap.add(paramd);
    paramMap.addAll(paramList);
    paramMap.add(n.D);
    paramMap.add(n.m);
    paramMap.add(n.g);
    paramMap.add(n.i);
    paramMap.add(n.k);
    params = a(params);
    paramMap.add(n.a(Long.TYPE, Long.class, params));
    paramMap.add(n.a(Double.TYPE, Double.class, a(paramBoolean7)));
    paramMap.add(n.a(Float.TYPE, Float.class, b(paramBoolean7)));
    paramMap.add(n.x);
    paramMap.add(n.o);
    paramMap.add(n.q);
    paramMap.add(n.a(AtomicLong.class, a(params)));
    paramMap.add(n.a(AtomicLongArray.class, b(params)));
    paramMap.add(n.s);
    paramMap.add(n.z);
    paramMap.add(n.F);
    paramMap.add(n.H);
    paramMap.add(n.a(BigDecimal.class, n.B));
    paramMap.add(n.a(BigInteger.class, n.C));
    paramMap.add(n.J);
    paramMap.add(n.L);
    paramMap.add(n.P);
    paramMap.add(n.R);
    paramMap.add(n.W);
    paramMap.add(n.N);
    paramMap.add(n.d);
    paramMap.add(com.google.gson.b.a.c.a);
    paramMap.add(n.U);
    paramMap.add(com.google.gson.b.a.k.a);
    paramMap.add(com.google.gson.b.a.j.a);
    paramMap.add(n.S);
    paramMap.add(com.google.gson.b.a.a.a);
    paramMap.add(n.b);
    paramMap.add(new b(this.e));
    paramMap.add(new g(this.e, paramBoolean2));
    this.m = new com.google.gson.b.a.d(this.e);
    paramMap.add(this.m);
    paramMap.add(n.Z);
    paramMap.add(new com.google.gson.b.a.i(this.e, paramd1, paramd, this.m));
    this.d = Collections.unmodifiableList(paramMap);
  }
  
  private static t<Number> a(s params)
  {
    if (params == s.DEFAULT) {
      return n.t;
    }
    new t()
    {
      public Number a(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        return Long.valueOf(paramAnonymousJsonReader.nextLong());
      }
      
      public void a(JsonWriter paramAnonymousJsonWriter, Number paramAnonymousNumber)
        throws IOException
      {
        if (paramAnonymousNumber == null)
        {
          paramAnonymousJsonWriter.nullValue();
          return;
        }
        paramAnonymousJsonWriter.value(paramAnonymousNumber.toString());
      }
    };
  }
  
  private static t<AtomicLong> a(t<Number> paramt)
  {
    new t()
    {
      public AtomicLong a(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        return new AtomicLong(((Number)this.a.b(paramAnonymousJsonReader)).longValue());
      }
      
      public void a(JsonWriter paramAnonymousJsonWriter, AtomicLong paramAnonymousAtomicLong)
        throws IOException
      {
        this.a.a(paramAnonymousJsonWriter, Long.valueOf(paramAnonymousAtomicLong.get()));
      }
    }.a();
  }
  
  private t<Number> a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return n.v;
    }
    new t()
    {
      public Double a(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        return Double.valueOf(paramAnonymousJsonReader.nextDouble());
      }
      
      public void a(JsonWriter paramAnonymousJsonWriter, Number paramAnonymousNumber)
        throws IOException
      {
        if (paramAnonymousNumber == null)
        {
          paramAnonymousJsonWriter.nullValue();
          return;
        }
        e.a(paramAnonymousNumber.doubleValue());
        paramAnonymousJsonWriter.value(paramAnonymousNumber);
      }
    };
  }
  
  static void a(double paramDouble)
  {
    if ((!Double.isNaN(paramDouble)) && (!Double.isInfinite(paramDouble))) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramDouble);
    localStringBuilder.append(" is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static void a(Object paramObject, JsonReader paramJsonReader)
  {
    if (paramObject != null) {
      try
      {
        if (paramJsonReader.peek() == JsonToken.END_DOCUMENT) {
          return;
        }
        throw new k("JSON document was not fully consumed.");
      }
      catch (IOException paramObject)
      {
        throw new k((Throwable)paramObject);
      }
      catch (MalformedJsonException paramObject)
      {
        throw new r((Throwable)paramObject);
      }
    }
  }
  
  private static t<AtomicLongArray> b(t<Number> paramt)
  {
    new t()
    {
      public AtomicLongArray a(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        ArrayList localArrayList = new ArrayList();
        paramAnonymousJsonReader.beginArray();
        while (paramAnonymousJsonReader.hasNext()) {
          localArrayList.add(Long.valueOf(((Number)this.a.b(paramAnonymousJsonReader)).longValue()));
        }
        paramAnonymousJsonReader.endArray();
        int j = localArrayList.size();
        paramAnonymousJsonReader = new AtomicLongArray(j);
        int i = 0;
        while (i < j)
        {
          paramAnonymousJsonReader.set(i, ((Long)localArrayList.get(i)).longValue());
          i += 1;
        }
        return paramAnonymousJsonReader;
      }
      
      public void a(JsonWriter paramAnonymousJsonWriter, AtomicLongArray paramAnonymousAtomicLongArray)
        throws IOException
      {
        paramAnonymousJsonWriter.beginArray();
        int j = paramAnonymousAtomicLongArray.length();
        int i = 0;
        while (i < j)
        {
          this.a.a(paramAnonymousJsonWriter, Long.valueOf(paramAnonymousAtomicLongArray.get(i)));
          i += 1;
        }
        paramAnonymousJsonWriter.endArray();
      }
    }.a();
  }
  
  private t<Number> b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return n.u;
    }
    new t()
    {
      public Float a(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        return Float.valueOf((float)paramAnonymousJsonReader.nextDouble());
      }
      
      public void a(JsonWriter paramAnonymousJsonWriter, Number paramAnonymousNumber)
        throws IOException
      {
        if (paramAnonymousNumber == null)
        {
          paramAnonymousJsonWriter.nullValue();
          return;
        }
        e.a(paramAnonymousNumber.floatValue());
        paramAnonymousJsonWriter.value(paramAnonymousNumber);
      }
    };
  }
  
  public JsonReader a(Reader paramReader)
  {
    paramReader = new JsonReader(paramReader);
    paramReader.setLenient(this.l);
    return paramReader;
  }
  
  public JsonWriter a(Writer paramWriter)
    throws IOException
  {
    if (this.j) {
      paramWriter.write(")]}'\n");
    }
    paramWriter = new JsonWriter(paramWriter);
    if (this.k) {
      paramWriter.setIndent("  ");
    }
    paramWriter.setSerializeNulls(this.h);
    return paramWriter;
  }
  
  public <T> t<T> a(com.google.gson.c.a<T> parama)
  {
    Object localObject2 = this.c;
    if (parama == null) {
      localObject1 = a;
    } else {
      localObject1 = parama;
    }
    Object localObject1 = (t)((Map)localObject2).get(localObject1);
    if (localObject1 != null) {
      return (t<T>)localObject1;
    }
    localObject2 = (Map)this.b.get();
    int n = 0;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new HashMap();
      this.b.set(localObject1);
      n = 1;
    }
    localObject2 = (a)((Map)localObject1).get(parama);
    if (localObject2 != null) {
      return (t<T>)localObject2;
    }
    try
    {
      localObject2 = new a();
      ((Map)localObject1).put(parama, localObject2);
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        t localt = ((u)localIterator.next()).a(this, parama);
        if (localt != null)
        {
          ((a)localObject2).a(localt);
          this.c.put(parama, localt);
          return localt;
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("GSON cannot handle ");
      ((StringBuilder)localObject2).append(parama);
      throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
    }
    finally
    {
      ((Map)localObject1).remove(parama);
      if (n != 0) {
        this.b.remove();
      }
    }
  }
  
  public <T> t<T> a(u paramu, com.google.gson.c.a<T> parama)
  {
    Object localObject1 = paramu;
    if (!this.d.contains(paramu)) {
      localObject1 = this.m;
    }
    int n = 0;
    paramu = this.d.iterator();
    while (paramu.hasNext())
    {
      Object localObject2 = (u)paramu.next();
      if (n == 0)
      {
        if (localObject2 == localObject1) {
          n = 1;
        }
      }
      else
      {
        localObject2 = ((u)localObject2).a(this, parama);
        if (localObject2 != null) {
          return (t<T>)localObject2;
        }
      }
    }
    paramu = new StringBuilder();
    paramu.append("GSON cannot serialize ");
    paramu.append(parama);
    throw new IllegalArgumentException(paramu.toString());
  }
  
  public <T> t<T> a(Class<T> paramClass)
  {
    return a(com.google.gson.c.a.b(paramClass));
  }
  
  /* Error */
  public <T> T a(JsonReader paramJsonReader, Type paramType)
    throws k, r
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 473	com/google/gson/stream/JsonReader:isLenient	()Z
    //   4: istore 4
    //   6: iconst_1
    //   7: istore_3
    //   8: aload_1
    //   9: iconst_1
    //   10: invokevirtual 377	com/google/gson/stream/JsonReader:setLenient	(Z)V
    //   13: aload_1
    //   14: invokevirtual 345	com/google/gson/stream/JsonReader:peek	()Lcom/google/gson/stream/JsonToken;
    //   17: pop
    //   18: iconst_0
    //   19: istore_3
    //   20: aload_0
    //   21: aload_2
    //   22: invokestatic 476	com/google/gson/c/a:a	(Ljava/lang/reflect/Type;)Lcom/google/gson/c/a;
    //   25: invokevirtual 464	com/google/gson/e:a	(Lcom/google/gson/c/a;)Lcom/google/gson/t;
    //   28: aload_1
    //   29: invokevirtual 479	com/google/gson/t:b	(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;
    //   32: astore_2
    //   33: aload_1
    //   34: iload 4
    //   36: invokevirtual 377	com/google/gson/stream/JsonReader:setLenient	(Z)V
    //   39: aload_2
    //   40: areturn
    //   41: astore_2
    //   42: goto +45 -> 87
    //   45: astore_2
    //   46: new 361	com/google/gson/r
    //   49: dup
    //   50: aload_2
    //   51: invokespecial 362	com/google/gson/r:<init>	(Ljava/lang/Throwable;)V
    //   54: athrow
    //   55: astore_2
    //   56: new 361	com/google/gson/r
    //   59: dup
    //   60: aload_2
    //   61: invokespecial 362	com/google/gson/r:<init>	(Ljava/lang/Throwable;)V
    //   64: athrow
    //   65: astore_2
    //   66: iload_3
    //   67: ifeq +11 -> 78
    //   70: aload_1
    //   71: iload 4
    //   73: invokevirtual 377	com/google/gson/stream/JsonReader:setLenient	(Z)V
    //   76: aconst_null
    //   77: areturn
    //   78: new 361	com/google/gson/r
    //   81: dup
    //   82: aload_2
    //   83: invokespecial 362	com/google/gson/r:<init>	(Ljava/lang/Throwable;)V
    //   86: athrow
    //   87: aload_1
    //   88: iload 4
    //   90: invokevirtual 377	com/google/gson/stream/JsonReader:setLenient	(Z)V
    //   93: aload_2
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	e
    //   0	95	1	paramJsonReader	JsonReader
    //   0	95	2	paramType	Type
    //   7	60	3	n	int
    //   4	85	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   13	18	41	finally
    //   20	33	41	finally
    //   46	55	41	finally
    //   56	65	41	finally
    //   78	87	41	finally
    //   13	18	45	java/io/IOException
    //   20	33	45	java/io/IOException
    //   13	18	55	java/lang/IllegalStateException
    //   20	33	55	java/lang/IllegalStateException
    //   13	18	65	java/io/EOFException
    //   20	33	65	java/io/EOFException
  }
  
  public <T> T a(Reader paramReader, Type paramType)
    throws k, r
  {
    paramReader = a(paramReader);
    paramType = a(paramReader, paramType);
    a(paramType, paramReader);
    return paramType;
  }
  
  public <T> T a(String paramString, Class<T> paramClass)
    throws r
  {
    paramString = a(paramString, paramClass);
    return (T)com.google.gson.b.i.a(paramClass).cast(paramString);
  }
  
  public <T> T a(String paramString, Type paramType)
    throws r
  {
    if (paramString == null) {
      return null;
    }
    return (T)a(new StringReader(paramString), paramType);
  }
  
  public String a(j paramj)
  {
    StringWriter localStringWriter = new StringWriter();
    a(paramj, localStringWriter);
    return localStringWriter.toString();
  }
  
  public String a(Object paramObject)
  {
    if (paramObject == null) {
      return a(l.a);
    }
    return a(paramObject, paramObject.getClass());
  }
  
  public String a(Object paramObject, Type paramType)
  {
    StringWriter localStringWriter = new StringWriter();
    a(paramObject, paramType, localStringWriter);
    return localStringWriter.toString();
  }
  
  /* Error */
  public void a(j paramj, JsonWriter paramJsonWriter)
    throws k
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 537	com/google/gson/stream/JsonWriter:isLenient	()Z
    //   4: istore_3
    //   5: aload_2
    //   6: iconst_1
    //   7: invokevirtual 538	com/google/gson/stream/JsonWriter:setLenient	(Z)V
    //   10: aload_2
    //   11: invokevirtual 541	com/google/gson/stream/JsonWriter:isHtmlSafe	()Z
    //   14: istore 4
    //   16: aload_2
    //   17: aload_0
    //   18: getfield 111	com/google/gson/e:i	Z
    //   21: invokevirtual 544	com/google/gson/stream/JsonWriter:setHtmlSafe	(Z)V
    //   24: aload_2
    //   25: invokevirtual 547	com/google/gson/stream/JsonWriter:getSerializeNulls	()Z
    //   28: istore 5
    //   30: aload_2
    //   31: aload_0
    //   32: getfield 107	com/google/gson/e:h	Z
    //   35: invokevirtual 398	com/google/gson/stream/JsonWriter:setSerializeNulls	(Z)V
    //   38: aload_1
    //   39: aload_2
    //   40: invokestatic 551	com/google/gson/b/j:a	(Lcom/google/gson/j;Lcom/google/gson/stream/JsonWriter;)V
    //   43: aload_2
    //   44: iload_3
    //   45: invokevirtual 538	com/google/gson/stream/JsonWriter:setLenient	(Z)V
    //   48: aload_2
    //   49: iload 4
    //   51: invokevirtual 544	com/google/gson/stream/JsonWriter:setHtmlSafe	(Z)V
    //   54: aload_2
    //   55: iload 5
    //   57: invokevirtual 398	com/google/gson/stream/JsonWriter:setSerializeNulls	(Z)V
    //   60: return
    //   61: astore_1
    //   62: goto +13 -> 75
    //   65: astore_1
    //   66: new 353	com/google/gson/k
    //   69: dup
    //   70: aload_1
    //   71: invokespecial 359	com/google/gson/k:<init>	(Ljava/lang/Throwable;)V
    //   74: athrow
    //   75: aload_2
    //   76: iload_3
    //   77: invokevirtual 538	com/google/gson/stream/JsonWriter:setLenient	(Z)V
    //   80: aload_2
    //   81: iload 4
    //   83: invokevirtual 544	com/google/gson/stream/JsonWriter:setHtmlSafe	(Z)V
    //   86: aload_2
    //   87: iload 5
    //   89: invokevirtual 398	com/google/gson/stream/JsonWriter:setSerializeNulls	(Z)V
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	e
    //   0	94	1	paramj	j
    //   0	94	2	paramJsonWriter	JsonWriter
    //   4	73	3	bool1	boolean
    //   14	68	4	bool2	boolean
    //   28	60	5	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   38	43	61	finally
    //   66	75	61	finally
    //   38	43	65	java/io/IOException
  }
  
  public void a(j paramj, Appendable paramAppendable)
    throws k
  {
    try
    {
      a(paramj, a(com.google.gson.b.j.a(paramAppendable)));
      return;
    }
    catch (IOException paramj)
    {
      throw new k(paramj);
    }
  }
  
  /* Error */
  public void a(Object paramObject, Type paramType, JsonWriter paramJsonWriter)
    throws k
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokestatic 476	com/google/gson/c/a:a	(Ljava/lang/reflect/Type;)Lcom/google/gson/c/a;
    //   5: invokevirtual 464	com/google/gson/e:a	(Lcom/google/gson/c/a;)Lcom/google/gson/t;
    //   8: astore_2
    //   9: aload_3
    //   10: invokevirtual 537	com/google/gson/stream/JsonWriter:isLenient	()Z
    //   13: istore 4
    //   15: aload_3
    //   16: iconst_1
    //   17: invokevirtual 538	com/google/gson/stream/JsonWriter:setLenient	(Z)V
    //   20: aload_3
    //   21: invokevirtual 541	com/google/gson/stream/JsonWriter:isHtmlSafe	()Z
    //   24: istore 5
    //   26: aload_3
    //   27: aload_0
    //   28: getfield 111	com/google/gson/e:i	Z
    //   31: invokevirtual 544	com/google/gson/stream/JsonWriter:setHtmlSafe	(Z)V
    //   34: aload_3
    //   35: invokevirtual 547	com/google/gson/stream/JsonWriter:getSerializeNulls	()Z
    //   38: istore 6
    //   40: aload_3
    //   41: aload_0
    //   42: getfield 107	com/google/gson/e:h	Z
    //   45: invokevirtual 398	com/google/gson/stream/JsonWriter:setSerializeNulls	(Z)V
    //   48: aload_2
    //   49: aload_3
    //   50: aload_1
    //   51: invokevirtual 561	com/google/gson/t:a	(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V
    //   54: aload_3
    //   55: iload 4
    //   57: invokevirtual 538	com/google/gson/stream/JsonWriter:setLenient	(Z)V
    //   60: aload_3
    //   61: iload 5
    //   63: invokevirtual 544	com/google/gson/stream/JsonWriter:setHtmlSafe	(Z)V
    //   66: aload_3
    //   67: iload 6
    //   69: invokevirtual 398	com/google/gson/stream/JsonWriter:setSerializeNulls	(Z)V
    //   72: return
    //   73: astore_1
    //   74: goto +13 -> 87
    //   77: astore_1
    //   78: new 353	com/google/gson/k
    //   81: dup
    //   82: aload_1
    //   83: invokespecial 359	com/google/gson/k:<init>	(Ljava/lang/Throwable;)V
    //   86: athrow
    //   87: aload_3
    //   88: iload 4
    //   90: invokevirtual 538	com/google/gson/stream/JsonWriter:setLenient	(Z)V
    //   93: aload_3
    //   94: iload 5
    //   96: invokevirtual 544	com/google/gson/stream/JsonWriter:setHtmlSafe	(Z)V
    //   99: aload_3
    //   100: iload 6
    //   102: invokevirtual 398	com/google/gson/stream/JsonWriter:setSerializeNulls	(Z)V
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	e
    //   0	107	1	paramObject	Object
    //   0	107	2	paramType	Type
    //   0	107	3	paramJsonWriter	JsonWriter
    //   13	76	4	bool1	boolean
    //   24	71	5	bool2	boolean
    //   38	63	6	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   48	54	73	finally
    //   78	87	73	finally
    //   48	54	77	java/io/IOException
  }
  
  public void a(Object paramObject, Type paramType, Appendable paramAppendable)
    throws k
  {
    try
    {
      a(paramObject, paramType, a(com.google.gson.b.j.a(paramAppendable)));
      return;
    }
    catch (IOException paramObject)
    {
      throw new k((Throwable)paramObject);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{serializeNulls:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(",factories:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",instanceCreators:");
    localStringBuilder.append(this.e);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static class a<T>
    extends t<T>
  {
    private t<T> a;
    
    public void a(JsonWriter paramJsonWriter, T paramT)
      throws IOException
    {
      if (this.a != null)
      {
        this.a.a(paramJsonWriter, paramT);
        return;
      }
      throw new IllegalStateException();
    }
    
    public void a(t<T> paramt)
    {
      if (this.a == null)
      {
        this.a = paramt;
        return;
      }
      throw new AssertionError();
    }
    
    public T b(JsonReader paramJsonReader)
      throws IOException
    {
      if (this.a != null) {
        return (T)this.a.b(paramJsonReader);
      }
      throw new IllegalStateException();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */