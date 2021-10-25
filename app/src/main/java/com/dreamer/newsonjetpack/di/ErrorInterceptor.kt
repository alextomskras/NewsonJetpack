package com.dreamer.newsonjetpack.di


import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ErrorInterceptor : Interceptor {
    //    val context = Context.STORAGE_SERVICE
    override fun intercept(chain: Interceptor.Chain): Response {

        val request: Request = chain.request()
        val response = chain.proceed(request)
        when (response.code) {
            200 -> {
                //Show Bad Request Error Message
//                Toast.makeText(context, "BADBBBBBBBBBBBBBB", Toast.LENGTH_SHORT).show()
//                Toast.makeText(MyActivity.this, "Pressed.", Toast.LENGTH_SHORT).show();
            }
            401 -> {
                //Show UnauthorizedError Message
            }

            403 -> {
                //Show Forbidden Message
            }

            404 -> {
                //Show NotFound Message
            }

            // ... and so on

        }
        return response
    }
}