/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;
import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

/**
 *
 * @author Maximus
 */
public class AudioPlayer {
    public static void playSound(String audioFile){
        try{
            FileInputStream file = new FileInputStream(audioFile);
            Player player = new Player(file);
            player.play();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
