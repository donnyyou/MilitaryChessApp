package com.donny.militarychessapp.chess;

public class Position //��Ӧ���̵�λ��
{
    private int Id;     //���
    private int Pos_X;  //1-12�У�AI
    private int Pos_Y;  //1-5��, AI
    private String Name = null;
    private int RedOrBlue;
    private boolean canSetDilei;
    private boolean canSetZhadan;
    private boolean isActive;
    private boolean isXingying;
    private boolean isOnTheRoad;
    public Position(int id, int x, int y)
    {
        this.Id = id;
        this.Pos_X = x;
        this.Pos_Y = y;
        this.isActive = true;
        this.canSetDilei = false;
        this.canSetZhadan = true;
        this.isXingying = false;
    }
    public Position Clone()
    {
        Position newP = new Position(Id, Pos_X, Pos_Y);
        newP.isActive = isActive;
        newP.isOnTheRoad = isOnTheRoad;
        newP.isXingying = isXingying;
        newP.Name = Name;
        newP.canSetDilei = canSetDilei;
        newP.canSetZhadan = canSetZhadan;
        newP.RedOrBlue = RedOrBlue;
        return newP;
    }
    public void setX(int x)
    {
    	this.Pos_X = x;
    }
    
    public int getX()
    {
    	return this.Pos_X;
    }
    public void setY(int y)
    {
    	this.Pos_Y = y;
    }
    
    public void setId(int id)
    {
    	this.Id = id;
    }
    
    public int getId()
    {
    	return this.Id;
    }
    
    public int getY()
    {
    	return this.Pos_Y;
    }
    
    public void setName(String name)
    {
        this.Name = name;
    }
    
    public String getName()
    {
    	return this.Name;
    }
    
    public void setRedOrBlue(int key)
    {
    	this.RedOrBlue = key;
    }
    
    public int getRedOrBlue()
    {
        return this.RedOrBlue;
    }
    
    public void setCanSetDilei(boolean judge)
    {
        this.canSetDilei = judge;
    }
    
    public boolean getCanSetDilei()
    {
    	return this.canSetDilei;
    }
    
    public void setCanSetZhadan(boolean judge)
    {
        this.canSetZhadan = judge;
    }
    
    public boolean getCanSetZhadan()
    {
    	return this.canSetZhadan;
    }
    
    public void setIsActive(boolean judge)//��Ӫλ��Ϊinactive
    {
        this.isActive = judge;
    }
    
    public boolean getIsActive()
    {
    	return this.isActive;
    }
    
    public void setIsXingying(boolean judge)//�Ƿ�Ϊ10����Ӫ��
    {
    	this.isXingying = judge;
    }
    
    public boolean getIsXingying()
    {
    	return this.isXingying;
    }
    
    public void setIsOnTheRoad(boolean judge)//�Ƿ�����·��
    {
        this.isOnTheRoad = judge;
    }
    
    public boolean getIsOnTheRoad()
    {
    	return this.isOnTheRoad;
    }
}
