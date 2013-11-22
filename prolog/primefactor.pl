isprime(N,M):-
	M = 1,
	write(N).

isprime(N,M):-
	F is N mod M,
	F=0.
	
isprime(N,M):-
	F is N mod M,
	F>0,
	M1 is M-1,
	isprime(N,M1).

prime(N):-
	M is round(N/2),
	isprime(N,M).



isfactor(N,M):-
	M=N,
	prime(N),nl.
	
isfactor(N,M):-
	M<N,
	F is N mod M,
	F=0,
	prime(M),nl,
	M1 is M + 1,
	isfactor(N,M1).
	
isfactor(N,M):-
	M<N,
	F is N mod M,
	F>0,
	M1 is M + 1,
	isfactor(N,M1).
	
factors(N):-
	isfactor(N,2).
