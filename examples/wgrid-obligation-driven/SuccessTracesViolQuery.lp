observed(creategrid,i00).
observed(download(alice,x1,c1),i01).
observed(download(bob,x2,c2),i02).
observed(send(alice,x1),i06).

%:- occured(creategrid,I), I != i00.


%busy :- holdsat(transmit(C,T),F),final(F).
%busy :- holdsat(creceive(A,T),F),final(F).
%busy :- holdsat(asend(A,T),F),final(F).
%busy :- holdsat(areceive(A,T),F),final(F).


% success criteria
%success :- holdsat(hasChunk(alice,x1),F),holdsat(hasChunk(alice,x2),F),holdsat(hasChunk(alice,x3),F),holdsat(hasChunk(alice,x4),F),
%           holdsat(hasChunk(bob,x1),F),holdsat(hasChunk(bob,x2),F),holdsat(hasChunk(bob,x3),F),holdsat(hasChunk(bob,x4),F), not busy,
%           final(F).

%:- success.

viol(X,I) :- occured(viol(X),I).
mviol :- occured(misuse(A),I).
dviol :- occured(viol(download(A,X,C)),I).
cviol :- occured(viol(creategrid),I).

:- not mviol.
%:- dviol.
%:- cviol.

count(T,I) :- holdsat(countdown(T),I).
%prev(X,Y,I) :- holdsat(previous(X,Y),I).

%trans(C,T,I) :-  holdsat(transmit(C,T),I).

obl(E,D,I) :- holdsat(obl(E,D,V),I).


%good(i00) :- occured(creategrid,i00).
%good(T) :- occured(download(A,X,C),T),occured(intDownload(A,X,C),T).
%good(T) :- occured(send(A,X),T), occured(intSend(A,X),T).
%good(T) :- occured(clock,T).
%good(T) :- final(T).

%:- not good(T), instant(T).


#hide.
#show observed(E,I).
%#show viol(X,I).
%#show success.
#show occured(X,I).
#show count(T,I).
%#show prev(X,Y,I).
%#show trans(C,T,I).
#show obl(E,D,I).
