package com.donny.militarychessapp.action;

/**
 * Created by youansheng on 2016/11/22.
 */
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import com.donny.militarychessapp.R;
import com.donny.militarychessapp.context.ContextUtil;

import java.util.HashMap;
import java.util.Map;

public class PlaySound {

	private static Map<String, Integer> mapSRC;
	private static SoundPool sp = null;

	//初始化声音池
	public static void loadSound(Context context){
		SoundPool sp = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
		mapSRC = new HashMap<String, Integer>();
		mapSRC.put("btnfocus", sp.load(context, R.raw.btnfocus, 0));
		mapSRC.put("hurry", sp.load(context, R.raw.hurry, 0));
		mapSRC.put("junqiactive", sp.load(context, R.raw.junqiactive, 0));
		mapSRC.put("junqieat", sp.load(context, R.raw.junqieat, 0));
		mapSRC.put("junqierro", sp.load(context, R.raw.junqierro, 0));
		mapSRC.put("junqigiveup", sp.load(context, R.raw.junqigiveup, 0));
		mapSRC.put("junqipeace", sp.load(context, R.raw.junqipeace, 0));
		mapSRC.put("junqiput", sp.load(context, R.raw.junqiput, 0));
		mapSRC.put("junqisldie", sp.load(context, R.raw.junqisldie, 0));
		mapSRC.put("junqistart", sp.load(context, R.raw.junqistart, 0));
		mapSRC.put("mov", sp.load(context, R.raw.mov, 0));
		mapSRC.put("win", sp.load(context, R.raw.win, 0));
	}


    public static void playSound(Context contenxt, String key) {
        AudioManager manager = (AudioManager) contenxt
                .getSystemService(Context.AUDIO_SERVICE);
        // 获取当前音量和当前音量
        float currVol = manager.getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVol = manager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volume = currVol / maxVol;
        sp.play(mapSRC.get(key), maxVol, maxVol, 1, 0, 1.0f);

    }
}
