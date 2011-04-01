

% 1.12.1
before(I1,I2):- next(I1,I2),instant(I1), instant(I2).
% 1.12.2
before(I1,I3):- before(I1,I2),before(I2,I3),instant(I1),instant(I2),instant(I3).


% fluent rules
holdsat(P,J):- holdsat(P,I),not terminated(P,I),
    next(I,J),ifluent(P),instant(I),instant(J).

holdsat(P,J):- initiated(P,I),next(I,J),
    ifluent(P),instant(I),instant(J).

%all observed events occur
occured(E,I):- evtype(E,ex),observed(E,I),instant(I).

% unfulfilled obligations generate violations
 occured(V,I):- holdsat(obl(E,D,V),I),occured(D,I),
     event(E;D;V),instant(I).

% %obligations are terminated by their deadline or by fulfillment
 terminated(obl(E,D,V),I):- occured(E,I),
     holdsat(obl(E,D,V),I),
     event(E;D;V),instant(I).

 terminated(obl(E,D,V),I):- occured(D,I),
     holdsat(obl(E,D,V),I),
     event(E;D;V),instant(I).

% a violation occurs for each non-permitted action
occured(viol(E),I):- 
    occured(E,I),
    evtype(E,ex),
    not holdsat(perm(E),I),
    holdsat(live(X),I),evinst(E,X),
    event(E),instant(I),event(viol(E)).

occured(viol(E),I):- 
    occured(E,I),
    evtype(E,inst),
    not holdsat(perm(E),I),
    event(E),instant(I),event(viol(E)).



% we pick exactly one observed event per instant up to but not
%including the final state.
%:- observed(E,J),observed(E,I),before(I,J),event(E),instant(I;J).

%We use final to terminate the trace, this allows us to select traces
%of _up_to_ and including length n (rather than just n) 
%final(J):- next(I,J),final(I).
%final(I):-cond(K),next(K,I),instant(I;K).

%event generation (debugging)
%only one observable per instant 
%bad :- observed(E1,I),observed(E2,I),E1!=E2,
%    instant(I),event(E1),event(E2).
