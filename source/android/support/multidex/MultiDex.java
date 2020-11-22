package android.support.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.util.Log;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class MultiDex
{
  private static final String CODE_CACHE_NAME = "code_cache";
  private static final String CODE_CACHE_SECONDARY_FOLDER_NAME = "secondary-dexes";
  private static final boolean IS_VM_MULTIDEX_CAPABLE = isVMMultidexCapable(System.getProperty("java.vm.version"));
  private static final int MAX_SUPPORTED_SDK_VERSION = 20;
  private static final int MIN_SDK_VERSION = 4;
  private static final String NO_KEY_PREFIX = "";
  private static final String OLD_SECONDARY_FOLDER_NAME = "secondary-dexes";
  static final String TAG = "MultiDex";
  private static final int VM_WITH_MULTIDEX_VERSION_MAJOR = 2;
  private static final int VM_WITH_MULTIDEX_VERSION_MINOR = 1;
  private static final Set<File> installedApk = new HashSet();
  
  private static void clearOldDexDir(Context paramContext)
    throws Exception
  {
    paramContext = new File(paramContext.getFilesDir(), "secondary-dexes");
    if (paramContext.isDirectory())
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Clearing old secondary dex dir (");
      ((StringBuilder)localObject1).append(paramContext.getPath());
      ((StringBuilder)localObject1).append(").");
      Log.i("MultiDex", ((StringBuilder)localObject1).toString());
      localObject1 = paramContext.listFiles();
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Failed to list secondary dex dir content (");
        ((StringBuilder)localObject1).append(paramContext.getPath());
        ((StringBuilder)localObject1).append(").");
        Log.w("MultiDex", ((StringBuilder)localObject1).toString());
        return;
      }
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Trying to delete old file ");
        localStringBuilder.append(((File)localObject2).getPath());
        localStringBuilder.append(" of size ");
        localStringBuilder.append(((File)localObject2).length());
        Log.i("MultiDex", localStringBuilder.toString());
        if (!((File)localObject2).delete())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Failed to delete old file ");
          localStringBuilder.append(((File)localObject2).getPath());
          Log.w("MultiDex", localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Deleted old file ");
          localStringBuilder.append(((File)localObject2).getPath());
          Log.i("MultiDex", localStringBuilder.toString());
        }
        i += 1;
      }
      if (!paramContext.delete())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Failed to delete secondary dex dir ");
        ((StringBuilder)localObject1).append(paramContext.getPath());
        Log.w("MultiDex", ((StringBuilder)localObject1).toString());
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Deleted old secondary dex dir ");
      ((StringBuilder)localObject1).append(paramContext.getPath());
      Log.i("MultiDex", ((StringBuilder)localObject1).toString());
    }
  }
  
  private static void doInstallation(Context paramContext, File paramFile1, File paramFile2, String paramString1, String paramString2)
    throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException
  {
    synchronized (installedApk)
    {
      if (installedApk.contains(paramFile1)) {
        return;
      }
      installedApk.add(paramFile1);
      Object localObject;
      if (Build.VERSION.SDK_INT > 20)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MultiDex is not guaranteed to work in SDK version ");
        ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
        ((StringBuilder)localObject).append(": SDK version higher than ");
        ((StringBuilder)localObject).append(20);
        ((StringBuilder)localObject).append(" should be backed by ");
        ((StringBuilder)localObject).append("runtime with built-in multidex capabilty but it's not the ");
        ((StringBuilder)localObject).append("case here: java.vm.version=\"");
        ((StringBuilder)localObject).append(System.getProperty("java.vm.version"));
        ((StringBuilder)localObject).append("\"");
        Log.w("MultiDex", ((StringBuilder)localObject).toString());
      }
      try
      {
        localObject = paramContext.getClassLoader();
        if (localObject == null)
        {
          Log.e("MultiDex", "Context class loader is null. Must be running in test mode. Skip patching.");
          return;
        }
        try
        {
          clearOldDexDir(paramContext);
        }
        catch (Throwable localThrowable)
        {
          Log.w("MultiDex", "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.", localThrowable);
        }
        paramFile2 = getDexDir(paramContext, paramFile2, paramString1);
        installSecondaryDexes((ClassLoader)localObject, paramFile2, MultiDexExtractor.load(paramContext, paramFile1, paramFile2, paramString2, false));
        return;
      }
      catch (RuntimeException paramContext)
      {
        Log.w("MultiDex", "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", paramContext);
        return;
      }
    }
  }
  
  private static void expandFieldArray(Object paramObject, String paramString, Object[] paramArrayOfObject)
    throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    paramString = findField(paramObject, paramString);
    Object[] arrayOfObject1 = (Object[])paramString.get(paramObject);
    Object[] arrayOfObject2 = (Object[])Array.newInstance(arrayOfObject1.getClass().getComponentType(), arrayOfObject1.length + paramArrayOfObject.length);
    System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, arrayOfObject1.length);
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject2, arrayOfObject1.length, paramArrayOfObject.length);
    paramString.set(paramObject, arrayOfObject2);
  }
  
  private static Field findField(Object paramObject, String paramString)
    throws NoSuchFieldException
  {
    for (Object localObject = paramObject.getClass(); localObject != null; localObject = ((Class)localObject).getSuperclass()) {
      try
      {
        Field localField = ((Class)localObject).getDeclaredField(paramString);
        if (!localField.isAccessible()) {
          localField.setAccessible(true);
        }
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;) {}
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Field ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" not found in ");
    ((StringBuilder)localObject).append(paramObject.getClass());
    throw new NoSuchFieldException(((StringBuilder)localObject).toString());
  }
  
  private static Method findMethod(Object paramObject, String paramString, Class<?>... paramVarArgs)
    throws NoSuchMethodException
  {
    for (Object localObject = paramObject.getClass(); localObject != null; localObject = ((Class)localObject).getSuperclass()) {
      try
      {
        Method localMethod = ((Class)localObject).getDeclaredMethod(paramString, paramVarArgs);
        if (!localMethod.isAccessible()) {
          localMethod.setAccessible(true);
        }
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;) {}
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Method ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" with parameters ");
    ((StringBuilder)localObject).append(Arrays.asList(paramVarArgs));
    ((StringBuilder)localObject).append(" not found in ");
    ((StringBuilder)localObject).append(paramObject.getClass());
    throw new NoSuchMethodException(((StringBuilder)localObject).toString());
  }
  
  private static ApplicationInfo getApplicationInfo(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getApplicationInfo();
      return paramContext;
    }
    catch (RuntimeException paramContext)
    {
      Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", paramContext);
    }
    return null;
  }
  
  private static File getDexDir(Context paramContext, File paramFile, String paramString)
    throws IOException
  {
    paramFile = new File(paramFile, "code_cache");
    try
    {
      mkdirChecked(paramFile);
      paramContext = paramFile;
    }
    catch (IOException paramFile)
    {
      for (;;) {}
    }
    paramContext = new File(paramContext.getFilesDir(), "code_cache");
    mkdirChecked(paramContext);
    paramContext = new File(paramContext, paramString);
    mkdirChecked(paramContext);
    return paramContext;
  }
  
  public static void install(Context paramContext)
  {
    Log.i("MultiDex", "Installing application");
    if (IS_VM_MULTIDEX_CAPABLE)
    {
      Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
      return;
    }
    if (Build.VERSION.SDK_INT >= 4) {
      try
      {
        localObject = getApplicationInfo(paramContext);
        if (localObject == null)
        {
          Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
          return;
        }
        doInstallation(paramContext, new File(((ApplicationInfo)localObject).sourceDir), new File(((ApplicationInfo)localObject).dataDir), "secondary-dexes", "");
        Log.i("MultiDex", "install done");
        return;
      }
      catch (Exception paramContext)
      {
        Log.e("MultiDex", "MultiDex installation failure", paramContext);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MultiDex installation failed (");
        ((StringBuilder)localObject).append(paramContext.getMessage());
        ((StringBuilder)localObject).append(").");
        throw new RuntimeException(((StringBuilder)localObject).toString());
      }
    }
    paramContext = new StringBuilder();
    paramContext.append("MultiDex installation failed. SDK ");
    paramContext.append(Build.VERSION.SDK_INT);
    paramContext.append(" is unsupported. Min SDK version is ");
    paramContext.append(4);
    paramContext.append(".");
    throw new RuntimeException(paramContext.toString());
  }
  
  public static void installInstrumentation(Context paramContext1, Context paramContext2)
  {
    Log.i("MultiDex", "Installing instrumentation");
    if (IS_VM_MULTIDEX_CAPABLE)
    {
      Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
      return;
    }
    if (Build.VERSION.SDK_INT >= 4) {
      try
      {
        Object localObject1 = getApplicationInfo(paramContext1);
        if (localObject1 == null)
        {
          Log.i("MultiDex", "No ApplicationInfo available for instrumentation, i.e. running on a test Context: MultiDex support library is disabled.");
          return;
        }
        ApplicationInfo localApplicationInfo = getApplicationInfo(paramContext2);
        if (localApplicationInfo == null)
        {
          Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
          return;
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramContext1.getPackageName());
        ((StringBuilder)localObject2).append(".");
        paramContext1 = ((StringBuilder)localObject2).toString();
        localObject2 = new File(localApplicationInfo.dataDir);
        localObject1 = new File(((ApplicationInfo)localObject1).sourceDir);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext1);
        localStringBuilder.append("secondary-dexes");
        doInstallation(paramContext2, (File)localObject1, (File)localObject2, localStringBuilder.toString(), paramContext1);
        doInstallation(paramContext2, new File(localApplicationInfo.sourceDir), (File)localObject2, "secondary-dexes", "");
        Log.i("MultiDex", "Installation done");
        return;
      }
      catch (Exception paramContext1)
      {
        Log.e("MultiDex", "MultiDex installation failure", paramContext1);
        paramContext2 = new StringBuilder();
        paramContext2.append("MultiDex installation failed (");
        paramContext2.append(paramContext1.getMessage());
        paramContext2.append(").");
        throw new RuntimeException(paramContext2.toString());
      }
    }
    paramContext1 = new StringBuilder();
    paramContext1.append("MultiDex installation failed. SDK ");
    paramContext1.append(Build.VERSION.SDK_INT);
    paramContext1.append(" is unsupported. Min SDK version is ");
    paramContext1.append(4);
    paramContext1.append(".");
    throw new RuntimeException(paramContext1.toString());
  }
  
  private static void installSecondaryDexes(ClassLoader paramClassLoader, File paramFile, List<? extends File> paramList)
    throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException
  {
    if (!paramList.isEmpty())
    {
      if (Build.VERSION.SDK_INT >= 19)
      {
        V19.install(paramClassLoader, paramList, paramFile);
        return;
      }
      if (Build.VERSION.SDK_INT >= 14)
      {
        V14.install(paramClassLoader, paramList, paramFile);
        return;
      }
      V4.install(paramClassLoader, paramList);
    }
  }
  
  static boolean isVMMultidexCapable(String paramString)
  {
    bool2 = false;
    bool1 = bool2;
    if (paramString != null)
    {
      localObject = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(paramString);
      bool1 = bool2;
      if (!((Matcher)localObject).matches()) {}
    }
    try
    {
      int i = Integer.parseInt(((Matcher)localObject).group(1));
      int j = Integer.parseInt(((Matcher)localObject).group(2));
      if (i <= 2)
      {
        bool1 = bool2;
        if (i == 2)
        {
          bool1 = bool2;
          if (j < 1) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("VM with version ");
    ((StringBuilder)localObject).append(paramString);
    if (bool1) {
      paramString = " has multidex support";
    } else {
      paramString = " does not have multidex support";
    }
    ((StringBuilder)localObject).append(paramString);
    Log.i("MultiDex", ((StringBuilder)localObject).toString());
    return bool1;
  }
  
  private static void mkdirChecked(File paramFile)
    throws IOException
  {
    paramFile.mkdir();
    if (!paramFile.isDirectory())
    {
      Object localObject = paramFile.getParentFile();
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Failed to create dir ");
        ((StringBuilder)localObject).append(paramFile.getPath());
        ((StringBuilder)localObject).append(". Parent file is null.");
        Log.e("MultiDex", ((StringBuilder)localObject).toString());
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to create dir ");
        localStringBuilder.append(paramFile.getPath());
        localStringBuilder.append(". parent file is a dir ");
        localStringBuilder.append(((File)localObject).isDirectory());
        localStringBuilder.append(", a file ");
        localStringBuilder.append(((File)localObject).isFile());
        localStringBuilder.append(", exists ");
        localStringBuilder.append(((File)localObject).exists());
        localStringBuilder.append(", readable ");
        localStringBuilder.append(((File)localObject).canRead());
        localStringBuilder.append(", writable ");
        localStringBuilder.append(((File)localObject).canWrite());
        Log.e("MultiDex", localStringBuilder.toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to create directory ");
      ((StringBuilder)localObject).append(paramFile.getPath());
      throw new IOException(((StringBuilder)localObject).toString());
    }
  }
  
  private static final class V14
  {
    private static void install(ClassLoader paramClassLoader, List<? extends File> paramList, File paramFile)
      throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException
    {
      paramClassLoader = MultiDex.findField(paramClassLoader, "pathList").get(paramClassLoader);
      MultiDex.expandFieldArray(paramClassLoader, "dexElements", makeDexElements(paramClassLoader, new ArrayList(paramList), paramFile));
    }
    
    private static Object[] makeDexElements(Object paramObject, ArrayList<File> paramArrayList, File paramFile)
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
    {
      return (Object[])MultiDex.findMethod(paramObject, "makeDexElements", new Class[] { ArrayList.class, File.class }).invoke(paramObject, new Object[] { paramArrayList, paramFile });
    }
  }
  
  private static final class V19
  {
    private static void install(ClassLoader paramClassLoader, List<? extends File> paramList, File paramFile)
      throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException
    {
      Object localObject = MultiDex.findField(paramClassLoader, "pathList").get(paramClassLoader);
      ArrayList localArrayList = new ArrayList();
      MultiDex.expandFieldArray(localObject, "dexElements", makeDexElements(localObject, new ArrayList(paramList), paramFile, localArrayList));
      if (localArrayList.size() > 0)
      {
        paramClassLoader = localArrayList.iterator();
        while (paramClassLoader.hasNext()) {
          Log.w("MultiDex", "Exception in makeDexElement", (IOException)paramClassLoader.next());
        }
        paramList = MultiDex.findField(localObject, "dexElementsSuppressedExceptions");
        paramFile = (IOException[])paramList.get(localObject);
        if (paramFile == null)
        {
          paramClassLoader = (IOException[])localArrayList.toArray(new IOException[localArrayList.size()]);
        }
        else
        {
          paramClassLoader = new IOException[localArrayList.size() + paramFile.length];
          localArrayList.toArray(paramClassLoader);
          System.arraycopy(paramFile, 0, paramClassLoader, localArrayList.size(), paramFile.length);
        }
        paramList.set(localObject, paramClassLoader);
      }
    }
    
    private static Object[] makeDexElements(Object paramObject, ArrayList<File> paramArrayList, File paramFile, ArrayList<IOException> paramArrayList1)
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
    {
      return (Object[])MultiDex.findMethod(paramObject, "makeDexElements", new Class[] { ArrayList.class, File.class, ArrayList.class }).invoke(paramObject, new Object[] { paramArrayList, paramFile, paramArrayList1 });
    }
  }
  
  private static final class V4
  {
    private static void install(ClassLoader paramClassLoader, List<? extends File> paramList)
      throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException
    {
      int i = paramList.size();
      Field localField = MultiDex.findField(paramClassLoader, "path");
      StringBuilder localStringBuilder = new StringBuilder((String)localField.get(paramClassLoader));
      String[] arrayOfString = new String[i];
      File[] arrayOfFile = new File[i];
      ZipFile[] arrayOfZipFile = new ZipFile[i];
      DexFile[] arrayOfDexFile = new DexFile[i];
      paramList = paramList.listIterator();
      while (paramList.hasNext())
      {
        Object localObject = (File)paramList.next();
        String str = ((File)localObject).getAbsolutePath();
        localStringBuilder.append(':');
        localStringBuilder.append(str);
        i = paramList.previousIndex();
        arrayOfString[i] = str;
        arrayOfFile[i] = localObject;
        arrayOfZipFile[i] = new ZipFile((File)localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(".dex");
        arrayOfDexFile[i] = DexFile.loadDex(str, ((StringBuilder)localObject).toString(), 0);
      }
      localField.set(paramClassLoader, localStringBuilder.toString());
      MultiDex.expandFieldArray(paramClassLoader, "mPaths", arrayOfString);
      MultiDex.expandFieldArray(paramClassLoader, "mFiles", arrayOfFile);
      MultiDex.expandFieldArray(paramClassLoader, "mZips", arrayOfZipFile);
      MultiDex.expandFieldArray(paramClassLoader, "mDexs", arrayOfDexFile);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\multidex\MultiDex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */