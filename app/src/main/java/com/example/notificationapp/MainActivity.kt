package com.example.notificationapp

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_next.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        btn_notification.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

            val inboxStyle = NotificationCompat.InboxStyle()
            inboxStyle.setBigContentTitle("Conveyance Journey")
            inboxStyle.addLine("Journey is Started")

            val notificationBuilder = NotificationCompat.Builder(this)
                .setContentTitle("Inbox Style notification")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentText("This is test")
                .setStyle(inboxStyle)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .addAction(R.mipmap.ic_launcher_round, "Stop", pendingIntent)
                .build()


            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(0, notificationBuilder)

        }
    }
}
