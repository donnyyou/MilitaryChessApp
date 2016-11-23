package com.donny.militarychessapp.ai;

import com.donny.militarychessapp.action.Move;
import com.donny.militarychessapp.var.Variable;
import com.donny.militarychessapp.chess.Position;

import java.util.ArrayList;
import java.util.List;



public class ActionByMode {
	final static int INFINITED = 888888888;
    
   
    public static void ActionMode(int mode)
    {
        if (mode == 0) return;
        else if (mode == 1)
        {
            ChessBoard initBoard = new ChessBoard();
            for (int i = 1; i < 61; i++)
            {
                if (Variable.ChessPos[i] != null)
                    initBoard.pos[i] = Variable.ChessPos[i].Clone();
            }
            TotalValue resultValue = alphaBeta(initBoard, Variable.searchDeepth, Variable.controlBelong == false ? 0 : 1, -INFINITED, INFINITED);
            Move.ChangePosition(Variable.isStart, resultValue.value_From, resultValue.value_To);
        }
        else if (mode == 2) { }
    }
    public static TotalValue alphaBeta(ChessBoard board, int depth, int side, int alpha, int beta)
    {
        //int value;
        TotalValue value = new TotalValue();
        if (depth == 0 || board.isEnded())
        {
            value.best = board.evaluate(side);
            return value;
        }
        //board.getOrderedMoves();
        //int best = 2*-INFINITED ;
        TotalValue best = new TotalValue();
        ChessBoard nextBoard;
        //while (board.hasMoreMoves())
        //{
        //    move = board.getNextMove();
        //    nextBoard = board.makeMove(move);
        boolean flag = false;
        for (int i = 1; i < 61; i++)
        {
            if (board.pos[i].getRedOrBlue() != side) continue;
            if (board.pos[i].getName() == null) continue;
            for (int j = 1; j < 61; j++)
            {
                if (board.pos[j].getRedOrBlue() == side) continue;
                if (Move.canMoveAfterStart(board.pos, i, j))
                {
                    nextBoard = board.nextMove(i, j);
                    TotalValue tmpV = alphaBeta(nextBoard, depth - 1, 1 - side, -beta, -alpha);
                    value.best = -tmpV.best;
                    if (value.best >= best.best)
                    {
                        best.value_From = i;
                        best.value_To = j;
                        best.best = value.best;
                    }
                    if (best.best > alpha)
                        alpha = best.best;
                    if (best.best >= beta)
                    {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) break;
        }
        return best;
    }
    public static int Coordinary_To_Index(int x, int y)
    {
        return x * 5 + y + 1;
    }

    public static void CheckSiLing()
    {
        if (!Variable.isEnd)
        {
            boolean flag = false;
            for (int i = 1; i < 61; i++)
            {
                if (Variable.ChessPos[i].getRedOrBlue() != 0) continue;
                if (Variable.ChessPos[i].getName() == "siling")
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
                if (Variable.ChessPos[2].getRedOrBlue() == 0&&Variable.ChessPos[2].getName()=="junqi")
                {
                    Variable.ItemBox[2].setImageResource(Variable.redKeyToImage.get("junqi"));
                }

                else if(Variable.ChessPos[59].getName()=="junqi")
                {
                    Variable.ItemBox[59].setImageResource(Variable.redKeyToImage.get("junqi"));
                }

            }
            flag = false;
            for (int i = 1; i < 61; i++)
            {
                if (Variable.ChessPos[i].getRedOrBlue() != 1) continue;
                if (Variable.ChessPos[i].getName() == "siling")
                {
                    flag = true;
                    break;
                }
            }
            if (!flag)
            {
                if (Variable.ChessPos[59].getRedOrBlue() == 1 && Variable.ChessPos[59].getName() == "junqi")
                {
                    Variable.ItemBox[59].setImageResource(Variable.blueKeyToImage.get("junqi"));
                }                  
                else if(Variable.ChessPos[2].getName()=="junqi")
                {
                    Variable.ItemBox[2].setImageResource(Variable.blueKeyToImage.get("junqi"));
                }

            }
        }
    }

    
    public static void DFS(List<Position> PList, int deepth, int from, int to, boolean[][] isVisited)
    {
        if (Variable.forDFS == true) return;
        Position tmpP = PList.get(deepth);
        int tmpX = tmpP.getX();
        int tmpY = tmpP.getY();
        if (tmpP == Variable.ChessPos[to])
        {
            Variable.forDFS = true;
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
           (Variable.ChessPos[Coordinary_To_Index(tmpX - 1, tmpY)].getName() == null &&
            Variable.ChessPos[Coordinary_To_Index(tmpX - 1, tmpY)].getIsOnTheRoad() == true &&
            isVisitedCopied[tmpX - 1][tmpY] == false) ||
            Coordinary_To_Index(tmpX - 1, tmpY) == to
           )
           )
        {
            if (!(tmpX == 6 && (tmpY == 1 || tmpY == 3)))
            {
                //isVisited[tmpX - 1, tmpY] = true;
                PList.add(Variable.ChessPos[Coordinary_To_Index(tmpX - 1, tmpY)]);
                DFS(PList, deepth + 1, from, to, isVisitedCopied);
                isVisitedCopied[tmpX - 1][tmpY] = true;
            }
        }
        if (Variable.forDFS == true) return;
        if (tmpX + 1 <= 11 &&
           (
           (Variable.ChessPos[Coordinary_To_Index(tmpX + 1, tmpY)].getName() == null &&
            Variable.ChessPos[Coordinary_To_Index(tmpX + 1, tmpY)].getIsOnTheRoad() == true &&
            isVisitedCopied[tmpX + 1][tmpY] == false) ||
            Coordinary_To_Index(tmpX + 1, tmpY) == to
            )
            )
        {
            if (!(tmpX == 5 && (tmpY == 1 || tmpY == 3)))
            {
                PList.add(Variable.ChessPos[Coordinary_To_Index(tmpX + 1, tmpY)]);
                DFS(PList, deepth + 1, from, to, isVisitedCopied);
                isVisitedCopied[tmpX + 1][tmpY] = true;
            }
        }
        if (Variable.forDFS == true) return;
        if (tmpY - 1 >= 0 &&
           (
           (
            Variable.ChessPos[Coordinary_To_Index(tmpX, tmpY - 1)].getName() == null &&
            Variable.ChessPos[Coordinary_To_Index(tmpX, tmpY - 1)].getIsOnTheRoad() == true &&
            isVisitedCopied[tmpX][tmpY - 1] == false) ||
            Coordinary_To_Index(tmpX, tmpY - 1) == to
           )
           )
        {
            PList.add(Variable.ChessPos[Coordinary_To_Index(tmpX, tmpY - 1)]);
            DFS(PList, deepth + 1, from, to, isVisitedCopied);
            isVisitedCopied[tmpX][tmpY - 1] = true;
        }
        if (Variable.forDFS == true) return;
        if (tmpY + 1 <= 4 &&
           (
           (Variable.ChessPos[Coordinary_To_Index(tmpX, tmpY + 1)].getName() == null &&
            Variable.ChessPos[Coordinary_To_Index(tmpX, tmpY + 1)].getIsOnTheRoad() == true &&
            isVisitedCopied[tmpX][tmpY + 1] == false) ||
            Coordinary_To_Index(tmpX, tmpY + 1) == to
           )
           )
        {
            PList.add(Variable.ChessPos[Coordinary_To_Index(tmpX, tmpY + 1)]);
            DFS(PList, deepth + 1, from, to, isVisitedCopied);
            isVisitedCopied[tmpX][tmpY + 1] = true;
        }
        if (Variable.forDFS == true) return;
        PList.remove(PList.get(deepth));
    }

    public static List<Position> GetPathList(int index1, int index2)
    {
        List<Position> PL = new ArrayList<Position>();
        if (Variable.ChessPos[index1].getName() != "gongbing")
        {
            int fX, tX, fY, tY;
            fX = Variable.ChessPos[index1].getX();
            fY = Variable.ChessPos[index1].getY();
            tX = Variable.ChessPos[index2].getX();
            tY = Variable.ChessPos[index2].getY();
            if (fX == tX)
            {
                int step = fY > tY ? -1 : 1;
                for (int i = fY; i != tY + step; i += step)
                {
                    PL.add(Variable.ChessPos[Coordinary_To_Index(fX, i)]);
                }
            }
            else
            {
                int step = fX > tX ? -1 : 1;
                for (int i = fX; i != tX + step; i += step)
                {
                    PL.add(Variable.ChessPos[Coordinary_To_Index(i, fY)]);
                }
            }
        }
        else
        {
            Variable.forDFS = false;
            boolean[][] isVisited = new boolean[12][5];
            for (int i = 0; i < 12; i++)
                for (int j = 0; j < 5; j++)
                    isVisited[i][j] = false;
            PL.add(Variable.ChessPos[index1]);
            DFS(PL, 0, index1, index2, isVisited);
        }
        return PL;
    }
    public static boolean allCanMove(int side)
    {
        for (int i = 1; i < 61; i++)
        {
            if (Variable.ChessPos[i].getIsActive() == false) continue;
            else if (Variable.ChessPos[i].getName() == "dilei") continue;
            else if (Variable.ChessPos[i].getRedOrBlue() != side) continue;
            else
            {
                int x = Variable.ChessPos[i].getX();
                int y = Variable.ChessPos[i].getY();
                if (x - 1 >= 0 && (Variable.ChessPos[Coordinary_To_Index(x - 1, y)].getName() == null || (Variable.ChessPos[Coordinary_To_Index(x - 1, y)].getRedOrBlue() == (1 - side) && !Variable.ChessPos[Coordinary_To_Index(x - 1, y)].getIsXingying())))//λ������û�����ӻ����ǶԷ�������
                {
                    return true;
                }
                if (x + 1 <= 11 && (Variable.ChessPos[Coordinary_To_Index(x + 1, y)].getName() == null || (Variable.ChessPos[Coordinary_To_Index(x + 1, y)].getRedOrBlue() == (1 - side) && !Variable.ChessPos[Coordinary_To_Index(x - 1, y)].getIsXingying())))
                {
                    return true;
                }
                if (y - 1 >= 0 && (Variable.ChessPos[Coordinary_To_Index(x, y - 1)].getName() == null || (Variable.ChessPos[Coordinary_To_Index(x, y - 1)].getRedOrBlue() == (1 - side) && !Variable.ChessPos[Coordinary_To_Index(x - 1, y)].getIsXingying())))
                {
                    return true;
                }
                if (y + 1 <= 4 && (Variable.ChessPos[Coordinary_To_Index(x, y + 1)].getName() == null || (Variable.ChessPos[Coordinary_To_Index(x, y + 1)].getRedOrBlue() == (1 - side) && !Variable.ChessPos[Coordinary_To_Index(x - 1, y)].getIsXingying())))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void CheckAllCanMove()
    {
        if (!allCanMove(Variable.controlBelong == true ? 1 : 0))
        {
            String tmpStr;
            if (Variable.controlBelong == true)
            {
                tmpStr = "blue";
            }
            else
                tmpStr = "red";
            System.out.println("the " + tmpStr + " has been failed!");
        }
    }
}
