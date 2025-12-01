(ns binary-search)

(defn binary-search [v target]
  (loop [low 0
         high (dec (count v))]
    (if (> low high)
      nil
      (let [mid (quot (+ low high) 2)
            val (v mid)]
        (cond
          (= val target) mid
          (< val target) (recur (inc mid) high)
          :else          (recur low (dec mid)))))))

(binary-search [1 3 5 7 9 11] 7)
(binary-search [1 3 5 7 9 11] 10)