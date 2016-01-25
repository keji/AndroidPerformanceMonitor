/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.moduth.blockcanary.log;

import android.app.ActivityManager;
import android.content.Context;

import com.github.moduth.blockcanary.BlockCanaryCore;

import java.util.List;

public class ProcessUtils {

    private static volatile String sProcessName;
    private final static Object sNameLock = new Object();

    public static String myProcessName() {
        if (sProcessName != null) {
            return sProcessName;
        }
        synchronized (sNameLock) {
            if (sProcessName != null) {
                return sProcessName;
            }
            return sProcessName = obtainProcessName(BlockCanaryCore.getContext().getContext());
        }
    }

    private static String obtainProcessName(Context context) {
        final int pid = android.os.Process.myPid();
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> listTaskInfo = am.getRunningAppProcesses();
        if (listTaskInfo != null && listTaskInfo.size() > 0) {
            for (ActivityManager.RunningAppProcessInfo info : listTaskInfo) {
                if (info != null && info.pid == pid) {
                    return info.processName;
                }
            }
        }
        return null;
    }
}