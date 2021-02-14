import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcessDir {

    // Process the directory to get the list of mp3 files.
    public static List<String> process(String path) throws IOException {
        String result, _result[];
        ArrayList<String> mp3Result = new ArrayList<>();

        if ( (new File(path)).exists() ) {
            result = recurseInDirFrom(path);
            _result = result.split("\\|");
            for (String s : _result) {
                if (s.endsWith(".mp3")) {
                    mp3Result.add(s);
                }
            }
            return (mp3Result);
        }
        else {
            throw new IOException("Path not found : " + path);
        }
    }

    private static String recurseInDirFrom(String dir) {
        File file;
        String list[], result;

        result = dir;
        file = new File(dir);
        if (file.isDirectory()) {
            list = file.list();
            for (String s : list)
                result = result + "|"
                        + recurseInDirFrom(dir + File.separatorChar + s);
        }
        return result;
    }

    // Get the mp3 file information
    public static List<String> mp3FileInfo(String file) throws TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException, IOException {
        ArrayList<String> result = new ArrayList<>();
        MP3File mp3file = (MP3File) AudioFileIO.read(new File(file));
        try {
            Tag fileTag = mp3file.getTag();
            if (fileTag != null) {
                String title = fileTag.getFirst(FieldKey.TITLE);
                String album = fileTag.getFirst(FieldKey.ALBUM);
                String artist = fileTag.getFirst(FieldKey.ARTIST);
                String composer = fileTag.getFirst(FieldKey.COMPOSER);
                String year = fileTag.getFirst(FieldKey.YEAR);
                String genre = fileTag.getFirst(FieldKey.GENRE);
                int duration = mp3file.getAudioHeader().getTrackLength();
                result.add(file);
                result.add(title);
                result.add(Integer.toString(duration));
                result.add(composer);
                result.add(artist);
                result.add(album);
                result.add(genre);
                result.add(year);

            }
            else {
                System.out.println("No tag found for " + file);
                return null;
            }

        }
        catch (KeyNotFoundException e) {
            System.out.println("COMMENT key not found in " + file);
        }
        return result;
    }


    public static String choosePath(){
        System.out.println("Choose file/Directory");
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:\\Users\\W_Dragon\\Music\\"));
        fileChooser.setDialogTitle("Select Mp3");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Mp3 files","mp3"));
        Component selectButton = null;
        fileChooser.showOpenDialog(null);
//            File myFile = fileChooser.getSelectedFile();
//            String filename = fileChooser.getSelectedFile().getName();
        return fileChooser.getSelectedFile().getPath();
    }








}
