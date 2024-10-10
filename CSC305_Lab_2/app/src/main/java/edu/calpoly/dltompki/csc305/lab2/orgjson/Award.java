package edu.calpoly.dltompki.csc305.lab2.orgjson;

import java.time.Year;
import lombok.Value;
import org.json.JSONObject;

@Value
public class Award {
  String name;
  Year year;

  Award(JSONObject json) {
    this.name = json.getString("name");
    this.year = Year.of(json.getInt("year"));
  }

  @Override
  public String toString() {
    return name + ", " + year;
  }
}
