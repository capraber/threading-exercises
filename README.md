# threading-exercises
Threading exercises in Kotlin for for Developers Coaching plan

## Loopers and Handler exercise
### [Looper](https://developer.android.com/reference/android/os/Looper)
### [Handler](https://developer.android.com/reference/android/os/Handler)
- Exercise description:
Try to reproduce the following steps and image behaviour
![alt tag](https://github.com/capraber/threading-exercises/blob/master/android-thread-message-looper-handler-exanple.gif)
From above picture, you can see below steps.
1. When the first two button are clicked, main thread will send a message object to worker thread message queue.
2. Worker thread read the message object out from the queue and send a message to main thread also.
3. Main thread will display different text according to worker thread sent message.
4. After the “quit child thread looper” button is clicked, worker thread message looper stopped. And worker thread can not handle any messages. So the text view content will not change also.
