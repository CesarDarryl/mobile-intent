package id.ac.polinema.intent;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class ImplicitIntentActivity extends AppCompatActivity {

    //this TAG used for Logging needs
    private static final String TAG = ImplicitIntentActivity.class.getCanonicalName();
    //this used for Definition of omplicit intent code request
    private static final int GALLERY_REQUEST_CODE = 1;

    private ImageView avatarImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
        avatarImage = findViewById(R.id.image_avatar);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_CANCELED)
        {
            return;
        }

        if(requestCode == GALLERY_REQUEST_CODE)
        {
            if(data != null)
            {
                try
                {
                    Uri imageUri = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),imageUri);
                    avatarImage.setImageBitmap(bitmap);
                }catch (IOException e)
                {
                    Toast.makeText(this,"Can't Load Image",Toast.LENGTH_SHORT).show();
                    Log.e(TAG,e.getMessage());
                }
            }
        }
    }

    public void handleImplicitIntent(View view) {
        //intent logical
        Intent intent = new Intent(this,ImplicitIntentActivity.class);
        //always add start activity
        startActivity(intent);
    }

    public void handleChangeAvatar(View view) {
        //intent logical
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        //add start activity
        startActivityForResult(intent,GALLERY_REQUEST_CODE);
        //take the result from intent, and Process the result.
    }
}
