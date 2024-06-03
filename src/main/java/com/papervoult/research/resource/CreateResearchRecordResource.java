package com.papervoult.research.resource;

import com.papervoult.research.domain.model.entity.ReviewStatus;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateResearchRecordResource {
    private String title;
    private String abstractText;
    private String content;
    private ReviewStatus reviewStatus;
    private boolean authenticated;
    private Date submissionDate;
    private Date lastModifiedDate;
}
