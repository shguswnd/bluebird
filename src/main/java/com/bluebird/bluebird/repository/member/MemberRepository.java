package com.bluebird.bluebird.repository.member;

import com.bluebird.bluebird.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
}
