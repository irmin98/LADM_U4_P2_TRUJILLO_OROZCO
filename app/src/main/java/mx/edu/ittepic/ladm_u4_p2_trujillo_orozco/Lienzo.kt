package mx.edu.ittepic.ladm_u4_p2_trujillo_orozco

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.view.MotionEvent
import android.view.View

class Lienzo(p:MainActivity) : View(p),SensorEventListener {

    var puntero =p
   // var posX =100f


    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onSensorChanged(e: SensorEvent?) {



    }
}