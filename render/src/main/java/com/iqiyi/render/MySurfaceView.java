package com.iqiyi.render;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by sunpengfei on 2018/4/16.
 */

public class MySurfaceView extends GLSurfaceView {
    /**
     * Standard View constructor. In order to render something, you
     * must call {@link #setRenderer} to register a renderer.
     *
     * @param context
     */
    public MySurfaceView(Context context) {
        super(context);
    }
}
