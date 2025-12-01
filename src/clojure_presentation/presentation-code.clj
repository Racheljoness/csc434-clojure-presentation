(def transactions
  [{:user "alice" :type :deposit    :amount 1000}
   {:user "alice" :type :withdrawal :amount 200}
   {:user "bob"   :type :deposit    :amount 500}
   {:user "bob"   :type :withdrawal :amount 100}
   {:user "alice" :type :deposit    :amount 300}])

(defn tx->signed-amount [tx]
  (case (:type tx)
    :deposit    (:amount tx)
    :withdrawal (- (:amount tx))))

(defn balances-by-user [txs]
  (let [grouped (group-by :user txs)]
    (let [pairs
          (map (fn [[user user-txs]]
                 (let [signed (map tx->signed-amount user-txs)
                       sum    (reduce + signed)]
                   [user sum]))
               grouped)
          result (into {} pairs)]
      result)))


(balances-by-user transactions)
;; => {"alice" 1100, "bob" 400}