(ns alphabet-cipher.coder)

(declare encode)

(def ^:private alphabet
  (map char (range (int \a) (inc (int \z)))))

(defn- rotate-str [str n]
  (take (count str) (drop n (cycle str))))

(defn- rotate-alphabet-to-start-with [c]
  (rotate-str alphabet (.indexOf alphabet c)))

(defn- encode-char [keyword-c msg-c]
  (nth (rotate-alphabet-to-start-with keyword-c)
       (.indexOf alphabet msg-c)))

(defn- decode-char [keyword-c c]
  (nth alphabet
       (.indexOf (rotate-alphabet-to-start-with keyword-c) c)))

(defn- decipher-char [encoded-c msg-c]
  (nth alphabet
       (.indexOf (rotate-alphabet-to-start-with msg-c) encoded-c)))

(defn- possible-keywords [enlarged-keyword]
  (map #(take % enlarged-keyword)
       (range 1 (inc (count enlarged-keyword)))))

(defn- find-first [pred coll]
  (some #(when (pred %) %) coll))

(defn- decipher-enlarged-keyword [encoded-msg msg]
  (apply str (map decipher-char encoded-msg msg)))

(defn encode [keyword msg]
  (apply str (map encode-char (cycle keyword) msg)))

(defn decode [keyword encoded-msg]
  (apply str (map decode-char (cycle keyword) encoded-msg)))

(defn decipher [encoded-msg msg]
  (->> (decipher-enlarged-keyword encoded-msg msg)
       possible-keywords
       (find-first #(= (encode % msg) encoded-msg))
       (apply str)))
