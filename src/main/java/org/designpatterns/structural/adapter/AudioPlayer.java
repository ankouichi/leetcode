package org.designpatterns.structural.adapter;

public class AudioPlayer implements MediaPlayer{
    private MediaAdaptor mediaAdaptor;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3"))
            System.out.println("Playing mp3 file. Name : " + fileName);
        else if (audioType.equalsIgnoreCase("mp4") || audioType.equalsIgnoreCase("vlc")) {
            mediaAdaptor = new MediaAdaptor(audioType);
            mediaAdaptor.play(audioType, fileName);
        } else
            System.out.println("Invalid media. " + audioType + " format not supported.");
    }
}
