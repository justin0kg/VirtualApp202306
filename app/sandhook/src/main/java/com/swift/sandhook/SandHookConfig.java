package com.swift.sandhook;

import android.os.Build;

public class SandHookConfig {

    public volatile static int SDK_INT = Build.VERSION.SDK_INT;
    //Debug status of hook target process
    public volatile static boolean DEBUG = true;
    //Enable compile with jit
    public volatile static boolean compiler = SDK_INT < 29;
    public volatile static ClassLoader initClassLoader;
    public volatile static int curUser = 0;
    public volatile static boolean delayHook = true;
}
