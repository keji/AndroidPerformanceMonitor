### 修改成和leakcanary相同的集成方式不需要添加代码
### 兼容最新版Android N,O
### 移除cpu频率的监控
``` 
//Add it in your root build.gradle at the end of repositories:
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
//Add the dependency
dependencies {
  debugImplementation 'com.github.keji.AndroidPerformanceMonitor:blockcanary-android:1.1.4'
}
```
