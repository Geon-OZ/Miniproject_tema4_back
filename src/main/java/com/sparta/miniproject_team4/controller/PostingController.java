package com.sparta.miniproject_team4.controller;

import com.sparta.miniproject_team4.dto.PostingDto;
import com.sparta.miniproject_team4.model.Posting;
import com.sparta.miniproject_team4.repository.PostingRepository;
import com.sparta.miniproject_team4.security.UserDetailsImpl;
import com.sparta.miniproject_team4.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostingController {

    private final PostingService postingService;
    private final PostingRepository postingRepository;

    //포스팅 글 작성
    @PostMapping("/posting")
    public Posting createPosting(@RequestBody PostingDto postingDto,
                                 @AuthenticationPrincipal UserDetailsImpl userDetails){
        String email = userDetails.getUser().getEmail();
        Posting posting = postingService.createPosting(postingDto, email);
        return posting;
    }

    // 포스팅 전체 조회
    @GetMapping("/posting")
    public List<Posting> getAllPosting(){
        return postingRepository.findAllByOrderByCreatedAtDesc();
    }

    // 포스팅  디테일 조회
    @GetMapping("/posting/{id}")
    public Posting getPosting(@PathVariable Long id){
        Posting posting = postingRepository.findById(id).orElseThrow(
                ()->new NullPointerException("해당글이 존재하지 않습니다.")
        );
        return posting;
    }


    // 마이페이지 포스팅 조회
    @GetMapping("/myposting/{email}")
    public List<Posting> getMyPosting(@PathVariable String email){
        return postingRepository.findAllByEmail(email);
    }


    // 포스팅 수정
    @PutMapping("/posting/{id}")
    public Long updatePosting(@PathVariable Long id, @RequestBody PostingDto postingDto){
        postingService.update(id, postingDto);
        return id;
    }


    // 포스팅삭제
    @DeleteMapping("/posting/{id}")
    public Long deletePosting(@PathVariable Long id){
        postingRepository.deleteById(id);
        return id;
    }


}
