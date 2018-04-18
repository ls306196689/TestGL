package com.iqiyi.render;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.View;
import android.widget.FrameLayout;


/**
 * Created by sunpengfei on 2018/4/16.
 */

public class GLController {
    private Context mContext;
    MySurfaceView mySurfaceView;
    FrameLayout frameLayout;
    public GLController(Context context)
    {
        mContext = context;
        Resource.inst().init(context);
    }

    public void init()
    {
        frameLayout = new FrameLayout(mContext);
        mySurfaceView = new MySurfaceView(mContext);
        mySurfaceView.setEGLContextClientVersion(2);
        mySurfaceView.setEGLConfigChooser(8,8,8,8,16,0);
        mySurfaceView.setRenderer(new MyRender());
        mySurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
        frameLayout.addView(mySurfaceView);
        NodeMgr.inst();
    }
    public void onPause()
    {
        mySurfaceView.onPause();
    }
    public void onResume()
    {
        mySurfaceView.onResume();
    }
    public View getView()
    {
        return frameLayout;
    }

}
