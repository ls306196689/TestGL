package com.iqiyi.render;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by sunpengfei on 2018/4/16.
 */

public class NodeMgr implements Node {
    public final static String TAG = "NodeMgr";
    ArrayList<Node> listNode = new ArrayList<Node>();
    static NodeMgr nodeMgr ;
    public static NodeMgr inst()
    {
        if (  nodeMgr == null)
        {
            nodeMgr = new  NodeMgr();
            nodeMgr.init();
        }
        return nodeMgr;
    }
    @Override
    public void init() {
        initScene();
    }
    void initScene()
    {
        Texture2D texture2D = new Texture2D("0.png");
        Log.i(TAG, "WIDTH " + texture2D.getWidth());
        ImageNode image = new ImageNode();

        addNode(image);

    }

    @Override
    public void draw() {
        for (Node node:listNode
             ) {
            node.draw();
        }
    }

    @Override
    public void beforeDraw() {
        for (Node node:listNode
                ) {
            node.beforeDraw();
        }
    }

    @Override
    public void afterDraw() {

    }
    public void addNode(Node node)
    {
        listNode.add(node);
    }
}
