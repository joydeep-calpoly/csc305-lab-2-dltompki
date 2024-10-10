package edu.calpoly.dltompki.csc305.lab2.orgjson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;
import lombok.extern.java.Log;
import org.json.JSONObject;

@Log
public class Main {
  private static final String RESOURCES_PATH = "app/src/main/resources";

  public static void main(String[] args) throws FileNotFoundException {
    File directory = new File(RESOURCES_PATH);
    File[] files = directory.listFiles();
    if (files == null) {
      log.severe("no input files");
      return;
    }
    for (File file : files) {
      String fileContent = new Scanner(file).useDelimiter("\\Z").next();
      JSONObject jsonObject = new JSONObject(fileContent);
      Dignitary dignitary = new Dignitary(jsonObject);
      StringWriter stringWriter = new StringWriter();
      try (PrintWriter printWriter = new PrintWriter(stringWriter)) {
        printWriter.println();
        printWriter.println(dignitary.getName());
        printWriter.println();
        printWriter.println("Known For:");
        dignitary
            .getKnownFor()
            .forEach(
                value -> {
                  printWriter.print("\t");
                  printWriter.println(value);
                });
        printWriter.println();
        printWriter.println("Awards:");
        dignitary
            .getAwards()
            .forEach(
                value -> {
                  printWriter.print("\t");
                  printWriter.println(value);
                });
      }
      log.info(stringWriter.toString());
    }
  }
}
