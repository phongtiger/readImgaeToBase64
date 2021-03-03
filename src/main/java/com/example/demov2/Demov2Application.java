package com.example.demov2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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

        BufferedImage image = null;
        byte[] imageByte;
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            imageByte = decoder.decode(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
            File outputfile = new File("../../Downloads/ideaIU-2020.3.1/idea-IU-203.6682.168/bin/idea2.png");
            ImageIO.write(image, "png", outputfile);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
