package com.donny.militarychessapp.action;

import android.graphics.drawable.Drawable;

import com.donny.militarychessapp.ai.ActionByMode;
import com.donny.militarychessapp.ai.ClassForBFS;
import com.donny.militarychessapp.chess.Position;
import com.donny.militarychessapp.var.Variable;

import java.util.ArrayList;
import java.util.List;



public class Move {

    public static boolean ChangePosition(boolean isstart, int index1, int index2)
    {
        if (!isstart)
        {
            if (Variable.ChessPos[index1].getRedOrBlue() == Variable.ChessPos[index2].getRedOrBlue() && CanMove(isstart, index1, index2))
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
                if (Variable.GameMode == 2)
                {
                    //netsystem.MoveDone(index1, index2);
                }
                Variable.controlBelong = !Variable.controlBelong;
                fightStatus(index1, index2);
                return true;
            }
            else
                return false;
        }
    }
    public static boolean CanMove(boolean isstart, int index1, int index2)
    {
        if (!isstart)
            return canMoveBeforeStart(index1, index2);
        else
            return canMoveAfterStart(Variable.ChessPos,index1, index2);
    }
    public static boolean canMoveBeforeStart(int index1, int index2)
    {
        if ((index1 > 30 && index2 < 31) || (index1 < 31 && index2 > 30)) return false;
        if (Variable.ChessPos[index1].getName() == "junqi" && Variable.ChessPos[index2].getIsActive()) return false;
        if (Variable.ChessPos[index2].getName() == "junqi" && Variable.ChessPos[index1].getIsActive()) return false;
        if (Variable.ChessPos[index1].getName() == "zhadan" && !Variable.ChessPos[index2].getCanSetZhadan()) return false;
        if (Variable.ChessPos[index2].getName() == "zhadan" && !Variable.ChessPos[index1].getCanSetZhadan()) return false;
        if (Variable.ChessPos[index1].getName() == "dilei" && !Variable.ChessPos[index2].getCanSetDilei()) return false;
        if (Variable.ChessPos[index2].getName() == "dilei" && !Variable.ChessPos[index1].getCanSetDilei()) return false;
        return true;
    }
    public static boolean canMoveAfterStart(Position[] pos, int index1, int index2)
    {
        if (index1 == index2) return false;
        if (pos[index1].getName() == "junqi" || pos[index1].getName() == "dilei") return false;
        if (!pos[index1].getIsActive()) return false;
        if (pos[index2].getIsXingying() && Variable.ItemBox[index2].getDrawable() != null) return false;//Ŀ���Ƿ�����Ӫ��
        if (pos[index1].getRedOrBlue() == pos[index2].getRedOrBlue() && pos[index2].getName() != null) return false;//�Ƿ��Ƕ���?
        if (!(pos[index1].getIsOnTheRoad() && pos[index2].getIsOnTheRoad()))
        {
            return ClassForBFS.isNeighbor(pos, index1, index2);
        }
        if (pos[index1].getIsOnTheRoad() && pos[index2].getIsOnTheRoad() &&
                pos[index1].getName() != null && pos[index1].getName() != "gongbing")
        {
            return ClassForBFS.BFS1(pos, index1, index2);
        }
        if (pos[index1].getIsOnTheRoad() && pos[index2].getIsOnTheRoad() &&
                pos[index1].getName() != null && pos[index1].getName() == "gongbing")
        {
            return ClassForBFS.BFS2(pos, index1, index2);
        }
        return true;
    }
    public static void changeStatus(int index1, int index2)
    {
        Drawable imageIndex1 = Variable.ItemBox[index1].getDrawable();
        Drawable imageIndex2 = Variable.ItemBox[index2].getDrawable();
        if(imageIndex1 == null) System.out.println("image1 is null");
        if(imageIndex2 == null) System.out.println("image2 is null");
        String name1 = Variable.ChessPos[index1].getName();
        String name2 = Variable.ChessPos[index2].getName();

        int redOrBlue1 = Variable.ChessPos[index1].getRedOrBlue();
        int redOrBlue2 = Variable.ChessPos[index2].getRedOrBlue();

        Variable.ItemBox[index1].setImageDrawable(imageIndex2);
        Variable.ItemBox[index2].setImageDrawable(imageIndex1);

        Variable.ChessPos[index1].setName(name2);
        Variable.ChessPos[index2].setName(name1);
        Variable.ChessPos[index1].setRedOrBlue(redOrBlue2);
        Variable.ChessPos[index2].setRedOrBlue(redOrBlue1);
    }
    public static void fightStatus(int index1, int index2)
    {
        if (Variable.ChessPos[index1].getRedOrBlue() == 2) return;
        Drawable imageIndex1 = Variable.ItemBox[index1].getDrawable();
        //Icon imageIndex2 = Variable.ItemBox[index2].getIcon();
        String name1 = Variable.ChessPos[index1].getName();
        String name2 = Variable.ChessPos[index2].getName();
        int redorblue1 = Variable.ChessPos[index1].getRedOrBlue();
        //int redorblue2 = Variable.ChessPos[index2].getRedOrBlue();
        //if (name2 == null) MessageBox.Show("nihao");
        int casenum = fightResult(name1, name2);
        if (Variable.ChessPos[index1].getIsOnTheRoad() && Variable.ChessPos[index2].getIsOnTheRoad())
        {
            List<Position> PList = ActionByMode.GetPathList(index1, index2);
            Variable.posList = (ArrayList<Position>) PList;
            new Thread()
            {
                public void run()
                {
                    for (int i = 0; i < Variable.posList.size() - 2; i++)
                    {
                        try {
                            sleep(20);
                            PlaySound.play("mov");
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        changeStatus(ActionByMode.Coordinary_To_Index(Variable.posList.get(i).getX(), Variable.posList.get(i).getY()), ActionByMode.Coordinary_To_Index(Variable.posList.get(i+1).getX(), Variable.posList.get(i+1).getY()));
                        //PlaySound.Play(@"wav\\MOVE.WAV");

                    }
                    Variable.ChessPos[ActionByMode.Coordinary_To_Index(Variable.posList.get(Variable.posList.size() - 2).getX(), Variable.posList.get(Variable.posList.size() - 2).getY())].setRedOrBlue(2);
                    Variable.ChessPos[ActionByMode.Coordinary_To_Index(Variable.posList.get(Variable.posList.size() - 2).getX(), Variable.posList.get(Variable.posList.size() - 2).getY())].setName(null);
                    Variable.ItemBox[ActionByMode.Coordinary_To_Index(Variable.posList.get(Variable.posList.size() - 2).getX(), Variable.posList.get(Variable.posList.size() - 2).getY())].setImageDrawable(null);
                }
            }.start();
        }
        else
        {
            Variable.ChessPos[index1].setRedOrBlue(2);
            Variable.ChessPos[index1].setName(null);
            Variable.ItemBox[index1].setImageDrawable(null);
        }
        //move end
        switch (casenum)
        {
            case 0:
                Variable.ItemBox[index2].setImageDrawable(imageIndex1);
                Variable.ChessPos[index2].setName(name1);
                Variable.ChessPos[index2].setRedOrBlue(redorblue1);
                PlaySound.play("mov");
                break;
            case 1:
                PlaySound.play("junqisldie");
                break;
            case 2:
                Variable.ItemBox[index2].setImageDrawable(imageIndex1);
                Variable.ChessPos[index2].setName(name1);
                Variable.ChessPos[index2].setRedOrBlue(redorblue1);
                PlaySound.play("junqieat");
                break;
            case 3:
                Variable.ItemBox[index2].setImageDrawable(null);
                Variable.ChessPos[index2].setName(null);;
                Variable.ChessPos[index2].setRedOrBlue(2);
                PlaySound.play("junqitongqu");
                break;
            case 4:
                Variable.ItemBox[index2].setImageDrawable(imageIndex1);
                Variable.ChessPos[index2].setName(name1);
                Variable.ChessPos[index2].setRedOrBlue(redorblue1);
                PlaySound.play("win");

                Variable.isEnd = true;
                // initChess();,
                break;
        }
    }
    public static int fightResult(String str1, String str2)
    {
        if (str2 == null) return 0;
        if (str1 == "zhadan" || str2 == "zhadan" || str1 == str2) return 3;
        if (str2 == "junqi") return 4;
        if (comparePower(str1, str2))
            return 2;
        else
            return 1;
    }
    public static boolean comparePower(String str1, String str2)
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
}
