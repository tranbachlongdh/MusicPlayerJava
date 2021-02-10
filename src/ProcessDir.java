import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcessDir {

    public static List<String> process(String path) throws IOException {
        String result, _result[];
        ArrayList<String> mp3Result = new ArrayList<String>();

        if ( (new File(path)).exists() ) {
            result = recurseInDirFrom(path);
            _result = result.split("\\|");
            for(int i=0; i<_result.length; i++) {
                if(_result[i].endsWith(".mp3")){
                    mp3Result.add(_result[i]);
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
            for (int i = 0; i < list.length; i++)
                result = result + "|"
                        + recurseInDirFrom(dir + File.separatorChar + list[i]);
        }
        return result;
    }

    // Get the mp3 file information
    public static List<String> mp3FileInfo(String file) throws TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException, IOException {
        ArrayList<String> result = new ArrayList<String>();
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

//                System.out.println("Album: " + album);
//                System.out.println("Artist: " + artist);
//                System.out.println("Composer: " + composer);
//                System.out.println("Year: " + year);
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


//    public static void main(String[] args) throws IOException, TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException {
//        String path = "C:\\Users\\W_Dragon\\Music\\";
//        //System.out.println("Process " + path);
//
//        List<String> mp3List = ProcessDir.process(path);
//        for(String s : mp3List) {
//            System.out.println("Mp3 file: " + ProcessDir.mp3FileInfo(s));
//
//        }
//    }
}
