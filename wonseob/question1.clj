(ns user
  (:require [clojure.spec.alpha :as s]))

(def suits
  [:h :d :s :c])

(range 1 14)

(def deck
  (for [suit suits
        rank (range 1 14)]
    [suit rank]))

(defn hand []
  (take 5 (shuffle deck)))

#_(defn high-card? [hand]
  )

(defn get-only-ranks [hand]
  (map (fn [card] (second card)) hand))

(defn pair? [hand]
  (->> (map (fn [[suit rank]]
             rank)
           hand)
      frequencies
      vals
      (some #{2})))

(defn evaluate [hand]
  (println hand)
  (cond
    (pair? hand)
    (println "got pair of " (pair? hand))

    :else
    (println "got high card of "
             (->> hand
                  get-only-ranks
                  (apply max)))))
