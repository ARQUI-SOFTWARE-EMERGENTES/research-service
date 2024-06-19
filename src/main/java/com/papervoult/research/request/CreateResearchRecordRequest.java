package com.papervoult.research.request;

import com.papervoult.research.domain.model.entity.ReviewStatus;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateResearchRecordRequest {
    private String title;
    private String abstractText;
    private String content; // Base64 encoded string
    private ReviewStatus reviewStatus;
    private boolean authenticated;
    private Date submissionDate;
    private Date lastModifiedDate;
}
