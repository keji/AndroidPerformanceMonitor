package com.github.moduth.blockcanary.util;

import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import timber.log.Timber;

/**
 * @author beiliming
 * time : 19-10-13 上午11:05
 * remark :切换到release时日志输出
 * 可以将特定等级日志写入文件
 * 或在release下打开日志开关
 */
public class ReleaseTree extends Timber.Tree {
    @Override
    protected void log(int priority, @Nullable String tag, @NotNull String message, @Nullable Throwable t) {
        if (Log.isLoggable("riqwhrbfgf&das", Log.WARN)) {
            //日志上报或写入文件操作
        }
    }
}
