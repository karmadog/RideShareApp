package kapaunmtcarmel.rides;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.support.design.widget.Snackbar;

import java.util.Arrays;



public class LoginActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 712;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FirebaseAuth auth = FirebaseAuth.getInstance();
                if (auth.getCurrentUser() != null) {
                    Intent alreadySigned = new Intent(getApplicationContext(), SignedInActivity.class);
                    startActivity(alreadySigned);
                } else {
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setAvailableProviders(Arrays.asList(new AuthUI.IdpConfig.GoogleBuilder().build()))
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    String email = user.getEmail();
                    if (email.matches(".+@kapuan\\.org")) {
                        Intent signedInIntent = new Intent(this, SignedInActivity.class);
                        startActivity(signedInIntent);
                        finish();
                        return;
                    }
                    else if (email.matches("karmadog@cox.net")) {
                        Intent signedInIntent = new Intent(this, SignedInActivity.class);
                        startActivity(signedInIntent);
                        finish();
                        return;
                    }
                    else {
                        showSnackbar(R.string.not_kapaun_user);
                        return;
                    }
                }
            } else {
                // Sign in failed

                if (response == null) {
                    // User pressed back button
                    showSnackbar(R.string.sign_in_cancelled);
                    return;
                }

                if (response.getErrorCode() == ErrorCodes.NO_NETWORK) {
                    showSnackbar(R.string.no_internet_connection);
                    return;
                }

                if (response.getErrorCode() == ErrorCodes.UNKNOWN_ERROR) {
                    showSnackbar(R.string.unknown_error);
                    return;
                }
            }

            showSnackbar(R.string.unknown_sign_in_response);
        }
    }

    private void showSnackbar(int message) {
        final View cView = findViewById(R.id.snackbarPosition);
        Snackbar.make(cView,message, Snackbar.LENGTH_LONG)
                .show();
    }
}
