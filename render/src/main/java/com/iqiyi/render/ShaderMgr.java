package com.iqiyi.render;

import android.opengl.GLES20;

/**
 * Created by sunpengfei on 2018/4/16.
 */

public final class ShaderMgr {

   static String SHADER_IMAGE_VEX =
    "attribute vec4 vPosition;\n"
            + "void main() {\n"
            + " gl_Position = vPosition;\n"
            + "}";
   static String SHADER_IMAGE_FRAG =
            "precision mediump float;\n"
                    + "void main() {\n"
                    + " gl_FragColor = vec4(0.5, 0, 0, 1);\n"
                    + "}";

   static int program_image = -1;
   public static int getProgram_image()
   {
       if (program_image == -1)
       {
           program_image = createProgram(SHADER_IMAGE_VEX, SHADER_IMAGE_FRAG);
       }
       return program_image;
   }
    static int loadShader(int type, String shaderCode) {
        int shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);
        return shader;
    }
    public static int createProgram(String vexShader, String fragShader)
    {
        int program = GLES20.glCreateProgram();
        int vex = loadShader(GLES20.GL_VERTEX_SHADER, vexShader);
        GLHelper.verify("createProgram:" + vexShader);
        int frag = loadShader(GLES20.GL_FRAGMENT_SHADER, fragShader);
        GLHelper.verify("createProgram:" + fragShader);
        GLES20.glAttachShader(program, vex);
        GLES20.glAttachShader(program, frag);
        GLES20.glLinkProgram(program);
        GLHelper.verify("createProgram: glLinkProgram" + program);
        return program;
    }

}
