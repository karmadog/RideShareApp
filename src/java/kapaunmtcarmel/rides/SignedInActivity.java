package kapaunmtcarmel.rides;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class SignedInActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signed_in);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.driveButton:
                if (checked) {
                    Intent driverActivity = new Intent(getApplicationContext(), DriverActivity.class);
                    startActivity(driverActivity);
                }
                break;
            case R.id.rideButton:
                if (checked){
                    Intent riderActivity = new Intent(getApplicationContext(), RiderActivity.class);
                    startActivity(riderActivity);
                }
                break;
        }
    }
}
