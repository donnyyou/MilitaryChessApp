package com.donny.militarychessapp.var;

import com.donny.militarychessapp.chess.Position;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.JLabel;

public class Variable {
    public static HashMap<String, String> redKeyToImage = new HashMap<String, String>();
    public static HashMap<String, String> blueKeyToImage = new HashMap<String, String>();
    public static JLabel[] ItemBox = new JLabel[61];//��¼60��picturebox����������
    public static Position[] ChessPos = new Position[61];
    public static boolean isStart = false;
    public static boolean isClicked = false;
    public static boolean isLocked = false;
    public static int clickIndex1 = 0;
    public static int clickIndex2 = 0;
    public static int GameMode = 1;
    public static boolean controlBelong = true;//���ķ��߶���trueΪ�췽��falseΪ����
    public static boolean isEnd = false;
    public static int searchDeepth = 1;
    public static boolean forDFS = false;
    public static Icon iconIndex1;
    public static Icon iconIndex2;
    public static int threadNum = 0;
    public static boolean flag = false;
    public static int threadAnimate = 0;
    public static int temp = 0;
    public static ArrayList<Position> posList = new ArrayList<Position>();
    public static JLabel picbox = new JLabel();
}
