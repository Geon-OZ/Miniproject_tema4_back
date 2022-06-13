package com.sparta.miniproject_team4.service;


import com.sparta.miniproject_team4.dto.PostingDto;
import com.sparta.miniproject_team4.model.Posting;
import com.sparta.miniproject_team4.model.Users;
import com.sparta.miniproject_team4.repository.PostingRepository;
import com.sparta.miniproject_team4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostingService {

    private final PostingRepository postingRepository;
    private final UserRepository userRepository;

    //포스팅 글 작성
    @Transactional
    public Posting createPosting(PostingDto postingDto, String email){
        String textCheck = postingDto.getText();
//        String image = postingDto.getImage();
        String faceCheck = postingDto.getFace();
//      텍스트,페이스 빈칸인지 확인
        if (textCheck.contains("script")|| textCheck.contains("<")||textCheck.contains(">")){
            Posting posting = new Posting(postingDto, email);
            postingRepository.save(posting);
        } if (faceCheck.contains("script")||faceCheck.contains("<")||faceCheck.contains(">")){
            Posting posting = new Posting(postingDto,email);
            postingRepository.save(posting);
        }
        Posting posting = new Posting(postingDto, email);
        postingRepository.save(posting);
        return posting;
    }

    //포스팅 수정
    @Transactional
    public void update(Long id, PostingDto postingDto) {
        Posting posting = postingRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("아이디가 존재하지 않습니다."));
        posting.update(postingDto);
    }





}

