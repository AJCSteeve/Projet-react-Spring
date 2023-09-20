package com.example.projetreactspringboot.controller;

import com.example.projetreactspringboot.model.Content;
import com.example.projetreactspringboot.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ContentRestController {

    @Autowired
    ContentRepository contRepo;

    @GetMapping("/contents")
    public List<Content> getAll()
    {
        if (contRepo.findAll().isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return contRepo.findAll();
    }

    @GetMapping("/contents/name/{contentName}")
    @ResponseBody
    public List<Content> getByContentNameIsContainingIgnoreCase(@PathVariable String contentName)
    {
        if (contRepo.findByContentNameContainingIgnoreCase(contentName).isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return contRepo.findByContentNameContainingIgnoreCase(contentName);
    }

    @GetMapping("/contents/photo")
    public List<Content> getByPhoto(@RequestParam Content.ContentType PHOTO)
    {
        if (contRepo.findByContentType(PHOTO).isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return contRepo.findByContentType(PHOTO);
    }

    @GetMapping("/contents/video")
    public List<Content> getByVideo(@RequestParam Content.ContentType VIDEO)
    {
        if (contRepo.findByContentType(VIDEO).isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return contRepo.findByContentType(VIDEO);
    }
    @GetMapping("/contents/id/{id}")
    public Optional<Content> getById(@PathVariable Long id)
    {
        if (contRepo.findById(id).isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return contRepo.findById(id);
    }

    @PostMapping("/contents")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Content content)
    {
        contRepo.save(new Content(content.getContentName(), content.getContentData(), content.getContentType()));
    }

    @PutMapping("/contents/{id}")
    public ResponseEntity<Content> updateById(@PathVariable ("id") Long id, @RequestBody Content contentToUpdate)
    {
        Optional<Content> updateTarget = contRepo.findById(id);
        if (updateTarget.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Content updatecontent = updateTarget.get();
        updatecontent.setContentName(contentToUpdate.getContentName());
        updatecontent.setContentData(contentToUpdate.getContentData());
        updatecontent.setContentType(contentToUpdate.getContentType());
        updatecontent.setDescription(contentToUpdate.getDescription());
        contRepo.save(updatecontent);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(contentToUpdate);
    }


    @DeleteMapping("/contents/{id}")
    public  ResponseEntity<HttpStatus> deletedById(@PathVariable("id") Long id)
    {
        Optional<Content> contentToDelete = contRepo.findById(id);
        if (contentToDelete.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        contRepo.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
