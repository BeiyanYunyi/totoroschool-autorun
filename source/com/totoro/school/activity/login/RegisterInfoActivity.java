package com.totoro.school.activity.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.bumptech.glide.h;
import com.bumptech.glide.load.resource.bitmap.d;
import com.totoro.school.activity.MainFragmentActivity;
import com.totoro.school.e.c;
import com.totoro.school.entity.login.login.LoginReturnModel;
import com.totoro.school.entity.login.register.RegisterRequestModel;
import com.totoro.school.entity.login.register.RegisterReturnModel;
import com.totoro.school.entity.upload.UploadImageReturnModel;
import com.totoro.school.utilpub.network.BaseActivity;
import com.totoro.school.utils.n;
import com.totoro.school.view.dialog.OneButtonDialog;
import com.totoro.school.view.dialog.OneButtonDialog.a;
import e.aa.a;
import e.ab;
import e.ac;
import e.b.a.a;
import e.v;
import e.w;
import e.w.a;
import e.x;
import e.x.a;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RegisterInfoActivity
  extends BaseActivity
{
  c a;
  private RegisterRequestModel b;
  private File c;
  private String d;
  private String e;
  @BindView(2131296376)
  EditText etPassword;
  private String f;
  private String g;
  @BindView(2131296404)
  ImageView headImage;
  @BindView(2131296381)
  EditText tvTwoPassword;
  @BindView(2131296708)
  EditText tvUsername;
  
  public RegisterInfoActivity()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
    localStringBuilder.append("/account/");
    this.d = localStringBuilder.toString();
    this.e = "icon_cache/";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append(this.e);
    this.f = localStringBuilder.toString();
    this.g = "faceImage.jpeg";
  }
  
  private void a(Uri paramUri)
  {
    if (paramUri == null)
    {
      Log.e("error", "The uri is not exist.");
      return;
    }
    Intent localIntent = new Intent("com.android.camera.action.CROP");
    localIntent.setDataAndType(paramUri, "image/*");
    localIntent.putExtra("crop", "true");
    localIntent.putExtra("aspectX", 1);
    localIntent.putExtra("aspectY", 1);
    localIntent.putExtra("outputX", 640);
    localIntent.putExtra("outputY", 640);
    localIntent.putExtra("scale", true);
    localIntent.putExtra("return-data", false);
    localIntent.putExtra("output", paramUri);
    localIntent.addFlags(1);
    localIntent.addFlags(2);
    localIntent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
    localIntent.putExtra("noFaceDetection", false);
    grantUriPermission(getPackageName(), paramUri, 2);
    grantUriPermission(getPackageName(), paramUri, 1);
    startActivityForResult(localIntent, 30);
  }
  
  private void a(File paramFile)
  {
    final ProgressDialog localProgressDialog = new ProgressDialog(this);
    localProgressDialog.setMessage("头像上传中");
    localProgressDialog.setCancelable(false);
    if (!localProgressDialog.isShowing()) {
      localProgressDialog.show();
    }
    Object localObject = new w.a();
    ((w.a)localObject).a(w.e);
    ((w.a)localObject).a("image", paramFile.getName(), ab.create(v.b("image/png"), paramFile));
    ((w.a)localObject).a("modeName", "THUMBNAIL");
    paramFile = ((w.a)localObject).a();
    paramFile = new aa.a().a("http://112.74.63.31:8091/api/msi/person/updateMsiPerson").a(paramFile).a("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIzOWM2YjA4MDEzOWM0ODg0ODNhMTZiY2JkOTNmYjk3MTE1MTY2NjY2NjY2LExPTCMxOTkxNjgyMjg0NzMwMDAj5p2o5paMIiwiZXhwIjoxNTc4OTI4NDk2fQ.llSivqMmxXbS-cWclRFisbzB8CnhVcdp3Zk3Sm8XiQr7t05Ja7ZwU0w-cRk6v0SHL96tck_AB6xvyGZXtIXO-w").a("deviceResource", "0").a();
    localObject = new x();
    e.b.a locala = new e.b.a();
    locala.a(a.a.BODY);
    ((x)localObject).A().b(locala).c(20L, TimeUnit.SECONDS).a().a(paramFile).a(new e.f()
    {
      public void onFailure(e.e paramAnonymouse, IOException paramAnonymousIOException)
      {
        paramAnonymousIOException.printStackTrace();
        RegisterInfoActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            RegisterInfoActivity.1.this.a.dismiss();
            Toast.makeText(RegisterInfoActivity.this.getApplicationContext(), "上传失败", 0).show();
          }
        });
      }
      
      public void onResponse(e.e paramAnonymouse, final ac paramAnonymousac)
        throws IOException
      {
        RegisterInfoActivity.this.runOnUiThread(new Runnable()
        {
          public void run()
          {
            RegisterInfoActivity.1.this.a.dismiss();
            com.bumptech.glide.e.a(RegisterInfoActivity.this).a(RegisterInfoActivity.a(RegisterInfoActivity.this)).d().a(new d[] { new com.totoro.school.utils.glide.a(RegisterInfoActivity.this) }).a(2131558452).a(RegisterInfoActivity.this.headImage);
            if (paramAnonymousac.c())
            {
              Object localObject = paramAnonymousac.g().toString();
              localObject = (UploadImageReturnModel)new com.google.gson.e().a((String)localObject, UploadImageReturnModel.class);
              RegisterInfoActivity.this.runOnUiThread(new Runnable()
              {
                public void run() {}
              });
              return;
            }
            RegisterInfoActivity.this.runOnUiThread(new Runnable()
            {
              public void run()
              {
                Toast.makeText(RegisterInfoActivity.this.getApplicationContext(), "上传失败", 0).show();
              }
            });
          }
        });
      }
    });
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      c(getString(2131689649));
      return false;
    }
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      if (!paramString2.equals(paramString3))
      {
        c(getString(2131689631));
        return false;
      }
      return true;
    }
    c(getString(2131689650));
    return false;
  }
  
  private void c(String paramString)
  {
    paramString = new OneButtonDialog(this, 2131755512, "", paramString, "", new OneButtonDialog.a()
    {
      public void a(String paramAnonymousString)
      {
        "confirm_btn".equals(paramAnonymousString);
      }
    });
    Window localWindow = paramString.getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localWindow.setGravity(17);
    localWindow.setAttributes(localLayoutParams);
    paramString.setCanceledOnTouchOutside(true);
    paramString.setCancelable(true);
    paramString.show();
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    int i = paramString.hashCode();
    int j = -1;
    if (i != -1833496647)
    {
      if ((i == -690213213) && (paramString.equals("register")))
      {
        i = 0;
        break label63;
      }
    }
    else if (paramString.equals("login_request"))
    {
      i = 1;
      break label63;
    }
    i = -1;
    switch (i)
    {
    default: 
      
    case 1: 
      paramString = (LoginReturnModel)com.totoro.school.utilpub.network.a.b.a(paramObject, LoginReturnModel.class);
      if (paramString != null)
      {
        paramObject = paramString.getCode();
        if ((((String)paramObject).hashCode() == 1477632) && (((String)paramObject).equals("0000"))) {
          j = 0;
        }
        if (j != 0) {
          return;
        }
        paramString.save();
        System.gc();
        n.a(getApplicationContext(), "autoLogin", Boolean.valueOf(false));
        paramString = new Intent(this, MainFragmentActivity.class);
        paramString.setFlags(268468224);
        startActivity(paramString);
        finish();
        return;
      }
      break;
    case 0: 
      label63:
      paramString = (RegisterReturnModel)com.totoro.school.utilpub.network.a.b.a(paramObject, RegisterReturnModel.class);
      if (paramString != null)
      {
        paramString = paramString.getCode();
        if ((paramString.hashCode() == 1715960) && (paramString.equals("8000"))) {
          j = 0;
        }
        if (j != 0) {
          return;
        }
        this.a.a(this.b.getPhoneNumber(), this.etPassword.getText().toString(), "2", getBaseContext());
      }
      break;
    }
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    super.a(paramString, paramThrowable);
    paramString = new StringBuilder();
    paramString.append("e:");
    paramString.append(paramThrowable.toString());
    Log.i("okhttp", paramString.toString());
  }
  
  @OnClick({2131296298})
  public void back(View paramView)
  {
    finish();
  }
  
  @OnClick({2131296404})
  public void headmage(View paramView) {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2)
    {
      if (paramInt2 == -1)
      {
        if (paramIntent != null)
        {
          this.c = new File(com.totoro.school.utils.f.a(this, paramIntent.getData()));
          if (Build.VERSION.SDK_INT >= 24)
          {
            a(FileProvider.getUriForFile(getApplicationContext(), "com.totoro.school.fileProvider", this.c));
            return;
          }
          a(Uri.fromFile(this.c));
        }
      }
      else {
        Toast.makeText(getApplicationContext(), "取消头像设置", 0).show();
      }
    }
    else
    {
      if (paramInt1 == 1)
      {
        if (paramInt2 == -1)
        {
          this.c = new File(this.f, this.g);
          if (Build.VERSION.SDK_INT >= 24)
          {
            a(FileProvider.getUriForFile(getApplicationContext(), "com.totoro.school.fileProvider", this.c));
            return;
          }
          a(Uri.fromFile(this.c));
          return;
        }
        Toast.makeText(getApplicationContext(), "取消头像设置", 0).show();
        return;
      }
      if (paramInt1 == 30)
      {
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          a(this.c);
          return;
        }
        if (paramInt2 == 0)
        {
          Toast.makeText(getApplicationContext(), "取消头像设置", 0).show();
          return;
        }
        Toast.makeText(getApplicationContext(), "设置头像失败", 0).show();
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131492912);
    ButterKnife.bind(this);
    this.a = new c(this);
    this.b = ((RegisterRequestModel)getIntent().getSerializableExtra("registerModel"));
  }
  
  @OnClick({2131296686})
  public void register(View paramView)
  {
    paramView = this.tvUsername.getText().toString();
    String str = this.etPassword.getText().toString();
    if (a(paramView, str, this.tvTwoPassword.getText().toString())) {
      this.a.a(this.b.getSnCode(), paramView, this.b.getIdNumber(), this.b.getSchoolName(), this.b.getSchoolarea(), str, this.b.getVerificationCode(), this.b.getPhoneNumber(), this.b.getWechat(), this.b.getQq(), this.b.getClassName(), getBaseContext());
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\activity\login\RegisterInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */