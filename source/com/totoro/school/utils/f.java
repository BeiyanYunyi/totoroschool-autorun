package com.totoro.school.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import java.io.File;

public class f
{
  public static String a = Environment.getExternalStorageDirectory().getPath();
  public static String b;
  public static String c = "show";
  private static String d;
  private static String e;
  private static String f = null;
  private static final String g = b;
  private static f h = null;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(File.separator);
    localStringBuilder.append("iclub/images");
    localStringBuilder.append(File.separator);
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("personal_bg");
    localStringBuilder.append(File.separator);
    d = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("iclub/images");
    localStringBuilder.append(File.separator);
    e = localStringBuilder.toString();
  }
  
  public static long a()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l;
  }
  
  public static String a(Activity paramActivity, Uri paramUri)
  {
    Object localObject = null;
    if (paramActivity != null)
    {
      if (paramUri == null) {
        return null;
      }
      if ((Build.VERSION.SDK_INT >= 19) && (DocumentsContract.isDocumentUri(paramActivity, paramUri)))
      {
        if (a(paramUri))
        {
          paramActivity = DocumentsContract.getDocumentId(paramUri).split(":");
          if ("primary".equalsIgnoreCase(paramActivity[0]))
          {
            paramUri = new StringBuilder();
            paramUri.append(Environment.getExternalStorageDirectory());
            paramUri.append("/");
            paramUri.append(paramActivity[1]);
            return paramUri.toString();
          }
        }
        else
        {
          if (b(paramUri))
          {
            paramUri = DocumentsContract.getDocumentId(paramUri);
            return a(paramActivity, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(paramUri).longValue()), null, null);
          }
          if (c(paramUri))
          {
            String[] arrayOfString = DocumentsContract.getDocumentId(paramUri).split(":");
            String str = arrayOfString[0];
            if ("image".equals(str))
            {
              paramUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            }
            else if ("video".equals(str))
            {
              paramUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            }
            else
            {
              paramUri = (Uri)localObject;
              if ("audio".equals(str)) {
                paramUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
              }
            }
            return a(paramActivity, paramUri, "_id=?", new String[] { arrayOfString[1] });
          }
        }
      }
      else
      {
        if ("content".equalsIgnoreCase(paramUri.getScheme()))
        {
          if (d(paramUri)) {
            return paramUri.getLastPathSegment();
          }
          return a(paramActivity, paramUri, null, null);
        }
        if ("file".equalsIgnoreCase(paramUri.getScheme())) {
          return paramUri.getPath();
        }
      }
      return null;
    }
    return null;
  }
  
  public static String a(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    try
    {
      paramContext = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, paramString, paramArrayOfString, null);
      if (paramContext != null) {
        try
        {
          if (paramContext.moveToFirst())
          {
            paramUri = paramContext.getString(paramContext.getColumnIndexOrThrow("_data"));
            if (paramContext != null) {
              paramContext.close();
            }
            return paramUri;
          }
        }
        finally
        {
          break label80;
        }
      }
      if (paramContext != null) {
        paramContext.close();
      }
      return null;
    }
    finally
    {
      paramContext = null;
      label80:
      if (paramContext != null) {
        paramContext.close();
      }
    }
  }
  
  public static boolean a(Uri paramUri)
  {
    return "com.android.externalstorage.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean b(Uri paramUri)
  {
    return "com.android.providers.downloads.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean c(Uri paramUri)
  {
    return "com.android.providers.media.documents".equals(paramUri.getAuthority());
  }
  
  public static boolean d(Uri paramUri)
  {
    return "com.google.android.apps.photos.content".equals(paramUri.getAuthority());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utils\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */