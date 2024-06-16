package org.example.hesabketab.Employee;

import org.example.hesabketab.FileHandler.IFileHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class EmployeeDataManager implements IFileHandler {
    public static ArrayList<Employee> list;
    private ObjectOutputStream writer;

    @Override
    public void UpdateFile(ArrayList<?> list, String fileAddress) throws Exception {

        boolean isOK = true;
        try {
            File file = new File(fileAddress);
            file.delete();
            if(file.createNewFile())
                System.out.printf("Created! + %s" , file.getAbsolutePath());
            writer =new ObjectOutputStream(Files.newOutputStream(Paths.get(fileAddress)));
            if(list != null)
            {
            for (Object object: list) {
                writer.writeObject(object);
            }
            }
        }
        catch (IOException ioException){
            System.out.println("File Not Found!");
        }
        finally{
            writer.close();
        }
    }
    @Override
    public ArrayList<Employee> ReadFile(String fileAddress) throws Exception{
       list = new ArrayList<>();
        try {
            ObjectInputStream reader = new ObjectInputStream(Files.newInputStream(Paths.get(fileAddress)));
            while (true) {
                Employee employee = (Employee) reader.readObject();
                list.add(employee);
            }
        } catch (EOFException ignored) {

        } catch (Exception exception) {
            System.out.println("File to read not found !");
        }
        return list;
    }
}
