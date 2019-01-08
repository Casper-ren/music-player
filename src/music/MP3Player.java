package music;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;


/**
 * @author 
 */
public class MP3Player {
	private String filename;
	private Player player;

	private Thread playThead;


	public MP3Player(String filename) {
		this.filename = filename;
	}


	public void play() {
		playThead= new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filename));
					player = new Player(buffer);
					player.play();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		playThead.start();

	}


	public void stop() {
		try {
			playThead.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}