package com.sparta.miniproject_team4.model;


import com.sparta.miniproject_team4.dto.PostingDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Posting extends Timestamped{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String text;

    @Column
    private String image;

    @Column(nullable = false)
    private String face;

    @Column(nullable = false)
    private String email;

//    @ManyToOne
//    @JoinColumn(name = "USERS_EMAIL")
//    private Users users;

    public Posting(PostingDto postingDto, String email){
        this.text = postingDto.getText();
        this.image = postingDto.getImage();
        this.face = postingDto.getFace();
        this.email = email;
    }
    public void update(PostingDto postingDto){
        this.text = postingDto.getText();
        this.image = postingDto.getImage();
        this.face = postingDto.getFace();
    }
}
