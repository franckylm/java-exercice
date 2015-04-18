package com.xebia;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.xebia.models.Mower;
import com.xebia.models.Coordinate;

public class Main {

    public static void main(String[] args) {
        List<String> data = Main.getFileContent();

        assert data != null;
        Mower.yCoord = new Coordinate(data.remove(0));
        while(!data.isEmpty()){
            Mower mower = new Mower(data.remove(0));
            mower.executeInstructions(data.remove(0));
        }
    }

    private static List<String> getFileContent() {
        Path path = FileSystems.getDefault().getPath("resources/data.txt");
        try{
            return Files.readAllLines(path);
        }catch (Exception e) {
            System.out.println("Unable to read the file.");
            return null;
        }
    }
}
