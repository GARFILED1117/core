package hello.core.xml;

import hello.core.beanfind.ApplicationContextInfoTest;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContext {

    @Test
    public void xmlAppContext(){
        ApplicationContext ac =new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberServe", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
