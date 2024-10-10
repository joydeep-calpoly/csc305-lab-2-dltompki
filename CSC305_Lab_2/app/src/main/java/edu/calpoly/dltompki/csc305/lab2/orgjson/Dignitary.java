package edu.calpoly.dltompki.csc305.lab2.orgjson;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Value;
import org.json.JSONArray;
import org.json.JSONObject;

@Value
public class Dignitary {
  String name;
  List<String> knownFor;
  List<Award> awards;

  Dignitary(JSONObject json) {
    this.name = json.getString("name");
    this.knownFor =
        json.getJSONArray("knownFor").toList().stream()
            .map(Object::toString)
            .collect(Collectors.toList());
    JSONArray awardsArray = json.getJSONArray("awards");
    List<JSONObject> awardsObjects = new ArrayList<>();
    for(int i = 0; i < awardsArray.length(); i++) {
      awardsObjects.add(awardsArray.getJSONObject(i));
    }
    this.awards = awardsObjects.stream().map(Award::new).collect(Collectors.toList());
  }
}
