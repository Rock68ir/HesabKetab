package Employee;

import FileHandler.IFileHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class EmployeeDataManager implements IFileHandler {
    private ArrayList<Employee> list;
    private ObjectInputStream reader;
    private ObjectOutputStream writer;
    @Override
    public void UpdateFile(ArrayList<?> list, String fileAddress) throws Exception {

        boolean isOK = true;
        try {
            File file = new File(fileAddress);
            file.delete();
            file.createNewFile();
            for (Object object: list) {
                writer.writeObject(object);
            }
        }
        catch (IOException ioException){
            throw ioException;
        }
        finally{
            writer.close();
        }
    }
    @Override
    public ArrayList<?> ReadFile(String fileAddress) throws Exception{
       list = new ArrayList<>();

        reader = new ObjectInputStream(Files.newInputStream(Paths.get(fileAddress)));
       try {
           while (true){
              Employee employee = (Employee)reader.readObject();
              list.add(employee);
           }
       }
       catch (EOFException e){

       }
       catch (Exception exception){
           throw exception;
       }
       finally {
           reader.close();
       }
        return list;
    }
}
