package com.bluebird.bluebird.service.member;

import com.bluebird.bluebird.domain.Member;
import com.bluebird.bluebird.domain.Status;
import com.bluebird.bluebird.dto.MemberDto;
import com.bluebird.bluebird.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class MemberService {

    //생성자 주입으로 jpa 가능한지 봐보자.
    private final MemberRepository memberRepository;



    public Member createMember(MemberDto memberDto){
        Member member = Member.builder()
                .id(memberDto.getId())
                .pwd(memberDto.getPwd())
                .name(memberDto.getName())
                .birthDay(memberDto.getBirthDay())
                .email(memberDto.getEmail())
                .phoneNum(memberDto.getPhoneNum())
                .joinDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()))
                .status(Status.valueOf("USER"))
                .profile("")
                .build();

        if(member == null) throw new IllegalArgumentException("멤버를 만들수 없다.");
        return memberRepository.save(member);
    }
}
