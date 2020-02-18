package id.ac.polinema.intent;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExplicitIntentActivity extends AppCompatActivity {

    private EditText nameInput;
    private TextView outPutText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);
        findViewById(R.id.input_name);
        nameInput = findViewById(R.id.input_name);
        outPutText = findViewById(R.id.text_output);
    }

    public void handleSubmit(View view) {
        String name = nameInput.getText().toString();
        outPutText.setText("Assalamualaikum " + name);
    }
}
