holdsat(busyBReceiving(A),I) :- holdsat(creceive(A,T2),I), agent(A),time(T2),instant(I).

holdsat(busyHReceiving(A),I) :- holdsat(areceive(A,T2),I), agent(A),time(T2),instant(I).

holdsat(busyHSending(A),I) :- holdsat(asend(A,T2),I), agent(A),time(T2),instant(I).

holdsat(busyChannel(C),I) :- holdsat(transmit(C,T2),I), channel(C),time(T2),instant(I).


channel(c1).
channel(c2).

agent(alice).
agent(bob).

time(1..4).

 


