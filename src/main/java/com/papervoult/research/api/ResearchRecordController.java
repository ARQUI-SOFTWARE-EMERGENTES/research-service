package com.papervoult.research.api;

import com.papervoult.research.domain.model.entity.ResearchRecord;
import com.papervoult.research.domain.service.ResearchRecordService;
import com.papervoult.research.mapping.ResearchRecordMapper;
import com.papervoult.research.resource.CreateResearchRecordResource;
import com.papervoult.research.resource.ResearchRecordResource;
import com.papervoult.research.resource.UpdateResearchRecordResource;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ResearchRecordResource> fetchId(@PathVariable Integer id){
        if (researchRecordService.getResearchById(id).isPresent()){
            ResearchRecordResource researchRecordResource = this.mapper.toResource(researchRecordService.getResearchById(id).get());
            return ResponseEntity.ok(researchRecordResource);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("")
    public ResearchRecordResource save(@RequestBody CreateResearchRecordResource resource){
        return mapper.toResource(researchRecordService.save(mapper.toModel(resource)));
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
