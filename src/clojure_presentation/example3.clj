(def transactions
  [{:user "alice" :type :deposit    :amount 1000}
   {:user "alice" :type :withdrawal :amount 200}
   {:user "bob"   :type :deposit    :amount 500}
   {:user "bob"   :type :withdrawal :amount 100}
   {:user "alice" :type :deposit    :amount 300}])

(defn tx->signed-amount [tx]
  (println "processing tx:" tx)
  (case (:type tx)
    :deposit    (:amount tx)
    :withdrawal (- (:amount tx))))

(defn balances-by-user [txs]
  (println "START txs:" txs)
  (let [grouped (group-by :user txs)]
    (println "\nAFTER group-by:" grouped)
    (let [pairs
          (map (fn [[user user-txs]]
                 (println "\nUSER:" user)
                 (println "  transactions:" user-txs)
                 (let [signed (map tx->signed-amount user-txs)
                       sum    (reduce + signed)]
                   (println "  signed amounts:" signed)
                   (println "  balance:" sum)
                   [user sum]))
               grouped)
          result (into {} pairs)]
      (println "\nFINAL result map:" result)
      result)))


(balances-by-user transactions)
;; => {"alice" 1100, "bob" 400}
  