package com.ll.donggibook.app.withdraw.controller;

import com.ll.donggibook.app.base.dto.RsData;
import com.ll.donggibook.app.base.rq.Rq;
import com.ll.donggibook.app.member.service.MemberService;
import com.ll.donggibook.app.withdraw.dto.WithDrawApplyForm;
import com.ll.donggibook.app.withdraw.entity.WithdrawApply;
import com.ll.donggibook.app.withdraw.service.WithdrawService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/withdraw")
@RequiredArgsConstructor
@Slf4j
public class WithdrawController {
    private final WithdrawService withdrawService;
    private final MemberService memberService;
    private final Rq rq;

    @GetMapping("/apply")
    public String showApply(Model model) {
        long actorRestCash = memberService.getRestCash(rq.getMember());
        model.addAttribute("actorRestCash", actorRestCash);

        return "withdraw/apply";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/apply")
    public String apply(@Valid WithDrawApplyForm withDrawApplyForm) {
        RsData<WithdrawApply> rsData = withdrawService.apply(
                withDrawApplyForm.getBankName(),
                withDrawApplyForm.getBankAccountNo(),
                withDrawApplyForm.getPrice(),
                rq.getMember()
        );

        return Rq.redirectWithMsg("/", rsData);
    }
}


