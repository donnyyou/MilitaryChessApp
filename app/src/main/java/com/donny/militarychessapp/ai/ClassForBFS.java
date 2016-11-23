package com.donny.militarychessapp.ai;

import com.donny.militarychessapp.chess.Position;

import java.util.LinkedList;
import java.util.Queue;


public class ClassForBFS {
	
	public static boolean isNeighbor(Position[] pos, int fromI, int toI)
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
    public static boolean BFS1(Position[] pos, int fromI, int ToI)
    {
        if (pos[fromI].getIsOnTheRoad() && pos[ToI].getIsOnTheRoad())
        {
            int fX, tX, fY, tY;
            fX = pos[fromI].getX();
            fY = pos[fromI].getY();
            tX = pos[ToI].getX();
            tY = pos[ToI].getY();
            if (pos[ActionByMode.Coordinary_To_Index(fX, fY)].getRedOrBlue() == pos[ActionByMode.Coordinary_To_Index(tX, tY)].getRedOrBlue()) return false;
            if (fX == tX)
            {
                int step = fY > tY ? -1 : 1;
                for (int i = fY + step; i != tY; i += step)
                {
                    if (pos[ActionByMode.Coordinary_To_Index(fX, i)].getName() != null) return false;
                    else if (pos[ActionByMode.Coordinary_To_Index(fX, i)].getRedOrBlue() == pos[ActionByMode.Coordinary_To_Index(fX, fY)].getRedOrBlue()) return false;
                }
                return true;
            }
            else if (fY == tY)
            {
                if ((fY == 1 || fY == 3) && (fX <= 5 || fX >= 6)) return false;
                int step = fX > tX ? -1 : 1;
                for (int i = fX + step; i != tX; i += step)
                {
                    if (pos[ActionByMode.Coordinary_To_Index(i, fY)].getName() != null) return false;
                    else if (pos[ActionByMode.Coordinary_To_Index(i, fY)].getRedOrBlue() == pos[ActionByMode.Coordinary_To_Index(fX, fY)].getRedOrBlue()) return false;
                }
                return true;
            }
            else return false;
        }
        return false;
    }
    public static boolean BFS2(Position[] pos, int fromI, int toI)
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
                if (ActionByMode.Coordinary_To_Index(P.getX(), P.getY()) == toI) return true;
                if (P.getX() - 1 >= 0 &&
                   (
                   (pos[ActionByMode.Coordinary_To_Index(P.getX() - 1, P.getY())].getName() == null &&
                   pos[ActionByMode.Coordinary_To_Index(P.getX() - 1, P.getY())].getIsOnTheRoad() == true &&
                   isVisited[P.getX() - 1][P.getY()] == false) ||
                   ActionByMode.Coordinary_To_Index(P.getX() - 1, P.getY()) == toI
                   )
                   )
                {
                    if (!(P.getX() == 6 && (P.getY() == 1 || P.getY() == 3)))
                    {
                        isVisited[P.getX() - 1][P.getY()] = true;
                        que.offer(pos[ActionByMode.Coordinary_To_Index(P.getX() - 1, P.getY())]);
                    }
                }
                if (P.getX() + 1 <= 11 &&
                   (
                   (pos[ActionByMode.Coordinary_To_Index(P.getX() + 1, P.getY())].getName() == null &&
                   pos[ActionByMode.Coordinary_To_Index(P.getX() + 1, P.getY())].getIsOnTheRoad() == true &&
                   isVisited[P.getX() + 1][P.getY()] == false) ||
                   ActionByMode.Coordinary_To_Index(P.getX() + 1, P.getY()) == toI
                   )
                   )
                {
                    if (!(P.getX() == 5 && (P.getY() == 1 || P.getY() == 3)))
                    {
                        isVisited[P.getX() + 1][P.getY()] = true;
                        que.offer(pos[ActionByMode.Coordinary_To_Index(P.getX() + 1, P.getY())]);
                    }
                }
                if (P.getY() - 1 >= 0 &&
                   (
                   (
                   pos[ActionByMode.Coordinary_To_Index(P.getX(), P.getY() - 1)].getName() == null &&
                   pos[ActionByMode.Coordinary_To_Index(P.getX(), P.getY() - 1)].getIsOnTheRoad() == true &&
                    isVisited[P.getX()][P.getY() - 1] == false) ||
                    ActionByMode.Coordinary_To_Index(P.getX(), P.getY() - 1) == toI
                    )
                    )
                {
                    isVisited[P.getX()][P.getY() - 1] = true;
                    que.offer(pos[ActionByMode.Coordinary_To_Index(P.getX(), P.getY() - 1)]);
                }
                if (P.getY() + 1 <= 4 &&
                   (
                   (pos[ActionByMode.Coordinary_To_Index(P.getX(), P.getY() + 1)].getName() == null &&
                   pos[ActionByMode.Coordinary_To_Index(P.getX(), P.getY() + 1)].getIsOnTheRoad() == true &&
                    isVisited[P.getX()][P.getY() + 1] == false) ||
                    ActionByMode.Coordinary_To_Index(P.getX(), P.getY() + 1) == toI
                    )
                    )
                {
                    isVisited[P.getX()][P.getY() + 1] = true;
                    que.offer(pos[ActionByMode.Coordinary_To_Index(P.getX(), P.getY() + 1)]);
                }
            }
            return false;
        }
        else return false;
    }
}
