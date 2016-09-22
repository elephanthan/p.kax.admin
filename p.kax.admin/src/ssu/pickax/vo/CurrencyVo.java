package ssu.pickax.vo;

public class CurrencyVo
{
  private String code;
  private Integer currencySeq;
  private String name;
  private Float rate;
  private String time;
  private Float ask;
  private Float bid;

  public String getCode()
  {
    return this.code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  public Integer getCurrencySeq() {
    return this.currencySeq;
  }
  public void setCurrencySeq(Integer currencySeq) {
    this.currencySeq = currencySeq;
  }
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Float getRate() {
    return this.rate;
  }
  public void setRate(Float rate) {
    this.rate = rate;
  }
  public String getTime() {
    return this.time;
  }
  public void setTime(String time) {
    this.time = time;
  }
  public Float getAsk() {
    return this.ask;
  }
  public void setAsk(Float ask) {
    this.ask = ask;
  }
  public Float getBid() {
    return this.bid;
  }
  public void setBid(Float bid) {
    this.bid = bid;
  }
}