package edu.calpoly.dltompki.csc305.lab2;

import lombok.extern.java.Log;

import java.io.File;

@Log
public class Main {
  private static final String RESOURCES_PATH = "./app/src/main/resources";

  public static void main(String[] args) {
    File directory = new File(RESOURCES_PATH);
    File[] files = directory.listFiles();
    if (files == null) {
      log.severe("no input files");
      return;
    }
    for (File file : files) {
      log.info(file.getName());
    }
  }
}
