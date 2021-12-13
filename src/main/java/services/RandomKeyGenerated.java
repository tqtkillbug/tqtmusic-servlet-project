package services;

import org.apache.commons.lang3.RandomStringUtils;


public class RandomKeyGenerated {
   public static String randomString(){
       return RandomStringUtils.random(6, false, true);
   }
}
