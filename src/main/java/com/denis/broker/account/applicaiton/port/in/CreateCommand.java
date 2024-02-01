package com.denis.broker.account.applicaiton.port.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCommand {
    private String name;
    private Long balance;
}
