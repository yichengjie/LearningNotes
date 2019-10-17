package com.yicj.classinfo.pets.s2;

import com.yicj.classinfo.pets.MapData;
import com.yicj.classinfo.pets.model.Pet;

import java.util.LinkedHashMap;
import java.util.Map;

public class PetCount3 {
    static class PetCounter extends LinkedHashMap<Class<? extends Pet>,Integer>{
        public PetCounter(){
            super(MapData.map(LiteralPetCreator.allTypes,0));
        }

        public void count(Pet pet){
            for(Map.Entry<Class<? extends Pet> ,Integer> pair : entrySet()){
                if(pair.getKey().isInstance(pet)){
                    put(pair.getKey(),pair.getValue() +1) ;
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("{") ;
            for(Map.Entry<Class<? extends Pet>,Integer> pair: entrySet()){
                result.append(pair.getKey().getSimpleName()) ;
                result.append("=") ;
                result.append(pair.getValue()) ;
                result.append(", ") ;
            }
            result.delete(result.length()-2, result.length()) ;
            result.append("}") ;
            return  result.toString() ;
        }

        public static void main(String[] args) {
            PetCounter petCount = new PetCounter() ;
            for(Pet pet : Pets.createArray(20)){
                System.out.print(pet.getClass().getSimpleName() + " ");
                petCount.count(pet);
            }
            System.out.println();
            System.out.println(petCount);
            //{Mouse=2, Dog=6, Rodent=5, EgyptianMau=2, Pet=20,
            // Cymric=5, Hamster=1, Pug=3, Manx=7, Cat=9, Mutt=3, Rat=2}

            //{EgyptianMau=7, Pug=3, Rat=2, Cymric=7, Mouse=2, Cat=9, Manx=7,
            // Rodent=5, Mutt=3, Dog=6, Pet=20, Hamster=1}
        }
    }
}
