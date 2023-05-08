package com.example.pacman;
import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.util.Log;


public class giroscopio implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor gyroscopeSensor;

    public giroscopio(Context context) {
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
    }

    public void start() {
        sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void stop() {
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];
        Log.d("Giroscopio", "x: " + x + " y: " + y + " z: " + z);


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
