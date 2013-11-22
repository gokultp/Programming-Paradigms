fact(A,F):-
	A=0,
	F is 1.
fact(A,F):-
	A>0,
	A1 is A-1,
	fact(A1,F1),
	F is A*F1.
