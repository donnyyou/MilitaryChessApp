package com.donny.militarychessapp.ai;


import com.donny.militarychessapp.action.Move;
import com.donny.militarychessapp.chess.Position;

public class ChessBoard {
	final int INFINITED = 888888888;
	public Position[] pos;
    public ChessBoard()
    {
        pos = new Position[61];
    }
    public int evaluate(int side)
    {
        int sum = 0;
        int sum2 = 0;
        for (int i = 1; i < 61; i++)
        {
            if (pos[i].getRedOrBlue() == side)
            {
                if (pos[i].getName() == "����")
                    sum += 5000;
                else if (pos[i].getName() == "ը��")
                    sum += 5000;
                else if (pos[i].getName() == "����")
                    sum += INFINITED;
                else if (pos[i].getName() == "����")
                    sum += 1000;
                else if (pos[i].getName() == "˾��")
                    sum += 50000;
                else if (pos[i].getName() == "����")
                    sum += 25000;
                else if (pos[i].getName() == "ʦ��")
                    sum += 5000;
                else if (pos[i].getName() == "�ó�")
                    sum += 2500;
                else if (pos[i].getName() == "�ų�")
                    sum += 500;
                else if (pos[i].getName() == "Ӫ��")
                    sum += 250;
                else if (pos[i].getName() == "����")
                    sum += 200;
                else if (pos[i].getName() == "�ų�")
                    sum += 100;
                else sum += 0;
            }
            else
            {
                if (pos[i].getName() == "����")
                    sum2 += 5000;
                else if (pos[i].getName() == "ը��")
                    sum2 += 5000;
                else if (pos[i].getName() == "����")
                    sum2 += INFINITED;
                else if (pos[i].getName() == "����")
                    sum2 += 1000;
                else if (pos[i].getName() == "˾��")
                    sum2 += 50000;
                else if (pos[i].getName() == "����")
                    sum2 += 25000;
                else if (pos[i].getName() == "ʦ��")
                    sum2 += 5000;
                else if (pos[i].getName() == "�ó�")
                    sum2 += 2500;
                else if (pos[i].getName() == "�ų�")
                    sum2 += 500;
                else if (pos[i].getName() == "Ӫ��")
                    sum2 += 250;
                else if (pos[i].getName() == "����")
                    sum2 += 200;
                else if (pos[i].getName() == "�ų�")
                    sum2 += 100;
                else sum2 += 0;
            }
        }
        return sum - sum2;
    }
    public Boolean isEnded()
    {
        if (!allCanMove(1) || !allCanMove(0)) return true;//��һ��û����
        Boolean flag = false;
        for (int i = 1; i < 61; i++)
        {
            if (pos[i].getRedOrBlue() == 1)
            {
                if (pos[i].getName() == "����")
                {
                    flag = true;
                    break;
                }
            }
        }
        if (!flag) return true;//һ��û�о���
        flag = false;
        for (int i = 1; i < 61; i++)
        {
            if (pos[i].getRedOrBlue() == 0)
            {
                if (pos[i].getName() == "����")
                {
                    flag = true;
                    break;
                }
            }
        }
        if (!flag) return true;
        return false;
    }
    public Boolean allCanMove(int side)
    {
        for (int i = 1; i < 61; i++)
        {
            if (pos[i].getIsActive() == false) continue;
            else if (pos[i].getRedOrBlue() != side) continue;
            else
            {
                int x = pos[i].getX();
                int y = pos[i].getY();
                if (x - 1 >= 0 && (pos[ActionByMode.Coordinary_To_Index(x - 1, y)].getName() == null || pos[ActionByMode.Coordinary_To_Index(x - 1, y)].getRedOrBlue() == (1 - side)))//λ������û�����ӻ����ǶԷ�������
                {
                    return true;
                }
                if (x + 1 <= 11 && (pos[ActionByMode.Coordinary_To_Index(x + 1, y)].getName() == null || pos[ActionByMode.Coordinary_To_Index(x + 1, y)].getRedOrBlue() == (1 - side)))
                {
                    return true;
                }
                if (y - 1 >= 0 && (pos[ActionByMode.Coordinary_To_Index(x, y - 1)].getName() == null || pos[ActionByMode.Coordinary_To_Index(x, y - 1)].getRedOrBlue() == (1 - side)))
                {
                    return true;
                }
                if (y + 1 <= 4 && (pos[ActionByMode.Coordinary_To_Index(x, y + 1)].getName() == null || pos[ActionByMode.Coordinary_To_Index(x, y + 1)].getRedOrBlue() == (1 - side)))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public ChessBoard nextMove(int from, int to)
    {
        ChessBoard iniPos = new ChessBoard();
        for (int i = 1; i < 61; i++)
        {
            iniPos.pos[i] = pos[i].Clone();
        }
        String name1 = iniPos.pos[from].getName();
        String name2 = iniPos.pos[to].getName();
        int redorblue1 = iniPos.pos[from].getRedOrBlue();
        //int redorblue2 = iniPos.pos[to].getRedOrBlue();
        //if (name2 == null) MessageBox.Show("nihao");
        int casenum = Move.fightResult(name1, name2);
        switch (casenum)
        {
            case 0:
                iniPos.pos[from].setName(null);
                iniPos.pos[to].setName(name1);
                iniPos.pos[to].setRedOrBlue(redorblue1);
                break;
            case 1:
                iniPos.pos[from].setName(null);
                break;
            case 2:
                iniPos.pos[from].setName(null);
                iniPos.pos[to].setName(name1);
                iniPos.pos[to].setRedOrBlue(redorblue1);
                break;
            case 3:
                iniPos.pos[from].setName(null);
                iniPos.pos[to].setName(null);
                break;
            case 4:
                iniPos.pos[from].setName(null);
                iniPos.pos[to].setName(name1);
                iniPos.pos[to].setRedOrBlue(redorblue1);
                break;
        }
        return iniPos;
    }
}