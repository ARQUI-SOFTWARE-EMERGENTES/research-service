package com.papervoult.research.api;

import com.papervoult.research.domain.model.entity.ResearchRecord;
import com.papervoult.research.domain.service.ResearchRecordService;
import com.papervoult.research.mapping.ResearchRecordMapper;
import com.papervoult.research.request.CreateResearchRecordRequest;
import com.papervoult.research.resource.CreateResearchRecordResource;
import com.papervoult.research.resource.ResearchRecordResource;
import com.papervoult.research.resource.UpdateResearchRecordResource;
import com.papervoult.research.response.ResearchRecordResponse;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("api/v1/researches")
public class ResearchRecordController {

    private ResearchRecordService researchRecordService;
    private ResearchRecordMapper mapper;

    public ResearchRecordController(ResearchRecordService researchRecordService, ResearchRecordMapper mapper){
        this.researchRecordService = researchRecordService;
        this.mapper = mapper;
    }

    @GetMapping("")
    public ResponseEntity<List<ResearchRecord>> fetchAll(){
        return ResponseEntity.ok(researchRecordService.getAllResearch());
    }

    @GetMapping("{id}")
    public ResponseEntity<ResearchRecordResponse> getResearchRecord(@PathVariable Integer id) {
        ResearchRecord record = researchRecordService.getResearchById(id)
                .orElseThrow(() -> new RuntimeException("ResearchRecord not found with id " + id));

        ResearchRecordResponse response = new ResearchRecordResponse();
        response.setTitle(record.getTitle());
        response.setAbstractText(record.getAbstractText());
        response.setReviewStatus(record.getReviewStatus());
        response.setAuthenticated(record.isAuthenticated());
        response.setSubmissionDate(record.getSubmissionDate());
        response.setLastModifiedDate(record.getLastModifiedDate());
        response.setFileDownloadUri("/api/v1/researches/" + id + "/download");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<Resource> downloadFile(@PathVariable Integer id) {
        ResearchRecord record = researchRecordService.getResearchById(id)
                .orElseThrow(() -> new RuntimeException("ResearchRecord not found with id " + id));

        ByteArrayResource resource = new ByteArrayResource(record.getContent());

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + record.getTitle() + ".pdf\"")
                .body(resource);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResearchRecordResource save(@RequestBody CreateResearchRecordRequest resource) throws IOException {
        ResearchRecord record = new ResearchRecord();
        record.setTitle(resource.getTitle());
        record.setAbstractText(resource.getAbstractText());
        record.setReviewStatus(resource.getReviewStatus());
        record.setAuthenticated(resource.isAuthenticated());
        record.setSubmissionDate(resource.getSubmissionDate());
        record.setLastModifiedDate(resource.getLastModifiedDate());
        record.setContent(Base64.getDecoder().decode(resource.getContent())); // Convertir base64 a bytes

        return mapper.toResource(researchRecordService.save(record));
    }

    @PutMapping("{id}")
    public ResponseEntity<ResearchRecordResource> update(@RequestBody UpdateResearchRecordResource resource, @PathVariable Integer id) {
        if (id.equals(resource.getId())) {
            ResearchRecordResource researchRecordResource = mapper.toResource(
                    researchRecordService.update(
                            mapper.toModel(resource)
                    )
            );
            return ResponseEntity.ok(researchRecordResource);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        if (researchRecordService.deleteById(id)){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
