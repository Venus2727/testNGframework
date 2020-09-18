package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IsFileExistClass extends TestBase {

    @Test
    public void isExist(){
        String pathOfFile = "C:/Users/Gurbet27/Desktop/FLOWER. IMG.jpg";
       boolean isExist = Files.exists(Paths.get(pathOfFile));
        Assert.assertTrue(isExist);

    }
}
