package com.xzzzf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class BorrowDetails {

    User user;

    List<Book> bookList;
}
