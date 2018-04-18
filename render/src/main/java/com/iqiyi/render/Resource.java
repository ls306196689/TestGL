package com.iqiyi.render;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by sunpengfei on 2018/4/16.
 */

public class Resource {
    private static final String TAG = "Resource";
    private static Resource resource;
    private Context mContext;
    static public Resource inst()
    {
        if (resource == null)
        {
            resource = new Resource();
        }
        return resource;
    }
    public void init(Context context)
    {
        mContext = context;
    }


    public byte[] readFileAssets(String path)
    {
        byte[] data = null;
        try {
            InputStream is = mContext.getAssets().open(path);
            int len = is.available();
            data = new byte[len];
            int lenTmp = 0;
            while ((lenTmp = is.read(data,0, len)) != len)
            {
                if (lenTmp > 0)
                {
                    len -= lenTmp;
                }else{
                    break;
                }
            }

        } catch (IOException e) {
            Log.e(TAG, path + " NOT EXSIT!");
        }
        return data;
    }

}
