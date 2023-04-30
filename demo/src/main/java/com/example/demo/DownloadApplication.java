package com.example.demo;

import com.example.demo.services.downloader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DownloadApplication implements CommandLineRunner {
    @Autowired
	downloader filedownloder;
	public static void main(String[] args) {
		SpringApplication.run(DownloadApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("No random order of executuion indicated thread run");
		filedownloder.thredrunner();
	}
}
