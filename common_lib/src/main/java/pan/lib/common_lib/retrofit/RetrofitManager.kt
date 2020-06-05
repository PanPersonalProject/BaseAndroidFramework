package pan.lib.common_lib.retrofit

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.logging.HttpLoggingInterceptor
import pan.lib.common_lib.BuildConfig
import pan.lib.common_lib.utils.printNetLog
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/4 14:26
 */
object RetrofitManager {
    private var retrofit = initRetrofit()

    /**
     * 用于生成post json的RequestBody
     * */
    fun getRequestBody(json: String): RequestBody {
        return json.toRequestBody("application/json; charset=utf-8".toMediaType())
    }


    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(initOkHttpClient())
            .baseUrl("https://www.baidu.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun initOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(10, TimeUnit.SECONDS);
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(getLoggingInterceptor())
        }
        return builder.build()
    }

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            private val mMessage = StringBuilder()
            override fun log(message: String) {
                mMessage.append(message).append("\n")
                // 响应结束，打印整条日志
                if (message.startsWith("<-- END HTTP")) {
                    printNetLog(mMessage.toString())
                    mMessage.clear()
                }
            }

        })
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return loggingInterceptor
    }

    fun getApiService(): ApiService {
        return retrofit.create(ApiService::class.java)
    }


}