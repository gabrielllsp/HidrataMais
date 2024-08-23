package com.joselaine.hidratamais

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class NotificationWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    override fun doWork(): Result {
        for(i in 0 until  1000){
            println("Executando a tarefa $i")
        }
        return Result.success()
    }
}