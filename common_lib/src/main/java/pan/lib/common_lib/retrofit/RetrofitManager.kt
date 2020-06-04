package pan.lib.common_lib.retrofit

import android.util.Log
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.logging.HttpLoggingInterceptor
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
        val loggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.e("pansome", message)
            }
        })
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(10, TimeUnit.SECONDS);
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor)
        return builder.build()
    }

    fun getApiService(): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}