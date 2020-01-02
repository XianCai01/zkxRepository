package com.zkx.item.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Item {
    private Long id;

    private String title;

    private String pic;

    private String desc;

    private Long price;

}
