#gcd program
gcd(A,B,G):-
	A=B,
	G is A.

gcd(A,B,G):-
	B=0,
	G is A.
gcd(A,B,G):-
	A>B,
	B1 is A mod B,
	gcd(B,B1,G).
gcd(A,B,G):-
	B>A,
	gcd(B,A,G).

