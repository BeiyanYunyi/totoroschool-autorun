package retrofit2;

import e.ac;
import e.ac.a;
import e.ad;
import e.e.a;
import e.f;
import e.v;
import f.c;
import f.h;
import f.l;
import f.s;
import java.io.IOException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class OkHttpCall<T>
  implements Call<T>
{
  private final Object[] args;
  private final e.a callFactory;
  private volatile boolean canceled;
  @Nullable
  @GuardedBy("this")
  private Throwable creationFailure;
  @GuardedBy("this")
  private boolean executed;
  @Nullable
  @GuardedBy("this")
  private e.e rawCall;
  private final RequestFactory requestFactory;
  private final Converter<ad, T> responseConverter;
  
  OkHttpCall(RequestFactory paramRequestFactory, Object[] paramArrayOfObject, e.a parama, Converter<ad, T> paramConverter)
  {
    this.requestFactory = paramRequestFactory;
    this.args = paramArrayOfObject;
    this.callFactory = parama;
    this.responseConverter = paramConverter;
  }
  
  private e.e createRawCall()
    throws IOException
  {
    e.e locale = this.callFactory.a(this.requestFactory.create(this.args));
    if (locale != null) {
      return locale;
    }
    throw new NullPointerException("Call.Factory returned null.");
  }
  
  public void cancel()
  {
    this.canceled = true;
    try
    {
      e.e locale = this.rawCall;
      if (locale != null) {
        locale.c();
      }
      return;
    }
    finally {}
  }
  
  public OkHttpCall<T> clone()
  {
    return new OkHttpCall(this.requestFactory, this.args, this.callFactory, this.responseConverter);
  }
  
  public void enqueue(final Callback<T> paramCallback)
  {
    Utils.checkNotNull(paramCallback, "callback == null");
    try
    {
      if (!this.executed)
      {
        this.executed = true;
        e.e locale2 = this.rawCall;
        Throwable localThrowable3 = this.creationFailure;
        e.e locale1 = locale2;
        Throwable localThrowable1 = localThrowable3;
        if (locale2 == null)
        {
          locale1 = locale2;
          localThrowable1 = localThrowable3;
          if (localThrowable3 == null) {
            try
            {
              locale1 = createRawCall();
              this.rawCall = locale1;
              localThrowable1 = localThrowable3;
            }
            catch (Throwable localThrowable2)
            {
              Utils.throwIfFatal(localThrowable2);
              this.creationFailure = localThrowable2;
              locale1 = locale2;
            }
          }
        }
        if (localThrowable2 != null)
        {
          paramCallback.onFailure(this, localThrowable2);
          return;
        }
        if (this.canceled) {
          locale1.c();
        }
        locale1.a(new f()
        {
          private void callFailure(Throwable paramAnonymousThrowable)
          {
            try
            {
              paramCallback.onFailure(OkHttpCall.this, paramAnonymousThrowable);
              return;
            }
            catch (Throwable paramAnonymousThrowable)
            {
              paramAnonymousThrowable.printStackTrace();
            }
          }
          
          public void onFailure(e.e paramAnonymouse, IOException paramAnonymousIOException)
          {
            callFailure(paramAnonymousIOException);
          }
          
          public void onResponse(e.e paramAnonymouse, ac paramAnonymousac)
          {
            try
            {
              paramAnonymouse = OkHttpCall.this.parseResponse(paramAnonymousac);
              try
              {
                paramCallback.onResponse(OkHttpCall.this, paramAnonymouse);
                return;
              }
              catch (Throwable paramAnonymouse)
              {
                paramAnonymouse.printStackTrace();
                return;
              }
              return;
            }
            catch (Throwable paramAnonymouse)
            {
              Utils.throwIfFatal(paramAnonymouse);
              callFailure(paramAnonymouse);
            }
          }
        });
        return;
      }
      throw new IllegalStateException("Already executed.");
    }
    finally {}
  }
  
  /* Error */
  public Response<T> execute()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 112	retrofit2/OkHttpCall:executed	Z
    //   6: ifne +121 -> 127
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 112	retrofit2/OkHttpCall:executed	Z
    //   14: aload_0
    //   15: getfield 114	retrofit2/OkHttpCall:creationFailure	Ljava/lang/Throwable;
    //   18: ifnull +47 -> 65
    //   21: aload_0
    //   22: getfield 114	retrofit2/OkHttpCall:creationFailure	Ljava/lang/Throwable;
    //   25: instanceof 57
    //   28: ifne +29 -> 57
    //   31: aload_0
    //   32: getfield 114	retrofit2/OkHttpCall:creationFailure	Ljava/lang/Throwable;
    //   35: instanceof 142
    //   38: ifeq +11 -> 49
    //   41: aload_0
    //   42: getfield 114	retrofit2/OkHttpCall:creationFailure	Ljava/lang/Throwable;
    //   45: checkcast 142	java/lang/RuntimeException
    //   48: athrow
    //   49: aload_0
    //   50: getfield 114	retrofit2/OkHttpCall:creationFailure	Ljava/lang/Throwable;
    //   53: checkcast 144	java/lang/Error
    //   56: athrow
    //   57: aload_0
    //   58: getfield 114	retrofit2/OkHttpCall:creationFailure	Ljava/lang/Throwable;
    //   61: checkcast 57	java/io/IOException
    //   64: athrow
    //   65: aload_0
    //   66: getfield 82	retrofit2/OkHttpCall:rawCall	Le/e;
    //   69: astore_2
    //   70: aload_2
    //   71: astore_1
    //   72: aload_2
    //   73: ifnonnull +28 -> 101
    //   76: aload_0
    //   77: invokespecial 116	retrofit2/OkHttpCall:createRawCall	()Le/e;
    //   80: astore_1
    //   81: aload_0
    //   82: aload_1
    //   83: putfield 82	retrofit2/OkHttpCall:rawCall	Le/e;
    //   86: goto +15 -> 101
    //   89: astore_1
    //   90: aload_1
    //   91: invokestatic 120	retrofit2/Utils:throwIfFatal	(Ljava/lang/Throwable;)V
    //   94: aload_0
    //   95: aload_1
    //   96: putfield 114	retrofit2/OkHttpCall:creationFailure	Ljava/lang/Throwable;
    //   99: aload_1
    //   100: athrow
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_0
    //   104: getfield 80	retrofit2/OkHttpCall:canceled	Z
    //   107: ifeq +9 -> 116
    //   110: aload_1
    //   111: invokeinterface 87 1 0
    //   116: aload_0
    //   117: aload_1
    //   118: invokeinterface 148 1 0
    //   123: invokevirtual 152	retrofit2/OkHttpCall:parseResponse	(Le/ac;)Lretrofit2/Response;
    //   126: areturn
    //   127: new 134	java/lang/IllegalStateException
    //   130: dup
    //   131: ldc -120
    //   133: invokespecial 137	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   136: athrow
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	OkHttpCall
    //   71	12	1	locale1	e.e
    //   89	29	1	localIOException	IOException
    //   137	4	1	localObject	Object
    //   69	4	2	locale2	e.e
    // Exception table:
    //   from	to	target	type
    //   76	86	89	java/io/IOException
    //   76	86	89	java/lang/RuntimeException
    //   76	86	89	java/lang/Error
    //   2	49	137	finally
    //   49	57	137	finally
    //   57	65	137	finally
    //   65	70	137	finally
    //   76	86	137	finally
    //   90	101	137	finally
    //   101	103	137	finally
    //   127	137	137	finally
    //   138	140	137	finally
  }
  
  public boolean isCanceled()
  {
    boolean bool2 = this.canceled;
    boolean bool1 = true;
    if (bool2) {
      return true;
    }
    for (;;)
    {
      try
      {
        if ((this.rawCall != null) && (this.rawCall.d())) {
          return bool1;
        }
      }
      finally {}
      bool1 = false;
    }
  }
  
  public boolean isExecuted()
  {
    try
    {
      boolean bool = this.executed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  Response<T> parseResponse(ac paramac)
    throws IOException
  {
    Object localObject = paramac.g();
    ac localac = paramac.h().a(new NoContentResponseBody(((ad)localObject).contentType(), ((ad)localObject).contentLength())).a();
    int i = localac.b();
    if ((i >= 200) && (i < 300))
    {
      if ((i != 204) && (i != 205))
      {
        paramac = new ExceptionCatchingResponseBody((ad)localObject);
        try
        {
          localObject = Response.success(this.responseConverter.convert(paramac), localac);
          return (Response<T>)localObject;
        }
        catch (RuntimeException localRuntimeException)
        {
          paramac.throwIfCaught();
          throw localRuntimeException;
        }
      }
      localRuntimeException.close();
      return Response.success(null, localac);
    }
    try
    {
      paramac = Response.error(Utils.buffer(localRuntimeException), localac);
      return paramac;
    }
    finally
    {
      localRuntimeException.close();
    }
  }
  
  /* Error */
  public e.aa request()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 82	retrofit2/OkHttpCall:rawCall	Le/e;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +14 -> 22
    //   11: aload_1
    //   12: invokeinterface 226 1 0
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: areturn
    //   22: aload_0
    //   23: getfield 114	retrofit2/OkHttpCall:creationFailure	Ljava/lang/Throwable;
    //   26: ifnull +53 -> 79
    //   29: aload_0
    //   30: getfield 114	retrofit2/OkHttpCall:creationFailure	Ljava/lang/Throwable;
    //   33: instanceof 57
    //   36: ifne +29 -> 65
    //   39: aload_0
    //   40: getfield 114	retrofit2/OkHttpCall:creationFailure	Ljava/lang/Throwable;
    //   43: instanceof 142
    //   46: ifeq +11 -> 57
    //   49: aload_0
    //   50: getfield 114	retrofit2/OkHttpCall:creationFailure	Ljava/lang/Throwable;
    //   53: checkcast 142	java/lang/RuntimeException
    //   56: athrow
    //   57: aload_0
    //   58: getfield 114	retrofit2/OkHttpCall:creationFailure	Ljava/lang/Throwable;
    //   61: checkcast 144	java/lang/Error
    //   64: athrow
    //   65: new 142	java/lang/RuntimeException
    //   68: dup
    //   69: ldc -28
    //   71: aload_0
    //   72: getfield 114	retrofit2/OkHttpCall:creationFailure	Ljava/lang/Throwable;
    //   75: invokespecial 231	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   78: athrow
    //   79: aload_0
    //   80: invokespecial 116	retrofit2/OkHttpCall:createRawCall	()Le/e;
    //   83: astore_1
    //   84: aload_0
    //   85: aload_1
    //   86: putfield 82	retrofit2/OkHttpCall:rawCall	Le/e;
    //   89: aload_1
    //   90: invokeinterface 226 1 0
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: areturn
    //   100: astore_1
    //   101: aload_0
    //   102: aload_1
    //   103: putfield 114	retrofit2/OkHttpCall:creationFailure	Ljava/lang/Throwable;
    //   106: new 142	java/lang/RuntimeException
    //   109: dup
    //   110: ldc -28
    //   112: aload_1
    //   113: invokespecial 231	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   116: athrow
    //   117: astore_1
    //   118: aload_1
    //   119: invokestatic 120	retrofit2/Utils:throwIfFatal	(Ljava/lang/Throwable;)V
    //   122: aload_0
    //   123: aload_1
    //   124: putfield 114	retrofit2/OkHttpCall:creationFailure	Ljava/lang/Throwable;
    //   127: aload_1
    //   128: athrow
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	OkHttpCall
    //   6	93	1	localObject1	Object
    //   100	13	1	localIOException	IOException
    //   117	11	1	localRuntimeException	RuntimeException
    //   129	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   79	96	100	java/io/IOException
    //   79	96	117	java/lang/RuntimeException
    //   79	96	117	java/lang/Error
    //   2	7	129	finally
    //   11	18	129	finally
    //   22	57	129	finally
    //   57	65	129	finally
    //   65	79	129	finally
    //   79	96	129	finally
    //   101	117	129	finally
    //   118	129	129	finally
  }
  
  static final class ExceptionCatchingResponseBody
    extends ad
  {
    private final ad delegate;
    @Nullable
    IOException thrownException;
    
    ExceptionCatchingResponseBody(ad paramad)
    {
      this.delegate = paramad;
    }
    
    public void close()
    {
      this.delegate.close();
    }
    
    public long contentLength()
    {
      return this.delegate.contentLength();
    }
    
    public v contentType()
    {
      return this.delegate.contentType();
    }
    
    public f.e source()
    {
      l.a(new h(this.delegate.source())
      {
        public long read(c paramAnonymousc, long paramAnonymousLong)
          throws IOException
        {
          try
          {
            paramAnonymousLong = super.read(paramAnonymousc, paramAnonymousLong);
            return paramAnonymousLong;
          }
          catch (IOException paramAnonymousc)
          {
            OkHttpCall.ExceptionCatchingResponseBody.this.thrownException = paramAnonymousc;
            throw paramAnonymousc;
          }
        }
      });
    }
    
    void throwIfCaught()
      throws IOException
    {
      if (this.thrownException == null) {
        return;
      }
      throw this.thrownException;
    }
  }
  
  static final class NoContentResponseBody
    extends ad
  {
    private final long contentLength;
    @Nullable
    private final v contentType;
    
    NoContentResponseBody(@Nullable v paramv, long paramLong)
    {
      this.contentType = paramv;
      this.contentLength = paramLong;
    }
    
    public long contentLength()
    {
      return this.contentLength;
    }
    
    public v contentType()
    {
      return this.contentType;
    }
    
    public f.e source()
    {
      throw new IllegalStateException("Cannot read raw response body of a converted body.");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\retrofit2\OkHttpCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */