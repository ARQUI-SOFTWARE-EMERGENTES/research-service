package com.papervoult.research.resource;

import com.papervoult.research.domain.model.entity.ReviewStatus;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateResearchRecordResource {
    private String title;
    private String abstractText;
    private MultipartFile content; // Usar MultipartFile para manejar archivos
    private ReviewStatus reviewStatus;
    private boolean authenticated;
    private Date submissionDate;
    private Date lastModifiedDate;
}
