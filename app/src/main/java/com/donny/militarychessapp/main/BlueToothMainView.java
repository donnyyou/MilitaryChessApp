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


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BlueToothMainView extends RelativeLayout implements View.OnClickListener {

    private Variable var = new Variable();
    private  BlueToothGameAty blueToothGameAty;

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
            int boxId = Integer.parseInt(v.getTag().toString());

            Drawable icon = var.ItemBox[boxId].getDrawable();

            if (var.isStart)
            {
                if (icon == null) return;
                if (var.controlBelong)
                {
                    var.isClicked = true;
                    var.clickIndex1 = boxId;
                    var.iconIndex1 = icon;
                }
                else
                {
                    var.isClicked = false;
                    return;
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

            if (var.isStart)
            {
                putChess(var.clickIndex1, var.clickIndex2, 1);
            }
            else
            {
                putChess(var.clickIndex1, var.clickIndex2, 0);
            }
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
                //var.controlBelong = !var.controlBelong;
                fightStatus(index1, index2);
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
        else
            return canMoveAfterStart(var.ChessPos,index1, index2);
    }
    public boolean canMoveAfterStart(Position[] pos, int index1, int index2)
    {
        if (index1 == index2) return false;
        if (pos[index1].getName() == "junqi" || pos[index1].getName() == "dilei") return false;
        if (!pos[index1].getIsActive()) return false;
        if (pos[index2].getIsXingying() && var.ItemBox[index2].getDrawable() != null) return false;//Ŀ���Ƿ�����Ӫ��
        if (pos[index1].getRedOrBlue() == pos[index2].getRedOrBlue() && pos[index2].getName() != null) return false;//�Ƿ��Ƕ���?
        if (!(pos[index1].getIsOnTheRoad() && pos[index2].getIsOnTheRoad()))
        {
            return isNeighbor(pos, index1, index2);
        }
        if (pos[index1].getIsOnTheRoad() && pos[index2].getIsOnTheRoad() &&
                pos[index1].getName() != null && pos[index1].getName() != "gongbing")
        {
            return BFS1(pos, index1, index2);
        }
        if (pos[index1].getIsOnTheRoad() && pos[index2].getIsOnTheRoad() &&
                pos[index1].getName() != null && pos[index1].getName() == "gongbing")
        {
            return BFS2(pos, index1, index2);
        }
        return true;
    }

    public boolean isNeighbor(Position[] pos, int fromI, int toI)
    {
        if (pos[fromI].getIsXingying() == true || pos[toI].getIsXingying() == true)
        {
            if (Math.abs(pos[fromI].getX() - pos[toI].getX()) <= 1 && Math.abs(pos[fromI].getY() - pos[toI].getY()) <= 1) return true;
            else return false;
        }
        else if (Math.abs(pos[fromI].getX() - pos[toI].getX()) == 1 && Math.abs(pos[fromI].getY() - pos[toI].getY()) == 0) return true;
        else if (Math.abs(pos[fromI].getY() - pos[toI].getY()) == 1 && Math.abs(pos[fromI].getX() - pos[toI].getX()) == 0) return true;
        else return false;
    }
    public boolean BFS1(Position[] pos, int fromI, int ToI)
    {
        if (pos[fromI].getIsOnTheRoad() && pos[ToI].getIsOnTheRoad())
        {
            int fX, tX, fY, tY;
            fX = pos[fromI].getX();
            fY = pos[fromI].getY();
            tX = pos[ToI].getX();
            tY = pos[ToI].getY();
            if (pos[Coordinary_To_Index(fX, fY)].getRedOrBlue() == pos[Coordinary_To_Index(tX, tY)].getRedOrBlue()) return false;
            if (fX == tX)
            {
                int step = fY > tY ? -1 : 1;
                for (int i = fY + step; i != tY; i += step)
                {
                    if (pos[Coordinary_To_Index(fX, i)].getName() != null) return false;
                    else if (pos[Coordinary_To_Index(fX, i)].getRedOrBlue() == pos[Coordinary_To_Index(fX, fY)].getRedOrBlue()) return false;
                }
                return true;
            }
            else if (fY == tY)
            {
                if ((fY == 1 || fY == 3) && (fX <= 5 || fX >= 6)) return false;
                int step = fX > tX ? -1 : 1;
                for (int i = fX + step; i != tX; i += step)
                {
                    if (pos[Coordinary_To_Index(i, fY)].getName() != null) return false;
                    else if (pos[Coordinary_To_Index(i, fY)].getRedOrBlue() == pos[Coordinary_To_Index(fX, fY)].getRedOrBlue()) return false;
                }
                return true;
            }
            else return false;
        }
        return false;
    }
    public boolean BFS2(Position[] pos, int fromI, int toI)
    {
        if (pos[fromI].getIsOnTheRoad() && pos[toI].getIsOnTheRoad())
        {
            boolean[][] isVisited = new boolean[12][5];
            for (int i = 0; i < 12; i++)
                for (int j = 0; j < 5; j++) isVisited[i][j] = false;
            Queue<Position> que = new LinkedList<Position>();
            que.offer(pos[fromI]);
            isVisited[pos[fromI].getX()][pos[fromI].getY()] = true;
            while (que.size() != 0)
            {
                Position P = que.poll();
                if (Coordinary_To_Index(P.getX(), P.getY()) == toI) return true;
                if (P.getX() - 1 >= 0 &&
                        (
                                (pos[Coordinary_To_Index(P.getX() - 1, P.getY())].getName() == null &&
                                        pos[Coordinary_To_Index(P.getX() - 1, P.getY())].getIsOnTheRoad() == true &&
                                        isVisited[P.getX() - 1][P.getY()] == false) ||
                                        Coordinary_To_Index(P.getX() - 1, P.getY()) == toI
                        )
                        )
                {
                    if (!(P.getX() == 6 && (P.getY() == 1 || P.getY() == 3)))
                    {
                        isVisited[P.getX() - 1][P.getY()] = true;
                        que.offer(pos[Coordinary_To_Index(P.getX() - 1, P.getY())]);
                    }
                }
                if (P.getX() + 1 <= 11 &&
                        (
                                (pos[Coordinary_To_Index(P.getX() + 1, P.getY())].getName() == null &&
                                        pos[Coordinary_To_Index(P.getX() + 1, P.getY())].getIsOnTheRoad() == true &&
                                        isVisited[P.getX() + 1][P.getY()] == false) ||
                                        Coordinary_To_Index(P.getX() + 1, P.getY()) == toI
                        )
                        )
                {
                    if (!(P.getX() == 5 && (P.getY() == 1 || P.getY() == 3)))
                    {
                        isVisited[P.getX() + 1][P.getY()] = true;
                        que.offer(pos[Coordinary_To_Index(P.getX() + 1, P.getY())]);
                    }
                }
                if (P.getY() - 1 >= 0 &&
                        (
                                (
                                        pos[Coordinary_To_Index(P.getX(), P.getY() - 1)].getName() == null &&
                                                pos[Coordinary_To_Index(P.getX(), P.getY() - 1)].getIsOnTheRoad() == true &&
                                                isVisited[P.getX()][P.getY() - 1] == false) ||
                                        Coordinary_To_Index(P.getX(), P.getY() - 1) == toI
                        )
                        )
                {
                    isVisited[P.getX()][P.getY() - 1] = true;
                    que.offer(pos[Coordinary_To_Index(P.getX(), P.getY() - 1)]);
                }
                if (P.getY() + 1 <= 4 &&
                        (
                                (pos[Coordinary_To_Index(P.getX(), P.getY() + 1)].getName() == null &&
                                        pos[Coordinary_To_Index(P.getX(), P.getY() + 1)].getIsOnTheRoad() == true &&
                                        isVisited[P.getX()][P.getY() + 1] == false) ||
                                        Coordinary_To_Index(P.getX(), P.getY() + 1) == toI
                        )
                        )
                {
                    isVisited[P.getX()][P.getY() + 1] = true;
                    que.offer(pos[Coordinary_To_Index(P.getX(), P.getY() + 1)]);
                }
            }
            return false;
        }
        else return false;
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

    public void setActionCallbak(BlueToothGameAty blueToothGameAty) {
        this.blueToothGameAty = blueToothGameAty;
    }

    public void adjust(){
        PleaseAdjust();
        var.controlBelong = false;
    }
    public void PleaseAdjust()
    {
        //MessageBox.Show("请调整布局");
        for (int i = 31; i < 61; i++)
        {
            if (i == 37 || i == 39 || i == 43 || i == 47 || i == 49) continue;
            //var.ItemBox[i].setImageResource(var.redKeyToImage.get("blank"));
        }
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 5; j++)
            {
                int from = i * 5 + j + 1;
                int to = (11 - i) * 5 + j + 1;
                Drawable fromImage = var.ItemBox[from].getDrawable();

                var.ItemBox[from].setImageDrawable(var.ItemBox[to].getDrawable());
                var.ItemBox[to].setImageDrawable(fromImage);
                String name = var.ChessPos[from].getName();
                var.ChessPos[from].setName(var.ChessPos[to].getName());
                var.ChessPos[to].setName(name);
                int redorblue = var.ChessPos[from].getRedOrBlue();
                var.ChessPos[from].setRedOrBlue(var.ChessPos[to].getRedOrBlue());
                var.ChessPos[to].setRedOrBlue(redorblue);
            }
        //请让用户调整布局
        //调整完布局请调用netsystem.AdjustDone(string chessboard)，参数是把己方棋盘存成字符串
    }//联机对战调整布局


    /**
     * @param x
     * @param y
     * @param order
     */
    public void putChess(int x, int y, int order) {
        String temp = x + ":" + y;
        //通过回调方法通知Activity下棋动作
        if(order == 1) {
            var.controlBelong = !var.controlBelong;
        }
        blueToothGameAty.onPutChess(temp + ":" + order);
    }

    //收到对方传来的棋子
    public void xiaqi(String command) {
        if ((command==null)) {
            return;
        }
        if ((command.equals("HUIQI"))) {
            //if (storageArray.size()==0) {
                //Toast.makeText(getContext(),"开局并不能悔棋",Toast.LENGTH_SHORT).show();
            //}else {

            //}
        }
        else if ((command.equals("WHITE"))) {

        } else if (command.equals("BLACK")) {

        } else {
            Log.d("whalea", "收到的指令:" + command);
            String[] temps = command.split(":");
            int old = Integer.parseInt(temps[0]);
            int now = Integer.parseInt(temps[1]);
            int order = Integer.parseInt(temps[2]);
            int i = (old - 1) / 5;
            int j = (old - 1) % 5;
            int from = (11 - i) * 5 + j + 1;
            int ii = (now - 1) / 5;
            int jj = (now - 1) % 5;
            int to = (11 - ii) * 5 + jj + 1;

            if (order == 0){
                ChangePosition(false, from, to);
            }
            else if (order == 1)
            {
                var.controlBelong = !var.controlBelong;
                ChangePosition(true, from, to);
                CheckSiLing();
            }
        }
    }

    public void fightStatus(int index1, int index2)
    {
        if (var.ChessPos[index1].getRedOrBlue() == 2) return;
        Drawable imageIndex1 = var.ItemBox[index1].getDrawable();
        //Icon imageIndex2 = Variable.ItemBox[index2].getIcon();
        String name1 = var.ChessPos[index1].getName();
        String name2 = var.ChessPos[index2].getName();
        int redorblue1 = var.ChessPos[index1].getRedOrBlue();
        //int redorblue2 = var.ChessPos[index2].getRedOrBlue();
        //if (name2 == null) MessageBox.Show("nihao");
        int casenum = fightResult(name1, name2);
        if (var.ChessPos[index1].getIsOnTheRoad() && var.ChessPos[index2].getIsOnTheRoad())
        {
            List<Position> PList = GetPathList(index1, index2);
            var.posList = (ArrayList<Position>) PList;

            for (int i = 0; i < var.posList.size() - 2; i++)
            {
                //PlaySound.play("mov");

                changeStatus(Coordinary_To_Index(var.posList.get(i).getX(), var.posList.get(i).getY()), Coordinary_To_Index(var.posList.get(i+1).getX(), var.posList.get(i+1).getY()));
                //PlaySound.Play(@"wav\\MOVE.WAV");
            }
            var.ChessPos[Coordinary_To_Index(var.posList.get(var.posList.size() - 2).getX(), var.posList.get(var.posList.size() - 2).getY())].setRedOrBlue(2);
            var.ChessPos[Coordinary_To_Index(var.posList.get(var.posList.size() - 2).getX(), var.posList.get(var.posList.size() - 2).getY())].setName(null);
            var.ItemBox[Coordinary_To_Index(var.posList.get(var.posList.size() - 2).getX(), var.posList.get(var.posList.size() - 2).getY())].setImageDrawable(null);
        }
        else
        {
            var.ChessPos[index1].setRedOrBlue(2);
            var.ChessPos[index1].setName(null);
            var.ItemBox[index1].setImageDrawable(null);
        }
        //move end
        switch (casenum)
        {
            case 0:
                var.ItemBox[index2].setImageDrawable(imageIndex1);
                var.ChessPos[index2].setName(name1);
                var.ChessPos[index2].setRedOrBlue(redorblue1);
//                PlaySound.play("mov");
                break;
            case 1:
                //PlaySound.play("junqisldie");
                break;
            case 2:
                var.ItemBox[index2].setImageDrawable(imageIndex1);
                var.ChessPos[index2].setName(name1);
                var.ChessPos[index2].setRedOrBlue(redorblue1);
                //              PlaySound.play("junqieat");
                break;
            case 3:
                var.ItemBox[index2].setImageDrawable(null);
                var.ChessPos[index2].setName(null);;
                var.ChessPos[index2].setRedOrBlue(2);
                //              PlaySound.play("junqitongqu");
                break;
            case 4:
                var.ItemBox[index2].setImageDrawable(imageIndex1);
                var.ChessPos[index2].setName(name1);
                var.ChessPos[index2].setRedOrBlue(redorblue1);
                //               PlaySound.play("win");

                var.isEnd = true;
                // initChess();,
                break;
        }
    }

    public int fightResult(String str1, String str2)
    {
        if (str2 == null) return 0;
        if (str1 == "zhadan" || str2 == "zhadan" || str1 == str2) return 3;
        if (str2 == "junqi") return 4;
        if (comparePower(str1, str2))
            return 2;
        else
            return 1;
    }
    public boolean comparePower(String str1, String str2)
    {
        String temp = str1;
        switch (temp)
        {
            case "siling":
                if (str2 == "junqi" || str2 == "junzhang" || str2 == "shizhang" || str2 == "lvzhang" || str2 == "tuanzhang" || str2 == "yingzhang" || str2 == "lianzhang" || str2 == "paizhang" || str2 == "gongbing") return true;
                else return false;
            case "junzhang":
                if (str2 == "junqi" || str2 == "shizhang" || str2 == "lvzhang" || str2 == "tuanzhang" || str2 == "yingzhang" || str2 == "lianzhang" || str2 == "paizhang" || str2 == "gongbing") return true;
                else return false;
            case "shizhang":
                if (str2 == "junqi" || str2 == "lvzhang" || str2 == "tuanzhang" || str2 == "yingzhang" || str2 == "lianzhang" || str2 == "paizhang" || str2 == "gongbing") return true;
                else return false;
            case "lvzhang":
                if (str2 == "junqi" || str2 == "tuanzhang" || str2 == "yingzhang" || str2 == "lianzhang" || str2 == "paizhang" || str2 == "gongbing") return true;
                else return false;
            case "tuanzhang":
                if (str2 == "junqi" || str2 == "yingzhang" || str2 == "lianzhang" || str2 == "paizhang" || str2 == "gongbing") return true;
                else return false;
            case "yingzhang":
                if (str2 == "junqi" || str2 == "lianzhang" || str2 == "paizhang" || str2 == "gongbing") return true;
                else return false;
            case "lianzhang":
                if (str2 == "junqi" || str2 == "paizhang" || str2 == "gongbing") return true;
                else return false;
            case "paizhang":
                if (str2 == "junqi" || str2 == "gongbing") return true;
                else return false;
            case "gongbing":
                if (str2 == "junqi" || str2 == "dilei") return true;
                else return false;
            default:
                System.out.println("comparePower");
                return false;
        }
    }

    public int Coordinary_To_Index(int x, int y)
    {
        return x * 5 + y + 1;
    }

    public void CheckSiLing()
    {
        if (!var.isEnd)
        {
            boolean flag = false;
            for (int i = 1; i < 61; i++)
            {
                if (var.ChessPos[i].getRedOrBlue() != 0) continue;
                if (var.ChessPos[i].getName() == "siling")
                {
                    flag = true;
                    break;
                }
            }
            if (!flag)
            {
                /* for (int i = 1; i < 61; i++)
                 {
                     if(Variable.ChessPos[i].getRedOrBlue()==blank0&&Variable.ChessPos[i].Name=="����")
                     {
                         this.pictureBox20.BackgroundImage = Image.FromFile(Variable.redKeyToImage["����"]);
                         break;
                     }
                 }*/
                if (var.ChessPos[2].getRedOrBlue() == 0&&var.ChessPos[2].getName()=="junqi")
                {
                    var.ItemBox[2].setImageResource(var.blueKeyToImage.get("junqi"));
                }

                else if(var.ChessPos[59].getName()=="junqi")
                {
                    var.ItemBox[59].setImageResource(var.blueKeyToImage.get("junqi"));
                }

            }
            flag = false;
            for (int i = 1; i < 61; i++)
            {
                if (var.ChessPos[i].getRedOrBlue() != 1) continue;
                if (var.ChessPos[i].getName() == "siling")
                {
                    flag = true;
                    break;
                }
            }
            if (!flag)
            {
                if (var.ChessPos[59].getRedOrBlue() == 1 && var.ChessPos[59].getName() == "junqi")
                {
                    var.ItemBox[59].setImageResource(var.redKeyToImage.get("junqi"));
                }
                else if(var.ChessPos[2].getName()=="junqi")
                {
                    var.ItemBox[2].setImageResource(var.redKeyToImage.get("junqi"));
                }

            }
        }
    }
    public void DFS(List<Position> PList, int deepth, int from, int to, boolean[][] isVisited)
    {
        if (var.forDFS == true) return;
        Position tmpP = PList.get(deepth);
        int tmpX = tmpP.getX();
        int tmpY = tmpP.getY();
        if (tmpP == var.ChessPos[to])
        {
            var.forDFS = true;
            return;
        }
        boolean[][] isVisitedCopied = new boolean[12][5];
        for (int i = 0; i < 12; i++)
            for (int j = 0; j < 5; j++)
            {
                isVisitedCopied[i][j] = isVisited[i][j];
            }
        isVisitedCopied[tmpX][tmpY] = true;
        if (tmpX - 1 >= 0 &&
                (
                        (var.ChessPos[Coordinary_To_Index(tmpX - 1, tmpY)].getName() == null &&
                                var.ChessPos[Coordinary_To_Index(tmpX - 1, tmpY)].getIsOnTheRoad() == true &&
                                isVisitedCopied[tmpX - 1][tmpY] == false) ||
                                Coordinary_To_Index(tmpX - 1, tmpY) == to
                )
                )
        {
            if (!(tmpX == 6 && (tmpY == 1 || tmpY == 3)))
            {
                //isVisited[tmpX - 1, tmpY] = true;
                PList.add(var.ChessPos[Coordinary_To_Index(tmpX - 1, tmpY)]);
                DFS(PList, deepth + 1, from, to, isVisitedCopied);
                isVisitedCopied[tmpX - 1][tmpY] = true;
            }
        }
        if (var.forDFS == true) return;
        if (tmpX + 1 <= 11 &&
                (
                        (var.ChessPos[Coordinary_To_Index(tmpX + 1, tmpY)].getName() == null &&
                                var.ChessPos[Coordinary_To_Index(tmpX + 1, tmpY)].getIsOnTheRoad() == true &&
                                isVisitedCopied[tmpX + 1][tmpY] == false) ||
                                Coordinary_To_Index(tmpX + 1, tmpY) == to
                )
                )
        {
            if (!(tmpX == 5 && (tmpY == 1 || tmpY == 3)))
            {
                PList.add(var.ChessPos[Coordinary_To_Index(tmpX + 1, tmpY)]);
                DFS(PList, deepth + 1, from, to, isVisitedCopied);
                isVisitedCopied[tmpX + 1][tmpY] = true;
            }
        }
        if (var.forDFS == true) return;
        if (tmpY - 1 >= 0 &&
                (
                        (
                                var.ChessPos[Coordinary_To_Index(tmpX, tmpY - 1)].getName() == null &&
                                        var.ChessPos[Coordinary_To_Index(tmpX, tmpY - 1)].getIsOnTheRoad() == true &&
                                        isVisitedCopied[tmpX][tmpY - 1] == false) ||
                                Coordinary_To_Index(tmpX, tmpY - 1) == to
                )
                )
        {
            PList.add(var.ChessPos[Coordinary_To_Index(tmpX, tmpY - 1)]);
            DFS(PList, deepth + 1, from, to, isVisitedCopied);
            isVisitedCopied[tmpX][tmpY - 1] = true;
        }
        if (var.forDFS == true) return;
        if (tmpY + 1 <= 4 &&
                (
                        (var.ChessPos[Coordinary_To_Index(tmpX, tmpY + 1)].getName() == null &&
                                var.ChessPos[Coordinary_To_Index(tmpX, tmpY + 1)].getIsOnTheRoad() == true &&
                                isVisitedCopied[tmpX][tmpY + 1] == false) ||
                                Coordinary_To_Index(tmpX, tmpY + 1) == to
                )
                )
        {
            PList.add(var.ChessPos[Coordinary_To_Index(tmpX, tmpY + 1)]);
            DFS(PList, deepth + 1, from, to, isVisitedCopied);
            isVisitedCopied[tmpX][tmpY + 1] = true;
        }
        if (var.forDFS == true) return;
        PList.remove(PList.get(deepth));
    }

    public List<Position> GetPathList(int index1, int index2)
    {
        List<Position> PL = new ArrayList<Position>();
        if (var.ChessPos[index1].getName() != "gongbing")
        {
            int fX, tX, fY, tY;
            fX = var.ChessPos[index1].getX();
            fY = var.ChessPos[index1].getY();
            tX = var.ChessPos[index2].getX();
            tY = var.ChessPos[index2].getY();
            if (fX == tX)
            {
                int step = fY > tY ? -1 : 1;
                for (int i = fY; i != tY + step; i += step)
                {
                    PL.add(var.ChessPos[Coordinary_To_Index(fX, i)]);
                }
            }
            else
            {
                int step = fX > tX ? -1 : 1;
                for (int i = fX; i != tX + step; i += step)
                {
                    PL.add(var.ChessPos[Coordinary_To_Index(i, fY)]);
                }
            }
        }
        else
        {
            var.forDFS = false;
            boolean[][] isVisited = new boolean[12][5];
            for (int i = 0; i < 12; i++)
                for (int j = 0; j < 5; j++)
                    isVisited[i][j] = false;
            PL.add(var.ChessPos[index1]);
            DFS(PL, 0, index1, index2, isVisited);
        }
        return PL;
    }

    public interface BlueToothActionListner {
        void  onPutChess(String temp);
        void onBtnPress(int i); //0悔棋  1刷新
    }
}
