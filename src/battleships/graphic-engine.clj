(def alphabet {:health "0" :hit "x" :miss "*" :sunk "~" :empty " "})

(defn draw-line 
  "returns a string that represent one row of a board (only battlefield)"
  [state-line]
  (clojure.string/join 
    (reduce 
        (fn [board-line state]
            (conj board-line (alphabet state))
        )
      [] state-line)
  )
)

;example
;(if false (draw-line [:sunk :hit]))

;"--------------------------------------------"
(defn get-list-of-rows 
  "returns a list of rows of a board (only battlefield)"
  [lines-list]
  (reduce
    (fn [lines-list line]
      (conj lines-list (draw-line line)
      )
    )

  [] lines-list

  )
)

;example
;(if false (get-list-of-rows 
;  [[:sunk :hit] 
;   [:sunk :hit]]))

;"--------------------------------------------"
(defn get-row 
  "returns a left boarder of a line of a battlefield (i.e. # 1 )"
  [n]
  (if (= n 10) 
    (str "#" n " ") (str "# " n " ")
  )
)

;"--------------------------------------------"

(defn draw-board 
  "returns a string that represent a board (a battlefield and boarders)"
  [lines-list]
  (let [first-line "#   ABCDEFGHIJ#"]
    (str 
      (clojure.string/join 
        (conj 
          (interleave (map get-row (range 1 (inc 10))) 
                      (get-list-of-rows lines-list)
                      (repeat 10 "#")
                      (repeat 10 "\n")
          )
          "\n" first-line "\n" (clojure.string/join (repeat 15 "#") )
        )
      )
      (clojure.string/join (repeat 15 "#"))
    )
  )
)

;example
;(if false (println (draw-board 
;            [[:health :empty :empty :empty :empty :empty  :empty :empty :empty :empty] 
;             [:health :empty :empty :empty :empty :empty  :empty :sunk  :empty :empty]
;             [:health :empty :empty :empty :empty :empty  :empty :miss  :empty :empty]
;             [:empty  :empty :empty :empty :empty :empty  :empty :empty :empty :empty]
;             [:empty  :empty :empty :empty :empty :empty  :empty :empty :empty :empty]
;             [:empty  :empty :empty :hit   :hit   :health :empty :empty :empty :empty]
;             [:empty  :empty :empty :empty :empty :empty  :empty :empty :empty :empty]
;             [:empty  :empty :empty :empty :empty :empty  :empty :empty :empty :empty]
;             [:empty  :empty :empty :empty :empty :empty  :empty :empty :empty :empty]
;             [:empty  :empty :empty :empty :empty :empty  :empty :empty :empty :empty]] )))

;return this:

;###############
;#   ABCDEFGHIJ#
;# 1 0         #
;# 2 0      ~  #
;# 3 0      *  #
;# 4           #
;# 5           #
;# 6    xx0    #
;# 7           #
;# 8           #
;# 9           #
;#10           #
;###############
