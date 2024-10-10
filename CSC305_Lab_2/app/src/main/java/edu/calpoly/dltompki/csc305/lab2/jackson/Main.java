package edu.calpoly.dltompki.csc305.lab2.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import lombok.extern.java.Log;

@Log
public class Main {
  private static final String RESOURCES_PATH = "app/src/main/resources";

  public static void main(String[] args) throws IOException {
    File directory = new File(RESOURCES_PATH);
    File[] files = directory.listFiles();
    if (files == null) {
      log.severe("no input files");
      return;
    }
    ObjectMapper objectMapper = new ObjectMapper();
    for (File file : files) {
      Dignitary dignitary = objectMapper.readValue(file, Dignitary.class);
      log.info(dignitary.toString());
    }
  }
}
