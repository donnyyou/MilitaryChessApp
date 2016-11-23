package com.donny.militarychessapp.ai;

public class TotalValue
{
	final int INFINITED = 888888888;
    public int best;
    public int value_From;
    public int value_To;
    public TotalValue()
    {
        best = 2 * -INFINITED;
        value_From = 0;
        value_To = 0;
    }
}
