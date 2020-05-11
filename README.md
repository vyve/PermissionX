# PermissionX

PermissionX是一个用于简化Android运行时权限用法的开源库。

添加如下配置将PermissionX引入到你的项目中：

``` groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}

dependencies {
	 implementation 'com.github.vyve:PermissionX:1.0.1'
}
```

```
kotlin
PermissionX.request(
                 this, Manifest.permission.CALL_PHONE, Manifest.permission.READ_EXTERNAL_STORAGE,
                 Manifest.permission.WRITE_EXTERNAL_STORAGE,callback = (object :IPermissionXCallBack{
                     override fun callBack(granted: Boolean, deniedList: List<String>) {
                         if (granted) {
                             callPhone()
                         } else {
                             Toast.makeText(this@MainActivity, "You denied $deniedList", Toast.LENGTH_SHORT).show()
                         }
                     }
                 }))
```

```
java
PermissionX.INSTANCE.request(MainJavaActivity.this, new String[]{Manifest.permission.CALL_PHONE}, new IPermissionXCallBack() {
                    @Override
                    public void callBack(boolean granted, @NotNull List<String> deniedList) {
                        if (granted) {
                            callPhone()
                        } else {
                            Toast.makeText(getApplicationContext(), "You denied", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
```

如果遇到
```
java.lang.NoClassDefFoundError: Failed resolution of: Lkotlin/jvm/internal/Intrinsics;
```
在app build.gradle 添加如下依赖
```
implementation 'com.mapzen:on-the-road:1.3.1'
```