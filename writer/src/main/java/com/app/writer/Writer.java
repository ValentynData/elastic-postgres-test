package com.app.writer;

import com.app.writer.config.WriterConfig;
import com.app.writer.service.Saver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

@Component
public class Writer implements CommandLineRunner {

    private Saver saver;
    private List<Future<String>> futures = new CopyOnWriteArrayList<>();

    public Writer(Saver saver){
        this.saver = saver;
    }

    public static void main(String[] args){
        new SpringApplicationBuilder(WriterConfig.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
    @Override
    public void run(String... args) throws Exception {
        IntStream.range(0, 1_000).forEach(i -> futures.add(saver.save()));
        futures.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
