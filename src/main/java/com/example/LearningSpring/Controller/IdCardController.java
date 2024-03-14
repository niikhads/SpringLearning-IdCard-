package com.example.LearningSpring.Controller;

import com.example.LearningSpring.Model.Dto.Request.IdCardRequest;
import com.example.LearningSpring.Model.Dto.Response.IdCardResponse;
import com.example.LearningSpring.Service.IdCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/id-cards")
public class IdCardController {

    private final IdCardService idCardService;

    public IdCardController(IdCardService idCardService) {
        this.idCardService = idCardService;
    }

    @GetMapping
    public ResponseEntity<List<IdCardResponse>> getAllIdCards() {
        List<IdCardResponse> idCards = idCardService.getAllIdCards();
        return ResponseEntity.ok(idCards);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<IdCardResponse> getIdCardById(@PathVariable("id") Long id) {
        IdCardResponse idCard = idCardService.getIdCardById(id);
        return ResponseEntity.ok(idCard);
    }

 //   @GetMapping("/id")
  //  public ResponseEntity<IdCardResponse> getIdCardById(@RequestParam("id") Long id) {
  //      IdCardResponse idCard = idCardService.getIdCardById(id);
   //    return ResponseEntity.ok(idCard);
 //  }


//    @GetMapping("/id")
//    public ResponseEntity<IdCardResponse> getIdCardById(@RequestHeader("id") Long id) {
//        IdCardResponse idCard = idCardService.getIdCardById(id);
//        return ResponseEntity.ok(idCard);
//    }

    @PostMapping
    public ResponseEntity<Void> addIdCard(@RequestBody IdCardRequest idCardRequest) {
        idCardService.addIdCard(idCardRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Void> updateIdCard(@PathVariable Long id,
                                             @RequestBody IdCardRequest idCardRequest) {
        idCardService.updateIdCard(id, idCardRequest);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/id/{id}")
    public ResponseEntity<Void> updateIdCardAge(@PathVariable Long id,
                                                @RequestParam Integer age) {
        idCardService.updateIdCardAge(id, age);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteIdCardById(@PathVariable Long id){
        idCardService.deleteIdCard(id);
        return ResponseEntity.ok().build();
    }

}