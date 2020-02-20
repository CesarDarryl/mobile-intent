package id.ac.polinema.intent;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

import id.ac.polinema.intent.Model.User;

public class ProfileParcelableActivity extends AppCompatActivity {

    private TextView usernameText;
    private TextView nameText;
    private TextView ageText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_parcelable);

        // TODO: bind here
        usernameText = findViewById(R.id.text_username);
        nameText = findViewById(R.id.text_name);
        ageText = findViewById(R.id.text_age);

        Bundle extras = getIntent().getExtras();
        User user = extras.getParcelable("user");
        if (extras != null) {

            // TODO: display value here
            usernameText.setText(user.getUsername());
            nameText.setText(user.getName());
            ageText.setText(String.valueOf(user.getAge()));
        }
    }
}
