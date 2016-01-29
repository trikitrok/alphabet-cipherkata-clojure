(ns alphabet-cipher.coder)

(def ^:private alphabet
  (map char (range (int \a) (inc (int \z)))))

(defn encode [keyword msg]
  (str
    (nth (take (count alphabet)
             (drop (.indexOf alphabet (first keyword)) (cycle alphabet)))
       (.indexOf alphabet (first msg)))))

(defn decode [keyword encoded-msg]
  )

(defn decipher [encoded-msg msg]
  )