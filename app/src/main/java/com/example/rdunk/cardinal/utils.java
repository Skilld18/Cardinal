package com.example.rdunk.cardinal;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

/**
 * Created by rdunk on 06/06/17.
 */

public class utils {
    public static TextToSpeech tts;
    public static Context c;
    public static GoogleApiClient mGoogleApiClient;
    public static boolean connected;
    public static LocationManager mLocationClient;
    public static LocationRequest mLocationRequest;

    public static void speak(String text){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        }else{
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    public static String degreesToCardinal(float degrees){
        int [] directions = {
                R.string.n,
                R.string.nne,
                R.string.ne,
                R.string.ene,
                R.string.e,
                R.string.ese,
                R.string.se,
                R.string.sse,
                R.string.s,
                R.string.ssw,
                R.string.sw,
                R.string.wsw,
                R.string.w,
                R.string.wnw,
                R.string.nw,
                R.string.nnw,
        };
        return c.getString(directions[(int)Math.round((((degrees + 360)% 360) / 22.5)) % 16]);
    }

}
