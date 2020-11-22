package com.google.gson.b.a;

import com.google.gson.a.c;
import com.google.gson.b.f;
import com.google.gson.c.a;
import com.google.gson.e;
import com.google.gson.g;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.l;
import com.google.gson.m;
import com.google.gson.o;
import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.t;
import com.google.gson.u;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class n
{
  public static final t<String> A = new t()
  {
    public String a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      JsonToken localJsonToken = paramAnonymousJsonReader.peek();
      if (localJsonToken == JsonToken.NULL)
      {
        paramAnonymousJsonReader.nextNull();
        return null;
      }
      if (localJsonToken == JsonToken.BOOLEAN) {
        return Boolean.toString(paramAnonymousJsonReader.nextBoolean());
      }
      return paramAnonymousJsonReader.nextString();
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, String paramAnonymousString)
      throws IOException
    {
      paramAnonymousJsonWriter.value(paramAnonymousString);
    }
  };
  public static final t<BigDecimal> B = new t()
  {
    public BigDecimal a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
      {
        paramAnonymousJsonReader.nextNull();
        return null;
      }
      try
      {
        paramAnonymousJsonReader = new BigDecimal(paramAnonymousJsonReader.nextString());
        return paramAnonymousJsonReader;
      }
      catch (NumberFormatException paramAnonymousJsonReader)
      {
        throw new r(paramAnonymousJsonReader);
      }
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, BigDecimal paramAnonymousBigDecimal)
      throws IOException
    {
      paramAnonymousJsonWriter.value(paramAnonymousBigDecimal);
    }
  };
  public static final t<BigInteger> C = new t()
  {
    public BigInteger a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
      {
        paramAnonymousJsonReader.nextNull();
        return null;
      }
      try
      {
        paramAnonymousJsonReader = new BigInteger(paramAnonymousJsonReader.nextString());
        return paramAnonymousJsonReader;
      }
      catch (NumberFormatException paramAnonymousJsonReader)
      {
        throw new r(paramAnonymousJsonReader);
      }
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, BigInteger paramAnonymousBigInteger)
      throws IOException
    {
      paramAnonymousJsonWriter.value(paramAnonymousBigInteger);
    }
  };
  public static final u D = a(String.class, A);
  public static final t<StringBuilder> E = new t()
  {
    public StringBuilder a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
      {
        paramAnonymousJsonReader.nextNull();
        return null;
      }
      return new StringBuilder(paramAnonymousJsonReader.nextString());
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, StringBuilder paramAnonymousStringBuilder)
      throws IOException
    {
      if (paramAnonymousStringBuilder == null) {
        paramAnonymousStringBuilder = null;
      } else {
        paramAnonymousStringBuilder = paramAnonymousStringBuilder.toString();
      }
      paramAnonymousJsonWriter.value(paramAnonymousStringBuilder);
    }
  };
  public static final u F = a(StringBuilder.class, E);
  public static final t<StringBuffer> G = new t()
  {
    public StringBuffer a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
      {
        paramAnonymousJsonReader.nextNull();
        return null;
      }
      return new StringBuffer(paramAnonymousJsonReader.nextString());
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, StringBuffer paramAnonymousStringBuffer)
      throws IOException
    {
      if (paramAnonymousStringBuffer == null) {
        paramAnonymousStringBuffer = null;
      } else {
        paramAnonymousStringBuffer = paramAnonymousStringBuffer.toString();
      }
      paramAnonymousJsonWriter.value(paramAnonymousStringBuffer);
    }
  };
  public static final u H = a(StringBuffer.class, G);
  public static final t<URL> I = new t()
  {
    public URL a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
      {
        paramAnonymousJsonReader.nextNull();
        return null;
      }
      paramAnonymousJsonReader = paramAnonymousJsonReader.nextString();
      if ("null".equals(paramAnonymousJsonReader)) {
        return null;
      }
      return new URL(paramAnonymousJsonReader);
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, URL paramAnonymousURL)
      throws IOException
    {
      if (paramAnonymousURL == null) {
        paramAnonymousURL = null;
      } else {
        paramAnonymousURL = paramAnonymousURL.toExternalForm();
      }
      paramAnonymousJsonWriter.value(paramAnonymousURL);
    }
  };
  public static final u J = a(URL.class, I);
  public static final t<URI> K = new t()
  {
    public URI a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
      {
        paramAnonymousJsonReader.nextNull();
        return null;
      }
      try
      {
        paramAnonymousJsonReader = paramAnonymousJsonReader.nextString();
        if ("null".equals(paramAnonymousJsonReader)) {
          return null;
        }
        paramAnonymousJsonReader = new URI(paramAnonymousJsonReader);
        return paramAnonymousJsonReader;
      }
      catch (URISyntaxException paramAnonymousJsonReader)
      {
        throw new k(paramAnonymousJsonReader);
      }
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, URI paramAnonymousURI)
      throws IOException
    {
      if (paramAnonymousURI == null) {
        paramAnonymousURI = null;
      } else {
        paramAnonymousURI = paramAnonymousURI.toASCIIString();
      }
      paramAnonymousJsonWriter.value(paramAnonymousURI);
    }
  };
  public static final u L = a(URI.class, K);
  public static final t<InetAddress> M = new t()
  {
    public InetAddress a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
      {
        paramAnonymousJsonReader.nextNull();
        return null;
      }
      return InetAddress.getByName(paramAnonymousJsonReader.nextString());
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, InetAddress paramAnonymousInetAddress)
      throws IOException
    {
      if (paramAnonymousInetAddress == null) {
        paramAnonymousInetAddress = null;
      } else {
        paramAnonymousInetAddress = paramAnonymousInetAddress.getHostAddress();
      }
      paramAnonymousJsonWriter.value(paramAnonymousInetAddress);
    }
  };
  public static final u N = b(InetAddress.class, M);
  public static final t<UUID> O = new t()
  {
    public UUID a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
      {
        paramAnonymousJsonReader.nextNull();
        return null;
      }
      return UUID.fromString(paramAnonymousJsonReader.nextString());
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, UUID paramAnonymousUUID)
      throws IOException
    {
      if (paramAnonymousUUID == null) {
        paramAnonymousUUID = null;
      } else {
        paramAnonymousUUID = paramAnonymousUUID.toString();
      }
      paramAnonymousJsonWriter.value(paramAnonymousUUID);
    }
  };
  public static final u P = a(UUID.class, O);
  public static final t<Currency> Q = new t()
  {
    public Currency a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      return Currency.getInstance(paramAnonymousJsonReader.nextString());
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, Currency paramAnonymousCurrency)
      throws IOException
    {
      paramAnonymousJsonWriter.value(paramAnonymousCurrency.getCurrencyCode());
    }
  }.a();
  public static final u R = a(Currency.class, Q);
  public static final u S = new u()
  {
    public <T> t<T> a(e paramAnonymouse, a<T> paramAnonymousa)
    {
      if (paramAnonymousa.a() != Timestamp.class) {
        return null;
      }
      new t()
      {
        public Timestamp a(JsonReader paramAnonymous2JsonReader)
          throws IOException
        {
          paramAnonymous2JsonReader = (Date)this.a.b(paramAnonymous2JsonReader);
          if (paramAnonymous2JsonReader != null) {
            return new Timestamp(paramAnonymous2JsonReader.getTime());
          }
          return null;
        }
        
        public void a(JsonWriter paramAnonymous2JsonWriter, Timestamp paramAnonymous2Timestamp)
          throws IOException
        {
          this.a.a(paramAnonymous2JsonWriter, paramAnonymous2Timestamp);
        }
      };
    }
  };
  public static final t<Calendar> T = new t()
  {
    public Calendar a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
      {
        paramAnonymousJsonReader.nextNull();
        return null;
      }
      paramAnonymousJsonReader.beginObject();
      int i2 = 0;
      int i1 = 0;
      int n = 0;
      int m = 0;
      int k = 0;
      int j = 0;
      while (paramAnonymousJsonReader.peek() != JsonToken.END_OBJECT)
      {
        String str = paramAnonymousJsonReader.nextName();
        int i = paramAnonymousJsonReader.nextInt();
        if ("year".equals(str)) {
          i2 = i;
        } else if ("month".equals(str)) {
          i1 = i;
        } else if ("dayOfMonth".equals(str)) {
          n = i;
        } else if ("hourOfDay".equals(str)) {
          m = i;
        } else if ("minute".equals(str)) {
          k = i;
        } else if ("second".equals(str)) {
          j = i;
        }
      }
      paramAnonymousJsonReader.endObject();
      return new GregorianCalendar(i2, i1, n, m, k, j);
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, Calendar paramAnonymousCalendar)
      throws IOException
    {
      if (paramAnonymousCalendar == null)
      {
        paramAnonymousJsonWriter.nullValue();
        return;
      }
      paramAnonymousJsonWriter.beginObject();
      paramAnonymousJsonWriter.name("year");
      paramAnonymousJsonWriter.value(paramAnonymousCalendar.get(1));
      paramAnonymousJsonWriter.name("month");
      paramAnonymousJsonWriter.value(paramAnonymousCalendar.get(2));
      paramAnonymousJsonWriter.name("dayOfMonth");
      paramAnonymousJsonWriter.value(paramAnonymousCalendar.get(5));
      paramAnonymousJsonWriter.name("hourOfDay");
      paramAnonymousJsonWriter.value(paramAnonymousCalendar.get(11));
      paramAnonymousJsonWriter.name("minute");
      paramAnonymousJsonWriter.value(paramAnonymousCalendar.get(12));
      paramAnonymousJsonWriter.name("second");
      paramAnonymousJsonWriter.value(paramAnonymousCalendar.get(13));
      paramAnonymousJsonWriter.endObject();
    }
  };
  public static final u U = b(Calendar.class, GregorianCalendar.class, T);
  public static final t<Locale> V = new t()
  {
    public Locale a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      Object localObject1 = paramAnonymousJsonReader.peek();
      Object localObject2 = JsonToken.NULL;
      String str = null;
      if (localObject1 == localObject2)
      {
        paramAnonymousJsonReader.nextNull();
        return null;
      }
      localObject2 = new StringTokenizer(paramAnonymousJsonReader.nextString(), "_");
      if (((StringTokenizer)localObject2).hasMoreElements()) {
        paramAnonymousJsonReader = ((StringTokenizer)localObject2).nextToken();
      } else {
        paramAnonymousJsonReader = null;
      }
      if (((StringTokenizer)localObject2).hasMoreElements()) {
        localObject1 = ((StringTokenizer)localObject2).nextToken();
      } else {
        localObject1 = null;
      }
      if (((StringTokenizer)localObject2).hasMoreElements()) {
        str = ((StringTokenizer)localObject2).nextToken();
      }
      if ((localObject1 == null) && (str == null)) {
        return new Locale(paramAnonymousJsonReader);
      }
      if (str == null) {
        return new Locale(paramAnonymousJsonReader, (String)localObject1);
      }
      return new Locale(paramAnonymousJsonReader, (String)localObject1, str);
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, Locale paramAnonymousLocale)
      throws IOException
    {
      if (paramAnonymousLocale == null) {
        paramAnonymousLocale = null;
      } else {
        paramAnonymousLocale = paramAnonymousLocale.toString();
      }
      paramAnonymousJsonWriter.value(paramAnonymousLocale);
    }
  };
  public static final u W = a(Locale.class, V);
  public static final t<j> X = new t()
  {
    public j a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      Object localObject;
      switch (n.29.a[paramAnonymousJsonReader.peek().ordinal()])
      {
      default: 
        throw new IllegalArgumentException();
      case 6: 
        localObject = new m();
        paramAnonymousJsonReader.beginObject();
        while (paramAnonymousJsonReader.hasNext()) {
          ((m)localObject).a(paramAnonymousJsonReader.nextName(), a(paramAnonymousJsonReader));
        }
        paramAnonymousJsonReader.endObject();
        return (j)localObject;
      case 5: 
        localObject = new g();
        paramAnonymousJsonReader.beginArray();
        while (paramAnonymousJsonReader.hasNext()) {
          ((g)localObject).a(a(paramAnonymousJsonReader));
        }
        paramAnonymousJsonReader.endArray();
        return (j)localObject;
      case 4: 
        paramAnonymousJsonReader.nextNull();
        return l.a;
      case 3: 
        return new o(paramAnonymousJsonReader.nextString());
      case 2: 
        return new o(Boolean.valueOf(paramAnonymousJsonReader.nextBoolean()));
      }
      return new o(new f(paramAnonymousJsonReader.nextString()));
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, j paramAnonymousj)
      throws IOException
    {
      if ((paramAnonymousj != null) && (!paramAnonymousj.j()))
      {
        if (paramAnonymousj.i())
        {
          paramAnonymousj = paramAnonymousj.m();
          if (paramAnonymousj.p())
          {
            paramAnonymousJsonWriter.value(paramAnonymousj.a());
            return;
          }
          if (paramAnonymousj.o())
          {
            paramAnonymousJsonWriter.value(paramAnonymousj.f());
            return;
          }
          paramAnonymousJsonWriter.value(paramAnonymousj.b());
          return;
        }
        if (paramAnonymousj.g())
        {
          paramAnonymousJsonWriter.beginArray();
          paramAnonymousj = paramAnonymousj.l().iterator();
          while (paramAnonymousj.hasNext()) {
            a(paramAnonymousJsonWriter, (j)paramAnonymousj.next());
          }
          paramAnonymousJsonWriter.endArray();
          return;
        }
        if (paramAnonymousj.h())
        {
          paramAnonymousJsonWriter.beginObject();
          paramAnonymousj = paramAnonymousj.k().o().iterator();
          while (paramAnonymousj.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)paramAnonymousj.next();
            paramAnonymousJsonWriter.name((String)localEntry.getKey());
            a(paramAnonymousJsonWriter, (j)localEntry.getValue());
          }
          paramAnonymousJsonWriter.endObject();
          return;
        }
        paramAnonymousJsonWriter = new StringBuilder();
        paramAnonymousJsonWriter.append("Couldn't write ");
        paramAnonymousJsonWriter.append(paramAnonymousj.getClass());
        throw new IllegalArgumentException(paramAnonymousJsonWriter.toString());
      }
      paramAnonymousJsonWriter.nullValue();
    }
  };
  public static final u Y = b(j.class, X);
  public static final u Z = new u()
  {
    public <T> t<T> a(e paramAnonymouse, a<T> paramAnonymousa)
    {
      paramAnonymousa = paramAnonymousa.a();
      if ((Enum.class.isAssignableFrom(paramAnonymousa)) && (paramAnonymousa != Enum.class))
      {
        paramAnonymouse = paramAnonymousa;
        if (!paramAnonymousa.isEnum()) {
          paramAnonymouse = paramAnonymousa.getSuperclass();
        }
        return new n.a(paramAnonymouse);
      }
      return null;
    }
  };
  public static final t<Class> a = new t()
  {
    public Class a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, Class paramAnonymousClass)
      throws IOException
    {
      paramAnonymousJsonWriter = new StringBuilder();
      paramAnonymousJsonWriter.append("Attempted to serialize java.lang.Class: ");
      paramAnonymousJsonWriter.append(paramAnonymousClass.getName());
      paramAnonymousJsonWriter.append(". Forgot to register a type adapter?");
      throw new UnsupportedOperationException(paramAnonymousJsonWriter.toString());
    }
  }.a();
  public static final u b = a(Class.class, a);
  public static final t<BitSet> c = new t()
  {
    public BitSet a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      BitSet localBitSet = new BitSet();
      paramAnonymousJsonReader.beginArray();
      Object localObject = paramAnonymousJsonReader.peek();
      int i = 0;
      while (localObject != JsonToken.END_ARRAY)
      {
        int j = n.29.a[localObject.ordinal()];
        boolean bool = true;
        switch (j)
        {
        default: 
          paramAnonymousJsonReader = new StringBuilder();
          paramAnonymousJsonReader.append("Invalid bitset value type: ");
          paramAnonymousJsonReader.append(localObject);
          throw new r(paramAnonymousJsonReader.toString());
        case 3: 
          localObject = paramAnonymousJsonReader.nextString();
        }
        do
        {
          try
          {
            j = Integer.parseInt((String)localObject);
            if (j != 0) {
              break;
            }
            bool = false;
          }
          catch (NumberFormatException paramAnonymousJsonReader)
          {
            for (;;) {}
          }
          paramAnonymousJsonReader = new StringBuilder();
          paramAnonymousJsonReader.append("Error: Expecting: bitset number value (1, 0), Found: ");
          paramAnonymousJsonReader.append((String)localObject);
          throw new r(paramAnonymousJsonReader.toString());
          bool = paramAnonymousJsonReader.nextBoolean();
          break;
        } while (paramAnonymousJsonReader.nextInt() == 0);
        if (bool) {
          localBitSet.set(i);
        }
        i += 1;
        localObject = paramAnonymousJsonReader.peek();
      }
      paramAnonymousJsonReader.endArray();
      return localBitSet;
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, BitSet paramAnonymousBitSet)
      throws IOException
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }.a();
  public static final u d = a(BitSet.class, c);
  public static final t<Boolean> e = new t()
  {
    public Boolean a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
      {
        paramAnonymousJsonReader.nextNull();
        return null;
      }
      if (paramAnonymousJsonReader.peek() == JsonToken.STRING) {
        return Boolean.valueOf(Boolean.parseBoolean(paramAnonymousJsonReader.nextString()));
      }
      return Boolean.valueOf(paramAnonymousJsonReader.nextBoolean());
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, Boolean paramAnonymousBoolean)
      throws IOException
    {
      paramAnonymousJsonWriter.value(paramAnonymousBoolean);
    }
  };
  public static final t<Boolean> f = new t()
  {
    public Boolean a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
      {
        paramAnonymousJsonReader.nextNull();
        return null;
      }
      return Boolean.valueOf(paramAnonymousJsonReader.nextString());
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, Boolean paramAnonymousBoolean)
      throws IOException
    {
      if (paramAnonymousBoolean == null) {
        paramAnonymousBoolean = "null";
      } else {
        paramAnonymousBoolean = paramAnonymousBoolean.toString();
      }
      paramAnonymousJsonWriter.value(paramAnonymousBoolean);
    }
  };
  public static final u g = a(Boolean.TYPE, Boolean.class, e);
  public static final t<Number> h = new t()
  {
    public Number a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
      {
        paramAnonymousJsonReader.nextNull();
        return null;
      }
      try
      {
        byte b = (byte)paramAnonymousJsonReader.nextInt();
        return Byte.valueOf(b);
      }
      catch (NumberFormatException paramAnonymousJsonReader)
      {
        throw new r(paramAnonymousJsonReader);
      }
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, Number paramAnonymousNumber)
      throws IOException
    {
      paramAnonymousJsonWriter.value(paramAnonymousNumber);
    }
  };
  public static final u i = a(Byte.TYPE, Byte.class, h);
  public static final t<Number> j = new t()
  {
    public Number a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
      {
        paramAnonymousJsonReader.nextNull();
        return null;
      }
      try
      {
        short s = (short)paramAnonymousJsonReader.nextInt();
        return Short.valueOf(s);
      }
      catch (NumberFormatException paramAnonymousJsonReader)
      {
        throw new r(paramAnonymousJsonReader);
      }
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, Number paramAnonymousNumber)
      throws IOException
    {
      paramAnonymousJsonWriter.value(paramAnonymousNumber);
    }
  };
  public static final u k = a(Short.TYPE, Short.class, j);
  public static final t<Number> l = new t()
  {
    public Number a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
      {
        paramAnonymousJsonReader.nextNull();
        return null;
      }
      try
      {
        int i = paramAnonymousJsonReader.nextInt();
        return Integer.valueOf(i);
      }
      catch (NumberFormatException paramAnonymousJsonReader)
      {
        throw new r(paramAnonymousJsonReader);
      }
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, Number paramAnonymousNumber)
      throws IOException
    {
      paramAnonymousJsonWriter.value(paramAnonymousNumber);
    }
  };
  public static final u m = a(Integer.TYPE, Integer.class, l);
  public static final t<AtomicInteger> n = new t()
  {
    public AtomicInteger a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      try
      {
        paramAnonymousJsonReader = new AtomicInteger(paramAnonymousJsonReader.nextInt());
        return paramAnonymousJsonReader;
      }
      catch (NumberFormatException paramAnonymousJsonReader)
      {
        throw new r(paramAnonymousJsonReader);
      }
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, AtomicInteger paramAnonymousAtomicInteger)
      throws IOException
    {
      paramAnonymousJsonWriter.value(paramAnonymousAtomicInteger.get());
    }
  }.a();
  public static final u o = a(AtomicInteger.class, n);
  public static final t<AtomicBoolean> p = new t()
  {
    public AtomicBoolean a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      return new AtomicBoolean(paramAnonymousJsonReader.nextBoolean());
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, AtomicBoolean paramAnonymousAtomicBoolean)
      throws IOException
    {
      paramAnonymousJsonWriter.value(paramAnonymousAtomicBoolean.get());
    }
  }.a();
  public static final u q = a(AtomicBoolean.class, p);
  public static final t<AtomicIntegerArray> r = new t()
  {
    public AtomicIntegerArray a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      ArrayList localArrayList = new ArrayList();
      paramAnonymousJsonReader.beginArray();
      while (paramAnonymousJsonReader.hasNext()) {
        try
        {
          localArrayList.add(Integer.valueOf(paramAnonymousJsonReader.nextInt()));
        }
        catch (NumberFormatException paramAnonymousJsonReader)
        {
          throw new r(paramAnonymousJsonReader);
        }
      }
      paramAnonymousJsonReader.endArray();
      int j = localArrayList.size();
      paramAnonymousJsonReader = new AtomicIntegerArray(j);
      int i = 0;
      while (i < j)
      {
        paramAnonymousJsonReader.set(i, ((Integer)localArrayList.get(i)).intValue());
        i += 1;
      }
      return paramAnonymousJsonReader;
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, AtomicIntegerArray paramAnonymousAtomicIntegerArray)
      throws IOException
    {
      paramAnonymousJsonWriter.beginArray();
      int j = paramAnonymousAtomicIntegerArray.length();
      int i = 0;
      while (i < j)
      {
        paramAnonymousJsonWriter.value(paramAnonymousAtomicIntegerArray.get(i));
        i += 1;
      }
      paramAnonymousJsonWriter.endArray();
    }
  }.a();
  public static final u s = a(AtomicIntegerArray.class, r);
  public static final t<Number> t = new t()
  {
    public Number a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
      {
        paramAnonymousJsonReader.nextNull();
        return null;
      }
      try
      {
        long l = paramAnonymousJsonReader.nextLong();
        return Long.valueOf(l);
      }
      catch (NumberFormatException paramAnonymousJsonReader)
      {
        throw new r(paramAnonymousJsonReader);
      }
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, Number paramAnonymousNumber)
      throws IOException
    {
      paramAnonymousJsonWriter.value(paramAnonymousNumber);
    }
  };
  public static final t<Number> u = new t()
  {
    public Number a(JsonReader paramAnonymousJsonReader)
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
      paramAnonymousJsonWriter.value(paramAnonymousNumber);
    }
  };
  public static final t<Number> v = new t()
  {
    public Number a(JsonReader paramAnonymousJsonReader)
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
      paramAnonymousJsonWriter.value(paramAnonymousNumber);
    }
  };
  public static final t<Number> w = new t()
  {
    public Number a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      JsonToken localJsonToken = paramAnonymousJsonReader.peek();
      int i = n.29.a[localJsonToken.ordinal()];
      if (i != 1) {
        switch (i)
        {
        default: 
          paramAnonymousJsonReader = new StringBuilder();
          paramAnonymousJsonReader.append("Expecting number, got: ");
          paramAnonymousJsonReader.append(localJsonToken);
          throw new r(paramAnonymousJsonReader.toString());
        case 4: 
          paramAnonymousJsonReader.nextNull();
          return null;
        }
      }
      return new f(paramAnonymousJsonReader.nextString());
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, Number paramAnonymousNumber)
      throws IOException
    {
      paramAnonymousJsonWriter.value(paramAnonymousNumber);
    }
  };
  public static final u x = a(Number.class, w);
  public static final t<Character> y = new t()
  {
    public Character a(JsonReader paramAnonymousJsonReader)
      throws IOException
    {
      if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
      {
        paramAnonymousJsonReader.nextNull();
        return null;
      }
      paramAnonymousJsonReader = paramAnonymousJsonReader.nextString();
      if (paramAnonymousJsonReader.length() == 1) {
        return Character.valueOf(paramAnonymousJsonReader.charAt(0));
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expecting character, got: ");
      localStringBuilder.append(paramAnonymousJsonReader);
      throw new r(localStringBuilder.toString());
    }
    
    public void a(JsonWriter paramAnonymousJsonWriter, Character paramAnonymousCharacter)
      throws IOException
    {
      if (paramAnonymousCharacter == null) {
        paramAnonymousCharacter = null;
      } else {
        paramAnonymousCharacter = String.valueOf(paramAnonymousCharacter);
      }
      paramAnonymousJsonWriter.value(paramAnonymousCharacter);
    }
  };
  public static final u z = a(Character.TYPE, Character.class, y);
  
  public static <TT> u a(Class<TT> paramClass, final t<TT> paramt)
  {
    new u()
    {
      public <T> t<T> a(e paramAnonymouse, a<T> paramAnonymousa)
      {
        if (paramAnonymousa.a() == this.a) {
          return paramt;
        }
        return null;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Factory[type=");
        localStringBuilder.append(this.a.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(paramt);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
  }
  
  public static <TT> u a(Class<TT> paramClass1, final Class<TT> paramClass2, final t<? super TT> paramt)
  {
    new u()
    {
      public <T> t<T> a(e paramAnonymouse, a<T> paramAnonymousa)
      {
        paramAnonymouse = paramAnonymousa.a();
        if ((paramAnonymouse != this.a) && (paramAnonymouse != paramClass2)) {
          return null;
        }
        return paramt;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Factory[type=");
        localStringBuilder.append(paramClass2.getName());
        localStringBuilder.append("+");
        localStringBuilder.append(this.a.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(paramt);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
  }
  
  public static <T1> u b(Class<T1> paramClass, final t<T1> paramt)
  {
    new u()
    {
      public <T2> t<T2> a(final e paramAnonymouse, a<T2> paramAnonymousa)
      {
        paramAnonymouse = paramAnonymousa.a();
        if (!this.a.isAssignableFrom(paramAnonymouse)) {
          return null;
        }
        new t()
        {
          public void a(JsonWriter paramAnonymous2JsonWriter, T1 paramAnonymous2T1)
            throws IOException
          {
            n.28.this.b.a(paramAnonymous2JsonWriter, paramAnonymous2T1);
          }
          
          public T1 b(JsonReader paramAnonymous2JsonReader)
            throws IOException
          {
            paramAnonymous2JsonReader = n.28.this.b.b(paramAnonymous2JsonReader);
            if (paramAnonymous2JsonReader != null)
            {
              if (paramAnonymouse.isInstance(paramAnonymous2JsonReader)) {
                return paramAnonymous2JsonReader;
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Expected a ");
              localStringBuilder.append(paramAnonymouse.getName());
              localStringBuilder.append(" but was ");
              localStringBuilder.append(paramAnonymous2JsonReader.getClass().getName());
              throw new r(localStringBuilder.toString());
            }
            return paramAnonymous2JsonReader;
          }
        };
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Factory[typeHierarchy=");
        localStringBuilder.append(this.a.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(paramt);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
  }
  
  public static <TT> u b(Class<TT> paramClass, final Class<? extends TT> paramClass1, final t<? super TT> paramt)
  {
    new u()
    {
      public <T> t<T> a(e paramAnonymouse, a<T> paramAnonymousa)
      {
        paramAnonymouse = paramAnonymousa.a();
        if ((paramAnonymouse != this.a) && (paramAnonymouse != paramClass1)) {
          return null;
        }
        return paramt;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Factory[type=");
        localStringBuilder.append(this.a.getName());
        localStringBuilder.append("+");
        localStringBuilder.append(paramClass1.getName());
        localStringBuilder.append(",adapter=");
        localStringBuilder.append(paramt);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
    };
  }
  
  private static final class a<T extends Enum<T>>
    extends t<T>
  {
    private final Map<String, T> a = new HashMap();
    private final Map<T, String> b = new HashMap();
    
    public a(Class<T> paramClass)
    {
      try
      {
        Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
        int k = arrayOfEnum.length;
        int i = 0;
        while (i < k)
        {
          Enum localEnum = arrayOfEnum[i];
          Object localObject1 = localEnum.name();
          Object localObject2 = (c)paramClass.getField((String)localObject1).getAnnotation(c.class);
          if (localObject2 != null)
          {
            String str = ((c)localObject2).a();
            localObject2 = ((c)localObject2).b();
            int m = localObject2.length;
            int j = 0;
            for (;;)
            {
              localObject1 = str;
              if (j >= m) {
                break;
              }
              localObject1 = localObject2[j];
              this.a.put(localObject1, localEnum);
              j += 1;
            }
          }
          this.a.put(localObject1, localEnum);
          this.b.put(localEnum, localObject1);
          i += 1;
        }
        return;
      }
      catch (NoSuchFieldException paramClass)
      {
        throw new AssertionError(paramClass);
      }
    }
    
    public T a(JsonReader paramJsonReader)
      throws IOException
    {
      if (paramJsonReader.peek() == JsonToken.NULL)
      {
        paramJsonReader.nextNull();
        return null;
      }
      return (Enum)this.a.get(paramJsonReader.nextString());
    }
    
    public void a(JsonWriter paramJsonWriter, T paramT)
      throws IOException
    {
      if (paramT == null) {
        paramT = null;
      } else {
        paramT = (String)this.b.get(paramT);
      }
      paramJsonWriter.value(paramT);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\b\a\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */