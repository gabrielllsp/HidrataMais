package com.joselaine.hidratamais

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlin.random.Random

class NotificationWorker(private val appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {
    override fun doWork(): Result {
        val notificationManager = appContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "your_channel_id"
        val channelName = "Seu Canal de Notificações"

        // Cria o canal de notificação (necessário para Android 8.0 e superior)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val builder = NotificationCompat.Builder(appContext, channelId)
            .setSmallIcon(R.drawable.baseline_water_drop_24) // Substitua pelo seu ícone
            .setContentTitle(appContext.getString(R.string.notification_title))
            .setContentText(appContext.getString(R.string.notification_subtitle))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val notification = builder.build()
        val idNotification = Random.nextInt()
        notificationManager.notify(idNotification, notification)

        return Result.success()
    }
}