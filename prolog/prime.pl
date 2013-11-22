isprime(N,M):-
	M = 1,
	write('prime').

isprime(N,M):-
	F is N mod M,
	F=0,
	write('not prime').
	
isprime(N,M):-
	F is N mod M,
	F>0,
	M1 is M-1,
	isprime(N,M1).

prime(N):-
	M is round(N/2),
	isprime(N,M).
	
	
	
