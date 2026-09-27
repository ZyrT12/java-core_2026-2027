package ru.zyryanova.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class HelloController {

    private ArrayList<String> arrayList;
    private HashMap<Integer, String> hashMap;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",
            defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public ArrayList<String> updateArrayList(@RequestParam String s) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }

        arrayList.add(s);

        return arrayList;
    }

    @GetMapping("/show-array")
    public ArrayList<String> showArrayList() {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }

        return arrayList;
    }

    @GetMapping("/update-map")
    public HashMap<Integer, String> updateHashMap(@RequestParam String s) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }

        hashMap.put(hashMap.size() + 1, s);

        return hashMap;
    }

    @GetMapping("/show-map")
    public HashMap<Integer, String> showHashMap() {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }

        return hashMap;
    }

    @GetMapping("/show-all-lenght")
    public String showAllLenght() {
        int arrayListSize = arrayList == null ? 0 : arrayList.size();
        int hashMapSize = hashMap == null ? 0 : hashMap.size();

        return "ArrayList: " + arrayListSize
                + ", HashMap: " + hashMapSize;
    }

}