package io.github.rubenhaag.bikelight;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.graphics.Color.*;
import java.io.IOException;


/**
 * Created by ruben on 30.08.17.
 */

public class Bildverarbeitung extends AppCompatActivity {
    public int bmpToPolar(Bitmap bmp) {
        final int STEP = 360; //Menge der Schritte die für einen Vollkreis verwendet werden
        final int LED_RAD = 35; //Menge der Led's im Radius
        int[] argb = new int [bmp.getWidth()*bmp.getWidth()];
        int[][][] rgb = new int[bmp.getWidth()][bmp.getHeight()][3];
        int[][] polar = new int[STEP][LED_RAD];
        bmp.getPixels(argb, 0, bmp.getWidth(), 0, 0,bmp.getWidth(), bmp.getHeight());

        //argb-Array zu rgb-Array
        for(int y = 0; y < bmp.getHeight(); y++){
            for(int x = 0; x<bmp.getWidth(); x++) {
                rgb[x][y][0] = Color.red(argb[x * y]);
                rgb[x][y][1] = Color.green(argb[x * y]);
                rgb[x][y][2] = Color.blue(argb[x * y]);
            }
        }
        for(int i = 0; i < STEP; i++){
            for(int r = 0; r<LED_RAD){
        }
        //rgb-Array zu Polar



    }


}
