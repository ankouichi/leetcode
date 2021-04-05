package org.designpatterns.structural.adapter;

public class MediaAdaptor implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdaptor(String audioType) {
        if (audioType.equalsIgnoreCase("vlc"))
            advancedMediaPlayer = new VlcPlayer();
        else if (audioType.equalsIgnoreCase("mp4"))
            advancedMediaPlayer = new Mp4Player();
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc"))
            advancedMediaPlayer.playVlc(fileName);
        else if (audioType.equalsIgnoreCase("mp4"))
            advancedMediaPlayer.playMp4(fileName);
    }
}
