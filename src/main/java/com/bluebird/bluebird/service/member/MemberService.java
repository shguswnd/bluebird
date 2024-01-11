package com.bluebird.bluebird.service.member;

import com.bluebird.bluebird.domain.Member;
import com.bluebird.bluebird.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    //생성자 주입으로 jpa 가능한지 봐보자.
    private final MemberRepository memberRepository;



    public Member createMember(Member creatMember){
        if(creatMember == null) throw new IllegalArgumentException("멤버를 만들수 없다.");
        return memberRepository.save(creatMember);
    }
}
