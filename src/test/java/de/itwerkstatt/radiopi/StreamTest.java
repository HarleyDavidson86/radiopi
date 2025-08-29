package de.itwerkstatt.radiopi;

import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.media.MediaRef;
import uk.co.caprica.vlcj.player.base.AudioApi;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.component.AudioPlayerComponent;

import java.io.IOException;

public class StreamTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        AudioPlayerComponent audioPlayerComponent = new AudioPlayerComponent();
        MediaPlayer mediaPlayer = audioPlayerComponent.mediaPlayer();
        AudioApi audio = mediaPlayer.audio();
        System.out.println("Mute: " + audio.isMute());
        System.out.println("Vol " + audio.volume());
        Thread.sleep(3000);
        audioPlayerComponent.mediaPlayer().audio().setVolume(100);
        audioPlayerComponent.mediaPlayer().audio().setMute(false);
        System.out.println("Mute: " + audio.isMute());
        System.out.println("Vol " + audio.volume());
        Thread.sleep(3000);
        System.out.println("Start playing stream paused");
        // start > Blockiert bis der Stream gestartet ist
        mediaPlayer.media().start("https://liveradio.swr.de/sw282p3/swr1bw");
        System.out.println("Start playing stream paused - waiting for info");
        // Info ist erst nach ein paar Sekunden verfügbar
        Thread.sleep(3000);
        System.out.println("Playing: " + mediaPlayer.media().info().mrl());
        System.out.println("Mute: " + audio.isMute());
        System.out.println("Vol " + audio.volume());
        for (int i = 100; i >= 0; i -= 20) {
            System.out.println("Setting volume to " + i);
            audio.setVolume(i);
            System.out.println("Vol " + audio.volume());
            System.out.println("Mute: " + audio.isMute());
            Thread.sleep(3000);
        }
        audioPlayerComponent.release();
    }
}
