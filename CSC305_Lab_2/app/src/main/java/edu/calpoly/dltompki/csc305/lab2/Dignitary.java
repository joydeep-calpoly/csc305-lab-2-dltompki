package edu.calpoly.dltompki.csc305.lab2;

import lombok.Value;

import java.util.List;

@Value
public class Dignitary {
    String name;
    List<String> knownFor;
    List<Award> awards;
}
