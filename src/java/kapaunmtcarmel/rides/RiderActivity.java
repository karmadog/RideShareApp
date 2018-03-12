package kapaunmtcarmel.rides;


import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


public class RiderActivity extends AppCompatActivity {
    int day, month;
    String riderName;
    public static FirebaseDatabase mFirebaseDatabase;
    String riderPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        riderName = user.getDisplayName();
        if(user.getPhotoUrl() != null)
            riderPhoto = user.getPhotoUrl().toString();
        else
            riderPhoto = null;
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new RiderDatePickerFragment();
        newFragment.show(getFragmentManager(), "Choose a date");
    }

    public void storeRideRequest(View v){
        EditText editText = findViewById(R.id.riderAddress);
        String address = editText.getText().toString();
        RideRequest ride = new RideRequest(riderName, day, month, address, riderPhoto);

        mFirebaseDatabase.getReference("rideRequests").push().setValue(ride);
        finish();
    }

    public void setDay(int requestDay){
        day = requestDay;
    }

    public void setMonth(int requestMonth){
        month = requestMonth;
    }

}

