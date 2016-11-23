package com.donny.militarychessapp.action;

import com.donny.militarychessapp.R;
import com.donny.militarychessapp.chess.Position;
import com.donny.militarychessapp.var.Variable;

public class InitAll {
	
	public static void initall()
	{
		keyToImage();
		initPosLimit();
	}
	
	public static void keyToImage()
    {
        Variable.redKeyToImage.put("siling", R.drawable.siling1);
        Variable.redKeyToImage.put("junzhang", R.drawable.junzhang1);
        Variable.redKeyToImage.put("shizhang", R.drawable.shizhang1);
        Variable.redKeyToImage.put("lvzhang", R.drawable.lvzhang1);
        Variable.redKeyToImage.put("tuanzhang", R.drawable.tuanzhang1);
        Variable.redKeyToImage.put("yingzhang", R.drawable.yingzhang1);
        Variable.redKeyToImage.put("lianzhang", R.drawable.lianzhang1);
        Variable.redKeyToImage.put("paizhang", R.drawable.paizhang1);
        Variable.redKeyToImage.put("gongbing", R.drawable.gongbing1);
        Variable.redKeyToImage.put("dilei", R.drawable.dilei1);
        Variable.redKeyToImage.put("zhadan", R.drawable.zhadan1);
        Variable.redKeyToImage.put("junqi", R.drawable.junqi1);
        Variable.redKeyToImage.put("blank", R.drawable.blank1);

        Variable.blueKeyToImage.put("siling", R.drawable.siling0);
        Variable.blueKeyToImage.put("junzhang", R.drawable.junzhang0);
        Variable.blueKeyToImage.put("shizhang", R.drawable.shizhang0);
        Variable.blueKeyToImage.put("lvzhang", R.drawable.lvzhang0);
        Variable.blueKeyToImage.put("tuanzhang", R.drawable.tuanzhang0);
        Variable.blueKeyToImage.put("yingzhang", R.drawable.yingzhang0);
        Variable.blueKeyToImage.put("lianzhang", R.drawable.lianzhang0);
        Variable.blueKeyToImage.put("paizhang", R.drawable.paizhang0);
        Variable.blueKeyToImage.put("gongbing", R.drawable.gongbing0);
        Variable.blueKeyToImage.put("dilei", R.drawable.dilei0);
        Variable.blueKeyToImage.put("zhadan", R.drawable.zhadan0);
        Variable.blueKeyToImage.put("junqi", R.drawable.junqi0);
        Variable.blueKeyToImage.put("blank", R.drawable.blank0);
    }

    public static void initPosLimit()//pos limit
    {
        int posId = 1;
        for (int i=0; i < 12; i++)
        for (int j = 0; j < 5; j++)
        {
            Variable.ChessPos[posId] = new Position(posId, i, j);
            if (posId < 31)
                Variable.ChessPos[posId].setRedOrBlue(0);
            else
                Variable.ChessPos[posId].setRedOrBlue(1);
            if (i == 0 || i == 1 || i == 10 || i == 11)
                Variable.ChessPos[posId].setCanSetDilei(true);
            if (i == 5 || i == 6)
                Variable.ChessPos[posId].setCanSetZhadan(false);
            posId++;
        }
        Variable.ChessPos[2].setIsActive(false);
        Variable.ChessPos[4].setIsActive(false);
        Variable.ChessPos[57].setIsActive(false);
        Variable.ChessPos[59].setIsActive(false);

        Variable.ChessPos[12].setIsXingying(true);
        Variable.ChessPos[12].setRedOrBlue(2); //there is nothing
        Variable.ChessPos[14].setIsXingying(true);
        Variable.ChessPos[14].setRedOrBlue(2);
        Variable.ChessPos[18].setIsXingying(true);
        Variable.ChessPos[18].setRedOrBlue(2);
        Variable.ChessPos[22].setIsXingying(true);
        Variable.ChessPos[22].setRedOrBlue(2);
        Variable.ChessPos[24].setIsXingying(true);
        Variable.ChessPos[24].setRedOrBlue(2);
        Variable.ChessPos[37].setIsXingying(true);
        Variable.ChessPos[37].setRedOrBlue(2);
        Variable.ChessPos[39].setIsXingying(true);
        Variable.ChessPos[39].setRedOrBlue(2);
        Variable.ChessPos[43].setIsXingying(true);
        Variable.ChessPos[43].setRedOrBlue(2);
        Variable.ChessPos[47].setIsXingying(true);
        Variable.ChessPos[47].setRedOrBlue(2);
        Variable.ChessPos[49].setIsXingying(true);
        Variable.ChessPos[49].setRedOrBlue(2);
        for (int i = 1; i <= 60; i++)
        {
            if (Variable.ChessPos[i].getX() == 1 || Variable.ChessPos[i].getX() == 5 || Variable.ChessPos[i].getX() == 6 || Variable.ChessPos[i].getX() == 10)
            {
                Variable.ChessPos[i].setIsOnTheRoad(true);
                continue;
            }
            if (Variable.ChessPos[i].getY() == 0 || Variable.ChessPos[i].getY() == 4)
            {
                if (Variable.ChessPos[i].getX() != 0 && Variable.ChessPos[i].getX() != 11)
                {
                    Variable.ChessPos[i].setIsOnTheRoad(true);
                    continue;
                }
            }
        }
    }
}
