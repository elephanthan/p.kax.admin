package ssu.pickax.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import ssu.pickax.dao.AdminDao;
import ssu.pickax.util.EncryptUtil;
import ssu.pickax.vo.CodeCommonVo;
import ssu.pickax.vo.CountryCodeVo;
import ssu.pickax.vo.MemberVo;

@Service
public class AdminService
{

  @Resource
  AdminDao mDao;

  public MemberVo submitSignUp(MemberVo memberVo)
  {
    memberVo.setPassword(EncryptUtil.encryptMD5(memberVo.getPassword()));
    this.mDao.insertMemberData(memberVo);
    return memberVo;
  }

  public List<CountryCodeVo> getContryCodeTable() {
    return this.mDao.getContryCodeTable();
  }

  public List<CountryCodeVo> getCrawlerInfoTable() {
    return this.mDao.getCrawlerInfoTable();
  }

  public List<CountryCodeVo> getCurrencyTable() {
    return this.mDao.getCurrencyTable();
  }

  public void updateCode(List<CodeCommonVo> editedCodeList) {
    for (CodeCommonVo codeCommonVo : editedCodeList)
      this.mDao.updateCodeTable(codeCommonVo);
  }
}