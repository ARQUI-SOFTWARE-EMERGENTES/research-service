package com.papervoult.research.response;

import com.papervoult.research.domain.model.entity.ReviewStatus;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ResearchRecordResponse {
    private String title;
    private String abstractText;
    private ReviewStatus reviewStatus;
    private boolean authenticated;
    private Date submissionDate;
    private Date lastModifiedDate;
    private String fileDownloadUri;
}
