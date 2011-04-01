{observed(E,J)}:- evtype(E,ex),instant(J),before(J,K),instant(K).
:- observed(E,J),observed(F,J),instant(J),instant(K),before(J,K),evtype(E,ex),evtype(F,ex), E!=F.
obs(I):- observed(E,I),evtype(E,ex),instant(I).
:- not obs(I), before(I,J).

