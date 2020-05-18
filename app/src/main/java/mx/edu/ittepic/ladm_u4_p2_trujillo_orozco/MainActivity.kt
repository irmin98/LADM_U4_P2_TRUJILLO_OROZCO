package mx.edu.ittepic.ladm_u4_p2_trujillo_orozco

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SensorEventListener {
    lateinit var sensorManager : SensorManager
    lateinit var sensorManagerP : SensorManager
    var miLienzo : Dibujo ?=null
    var x=600f
    var y =1000f
    var valor =0f
    var cambiarColor =false





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        miLienzo =Dibujo(this)
        setContentView(miLienzo)



        sensorManager =getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_FASTEST)

        sensorManagerP =getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManagerP.registerListener(this,sensorManagerP.getDefaultSensor(Sensor.TYPE_PROXIMITY),SensorManager.SENSOR_DELAY_NORMAL)

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onSensorChanged(e: SensorEvent) {
        valor=e.values[0]




        if(e.values[0]>0f && e.values[0] != 5f ) {
           // Toast.makeText(this, "EQUIS ES MAYOR", Toast.LENGTH_SHORT).show()
            x -= 5

        }
        else if(e.values[0]<0f){
            //Toast.makeText(this,"EQUIS ES MENOR",Toast.LENGTH_SHORT).show()
            x+=5


        }


        if(e.values[0]==0f){
            cambiarColor =true
        }

        if(e.values[0]==5f){
            cambiarColor =false
        }


    }




}


class Dibujo(p:MainActivity) : View(p) {
    var puntero =p



    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        puntero.setTitle(puntero.valor.toString())
        //aqui en este metodo se realiza el dibujo
        var p =Paint()

        p.color =Color.RED
        c.drawCircle(puntero.x,puntero.y,40f,p)
        //puntero.setTitle(puntero.PosX.toString()) //me da la resolucion de la pantalla (canzas)

        if(puntero.cambiarColor){
            p.color =Color.BLACK
            c.drawCircle(puntero.x,puntero.y,40f,p)
        }

        invalidate()
    }

}



