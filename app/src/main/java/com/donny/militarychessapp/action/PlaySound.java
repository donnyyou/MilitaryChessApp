package com.donny.militarychessapp.action;

/**
 * Created by youansheng on 2016/11/22.
 */
import android.media.AudioManager;
import android.media.SoundPool;

import com.donny.militarychessapp.R;
import com.donny.militarychessapp.context.ContextUtil;

import java.util.HashMap;
import java.util.Map;

public class PlaySound {

	private static Map<String, Integer> mapSRC;
	private static SoundPool sp = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        PlaySound.play("mov");
	}
	//初始化声音池
	public PlaySound(){
		SoundPool sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
		mapSRC = new HashMap<String, Integer>();
		mapSRC.put("btnfocus", sp.load(ContextUtil.getInstance(), R.raw.btnfocus, 0));
		mapSRC.put("hurry", sp.load(ContextUtil.getInstance(), R.raw.hurry, 0));
		mapSRC.put("junqiactive", sp.load(ContextUtil.getInstance(), R.raw.junqiactive, 0));
		mapSRC.put("junqieat", sp.load(ContextUtil.getInstance(), R.raw.junqieat, 0));
		mapSRC.put("junqierro", sp.load(ContextUtil.getInstance(), R.raw.junqierro, 0));
		mapSRC.put("junqigiveup", sp.load(ContextUtil.getInstance(), R.raw.junqigiveup, 0));
		mapSRC.put("junqipeace", sp.load(ContextUtil.getInstance(), R.raw.junqipeace, 0));
		mapSRC.put("junqiput", sp.load(ContextUtil.getInstance(), R.raw.junqiput, 0));
		mapSRC.put("junqisldie", sp.load(ContextUtil.getInstance(), R.raw.junqisldie, 0));
		mapSRC.put("junqistart", sp.load(ContextUtil.getInstance(), R.raw.junqistart, 0));
		mapSRC.put("mov", sp.load(ContextUtil.getInstance(), R.raw.mov, 0));
		mapSRC.put("win", sp.load(ContextUtil.getInstance(), R.raw.win, 0));
	}

	/**
	 * 播放声音池的声音
	 * @param sound
	 */
	public static void play(String sound){
		sp.play(mapSRC.get(sound),//播放的声音资源
				1.0f,//左声道，范围为0--1.0
				1.0f,//右声道，范围为0--1.0
				0, //优先级，0为最低优先级
				5,//循环次数,0为不循环
				0);//播放速率，0为正常速率
	}

}
