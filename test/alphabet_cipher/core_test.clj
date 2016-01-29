(ns alphabet-cipher.core-test
  (:require [midje.sweet :refer :all]
            [alphabet-cipher.coder :refer :all]))

(facts
  "about Alphabet cipher"

  (fact
    "can encode given a secret keyword"

    (encode "v" "m") => "h"

    ;(encode "vigilance" "meetmeontuesdayeveningatseven") => "hmkbxebpxpmyllyrxiiqtoltfgzzv"
    ;
    ;(encode "scones" "meetmebythetree") => "egsgqwtahuiljgs"
    )

  ;(fact
  ;  "can decode an cyrpted message given a secret keyword"
  ;
  ;  (decode "vigilance" "hmkbxebpxpmyllyrxiiqtoltfgzzv") => "meetmeontuesdayeveningatseven"
  ;
  ;  (decode "scones" "egsgqwtahuiljgs") => "meetmebythetree")
  ;
  ;(fact
  ;  "can extract the secret keyword given an encrypted message and the original message"
  ;
  ;  (decipher "opkyfipmfmwcvqoklyhxywgeecpvhelzg" "thequickbrownfoxjumpsoveralazydog") => "vigilance"
  ;
  ;  (decipher "hcqxqqtqljmlzhwiivgbsapaiwcenmyu" "packmyboxwithfivedozenliquorjugs") => "scones")
  ;
  )
