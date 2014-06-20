package com.example.accelerometerdata;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * ���ٶȴ���������
 * 
 * @author Gavin
 * 
 */
public class AccelerometerActivity extends Activity {
	private TextView textViewX = null;
	private TextView textViewY = null;
	private TextView textViewZ = null;
	private SensorManager sensorManager = null;
	private Sensor sensor = null;
	private float gravity[] = new float[3];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.accelerometer_activity);
		textViewX = (TextView) findViewById(R.id.accelerometerTextViewX);
		textViewY = (TextView) findViewById(R.id.accelerometerTextViewY);
		textViewZ = (TextView) findViewById(R.id.accelerometerTextViewZ);
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	}
//����github3
	@Override
	protected void onResume() {
		super.onResume();
		sensorManager.registerListener(listener, sensor,
				SensorManager.SENSOR_DELAY_NORMAL);
	}
//����github2
	@Override
	protected void onStop() {
		super.onStop();
		sensorManager.unregisterListener(listener);
	}
//����github
	private SensorEventListener listener = new SensorEventListener() {

		public void onSensorChanged(SensorEvent e) {
			gravity[0] = e.values[0];
			gravity[1] = e.values[1];
			gravity[2] = e.values[2];
			textViewX.setText("X�����ϼ��ٶȣ�\n          " + gravity[0] + "m/s^2");
			textViewY.setText("Y�����ϼ��ٶȣ�\n          " + gravity[1] + "m/s^2");
			textViewZ.setText("Z�����ϼ��ٶȣ�\n          " + gravity[2] + "m/s^2");
		}

		public void onAccuracyChanged(Sensor arg0, int arg1) {

		}
	};
}
