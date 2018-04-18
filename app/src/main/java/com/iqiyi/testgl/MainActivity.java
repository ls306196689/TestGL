package com.iqiyi.testgl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iqiyi.render.GLController;

public class MainActivity extends AppCompatActivity {
    GLController mController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mController = new GLController(this);
        mController.init();
        setContentView(mController.getView());
    }
}
