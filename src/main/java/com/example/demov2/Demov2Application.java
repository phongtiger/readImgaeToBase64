package com.example.demov2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

@SpringBootApplication
public class Demov2Application {

    public static void main(String[] args) {
        SpringApplication.run(Demov2Application.class, args);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("../../Downloads/ideaIU-2020.3.1/idea-IU-203.6682.168/bin/idea.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            assert img != null;
            ImageIO.write(img, "png", bos);
            byte[] imageBytes = bos.toByteArray();

            Base64.Encoder encoder = Base64.getEncoder();
            imageString = encoder.encodeToString(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
