package edu.calpoly.dltompki.csc305.lab2.jackson;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Dignitary {
  String name;
  List<String> knownFor;
  List<Award> awards;

  @Override
  public String toString() {
    StringWriter stringWriter = new StringWriter();
    try (PrintWriter printWriter = new PrintWriter(stringWriter)) {
      printWriter.println();
      printWriter.println(name);
      printWriter.println();
      printWriter.println("Known For:");
      knownFor.forEach(
          value -> {
            printWriter.print("\t");
            printWriter.println(value);
          });
      printWriter.println();
      printWriter.println("Awards:");
      awards.forEach(
          value -> {
            printWriter.print("\t");
            printWriter.println(value);
          });
    }
    return stringWriter.toString();
  }
}
