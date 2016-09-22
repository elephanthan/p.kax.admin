package ssu.pickax.vo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class CodeCommonVo
{

  @JsonProperty("seq")
  private Integer seq;

  @JsonProperty("name")
  private String name;

  @JsonProperty("seq_name")
  private String seq_name;

  @JsonProperty("val")
  private String val;

  @JsonProperty("menu")
  private String menu;
}