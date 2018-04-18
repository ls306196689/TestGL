package com.iqiyi.render;

import android.opengl.GLES20;
import android.util.Log;

/**
 * Created by sunpengfei on 2018/4/16.
 */

public final class GLHelper {
    public static void verify(String tag) {
        int error;
        if ((error = GLES20.glGetError()) != GLES20.GL_NO_ERROR)
        {
            Log.e(tag, "glGetError " + error);
            throw new RuntimeException(tag + ": glGetError " + error);
        }
    }
}
