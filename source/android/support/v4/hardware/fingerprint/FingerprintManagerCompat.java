package android.support.v4.hardware.fingerprint;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RequiresPermission;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public final class FingerprintManagerCompat
{
  private final Context mContext;
  
  private FingerprintManagerCompat(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  @NonNull
  public static FingerprintManagerCompat from(@NonNull Context paramContext)
  {
    return new FingerprintManagerCompat(paramContext);
  }
  
  @Nullable
  @RequiresApi(23)
  private static FingerprintManager getFingerprintManagerOrNull(@NonNull Context paramContext)
  {
    if (paramContext.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
      return (FingerprintManager)paramContext.getSystemService(FingerprintManager.class);
    }
    return null;
  }
  
  @RequiresApi(23)
  static CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject paramCryptoObject)
  {
    if (paramCryptoObject == null) {
      return null;
    }
    if (paramCryptoObject.getCipher() != null) {
      return new CryptoObject(paramCryptoObject.getCipher());
    }
    if (paramCryptoObject.getSignature() != null) {
      return new CryptoObject(paramCryptoObject.getSignature());
    }
    if (paramCryptoObject.getMac() != null) {
      return new CryptoObject(paramCryptoObject.getMac());
    }
    return null;
  }
  
  @RequiresApi(23)
  private static FingerprintManager.AuthenticationCallback wrapCallback(AuthenticationCallback paramAuthenticationCallback)
  {
    new FingerprintManager.AuthenticationCallback()
    {
      public void onAuthenticationError(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        this.val$callback.onAuthenticationError(paramAnonymousInt, paramAnonymousCharSequence);
      }
      
      public void onAuthenticationFailed()
      {
        this.val$callback.onAuthenticationFailed();
      }
      
      public void onAuthenticationHelp(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        this.val$callback.onAuthenticationHelp(paramAnonymousInt, paramAnonymousCharSequence);
      }
      
      public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult paramAnonymousAuthenticationResult)
      {
        this.val$callback.onAuthenticationSucceeded(new FingerprintManagerCompat.AuthenticationResult(FingerprintManagerCompat.unwrapCryptoObject(paramAnonymousAuthenticationResult.getCryptoObject())));
      }
    };
  }
  
  @RequiresApi(23)
  private static FingerprintManager.CryptoObject wrapCryptoObject(CryptoObject paramCryptoObject)
  {
    if (paramCryptoObject == null) {
      return null;
    }
    if (paramCryptoObject.getCipher() != null) {
      return new FingerprintManager.CryptoObject(paramCryptoObject.getCipher());
    }
    if (paramCryptoObject.getSignature() != null) {
      return new FingerprintManager.CryptoObject(paramCryptoObject.getSignature());
    }
    if (paramCryptoObject.getMac() != null) {
      return new FingerprintManager.CryptoObject(paramCryptoObject.getMac());
    }
    return null;
  }
  
  @RequiresPermission("android.permission.USE_FINGERPRINT")
  public void authenticate(@Nullable CryptoObject paramCryptoObject, int paramInt, @Nullable android.support.v4.os.CancellationSignal paramCancellationSignal, @NonNull AuthenticationCallback paramAuthenticationCallback, @Nullable Handler paramHandler)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      FingerprintManager localFingerprintManager = getFingerprintManagerOrNull(this.mContext);
      if (localFingerprintManager != null)
      {
        if (paramCancellationSignal != null) {}
        for (paramCancellationSignal = (android.os.CancellationSignal)paramCancellationSignal.getCancellationSignalObject();; paramCancellationSignal = null) {
          break;
        }
        localFingerprintManager.authenticate(wrapCryptoObject(paramCryptoObject), paramCancellationSignal, paramInt, wrapCallback(paramAuthenticationCallback), paramHandler);
      }
    }
  }
  
  @RequiresPermission("android.permission.USE_FINGERPRINT")
  public boolean hasEnrolledFingerprints()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    if (i >= 23)
    {
      FingerprintManager localFingerprintManager = getFingerprintManagerOrNull(this.mContext);
      boolean bool1 = bool2;
      if (localFingerprintManager != null)
      {
        bool1 = bool2;
        if (localFingerprintManager.hasEnrolledFingerprints()) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return false;
  }
  
  @RequiresPermission("android.permission.USE_FINGERPRINT")
  public boolean isHardwareDetected()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    if (i >= 23)
    {
      FingerprintManager localFingerprintManager = getFingerprintManagerOrNull(this.mContext);
      boolean bool1 = bool2;
      if (localFingerprintManager != null)
      {
        bool1 = bool2;
        if (localFingerprintManager.isHardwareDetected()) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return false;
  }
  
  public static abstract class AuthenticationCallback
  {
    public void onAuthenticationError(int paramInt, CharSequence paramCharSequence) {}
    
    public void onAuthenticationFailed() {}
    
    public void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence) {}
    
    public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult paramAuthenticationResult) {}
  }
  
  public static final class AuthenticationResult
  {
    private final FingerprintManagerCompat.CryptoObject mCryptoObject;
    
    public AuthenticationResult(FingerprintManagerCompat.CryptoObject paramCryptoObject)
    {
      this.mCryptoObject = paramCryptoObject;
    }
    
    public FingerprintManagerCompat.CryptoObject getCryptoObject()
    {
      return this.mCryptoObject;
    }
  }
  
  public static class CryptoObject
  {
    private final Cipher mCipher;
    private final Mac mMac;
    private final Signature mSignature;
    
    public CryptoObject(@NonNull Signature paramSignature)
    {
      this.mSignature = paramSignature;
      this.mCipher = null;
      this.mMac = null;
    }
    
    public CryptoObject(@NonNull Cipher paramCipher)
    {
      this.mCipher = paramCipher;
      this.mSignature = null;
      this.mMac = null;
    }
    
    public CryptoObject(@NonNull Mac paramMac)
    {
      this.mMac = paramMac;
      this.mCipher = null;
      this.mSignature = null;
    }
    
    @Nullable
    public Cipher getCipher()
    {
      return this.mCipher;
    }
    
    @Nullable
    public Mac getMac()
    {
      return this.mMac;
    }
    
    @Nullable
    public Signature getSignature()
    {
      return this.mSignature;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\hardware\fingerprint\FingerprintManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */