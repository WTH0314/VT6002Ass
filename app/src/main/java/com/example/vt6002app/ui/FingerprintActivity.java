package com.example.vt6002app.ui;
//reference from https://xnfood.com.tw/android-fingerprintmanager-api/

import android.Manifest;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.os.CancellationSignal;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vt6002app.R;

public class FingerprintActivity extends AppCompatActivity {

    private KeyguardManager mKeyguardManager;
    private FingerprintManager mFingerprintManager;
    private CancellationSignal cancellationSignal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mKeyguardManager = (KeyguardManager)getSystemService(Activity.KEYGUARD_SERVICE);
        mFingerprintManager = (FingerprintManager)getSystemService(Activity.FINGERPRINT_SERVICE);//FingerprintManager.class

        if (!mKeyguardManager.isKeyguardSecure())
        {
            //是否有設定 fingerprint screen lock
            return;
        }

        if (checkSelfPermission(Manifest.permission.USE_FINGERPRINT)
                == PackageManager.PERMISSION_GRANTED) //In SDK 23, we need to check the permission before we call FingerprintManager API functionality.
        {
            if (!mFingerprintManager.isHardwareDetected())
            {
                //硬體裝置是否有 fingerprint reader
                return;
            }

            if (!mFingerprintManager.hasEnrolledFingerprints())
            {
                //是否有設定至少一枚指紋
                return;
            }
        }
        startFingerprintListening();
    }

    private void startFingerprintListening() {
    }
}
