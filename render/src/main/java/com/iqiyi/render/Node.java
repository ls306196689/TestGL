package com.iqiyi.render;

/**
 * Created by sunpengfei on 2018/4/16.
 */

public interface Node {
    void init();
    void draw();
    void beforeDraw();
    void afterDraw();
}
