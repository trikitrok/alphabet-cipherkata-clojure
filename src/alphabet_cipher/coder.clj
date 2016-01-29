(ns alphabet-cipher.coder)

(def ^:private alphabet
  (map char (range (int \a) (inc (int \z)))))

(defn rotate-str [str n]
  (take (count str) (drop n (cycle str))))

(defn- rotate-alphabet-to-start-with [c]
  (rotate-str alphabet (.indexOf alphabet c)))

(defn- encode-char [keyword-char msg-char]
  (nth (rotate-alphabet-to-start-with keyword-char)
       (.indexOf alphabet msg-char)))

(defn encode [keyword msg]
  (str (encode-char (first keyword) (first msg))))

(defn decode [keyword encoded-msg]
  )

(defn decipher [encoded-msg msg]
  )