package com.donny.militarychessapp.main;

/**
 * Created by youansheng on 2016/12/23.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.donny.militarychessapp.R;
import com.donny.militarychessapp.chess.Position;
import com.donny.militarychessapp.var.Variable;


import java.util.Stack;

public class BlueToothMainView extends RelativeLayout implements View.OnClickListener {
    protected static int GRID_SIZE = 14;    //设置为国际标准
    protected static int GRID_WIDTH = 42; // 棋盘格的宽度
    protected static int CHESS_DIAMETER = 37; // 棋的直径
    private Variable var = new Variable();

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
        //this.setFocusableInTouchMode(true);

        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li;
        li = (LayoutInflater) getContext().getSystemService(infService);
        li.inflate(R.layout.blue_tooth_main_layout, this, true);

        ((ImageView)findViewById(R.id.imageViewTitle)).setImageResource(R.drawable.title);
        ((ImageView)findViewById(R.id.imageViewUser1)).setImageResource(R.drawable.user1);
        ((ImageView)findViewById(R.id.imageViewUser2)).setImageResource(R.drawable.user2);
        ((ImageView)findViewById(R.id.imageViewChessBoard)).setImageResource(R.drawable.board720p);

        var.ItemBox[1] = (ImageView)findViewById(R.id.imageViewC1);
        var.ItemBox[2] = (ImageView)findViewById(R.id.imageViewC2);
        var.ItemBox[3] = (ImageView)findViewById(R.id.imageViewC3);
        var.ItemBox[4] = (ImageView)findViewById(R.id.imageViewC4);
        var.ItemBox[5] = (ImageView)findViewById(R.id.imageViewC5);
        var.ItemBox[6] = (ImageView)findViewById(R.id.imageViewC6);
        var.ItemBox[7] = (ImageView)findViewById(R.id.imageViewC7);
        var.ItemBox[8] = (ImageView)findViewById(R.id.imageViewC8);
        var.ItemBox[9] = (ImageView)findViewById(R.id.imageViewC9);
        var.ItemBox[10] = (ImageView)findViewById(R.id.imageViewC10);
        var.ItemBox[11] = (ImageView)findViewById(R.id.imageViewC11);
        var.ItemBox[12] = (ImageView)findViewById(R.id.imageViewC12);
        var.ItemBox[13] = (ImageView)findViewById(R.id.imageViewC13);
        var.ItemBox[14] = (ImageView)findViewById(R.id.imageViewC14);
        var.ItemBox[15] = (ImageView)findViewById(R.id.imageViewC15);
        var.ItemBox[16] = (ImageView)findViewById(R.id.imageViewC16);
        var.ItemBox[17] = (ImageView)findViewById(R.id.imageViewC17);
        var.ItemBox[18] = (ImageView)findViewById(R.id.imageViewC18);
        var.ItemBox[19] = (ImageView)findViewById(R.id.imageViewC19);
        var.ItemBox[20] = (ImageView)findViewById(R.id.imageViewC20);
        var.ItemBox[21] = (ImageView)findViewById(R.id.imageViewC21);
        var.ItemBox[22] = (ImageView)findViewById(R.id.imageViewC22);
        var.ItemBox[23] = (ImageView)findViewById(R.id.imageViewC23);
        var.ItemBox[24] = (ImageView)findViewById(R.id.imageViewC24);
        var.ItemBox[25] = (ImageView)findViewById(R.id.imageViewC25);
        var.ItemBox[26] = (ImageView)findViewById(R.id.imageViewC26);
        var.ItemBox[27] = (ImageView)findViewById(R.id.imageViewC27);
        var.ItemBox[28] = (ImageView)findViewById(R.id.imageViewC28);
        var.ItemBox[29] = (ImageView)findViewById(R.id.imageViewC29);
        var.ItemBox[30] = (ImageView)findViewById(R.id.imageViewC30);
        var.ItemBox[31] = (ImageView)findViewById(R.id.imageViewC31);
        var.ItemBox[32] = (ImageView)findViewById(R.id.imageViewC32);
        var.ItemBox[33] = (ImageView)findViewById(R.id.imageViewC33);
        var.ItemBox[34] = (ImageView)findViewById(R.id.imageViewC34);
        var.ItemBox[35] = (ImageView)findViewById(R.id.imageViewC35);
        var.ItemBox[36] = (ImageView)findViewById(R.id.imageViewC36);
        var.ItemBox[37] = (ImageView)findViewById(R.id.imageViewC37);
        var.ItemBox[38] = (ImageView)findViewById(R.id.imageViewC38);
        var.ItemBox[39] = (ImageView)findViewById(R.id.imageViewC39);
        var.ItemBox[40] = (ImageView)findViewById(R.id.imageViewC40);
        var.ItemBox[41] = (ImageView)findViewById(R.id.imageViewC41);
        var.ItemBox[42] = (ImageView)findViewById(R.id.imageViewC42);
        var.ItemBox[43] = (ImageView)findViewById(R.id.imageViewC43);
        var.ItemBox[44] = (ImageView)findViewById(R.id.imageViewC44);
        var.ItemBox[45] = (ImageView)findViewById(R.id.imageViewC45);
        var.ItemBox[46] = (ImageView)findViewById(R.id.imageViewC46);
        var.ItemBox[47] = (ImageView)findViewById(R.id.imageViewC47);
        var.ItemBox[48] = (ImageView)findViewById(R.id.imageViewC48);
        var.ItemBox[49] = (ImageView)findViewById(R.id.imageViewC49);
        var.ItemBox[50] = (ImageView)findViewById(R.id.imageViewC50);
        var.ItemBox[51] = (ImageView)findViewById(R.id.imageViewC51);
        var.ItemBox[52] = (ImageView)findViewById(R.id.imageViewC52);
        var.ItemBox[53] = (ImageView)findViewById(R.id.imageViewC53);
        var.ItemBox[54] = (ImageView)findViewById(R.id.imageViewC54);
        var.ItemBox[55] = (ImageView)findViewById(R.id.imageViewC55);
        var.ItemBox[56] = (ImageView)findViewById(R.id.imageViewC56);
        var.ItemBox[57] = (ImageView)findViewById(R.id.imageViewC57);
        var.ItemBox[58] = (ImageView)findViewById(R.id.imageViewC58);
        var.ItemBox[59] = (ImageView)findViewById(R.id.imageViewC59);
        var.ItemBox[60] = (ImageView)findViewById(R.id.imageViewC60);

        initall();

        for (int i = 1; i < 61; ++i)
        {
            var.ItemBox[i].setOnClickListener(this);
        }

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var.isStart = true;
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // load the layout.
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(!var.isClicked)
        {
            if(var.threadNum == 1)
            {
                return;
            }
            int boxId = Integer.parseInt(v.getTag().toString());

            Drawable icon = var.ItemBox[boxId].getDrawable();

            if (var.isStart)
            {
                if (var.GameMode == 2)
                {
                    //if (netsystem.redOrblue != var.ChessPos[BoxId].RedOrBlue)
                    return;
                }
                if (icon == null) return;
                if (!((var.ChessPos[boxId].getRedOrBlue() == 1) ^ var.controlBelong))
                {
                    var.isClicked = true;
                    var.clickIndex1 = boxId;
                    var.iconIndex1 = icon;
                }
                else
                {
                    var.isClicked = false;
                }
            }
            else
            {
                var.isClicked = true;
                var.clickIndex1 = boxId;
                var.iconIndex1 = icon;
            }


            var.picbox = var.ItemBox[boxId];
            AlphaAnimation animation = new AlphaAnimation(1, 0);
            animation.setDuration(200);
            animation.setRepeatCount(30);
            animation.setStartOffset(300);
            var.ItemBox[boxId].startAnimation(animation);
        }
        else
        {
            int boxId = Integer.parseInt(v.getTag().toString());
            if (!var.isStart)
            {
                if (var.ItemBox[boxId].getDrawable() == null)
                {
                    return;
                }
            }
            var.ItemBox[var.clickIndex1].clearAnimation();
            var.isClicked = false;
            var.clickIndex2 = boxId;
            // var.ItemBox[var.clickIndex1].setImageDrawable(var.iconIndex1);

            if (!ChangePosition(var.isStart, var.clickIndex1, var.clickIndex2)) return;
            else
            {


                //if (var.controlBelong == false) ActionMode(var.GameMode);

            }
            putChess(var.clickIndex1, var.clickIndex2, 0);
            System.out.println(var.clickIndex1);
            System.out.println(var.clickIndex2);
        }
    }

    public void initall()
    {
        keyToImage();
        initPosLimit();
        initChess();
    }

    public void initChess()
    {
        var.ItemBox[1].setImageResource(var.blueKeyToImage.get("dilei"));
        var.ItemBox[1].setVisibility(View.VISIBLE);
        var.ChessPos[1].setName("dilei");

        var.ItemBox[2].setImageResource(var.blueKeyToImage.get("junqi"));
        var.ItemBox[2].setVisibility(View.VISIBLE);
        var.ChessPos[2].setName("junqi");

        var.ItemBox[3].setImageResource(var.blueKeyToImage.get("dilei"));
        var.ItemBox[3].setVisibility(View.VISIBLE);
        var.ChessPos[3].setName("dilei");

        var.ItemBox[4].setImageResource(var.blueKeyToImage.get("dilei"));
        var.ItemBox[4].setVisibility(View.VISIBLE);
        var.ChessPos[4].setName("dilei");

        var.ItemBox[5].setImageResource(var.blueKeyToImage.get("gongbing"));
        var.ItemBox[5].setVisibility(View.VISIBLE);
        var.ChessPos[5].setName("gongbing");

        var.ItemBox[6].setImageResource(var.blueKeyToImage.get("gongbing"));
        var.ItemBox[6].setVisibility(View.VISIBLE);
        var.ChessPos[6].setName("gongbing");

        var.ItemBox[7].setImageResource(var.blueKeyToImage.get("gongbing"));
        var.ItemBox[7].setVisibility(View.VISIBLE);
        var.ChessPos[7].setName("gongbing");

        var.ItemBox[8].setImageResource(var.blueKeyToImage.get("zhadan"));
        var.ItemBox[8].setVisibility(View.VISIBLE);
        var.ChessPos[8].setName("zhadan");

        var.ItemBox[9].setImageResource(var.blueKeyToImage.get("zhadan"));
        var.ItemBox[9].setVisibility(View.VISIBLE);
        var.ChessPos[9].setName("zhadan");

        var.ItemBox[10].setImageResource(var.blueKeyToImage.get("paizhang"));
        var.ItemBox[10].setVisibility(View.VISIBLE);
        var.ChessPos[10].setName("paizhang");

        var.ItemBox[11].setImageResource(var.blueKeyToImage.get("paizhang"));
        var.ItemBox[11].setVisibility(View.VISIBLE);
        var.ChessPos[11].setName("paizhang");

        var.ItemBox[12].setImageDrawable(null);
        var.ItemBox[12].setVisibility(View.VISIBLE);

        var.ItemBox[13].setImageResource(var.blueKeyToImage.get("lianzhang"));
        var.ItemBox[13].setVisibility(View.VISIBLE);
        var.ChessPos[13].setName("lianzhang");

        var.ItemBox[14].setImageDrawable(null);
        var.ItemBox[14].setVisibility(View.VISIBLE);

        var.ItemBox[15].setImageResource(var.blueKeyToImage.get("lianzhang"));
        var.ItemBox[15].setVisibility(View.VISIBLE);
        var.ChessPos[15].setName("lianzhang");

        var.ItemBox[16].setImageResource(var.blueKeyToImage.get("yingzhang"));
        var.ItemBox[16].setVisibility(View.VISIBLE);
        var.ChessPos[16].setName("yingzhang");

        var.ItemBox[17].setImageResource(var.blueKeyToImage.get("yingzhang"));
        var.ItemBox[17].setVisibility(View.VISIBLE);
        var.ChessPos[17].setName("yingzhang");

        var.ItemBox[18].setImageDrawable(null);
        var.ItemBox[18].setVisibility(View.VISIBLE);

        var.ItemBox[19].setImageResource(var.blueKeyToImage.get("tuanzhang"));
        var.ItemBox[19].setVisibility(View.VISIBLE);
        var.ChessPos[19].setName("tuanzhang");

        var.ItemBox[20].setImageResource(var.blueKeyToImage.get("tuanzhang"));
        var.ItemBox[20].setVisibility(View.VISIBLE);
        var.ChessPos[20].setName("tuanzhang");

        var.ItemBox[21].setImageResource(var.blueKeyToImage.get("lvzhang"));
        var.ItemBox[21].setVisibility(View.VISIBLE);
        var.ChessPos[21].setName("lvzhang");

        var.ItemBox[22].setImageDrawable(null);
        var.ItemBox[22].setVisibility(View.VISIBLE);

        var.ItemBox[23].setImageResource(var.blueKeyToImage.get("lvzhang"));
        var.ItemBox[23].setVisibility(View.VISIBLE);
        var.ChessPos[23].setName("lvzhang");

        var.ItemBox[24].setImageDrawable(null);
        var.ItemBox[24].setVisibility(View.VISIBLE);

        var.ItemBox[25].setImageResource(var.blueKeyToImage.get("shizhang"));
        var.ItemBox[25].setVisibility(View.VISIBLE);
        var.ChessPos[25].setName("shizhang");

        var.ItemBox[26].setImageResource(var.blueKeyToImage.get("shizhang"));
        var.ItemBox[26].setVisibility(View.VISIBLE);
        var.ChessPos[26].setName("shizhang");

        var.ItemBox[27].setImageResource(var.blueKeyToImage.get("junzhang"));
        var.ItemBox[27].setVisibility(View.VISIBLE);
        var.ChessPos[27].setName("junzhang");

        var.ItemBox[28].setImageResource(var.blueKeyToImage.get("siling"));
        var.ItemBox[28].setVisibility(View.VISIBLE);
        var.ChessPos[28].setName("siling");

        var.ItemBox[29].setImageResource(var.blueKeyToImage.get("paizhang"));
        var.ItemBox[29].setVisibility(View.VISIBLE);
        var.ChessPos[29].setName("paizhang");

        var.ItemBox[30].setImageResource(var.blueKeyToImage.get("lianzhang"));
        var.ItemBox[30].setVisibility(View.VISIBLE);
        var.ChessPos[30].setName("lianzhang");

        var.ItemBox[60].setImageResource(var.redKeyToImage.get("dilei"));
        var.ItemBox[60].setVisibility(View.VISIBLE);
        var.ChessPos[60].setName("dilei");

        var.ItemBox[59].setImageResource(var.redKeyToImage.get("junqi"));
        var.ItemBox[59].setVisibility(View.VISIBLE);
        var.ChessPos[59].setName("junqi");

        var.ItemBox[58].setImageResource(var.redKeyToImage.get("dilei"));
        var.ItemBox[58].setVisibility(View.VISIBLE);
        var.ChessPos[58].setName("dilei");

        var.ItemBox[57].setImageResource(var.redKeyToImage.get("dilei"));
        var.ItemBox[57].setVisibility(View.VISIBLE);
        var.ChessPos[57].setName("dilei");

        var.ItemBox[56].setImageResource(var.redKeyToImage.get("gongbing"));
        var.ItemBox[56].setVisibility(View.VISIBLE);
        var.ChessPos[56].setName("gongbing");

        var.ItemBox[55].setImageResource(var.redKeyToImage.get("gongbing"));
        var.ItemBox[55].setVisibility(View.VISIBLE);
        var.ChessPos[55].setName("gongbing");

        var.ItemBox[54].setImageResource(var.redKeyToImage.get("gongbing"));
        var.ItemBox[54].setVisibility(View.VISIBLE);
        var.ChessPos[54].setName("gongbing");

        var.ItemBox[53].setImageResource(var.redKeyToImage.get("zhadan"));
        var.ItemBox[53].setVisibility(View.VISIBLE);
        var.ChessPos[53].setName("zhadan");

        var.ItemBox[52].setImageResource(var.redKeyToImage.get("zhadan"));
        var.ItemBox[52].setVisibility(View.VISIBLE);
        var.ChessPos[52].setName("zhadan");

        var.ItemBox[51].setImageResource(var.redKeyToImage.get("paizhang"));
        var.ItemBox[51].setVisibility(View.VISIBLE);
        var.ChessPos[51].setName("paizhang");

        var.ItemBox[50].setImageResource(var.redKeyToImage.get("paizhang"));
        var.ItemBox[50].setVisibility(View.VISIBLE);
        var.ChessPos[50].setName("paizhang");

        var.ItemBox[49].setImageDrawable(null);
        var.ItemBox[49].setVisibility(View.VISIBLE);

        var.ItemBox[48].setImageResource(var.redKeyToImage.get("lianzhang"));
        var.ItemBox[48].setVisibility(View.VISIBLE);
        var.ChessPos[48].setName("lianzhang");

        var.ItemBox[47].setImageDrawable(null);
        var.ItemBox[47].setVisibility(View.VISIBLE);

        var.ItemBox[46].setImageResource(var.redKeyToImage.get("lianzhang"));
        var.ItemBox[46].setVisibility(View.VISIBLE);
        var.ChessPos[46].setName("lianzhang");

        var.ItemBox[45].setImageResource(var.redKeyToImage.get("yingzhang"));
        var.ItemBox[45].setVisibility(View.VISIBLE);
        var.ChessPos[45].setName("yingzhang");

        var.ItemBox[44].setImageResource(var.redKeyToImage.get("yingzhang"));
        var.ItemBox[44].setVisibility(View.VISIBLE);
        var.ChessPos[44].setName("yingzhang");

        var.ItemBox[43].setImageDrawable(null);
        var.ItemBox[43].setVisibility(View.VISIBLE);

        var.ItemBox[42].setImageResource(var.redKeyToImage.get("tuanzhang"));
        var.ItemBox[42].setVisibility(View.VISIBLE);
        var.ChessPos[42].setName("tuanzhang");

        var.ItemBox[41].setImageResource(var.redKeyToImage.get("tuanzhang"));
        var.ItemBox[41].setVisibility(View.VISIBLE);
        var.ChessPos[41].setName("tuanzhang");

        var.ItemBox[40].setImageResource(var.redKeyToImage.get("lvzhang"));
        var.ItemBox[40].setVisibility(View.VISIBLE);
        var.ChessPos[40].setName("lvzhang");

        var.ItemBox[39].setImageDrawable(null);
        var.ItemBox[39].setVisibility(View.VISIBLE);

        var.ItemBox[38].setImageResource(var.redKeyToImage.get("lvzhang"));
        var.ItemBox[38].setVisibility(View.VISIBLE);
        var.ChessPos[38].setName("lvzhang");

        var.ItemBox[37].setImageDrawable(null);
        var.ItemBox[37].setVisibility(View.VISIBLE);

        var.ItemBox[36].setImageResource(var.redKeyToImage.get("shizhang"));
        var.ItemBox[36].setVisibility(View.VISIBLE);
        var.ChessPos[36].setName("shizhang");

        var.ItemBox[35].setImageResource(var.redKeyToImage.get("shizhang"));
        var.ItemBox[35].setVisibility(View.VISIBLE);
        var.ChessPos[35].setName("shizhang");

        var.ItemBox[34].setImageResource(var.redKeyToImage.get("junzhang"));
        var.ItemBox[34].setVisibility(View.VISIBLE);
        var.ChessPos[34].setName("junzhang");

        var.ItemBox[33].setImageResource(var.redKeyToImage.get("siling"));
        var.ItemBox[33].setVisibility(View.VISIBLE);
        var.ChessPos[33].setName("siling");

        var.ItemBox[32].setImageResource(var.redKeyToImage.get("paizhang"));
        var.ItemBox[32].setVisibility(View.VISIBLE);
        var.ChessPos[32].setName("paizhang");

        var.ItemBox[31].setImageResource(var.redKeyToImage.get("lianzhang"));
        var.ItemBox[31].setVisibility(View.VISIBLE);
        var.ChessPos[31].setName("lianzhang");
    }

    public void keyToImage()
    {
        var.redKeyToImage.put("siling", R.drawable.siling1);
        var.redKeyToImage.put("junzhang", R.drawable.junzhang1);
        var.redKeyToImage.put("shizhang", R.drawable.shizhang1);
        var.redKeyToImage.put("lvzhang", R.drawable.lvzhang1);
        var.redKeyToImage.put("tuanzhang", R.drawable.tuanzhang1);
        var.redKeyToImage.put("yingzhang", R.drawable.yingzhang1);
        var.redKeyToImage.put("lianzhang", R.drawable.lianzhang1);
        var.redKeyToImage.put("paizhang", R.drawable.paizhang1);
        var.redKeyToImage.put("gongbing", R.drawable.gongbing1);
        var.redKeyToImage.put("dilei", R.drawable.dilei1);
        var.redKeyToImage.put("zhadan", R.drawable.zhadan1);
        var.redKeyToImage.put("junqi", R.drawable.junqi1);
        var.redKeyToImage.put("blank", R.drawable.blank1);

        var.blueKeyToImage.put("siling", R.drawable.siling0);
        var.blueKeyToImage.put("junzhang", R.drawable.junzhang0);
        var.blueKeyToImage.put("shizhang", R.drawable.shizhang0);
        var.blueKeyToImage.put("lvzhang", R.drawable.lvzhang0);
        var.blueKeyToImage.put("tuanzhang", R.drawable.tuanzhang0);
        var.blueKeyToImage.put("yingzhang", R.drawable.yingzhang0);
        var.blueKeyToImage.put("lianzhang", R.drawable.lianzhang0);
        var.blueKeyToImage.put("paizhang", R.drawable.paizhang0);
        var.blueKeyToImage.put("gongbing", R.drawable.gongbing0);
        var.blueKeyToImage.put("dilei", R.drawable.dilei0);
        var.blueKeyToImage.put("zhadan", R.drawable.zhadan0);
        var.blueKeyToImage.put("junqi", R.drawable.junqi0);
        var.blueKeyToImage.put("blank", R.drawable.blank0);
    }

    public void initPosLimit()//pos limit
    {
        int posId = 1;
        for (int i=0; i < 12; i++)
            for (int j = 0; j < 5; j++)
            {
                var.ChessPos[posId] = new Position(posId, i, j);
                if (posId < 31)
                    var.ChessPos[posId].setRedOrBlue(0);
                else
                    var.ChessPos[posId].setRedOrBlue(1);
                if (i == 0 || i == 1 || i == 10 || i == 11)
                    var.ChessPos[posId].setCanSetDilei(true);
                if (i == 5 || i == 6)
                    var.ChessPos[posId].setCanSetZhadan(false);
                posId++;
            }
        var.ChessPos[2].setIsActive(false);
        var.ChessPos[4].setIsActive(false);
        var.ChessPos[57].setIsActive(false);
        var.ChessPos[59].setIsActive(false);

        var.ChessPos[12].setIsXingying(true);
        var.ChessPos[12].setRedOrBlue(2); //there is nothing
        var.ChessPos[14].setIsXingying(true);
        var.ChessPos[14].setRedOrBlue(2);
        var.ChessPos[18].setIsXingying(true);
        var.ChessPos[18].setRedOrBlue(2);
        var.ChessPos[22].setIsXingying(true);
        var.ChessPos[22].setRedOrBlue(2);
        var.ChessPos[24].setIsXingying(true);
        var.ChessPos[24].setRedOrBlue(2);
        var.ChessPos[37].setIsXingying(true);
        var.ChessPos[37].setRedOrBlue(2);
        var.ChessPos[39].setIsXingying(true);
        var.ChessPos[39].setRedOrBlue(2);
        var.ChessPos[43].setIsXingying(true);
        var.ChessPos[43].setRedOrBlue(2);
        var.ChessPos[47].setIsXingying(true);
        var.ChessPos[47].setRedOrBlue(2);
        var.ChessPos[49].setIsXingying(true);
        var.ChessPos[49].setRedOrBlue(2);
        for (int i = 1; i <= 60; i++)
        {
            if (var.ChessPos[i].getX() == 1 || var.ChessPos[i].getX() == 5 || var.ChessPos[i].getX() == 6 || var.ChessPos[i].getX() == 10)
            {
                var.ChessPos[i].setIsOnTheRoad(true);
                continue;
            }
            if (var.ChessPos[i].getY() == 0 || var.ChessPos[i].getY() == 4)
            {
                if (var.ChessPos[i].getX() != 0 && var.ChessPos[i].getX() != 11)
                {
                    var.ChessPos[i].setIsOnTheRoad(true);
                    continue;
                }
            }
        }
    }

    public boolean ChangePosition(boolean isstart, int index1, int index2)
    {
        if (!isstart)
        {
            if (var.ChessPos[index1].getRedOrBlue() == var.ChessPos[index2].getRedOrBlue() && CanMove(isstart, index1, index2))
            {
                changeStatus(index1, index2);
                return true;
            }
            else return false;

        }
        else
        {
            if (CanMove(isstart, index1, index2))
            {
                if (var.GameMode == 2)
                {
                    //netsystem.MoveDone(index1, index2);
                }
                var.controlBelong = !var.controlBelong;
                //fightStatus(index1, index2);
                return true;
            }
            else
                return false;
        }
    }

    public boolean CanMove(boolean isstart, int index1, int index2)
    {
        if (!isstart)
            return canMoveBeforeStart(index1, index2);
        //else
            //return canMoveAfterStart(var.ChessPos,index1, index2);
        return false;
    }

    public boolean canMoveBeforeStart(int index1, int index2)
    {
        if ((index1 > 30 && index2 < 31) || (index1 < 31 && index2 > 30)) return false;
        if (var.ChessPos[index1].getName() == "junqi" && var.ChessPos[index2].getIsActive()) return false;
        if (var.ChessPos[index2].getName() == "junqi" && var.ChessPos[index1].getIsActive()) return false;
        if (var.ChessPos[index1].getName() == "zhadan" && !var.ChessPos[index2].getCanSetZhadan()) return false;
        if (var.ChessPos[index2].getName() == "zhadan" && !var.ChessPos[index1].getCanSetZhadan()) return false;
        if (var.ChessPos[index1].getName() == "dilei" && !var.ChessPos[index2].getCanSetDilei()) return false;
        if (var.ChessPos[index2].getName() == "dilei" && !var.ChessPos[index1].getCanSetDilei()) return false;
        return true;
    }

    public void changeStatus(int index1, int index2)
    {
        Drawable imageIndex1 = var.ItemBox[index1].getDrawable();
        Drawable imageIndex2 = var.ItemBox[index2].getDrawable();
        if(imageIndex1 == null) System.out.println("image1 is null");
        if(imageIndex2 == null) System.out.println("image2 is null");
        String name1 = var.ChessPos[index1].getName();
        String name2 = var.ChessPos[index2].getName();

        int redOrBlue1 = var.ChessPos[index1].getRedOrBlue();
        int redOrBlue2 = var.ChessPos[index2].getRedOrBlue();

        var.ItemBox[index1].setImageDrawable(imageIndex2);
        var.ItemBox[index2].setImageDrawable(imageIndex1);

        var.ChessPos[index1].setName(name2);
        var.ChessPos[index2].setName(name1);
        var.ChessPos[index1].setRedOrBlue(redOrBlue2);
        var.ChessPos[index2].setRedOrBlue(redOrBlue1);
    }

    //按钮监听器
    MyButtonListener myButtonListener;

    public void setActionCallbak(BlueToothGameAty blueToothGameAty) {
        this.blueToothGameAty = blueToothGameAty;
    }

    private  BlueToothGameAty blueToothGameAty;


    //悔棋按钮
    Button huiqi;
    //刷新那妞
    Button refresh;



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
     * @param order
     */
    public void putChess(int x, int y, int order) {
        String temp = x + ":" + y;
        //通过回调方法通知Activity下棋动作
        blueToothGameAty.onPutChess(temp + ":" + order);
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
        }
        else if ((command.equals("WHITE"))) {

        } else if (command.equals("BLACK")) {

        } else {
            Log.d("whalea", "收到的指令:" + command);
            String[] temps = command.split(":");
            int a = Integer.parseInt(temps[0]);
            int b = Integer.parseInt(temps[1]);
            int c = Integer.parseInt(temps[2]);

            if (c == 0){
                ChangePosition(false, a, b);
            }
            else if (c == 1)
            {
                ChangePosition(true, a, b);
            }
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
