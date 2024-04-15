package com.tomasdev.akhanta.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.tomasdev.akhanta.exceptions.ServiceException;
import com.tomasdev.akhanta.service.AmazonS3Service;
import com.tomasdev.akhanta.utils.SequenceGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class AmazonS3ServiceImpl implements AmazonS3Service {

    private final AmazonS3 s3Client;
    @Value("${application.bucket.name}")
    private String bucketName;

    public AmazonS3ServiceImpl(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    @Override
    public String upload(MultipartFile image, String folder) {
        File file = convertMultipartFileToFile(image);
        String filename = SequenceGenerator.uniqueSequence();

        s3Client.putObject(new PutObjectRequest(STR."\{bucketName}/\{folder}", filename, file));

        file.delete();

        return STR."https://\{bucketName}.s3.amazonaws.com/\{folder}/\{filename}";
    }

    @Override
    public String update(MultipartFile image, String folder, String originalName) {
        File file = convertMultipartFileToFile(image);
        s3Client.putObject(new PutObjectRequest(STR."\{bucketName}/\{folder}", originalName, file));
        file.delete();
        return STR."https://\{bucketName}.s3.amazonaws.com/\{folder}/\{originalName}";
    }

    @Override
    public void delete(String folder, String name) {
        s3Client.deleteObject(new DeleteObjectRequest(bucketName, STR."\{folder}/\{name}"));
    }

    private File convertMultipartFileToFile(MultipartFile file){
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)){
            fos.write(file.getBytes());
        } catch (IOException e) {
            throw new ServiceException("Error converting multipart-file to file.");
        }
        return convertedFile;
    }

    public String getImageKeyFromUrl(String url) {
        return url.split("/")[4];
    }

}