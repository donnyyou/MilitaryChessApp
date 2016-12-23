package com.donny.militarychessapp.main;

/**
 * Created by youansheng on 2016/12/23.
 */

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.donny.militarychessapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

public class BlueToothMainView extends RelativeLayout {
    protected static int GRID_SIZE = 14;    //设置为国际标准
    protected static int GRID_WIDTH = 42; // 棋盘格的宽度
    protected static int CHESS_DIAMETER = 37; // 棋的直径
    protected static int mStartX;// 棋盘定位的左上角X
    protected static int mStartY;// 棋盘定位的左上角Y

    private static int[][] mGridArray; // 网格
    private Stack<String> storageArray;


    int wbflag = 1; //该下白棋了=2，该下黑棋了=1. 这里先下黑棋（黑棋以后设置为机器自动下的棋子）
    int mLevel = 1; //游戏难度
    int mWinFlag = 0;
    private final int BLACK = 1;
    private final int WHITE = 2;


    //private TextView mStatusTextView; //  根据游戏状态设置显示的文字
    private TextView mStatusTextView; //  根据游戏状态设置显示的文字

    private Bitmap btm1;
    private final Paint mPaint = new Paint();

    CharSequence mText;
    CharSequence STRING_WIN = "白棋赢啦!  ";
    CharSequence STRING_LOSE = "黑棋赢啦!  ";
    CharSequence STRING_EQUAL = "和棋！  ";

    public BlueToothMainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);

        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li;
        li = (LayoutInflater) getContext().getSystemService(infService);
        li.inflate(R.layout.blue_tooth_main_layout, this, true);
        //init();
    }

    //按钮监听器
    MyButtonListener myButtonListener;

    public void setActionCallbak(BlueToothGameAty blueToothGameAty) {
        this.blueToothGameAty = blueToothGameAty;
    }

    private  BlueToothGameAty blueToothGameAty;

    // 初始化黑白棋的Bitmap
    public void init() {
        storageArray = new Stack<>();
        myButtonListener = new MyButtonListener();
        wbflag = BLACK; //初始为先下黑棋
        mWinFlag = 0; //清空输赢标志。
        mGridArray = new int[GRID_SIZE - 1][GRID_SIZE - 1];


        Bitmap bitmap = Bitmap.createBitmap(CHESS_DIAMETER, CHESS_DIAMETER, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Resources r = this.getContext().getResources();

    }

    //设置显示的textView
    public void setTextView(TextView tv) {
        mStatusTextView = tv;
    }

    //悔棋按钮
    Button huiqi;
    //刷新那妞
    Button refresh;

    //设置两个按钮
    public void setButtons(Button huiqi, Button refresh) {
        this.huiqi = huiqi;
        this.refresh = refresh;
        huiqi.setOnClickListener(myButtonListener);
        refresh.setOnClickListener(myButtonListener);
    }


    /**
     * 点下出现棋子
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return true;

    }



    /**
     * 下棋，黑1 白2
     * @param x
     * @param y
     * @param blackwhite
     */
    public void putChess(int x, int y, int blackwhite) {
        mGridArray[x][y] = blackwhite;
        String temp = x + ":" + y;
        storageArray.push(temp);
        //通过回调方法通知Activity下棋动作
        blueToothGameAty.onPutChess(temp + ":" + blackwhite);
        invalidate();
    }

    //收到对方传来的棋子
    public void xiaqi(String command) {
        if ((command==null)) {
            return;
        }
        if ((command.equals("HUIQI"))) {
            if (storageArray.size()==0) {
                //Toast.makeText(getContext(),"开局并不能悔棋",Toast.LENGTH_SHORT).show();
            }else {

            }
        } else if ((command.equals("REFRESH")))
        {

        }
        else if ((command.equals("WHITE"))) {

        } else if (command.equals("BLACK")) {

        } else {
            Log.d("whalea", "收到的指令:" + command);
            String[] temps = command.split(":");
            int a = Integer.parseInt(temps[0]);
            int b = Integer.parseInt(temps[1]);
            int c = Integer.parseInt(temps[2]);

        }
    }


    public interface BlueToothActionListner {
        void  onPutChess(String temp);
        void onBtnPress(int i); //0悔棋  1刷新
    }


    class MyButtonListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //如果是悔棋
/*                case R.id.bluetooth_btn1:
                    blueToothGameAty.onBtnPress(0);
                    if (storageArray.size()==0) {
                        Toast.makeText(getContext(),"开局并不能悔棋",Toast.LENGTH_SHORT).show();
                    }else {
                        if (storageArray.size()==1) {
                            storageArray.pop();
                            mGridArray = new int[GRID_SIZE - 1][GRID_SIZE - 1];
                            invalidate();
                        } else {
                            String temp = storageArray.pop();
                            String[] temps = temp.split(":");

                            int a = Integer.parseInt(temps[0]);
                            int b = Integer.parseInt(temps[1]);
                            mGridArray[a][b] = 0;
                            invalidate();
                        }
                    }
                    break;
                //如果是刷新
                case R.id.bluetooth_btn2:
                    blueToothGameAty.onBtnPress(1);
                    setVisibility(View.VISIBLE);
                    mStatusTextView.invalidate();
                    init();
                    invalidate();
                    for (int i = 0; i < showtime.length; i++) {
                        showtime[i] = 0;
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
                    mStatusTextView.setText("蓝牙对战模式 当前时间：" + simpleDateFormat.format(new Date()));
                    break;*/
            }
        }
    }
}
