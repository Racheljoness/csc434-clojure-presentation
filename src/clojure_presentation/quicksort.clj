(ns quicksort)

(defn quicksort [lst]
  (if (<= (count lst) 1)
    lst
    (let [pivot (first lst)
          rest (rest lst)
          smaller (filter #(< % pivot) rest)
          larger (filter #(>= % pivot) rest)]
      (concat (quicksort smaller)
              [pivot]
              (quicksort larger)))))

;; Example:
;; (quicksort [3 1 4 1 5 9 2 6 5 3 5]) => (1 1 2 3 3 4 5 5 5 6 9)
(println "Sorted list:" (quicksort [3 1 4 1 5 9 2 6 5 3 5]))
(quicksort [3 1 4 1 5 9 2 6 5 3 5])