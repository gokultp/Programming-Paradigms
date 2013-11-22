

(format t "Enter 2 sets ~% A:")
(setf a (read))
(format t "B:")
(setf b (read))
(format t "~% A U B   :")
(print (union a b))
(format t "~% A ^ B :")
(print (intersection a b))
(format t "~% A - B :")
(print(set-difference a b))
(format t "~% B - A :")
(print(set-difference b a))
