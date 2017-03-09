# RxBus的使用
库中已经引用rx的两个库有
```Java
compile 'io.reactivex:rxandroid:1.1.0'
compile 'io.reactivex:rxjava:1.1.0'
```

## RxBus库的导入
```Java
compile 'com.ternence.tevent:t-event:0.0.3'
```

## RxBus的使用
1.发送Rx消息
```Java
 RxBus.get().post("1234",view.toString());
```
post方法有两个参数，第一个是tag，第二个是需要发送的参数</br>
第二个参数不能为空，并且一定是Object类型。</br>

2.消息订阅
```Java
@Keep
@Subscribe(tags = {@Tag("test"),@Tag("1234")},thread = EventThread.MAIN_THREAD)
public void onTextChange(String a)
{
    Log.e("MainActivity","Thread:" + Thread.currentThread().getName());
}
```
* 首先如果项目有混淆要加上@Keep标识，以免被混淆
* 还有一个必要的订阅参数是@Subscribe，这部分有两部分参数组成，tags和thread。tag是一个标识数组，就是上面post的第一个参数。然后是thread是线程的指定，可以不写，默认在主线程。
