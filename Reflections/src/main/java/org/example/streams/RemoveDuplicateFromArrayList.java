package org.example.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicateFromArrayList {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1,1,1,10,34,53,2,10,2);
        List<Integer> unq = nums
            .stream()
            .distinct()
            .toList();
        System.out.println(unq);
    }
}
