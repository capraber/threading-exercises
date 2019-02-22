package com.example.threadingexercises

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_child_thread_handler_looper.*

class ChildThreadHandlerLooperActivity : AppCompatActivity() {

    companion object {
        const val MAIN_THREAD_TASK_1 = 1
        const val MAIN_THREAD_TASK_2 = 2
        const val CHILD_THREAD_QUIT_LOOPER = 3
    }

    private lateinit var mainThreadHandler: Handler
    private lateinit var workerThread: MyWorkerThread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child_thread_handler_looper)

        // Create and start the worker thread.
        workerThread = MyWorkerThread()
        workerThread.start()

        // Handle message from main thread message queue.
        mainThreadHandler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                Log.i("MAIN_THREAD", "Receive message from child thread.")
                // If task one button is clicked.  -> getString(R.string.task_one_execute)
                //If task two button is clicked. -> getString(R.string.task_two_execute)
                // If quit child thread looper button is clicked. -> getString(R.string.quit_text)
            }
        }

        // Set on click listener to each button.
        runTaskOneButton.setOnClickListener {
            // When click this button, create a message object.
            // MAIN_THREAD_TASK_1
            // Use worker thread message Handler to put message into worker thread message queue.
        }

        // Please see comments for runTaskOneButton.
        runTaskTwoButton.setOnClickListener {
            // When click this button, create a message object.
            // MAIN_THREAD_TASK_2
            // Use worker thread message Handler to put message into worker thread message queue.
        }

        quitChildThreaLooperButton.setOnClickListener {
            // Click this button will quit child thread looper.
        }
    }

    // This child thread class has it's own Looper and Handler object.
    private inner class MyWorkerThread : Thread() {
        // This is worker thread handler.
        lateinit var workerThreadHandler: Handler

        override fun run() {
            // Prepare child thread Lopper object.
            Looper.prepare()

            // Create child thread Handler.
            // When child thread handler get message from child thread message queue.
            Log.i("CHILD_THREAD", "Receive message from main thread.")
            // Send the message back to main thread message queue use main thread message Handler.

            // Loop the child thread message queue.
            Looper.loop()

            // The code after Looper.loop() will not be executed until you call workerThreadHandler.getLooper().quit()
            Log.i(
                "CHILD_THREAD",
                "This log is printed after Looper.loop() method. Only when this thread loop quit can this log be printed."
            )
            // Send a message to main thread.
            // CHILD_THREAD_QUIT_LOOPER
        }
    }
}