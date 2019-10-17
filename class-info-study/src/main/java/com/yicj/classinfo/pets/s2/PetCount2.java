package com.yicj.classinfo.pets.s2;

import com.yicj.classinfo.pets.s1.PetCount;

public class PetCount2 {

    public static void main(String[] args) {
        PetCount.countPets(Pets.creator);
        //{EgyptianMau=7, Pug=3, Rat=2, Cymric=7, Mouse=2, Cat=9, Manx=7,
        // Rodent=5, Mutt=3, Dog=6, Pet=20, Hamster=1}
    }
}
