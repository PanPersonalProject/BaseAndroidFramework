<h1 align="center">BaseAndroidFramework</h1>
<p align="center">  
一款基于google官方推荐架构体系封装和Jetpack的MVVM框架。致力于写出最精简,易读性又高的代码，又保证项目的健壮性。
项目正在搭建中，如果喜欢的话不妨点个star~
</p>

## 主要技术栈
- Kotlin+ Coroutines+KTX  
- JetPack
  - [Dagger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android)-用于依赖注入(ViewModel,Responese,ApiService)
  - LiveData 
  - Lifecycle 
  - ViewModel 

- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) -retrofit2.9.0搭配协程
- [Arouter](https://github.com/alibaba/ARouter) -跨模块通信框架
- [Glide](https://github.com/bumptech/glide), [Glide Transformations](https://github.com/wasabeef/glide-transformations)
- [Logger](https://github.com/orhanobut/logger) - Simple, pretty and powerful logger for android
- [BaseRecyclerViewAdapterHelper](https://github.com/CymChad/BaseRecyclerViewAdapterHelper) - 强大而灵活的RecyclerView Adapter
- Gson，[Kotson](https://github.com/SalomonBrys/Kotson)-  更简易的Gson使用 val userInfo: User="user json".toObject()

## 网络请求Example


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

@ViewModelInject constructor(private val articleRepository: ArticleRepository)依赖注入声明，会自动生成TopArticleViewModel_AssistedFactory，注入ArticleRepository
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
@InstallIn(ApplicationComponent::class)
@Module
object WanNetModule {
    @Provides
    @Singleton
    fun provideService(): WanApiService = RetrofitManager.getApiService(
        WanApiService::class.java)  //提供WanApiService单例，只需要写一次

}
```

## 架构图
<p align="center">
<img src="/art/architecture.png"/>
</p>


