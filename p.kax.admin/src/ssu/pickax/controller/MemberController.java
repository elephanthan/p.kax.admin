package ssu.pickax.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssu.pickax.service.AdminService;
import ssu.pickax.vo.MemberVo;

@Controller
@RequestMapping({"/member"})
public class MemberController
{

  @Resource
  AdminService mService;

  @ResponseBody
  @RequestMapping(value={"/sign-up/submit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public MemberVo submitSignUp(@ModelAttribute MemberVo memberVo)
  {
    MemberVo returnData = this.mService.submitSignUp(memberVo);
    return returnData;
  }
}