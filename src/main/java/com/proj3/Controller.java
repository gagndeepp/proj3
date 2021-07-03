package com.proj3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    static List<String> list = new ArrayList<>();
    {
        list.add("Initial element 1");
        list.add("Initial element 2");
        list.add("Initial element 3");
        list.add("Initial element 4");
        list.add("itemToUpdate");
        list.add("itemToDelete");
        list.add("itemToFind");
    }

    @GetMapping("/getItems")
    public static List getItems(){
        return list;
    }

    @PutMapping("/updateItem")
    public static void updateItem(@RequestParam String s,@RequestParam String updS){
        list.set(list.indexOf(s),updS);
    }

    @PostMapping("/addItem")
    public static void addItem(@RequestParam String s){
        //Not sure of the Http Return status 201
        list.add(s);
    }

    @DeleteMapping("/deleteItem")
    public static void deleteItem(@RequestParam String s){
        list.remove(s);
    }

    @GetMapping("/findItem")
    public static String findItem(@RequestParam String s){
        //Not sure of the Http return status 404
        return list.get(list.indexOf(s));
    }
}
