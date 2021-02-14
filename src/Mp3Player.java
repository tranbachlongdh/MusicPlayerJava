import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Mp3Player {

    private String filePath;
    private FileInputStream fileInputStream;
    private BufferedInputStream bufferedInputStream;
    private Player player;
    private Thread playThread;
    private Thread resumeThread;
    private long totalLength;
    private long pause;
    private File myFile;
    private Scanner scanner = new Scanner(System.in);

    public Mp3Player() {
        playThread = new Thread(runnablePlay);
        resumeThread = new Thread(runnableResume);
    }

    public Mp3Player(String filePath) {
        this.filePath = filePath;
        this.myFile = new File(filePath);
        playThread = new Thread(runnablePlay);
        resumeThread = new Thread(runnableResume);
//        playThread.start();
//        System.out.println("Playing");
//        resumeThread=new Thread(runnableResume);
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
        this.myFile = new File(filePath);
    }

    public void play() {
        playThread.start();
        System.out.println("Playing!!!");
    }

    public void pause() {
        //code for pause button
        if (player != null) {
            try {
                pause = fileInputStream.available();
                player.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void resume() {
        resumeThread.start();
        System.out.println("Playing!!!");
    }

    public void stop() {
        player.close();
        System.out.println("Stop!!!");
    }

    public String getPath() {
        System.out.println("Choose file");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:\\Users\\W_Dragon\\Music\\"));
        fileChooser.setDialogTitle("Select Mp3");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Mp3 files", "mp3"));
        Component selectButton = null;
        fileChooser.showOpenDialog(null);
//            File myFile = fileChooser.getSelectedFile();
//            String filename = fileChooser.getSelectedFile().getName();
        return fileChooser.getSelectedFile().getPath();

    }

    Runnable runnablePlay = new Runnable() {
        @Override
        public void run() {
            try {
                //code for play button
                fileInputStream = new FileInputStream(myFile);
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                player = new Player(bufferedInputStream);
                totalLength = fileInputStream.available();
                player.play();//starting music
            } catch (JavaLayerException | IOException e) {
                e.printStackTrace();
            }
        }
    };

    Runnable runnableResume = new Runnable() {
        @Override
        public void run() {
            try {
                //code for resume button
                fileInputStream = new FileInputStream(myFile);
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                player = new Player(bufferedInputStream);
                fileInputStream.skip(totalLength - pause);
                player.play();
            } catch (JavaLayerException | IOException e) {
                e.printStackTrace();
            }
        }
    };

    public void playSongs(Playlist playlist) {
        System.out.println(playlist.getName());
        playSongs(playlist.getSongs());
    }

    public void playSongs(List<Song> songs) {

        String choice;
        for (Song song : songs) {
            boolean exit = false;
//            Mp3Player mp3Player = new Mp3Player();
            setFilePath(song.getPath());
            this.play();
            System.out.println("Now Playing \"" + song.getTitle() + "\".");
            while (!exit) {
                Displayer.displayPlayerMenu();
                System.out.println("Choose your option:");
                choice = scanner.nextLine();
                switch (choice) {
//                    case "1": {
//                        this.setFilePath(song.getPath());
//                        break;
//                    }
                    case "2": {
                        this.play();
                        System.out.println("Now Playing \"" + song.getTitle() + "\".");
                        break;
                    }
                    case "3": {
                        this.pause();
                        break;
                    }
                    case "4": {
                        this.resume();
                        break;
                    }
                    case "5": {
                        this.stop();
                        break;
                    }
                    case "6": {
                        continue;
                    }
                    case "0": {
                        Displayer.displayPlayerMenu();
                        break;
                    }
                    case "7": {
//                        this.stop();
                        exit = true;
                    }
                }


            }

        }



    }

//    public static void playAllSongs() {
//        Mp3Player mp3Player = new Mp3Player();
//        List<Song> songs = Library.getSongs();
//        Scanner scanner = new Scanner(System.in);
//        String choice;
//        boolean exit = false;
//
//        for (Song song : songs) {
////            Mp3Player mp3Player = new Mp3Player();
//            mp3Player.setFilePath(song.getPath());
//            mp3Player.playThread();
//            while (!exit) {
//                Displayer.displayPlayerMenu();
//                System.out.println("Choose your option:");
//                choice = scanner.nextLine();
//                switch (choice) {
//                    case "0": {
//                        Displayer.displayPlayerMenu();
//                        break;
//                    }
//                    case "1": {
//                        mp3Player.setFilePath(song.getPath());
//                        break;
//                    }
//                    case "2": {
//                        mp3Player.playThread();
//                        break;
//                    }
//                    case "3": {
//                        mp3Player.pause();
//                        break;
//                    }
//                    case "4": {
//                        mp3Player.resumeThread();
//                        break;
//                    }
//                    case "5": {
//                        mp3Player.stop();
//                        break;
//                    }
//                    case "6": {
//                        continue;
//                    }
//                    case "7": {
//                        exit = true;
//                    }
//                }
//
//
//            }
//
//        }
//
//
//
//    }
}




//        Scanner scanner = new Scanner(System.in);
//        String choice;
//        boolean exit = false;
//        Mp3Player mp3Player = new Mp3Player();
//        while (!exit) {
//            Displayer.displayPlayerMenu();
//            System.out.println("Choose your option:");
//            choice = scanner.nextLine();
//            switch (choice){
//                case "0": {
//                    Displayer.displayPlayerMenu();
//                    break;
//                }
//                case "1": {
//                    mp3Player.setFilePath(mp3Player.getPath());
//                    break;
//                }
//                case "2": {
//                    mp3Player.playThread();
//                    break;
//                }
//                case "3": {
//                    mp3Player.pause();
//                    break;
//                }
//                case "4": {
//                    mp3Player.resumeThread();
//                    break;
//                }
//                case "5": {
//                    mp3Player.stop();
//                    break;
//                }
//                case "6": {
//                    exit = true;
//                }
//            }
//
//        }

//    }





//}
