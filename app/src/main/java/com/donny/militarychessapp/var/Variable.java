package com.donny.militarychessapp.var;

/**
 * Created by youansheng on 2016/11/22.
 */
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.donny.militarychessapp.chess.Position;
import com.donny.militarychessapp.context.ContextUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class Variable {
    public HashMap<String, Integer> redKeyToImage = new HashMap<String, Integer>();
    public HashMap<String, Integer> blueKeyToImage = new HashMap<String, Integer>();
    public ImageView[] ItemBox = new ImageView[61];
    public Position[] ChessPos = new Position[61];
    public boolean isStart = true;
    public boolean isClicked = false;
    public boolean isLocked = false;
    public int clickIndex1 = 0;
    public int clickIndex2 = 0;
    public int GameMode = 1;
    public boolean controlBelong = true; //if red, true, else blue
    public boolean isEnd = false;
    public int searchDeepth = 1;
    public boolean forDFS = false;
    public Drawable iconIndex1;
    public Drawable iconIndex2;
    public int threadNum = 0;
    public boolean flag = false;
    public int threadAnimate = 0;
    public int temp = 0;
    public ArrayList<Position> posList = new ArrayList<Position>();
    public ImageView picbox; //= new ImageView(ContextUtil.getInstance());
}
