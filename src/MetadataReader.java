import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.LogManager;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.images.Artwork;

public class MetadataReader {
    public static void main(String[] args) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException {
        LogManager.getLogManager().reset();   // jaudiotagger can generating many warnings when analyzing a MP3 file,
        // this will suppress unwanted output.
        String path = "C:\\Users\\W_Dragon\\Music\\";
        System.out.println("Process " + path);

        List<String> mp3 = ProcessDir.process(path);

        for(String s : mp3) {
            if (s.toLowerCase().endsWith(".mp3")) {
                MP3File mp3file = (MP3File) AudioFileIO.read(new File(s));
                try {
                    Tag fileTag = mp3file.getTag();
                    if (fileTag != null) {
                        String comment = fileTag.getFirst(FieldKey.ALBUM);
                        if (comment == null || "".equals(comment.trim())) {
                            // System.out.println("No COMMENT for " + s);
                        }
                        else if (comment.length() > 0) {
                            System.out.println("COMMENT found in " + s + " : " + comment);
                        }
                    }
                    else {
                        System.out.println("No tag found for " + s);
                    }

                }
                catch (KeyNotFoundException e) {
                    System.out.println("COMMENT key not found in " + s);
                }
            }
        }
        System.out.println("Done.");
    }


}
