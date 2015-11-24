package edu.tjhsst.eluk.mysimpleweatherapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
//import android.R;

import java.io.IOException;
import java.text.DecimalFormat;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
    }

    private void RetrieveWeather() throws IOException{
        String url = "http://api.openweathermap.org/data/2.5/weather?q=austin,tx";
        WeatherServiceAsync task = new WeatherServiceAsync(this);
        task.execute(url);
    }

    public void SetDescription(String descpition)
    {
        TextView view = (TextView) this.findViewById(R.id.description);
        view.setText("Description: " + descpition);
    }

    public void SetTemperature(double temperature) {
        TextView view = (TextView) this.findViewById(R.id.temperature);
        DecimalFormat df = new DecimalFormat("###");
        String formattedTemp = df.format(temperature);
        view.setText("Temperature: " + formattedTemp + "°F");
    }

    public void SetPressure(double pressure)
    {
        TextView view = (TextView)this.findViewById(R.id.pressure);
        DecimalFormat df = new DecimalFormat("###.##");
        String formattedTemp = df.format(pressure);
        view.setText("Pressure: " + formattedTemp + "mb");
    }

    public void SetHumidity(double humidity)
    {
        TextView view = (TextView) this.findViewById(R.id.temperature);
        DecimalFormat df = new DecimalFormat("###");
        String formattedTemp = df.format(humidity);
        view.setText("Humidity: " + formattedTemp + "%");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
