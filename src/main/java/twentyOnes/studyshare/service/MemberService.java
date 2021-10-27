package twentyOnes.studyshare.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import twentyOnes.studyshare.domain.member.Authority;
import twentyOnes.studyshare.domain.member.Member;
import twentyOnes.studyshare.domain.member.MemberRepository;
import twentyOnes.studyshare.dto.member.MemberDto;
import twentyOnes.studyshare.util.SecurityUtil;

import java.util.Collections;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Member signup(MemberDto memberDto) {
        //빌더 패턴의 장점
        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        Member member = Member.builder()
                .username(memberDto.getUsername())
                .password(passwordEncoder.encode(memberDto.getPassword()))
                .nickname(memberDto.getNickname())
                .authorities(Collections.singleton(authority))
                .activated(true)
                .build();

        return memberRepository.save(member);
    }

    @Transactional
    public Boolean idVerification(String username) {
        if (memberRepository.findOneWithAuthoritiesByUsername(username).orElse(null) != null) {
            return false;
        }
        else
            return true;
    }

    @Transactional
    public Boolean nicknameVerification(String nickname) {
        if (memberRepository.findOneWithAuthoritiesByUsername(nickname).orElse(null) != null) {
            return false;
        }
        else
            return true;
    }

    @Transactional
    public Boolean emailVerification(String email) {
        if (memberRepository.findOneWithAuthoritiesByUsername(email).orElse(null) != null) {
            return false;
        }
        else
            return true;
    }

    @Transactional(readOnly = true)
    public Optional<Member> getUserWithAuthorities(String username) {
        return memberRepository.findOneWithAuthoritiesByUsername(username);
    }

    @Transactional(readOnly = true)
    public Optional<Member> getMyUserWithAuthorities() {
        return SecurityUtil.getCurrentUsername().flatMap(memberRepository::findOneWithAuthoritiesByUsername);
    }
}