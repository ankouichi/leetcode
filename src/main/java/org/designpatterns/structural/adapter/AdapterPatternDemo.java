package org.designpatterns.structural.adapter;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "1.mp3");
        audioPlayer.play("vlc", "2.vlc");
        audioPlayer.play("mp4", "3.mp4");
        audioPlayer.play("avi", "4.avi");
    }
}
