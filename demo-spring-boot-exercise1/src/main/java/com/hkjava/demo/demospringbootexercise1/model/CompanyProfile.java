package com.hkjava.demo.demospringbootexercise1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CompanyProfile {
  private String country;
  @JsonProperty("companyName")
  private String name;
  @JsonProperty("ipoDate")
  private String ipo;
  private String logo;
  @JsonProperty("marketCap")
  private double marketCapitalization;
  private String currency;
}
