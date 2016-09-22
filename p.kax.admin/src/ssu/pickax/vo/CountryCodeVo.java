package ssu.pickax.vo;

public class CountryCodeVo
{
  private String name;
  private String useYn;
  private String code;
  private Integer codeSec;

  public String getName()
  {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getUseYn() {
    return this.useYn;
  }
  public void setUseYn(String useYn) {
    this.useYn = useYn;
  }
  public String getCode() {
    return this.code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  public Integer getCodeSec() {
    return this.codeSec;
  }
  public void setCodeSec(Integer codeSec) {
    this.codeSec = codeSec;
  }
}