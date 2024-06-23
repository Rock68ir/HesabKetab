package org.example.hesabketab.Department;

import org.example.hesabketab.Employee.Employee;
import org.example.hesabketab.FileHandler.IFileHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DepartmentDataManager implements IFileHandler {

    public static ArrayList<Department> list;
    private ObjectOutputStream writer;

    @Override
    public void UpdateFile(ArrayList<?> list, String fileAddress) throws Exception {
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
            System.out.println("in dep");
            ioException.printStackTrace();
        }
        finally{
            writer.close();
        }
    }
    @Override
    public ArrayList<Department> ReadFile(String fileAddress) throws Exception {
        list = new ArrayList<>();
        ObjectInputStream reader = null;
        try {
            reader = new ObjectInputStream(Files.newInputStream(Paths.get(fileAddress)));
            while (true) {
                Department department = (Department) reader.readObject();
                list.add(department);
            }

        } catch (EOFException ignored) {
            assert reader != null;
            reader.close();
        } catch (IOException ioexception) {
            System.out.println("File to read not found (dep)!");
        }
        return list;
    }
}
