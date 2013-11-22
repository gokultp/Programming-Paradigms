(defun quicksort (list &aux (pivot (car list)) )
  (if (cdr list)
      (nconc (quicksort (remove-if-not #'(lambda (x) (< x pivot)) list))
             (remove-if-not #'(lambda (x) (= x pivot)) list)
             (quicksort (remove-if-not #'(lambda (x) (> x pivot)) list)))
      list))

(setf a (read))

(print(quicksort a))
