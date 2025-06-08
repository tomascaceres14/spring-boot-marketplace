package com.tomasdev.akhanta.professional;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProfessionalService {

    Professional findProfessionalById(String id);
    Page<Professional> findAllProfessionals(int page, int size);
    Professional saveProfessional(Professional professional, List<MultipartFile> images, String userId);
    Professional updateProfessionalById(String id, Professional professional);
    String deleteProfessionalById(String id);
}
