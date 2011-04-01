busy :- holdsat(transmit(C,T),F),final(F).
busy :- holdsat(creceive(A,T),F), final(F).
busy :- holdsat(asend(A,T),F),final(F).
busy :- holdsat(areceive(A,T),F),final(F).

% success criteria
success :- holdsat(hasChunk(alice,x1),F),
           holdsat(hasChunk(alice,x2),F),
           holdsat(hasChunk(alice,x3),F),
           holdsat(hasChunk(alice,x4),F),
           holdsat(hasChunk(bob,x1),F),
           holdsat(hasChunk(bob,x2),F),
           holdsat(hasChunk(bob,x3),F),
           holdsat(hasChunk(bob,x4),F), 
           not busy, final(F).

:- not success.

viol :- occured(viol(X),I).

:- viol.

good(i00) :- occured(creategrid,i00).
good(T) :- occured(download(A,X,C),T),occured(intDownload(A,X,C),T).
good(T) :- occured(send(A,X),T), occured(intSend(A),T).
good(T) :- occured(clock,T).
good(T) :- final(T).

:- not good(T), instant(T).

busyHReceiving(A,I) :- holdsat(busyHReceiving(A),I). 
busyHSending(A,I) :- holdsat(busyHSending(A),I).
busyChannel(C,I) :- holdsat(busyChannel(C),I).
busyBReceiving(A,I) :- holdsat(busyBReceiving(A),I).

#hide.
#show observed(E,I).
#show occured(X,I).
#show success.
#show busyHReceiving(A,I).
#show busyHSending(A,I).
#show busyChannel(C,I).
#show busyBReceiving(A,I).

