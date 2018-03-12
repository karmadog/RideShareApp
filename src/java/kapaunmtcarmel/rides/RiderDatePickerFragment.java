package kapaunmtcarmel.rides;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import java.util.Calendar;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

/**
 * Created by karma on 2/23/2018.
 */

public class RiderDatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        int mMonth;
        mMonth = month + 1;
        TextView tv1= (TextView) getActivity().findViewById(R.id.selectedDate);
        tv1.setText("Date selected was " + mMonth + "/" + day );
        ((RiderActivity) getActivity()).setDay(day);
        ((RiderActivity) getActivity()).setMonth(mMonth);
    }
}
