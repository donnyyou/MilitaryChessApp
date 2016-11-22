package com.donny.militarychessapp.action;

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
        Variable.redKeyToImage.put("˾��", "pic\\siling1.png");
        Variable.redKeyToImage.put("����", "pic\\junzhang1.png");
        Variable.redKeyToImage.put("ʦ��", "pic\\shizhang1.png");
        Variable.redKeyToImage.put("�ó�", "pic\\lvzhang1.png");
        Variable.redKeyToImage.put("�ų�", "pic\\tuanzhang1.png");
        Variable.redKeyToImage.put("Ӫ��", "pic\\yingzhang1.png");
        Variable.redKeyToImage.put("����", "pic\\lianzhang1.png");
        Variable.redKeyToImage.put("�ų�", "pic\\paizhang1.png");
        Variable.redKeyToImage.put("����", "pic\\gongbing1.png");
        Variable.redKeyToImage.put("����", "pic\\dilei1.png");
        Variable.redKeyToImage.put("ը��", "pic\\zhadan1.png");
        Variable.redKeyToImage.put("����", "pic\\junqi1.png");
        Variable.redKeyToImage.put("blank", "pic\\1.png");

        Variable.blueKeyToImage.put("˾��", "pic\\siling0.png");
        Variable.blueKeyToImage.put("����", "pic\\junzhang0.png");
        Variable.blueKeyToImage.put("ʦ��", "pic\\shizhang0.png");
        Variable.blueKeyToImage.put("�ó�", "pic\\lvzhang0.png");
        Variable.blueKeyToImage.put("�ų�", "pic\\tuanzhang0.png");
        Variable.blueKeyToImage.put("Ӫ��", "pic\\yingzhang0.png");
        Variable.blueKeyToImage.put("����", "pic\\lianzhang0.png");
        Variable.blueKeyToImage.put("�ų�", "pic\\paizhang0.png");
        Variable.blueKeyToImage.put("����", "pic\\gongbing0.png");
        Variable.blueKeyToImage.put("����", "pic\\dilei0.png");
        Variable.blueKeyToImage.put("ը��", "pic\\zhadan0.png");
        Variable.blueKeyToImage.put("����", "pic\\junqi0.png");
        Variable.blueKeyToImage.put("blank", "pic\\0.png");
    }//����ͼƬӳ��
	
	public static void initPosLimit()//���ӵ�λ�õ�limit
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
        Variable.ChessPos[59].setIsActive(false);//�ĸ���Ӫλ��,����Ҳ�ǲ�����  

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
