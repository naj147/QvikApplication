package com.arch.qvikapplication.database

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.arch.qvikapplication.datamodel.Articles
import com.arch.qvikapplication.datamodel.Channel
import com.arch.qvikapplication.utils.Constants
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import org.json.JSONObject

class DatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {
    private val TAG = "DatabaseWorker"
    override suspend fun doWork(): Result = coroutineScope {
        withContext(Dispatchers.IO) {
            try {
                applicationContext.assets.open(Constants.CHANNELS_JSON_FILE).bufferedReader()
                    .use { reader ->
                        val jsonObject = JSONObject(reader.readText())
                        val jsonArrayString = jsonObject.getJSONArray("channels").toString()
                        val list = GsonBuilder().create()
                            .fromJson(jsonArrayString, Array<Channel>::class.java).toList()
                        AppDatabase.getInstance(applicationContext).channelDao().insertAll(list)
                    }
            } catch (e: Exception) {
                Log.e(TAG, "Error creating database $e")
                Result.failure()
            }
        }

        withContext(Dispatchers.IO) {
            try {
                applicationContext.assets.open(Constants.ARTICLE_JSON_FILE).bufferedReader()
                    .use { reader ->
                        val jsonObject = JSONObject(reader.readText())
                        val jsonArrayString = jsonObject.getJSONArray("articles").toString()
                        val list = GsonBuilder().create()
                            .fromJson(jsonArrayString, Array<Articles>::class.java).toList()
                        AppDatabase.getInstance(applicationContext).articleDao().insertAll(list)
                        Result.success()
                    }
            } catch (e: Exception) {
                Log.e(TAG, "Error creating database $e")
                Result.failure()
            }
        }
    }

}