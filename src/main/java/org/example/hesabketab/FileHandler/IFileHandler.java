package FileHandler;

import java.io.File;
import java.util.ArrayList;
public interface IFileHandler {
    void UpdateFile(ArrayList<?> list, String fileAddress) throws Exception;
    ArrayList<?> ReadFile(String fileAddress) throws Exception;

}
