(ns alphabet-cipher.coder)

(def ^:private alphabet
  (map char (range (int \a) (inc (int \z)))))

(defn- rotate-str [str n]
  (take (count str) (drop n (cycle str))))

(defn- rotate-alphabet-to-start-with [c]
  (rotate-str alphabet (.indexOf alphabet c)))

(defn- encode-char [keyword-char msg-char]
  (nth (rotate-alphabet-to-start-with keyword-char)
       (.indexOf alphabet msg-char)))

(defn- decode-char [keyword-char msg-char]
  (nth alphabet
       (.indexOf (rotate-alphabet-to-start-with keyword-char)
                 msg-char)))

(defn- decipher-char [encoded-msg-char msg-char]
  (nth alphabet
       (.indexOf (rotate-alphabet-to-start-with msg-char) encoded-msg-char)))

(defn- possible-keywords [enlarged-keyword]
  (map #(take % enlarged-keyword)
       (range 1 (inc (count enlarged-keyword)))))

(defn- find-first [pred coll]
  (first (drop-while (complement pred) coll)))

(defn encode [keyword msg]
  (apply str (map encode-char (cycle keyword) msg)))

(defn decode [keyword encoded-msg]
  (apply str (map decode-char (cycle keyword) encoded-msg)))

(defn decipher [encoded-msg msg]
  (let [enlarged-keyword (apply str (map decipher-char encoded-msg msg))]
    (->> enlarged-keyword
         possible-keywords
         (find-first #(= (encode % msg) encoded-msg))
         (apply str))))