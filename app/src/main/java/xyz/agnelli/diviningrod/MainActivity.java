package xyz.agnelli.diviningrod;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.widget.FrameLayout;


public class MainActivity extends AppCompatActivity {


    private Camera cam;
    private CameraPreview camPreview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(checkCameraHardware(this)){
            Log.e("Camera","Camera exists");
            cam = getCameraInstance();

            camPreview = new CameraPreview(this,cam);
            FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
            preview.addView(camPreview);

        }

    }

    private boolean checkCameraHardware(Context context){

        if(context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA))
            return true;
        return false;

    }

    public static Camera getCameraInstance(){
        Camera c = null;

        try{
            c = Camera.open();
        }
        catch(Exception e){
            Log.e("Camera",e.toString());
        }

        return c;

    }

}

