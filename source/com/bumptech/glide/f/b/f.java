package com.bumptech.glide.f.b;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class f
{
  public <Z> j<Z> a(ImageView paramImageView, Class<Z> paramClass)
  {
    if (com.bumptech.glide.load.resource.a.b.class.isAssignableFrom(paramClass)) {
      return new d(paramImageView);
    }
    if (Bitmap.class.equals(paramClass)) {
      return new b(paramImageView);
    }
    if (Drawable.class.isAssignableFrom(paramClass)) {
      return new c(paramImageView);
    }
    paramImageView = new StringBuilder();
    paramImageView.append("Unhandled class: ");
    paramImageView.append(paramClass);
    paramImageView.append(", try .as*(Class).transcode(ResourceTranscoder)");
    throw new IllegalArgumentException(paramImageView.toString());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\f\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */