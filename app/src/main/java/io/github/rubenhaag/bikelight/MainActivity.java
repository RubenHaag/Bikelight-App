package io.github.rubenhaag.bikelight;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private int PICK_IMAGE_REQUEST = 1;
    private Bitmap bmp;
    private Bitmap quad;
    private int h, w;
    private int[] pixels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void choseImage(View v){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data!= null && data.getData() != null){
            Uri uri = data.getData();
            try{
                bmp = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                ImageView picView = (ImageView) findViewById(R.id.imageView);
                picView.setImageBitmap(bmp);
                h = bmp.getHeight();
                w = bmp.getWidth();
                int x, y, z;
                if(h < w){
                    x = (w-h)/2;
                    y = 0;
                    quad = Bitmap.createBitmap(bmp, x, y, h, h);
                }
                else if(h > w){
                    y = (h - w) /2;
                    x = 0;
                    quad = Bitmap.createBitmap(bmp, x, y, w, w);
                }
                else{
                    quad = bmp;
                }
                quad = Bitmap.createScaledBitmap(quad, 100, 100, false);
                picView.setImageBitmap(quad);
            }
            catch (IOException e){
                Toast.makeText(this, "Fehler:\n" + e, Toast.LENGTH_LONG);
            }
        }
    }
    public void bildSenden(){

    }


}
