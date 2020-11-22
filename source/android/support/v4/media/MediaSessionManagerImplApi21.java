package android.support.v4.media;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

@RequiresApi(21)
class MediaSessionManagerImplApi21
  extends MediaSessionManagerImplBase
{
  MediaSessionManagerImplApi21(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  private boolean hasMediaControlPermission(@NonNull MediaSessionManager.RemoteUserInfoImpl paramRemoteUserInfoImpl)
  {
    return getContext().checkPermission("android.permission.MEDIA_CONTENT_CONTROL", paramRemoteUserInfoImpl.getPid(), paramRemoteUserInfoImpl.getUid()) == 0;
  }
  
  public boolean isTrustedForMediaControl(@NonNull MediaSessionManager.RemoteUserInfoImpl paramRemoteUserInfoImpl)
  {
    return (hasMediaControlPermission(paramRemoteUserInfoImpl)) || (super.isTrustedForMediaControl(paramRemoteUserInfoImpl));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\media\MediaSessionManagerImplApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */