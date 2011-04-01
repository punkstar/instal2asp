// $ANTLR 3.3 Nov 30, 2010 12:45:30 InstAL.g 2011-04-01 13:16:59

	package uk.ac.bath.cs.agents.instal.parser;
	
	import java.util.ArrayList;
	import java.util.Iterator;
	
	import uk.ac.bath.cs.agents.instal.*;
	import uk.ac.bath.cs.agents.instal.asp.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InstALLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int LINE_COMMENT=4;
    public static final int KEY_INST=5;
    public static final int END=6;
    public static final int LITERAL=7;
    public static final int KEY_TYPE=8;
    public static final int TYPE=9;
    public static final int KEY_WITH=10;
    public static final int KEY_EVENT=11;
    public static final int EVENT_KEY_CREATE=12;
    public static final int KEY_NONINERTIAL=13;
    public static final int KEY_FLUENT=14;
    public static final int KEY_GENERATES=15;
    public static final int KEY_IF=16;
    public static final int KEY_NOT=17;
    public static final int LPAR=18;
    public static final int RPAR=19;
    public static final int KEY_POW=20;
    public static final int KEY_PERM=21;
    public static final int KEY_INITIATES=22;
    public static final int KEY_TERMINATES=23;
    public static final int KEY_INITIALLY=24;
    public static final int KEY_OBLIGATION=25;
    public static final int LT=26;
    public static final int GT=27;
    public static final int EQ=28;
    public static final int NE=29;
    public static final int UCALPHA=30;
    public static final int DIGIT=31;
    public static final int LCALPHA=32;
    public static final int ANY=33;

    // delegates
    // delegators

    public InstALLexer() {;} 
    public InstALLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InstALLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InstAL.g"; }

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:17:7: ( 'exogenous' )
            // InstAL.g:17:9: 'exogenous'
            {
            match("exogenous"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:18:7: ( 'inst' )
            // InstAL.g:18:9: 'inst'
            {
            match("inst"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:19:7: ( 'violation' )
            // InstAL.g:19:9: 'violation'
            {
            match("violation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:20:7: ( ',' )
            // InstAL.g:20:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:21:7: ( 'viol' )
            // InstAL.g:21:9: 'viol'
            {
            match("viol"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:22:7: ( ':' )
            // InstAL.g:22:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:602:2: ( '%' ( (~ ( '\\r' | '\\n' ) )* ) ( '\\r' )? '\\n' )
            // InstAL.g:602:4: '%' ( (~ ( '\\r' | '\\n' ) )* ) ( '\\r' )? '\\n'
            {
            match('%'); 
            // InstAL.g:602:8: ( (~ ( '\\r' | '\\n' ) )* )
            // InstAL.g:602:10: (~ ( '\\r' | '\\n' ) )*
            {
            // InstAL.g:602:10: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InstAL.g:602:10: ~ ( '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            // InstAL.g:602:26: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InstAL.g:602:26: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
             skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINE_COMMENT"

    // $ANTLR start "KEY_INST"
    public final void mKEY_INST() throws RecognitionException {
        try {
            int _type = KEY_INST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:606:10: ( ( 'institution' | 'inst' ) )
            // InstAL.g:606:12: ( 'institution' | 'inst' )
            {
            // InstAL.g:606:12: ( 'institution' | 'inst' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='i') ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1=='n') ) {
                    int LA3_2 = input.LA(3);

                    if ( (LA3_2=='s') ) {
                        int LA3_3 = input.LA(4);

                        if ( (LA3_3=='t') ) {
                            int LA3_4 = input.LA(5);

                            if ( (LA3_4=='i') ) {
                                alt3=1;
                            }
                            else {
                                alt3=2;}
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InstAL.g:606:14: 'institution'
                    {
                    match("institution"); 


                    }
                    break;
                case 2 :
                    // InstAL.g:606:30: 'inst'
                    {
                    match("inst"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEY_INST"

    // $ANTLR start "KEY_TYPE"
    public final void mKEY_TYPE() throws RecognitionException {
        try {
            int _type = KEY_TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:607:10: ( 'type' )
            // InstAL.g:607:12: 'type'
            {
            match("type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEY_TYPE"

    // $ANTLR start "KEY_EVENT"
    public final void mKEY_EVENT() throws RecognitionException {
        try {
            int _type = KEY_EVENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:608:11: ( 'event' )
            // InstAL.g:608:13: 'event'
            {
            match("event"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEY_EVENT"

    // $ANTLR start "KEY_WITH"
    public final void mKEY_WITH() throws RecognitionException {
        try {
            int _type = KEY_WITH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:609:10: ( 'with' )
            // InstAL.g:609:12: 'with'
            {
            match("with"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEY_WITH"

    // $ANTLR start "KEY_FLUENT"
    public final void mKEY_FLUENT() throws RecognitionException {
        try {
            int _type = KEY_FLUENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:610:12: ( 'fluent' )
            // InstAL.g:610:14: 'fluent'
            {
            match("fluent"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEY_FLUENT"

    // $ANTLR start "KEY_GENERATES"
    public final void mKEY_GENERATES() throws RecognitionException {
        try {
            int _type = KEY_GENERATES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:611:15: ( 'generates' )
            // InstAL.g:611:17: 'generates'
            {
            match("generates"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEY_GENERATES"

    // $ANTLR start "KEY_INITIATES"
    public final void mKEY_INITIATES() throws RecognitionException {
        try {
            int _type = KEY_INITIATES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:612:15: ( 'initiates' )
            // InstAL.g:612:17: 'initiates'
            {
            match("initiates"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEY_INITIATES"

    // $ANTLR start "KEY_TERMINATES"
    public final void mKEY_TERMINATES() throws RecognitionException {
        try {
            int _type = KEY_TERMINATES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:613:16: ( 'terminates' )
            // InstAL.g:613:18: 'terminates'
            {
            match("terminates"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEY_TERMINATES"

    // $ANTLR start "KEY_IF"
    public final void mKEY_IF() throws RecognitionException {
        try {
            int _type = KEY_IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:614:9: ( 'if' )
            // InstAL.g:614:11: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEY_IF"

    // $ANTLR start "KEY_INITIALLY"
    public final void mKEY_INITIALLY() throws RecognitionException {
        try {
            int _type = KEY_INITIALLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:615:15: ( 'initially' )
            // InstAL.g:615:17: 'initially'
            {
            match("initially"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEY_INITIALLY"

    // $ANTLR start "KEY_NOT"
    public final void mKEY_NOT() throws RecognitionException {
        try {
            int _type = KEY_NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:616:10: ( 'not' )
            // InstAL.g:616:12: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEY_NOT"

    // $ANTLR start "KEY_OBLIGATION"
    public final void mKEY_OBLIGATION() throws RecognitionException {
        try {
            int _type = KEY_OBLIGATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:617:16: ( 'obl' )
            // InstAL.g:617:18: 'obl'
            {
            match("obl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEY_OBLIGATION"

    // $ANTLR start "KEY_PERM"
    public final void mKEY_PERM() throws RecognitionException {
        try {
            int _type = KEY_PERM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:618:10: ( 'perm' )
            // InstAL.g:618:12: 'perm'
            {
            match("perm"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEY_PERM"

    // $ANTLR start "KEY_POW"
    public final void mKEY_POW() throws RecognitionException {
        try {
            int _type = KEY_POW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:619:10: ( 'pow' )
            // InstAL.g:619:12: 'pow'
            {
            match("pow"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEY_POW"

    // $ANTLR start "KEY_NONINERTIAL"
    public final void mKEY_NONINERTIAL() throws RecognitionException {
        try {
            int _type = KEY_NONINERTIAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:620:17: ( 'noninertial' )
            // InstAL.g:620:19: 'noninertial'
            {
            match("noninertial"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KEY_NONINERTIAL"

    // $ANTLR start "EVENT_KEY_CREATE"
    public final void mEVENT_KEY_CREATE() throws RecognitionException {
        try {
            int _type = EVENT_KEY_CREATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:623:2: ( ( 'create' | 'creation' ) )
            // InstAL.g:623:4: ( 'create' | 'creation' )
            {
            // InstAL.g:623:4: ( 'create' | 'creation' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='c') ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='r') ) {
                    int LA4_2 = input.LA(3);

                    if ( (LA4_2=='e') ) {
                        int LA4_3 = input.LA(4);

                        if ( (LA4_3=='a') ) {
                            int LA4_4 = input.LA(5);

                            if ( (LA4_4=='t') ) {
                                int LA4_5 = input.LA(6);

                                if ( (LA4_5=='e') ) {
                                    alt4=1;
                                }
                                else if ( (LA4_5=='i') ) {
                                    alt4=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 4, 5, input);

                                    throw nvae;
                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 4, 4, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 4, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InstAL.g:623:5: 'create'
                    {
                    match("create"); 


                    }
                    break;
                case 2 :
                    // InstAL.g:623:14: 'creation'
                    {
                    match("creation"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EVENT_KEY_CREATE"

    // $ANTLR start "LPAR"
    public final void mLPAR() throws RecognitionException {
        try {
            int _type = LPAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:626:6: ( '(' )
            // InstAL.g:626:8: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAR"

    // $ANTLR start "RPAR"
    public final void mRPAR() throws RecognitionException {
        try {
            int _type = RPAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:627:6: ( ')' )
            // InstAL.g:627:8: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAR"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:628:5: ( ';' )
            // InstAL.g:628:7: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "TYPE"
    public final void mTYPE() throws RecognitionException {
        try {
            int _type = TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:629:6: ( UCALPHA ( DIGIT | UCALPHA | LCALPHA | '_' )* )
            // InstAL.g:629:8: UCALPHA ( DIGIT | UCALPHA | LCALPHA | '_' )*
            {
            mUCALPHA(); 
            // InstAL.g:629:16: ( DIGIT | UCALPHA | LCALPHA | '_' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InstAL.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TYPE"

    // $ANTLR start "LITERAL"
    public final void mLITERAL() throws RecognitionException {
        try {
            int _type = LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:630:9: ( LCALPHA ( DIGIT | UCALPHA | LCALPHA | '_' )* )
            // InstAL.g:630:11: LCALPHA ( DIGIT | UCALPHA | LCALPHA | '_' )*
            {
            mLCALPHA(); 
            // InstAL.g:630:19: ( DIGIT | UCALPHA | LCALPHA | '_' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InstAL.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LITERAL"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:631:4: ( ( '<' | 'lt' | 'LT' ) )
            // InstAL.g:631:6: ( '<' | 'lt' | 'LT' )
            {
            // InstAL.g:631:6: ( '<' | 'lt' | 'LT' )
            int alt7=3;
            switch ( input.LA(1) ) {
            case '<':
                {
                alt7=1;
                }
                break;
            case 'l':
                {
                alt7=2;
                }
                break;
            case 'L':
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InstAL.g:631:8: '<'
                    {
                    match('<'); 

                    }
                    break;
                case 2 :
                    // InstAL.g:631:14: 'lt'
                    {
                    match("lt"); 


                    }
                    break;
                case 3 :
                    // InstAL.g:631:21: 'LT'
                    {
                    match("LT"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:632:4: ( ( '>' | 'gt' | 'GT' ) )
            // InstAL.g:632:6: ( '>' | 'gt' | 'GT' )
            {
            // InstAL.g:632:6: ( '>' | 'gt' | 'GT' )
            int alt8=3;
            switch ( input.LA(1) ) {
            case '>':
                {
                alt8=1;
                }
                break;
            case 'g':
                {
                alt8=2;
                }
                break;
            case 'G':
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InstAL.g:632:8: '>'
                    {
                    match('>'); 

                    }
                    break;
                case 2 :
                    // InstAL.g:632:14: 'gt'
                    {
                    match("gt"); 


                    }
                    break;
                case 3 :
                    // InstAL.g:632:21: 'GT'
                    {
                    match("GT"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:633:4: ( ( '=' | '==' | 'eq' | 'EQ' ) )
            // InstAL.g:633:6: ( '=' | '==' | 'eq' | 'EQ' )
            {
            // InstAL.g:633:6: ( '=' | '==' | 'eq' | 'EQ' )
            int alt9=4;
            switch ( input.LA(1) ) {
            case '=':
                {
                int LA9_1 = input.LA(2);

                if ( (LA9_1=='=') ) {
                    alt9=2;
                }
                else {
                    alt9=1;}
                }
                break;
            case 'e':
                {
                alt9=3;
                }
                break;
            case 'E':
                {
                alt9=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InstAL.g:633:8: '='
                    {
                    match('='); 

                    }
                    break;
                case 2 :
                    // InstAL.g:633:14: '=='
                    {
                    match("=="); 


                    }
                    break;
                case 3 :
                    // InstAL.g:633:21: 'eq'
                    {
                    match("eq"); 


                    }
                    break;
                case 4 :
                    // InstAL.g:633:28: 'EQ'
                    {
                    match("EQ"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "NE"
    public final void mNE() throws RecognitionException {
        try {
            int _type = NE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:634:4: ( ( '!=' | 'ne' | 'NE' | '<>' ) )
            // InstAL.g:634:6: ( '!=' | 'ne' | 'NE' | '<>' )
            {
            // InstAL.g:634:6: ( '!=' | 'ne' | 'NE' | '<>' )
            int alt10=4;
            switch ( input.LA(1) ) {
            case '!':
                {
                alt10=1;
                }
                break;
            case 'n':
                {
                alt10=2;
                }
                break;
            case 'N':
                {
                alt10=3;
                }
                break;
            case '<':
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InstAL.g:634:8: '!='
                    {
                    match("!="); 


                    }
                    break;
                case 2 :
                    // InstAL.g:634:15: 'ne'
                    {
                    match("ne"); 


                    }
                    break;
                case 3 :
                    // InstAL.g:634:22: 'NE'
                    {
                    match("NE"); 


                    }
                    break;
                case 4 :
                    // InstAL.g:634:29: '<>'
                    {
                    match("<>"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NE"

    // $ANTLR start "UCALPHA"
    public final void mUCALPHA() throws RecognitionException {
        try {
            // InstAL.g:636:18: ( 'A' .. 'Z' )
            // InstAL.g:636:20: 'A' .. 'Z'
            {
            matchRange('A','Z'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UCALPHA"

    // $ANTLR start "LCALPHA"
    public final void mLCALPHA() throws RecognitionException {
        try {
            // InstAL.g:637:18: ( 'a' .. 'z' )
            // InstAL.g:637:20: 'a' .. 'z'
            {
            matchRange('a','z'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "LCALPHA"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // InstAL.g:638:17: ( '0' .. '9' )
            // InstAL.g:638:19: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "ANY"
    public final void mANY() throws RecognitionException {
        try {
            int _type = ANY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:640:5: ( . )
            // InstAL.g:640:8: .
            {
            matchAny(); 
             skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ANY"

    public void mTokens() throws RecognitionException {
        // InstAL.g:1:8: ( T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | LINE_COMMENT | KEY_INST | KEY_TYPE | KEY_EVENT | KEY_WITH | KEY_FLUENT | KEY_GENERATES | KEY_INITIATES | KEY_TERMINATES | KEY_IF | KEY_INITIALLY | KEY_NOT | KEY_OBLIGATION | KEY_PERM | KEY_POW | KEY_NONINERTIAL | EVENT_KEY_CREATE | LPAR | RPAR | END | TYPE | LITERAL | LT | GT | EQ | NE | ANY )
        int alt11=33;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // InstAL.g:1:10: T__34
                {
                mT__34(); 

                }
                break;
            case 2 :
                // InstAL.g:1:16: T__35
                {
                mT__35(); 

                }
                break;
            case 3 :
                // InstAL.g:1:22: T__36
                {
                mT__36(); 

                }
                break;
            case 4 :
                // InstAL.g:1:28: T__37
                {
                mT__37(); 

                }
                break;
            case 5 :
                // InstAL.g:1:34: T__38
                {
                mT__38(); 

                }
                break;
            case 6 :
                // InstAL.g:1:40: T__39
                {
                mT__39(); 

                }
                break;
            case 7 :
                // InstAL.g:1:46: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;
            case 8 :
                // InstAL.g:1:59: KEY_INST
                {
                mKEY_INST(); 

                }
                break;
            case 9 :
                // InstAL.g:1:68: KEY_TYPE
                {
                mKEY_TYPE(); 

                }
                break;
            case 10 :
                // InstAL.g:1:77: KEY_EVENT
                {
                mKEY_EVENT(); 

                }
                break;
            case 11 :
                // InstAL.g:1:87: KEY_WITH
                {
                mKEY_WITH(); 

                }
                break;
            case 12 :
                // InstAL.g:1:96: KEY_FLUENT
                {
                mKEY_FLUENT(); 

                }
                break;
            case 13 :
                // InstAL.g:1:107: KEY_GENERATES
                {
                mKEY_GENERATES(); 

                }
                break;
            case 14 :
                // InstAL.g:1:121: KEY_INITIATES
                {
                mKEY_INITIATES(); 

                }
                break;
            case 15 :
                // InstAL.g:1:135: KEY_TERMINATES
                {
                mKEY_TERMINATES(); 

                }
                break;
            case 16 :
                // InstAL.g:1:150: KEY_IF
                {
                mKEY_IF(); 

                }
                break;
            case 17 :
                // InstAL.g:1:157: KEY_INITIALLY
                {
                mKEY_INITIALLY(); 

                }
                break;
            case 18 :
                // InstAL.g:1:171: KEY_NOT
                {
                mKEY_NOT(); 

                }
                break;
            case 19 :
                // InstAL.g:1:179: KEY_OBLIGATION
                {
                mKEY_OBLIGATION(); 

                }
                break;
            case 20 :
                // InstAL.g:1:194: KEY_PERM
                {
                mKEY_PERM(); 

                }
                break;
            case 21 :
                // InstAL.g:1:203: KEY_POW
                {
                mKEY_POW(); 

                }
                break;
            case 22 :
                // InstAL.g:1:211: KEY_NONINERTIAL
                {
                mKEY_NONINERTIAL(); 

                }
                break;
            case 23 :
                // InstAL.g:1:227: EVENT_KEY_CREATE
                {
                mEVENT_KEY_CREATE(); 

                }
                break;
            case 24 :
                // InstAL.g:1:244: LPAR
                {
                mLPAR(); 

                }
                break;
            case 25 :
                // InstAL.g:1:249: RPAR
                {
                mRPAR(); 

                }
                break;
            case 26 :
                // InstAL.g:1:254: END
                {
                mEND(); 

                }
                break;
            case 27 :
                // InstAL.g:1:258: TYPE
                {
                mTYPE(); 

                }
                break;
            case 28 :
                // InstAL.g:1:263: LITERAL
                {
                mLITERAL(); 

                }
                break;
            case 29 :
                // InstAL.g:1:271: LT
                {
                mLT(); 

                }
                break;
            case 30 :
                // InstAL.g:1:274: GT
                {
                mGT(); 

                }
                break;
            case 31 :
                // InstAL.g:1:277: EQ
                {
                mEQ(); 

                }
                break;
            case 32 :
                // InstAL.g:1:280: NE
                {
                mNE(); 

                }
                break;
            case 33 :
                // InstAL.g:1:283: ANY
                {
                mANY(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\1\uffff\3\41\2\uffff\1\35\10\41\3\uffff\1\70\1\41\1\73\1\uffff"+
        "\1\70\1\uffff\1\70\1\uffff\1\70\1\35\2\uffff\2\41\2\uffff\1\41\1"+
        "\105\1\41\3\uffff\5\41\1\uffff\1\41\1\uffff\4\41\15\uffff\4\41\1"+
        "\uffff\6\41\1\134\1\41\1\136\1\41\1\140\3\41\1\145\1\41\1\150\1"+
        "\151\1\41\1\153\2\41\1\uffff\1\41\1\uffff\1\157\1\uffff\2\41\1\162"+
        "\1\41\1\uffff\2\41\2\uffff\1\41\1\uffff\3\41\1\uffff\2\41\1\uffff"+
        "\4\41\1\u0082\2\41\1\u0085\7\41\1\uffff\2\41\1\uffff\11\41\1\u0085"+
        "\1\u0098\1\41\1\u009a\1\u009b\1\u009c\1\41\1\u009e\1\41\1\uffff"+
        "\1\41\3\uffff\1\u00a1\1\uffff\1\41\1\u00a3\1\uffff\1\u00a4\2\uffff";
    static final String DFA11_eofS =
        "\u00a5\uffff";
    static final String DFA11_minS =
        "\1\0\1\161\1\146\1\151\2\uffff\1\0\1\145\1\151\1\154\2\145\1\142"+
        "\1\145\1\162\3\uffff\1\124\1\164\1\76\1\uffff\1\124\1\uffff\1\121"+
        "\1\uffff\1\105\1\75\2\uffff\1\157\1\145\2\uffff\1\151\1\60\1\157"+
        "\3\uffff\1\160\1\162\1\164\1\165\1\156\1\uffff\1\156\1\uffff\1\154"+
        "\1\162\1\167\1\145\15\uffff\1\147\1\156\2\164\1\uffff\1\154\1\145"+
        "\1\155\1\150\2\145\1\60\1\151\1\60\1\155\1\60\1\141\1\145\1\164"+
        "\1\60\1\151\2\60\1\151\1\60\1\156\1\162\1\uffff\1\156\1\uffff\1"+
        "\60\1\uffff\1\164\1\156\1\60\1\164\1\uffff\1\141\1\164\2\uffff\1"+
        "\156\1\uffff\1\164\1\141\1\145\1\uffff\1\145\1\157\1\uffff\1\165"+
        "\1\154\1\151\1\141\1\60\1\164\1\162\1\60\1\157\1\165\1\164\1\145"+
        "\1\154\1\157\1\164\1\uffff\1\145\1\164\1\uffff\1\156\1\163\1\151"+
        "\1\163\1\171\1\156\1\145\1\163\1\151\2\60\1\157\3\60\1\163\1\60"+
        "\1\141\1\uffff\1\156\3\uffff\1\60\1\uffff\1\154\1\60\1\uffff\1\60"+
        "\2\uffff";
    static final String DFA11_maxS =
        "\1\uffff\1\170\1\156\1\151\2\uffff\1\uffff\1\171\1\151\1\154\1\164"+
        "\1\157\1\142\1\157\1\162\3\uffff\1\124\1\164\1\76\1\uffff\1\124"+
        "\1\uffff\1\121\1\uffff\1\105\1\75\2\uffff\1\157\1\145\2\uffff\1"+
        "\163\1\172\1\157\3\uffff\1\160\1\162\1\164\1\165\1\156\1\uffff\1"+
        "\164\1\uffff\1\154\1\162\1\167\1\145\15\uffff\1\147\1\156\2\164"+
        "\1\uffff\1\154\1\145\1\155\1\150\2\145\1\172\1\151\1\172\1\155\1"+
        "\172\1\141\1\145\1\164\1\172\1\151\2\172\1\151\1\172\1\156\1\162"+
        "\1\uffff\1\156\1\uffff\1\172\1\uffff\1\164\1\156\1\172\1\164\1\uffff"+
        "\1\141\1\164\2\uffff\1\156\1\uffff\1\164\1\141\1\145\1\uffff\1\151"+
        "\1\157\1\uffff\1\165\1\164\1\151\1\141\1\172\1\164\1\162\1\172\1"+
        "\157\1\165\1\164\1\145\1\154\1\157\1\164\1\uffff\1\145\1\164\1\uffff"+
        "\1\156\1\163\1\151\1\163\1\171\1\156\1\145\1\163\1\151\2\172\1\157"+
        "\3\172\1\163\1\172\1\141\1\uffff\1\156\3\uffff\1\172\1\uffff\1\154"+
        "\1\172\1\uffff\1\172\2\uffff";
    static final String DFA11_acceptS =
        "\4\uffff\1\4\1\6\11\uffff\1\30\1\31\1\32\3\uffff\1\34\1\uffff\1"+
        "\36\1\uffff\1\37\2\uffff\1\33\1\41\2\uffff\2\34\3\uffff\1\4\1\6"+
        "\1\7\5\uffff\1\34\1\uffff\1\34\4\uffff\1\30\1\31\1\32\2\33\1\34"+
        "\1\40\1\35\1\33\1\36\1\33\1\37\1\33\4\uffff\1\20\26\uffff\1\22\1"+
        "\uffff\1\23\1\uffff\1\25\4\uffff\1\2\2\uffff\1\5\1\11\1\uffff\1"+
        "\13\3\uffff\1\24\2\uffff\1\12\17\uffff\1\14\2\uffff\1\27\22\uffff"+
        "\1\1\1\uffff\1\16\1\21\1\3\1\uffff\1\15\2\uffff\1\17\1\uffff\1\10"+
        "\1\26";
    static final String DFA11_specialS =
        "\1\1\5\uffff\1\0\u009e\uffff}>";
    static final String[] DFA11_transitionS = {
            "\41\35\1\33\3\35\1\6\2\35\1\17\1\20\2\35\1\4\15\35\1\5\1\21"+
            "\1\24\1\31\1\27\2\35\4\34\1\30\1\34\1\26\4\34\1\22\1\34\1\32"+
            "\14\34\6\35\2\25\1\16\1\25\1\1\1\11\1\12\1\25\1\2\2\25\1\23"+
            "\1\25\1\13\1\14\1\15\3\25\1\7\1\25\1\3\1\10\3\25\uff85\35",
            "\1\40\4\uffff\1\37\1\uffff\1\36",
            "\1\43\7\uffff\1\42",
            "\1\44",
            "",
            "",
            "\0\47",
            "\1\51\23\uffff\1\50",
            "\1\52",
            "\1\53",
            "\1\54\16\uffff\1\55",
            "\1\57\11\uffff\1\56",
            "\1\60",
            "\1\61\11\uffff\1\62",
            "\1\63",
            "",
            "",
            "",
            "\1\67",
            "\1\71",
            "\1\72",
            "",
            "\1\74",
            "",
            "\1\76",
            "",
            "\1\100",
            "\1\72",
            "",
            "",
            "\1\101",
            "\1\102",
            "",
            "",
            "\1\104\11\uffff\1\103",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\106",
            "",
            "",
            "",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "",
            "\1\115\5\uffff\1\114",
            "",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\135",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\137",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\141",
            "\1\142",
            "\1\143",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\10\41\1\144\21\41",
            "\1\146",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\1\147\31\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\152",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\154",
            "\1\155",
            "",
            "\1\156",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "\1\160",
            "\1\161",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\163",
            "",
            "\1\164",
            "\1\165",
            "",
            "",
            "\1\166",
            "",
            "\1\167",
            "\1\170",
            "\1\171",
            "",
            "\1\172\3\uffff\1\173",
            "\1\174",
            "",
            "\1\175",
            "\1\177\7\uffff\1\176",
            "\1\u0080",
            "\1\u0081",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u0083",
            "\1\u0084",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "",
            "\1\u008d",
            "\1\u008e",
            "",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u0099",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u009d",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\u009f",
            "",
            "\1\u00a0",
            "",
            "",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "\1\u00a2",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | LINE_COMMENT | KEY_INST | KEY_TYPE | KEY_EVENT | KEY_WITH | KEY_FLUENT | KEY_GENERATES | KEY_INITIATES | KEY_TERMINATES | KEY_IF | KEY_INITIALLY | KEY_NOT | KEY_OBLIGATION | KEY_PERM | KEY_POW | KEY_NONINERTIAL | EVENT_KEY_CREATE | LPAR | RPAR | END | TYPE | LITERAL | LT | GT | EQ | NE | ANY );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_6 = input.LA(1);

                        s = -1;
                        if ( ((LA11_6>='\u0000' && LA11_6<='\uFFFF')) ) {s = 39;}

                        else s = 29;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_0 = input.LA(1);

                        s = -1;
                        if ( (LA11_0=='e') ) {s = 1;}

                        else if ( (LA11_0=='i') ) {s = 2;}

                        else if ( (LA11_0=='v') ) {s = 3;}

                        else if ( (LA11_0==',') ) {s = 4;}

                        else if ( (LA11_0==':') ) {s = 5;}

                        else if ( (LA11_0=='%') ) {s = 6;}

                        else if ( (LA11_0=='t') ) {s = 7;}

                        else if ( (LA11_0=='w') ) {s = 8;}

                        else if ( (LA11_0=='f') ) {s = 9;}

                        else if ( (LA11_0=='g') ) {s = 10;}

                        else if ( (LA11_0=='n') ) {s = 11;}

                        else if ( (LA11_0=='o') ) {s = 12;}

                        else if ( (LA11_0=='p') ) {s = 13;}

                        else if ( (LA11_0=='c') ) {s = 14;}

                        else if ( (LA11_0=='(') ) {s = 15;}

                        else if ( (LA11_0==')') ) {s = 16;}

                        else if ( (LA11_0==';') ) {s = 17;}

                        else if ( (LA11_0=='L') ) {s = 18;}

                        else if ( (LA11_0=='l') ) {s = 19;}

                        else if ( (LA11_0=='<') ) {s = 20;}

                        else if ( ((LA11_0>='a' && LA11_0<='b')||LA11_0=='d'||LA11_0=='h'||(LA11_0>='j' && LA11_0<='k')||LA11_0=='m'||(LA11_0>='q' && LA11_0<='s')||LA11_0=='u'||(LA11_0>='x' && LA11_0<='z')) ) {s = 21;}

                        else if ( (LA11_0=='G') ) {s = 22;}

                        else if ( (LA11_0=='>') ) {s = 23;}

                        else if ( (LA11_0=='E') ) {s = 24;}

                        else if ( (LA11_0=='=') ) {s = 25;}

                        else if ( (LA11_0=='N') ) {s = 26;}

                        else if ( (LA11_0=='!') ) {s = 27;}

                        else if ( ((LA11_0>='A' && LA11_0<='D')||LA11_0=='F'||(LA11_0>='H' && LA11_0<='K')||LA11_0=='M'||(LA11_0>='O' && LA11_0<='Z')) ) {s = 28;}

                        else if ( ((LA11_0>='\u0000' && LA11_0<=' ')||(LA11_0>='\"' && LA11_0<='$')||(LA11_0>='&' && LA11_0<='\'')||(LA11_0>='*' && LA11_0<='+')||(LA11_0>='-' && LA11_0<='9')||(LA11_0>='?' && LA11_0<='@')||(LA11_0>='[' && LA11_0<='`')||(LA11_0>='{' && LA11_0<='\uFFFF')) ) {s = 29;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}