// Spencer Jones
// MDV3832-0 - 062024
// BookFetcher.java

package com.example.jonesspencer_ce09

import kotlinx.coroutines.*
import android.view.View
import com.example.jonesspencer_ce09.NetworkHelper

class BookFetcher(private val activity: MainActivity) {
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + job)

    fun fetchBooks() {
        scope.launch {
            activity.runOnUiThread {
                activity.progressBar.visibility = View.VISIBLE
            }
            try {
                val books = NetworkHelper.getBooksFromApi()
                activity.runOnUiThread {
                    activity.gridView.adapter = BookAdapter(activity, books)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                activity.runOnUiThread {
                    activity.progressBar.visibility = View.GONE
                }
            }
        }
    }

    fun cancel() {
        job.cancel()
    }
}
