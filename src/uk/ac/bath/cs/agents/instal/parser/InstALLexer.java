// $ANTLR 3.3 Nov 30, 2010 12:45:30 InstAL.g 2011-03-29 15:18:05

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
    public static final int T__40=40;
    public static final int LINE_COMMENT=4;
    public static final int KEY_INST=5;
    public static final int END=6;
    public static final int LITERAL=7;
    public static final int KEY_TYPE=8;
    public static final int TYPE=9;
    public static final int KEY_WITH=10;
    public static final int KEY_EVENT=11;
    public static final int KEY_NONINERTIAL=12;
    public static final int KEY_FLUENT=13;
    public static final int KEY_GENERATES=14;
    public static final int KEY_IF=15;
    public static final int KEY_NOT=16;
    public static final int LPAR=17;
    public static final int RPAR=18;
    public static final int KEY_POW=19;
    public static final int KEY_PERM=20;
    public static final int KEY_INITIATES=21;
    public static final int KEY_TERMINATES=22;
    public static final int KEY_INITIALLY=23;
    public static final int KEY_OBLIGATION=24;
    public static final int VARIABLE=25;
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
            // InstAL.g:19:7: ( 'creation' )
            // InstAL.g:19:9: 'creation'
            {
            match("creation"); 


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
            // InstAL.g:20:7: ( 'violation' )
            // InstAL.g:20:9: 'violation'
            {
            match("violation"); 


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
            // InstAL.g:21:7: ( ',' )
            // InstAL.g:21:9: ','
            {
            match(','); 

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
            // InstAL.g:22:7: ( 'viol' )
            // InstAL.g:22:9: 'viol'
            {
            match("viol"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:23:7: ( ':' )
            // InstAL.g:23:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:576:2: ( '%' ( (~ ( '\\r' | '\\n' ) )* ) ( '\\r' )? '\\n' )
            // InstAL.g:576:4: '%' ( (~ ( '\\r' | '\\n' ) )* ) ( '\\r' )? '\\n'
            {
            match('%'); 
            // InstAL.g:576:8: ( (~ ( '\\r' | '\\n' ) )* )
            // InstAL.g:576:10: (~ ( '\\r' | '\\n' ) )*
            {
            // InstAL.g:576:10: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InstAL.g:576:10: ~ ( '\\r' | '\\n' )
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

            // InstAL.g:576:26: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InstAL.g:576:26: '\\r'
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
            // InstAL.g:580:10: ( ( 'institution' | 'inst' ) )
            // InstAL.g:580:12: ( 'institution' | 'inst' )
            {
            // InstAL.g:580:12: ( 'institution' | 'inst' )
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
                    // InstAL.g:580:14: 'institution'
                    {
                    match("institution"); 


                    }
                    break;
                case 2 :
                    // InstAL.g:580:30: 'inst'
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
            // InstAL.g:581:10: ( 'type' )
            // InstAL.g:581:12: 'type'
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
            // InstAL.g:582:11: ( 'event' )
            // InstAL.g:582:13: 'event'
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
            // InstAL.g:583:10: ( 'with' )
            // InstAL.g:583:12: 'with'
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
            // InstAL.g:584:12: ( 'fluent' )
            // InstAL.g:584:14: 'fluent'
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
            // InstAL.g:585:15: ( 'generates' )
            // InstAL.g:585:17: 'generates'
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
            // InstAL.g:586:15: ( 'initiates' )
            // InstAL.g:586:17: 'initiates'
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
            // InstAL.g:587:16: ( 'terminates' )
            // InstAL.g:587:18: 'terminates'
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
            // InstAL.g:588:9: ( 'if' )
            // InstAL.g:588:11: 'if'
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
            // InstAL.g:589:15: ( 'initially' )
            // InstAL.g:589:17: 'initially'
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
            // InstAL.g:590:10: ( 'not' )
            // InstAL.g:590:12: 'not'
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
            // InstAL.g:591:16: ( 'obl' )
            // InstAL.g:591:18: 'obl'
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
            // InstAL.g:592:10: ( 'perm' )
            // InstAL.g:592:12: 'perm'
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
            // InstAL.g:593:10: ( 'pow' )
            // InstAL.g:593:12: 'pow'
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
            // InstAL.g:594:17: ( 'noninertial' )
            // InstAL.g:594:19: 'noninertial'
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

    // $ANTLR start "LPAR"
    public final void mLPAR() throws RecognitionException {
        try {
            int _type = LPAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:596:6: ( '(' )
            // InstAL.g:596:8: '('
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
            // InstAL.g:597:6: ( ')' )
            // InstAL.g:597:8: ')'
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
            // InstAL.g:598:5: ( ';' )
            // InstAL.g:598:7: ';'
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

    // $ANTLR start "VARIABLE"
    public final void mVARIABLE() throws RecognitionException {
        try {
            int _type = VARIABLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:599:9: ( ( UCALPHA | DIGIT )+ )
            // InstAL.g:599:11: ( UCALPHA | DIGIT )+
            {
            // InstAL.g:599:11: ( UCALPHA | DIGIT )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InstAL.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VARIABLE"

    // $ANTLR start "TYPE"
    public final void mTYPE() throws RecognitionException {
        try {
            int _type = TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InstAL.g:600:6: ( UCALPHA ( DIGIT | UCALPHA | LCALPHA | '_' )* )
            // InstAL.g:600:8: UCALPHA ( DIGIT | UCALPHA | LCALPHA | '_' )*
            {
            mUCALPHA(); 
            // InstAL.g:600:16: ( DIGIT | UCALPHA | LCALPHA | '_' )*
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
            // InstAL.g:601:9: ( LCALPHA ( DIGIT | UCALPHA | LCALPHA | '_' )* )
            // InstAL.g:601:11: LCALPHA ( DIGIT | UCALPHA | LCALPHA | '_' )*
            {
            mLCALPHA(); 
            // InstAL.g:601:19: ( DIGIT | UCALPHA | LCALPHA | '_' )*
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
            // InstAL.g:602:4: ( ( '<' | 'lt' | 'LT' ) )
            // InstAL.g:602:6: ( '<' | 'lt' | 'LT' )
            {
            // InstAL.g:602:6: ( '<' | 'lt' | 'LT' )
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
                    // InstAL.g:602:8: '<'
                    {
                    match('<'); 

                    }
                    break;
                case 2 :
                    // InstAL.g:602:14: 'lt'
                    {
                    match("lt"); 


                    }
                    break;
                case 3 :
                    // InstAL.g:602:21: 'LT'
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
            // InstAL.g:603:4: ( ( '>' | 'gt' | 'GT' ) )
            // InstAL.g:603:6: ( '>' | 'gt' | 'GT' )
            {
            // InstAL.g:603:6: ( '>' | 'gt' | 'GT' )
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
                    // InstAL.g:603:8: '>'
                    {
                    match('>'); 

                    }
                    break;
                case 2 :
                    // InstAL.g:603:14: 'gt'
                    {
                    match("gt"); 


                    }
                    break;
                case 3 :
                    // InstAL.g:603:21: 'GT'
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
            // InstAL.g:604:4: ( ( '=' | '==' | 'eq' | 'EQ' ) )
            // InstAL.g:604:6: ( '=' | '==' | 'eq' | 'EQ' )
            {
            // InstAL.g:604:6: ( '=' | '==' | 'eq' | 'EQ' )
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
                    // InstAL.g:604:8: '='
                    {
                    match('='); 

                    }
                    break;
                case 2 :
                    // InstAL.g:604:14: '=='
                    {
                    match("=="); 


                    }
                    break;
                case 3 :
                    // InstAL.g:604:21: 'eq'
                    {
                    match("eq"); 


                    }
                    break;
                case 4 :
                    // InstAL.g:604:28: 'EQ'
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
            // InstAL.g:605:4: ( ( '!=' | 'ne' | 'NE' | '<>' ) )
            // InstAL.g:605:6: ( '!=' | 'ne' | 'NE' | '<>' )
            {
            // InstAL.g:605:6: ( '!=' | 'ne' | 'NE' | '<>' )
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
                    // InstAL.g:605:8: '!='
                    {
                    match("!="); 


                    }
                    break;
                case 2 :
                    // InstAL.g:605:15: 'ne'
                    {
                    match("ne"); 


                    }
                    break;
                case 3 :
                    // InstAL.g:605:22: 'NE'
                    {
                    match("NE"); 


                    }
                    break;
                case 4 :
                    // InstAL.g:605:29: '<>'
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
            // InstAL.g:607:18: ( 'A' .. 'Z' )
            // InstAL.g:607:20: 'A' .. 'Z'
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
            // InstAL.g:608:18: ( 'a' .. 'z' )
            // InstAL.g:608:20: 'a' .. 'z'
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
            // InstAL.g:609:17: ( '0' .. '9' )
            // InstAL.g:609:19: '0' .. '9'
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
            // InstAL.g:611:5: ( . )
            // InstAL.g:611:8: .
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
        // InstAL.g:1:8: ( T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | LINE_COMMENT | KEY_INST | KEY_TYPE | KEY_EVENT | KEY_WITH | KEY_FLUENT | KEY_GENERATES | KEY_INITIATES | KEY_TERMINATES | KEY_IF | KEY_INITIALLY | KEY_NOT | KEY_OBLIGATION | KEY_PERM | KEY_POW | KEY_NONINERTIAL | LPAR | RPAR | END | VARIABLE | TYPE | LITERAL | LT | GT | EQ | NE | ANY )
        int alt11=34;
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
                // InstAL.g:1:46: T__40
                {
                mT__40(); 

                }
                break;
            case 8 :
                // InstAL.g:1:52: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;
            case 9 :
                // InstAL.g:1:65: KEY_INST
                {
                mKEY_INST(); 

                }
                break;
            case 10 :
                // InstAL.g:1:74: KEY_TYPE
                {
                mKEY_TYPE(); 

                }
                break;
            case 11 :
                // InstAL.g:1:83: KEY_EVENT
                {
                mKEY_EVENT(); 

                }
                break;
            case 12 :
                // InstAL.g:1:93: KEY_WITH
                {
                mKEY_WITH(); 

                }
                break;
            case 13 :
                // InstAL.g:1:102: KEY_FLUENT
                {
                mKEY_FLUENT(); 

                }
                break;
            case 14 :
                // InstAL.g:1:113: KEY_GENERATES
                {
                mKEY_GENERATES(); 

                }
                break;
            case 15 :
                // InstAL.g:1:127: KEY_INITIATES
                {
                mKEY_INITIATES(); 

                }
                break;
            case 16 :
                // InstAL.g:1:141: KEY_TERMINATES
                {
                mKEY_TERMINATES(); 

                }
                break;
            case 17 :
                // InstAL.g:1:156: KEY_IF
                {
                mKEY_IF(); 

                }
                break;
            case 18 :
                // InstAL.g:1:163: KEY_INITIALLY
                {
                mKEY_INITIALLY(); 

                }
                break;
            case 19 :
                // InstAL.g:1:177: KEY_NOT
                {
                mKEY_NOT(); 

                }
                break;
            case 20 :
                // InstAL.g:1:185: KEY_OBLIGATION
                {
                mKEY_OBLIGATION(); 

                }
                break;
            case 21 :
                // InstAL.g:1:200: KEY_PERM
                {
                mKEY_PERM(); 

                }
                break;
            case 22 :
                // InstAL.g:1:209: KEY_POW
                {
                mKEY_POW(); 

                }
                break;
            case 23 :
                // InstAL.g:1:217: KEY_NONINERTIAL
                {
                mKEY_NONINERTIAL(); 

                }
                break;
            case 24 :
                // InstAL.g:1:233: LPAR
                {
                mLPAR(); 

                }
                break;
            case 25 :
                // InstAL.g:1:238: RPAR
                {
                mRPAR(); 

                }
                break;
            case 26 :
                // InstAL.g:1:243: END
                {
                mEND(); 

                }
                break;
            case 27 :
                // InstAL.g:1:247: VARIABLE
                {
                mVARIABLE(); 

                }
                break;
            case 28 :
                // InstAL.g:1:256: TYPE
                {
                mTYPE(); 

                }
                break;
            case 29 :
                // InstAL.g:1:261: LITERAL
                {
                mLITERAL(); 

                }
                break;
            case 30 :
                // InstAL.g:1:269: LT
                {
                mLT(); 

                }
                break;
            case 31 :
                // InstAL.g:1:272: GT
                {
                mGT(); 

                }
                break;
            case 32 :
                // InstAL.g:1:275: EQ
                {
                mEQ(); 

                }
                break;
            case 33 :
                // InstAL.g:1:278: NE
                {
                mNE(); 

                }
                break;
            case 34 :
                // InstAL.g:1:281: ANY
                {
                mANY(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\1\uffff\4\42\2\uffff\1\36\7\42\3\uffff\1\71\1\uffff\1\42\1\76\1"+
        "\uffff\1\71\1\uffff\1\71\1\uffff\1\71\1\36\1\71\1\uffff\2\42\2\uffff"+
        "\1\42\1\110\2\42\3\uffff\5\42\1\uffff\1\42\1\uffff\3\42\3\uffff"+
        "\1\71\1\uffff\1\71\4\uffff\1\71\1\uffff\1\71\1\uffff\1\71\4\42\1"+
        "\uffff\7\42\1\140\1\42\1\142\1\42\1\144\2\42\1\150\2\42\1\154\1"+
        "\155\1\42\1\157\2\42\1\uffff\1\42\1\uffff\1\163\1\uffff\1\42\1\165"+
        "\1\42\1\uffff\3\42\2\uffff\1\42\1\uffff\3\42\1\uffff\1\42\1\uffff"+
        "\5\42\1\u0085\11\42\1\uffff\6\42\1\u0095\4\42\1\u009a\1\42\1\u009c"+
        "\1\u009d\1\uffff\1\u009e\1\42\1\u00a0\1\42\1\uffff\1\42\3\uffff"+
        "\1\u00a3\1\uffff\1\42\1\u00a5\1\uffff\1\u00a6\2\uffff";
    static final String DFA11_eofS =
        "\u00a7\uffff";
    static final String DFA11_minS =
        "\1\0\1\161\1\146\1\162\1\151\2\uffff\1\0\1\145\1\151\1\154\2\145"+
        "\1\142\1\145\3\uffff\1\60\1\uffff\1\164\1\76\1\uffff\1\60\1\uffff"+
        "\1\60\1\uffff\1\60\1\75\1\60\1\uffff\1\157\1\145\2\uffff\1\151\1"+
        "\60\1\145\1\157\3\uffff\1\160\1\162\1\164\1\165\1\156\1\uffff\1"+
        "\156\1\uffff\1\154\1\162\1\167\3\uffff\1\60\1\uffff\1\60\4\uffff"+
        "\1\60\1\uffff\1\60\1\uffff\1\60\1\147\1\156\2\164\1\uffff\1\141"+
        "\1\154\1\145\1\155\1\150\2\145\1\60\1\151\1\60\1\155\1\60\1\145"+
        "\1\164\1\60\1\151\1\164\2\60\1\151\1\60\1\156\1\162\1\uffff\1\156"+
        "\1\uffff\1\60\1\uffff\1\156\1\60\1\164\1\uffff\1\141\1\151\1\164"+
        "\2\uffff\1\156\1\uffff\1\164\1\141\1\145\1\uffff\1\157\1\uffff\1"+
        "\165\1\154\1\157\1\151\1\141\1\60\1\164\1\162\1\165\1\164\1\145"+
        "\1\154\1\156\1\157\1\164\1\uffff\1\145\1\164\1\163\1\151\1\163\1"+
        "\171\1\60\1\156\1\145\1\163\1\151\1\60\1\157\2\60\1\uffff\1\60\1"+
        "\163\1\60\1\141\1\uffff\1\156\3\uffff\1\60\1\uffff\1\154\1\60\1"+
        "\uffff\1\60\2\uffff";
    static final String DFA11_maxS =
        "\1\uffff\1\170\1\156\1\162\1\151\2\uffff\1\uffff\1\171\1\151\1\154"+
        "\1\164\1\157\1\142\1\157\3\uffff\1\172\1\uffff\1\164\1\76\1\uffff"+
        "\1\172\1\uffff\1\172\1\uffff\1\172\1\75\1\172\1\uffff\1\157\1\145"+
        "\2\uffff\1\163\1\172\1\145\1\157\3\uffff\1\160\1\162\1\164\1\165"+
        "\1\156\1\uffff\1\164\1\uffff\1\154\1\162\1\167\3\uffff\1\172\1\uffff"+
        "\1\172\4\uffff\1\172\1\uffff\1\172\1\uffff\1\172\1\147\1\156\2\164"+
        "\1\uffff\1\141\1\154\1\145\1\155\1\150\2\145\1\172\1\151\1\172\1"+
        "\155\1\172\1\145\1\164\1\172\1\151\1\164\2\172\1\151\1\172\1\156"+
        "\1\162\1\uffff\1\156\1\uffff\1\172\1\uffff\1\156\1\172\1\164\1\uffff"+
        "\1\141\1\151\1\164\2\uffff\1\156\1\uffff\1\164\1\141\1\145\1\uffff"+
        "\1\157\1\uffff\1\165\1\164\1\157\1\151\1\141\1\172\1\164\1\162\1"+
        "\165\1\164\1\145\1\154\1\156\1\157\1\164\1\uffff\1\145\1\164\1\163"+
        "\1\151\1\163\1\171\1\172\1\156\1\145\1\163\1\151\1\172\1\157\2\172"+
        "\1\uffff\1\172\1\163\1\172\1\141\1\uffff\1\156\3\uffff\1\172\1\uffff"+
        "\1\154\1\172\1\uffff\1\172\2\uffff";
    static final String DFA11_acceptS =
        "\5\uffff\1\5\1\7\10\uffff\1\30\1\31\1\32\1\uffff\1\33\2\uffff\1"+
        "\35\1\uffff\1\37\1\uffff\1\40\3\uffff\1\42\2\uffff\2\35\4\uffff"+
        "\1\5\1\7\1\10\5\uffff\1\35\1\uffff\1\35\3\uffff\1\30\1\31\1\32\1"+
        "\uffff\1\33\1\uffff\1\34\1\35\1\41\1\36\1\uffff\1\37\1\uffff\1\40"+
        "\5\uffff\1\21\27\uffff\1\23\1\uffff\1\24\1\uffff\1\26\3\uffff\1"+
        "\2\3\uffff\1\6\1\12\1\uffff\1\14\3\uffff\1\25\1\uffff\1\13\17\uffff"+
        "\1\15\17\uffff\1\3\4\uffff\1\1\1\uffff\1\17\1\22\1\4\1\uffff\1\16"+
        "\2\uffff\1\20\1\uffff\1\11\1\27";
    static final String DFA11_specialS =
        "\1\1\6\uffff\1\0\u009f\uffff}>";
    static final String[] DFA11_transitionS = {
            "\41\36\1\34\3\36\1\7\2\36\1\17\1\20\2\36\1\5\3\36\12\23\1\6"+
            "\1\21\1\25\1\32\1\30\2\36\4\35\1\31\1\35\1\27\4\35\1\22\1\35"+
            "\1\33\14\35\6\36\2\26\1\3\1\26\1\1\1\12\1\13\1\26\1\2\2\26\1"+
            "\24\1\26\1\14\1\15\1\16\3\26\1\10\1\26\1\4\1\11\3\26\uff85\36",
            "\1\41\4\uffff\1\40\1\uffff\1\37",
            "\1\44\7\uffff\1\43",
            "\1\45",
            "\1\46",
            "",
            "",
            "\0\51",
            "\1\53\23\uffff\1\52",
            "\1\54",
            "\1\55",
            "\1\56\16\uffff\1\57",
            "\1\61\11\uffff\1\60",
            "\1\62",
            "\1\63\11\uffff\1\64",
            "",
            "",
            "",
            "\12\72\7\uffff\23\72\1\70\6\72\4\uffff\1\73\1\uffff\32\73",
            "",
            "\1\74",
            "\1\75",
            "",
            "\12\72\7\uffff\23\72\1\77\6\72\4\uffff\1\73\1\uffff\32\73",
            "",
            "\12\72\7\uffff\20\72\1\101\11\72\4\uffff\1\73\1\uffff\32\73",
            "",
            "\12\72\7\uffff\4\72\1\103\25\72\4\uffff\1\73\1\uffff\32\73",
            "\1\75",
            "\12\72\7\uffff\32\72\4\uffff\1\73\1\uffff\32\73",
            "",
            "\1\104",
            "\1\105",
            "",
            "",
            "\1\107\11\uffff\1\106",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\111",
            "\1\112",
            "",
            "",
            "",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "",
            "\1\121\5\uffff\1\120",
            "",
            "\1\122",
            "\1\123",
            "\1\124",
            "",
            "",
            "",
            "\12\72\7\uffff\32\72\4\uffff\1\73\1\uffff\32\73",
            "",
            "\12\72\7\uffff\32\72\4\uffff\1\73\1\uffff\32\73",
            "",
            "",
            "",
            "",
            "\12\72\7\uffff\32\72\4\uffff\1\73\1\uffff\32\73",
            "",
            "\12\72\7\uffff\32\72\4\uffff\1\73\1\uffff\32\73",
            "",
            "\12\72\7\uffff\32\72\4\uffff\1\73\1\uffff\32\73",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\141",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\143",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\145",
            "\1\146",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\10\42\1\147\21\42",
            "\1\151",
            "\1\152",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\1\153\31\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\156",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\160",
            "\1\161",
            "",
            "\1\162",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\1\164",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\166",
            "",
            "\1\167",
            "\1\170",
            "\1\171",
            "",
            "",
            "\1\172",
            "",
            "\1\173",
            "\1\174",
            "\1\175",
            "",
            "\1\176",
            "",
            "\1\177",
            "\1\u0081\7\uffff\1\u0080",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u009b",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u009f",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "\1\u00a1",
            "",
            "\1\u00a2",
            "",
            "",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\1\u00a4",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
            "",
            "\12\42\7\uffff\32\42\4\uffff\1\42\1\uffff\32\42",
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
            return "1:1: Tokens : ( T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | LINE_COMMENT | KEY_INST | KEY_TYPE | KEY_EVENT | KEY_WITH | KEY_FLUENT | KEY_GENERATES | KEY_INITIATES | KEY_TERMINATES | KEY_IF | KEY_INITIALLY | KEY_NOT | KEY_OBLIGATION | KEY_PERM | KEY_POW | KEY_NONINERTIAL | LPAR | RPAR | END | VARIABLE | TYPE | LITERAL | LT | GT | EQ | NE | ANY );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_7 = input.LA(1);

                        s = -1;
                        if ( ((LA11_7>='\u0000' && LA11_7<='\uFFFF')) ) {s = 41;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_0 = input.LA(1);

                        s = -1;
                        if ( (LA11_0=='e') ) {s = 1;}

                        else if ( (LA11_0=='i') ) {s = 2;}

                        else if ( (LA11_0=='c') ) {s = 3;}

                        else if ( (LA11_0=='v') ) {s = 4;}

                        else if ( (LA11_0==',') ) {s = 5;}

                        else if ( (LA11_0==':') ) {s = 6;}

                        else if ( (LA11_0=='%') ) {s = 7;}

                        else if ( (LA11_0=='t') ) {s = 8;}

                        else if ( (LA11_0=='w') ) {s = 9;}

                        else if ( (LA11_0=='f') ) {s = 10;}

                        else if ( (LA11_0=='g') ) {s = 11;}

                        else if ( (LA11_0=='n') ) {s = 12;}

                        else if ( (LA11_0=='o') ) {s = 13;}

                        else if ( (LA11_0=='p') ) {s = 14;}

                        else if ( (LA11_0=='(') ) {s = 15;}

                        else if ( (LA11_0==')') ) {s = 16;}

                        else if ( (LA11_0==';') ) {s = 17;}

                        else if ( (LA11_0=='L') ) {s = 18;}

                        else if ( ((LA11_0>='0' && LA11_0<='9')) ) {s = 19;}

                        else if ( (LA11_0=='l') ) {s = 20;}

                        else if ( (LA11_0=='<') ) {s = 21;}

                        else if ( ((LA11_0>='a' && LA11_0<='b')||LA11_0=='d'||LA11_0=='h'||(LA11_0>='j' && LA11_0<='k')||LA11_0=='m'||(LA11_0>='q' && LA11_0<='s')||LA11_0=='u'||(LA11_0>='x' && LA11_0<='z')) ) {s = 22;}

                        else if ( (LA11_0=='G') ) {s = 23;}

                        else if ( (LA11_0=='>') ) {s = 24;}

                        else if ( (LA11_0=='E') ) {s = 25;}

                        else if ( (LA11_0=='=') ) {s = 26;}

                        else if ( (LA11_0=='N') ) {s = 27;}

                        else if ( (LA11_0=='!') ) {s = 28;}

                        else if ( ((LA11_0>='A' && LA11_0<='D')||LA11_0=='F'||(LA11_0>='H' && LA11_0<='K')||LA11_0=='M'||(LA11_0>='O' && LA11_0<='Z')) ) {s = 29;}

                        else if ( ((LA11_0>='\u0000' && LA11_0<=' ')||(LA11_0>='\"' && LA11_0<='$')||(LA11_0>='&' && LA11_0<='\'')||(LA11_0>='*' && LA11_0<='+')||(LA11_0>='-' && LA11_0<='/')||(LA11_0>='?' && LA11_0<='@')||(LA11_0>='[' && LA11_0<='`')||(LA11_0>='{' && LA11_0<='\uFFFF')) ) {s = 30;}

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