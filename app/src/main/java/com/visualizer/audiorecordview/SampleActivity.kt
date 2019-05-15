package com.visualizer.audiorecordview

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Toast
import com.visualizer.audio_record_view.AudioRecordView

import java.util.Timer
import java.util.TimerTask
import kotlin.collections.ArrayList

class SampleActivity : AppCompatActivity() {

    private lateinit var play: View
    private lateinit var stop: View
    private lateinit var record: View
    private lateinit var myAudioRecorder: MediaRecorder
    private lateinit var audioVisualizerView: AudioRecordView

    private var outputFile: String? = null
    private var timer: Timer? = null
    private var timerTask: TimerTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        findViews()

        setRecordOnClickListener()
        setStopOnClickListener()
        setPlayOnClickListener()
    }

    private fun findViews() {
        audioVisualizerView = findViewById(R.id.visualizer_view)
        audioVisualizerView.chunkMaxHeight
        play = findViewById(R.id.play)
        stop = findViewById(R.id.stop)
        record = findViewById(R.id.record)
    }

    private fun startTimer() {
        timerTask = object : TimerTask() {
            override fun run() {
                audioVisualizerView.update(myAudioRecorder.maxAmplitude)
            }
        }
        timer = Timer()
        timer!!.schedule(timerTask, 0, 50)
    }

    private fun stopTimer() {
        if (timer != null) {
            timer!!.cancel()
            timer = null
        }
        if (timerTask != null) {
            timerTask!!.cancel()
            timerTask = null
        }
    }

    private fun setPlayOnClickListener() {
        play.setOnClickListener {
            val mediaPlayer = MediaPlayer()
            try {
                mediaPlayer.setDataSource(outputFile)
                mediaPlayer.prepare()
                mediaPlayer.start()

                enableView(record)
                enableView(play)

                Toast.makeText(applicationContext, "Playing Audio", Toast.LENGTH_LONG).show()
            } catch (ignored: Exception) {

            }
        }
    }

    private fun setStopOnClickListener() {
        stop.setOnClickListener {
            stopTimer()
            audioVisualizerView.recreate()
            myAudioRecorder.stop()
            myAudioRecorder.release()

            enableView(record)
            enableView(play)
            desableView(stop)

            Toast.makeText(applicationContext, "Audio Recorder successfully", Toast.LENGTH_LONG).show()
        }
    }

    private fun setRecordOnClickListener() {
        record.setOnClickListener {
            if (!requestPermissions()) {
                handleRecordClick()
            }
        }
    }

    private fun handleRecordClick() {
        try {
            outputFile = Environment.getExternalStorageDirectory().absolutePath + "/" + System.currentTimeMillis() + ".3gp"
            myAudioRecorder = MediaRecorder()
            myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC)
            myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB)
            myAudioRecorder.setOutputFile(outputFile)
            myAudioRecorder.prepare()
            myAudioRecorder.start()
            startTimer()
        } catch (ignored: Exception) {

        }

        enableView(stop)
        desableView(record)
        desableView(play)

        Toast.makeText(applicationContext, "Recording started", Toast.LENGTH_LONG).show()
    }

    private fun enableView(v: View) {
        v.isEnabled = true
        v.alpha = 1f
    }

    private fun desableView(v: View) {
        v.isEnabled = false
        v.alpha = 0.5f
    }

    private fun requestPermissions(): Boolean {
        val needPermArr: MutableList<String?> = ArrayList()
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            needPermArr.add(Manifest.permission.RECORD_AUDIO)
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            needPermArr.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        return if (needPermArr.isEmpty()) {
            false
        } else {
            ActivityCompat.requestPermissions(this, needPermArr.toTypedArray(), 100)
            true
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            handleRecordClick()
        }
    }
}