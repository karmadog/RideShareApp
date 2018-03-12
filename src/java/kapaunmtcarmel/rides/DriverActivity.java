package kapaunmtcarmel.rides;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import kapaunmtcarmel.rides.dummy.DummyContent;

public class DriverActivity extends AppCompatActivity implements RideRequestFragment.OnListFragmentInteractionListener {

    int day, month;
    String driverName;
    String riderPhoto, driverPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        driverName = user.getDisplayName();
        //get driver photo
        if(user.getPhotoUrl() != null)
            driverPhoto = user.getPhotoUrl().toString();
        else
            riderPhoto = null;
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DriverDatePickerFragment();
        newFragment.show(getFragmentManager(), "Choose a date");
    }

    public void showRiderListDialog(View v) {
        DialogFragment newFragment = new RideRequestFragment();
        newFragment.show(getFragmentManager(), "Ride List");
    }

    public void setDay(int requestDay){
        day = requestDay;
    }

    public void setMonth(int requestMonth){
        month = requestMonth;
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }


}
