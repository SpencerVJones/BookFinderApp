package com.example.jonesspencer_ce09

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.apache.commons.io.IOUtils
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

object NetworkHelper {

    @JvmStatic
    suspend fun getBooksFromApi(): List<Book> {
        return withContext(Dispatchers.IO) {
            val books = mutableListOf<Book>()
            val url = URL("https://www.googleapis.com/books/v1/volumes?q=android")
            val urlConnection = url.openConnection() as HttpURLConnection

            try {
                val inputStream: InputStream = BufferedInputStream(urlConnection.inputStream)
                val result = IOUtils.toString(inputStream, "UTF-8")
                val jsonObject = JSONObject(result)
                val items: JSONArray = jsonObject.getJSONArray("items")

                for (i in 0 until items.length()) {
                    val item = items.getJSONObject(i)
                    val volumeInfo = item.getJSONObject("volumeInfo")
                    val title = volumeInfo.getString("title")
                    val imageUrl = volumeInfo.getJSONObject("imageLinks").getString("thumbnail")
                    books.add(Book(title, imageUrl))
                }
            } finally {
                urlConnection.disconnect()
            }

            books
        }
    }
}
