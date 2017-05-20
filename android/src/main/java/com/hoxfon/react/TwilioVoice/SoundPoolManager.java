package com.hoxfon.react.TwilioVoice;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;

import static android.content.Context.AUDIO_SERVICE;

public class SoundPoolManager {

    private boolean playing = false;
    private static SoundPoolManager instance;
    private Ringtone ringtone = null;

    private SoundPoolManager(Context context) {
        Uri ringtoneSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        ringtone = RingtoneManager.getRingtone(context, ringtoneSound);
    }

    public static SoundPoolManager getInstance(Context context) {
        if (instance == null) {
            instance = new SoundPoolManager(context);
        }
        return instance;
    }

    public void playRinging() {
        if (!playing) {
            ringtone.play();
            playing = true;
        }
    }

    public void stopRinging() {
        if (playing) {
            ringtone.stop();
            playing = false;
        }
    }

    public void playDisconnect() {
        if (!playing) {
            ringtone.stop();
            playing = false;
        }
    }

}