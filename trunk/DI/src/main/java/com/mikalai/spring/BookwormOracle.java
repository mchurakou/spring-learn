package com.mikalai.spring;

import org.springframework.stereotype.Service;


@Service("oracle")
public class BookwormOracle implements Oracle {

    @Override
    public String defineMeaningOfLife() {
        return "Encyclopedias are waste of money!";
    }

}
