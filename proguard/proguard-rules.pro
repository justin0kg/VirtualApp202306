
-dontshrink
-dontwarn

-keepattributes *Annotation*,InnerClasses,Exceptions
-keepattributes Signature,EnclosingMethod
#-keepattributes SourceFile,LineNumberTable

-keepclassmembers class * implements java.io.Serializable {*;}

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.ContentProvider

# Parcelable
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keepclassmembers class * extends android.os.Binder{
    public <methods>;
}

-keepclasseswithmembernames class * {
    native <methods>;
}
# android
-keep class android.**{
    *;
}

# Thirdparty Library
-keep class c.t.m.g.**{*;}
-keep class com.tencent.**{*;}
-keep class jonathanfinerty.once.**{public *;}

# virtual app
-keep @interface com.lody.virtual.client.hook.annotations.** {*;}

-keep @interface mirror.** {*;}
-keepclassmembers class mirror.**{
   public *;
}

-keep class com.lody.virtual.client.NativeEngine{
    public <methods>;
}

-keep @interface com.lody.virtual.helper.Keep {*;}
-keep @com.lody.virtual.helper.Keep class ** {
    public <methods>;
}

-keepclasseswithmembernames class com.lody.virtual.client.hook.instruments.InstrumentationProxy {*;}

-keep class com.lody.virtual.client.hiddenapibypass.** { *;}
-keep class sun.misc.** { *;}
-keep class com.android.**{*;}





########## 下面两个配置节点 二选一 启用 ##########

# 使用 mapping 文件混淆部分特征
#################### start enable mapping
-keep class com.swift.sandhook.a*.**{*;}
-keep class com.swift.sandhook.b*.**{*;}
-keep class com.swift.sandhook.u*.**{*;}
-keep class com.swift.sandhook.w*.**{*;}
-keep class com.swift.sandhook.*{*;}
-keepclassmembernames class com.swift.sandhook.xposedcompat.**{*;}
-applymapping mapping.txt
#################### end enable mapping

#################### start disable mapping
#-keep class de.robv.android.xposed.*
#-keepclassmembers class de.robv.android.xposed.* {
#   *;
#}
#-keep class com.swift.sandhook.**{*;}
#################### end disable mapping