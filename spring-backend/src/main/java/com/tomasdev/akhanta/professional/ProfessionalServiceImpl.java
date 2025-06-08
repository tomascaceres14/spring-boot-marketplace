package com.tomasdev.akhanta.professional;

import com.tomasdev.akhanta.exceptions.ResourceNotFoundException;
import com.tomasdev.akhanta.exceptions.ServiceException;
import com.tomasdev.akhanta.images.AmazonS3Service;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProfessionalServiceImpl implements ProfessionalService {

    private ProfessionalRepository repository;
    private AmazonS3Service s3Service;

    @Override
    public Professional findProfessionalById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Professional id " + id + " not found"));
    }

    @Override
    public Page<Professional> findAllProfessionals(int page, int size) {
        return null;
    }

    @Override
    public Professional saveProfessional(Professional professional, List<MultipartFile> images, String userId) {

        List<String> imagesUrl = new ArrayList<>();

        if (images != null) {
            if (images.size() > 5) throw new ServiceException("Se ha excedido el máximo de 5 imágenes por producto");

            images.forEach(image -> {
                imagesUrl.add(s3Service.upload(image, "productos"));
            });
            professional.setImages(imagesUrl);
        }

        return null;
    }

    @Override
    public Professional updateProfessionalById(String id, Professional professional) {
        return null;
    }

    @Override
    public String deleteProfessionalById(String id) {
        return null;
    }
}
