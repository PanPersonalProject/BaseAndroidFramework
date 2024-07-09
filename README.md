<h1 align="center">BaseAndroidFramework</h1>
<p align="center">  
一款基于google官方推荐架构体系封装和Jetpack的MVVM框架。致力于写出最精简,易读性又高的代码，又保证项目的健壮性。
项目正在搭建中，如果喜欢的话不妨点个star~
</p>

## 主要技术栈
- Kotlin+ Coroutines+KTX  
- JetPack
  - [Dagger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android)-用于依赖注入(ViewModel,Repository,ApiService)
  - LiveData 
  - Lifecycle 
  - ViewModel 

- [TheRouter](https://github.com/HuolalaTech/hll-wp-therouter-android) -跨模块通信框架
- [Retrofit2 & OkHttp4](https://github.com/square/retrofit) -Retrofit2.11.0搭配协程
- [Scarlet & Rxjava](https://github.com/Tinder/Scarlet) -Retrofit风格的WebSocket client
- [Logger](https://github.com/orhanobut/logger) - Simple, pretty and powerful logger for android

- [Kotson](https://github.com/SalomonBrys/Kotson)-  更简易的Gson使用 val userInfo: User="user json".toObject()


<br>

## HTTP请求Example

```kotlin
@AndroidEntryPoint //注解的入口
class TopArticleActivity : BaseActivity() {
    private val topArticleViewModel: TopArticleViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_article)

        initView()

        topArticleViewModel.fetchTopArticle() 


    }

}
```

#### @ViewModelInject依赖注入声明，会自动生成TopArticleViewModel_AssistedFactory，注入ArticleRepository
```kotlin
class TopArticleViewModel @ViewModelInject constructor(private val articleRepository: ArticleRepository) :
    ViewModel() {


    val articleList = MutableLiveData<MutableList<TopArticle>>()

    fun fetchTopArticle() {
        launchOnUI {
            val response = articleRepository.fetchTopArticle()

            response.whenSuccess {
                articleList.value = it.toMutableList()
            }
            
        }
    }

}
```

```kotlin
@Singleton
class ArticleRepository @Inject constructor(private val wanApiService: WanApiService) :
    BaseRepository() {
    suspend fun fetchTopArticle(): NetResult<List<TopArticle>> {
        return fetchApi { wanApiService.topArticle() }
    }

}
```

```kotlin
@InstallIn(SingletonComponent::class)
@Module
object WanNetModule {
    @Provides
    @Singleton
    fun provideService(): WanApiService = RetrofitManager.getApiService(
        WanApiService::class.java)  //提供WanApiService单例，只需要写一次

}
```

<br>

## WebSocket请求Example

#### 声明接口
```kotlin
interface DemoWebsocketService {
    @Send
    fun send(protocol: Protocol)

    @Receive
    fun observeCustomInfo(): Flowable<Result>

    @Receive
    fun observeWebSocketEvent(): Flowable<WebSocket.Event>

    @Send
    fun send(msg: String)
}
```

#### 初始化WSManager
```kotlin
val wsManager: WSManager<DemoWebsocketService> = WSManager()
```

#### 发送消息
```kotlin
wsManager.service.send(message)
```

#### 接收消息
```kotlin
wsManager.service.observeCustomInfo().subscribe {
    receivedMessages.postValue(it.message)
}
```
## 架构图
![](architecture.png)