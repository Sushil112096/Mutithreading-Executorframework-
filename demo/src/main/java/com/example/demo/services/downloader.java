package com.example.demo.services;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Component
public class downloader {

    public List<List<Integer>> returnlist(){
        List<Integer> downloadlist=new ArrayList<>();
        List<List<Integer>> finallist=new ArrayList<>();
        for(int i=0;i<1000;i++)
        {
            downloadlist.add(i);
        }
        finallist= Lists.partition(downloadlist,10);
        return finallist;
    }

    public void thredrunner()
    {
        List<List<Integer>> finallist=returnlist();
        finallist.stream().forEach(listofmodel->{
            ThreadPoolExecutor executor= (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
//splitting each list with single executor intilized for each of them and passing the same object parmaeter futher in method parmater
            downloa_assigner(listofmodel,executor);
            executor.shutdown();
        });
    }

   public void downloa_assigner(List<Integer> downloadlist, ThreadPoolExecutor executor) {
       downloadlist.stream().forEach(data->{
           executor.execute(new Runnable() {
               @Override
               public void run() {
                   //task which we need to perform exactly funciononlatiy for thread need to be defined here
                   Download_files(data);
               }
           });
       });
    }

    public void Download_files(Integer y)
    {
        System.out.println("Thread no "+y+"with putput perform for =="+y);
    }

}
