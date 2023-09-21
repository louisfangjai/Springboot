package com.hkjava.demo.demoshopping.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //包一堆野
@AllArgsConstructor
@NoArgsConstructor
@Builder // 唔洗NEW OBJECT去起OBJECT
public class Order {
  private long id;
  private long customerId;
  private List<Item> items;
}
