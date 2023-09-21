package com.hkjava.demo.demoshopping.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
// 唔@data因為會call super, constructor無繼承
public class Item extends Good{
  private int quantity;

  public Item(double price,String description, int quantity){
    super(price,description); // from good
    this.quantity=quantity;
  }

  public static void main(String[] args) {
    Item item1 = new Item(30.0,"ABC",3); //
    System.out.println(item1.getId());
    System.out.println(item1);
    Item item2 = new Item();
    System.out.println(item2);
    Item item3 = new Item(99.9,"ANDY",2);
    System.out.println(item3);
    System.out.println(item3.getId());
  }
}
