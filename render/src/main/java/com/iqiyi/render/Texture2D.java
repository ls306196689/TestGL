package com.iqiyi.render;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;

/**
 * Created by sunpengfei on 2018/4/16.
 */

public class Texture2D {
    int[] texID = {0};
    float mWidth;
    float mHeight;

    public Texture2D(String path)
    {
        loadPicture(path);
    }
    public void loadPicture(String path)
    {
        //Resource.readFileAssets()
        byte[] data = Resource.inst().readFileAssets(path);
        Bitmap bitmap = BitmapFactory.decodeByteArray(data, data.length,0);
        if (bitmap != null)
        {
            mWidth = bitmap.getWidth();
            mHeight = bitmap.getHeight();
            GLES20.glGenTextures(1,texID, 0);
            GLES20.glBindTexture(GLES20.GL_TEXTURE0, texID[0]);
            GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D,GLES20.GL_TEXTURE_MIN_FILTER,GLES20.GL_NEAREST);
            GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D,GLES20.GL_TEXTURE_MAG_FILTER,GLES20.GL_LINEAR);
            GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D,GLES20.GL_TEXTURE_WRAP_S,GLES20.GL_CLAMP_TO_EDGE);
            GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T,GLES20.GL_CLAMP_TO_EDGE);
            GLUtils.texImage2D(GLES20.GL_TEXTURE0, 0, bitmap, 0);
            bitmap.recycle();
        }
    }


    public int getTexID()
    {
        return texID[0];
    }
    public float getWidth()
    {
        return mWidth;
    }
    public float getHeight()
    {
        return mHeight;
    }

    void  release()
    {
        GLES20.glDeleteTextures(1,texID, 0);
    }

}
