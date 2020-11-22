package com.pgyersdk.c;

import com.pgyersdk.crash.g;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class b
{
  private static final Map<Integer, String> a = new HashMap();
  
  static
  {
    if ("zh".equals(Locale.getDefault().getLanguage()))
    {
      a.put(Integer.valueOf(256), "下载失败");
      a.put(Integer.valueOf(257), "下载文件失败，请重试?");
      a.put(Integer.valueOf(258), "取消");
      a.put(Integer.valueOf(259), "重试");
      a.put(Integer.valueOf(260), "正在下载...");
      a.put(Integer.valueOf(513), "更新提醒");
      a.put(Integer.valueOf(514), "无更新说明");
      a.put(Integer.valueOf(515), "取消");
      a.put(Integer.valueOf(516), "下载");
      a.put(Integer.valueOf(517), "请求检查更新失败");
      a.put(Integer.valueOf(518), "目前无网络");
      a.put(Integer.valueOf(1044), "请输入您的反馈...");
      a.put(Integer.valueOf(1045), "请输入您的邮箱（必填）");
      a.put(Integer.valueOf(1063), "请输入您的邮箱");
      a.put(Integer.valueOf(1046), "你输入的邮箱格式不正确");
      a.put(Integer.valueOf(1048), "发送");
      a.put(Integer.valueOf(1049), "取消");
      a.put(Integer.valueOf(1056), "反馈内容将会保留，下次可以继续发送");
      a.put(Integer.valueOf(1057), "你需要添加android.permission.INTERNET权限");
      a.put(Integer.valueOf(1077), "你需要添加android.permission.WRITE_EXTERNAL_STORAGE权限");
      a.put(Integer.valueOf(1058), "谢谢您的反馈");
      a.put(Integer.valueOf(1059), "发送失败，请稍后重试");
      a.put(Integer.valueOf(1060), "不支持摇一摇");
      a.put(Integer.valueOf(1061), "正在发送反馈...");
      a.put(Integer.valueOf(1062), "反馈");
      a.put(Integer.valueOf(1064), "上传屏幕截图");
      a.put(Integer.valueOf(1065), "设备详情：");
      a.put(Integer.valueOf(1072), "按住录音");
      a.put(Integer.valueOf(1073), "松开结束");
      a.put(Integer.valueOf(1074), "你需要添加android.permission.RECORD_AUDIO权限");
      a.put(Integer.valueOf(1075), "录音时间太短");
      a.put(Integer.valueOf(1076), "最大时长两分钟");
      return;
    }
    a.put(Integer.valueOf(256), "Download failed");
    a.put(Integer.valueOf(257), "The update could not be downloaded. Would you like to try again?");
    a.put(Integer.valueOf(258), "Cancel");
    a.put(Integer.valueOf(259), "Retry");
    a.put(Integer.valueOf(260), "Loading...");
    a.put(Integer.valueOf(513), "Update Available");
    a.put(Integer.valueOf(514), "There is no update note");
    a.put(Integer.valueOf(515), "Cancel");
    a.put(Integer.valueOf(516), "Download");
    a.put(Integer.valueOf(517), "check update failed");
    a.put(Integer.valueOf(518), "new work unavailable");
    a.put(Integer.valueOf(1044), "Please enter a feedback text...");
    a.put(Integer.valueOf(1045), "Please enter an email address(Required)");
    a.put(Integer.valueOf(1063), "Please enter an email address");
    a.put(Integer.valueOf(1046), "Please enter a valid email");
    a.put(Integer.valueOf(1048), "Send");
    a.put(Integer.valueOf(1049), "Cancel");
    a.put(Integer.valueOf(1056), "Feedback content will be retained, the next time you can continue to send");
    a.put(Integer.valueOf(1057), "You need to add permission of android.permission.INTERNET");
    a.put(Integer.valueOf(1058), "Feedback successfully");
    a.put(Integer.valueOf(1059), "Send failed, please try again later");
    a.put(Integer.valueOf(1060), "Shake is not supported");
    a.put(Integer.valueOf(1061), "Sending...");
    a.put(Integer.valueOf(1062), "Feedback");
    a.put(Integer.valueOf(1064), "Take screenshot");
    a.put(Integer.valueOf(1065), "Device details: ");
    a.put(Integer.valueOf(1072), "Hold to talk");
    a.put(Integer.valueOf(1073), "Release to stop");
    a.put(Integer.valueOf(1074), "You need to add permission of android.permission.RECORD_AUDIO");
    a.put(Integer.valueOf(1075), "Recording time is too short");
    a.put(Integer.valueOf(1076), "2 minutes at most");
  }
  
  public static String a(int paramInt)
  {
    return a(null, paramInt);
  }
  
  public static String a(g paramg, int paramInt)
  {
    if (paramg != null) {
      paramg = paramg.a(paramInt);
    } else {
      paramg = null;
    }
    Object localObject = paramg;
    if (paramg == null) {
      localObject = (String)a.get(Integer.valueOf(paramInt));
    }
    return (String)localObject;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */