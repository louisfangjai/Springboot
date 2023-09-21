package com.hkjava.demo.demospringbootexercise1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stock {
  
  private CompanyProfile companyProfile;
  @JsonProperty("currentPrice")
  private double c;
  @JsonProperty("dayHigh")
  private double h;
  @JsonProperty("dayLow")
  private double l;
  @JsonProperty("dayOpen")
  private double o ;
  @JsonProperty("prevDayClose")
  private double pc;

  

}
