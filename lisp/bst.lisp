(defstruct node
	data
	left
	right)

(defun ins(p n)
	(cond
		((equal p nil)
			(setf p (make-node :data n :left nil :right nil))p)
		
		((< n (node-data p))
			(setf (node-left p) (ins (node-left p) n))p)
			
		((> n (node-data p))
			(setf (node-right p) (ins (node-right p) n))p)))


(defun inorder(p)
	(if(equal p nil)
		nil
		
		(progn
			(inorder (node-left p))
			(print (node-data p))
			(inorder(node-right p)))))
(defun del(p n)
	(cond
		((equal (node-data p) n)
		(cond
			((equal (node-left p)nil)
				(node-right p))
			((equal (node-right p)nil)
				(node-left p))
				(t
					(setf m (min (node-right p)))
					(setf (node-data p) m)
					(del (node-right p) m)p)
					))
		
		((< n (node-data p))
			(setf (node-left p) (del (node-left p) n))p)
			
		((> n (node-data p))
			(setf (node-right p) (del (node-right p) n))p)))
	
	
(setf root nil)
(setf root (ins root 10))
(setf root (ins root 5))
(setf root (ins root 12))
(inorder root)
(setf root (del root 5))
(inorder root)
