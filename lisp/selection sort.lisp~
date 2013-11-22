
(defun selsort(list &aux (mn (apply #'min list)))
	(if(cdr list)
		(cons mn (selsort(remove mn list)))
		list))
	

(setq a (read))

(print(selsort a))
