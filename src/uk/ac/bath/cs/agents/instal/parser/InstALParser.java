// $ANTLR 3.3 Nov 30, 2010 12:45:30 InstAL.g 2011-03-31 01:24:21

	package uk.ac.bath.cs.agents.instal.parser;
	
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.Hashtable;
	
	import uk.ac.bath.cs.agents.instal.*;
	import uk.ac.bath.cs.agents.instal.asp.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class InstALParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LINE_COMMENT", "KEY_INST", "END", "LITERAL", "KEY_TYPE", "TYPE", "KEY_WITH", "KEY_EVENT", "KEY_NONINERTIAL", "KEY_FLUENT", "KEY_GENERATES", "KEY_IF", "KEY_NOT", "LPAR", "RPAR", "KEY_POW", "KEY_PERM", "KEY_INITIATES", "KEY_TERMINATES", "KEY_INITIALLY", "KEY_OBLIGATION", "VARIABLE", "LT", "GT", "EQ", "NE", "UCALPHA", "DIGIT", "LCALPHA", "ANY", "'exogenous'", "'inst'", "'creation'", "'violation'", "','", "'viol'", "':'"
    };
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


        public InstALParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InstALParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return InstALParser.tokenNames; }
    public String getGrammarFileName() { return "InstAL.g"; }

    	
    	public Institution i;
    	public Domain d = new Domain();
    	protected Hashtable<String, Type> _typeMap = new Hashtable<String, Type>();
    	protected Hashtable<String, Fluent> _fluentMap = new Hashtable<String, Fluent>();
    	protected Hashtable<String, uk.ac.bath.cs.agents.instal.Event> _eventMap = new Hashtable<String, uk.ac.bath.cs.agents.instal.Event>();

    	private static void log(String message) {
    		System.err.println("[antlr]: " + message);
    	}
    	
    	private static void log(ArrayList<String> list) {
    		log(list.toArray(new String[] {}));
    	}
    	
    	private static void log(String[] list) {
    		log("list start");
    		for (int i = 0; i < list.length; i++) {
    			log("item: " + list[i]);
    		}
    		log("list end");
    	}

    	private void outputASP() {
    		AnsProlog asp = new AnsProlog(this.i, this.d);
    		asp.generate();
    		//System.out.println(asp.toString());
    	}
    	
    	// Constructors
    	protected void _setInsitutionName(String name) {
    		i = new Institution(name, 10);
    	}
    	
    	protected void _addType(String name) {
    		if (_typeMap.containsKey(name)) {
    			emitErrorMessage("Type '" + name + "' already defined");
    		}
    	
    		Type t = new Type(name);
    		i.type(t);
    		
    		_typeMap.put(name, t);
    	}
    	
    	// OMGWTFBBQ!
    	protected void _addEvent(String type, String name, ArrayList<String> args) {
    		if (type.equals("exogenous")) {
    			ExogenousEvent e = new ExogenousEvent(name);
    			if (args != null) {
    				Iterator<String> iter = args.iterator();
    				while (iter.hasNext()) {
    					String key = iter.next();
    					Type t = _getType(key);
    		
    					e.addParameter(t);
    				}
    			}
    			i.event(e);
    			_eventMap.put(name, e);
    		} else if (type.equals("inst")) {
    			NormativeEvent e = new NormativeEvent(name);
    			if (args != null) {
    				Iterator<String> iter = args.iterator();
    				while (iter.hasNext()) {
    					String key = iter.next();
    					Type t = _getType(key);
    		
    					e.addParameter(t);
    				}
    			}
    			i.event(e);
    			_eventMap.put(name, e);
    		} else if (type.equals("creation")) {
    			log("Created creation event: " + name);
    			CreationEvent e = new CreationEvent(name);
    			if (args != null) {
    				Iterator<String> iter = args.iterator();
    				while (iter.hasNext()) {
    					String key = iter.next();
    					Type t = _getType(key);
    		
    					e.addParameter(t);
    				}
    			}
    			i.event(e);
    			_eventMap.put(name, e);
    		} else if (type.equals("violation")) {
    			ViolationEvent e = new ViolationEvent(name);
    			if (args != null) {
    				Iterator<String> iter = args.iterator();
    				while (iter.hasNext()) {
    					String key = iter.next();
    					Type t = _getType(key);
    		
    					e.addParameter(t);
    				}
    			}
    			i.event(e);
    			_eventMap.put(name, e);
    		} else {
    			emitErrorMessage("Unrecognised event type '" + type + "'");
    			return;
    		}
    	}
    	
    	protected void _addFluent(String type, String name, ArrayList<String> args) {
    	
    		if (_fluentMap.containsKey(name)) {
    			emitErrorMessage("Fluent '" + name + "' already defined");
    			return;
    		}
    	
    		if (type.equals("noninertial")) {
    			NoninertialFluent f = new NoninertialFluent(name);
    			
    			if (args != null) {
    				Iterator<String> iter = args.iterator();
    				while (iter.hasNext()) {
    					String key = iter.next();
    					Type t = _getType(key);
    		
    					f.addParameter(t);
    				}
    			}
    			
    			i.fluent(f);
    			
    			_fluentMap.put(name, f);
    		} else if (type.equals("inertial")) {
    			Fluent f = new Fluent(name);
    			
    			if (args != null) {
    				Iterator<String> iter = args.iterator();
    				while (iter.hasNext()) {
    					String key = iter.next();
    					Type t = _getType(key);
    		
    					f.addParameter(t);
    				}
    			}
    			
    			i.fluent(f);
    			
    			_fluentMap.put(name, f);
    		} else {
    			emitErrorMessage("Unrecognised fluent type '" + type + "'");
    			return;
    		}
    	}

    	protected void _addGeneratesRule(String event, ArrayList<String> event_variables, ArrayList<EventWithVariables> result_events, ArrayList<FluentCondition> condition_fluents) {
    		String[] event_vars_array = new String[] {};
    		
    		if (event_variables != null) {
    			event_vars_array = event_variables.toArray(new String[] {});
    		}
    	
    		if (_getEvent(event) != null) {
    			Generates g = new Generates(_getEvent(event), event_vars_array);
    			
    			g = (Generates) _addRuleConditions(g,condition_fluents);
    			g = (Generates) _addRuleResultEvents(g,result_events);
    			
    			i.generates(g);
    		}
    	}
    	
    	protected void _addInitiatesRule(String event, ArrayList<String> event_variables, ArrayList<FluentCondition> result_fluents, ArrayList<FluentCondition> condition_fluents) {
    		String[] event_vars_array = new String[] {};
    		
    		if (event_variables != null) {
    			event_vars_array = event_variables.toArray(new String[] {});
    		}
    		
    		log("Initiates event: " + event);
    	
    		if (_getEvent(event) != null) {
    			Initiates in = new Initiates(_getEvent(event), event_vars_array);
    			
    			if (_checkFluentsExist(result_fluents) && _checkFluentsExist(condition_fluents)) {	
    				in = (Initiates) _addRuleConditions(in, condition_fluents);
    				in = (Initiates) _addRuleResultFluents(in, result_fluents);
    				
    				i.initiates(in);
    			} else {
    				log("Ignoring inititates because there are fluents that don't exist");
    			}
    		}
    	}

    	protected void _addTerminatesRule(String event, ArrayList<String> event_variables, ArrayList<FluentCondition> result_fluents, ArrayList<FluentCondition> condition_fluents) {
    		String[] event_vars_array = new String[] {};
    		
    		if (event_variables != null) {
    			event_vars_array = event_variables.toArray(new String[] {});
    		}
    	
    		if (_getEvent(event) != null) {
    			Terminates t = new Terminates(_getEvent(event), event_vars_array);
    			
    			if (_checkFluentsExist(result_fluents) && _checkFluentsExist(condition_fluents)) {	
    				t = (Terminates) _addRuleConditions(t, condition_fluents);
    				t = (Terminates) _addRuleResultFluents(t, result_fluents);
    				
    				i.terminates(t);
    			} else {
    				log("Ignoring terminates because there are fluents that don't exist");
    			}
    		}
    	}
    	
    	protected Rule _addRuleConditions(Rule r, ArrayList<FluentCondition> condition_fluents) {
    		// Conditions
    		if (condition_fluents != null) {
    			Iterator<FluentCondition> iter2 = condition_fluents.iterator();
    			while (iter2.hasNext()) {
    				FluentCondition cond = iter2.next();
    				
    				log("Condition: +/-?" + cond.fluent);
    				
    				if (cond.sign) {
    					r.condition(_getFluent(cond.fluent), cond.args);
    				} else {
    					r.condition(false, _getFluent(cond.fluent), cond.args);
    				}
    			}
    		}
    		
    		return r;
    	}
    	
    	protected Rule _addRuleResultFluents(Rule r, ArrayList<FluentCondition> result_fluents) {
    		// Results
    		if (result_fluents != null) {
    			Iterator<FluentCondition> iter = result_fluents.iterator();
    			while (iter.hasNext()) {
    				FluentCondition f_v = iter.next();
    				
    				log("Fluent Result: " + f_v.fluent);
    				
    				if (f_v.args == null) {
    					r.result(_getFluent(f_v.fluent));
    				} else {
    					r.result(_getFluent(f_v.fluent), f_v.args);
    				}
    			}
    		}
    		
    		return r;
    	}
    	
    	protected Rule _addRuleResultEvents(Rule r, ArrayList<EventWithVariables> result_events) {
    		// Results
    		if (result_events != null) {
    			Iterator<EventWithVariables> iter = result_events.iterator();
    			while (iter.hasNext()) {
    				EventWithVariables e_v = iter.next();
    				
    				log("Event Result: " + e_v.name);
    				
    				if (e_v.args == null) {
    					r.result(_getEvent(e_v.name));
    				} else {
    					r.result(_getEvent(e_v.name), e_v.args);
    				}
    			}
    		}
    		
    		return r;
    	}
    	
    	// Utility
    	protected Type _getType(String name) {
    		if (_typeMap.containsKey(name)) {
    			return _typeMap.get(name);
    		} else {
    			emitErrorMessage("Type '" + name + "' is undefined");
    			return null;
    		}
    	}
    	
    	protected uk.ac.bath.cs.agents.instal.Event _getEvent(String name) {
    		if (_eventMap.containsKey(name)) {
    			return _eventMap.get(name);
    		} else {
    			emitErrorMessage("Event '" + name + "' is undefined");
    			return null;
    		}
    	}
    	
    	protected Fluent _getFluent(String name) {
    		if(_fluentMap.containsKey(name)) {
    			return _fluentMap.get(name);
    		} else {
    			emitErrorMessage("Fluent '" + name + "' is undefined");
    			return null;
    		}
    	}
    	
    	protected boolean _checkFluentsExist(ArrayList<FluentCondition> fluents) {
    		if (fluents != null) {
    			Iterator<FluentCondition> iter = fluents.iterator();
    			while(iter.hasNext()) {
    				FluentCondition f = iter.next();
    				
    				if (_getFluent(f.fluent) == null) {
    					return false;
    				}
    			}
    		}
    		
    		return true;
    	}
    	
    	private class FluentCondition {
    		public boolean sign;
    		public String fluent;
    		public String[] args;
    		
    		public FluentCondition(boolean sign, String fluent, ArrayList<String> args) {
    			this.sign = sign;
    			this.fluent = fluent;
    			
    			if (args != null) {
    				this.args = args.toArray(new String[] {});
    			} else {
    				this.args = null;
    			}
    		}
    	}
    	
    	private class EventWithVariables {
    		public String name;
    		public String[] args;
    		
    		public EventWithVariables(String name, ArrayList<String> variables) {
    			this.name = name;
    			
    			if (variables != null) {
    				this.args = variables.toArray(new String[] {});
    			} else {
    				this.args = null;
    			}
    		}
    	}
    	
    	@Override
      	public void reportError(RecognitionException e) {
      		try {
      			throw e;
      		} catch (NoViableAltException e1) {
      		
      		} catch (Exception e2) {
      			throw new IllegalArgumentException(e);
      		}
      	}


    public static class instal_specification_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instal_specification"
    // InstAL.g:389:1: instal_specification : institution_decl ( constituent_decl | LINE_COMMENT )* ( initially_decl | LINE_COMMENT )* EOF ;
    public final InstALParser.instal_specification_return instal_specification() throws RecognitionException {
        InstALParser.instal_specification_return retval = new InstALParser.instal_specification_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LINE_COMMENT3=null;
        Token LINE_COMMENT5=null;
        Token EOF6=null;
        InstALParser.institution_decl_return institution_decl1 = null;

        InstALParser.constituent_decl_return constituent_decl2 = null;

        InstALParser.initially_decl_return initially_decl4 = null;


        CommonTree LINE_COMMENT3_tree=null;
        CommonTree LINE_COMMENT5_tree=null;
        CommonTree EOF6_tree=null;

        try {
            // InstAL.g:390:2: ( institution_decl ( constituent_decl | LINE_COMMENT )* ( initially_decl | LINE_COMMENT )* EOF )
            // InstAL.g:391:3: institution_decl ( constituent_decl | LINE_COMMENT )* ( initially_decl | LINE_COMMENT )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_institution_decl_in_instal_specification58);
            institution_decl1=institution_decl();

            state._fsp--;

            adaptor.addChild(root_0, institution_decl1.getTree());
             _setInsitutionName((institution_decl1!=null?institution_decl1.name:null)); 
            // InstAL.g:392:3: ( constituent_decl | LINE_COMMENT )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==LINE_COMMENT) ) {
                    alt1=2;
                }
                else if ( ((LA1_0>=LITERAL && LA1_0<=KEY_TYPE)||(LA1_0>=KEY_NONINERTIAL && LA1_0<=KEY_FLUENT)||LA1_0==KEY_OBLIGATION||(LA1_0>=34 && LA1_0<=37)||LA1_0==39) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InstAL.g:392:5: constituent_decl
            	    {
            	    pushFollow(FOLLOW_constituent_decl_in_instal_specification69);
            	    constituent_decl2=constituent_decl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, constituent_decl2.getTree());

            	    }
            	    break;
            	case 2 :
            	    // InstAL.g:392:24: LINE_COMMENT
            	    {
            	    LINE_COMMENT3=(Token)match(input,LINE_COMMENT,FOLLOW_LINE_COMMENT_in_instal_specification73); 
            	    LINE_COMMENT3_tree = (CommonTree)adaptor.create(LINE_COMMENT3);
            	    adaptor.addChild(root_0, LINE_COMMENT3_tree);


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InstAL.g:393:3: ( initially_decl | LINE_COMMENT )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==KEY_INITIALLY) ) {
                    alt2=1;
                }
                else if ( (LA2_0==LINE_COMMENT) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // InstAL.g:393:5: initially_decl
            	    {
            	    pushFollow(FOLLOW_initially_decl_in_instal_specification82);
            	    initially_decl4=initially_decl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, initially_decl4.getTree());

            	    }
            	    break;
            	case 2 :
            	    // InstAL.g:393:24: LINE_COMMENT
            	    {
            	    LINE_COMMENT5=(Token)match(input,LINE_COMMENT,FOLLOW_LINE_COMMENT_in_instal_specification88); 
            	    LINE_COMMENT5_tree = (CommonTree)adaptor.create(LINE_COMMENT5);
            	    adaptor.addChild(root_0, LINE_COMMENT5_tree);


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            EOF6=(Token)match(input,EOF,FOLLOW_EOF_in_instal_specification95); 
            EOF6_tree = (CommonTree)adaptor.create(EOF6);
            adaptor.addChild(root_0, EOF6_tree);

             outputASP(); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "instal_specification"

    public static class institution_decl_return extends ParserRuleReturnScope {
        public String name;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "institution_decl"
    // InstAL.g:397:1: institution_decl returns [String name] : KEY_INST institution_name END ;
    public final InstALParser.institution_decl_return institution_decl() throws RecognitionException {
        InstALParser.institution_decl_return retval = new InstALParser.institution_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_INST7=null;
        Token END9=null;
        InstALParser.institution_name_return institution_name8 = null;


        CommonTree KEY_INST7_tree=null;
        CommonTree END9_tree=null;

        try {
            // InstAL.g:398:2: ( KEY_INST institution_name END )
            // InstAL.g:398:4: KEY_INST institution_name END
            {
            root_0 = (CommonTree)adaptor.nil();

            KEY_INST7=(Token)match(input,KEY_INST,FOLLOW_KEY_INST_in_institution_decl119); 
            KEY_INST7_tree = (CommonTree)adaptor.create(KEY_INST7);
            adaptor.addChild(root_0, KEY_INST7_tree);

            pushFollow(FOLLOW_institution_name_in_institution_decl121);
            institution_name8=institution_name();

            state._fsp--;

            adaptor.addChild(root_0, institution_name8.getTree());
            END9=(Token)match(input,END,FOLLOW_END_in_institution_decl123); 
            END9_tree = (CommonTree)adaptor.create(END9);
            adaptor.addChild(root_0, END9_tree);

             retval.name = (institution_name8!=null?input.toString(institution_name8.start,institution_name8.stop):null); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "institution_decl"

    public static class institution_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "institution_name"
    // InstAL.g:401:1: institution_name : LITERAL ;
    public final InstALParser.institution_name_return institution_name() throws RecognitionException {
        InstALParser.institution_name_return retval = new InstALParser.institution_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LITERAL10=null;

        CommonTree LITERAL10_tree=null;

        try {
            // InstAL.g:402:2: ( LITERAL )
            // InstAL.g:402:5: LITERAL
            {
            root_0 = (CommonTree)adaptor.nil();

            LITERAL10=(Token)match(input,LITERAL,FOLLOW_LITERAL_in_institution_name138); 
            LITERAL10_tree = (CommonTree)adaptor.create(LITERAL10);
            adaptor.addChild(root_0, LITERAL10_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "institution_name"

    public static class constituent_decl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constituent_decl"
    // InstAL.g:404:1: constituent_decl : ( type_decl | event_decl | fluent_decl | obligation_decl | generates_rule | consequence_rule );
    public final InstALParser.constituent_decl_return constituent_decl() throws RecognitionException {
        InstALParser.constituent_decl_return retval = new InstALParser.constituent_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        InstALParser.type_decl_return type_decl11 = null;

        InstALParser.event_decl_return event_decl12 = null;

        InstALParser.fluent_decl_return fluent_decl13 = null;

        InstALParser.obligation_decl_return obligation_decl14 = null;

        InstALParser.generates_rule_return generates_rule15 = null;

        InstALParser.consequence_rule_return consequence_rule16 = null;



        try {
            // InstAL.g:405:2: ( type_decl | event_decl | fluent_decl | obligation_decl | generates_rule | consequence_rule )
            int alt3=6;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InstAL.g:405:4: type_decl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_type_decl_in_constituent_decl148);
                    type_decl11=type_decl();

                    state._fsp--;

                    adaptor.addChild(root_0, type_decl11.getTree());

                    }
                    break;
                case 2 :
                    // InstAL.g:406:5: event_decl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_event_decl_in_constituent_decl154);
                    event_decl12=event_decl();

                    state._fsp--;

                    adaptor.addChild(root_0, event_decl12.getTree());

                    }
                    break;
                case 3 :
                    // InstAL.g:407:5: fluent_decl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_fluent_decl_in_constituent_decl160);
                    fluent_decl13=fluent_decl();

                    state._fsp--;

                    adaptor.addChild(root_0, fluent_decl13.getTree());

                    }
                    break;
                case 4 :
                    // InstAL.g:408:4: obligation_decl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_obligation_decl_in_constituent_decl165);
                    obligation_decl14=obligation_decl();

                    state._fsp--;

                    adaptor.addChild(root_0, obligation_decl14.getTree());

                    }
                    break;
                case 5 :
                    // InstAL.g:409:5: generates_rule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_generates_rule_in_constituent_decl172);
                    generates_rule15=generates_rule();

                    state._fsp--;

                    adaptor.addChild(root_0, generates_rule15.getTree());

                    }
                    break;
                case 6 :
                    // InstAL.g:410:5: consequence_rule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_consequence_rule_in_constituent_decl178);
                    consequence_rule16=consequence_rule();

                    state._fsp--;

                    adaptor.addChild(root_0, consequence_rule16.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "constituent_decl"

    public static class type_decl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type_decl"
    // InstAL.g:415:1: type_decl : KEY_TYPE type_name END ;
    public final InstALParser.type_decl_return type_decl() throws RecognitionException {
        InstALParser.type_decl_return retval = new InstALParser.type_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_TYPE17=null;
        Token END19=null;
        InstALParser.type_name_return type_name18 = null;


        CommonTree KEY_TYPE17_tree=null;
        CommonTree END19_tree=null;

        try {
            // InstAL.g:416:2: ( KEY_TYPE type_name END )
            // InstAL.g:416:4: KEY_TYPE type_name END
            {
            root_0 = (CommonTree)adaptor.nil();

            KEY_TYPE17=(Token)match(input,KEY_TYPE,FOLLOW_KEY_TYPE_in_type_decl192); 
            KEY_TYPE17_tree = (CommonTree)adaptor.create(KEY_TYPE17);
            adaptor.addChild(root_0, KEY_TYPE17_tree);

            pushFollow(FOLLOW_type_name_in_type_decl194);
            type_name18=type_name();

            state._fsp--;

            adaptor.addChild(root_0, type_name18.getTree());
            END19=(Token)match(input,END,FOLLOW_END_in_type_decl196); 
            END19_tree = (CommonTree)adaptor.create(END19);
            adaptor.addChild(root_0, END19_tree);

             _addType((type_name18!=null?input.toString(type_name18.start,type_name18.stop):null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "type_decl"

    public static class type_name_return extends ParserRuleReturnScope {
        public String result;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type_name"
    // InstAL.g:419:1: type_name returns [String result] : TYPE ;
    public final InstALParser.type_name_return type_name() throws RecognitionException {
        InstALParser.type_name_return retval = new InstALParser.type_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TYPE20=null;

        CommonTree TYPE20_tree=null;

        try {
            // InstAL.g:420:2: ( TYPE )
            // InstAL.g:420:4: TYPE
            {
            root_0 = (CommonTree)adaptor.nil();

            TYPE20=(Token)match(input,TYPE,FOLLOW_TYPE_in_type_name213); 
            TYPE20_tree = (CommonTree)adaptor.create(TYPE20);
            adaptor.addChild(root_0, TYPE20_tree);

             retval.result = (TYPE20!=null?TYPE20.getText():null); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "type_name"

    public static class event_decl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "event_decl"
    // InstAL.g:424:1: event_decl : ( extended_event_decl | standard_event_decl ) END ;
    public final InstALParser.event_decl_return event_decl() throws RecognitionException {
        InstALParser.event_decl_return retval = new InstALParser.event_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token END23=null;
        InstALParser.extended_event_decl_return extended_event_decl21 = null;

        InstALParser.standard_event_decl_return standard_event_decl22 = null;


        CommonTree END23_tree=null;

        try {
            // InstAL.g:425:2: ( ( extended_event_decl | standard_event_decl ) END )
            // InstAL.g:426:2: ( extended_event_decl | standard_event_decl ) END
            {
            root_0 = (CommonTree)adaptor.nil();

            // InstAL.g:426:2: ( extended_event_decl | standard_event_decl )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=34 && LA4_0<=37)) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==KEY_EVENT) ) {
                    int LA4_2 = input.LA(3);

                    if ( (LA4_2==LITERAL) ) {
                        int LA4_3 = input.LA(4);

                        if ( (LA4_3==LPAR) ) {
                            int LA4_4 = input.LA(5);

                            if ( (LA4_4==VARIABLE) ) {
                                alt4=1;
                            }
                            else if ( (LA4_4==TYPE) ) {
                                alt4=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 4, 4, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA4_3==END) ) {
                            alt4=2;
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
                    // InstAL.g:426:4: extended_event_decl
                    {
                    pushFollow(FOLLOW_extended_event_decl_in_event_decl233);
                    extended_event_decl21=extended_event_decl();

                    state._fsp--;

                    adaptor.addChild(root_0, extended_event_decl21.getTree());
                     log("TODO: extended_event_decl"); 

                    }
                    break;
                case 2 :
                    // InstAL.g:427:5: standard_event_decl
                    {
                    pushFollow(FOLLOW_standard_event_decl_in_event_decl242);
                    standard_event_decl22=standard_event_decl();

                    state._fsp--;

                    adaptor.addChild(root_0, standard_event_decl22.getTree());
                     _addEvent((standard_event_decl22!=null?standard_event_decl22.type:null), (standard_event_decl22!=null?standard_event_decl22.name:null), (standard_event_decl22!=null?standard_event_decl22.types:null)); 

                    }
                    break;

            }

            END23=(Token)match(input,END,FOLLOW_END_in_event_decl251); 
            END23_tree = (CommonTree)adaptor.create(END23);
            adaptor.addChild(root_0, END23_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "event_decl"

    public static class standard_event_decl_return extends ParserRuleReturnScope {
        public String type;
        public String name;
        public ArrayList<String> types;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "standard_event_decl"
    // InstAL.g:431:1: standard_event_decl returns [String type, String name, ArrayList<String> types] : event_description ( type_arguments )? ;
    public final InstALParser.standard_event_decl_return standard_event_decl() throws RecognitionException {
        InstALParser.standard_event_decl_return retval = new InstALParser.standard_event_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        InstALParser.event_description_return event_description24 = null;

        InstALParser.type_arguments_return type_arguments25 = null;



        try {
            // InstAL.g:432:2: ( event_description ( type_arguments )? )
            // InstAL.g:432:4: event_description ( type_arguments )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_event_description_in_standard_event_decl267);
            event_description24=event_description();

            state._fsp--;

            adaptor.addChild(root_0, event_description24.getTree());
            // InstAL.g:432:22: ( type_arguments )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==LPAR) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InstAL.g:432:22: type_arguments
                    {
                    pushFollow(FOLLOW_type_arguments_in_standard_event_decl269);
                    type_arguments25=type_arguments();

                    state._fsp--;

                    adaptor.addChild(root_0, type_arguments25.getTree());

                    }
                    break;

            }

             retval.type = (event_description24!=null?event_description24.type:null); retval.name = (event_description24!=null?event_description24.name:null); retval.types = (type_arguments25!=null?type_arguments25.args:null); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "standard_event_decl"

    public static class extended_event_decl_return extends ParserRuleReturnScope {
        public String type;
        public String name;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "extended_event_decl"
    // InstAL.g:435:1: extended_event_decl returns [String type, String name] : event_description variable_type_arguments KEY_WITH variable_constraints ;
    public final InstALParser.extended_event_decl_return extended_event_decl() throws RecognitionException {
        InstALParser.extended_event_decl_return retval = new InstALParser.extended_event_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_WITH28=null;
        InstALParser.event_description_return event_description26 = null;

        InstALParser.variable_type_arguments_return variable_type_arguments27 = null;

        InstALParser.variable_constraints_return variable_constraints29 = null;


        CommonTree KEY_WITH28_tree=null;

        try {
            // InstAL.g:436:2: ( event_description variable_type_arguments KEY_WITH variable_constraints )
            // InstAL.g:436:4: event_description variable_type_arguments KEY_WITH variable_constraints
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_event_description_in_extended_event_decl288);
            event_description26=event_description();

            state._fsp--;

            adaptor.addChild(root_0, event_description26.getTree());
            pushFollow(FOLLOW_variable_type_arguments_in_extended_event_decl290);
            variable_type_arguments27=variable_type_arguments();

            state._fsp--;

            adaptor.addChild(root_0, variable_type_arguments27.getTree());
            KEY_WITH28=(Token)match(input,KEY_WITH,FOLLOW_KEY_WITH_in_extended_event_decl292); 
            KEY_WITH28_tree = (CommonTree)adaptor.create(KEY_WITH28);
            adaptor.addChild(root_0, KEY_WITH28_tree);

            pushFollow(FOLLOW_variable_constraints_in_extended_event_decl294);
            variable_constraints29=variable_constraints();

            state._fsp--;

            adaptor.addChild(root_0, variable_constraints29.getTree());
             retval.type = (event_description26!=null?event_description26.type:null); retval.name = (event_description26!=null?event_description26.name:null); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "extended_event_decl"

    public static class event_description_return extends ParserRuleReturnScope {
        public String type;
        public String name;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "event_description"
    // InstAL.g:439:1: event_description returns [String type, String name] : event_type KEY_EVENT event_name ;
    public final InstALParser.event_description_return event_description() throws RecognitionException {
        InstALParser.event_description_return retval = new InstALParser.event_description_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_EVENT31=null;
        InstALParser.event_type_return event_type30 = null;

        InstALParser.event_name_return event_name32 = null;


        CommonTree KEY_EVENT31_tree=null;

        try {
            // InstAL.g:440:2: ( event_type KEY_EVENT event_name )
            // InstAL.g:440:4: event_type KEY_EVENT event_name
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_event_type_in_event_description312);
            event_type30=event_type();

            state._fsp--;

            adaptor.addChild(root_0, event_type30.getTree());
            KEY_EVENT31=(Token)match(input,KEY_EVENT,FOLLOW_KEY_EVENT_in_event_description314); 
            KEY_EVENT31_tree = (CommonTree)adaptor.create(KEY_EVENT31);
            adaptor.addChild(root_0, KEY_EVENT31_tree);

            pushFollow(FOLLOW_event_name_in_event_description316);
            event_name32=event_name();

            state._fsp--;

            adaptor.addChild(root_0, event_name32.getTree());
             retval.type = (event_type30!=null?input.toString(event_type30.start,event_type30.stop):null); retval.name = (event_name32!=null?input.toString(event_name32.start,event_name32.stop):null); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "event_description"

    public static class event_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "event_name"
    // InstAL.g:443:1: event_name : LITERAL ;
    public final InstALParser.event_name_return event_name() throws RecognitionException {
        InstALParser.event_name_return retval = new InstALParser.event_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LITERAL33=null;

        CommonTree LITERAL33_tree=null;

        try {
            // InstAL.g:444:2: ( LITERAL )
            // InstAL.g:444:4: LITERAL
            {
            root_0 = (CommonTree)adaptor.nil();

            LITERAL33=(Token)match(input,LITERAL,FOLLOW_LITERAL_in_event_name330); 
            LITERAL33_tree = (CommonTree)adaptor.create(LITERAL33);
            adaptor.addChild(root_0, LITERAL33_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "event_name"

    public static class event_type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "event_type"
    // InstAL.g:446:1: event_type : ( 'exogenous' | 'inst' | 'creation' | 'violation' ) ;
    public final InstALParser.event_type_return event_type() throws RecognitionException {
        InstALParser.event_type_return retval = new InstALParser.event_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set34=null;

        CommonTree set34_tree=null;

        try {
            // InstAL.g:447:2: ( ( 'exogenous' | 'inst' | 'creation' | 'violation' ) )
            // InstAL.g:447:4: ( 'exogenous' | 'inst' | 'creation' | 'violation' )
            {
            root_0 = (CommonTree)adaptor.nil();

            set34=(Token)input.LT(1);
            if ( (input.LA(1)>=34 && input.LA(1)<=37) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set34));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "event_type"

    public static class variable_constraints_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable_constraints"
    // InstAL.g:449:1: variable_constraints : variable_constraint ( ',' variable_constraint )* ;
    public final InstALParser.variable_constraints_return variable_constraints() throws RecognitionException {
        InstALParser.variable_constraints_return retval = new InstALParser.variable_constraints_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal36=null;
        InstALParser.variable_constraint_return variable_constraint35 = null;

        InstALParser.variable_constraint_return variable_constraint37 = null;


        CommonTree char_literal36_tree=null;

        try {
            // InstAL.g:450:2: ( variable_constraint ( ',' variable_constraint )* )
            // InstAL.g:450:4: variable_constraint ( ',' variable_constraint )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_variable_constraint_in_variable_constraints366);
            variable_constraint35=variable_constraint();

            state._fsp--;

            adaptor.addChild(root_0, variable_constraint35.getTree());
            // InstAL.g:450:24: ( ',' variable_constraint )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==38) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InstAL.g:450:26: ',' variable_constraint
            	    {
            	    char_literal36=(Token)match(input,38,FOLLOW_38_in_variable_constraints370); 
            	    char_literal36_tree = (CommonTree)adaptor.create(char_literal36);
            	    adaptor.addChild(root_0, char_literal36_tree);

            	    pushFollow(FOLLOW_variable_constraint_in_variable_constraints372);
            	    variable_constraint37=variable_constraint();

            	    state._fsp--;

            	    adaptor.addChild(root_0, variable_constraint37.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "variable_constraints"

    public static class variable_constraint_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable_constraint"
    // InstAL.g:452:1: variable_constraint : variable_name operation variable_name ;
    public final InstALParser.variable_constraint_return variable_constraint() throws RecognitionException {
        InstALParser.variable_constraint_return retval = new InstALParser.variable_constraint_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        InstALParser.variable_name_return variable_name38 = null;

        InstALParser.operation_return operation39 = null;

        InstALParser.variable_name_return variable_name40 = null;



        try {
            // InstAL.g:453:2: ( variable_name operation variable_name )
            // InstAL.g:453:4: variable_name operation variable_name
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_variable_name_in_variable_constraint385);
            variable_name38=variable_name();

            state._fsp--;

            adaptor.addChild(root_0, variable_name38.getTree());
            pushFollow(FOLLOW_operation_in_variable_constraint387);
            operation39=operation();

            state._fsp--;

            adaptor.addChild(root_0, operation39.getTree());
            pushFollow(FOLLOW_variable_name_in_variable_constraint389);
            variable_name40=variable_name();

            state._fsp--;

            adaptor.addChild(root_0, variable_name40.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "variable_constraint"

    public static class fluent_decl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fluent_decl"
    // InstAL.g:456:1: fluent_decl : ( noninertial_fluent_decl | standard_fluent_decl ) END ;
    public final InstALParser.fluent_decl_return fluent_decl() throws RecognitionException {
        InstALParser.fluent_decl_return retval = new InstALParser.fluent_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token END43=null;
        InstALParser.noninertial_fluent_decl_return noninertial_fluent_decl41 = null;

        InstALParser.standard_fluent_decl_return standard_fluent_decl42 = null;


        CommonTree END43_tree=null;

        try {
            // InstAL.g:457:2: ( ( noninertial_fluent_decl | standard_fluent_decl ) END )
            // InstAL.g:457:4: ( noninertial_fluent_decl | standard_fluent_decl ) END
            {
            root_0 = (CommonTree)adaptor.nil();

            // InstAL.g:457:4: ( noninertial_fluent_decl | standard_fluent_decl )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==KEY_NONINERTIAL) ) {
                alt7=1;
            }
            else if ( (LA7_0==KEY_FLUENT) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InstAL.g:458:4: noninertial_fluent_decl
                    {
                    pushFollow(FOLLOW_noninertial_fluent_decl_in_fluent_decl405);
                    noninertial_fluent_decl41=noninertial_fluent_decl();

                    state._fsp--;

                    adaptor.addChild(root_0, noninertial_fluent_decl41.getTree());
                     _addFluent((noninertial_fluent_decl41!=null?noninertial_fluent_decl41.type:null), (noninertial_fluent_decl41!=null?noninertial_fluent_decl41.name:null),  (noninertial_fluent_decl41!=null?noninertial_fluent_decl41.args:null)); 

                    }
                    break;
                case 2 :
                    // InstAL.g:459:5: standard_fluent_decl
                    {
                    pushFollow(FOLLOW_standard_fluent_decl_in_fluent_decl413);
                    standard_fluent_decl42=standard_fluent_decl();

                    state._fsp--;

                    adaptor.addChild(root_0, standard_fluent_decl42.getTree());
                     _addFluent((standard_fluent_decl42!=null?standard_fluent_decl42.type:null),    (standard_fluent_decl42!=null?standard_fluent_decl42.name:null),     (standard_fluent_decl42!=null?standard_fluent_decl42.args:null)  ); 

                    }
                    break;

            }

            END43=(Token)match(input,END,FOLLOW_END_in_fluent_decl421); 
            END43_tree = (CommonTree)adaptor.create(END43);
            adaptor.addChild(root_0, END43_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fluent_decl"

    public static class noninertial_fluent_decl_return extends ParserRuleReturnScope {
        public String type;
        public String name;
        public ArrayList<String> args;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "noninertial_fluent_decl"
    // InstAL.g:463:1: noninertial_fluent_decl returns [String type, String name, ArrayList<String> args] : KEY_NONINERTIAL standard_fluent_decl ;
    public final InstALParser.noninertial_fluent_decl_return noninertial_fluent_decl() throws RecognitionException {
        InstALParser.noninertial_fluent_decl_return retval = new InstALParser.noninertial_fluent_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_NONINERTIAL44=null;
        InstALParser.standard_fluent_decl_return standard_fluent_decl45 = null;


        CommonTree KEY_NONINERTIAL44_tree=null;

        try {
            // InstAL.g:464:2: ( KEY_NONINERTIAL standard_fluent_decl )
            // InstAL.g:464:4: KEY_NONINERTIAL standard_fluent_decl
            {
            root_0 = (CommonTree)adaptor.nil();

            KEY_NONINERTIAL44=(Token)match(input,KEY_NONINERTIAL,FOLLOW_KEY_NONINERTIAL_in_noninertial_fluent_decl439); 
            KEY_NONINERTIAL44_tree = (CommonTree)adaptor.create(KEY_NONINERTIAL44);
            adaptor.addChild(root_0, KEY_NONINERTIAL44_tree);

            pushFollow(FOLLOW_standard_fluent_decl_in_noninertial_fluent_decl441);
            standard_fluent_decl45=standard_fluent_decl();

            state._fsp--;

            adaptor.addChild(root_0, standard_fluent_decl45.getTree());
             retval.type = "noninertial"; retval.name = (standard_fluent_decl45!=null?standard_fluent_decl45.name:null); retval.args = (standard_fluent_decl45!=null?standard_fluent_decl45.args:null); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "noninertial_fluent_decl"

    public static class standard_fluent_decl_return extends ParserRuleReturnScope {
        public String type;
        public String name;
        public ArrayList<String> args;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "standard_fluent_decl"
    // InstAL.g:467:1: standard_fluent_decl returns [String type, String name, ArrayList<String> args] : KEY_FLUENT fluent_name ( type_arguments )? ;
    public final InstALParser.standard_fluent_decl_return standard_fluent_decl() throws RecognitionException {
        InstALParser.standard_fluent_decl_return retval = new InstALParser.standard_fluent_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_FLUENT46=null;
        InstALParser.fluent_name_return fluent_name47 = null;

        InstALParser.type_arguments_return type_arguments48 = null;


        CommonTree KEY_FLUENT46_tree=null;

        try {
            // InstAL.g:468:2: ( KEY_FLUENT fluent_name ( type_arguments )? )
            // InstAL.g:468:4: KEY_FLUENT fluent_name ( type_arguments )?
            {
            root_0 = (CommonTree)adaptor.nil();

            KEY_FLUENT46=(Token)match(input,KEY_FLUENT,FOLLOW_KEY_FLUENT_in_standard_fluent_decl459); 
            KEY_FLUENT46_tree = (CommonTree)adaptor.create(KEY_FLUENT46);
            adaptor.addChild(root_0, KEY_FLUENT46_tree);

            pushFollow(FOLLOW_fluent_name_in_standard_fluent_decl461);
            fluent_name47=fluent_name();

            state._fsp--;

            adaptor.addChild(root_0, fluent_name47.getTree());
            // InstAL.g:468:27: ( type_arguments )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==LPAR) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InstAL.g:468:27: type_arguments
                    {
                    pushFollow(FOLLOW_type_arguments_in_standard_fluent_decl463);
                    type_arguments48=type_arguments();

                    state._fsp--;

                    adaptor.addChild(root_0, type_arguments48.getTree());

                    }
                    break;

            }

             retval.type = "inertial"; retval.name = (fluent_name47!=null?input.toString(fluent_name47.start,fluent_name47.stop):null); retval.args = (type_arguments48!=null?type_arguments48.args:null); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "standard_fluent_decl"

    public static class fluent_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fluent_name"
    // InstAL.g:471:1: fluent_name : LITERAL ;
    public final InstALParser.fluent_name_return fluent_name() throws RecognitionException {
        InstALParser.fluent_name_return retval = new InstALParser.fluent_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LITERAL49=null;

        CommonTree LITERAL49_tree=null;

        try {
            // InstAL.g:472:2: ( LITERAL )
            // InstAL.g:472:4: LITERAL
            {
            root_0 = (CommonTree)adaptor.nil();

            LITERAL49=(Token)match(input,LITERAL,FOLLOW_LITERAL_in_fluent_name478); 
            LITERAL49_tree = (CommonTree)adaptor.create(LITERAL49);
            adaptor.addChild(root_0, LITERAL49_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fluent_name"

    public static class generates_rule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "generates_rule"
    // InstAL.g:476:1: generates_rule : event_varient KEY_GENERATES results= events_with_variables ( KEY_IF conditions= fluents_with_variables_with_negation )? END ;
    public final InstALParser.generates_rule_return generates_rule() throws RecognitionException {
        InstALParser.generates_rule_return retval = new InstALParser.generates_rule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_GENERATES51=null;
        Token KEY_IF52=null;
        Token END53=null;
        InstALParser.events_with_variables_return results = null;

        InstALParser.fluents_with_variables_with_negation_return conditions = null;

        InstALParser.event_varient_return event_varient50 = null;


        CommonTree KEY_GENERATES51_tree=null;
        CommonTree KEY_IF52_tree=null;
        CommonTree END53_tree=null;

        try {
            // InstAL.g:477:2: ( event_varient KEY_GENERATES results= events_with_variables ( KEY_IF conditions= fluents_with_variables_with_negation )? END )
            // InstAL.g:477:4: event_varient KEY_GENERATES results= events_with_variables ( KEY_IF conditions= fluents_with_variables_with_negation )? END
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_event_varient_in_generates_rule491);
            event_varient50=event_varient();

            state._fsp--;

            adaptor.addChild(root_0, event_varient50.getTree());
            KEY_GENERATES51=(Token)match(input,KEY_GENERATES,FOLLOW_KEY_GENERATES_in_generates_rule493); 
            KEY_GENERATES51_tree = (CommonTree)adaptor.create(KEY_GENERATES51);
            adaptor.addChild(root_0, KEY_GENERATES51_tree);

            pushFollow(FOLLOW_events_with_variables_in_generates_rule497);
            results=events_with_variables();

            state._fsp--;

            adaptor.addChild(root_0, results.getTree());
            // InstAL.g:477:62: ( KEY_IF conditions= fluents_with_variables_with_negation )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==KEY_IF) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InstAL.g:477:64: KEY_IF conditions= fluents_with_variables_with_negation
                    {
                    KEY_IF52=(Token)match(input,KEY_IF,FOLLOW_KEY_IF_in_generates_rule501); 
                    KEY_IF52_tree = (CommonTree)adaptor.create(KEY_IF52);
                    adaptor.addChild(root_0, KEY_IF52_tree);

                    pushFollow(FOLLOW_fluents_with_variables_with_negation_in_generates_rule505);
                    conditions=fluents_with_variables_with_negation();

                    state._fsp--;

                    adaptor.addChild(root_0, conditions.getTree());

                    }
                    break;

            }

            END53=(Token)match(input,END,FOLLOW_END_in_generates_rule510); 
            END53_tree = (CommonTree)adaptor.create(END53);
            adaptor.addChild(root_0, END53_tree);

             _addGeneratesRule((event_varient50!=null?event_varient50.name:null), (event_varient50!=null?event_varient50.args:null), (results!=null?results.events:null), (conditions!=null?conditions.fluents:null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "generates_rule"

    protected static class events_with_variables_scope {
        ArrayList<EventWithVariables> list;
    }
    protected Stack events_with_variables_stack = new Stack();

    public static class events_with_variables_return extends ParserRuleReturnScope {
        public ArrayList<EventWithVariables> events;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "events_with_variables"
    // InstAL.g:480:1: events_with_variables returns [ArrayList<EventWithVariables> events] : event_with_variables ( ',' event_with_variables )* ;
    public final InstALParser.events_with_variables_return events_with_variables() throws RecognitionException {
        events_with_variables_stack.push(new events_with_variables_scope());
        InstALParser.events_with_variables_return retval = new InstALParser.events_with_variables_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal55=null;
        InstALParser.event_with_variables_return event_with_variables54 = null;

        InstALParser.event_with_variables_return event_with_variables56 = null;


        CommonTree char_literal55_tree=null;

         ((events_with_variables_scope)events_with_variables_stack.peek()).list = new ArrayList<EventWithVariables>(); 
        try {
            // InstAL.g:483:2: ( event_with_variables ( ',' event_with_variables )* )
            // InstAL.g:483:4: event_with_variables ( ',' event_with_variables )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_event_with_variables_in_events_with_variables540);
            event_with_variables54=event_with_variables();

            state._fsp--;

            adaptor.addChild(root_0, event_with_variables54.getTree());
            // InstAL.g:483:25: ( ',' event_with_variables )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==38) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InstAL.g:483:27: ',' event_with_variables
            	    {
            	    char_literal55=(Token)match(input,38,FOLLOW_38_in_events_with_variables544); 
            	    char_literal55_tree = (CommonTree)adaptor.create(char_literal55);
            	    adaptor.addChild(root_0, char_literal55_tree);

            	    pushFollow(FOLLOW_event_with_variables_in_events_with_variables546);
            	    event_with_variables56=event_with_variables();

            	    state._fsp--;

            	    adaptor.addChild(root_0, event_with_variables56.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             retval.events = ((events_with_variables_scope)events_with_variables_stack.peek()).list; 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            events_with_variables_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "events_with_variables"

    public static class event_with_variables_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "event_with_variables"
    // InstAL.g:486:1: event_with_variables : event_varient ;
    public final InstALParser.event_with_variables_return event_with_variables() throws RecognitionException {
        InstALParser.event_with_variables_return retval = new InstALParser.event_with_variables_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        InstALParser.event_varient_return event_varient57 = null;



        try {
            // InstAL.g:487:2: ( event_varient )
            // InstAL.g:487:4: event_varient
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_event_varient_in_event_with_variables563);
            event_varient57=event_varient();

            state._fsp--;

            adaptor.addChild(root_0, event_varient57.getTree());
             ((events_with_variables_scope)events_with_variables_stack.peek()).list.add(new EventWithVariables((event_varient57!=null?event_varient57.name:null), (event_varient57!=null?event_varient57.args:null))); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "event_with_variables"

    protected static class fluents_with_variables_scope {
        ArrayList<FluentCondition> list;
    }
    protected Stack fluents_with_variables_stack = new Stack();

    public static class fluents_with_variables_return extends ParserRuleReturnScope {
        public ArrayList<FluentCondition> fluents;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fluents_with_variables"
    // InstAL.g:490:1: fluents_with_variables returns [ArrayList<FluentCondition> fluents] : fluent_with_variables ( ',' fluent_with_variables )* ;
    public final InstALParser.fluents_with_variables_return fluents_with_variables() throws RecognitionException {
        fluents_with_variables_stack.push(new fluents_with_variables_scope());
        InstALParser.fluents_with_variables_return retval = new InstALParser.fluents_with_variables_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal59=null;
        InstALParser.fluent_with_variables_return fluent_with_variables58 = null;

        InstALParser.fluent_with_variables_return fluent_with_variables60 = null;


        CommonTree char_literal59_tree=null;

         ((fluents_with_variables_scope)fluents_with_variables_stack.peek()).list = new ArrayList<FluentCondition>(); 
        try {
            // InstAL.g:493:2: ( fluent_with_variables ( ',' fluent_with_variables )* )
            // InstAL.g:493:4: fluent_with_variables ( ',' fluent_with_variables )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_fluent_with_variables_in_fluents_with_variables591);
            fluent_with_variables58=fluent_with_variables();

            state._fsp--;

            adaptor.addChild(root_0, fluent_with_variables58.getTree());
            // InstAL.g:493:26: ( ',' fluent_with_variables )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==38) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InstAL.g:493:28: ',' fluent_with_variables
            	    {
            	    char_literal59=(Token)match(input,38,FOLLOW_38_in_fluents_with_variables595); 
            	    char_literal59_tree = (CommonTree)adaptor.create(char_literal59);
            	    adaptor.addChild(root_0, char_literal59_tree);

            	    pushFollow(FOLLOW_fluent_with_variables_in_fluents_with_variables597);
            	    fluent_with_variables60=fluent_with_variables();

            	    state._fsp--;

            	    adaptor.addChild(root_0, fluent_with_variables60.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             retval.fluents = ((fluents_with_variables_scope)fluents_with_variables_stack.peek()).list; 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            fluents_with_variables_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "fluents_with_variables"

    public static class fluent_with_variables_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fluent_with_variables"
    // InstAL.g:496:1: fluent_with_variables : fluent_varient ;
    public final InstALParser.fluent_with_variables_return fluent_with_variables() throws RecognitionException {
        InstALParser.fluent_with_variables_return retval = new InstALParser.fluent_with_variables_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        InstALParser.fluent_varient_return fluent_varient61 = null;



        try {
            // InstAL.g:497:2: ( fluent_varient )
            // InstAL.g:497:4: fluent_varient
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_fluent_varient_in_fluent_with_variables615);
            fluent_varient61=fluent_varient();

            state._fsp--;

            adaptor.addChild(root_0, fluent_varient61.getTree());
             ((fluents_with_variables_scope)fluents_with_variables_stack.peek()).list.add(new FluentCondition(false, (fluent_varient61!=null?fluent_varient61.name:null), (fluent_varient61!=null?fluent_varient61.args:null))); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fluent_with_variables"

    protected static class fluents_with_variables_with_negation_scope {
        ArrayList<FluentCondition> list;
    }
    protected Stack fluents_with_variables_with_negation_stack = new Stack();

    public static class fluents_with_variables_with_negation_return extends ParserRuleReturnScope {
        public ArrayList<FluentCondition> fluents;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fluents_with_variables_with_negation"
    // InstAL.g:500:1: fluents_with_variables_with_negation returns [ArrayList<FluentCondition> fluents] : fluent_with_variables_with_negation ( ',' fluent_with_variables_with_negation )* ;
    public final InstALParser.fluents_with_variables_with_negation_return fluents_with_variables_with_negation() throws RecognitionException {
        fluents_with_variables_with_negation_stack.push(new fluents_with_variables_with_negation_scope());
        InstALParser.fluents_with_variables_with_negation_return retval = new InstALParser.fluents_with_variables_with_negation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal63=null;
        InstALParser.fluent_with_variables_with_negation_return fluent_with_variables_with_negation62 = null;

        InstALParser.fluent_with_variables_with_negation_return fluent_with_variables_with_negation64 = null;


        CommonTree char_literal63_tree=null;

         ((fluents_with_variables_with_negation_scope)fluents_with_variables_with_negation_stack.peek()).list = new ArrayList<FluentCondition>(); 
        try {
            // InstAL.g:503:2: ( fluent_with_variables_with_negation ( ',' fluent_with_variables_with_negation )* )
            // InstAL.g:503:4: fluent_with_variables_with_negation ( ',' fluent_with_variables_with_negation )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_fluent_with_variables_with_negation_in_fluents_with_variables_with_negation643);
            fluent_with_variables_with_negation62=fluent_with_variables_with_negation();

            state._fsp--;

            adaptor.addChild(root_0, fluent_with_variables_with_negation62.getTree());
            // InstAL.g:503:40: ( ',' fluent_with_variables_with_negation )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==38) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InstAL.g:503:42: ',' fluent_with_variables_with_negation
            	    {
            	    char_literal63=(Token)match(input,38,FOLLOW_38_in_fluents_with_variables_with_negation647); 
            	    char_literal63_tree = (CommonTree)adaptor.create(char_literal63);
            	    adaptor.addChild(root_0, char_literal63_tree);

            	    pushFollow(FOLLOW_fluent_with_variables_with_negation_in_fluents_with_variables_with_negation649);
            	    fluent_with_variables_with_negation64=fluent_with_variables_with_negation();

            	    state._fsp--;

            	    adaptor.addChild(root_0, fluent_with_variables_with_negation64.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             retval.fluents = ((fluents_with_variables_with_negation_scope)fluents_with_variables_with_negation_stack.peek()).list; 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            fluents_with_variables_with_negation_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "fluents_with_variables_with_negation"

    public static class fluent_with_variables_with_negation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fluent_with_variables_with_negation"
    // InstAL.g:506:1: fluent_with_variables_with_negation : ( KEY_NOT fluent_varient | fluent_varient );
    public final InstALParser.fluent_with_variables_with_negation_return fluent_with_variables_with_negation() throws RecognitionException {
        InstALParser.fluent_with_variables_with_negation_return retval = new InstALParser.fluent_with_variables_with_negation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_NOT65=null;
        InstALParser.fluent_varient_return fluent_varient66 = null;

        InstALParser.fluent_varient_return fluent_varient67 = null;


        CommonTree KEY_NOT65_tree=null;

        try {
            // InstAL.g:507:2: ( KEY_NOT fluent_varient | fluent_varient )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==KEY_NOT) ) {
                alt13=1;
            }
            else if ( (LA13_0==LITERAL||(LA13_0>=KEY_POW && LA13_0<=KEY_PERM)) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InstAL.g:507:4: KEY_NOT fluent_varient
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    KEY_NOT65=(Token)match(input,KEY_NOT,FOLLOW_KEY_NOT_in_fluent_with_variables_with_negation668); 
                    KEY_NOT65_tree = (CommonTree)adaptor.create(KEY_NOT65);
                    adaptor.addChild(root_0, KEY_NOT65_tree);

                    pushFollow(FOLLOW_fluent_varient_in_fluent_with_variables_with_negation670);
                    fluent_varient66=fluent_varient();

                    state._fsp--;

                    adaptor.addChild(root_0, fluent_varient66.getTree());
                     ((fluents_with_variables_with_negation_scope)fluents_with_variables_with_negation_stack.peek()).list.add(new FluentCondition(false, (fluent_varient66!=null?fluent_varient66.name:null), (fluent_varient66!=null?fluent_varient66.args:null))); 

                    }
                    break;
                case 2 :
                    // InstAL.g:508:4: fluent_varient
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_fluent_varient_in_fluent_with_variables_with_negation677);
                    fluent_varient67=fluent_varient();

                    state._fsp--;

                    adaptor.addChild(root_0, fluent_varient67.getTree());
                     ((fluents_with_variables_with_negation_scope)fluents_with_variables_with_negation_stack.peek()).list.add(new FluentCondition(true,  (fluent_varient67!=null?fluent_varient67.name:null), (fluent_varient67!=null?fluent_varient67.args:null))); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fluent_with_variables_with_negation"

    public static class event_varient_return extends ParserRuleReturnScope {
        public String name;
        public ArrayList<String> args;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "event_varient"
    // InstAL.g:512:1: event_varient returns [String name, ArrayList<String> args] : ( ( 'viol' LPAR event_name ( variable_arguments )? RPAR ) | ( event_name ( variable_arguments )? ) );
    public final InstALParser.event_varient_return event_varient() throws RecognitionException {
        InstALParser.event_varient_return retval = new InstALParser.event_varient_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal68=null;
        Token LPAR69=null;
        Token RPAR72=null;
        InstALParser.event_name_return event_name70 = null;

        InstALParser.variable_arguments_return variable_arguments71 = null;

        InstALParser.event_name_return event_name73 = null;

        InstALParser.variable_arguments_return variable_arguments74 = null;


        CommonTree string_literal68_tree=null;
        CommonTree LPAR69_tree=null;
        CommonTree RPAR72_tree=null;

        try {
            // InstAL.g:513:2: ( ( 'viol' LPAR event_name ( variable_arguments )? RPAR ) | ( event_name ( variable_arguments )? ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==39) ) {
                alt16=1;
            }
            else if ( (LA16_0==LITERAL) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InstAL.g:513:4: ( 'viol' LPAR event_name ( variable_arguments )? RPAR )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // InstAL.g:513:4: ( 'viol' LPAR event_name ( variable_arguments )? RPAR )
                    // InstAL.g:513:6: 'viol' LPAR event_name ( variable_arguments )? RPAR
                    {
                    string_literal68=(Token)match(input,39,FOLLOW_39_in_event_varient700); 
                    string_literal68_tree = (CommonTree)adaptor.create(string_literal68);
                    adaptor.addChild(root_0, string_literal68_tree);

                    LPAR69=(Token)match(input,LPAR,FOLLOW_LPAR_in_event_varient702); 
                    LPAR69_tree = (CommonTree)adaptor.create(LPAR69);
                    adaptor.addChild(root_0, LPAR69_tree);

                    pushFollow(FOLLOW_event_name_in_event_varient704);
                    event_name70=event_name();

                    state._fsp--;

                    adaptor.addChild(root_0, event_name70.getTree());
                    // InstAL.g:513:30: ( variable_arguments )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==LPAR) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InstAL.g:513:30: variable_arguments
                            {
                            pushFollow(FOLLOW_variable_arguments_in_event_varient707);
                            variable_arguments71=variable_arguments();

                            state._fsp--;

                            adaptor.addChild(root_0, variable_arguments71.getTree());

                            }
                            break;

                    }

                    RPAR72=(Token)match(input,RPAR,FOLLOW_RPAR_in_event_varient710); 
                    RPAR72_tree = (CommonTree)adaptor.create(RPAR72);
                    adaptor.addChild(root_0, RPAR72_tree);


                    }

                     retval.name = (event_name70!=null?input.toString(event_name70.start,event_name70.stop):null); retval.args = (variable_arguments71!=null?variable_arguments71.args:null); 

                    }
                    break;
                case 2 :
                    // InstAL.g:514:5: ( event_name ( variable_arguments )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // InstAL.g:514:5: ( event_name ( variable_arguments )? )
                    // InstAL.g:514:7: event_name ( variable_arguments )?
                    {
                    pushFollow(FOLLOW_event_name_in_event_varient722);
                    event_name73=event_name();

                    state._fsp--;

                    adaptor.addChild(root_0, event_name73.getTree());
                    // InstAL.g:514:19: ( variable_arguments )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==LPAR) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // InstAL.g:514:19: variable_arguments
                            {
                            pushFollow(FOLLOW_variable_arguments_in_event_varient725);
                            variable_arguments74=variable_arguments();

                            state._fsp--;

                            adaptor.addChild(root_0, variable_arguments74.getTree());

                            }
                            break;

                    }


                    }

                     retval.name = (event_name73!=null?input.toString(event_name73.start,event_name73.stop):null); retval.args = (variable_arguments74!=null?variable_arguments74.args:null); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "event_varient"

    public static class fluent_varient_return extends ParserRuleReturnScope {
        public String type;
        public String name;
        public ArrayList<String> args;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fluent_varient"
    // InstAL.g:517:1: fluent_varient returns [String type, String name, ArrayList<String> args] : ( ( KEY_POW LPAR fluent_name ( variable_arguments )? RPAR ) | ( KEY_PERM LPAR fluent_name ( variable_arguments )? RPAR ) | ( fluent_name ( variable_arguments )? ) );
    public final InstALParser.fluent_varient_return fluent_varient() throws RecognitionException {
        InstALParser.fluent_varient_return retval = new InstALParser.fluent_varient_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_POW75=null;
        Token LPAR76=null;
        Token RPAR79=null;
        Token KEY_PERM80=null;
        Token LPAR81=null;
        Token RPAR84=null;
        InstALParser.fluent_name_return fluent_name77 = null;

        InstALParser.variable_arguments_return variable_arguments78 = null;

        InstALParser.fluent_name_return fluent_name82 = null;

        InstALParser.variable_arguments_return variable_arguments83 = null;

        InstALParser.fluent_name_return fluent_name85 = null;

        InstALParser.variable_arguments_return variable_arguments86 = null;


        CommonTree KEY_POW75_tree=null;
        CommonTree LPAR76_tree=null;
        CommonTree RPAR79_tree=null;
        CommonTree KEY_PERM80_tree=null;
        CommonTree LPAR81_tree=null;
        CommonTree RPAR84_tree=null;

        try {
            // InstAL.g:518:2: ( ( KEY_POW LPAR fluent_name ( variable_arguments )? RPAR ) | ( KEY_PERM LPAR fluent_name ( variable_arguments )? RPAR ) | ( fluent_name ( variable_arguments )? ) )
            int alt20=3;
            switch ( input.LA(1) ) {
            case KEY_POW:
                {
                alt20=1;
                }
                break;
            case KEY_PERM:
                {
                alt20=2;
                }
                break;
            case LITERAL:
                {
                alt20=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InstAL.g:518:4: ( KEY_POW LPAR fluent_name ( variable_arguments )? RPAR )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // InstAL.g:518:4: ( KEY_POW LPAR fluent_name ( variable_arguments )? RPAR )
                    // InstAL.g:518:6: KEY_POW LPAR fluent_name ( variable_arguments )? RPAR
                    {
                    KEY_POW75=(Token)match(input,KEY_POW,FOLLOW_KEY_POW_in_fluent_varient750); 
                    KEY_POW75_tree = (CommonTree)adaptor.create(KEY_POW75);
                    adaptor.addChild(root_0, KEY_POW75_tree);

                    LPAR76=(Token)match(input,LPAR,FOLLOW_LPAR_in_fluent_varient752); 
                    LPAR76_tree = (CommonTree)adaptor.create(LPAR76);
                    adaptor.addChild(root_0, LPAR76_tree);

                    pushFollow(FOLLOW_fluent_name_in_fluent_varient754);
                    fluent_name77=fluent_name();

                    state._fsp--;

                    adaptor.addChild(root_0, fluent_name77.getTree());
                    // InstAL.g:518:31: ( variable_arguments )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==LPAR) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // InstAL.g:518:31: variable_arguments
                            {
                            pushFollow(FOLLOW_variable_arguments_in_fluent_varient756);
                            variable_arguments78=variable_arguments();

                            state._fsp--;

                            adaptor.addChild(root_0, variable_arguments78.getTree());

                            }
                            break;

                    }

                    RPAR79=(Token)match(input,RPAR,FOLLOW_RPAR_in_fluent_varient759); 
                    RPAR79_tree = (CommonTree)adaptor.create(RPAR79);
                    adaptor.addChild(root_0, RPAR79_tree);


                    }

                     retval.name = (fluent_name77!=null?input.toString(fluent_name77.start,fluent_name77.stop):null); retval.args = (variable_arguments78!=null?variable_arguments78.args:null); 

                    }
                    break;
                case 2 :
                    // InstAL.g:519:5: ( KEY_PERM LPAR fluent_name ( variable_arguments )? RPAR )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // InstAL.g:519:5: ( KEY_PERM LPAR fluent_name ( variable_arguments )? RPAR )
                    // InstAL.g:519:7: KEY_PERM LPAR fluent_name ( variable_arguments )? RPAR
                    {
                    KEY_PERM80=(Token)match(input,KEY_PERM,FOLLOW_KEY_PERM_in_fluent_varient772); 
                    KEY_PERM80_tree = (CommonTree)adaptor.create(KEY_PERM80);
                    adaptor.addChild(root_0, KEY_PERM80_tree);

                    LPAR81=(Token)match(input,LPAR,FOLLOW_LPAR_in_fluent_varient774); 
                    LPAR81_tree = (CommonTree)adaptor.create(LPAR81);
                    adaptor.addChild(root_0, LPAR81_tree);

                    pushFollow(FOLLOW_fluent_name_in_fluent_varient776);
                    fluent_name82=fluent_name();

                    state._fsp--;

                    adaptor.addChild(root_0, fluent_name82.getTree());
                    // InstAL.g:519:33: ( variable_arguments )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==LPAR) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // InstAL.g:519:33: variable_arguments
                            {
                            pushFollow(FOLLOW_variable_arguments_in_fluent_varient778);
                            variable_arguments83=variable_arguments();

                            state._fsp--;

                            adaptor.addChild(root_0, variable_arguments83.getTree());

                            }
                            break;

                    }

                    RPAR84=(Token)match(input,RPAR,FOLLOW_RPAR_in_fluent_varient781); 
                    RPAR84_tree = (CommonTree)adaptor.create(RPAR84);
                    adaptor.addChild(root_0, RPAR84_tree);


                    }

                     retval.name = (fluent_name82!=null?input.toString(fluent_name82.start,fluent_name82.stop):null); retval.args = (variable_arguments83!=null?variable_arguments83.args:null); 

                    }
                    break;
                case 3 :
                    // InstAL.g:520:4: ( fluent_name ( variable_arguments )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // InstAL.g:520:4: ( fluent_name ( variable_arguments )? )
                    // InstAL.g:520:6: fluent_name ( variable_arguments )?
                    {
                    pushFollow(FOLLOW_fluent_name_in_fluent_varient793);
                    fluent_name85=fluent_name();

                    state._fsp--;

                    adaptor.addChild(root_0, fluent_name85.getTree());
                    // InstAL.g:520:18: ( variable_arguments )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==LPAR) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // InstAL.g:520:18: variable_arguments
                            {
                            pushFollow(FOLLOW_variable_arguments_in_fluent_varient795);
                            variable_arguments86=variable_arguments();

                            state._fsp--;

                            adaptor.addChild(root_0, variable_arguments86.getTree());

                            }
                            break;

                    }


                    }

                     retval.name = (fluent_name85!=null?input.toString(fluent_name85.start,fluent_name85.stop):null); retval.args = (variable_arguments86!=null?variable_arguments86.args:null); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fluent_varient"

    public static class consequence_rule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "consequence_rule"
    // InstAL.g:524:1: consequence_rule : ( initiates_rule | terminates_rule ) END ;
    public final InstALParser.consequence_rule_return consequence_rule() throws RecognitionException {
        InstALParser.consequence_rule_return retval = new InstALParser.consequence_rule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token END89=null;
        InstALParser.initiates_rule_return initiates_rule87 = null;

        InstALParser.terminates_rule_return terminates_rule88 = null;


        CommonTree END89_tree=null;

        try {
            // InstAL.g:525:2: ( ( initiates_rule | terminates_rule ) END )
            // InstAL.g:525:4: ( initiates_rule | terminates_rule ) END
            {
            root_0 = (CommonTree)adaptor.nil();

            // InstAL.g:525:4: ( initiates_rule | terminates_rule )
            int alt21=2;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // InstAL.g:525:6: initiates_rule
                    {
                    pushFollow(FOLLOW_initiates_rule_in_consequence_rule818);
                    initiates_rule87=initiates_rule();

                    state._fsp--;

                    adaptor.addChild(root_0, initiates_rule87.getTree());

                    }
                    break;
                case 2 :
                    // InstAL.g:525:23: terminates_rule
                    {
                    pushFollow(FOLLOW_terminates_rule_in_consequence_rule822);
                    terminates_rule88=terminates_rule();

                    state._fsp--;

                    adaptor.addChild(root_0, terminates_rule88.getTree());

                    }
                    break;

            }

            END89=(Token)match(input,END,FOLLOW_END_in_consequence_rule826); 
            END89_tree = (CommonTree)adaptor.create(END89);
            adaptor.addChild(root_0, END89_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "consequence_rule"

    public static class initiates_rule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "initiates_rule"
    // InstAL.g:527:1: initiates_rule : event_varient KEY_INITIATES results= fluents_with_variables ( KEY_IF conditions= fluents_with_variables )? ;
    public final InstALParser.initiates_rule_return initiates_rule() throws RecognitionException {
        InstALParser.initiates_rule_return retval = new InstALParser.initiates_rule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_INITIATES91=null;
        Token KEY_IF92=null;
        InstALParser.fluents_with_variables_return results = null;

        InstALParser.fluents_with_variables_return conditions = null;

        InstALParser.event_varient_return event_varient90 = null;


        CommonTree KEY_INITIATES91_tree=null;
        CommonTree KEY_IF92_tree=null;

        try {
            // InstAL.g:528:2: ( event_varient KEY_INITIATES results= fluents_with_variables ( KEY_IF conditions= fluents_with_variables )? )
            // InstAL.g:528:4: event_varient KEY_INITIATES results= fluents_with_variables ( KEY_IF conditions= fluents_with_variables )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_event_varient_in_initiates_rule836);
            event_varient90=event_varient();

            state._fsp--;

            adaptor.addChild(root_0, event_varient90.getTree());
            KEY_INITIATES91=(Token)match(input,KEY_INITIATES,FOLLOW_KEY_INITIATES_in_initiates_rule838); 
            KEY_INITIATES91_tree = (CommonTree)adaptor.create(KEY_INITIATES91);
            adaptor.addChild(root_0, KEY_INITIATES91_tree);

            pushFollow(FOLLOW_fluents_with_variables_in_initiates_rule842);
            results=fluents_with_variables();

            state._fsp--;

            adaptor.addChild(root_0, results.getTree());
            // InstAL.g:528:63: ( KEY_IF conditions= fluents_with_variables )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==KEY_IF) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InstAL.g:528:65: KEY_IF conditions= fluents_with_variables
                    {
                    KEY_IF92=(Token)match(input,KEY_IF,FOLLOW_KEY_IF_in_initiates_rule846); 
                    KEY_IF92_tree = (CommonTree)adaptor.create(KEY_IF92);
                    adaptor.addChild(root_0, KEY_IF92_tree);

                    pushFollow(FOLLOW_fluents_with_variables_in_initiates_rule850);
                    conditions=fluents_with_variables();

                    state._fsp--;

                    adaptor.addChild(root_0, conditions.getTree());

                    }
                    break;

            }

             _addInitiatesRule((event_varient90!=null?event_varient90.name:null), (event_varient90!=null?event_varient90.args:null), (results!=null?results.fluents:null), (conditions!=null?conditions.fluents:null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "initiates_rule"

    public static class terminates_rule_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "terminates_rule"
    // InstAL.g:531:1: terminates_rule : event_varient KEY_TERMINATES results= fluents_with_variables ( KEY_IF conditions= fluents_with_variables )? ;
    public final InstALParser.terminates_rule_return terminates_rule() throws RecognitionException {
        InstALParser.terminates_rule_return retval = new InstALParser.terminates_rule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_TERMINATES94=null;
        Token KEY_IF95=null;
        InstALParser.fluents_with_variables_return results = null;

        InstALParser.fluents_with_variables_return conditions = null;

        InstALParser.event_varient_return event_varient93 = null;


        CommonTree KEY_TERMINATES94_tree=null;
        CommonTree KEY_IF95_tree=null;

        try {
            // InstAL.g:532:2: ( event_varient KEY_TERMINATES results= fluents_with_variables ( KEY_IF conditions= fluents_with_variables )? )
            // InstAL.g:532:4: event_varient KEY_TERMINATES results= fluents_with_variables ( KEY_IF conditions= fluents_with_variables )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_event_varient_in_terminates_rule867);
            event_varient93=event_varient();

            state._fsp--;

            adaptor.addChild(root_0, event_varient93.getTree());
            KEY_TERMINATES94=(Token)match(input,KEY_TERMINATES,FOLLOW_KEY_TERMINATES_in_terminates_rule869); 
            KEY_TERMINATES94_tree = (CommonTree)adaptor.create(KEY_TERMINATES94);
            adaptor.addChild(root_0, KEY_TERMINATES94_tree);

            pushFollow(FOLLOW_fluents_with_variables_in_terminates_rule873);
            results=fluents_with_variables();

            state._fsp--;

            adaptor.addChild(root_0, results.getTree());
            // InstAL.g:532:64: ( KEY_IF conditions= fluents_with_variables )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==KEY_IF) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InstAL.g:532:66: KEY_IF conditions= fluents_with_variables
                    {
                    KEY_IF95=(Token)match(input,KEY_IF,FOLLOW_KEY_IF_in_terminates_rule877); 
                    KEY_IF95_tree = (CommonTree)adaptor.create(KEY_IF95);
                    adaptor.addChild(root_0, KEY_IF95_tree);

                    pushFollow(FOLLOW_fluents_with_variables_in_terminates_rule881);
                    conditions=fluents_with_variables();

                    state._fsp--;

                    adaptor.addChild(root_0, conditions.getTree());

                    }
                    break;

            }

             _addTerminatesRule((event_varient93!=null?event_varient93.name:null), (event_varient93!=null?event_varient93.args:null), (results!=null?results.fluents:null), (conditions!=null?conditions.fluents:null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "terminates_rule"

    public static class initially_decl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "initially_decl"
    // InstAL.g:536:1: initially_decl : KEY_INITIALLY fluents_with_variables END ;
    public final InstALParser.initially_decl_return initially_decl() throws RecognitionException {
        InstALParser.initially_decl_return retval = new InstALParser.initially_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_INITIALLY96=null;
        Token END98=null;
        InstALParser.fluents_with_variables_return fluents_with_variables97 = null;


        CommonTree KEY_INITIALLY96_tree=null;
        CommonTree END98_tree=null;

        try {
            // InstAL.g:537:2: ( KEY_INITIALLY fluents_with_variables END )
            // InstAL.g:537:4: KEY_INITIALLY fluents_with_variables END
            {
            root_0 = (CommonTree)adaptor.nil();

            KEY_INITIALLY96=(Token)match(input,KEY_INITIALLY,FOLLOW_KEY_INITIALLY_in_initially_decl900); 
            KEY_INITIALLY96_tree = (CommonTree)adaptor.create(KEY_INITIALLY96);
            adaptor.addChild(root_0, KEY_INITIALLY96_tree);

            pushFollow(FOLLOW_fluents_with_variables_in_initially_decl902);
            fluents_with_variables97=fluents_with_variables();

            state._fsp--;

            adaptor.addChild(root_0, fluents_with_variables97.getTree());
            END98=(Token)match(input,END,FOLLOW_END_in_initially_decl904); 
            END98_tree = (CommonTree)adaptor.create(END98);
            adaptor.addChild(root_0, END98_tree);

             log("TODO: initially_decl: " + (fluents_with_variables97!=null?input.toString(fluents_with_variables97.start,fluents_with_variables97.stop):null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "initially_decl"

    public static class obligation_decl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "obligation_decl"
    // InstAL.g:541:1: obligation_decl : KEY_OBLIGATION LPAR event_varient ',' event_varient ',' event_varient RPAR END ;
    public final InstALParser.obligation_decl_return obligation_decl() throws RecognitionException {
        InstALParser.obligation_decl_return retval = new InstALParser.obligation_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_OBLIGATION99=null;
        Token LPAR100=null;
        Token char_literal102=null;
        Token char_literal104=null;
        Token RPAR106=null;
        Token END107=null;
        InstALParser.event_varient_return event_varient101 = null;

        InstALParser.event_varient_return event_varient103 = null;

        InstALParser.event_varient_return event_varient105 = null;


        CommonTree KEY_OBLIGATION99_tree=null;
        CommonTree LPAR100_tree=null;
        CommonTree char_literal102_tree=null;
        CommonTree char_literal104_tree=null;
        CommonTree RPAR106_tree=null;
        CommonTree END107_tree=null;

        try {
            // InstAL.g:542:2: ( KEY_OBLIGATION LPAR event_varient ',' event_varient ',' event_varient RPAR END )
            // InstAL.g:542:4: KEY_OBLIGATION LPAR event_varient ',' event_varient ',' event_varient RPAR END
            {
            root_0 = (CommonTree)adaptor.nil();

            KEY_OBLIGATION99=(Token)match(input,KEY_OBLIGATION,FOLLOW_KEY_OBLIGATION_in_obligation_decl920); 
            KEY_OBLIGATION99_tree = (CommonTree)adaptor.create(KEY_OBLIGATION99);
            adaptor.addChild(root_0, KEY_OBLIGATION99_tree);

            LPAR100=(Token)match(input,LPAR,FOLLOW_LPAR_in_obligation_decl922); 
            LPAR100_tree = (CommonTree)adaptor.create(LPAR100);
            adaptor.addChild(root_0, LPAR100_tree);

            pushFollow(FOLLOW_event_varient_in_obligation_decl924);
            event_varient101=event_varient();

            state._fsp--;

            adaptor.addChild(root_0, event_varient101.getTree());
            char_literal102=(Token)match(input,38,FOLLOW_38_in_obligation_decl926); 
            char_literal102_tree = (CommonTree)adaptor.create(char_literal102);
            adaptor.addChild(root_0, char_literal102_tree);

            pushFollow(FOLLOW_event_varient_in_obligation_decl928);
            event_varient103=event_varient();

            state._fsp--;

            adaptor.addChild(root_0, event_varient103.getTree());
            char_literal104=(Token)match(input,38,FOLLOW_38_in_obligation_decl930); 
            char_literal104_tree = (CommonTree)adaptor.create(char_literal104);
            adaptor.addChild(root_0, char_literal104_tree);

            pushFollow(FOLLOW_event_varient_in_obligation_decl932);
            event_varient105=event_varient();

            state._fsp--;

            adaptor.addChild(root_0, event_varient105.getTree());
            RPAR106=(Token)match(input,RPAR,FOLLOW_RPAR_in_obligation_decl934); 
            RPAR106_tree = (CommonTree)adaptor.create(RPAR106);
            adaptor.addChild(root_0, RPAR106_tree);

            END107=(Token)match(input,END,FOLLOW_END_in_obligation_decl936); 
            END107_tree = (CommonTree)adaptor.create(END107);
            adaptor.addChild(root_0, END107_tree);

             log("TODO: Obligations"); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "obligation_decl"

    protected static class type_arguments_scope {
        ArrayList<String> list;
    }
    protected Stack type_arguments_stack = new Stack();

    public static class type_arguments_return extends ParserRuleReturnScope {
        public ArrayList<String> args;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type_arguments"
    // InstAL.g:546:1: type_arguments returns [ ArrayList<String> args ] : LPAR type_argument ( ',' type_argument )* RPAR ;
    public final InstALParser.type_arguments_return type_arguments() throws RecognitionException {
        type_arguments_stack.push(new type_arguments_scope());
        InstALParser.type_arguments_return retval = new InstALParser.type_arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LPAR108=null;
        Token char_literal110=null;
        Token RPAR112=null;
        InstALParser.type_argument_return type_argument109 = null;

        InstALParser.type_argument_return type_argument111 = null;


        CommonTree LPAR108_tree=null;
        CommonTree char_literal110_tree=null;
        CommonTree RPAR112_tree=null;

         ((type_arguments_scope)type_arguments_stack.peek()).list = new ArrayList<String>(); 
        try {
            // InstAL.g:549:2: ( LPAR type_argument ( ',' type_argument )* RPAR )
            // InstAL.g:549:4: LPAR type_argument ( ',' type_argument )* RPAR
            {
            root_0 = (CommonTree)adaptor.nil();

            LPAR108=(Token)match(input,LPAR,FOLLOW_LPAR_in_type_arguments967); 
            LPAR108_tree = (CommonTree)adaptor.create(LPAR108);
            adaptor.addChild(root_0, LPAR108_tree);

            pushFollow(FOLLOW_type_argument_in_type_arguments969);
            type_argument109=type_argument();

            state._fsp--;

            adaptor.addChild(root_0, type_argument109.getTree());
            // InstAL.g:549:23: ( ',' type_argument )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==38) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InstAL.g:549:24: ',' type_argument
            	    {
            	    char_literal110=(Token)match(input,38,FOLLOW_38_in_type_arguments972); 
            	    char_literal110_tree = (CommonTree)adaptor.create(char_literal110);
            	    adaptor.addChild(root_0, char_literal110_tree);

            	    pushFollow(FOLLOW_type_argument_in_type_arguments974);
            	    type_argument111=type_argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, type_argument111.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            RPAR112=(Token)match(input,RPAR,FOLLOW_RPAR_in_type_arguments978); 
            RPAR112_tree = (CommonTree)adaptor.create(RPAR112);
            adaptor.addChild(root_0, RPAR112_tree);

             retval.args = ((type_arguments_scope)type_arguments_stack.peek()).list; 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            type_arguments_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "type_arguments"

    public static class type_argument_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type_argument"
    // InstAL.g:552:1: type_argument : type_name ;
    public final InstALParser.type_argument_return type_argument() throws RecognitionException {
        InstALParser.type_argument_return retval = new InstALParser.type_argument_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        InstALParser.type_name_return type_name113 = null;



        try {
            // InstAL.g:553:2: ( type_name )
            // InstAL.g:553:4: type_name
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_name_in_type_argument992);
            type_name113=type_name();

            state._fsp--;

            adaptor.addChild(root_0, type_name113.getTree());
             ((type_arguments_scope)type_arguments_stack.peek()).list.add((type_name113!=null?input.toString(type_name113.start,type_name113.stop):null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "type_argument"

    protected static class variable_type_arguments_scope {
        ArrayList<String> list;
        Hashtable<String, String> map;
    }
    protected Stack variable_type_arguments_stack = new Stack();

    public static class variable_type_arguments_return extends ParserRuleReturnScope {
        public ArrayList<String> args;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable_type_arguments"
    // InstAL.g:556:1: variable_type_arguments returns [ArrayList<String> args] : LPAR variable_type_argument ( ',' variable_type_argument )* RPAR ;
    public final InstALParser.variable_type_arguments_return variable_type_arguments() throws RecognitionException {
        variable_type_arguments_stack.push(new variable_type_arguments_scope());
        InstALParser.variable_type_arguments_return retval = new InstALParser.variable_type_arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LPAR114=null;
        Token char_literal116=null;
        Token RPAR118=null;
        InstALParser.variable_type_argument_return variable_type_argument115 = null;

        InstALParser.variable_type_argument_return variable_type_argument117 = null;


        CommonTree LPAR114_tree=null;
        CommonTree char_literal116_tree=null;
        CommonTree RPAR118_tree=null;

         ((variable_type_arguments_scope)variable_type_arguments_stack.peek()).list = new ArrayList<String>(); ((variable_type_arguments_scope)variable_type_arguments_stack.peek()).map = new Hashtable<String, String>(); 
        try {
            // InstAL.g:559:2: ( LPAR variable_type_argument ( ',' variable_type_argument )* RPAR )
            // InstAL.g:559:4: LPAR variable_type_argument ( ',' variable_type_argument )* RPAR
            {
            root_0 = (CommonTree)adaptor.nil();

            LPAR114=(Token)match(input,LPAR,FOLLOW_LPAR_in_variable_type_arguments1021); 
            LPAR114_tree = (CommonTree)adaptor.create(LPAR114);
            adaptor.addChild(root_0, LPAR114_tree);

            pushFollow(FOLLOW_variable_type_argument_in_variable_type_arguments1023);
            variable_type_argument115=variable_type_argument();

            state._fsp--;

            adaptor.addChild(root_0, variable_type_argument115.getTree());
            // InstAL.g:559:32: ( ',' variable_type_argument )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==38) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InstAL.g:559:34: ',' variable_type_argument
            	    {
            	    char_literal116=(Token)match(input,38,FOLLOW_38_in_variable_type_arguments1027); 
            	    char_literal116_tree = (CommonTree)adaptor.create(char_literal116);
            	    adaptor.addChild(root_0, char_literal116_tree);

            	    pushFollow(FOLLOW_variable_type_argument_in_variable_type_arguments1029);
            	    variable_type_argument117=variable_type_argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, variable_type_argument117.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            RPAR118=(Token)match(input,RPAR,FOLLOW_RPAR_in_variable_type_arguments1034); 
            RPAR118_tree = (CommonTree)adaptor.create(RPAR118);
            adaptor.addChild(root_0, RPAR118_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            variable_type_arguments_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "variable_type_arguments"

    public static class variable_type_argument_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable_type_argument"
    // InstAL.g:562:1: variable_type_argument : variable_name ':' type_name ;
    public final InstALParser.variable_type_argument_return variable_type_argument() throws RecognitionException {
        InstALParser.variable_type_argument_return retval = new InstALParser.variable_type_argument_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal120=null;
        InstALParser.variable_name_return variable_name119 = null;

        InstALParser.type_name_return type_name121 = null;


        CommonTree char_literal120_tree=null;

        try {
            // InstAL.g:563:2: ( variable_name ':' type_name )
            // InstAL.g:563:4: variable_name ':' type_name
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_variable_name_in_variable_type_argument1046);
            variable_name119=variable_name();

            state._fsp--;

            adaptor.addChild(root_0, variable_name119.getTree());
            char_literal120=(Token)match(input,40,FOLLOW_40_in_variable_type_argument1048); 
            char_literal120_tree = (CommonTree)adaptor.create(char_literal120);
            adaptor.addChild(root_0, char_literal120_tree);

            pushFollow(FOLLOW_type_name_in_variable_type_argument1050);
            type_name121=type_name();

            state._fsp--;

            adaptor.addChild(root_0, type_name121.getTree());
             ((variable_type_arguments_scope)variable_type_arguments_stack.peek()).list.add((variable_name119!=null?input.toString(variable_name119.start,variable_name119.stop):null)); ((variable_type_arguments_scope)variable_type_arguments_stack.peek()).map.put((variable_name119!=null?input.toString(variable_name119.start,variable_name119.stop):null), (type_name121!=null?input.toString(type_name121.start,type_name121.stop):null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "variable_type_argument"

    protected static class variable_arguments_scope {
        ArrayList<String> list;
    }
    protected Stack variable_arguments_stack = new Stack();

    public static class variable_arguments_return extends ParserRuleReturnScope {
        public ArrayList<String> args;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable_arguments"
    // InstAL.g:566:1: variable_arguments returns [ArrayList<String> args] : LPAR variable_argument ( ',' variable_argument )* RPAR ;
    public final InstALParser.variable_arguments_return variable_arguments() throws RecognitionException {
        variable_arguments_stack.push(new variable_arguments_scope());
        InstALParser.variable_arguments_return retval = new InstALParser.variable_arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LPAR122=null;
        Token char_literal124=null;
        Token RPAR126=null;
        InstALParser.variable_argument_return variable_argument123 = null;

        InstALParser.variable_argument_return variable_argument125 = null;


        CommonTree LPAR122_tree=null;
        CommonTree char_literal124_tree=null;
        CommonTree RPAR126_tree=null;

         ((variable_arguments_scope)variable_arguments_stack.peek()).list = new ArrayList<String>(); 
        try {
            // InstAL.g:569:2: ( LPAR variable_argument ( ',' variable_argument )* RPAR )
            // InstAL.g:569:4: LPAR variable_argument ( ',' variable_argument )* RPAR
            {
            root_0 = (CommonTree)adaptor.nil();

            LPAR122=(Token)match(input,LPAR,FOLLOW_LPAR_in_variable_arguments1080); 
            LPAR122_tree = (CommonTree)adaptor.create(LPAR122);
            adaptor.addChild(root_0, LPAR122_tree);

            pushFollow(FOLLOW_variable_argument_in_variable_arguments1082);
            variable_argument123=variable_argument();

            state._fsp--;

            adaptor.addChild(root_0, variable_argument123.getTree());
            // InstAL.g:569:27: ( ',' variable_argument )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==38) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InstAL.g:569:29: ',' variable_argument
            	    {
            	    char_literal124=(Token)match(input,38,FOLLOW_38_in_variable_arguments1086); 
            	    char_literal124_tree = (CommonTree)adaptor.create(char_literal124);
            	    adaptor.addChild(root_0, char_literal124_tree);

            	    pushFollow(FOLLOW_variable_argument_in_variable_arguments1088);
            	    variable_argument125=variable_argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, variable_argument125.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            RPAR126=(Token)match(input,RPAR,FOLLOW_RPAR_in_variable_arguments1093); 
            RPAR126_tree = (CommonTree)adaptor.create(RPAR126);
            adaptor.addChild(root_0, RPAR126_tree);

             retval.args = ((variable_arguments_scope)variable_arguments_stack.peek()).list; 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            variable_arguments_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "variable_arguments"

    public static class variable_argument_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable_argument"
    // InstAL.g:572:1: variable_argument : variable_name ;
    public final InstALParser.variable_argument_return variable_argument() throws RecognitionException {
        InstALParser.variable_argument_return retval = new InstALParser.variable_argument_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        InstALParser.variable_name_return variable_name127 = null;



        try {
            // InstAL.g:573:2: ( variable_name )
            // InstAL.g:573:4: variable_name
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_variable_name_in_variable_argument1107);
            variable_name127=variable_name();

            state._fsp--;

            adaptor.addChild(root_0, variable_name127.getTree());
             ((variable_arguments_scope)variable_arguments_stack.peek()).list.add((variable_name127!=null?input.toString(variable_name127.start,variable_name127.stop):null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "variable_argument"

    public static class variable_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable_name"
    // InstAL.g:576:1: variable_name : VARIABLE ;
    public final InstALParser.variable_name_return variable_name() throws RecognitionException {
        InstALParser.variable_name_return retval = new InstALParser.variable_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VARIABLE128=null;

        CommonTree VARIABLE128_tree=null;

        try {
            // InstAL.g:577:2: ( VARIABLE )
            // InstAL.g:577:4: VARIABLE
            {
            root_0 = (CommonTree)adaptor.nil();

            VARIABLE128=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_variable_name1121); 
            VARIABLE128_tree = (CommonTree)adaptor.create(VARIABLE128);
            adaptor.addChild(root_0, VARIABLE128_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "variable_name"

    public static class operation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "operation"
    // InstAL.g:580:1: operation : ( LT | GT | EQ | NE );
    public final InstALParser.operation_return operation() throws RecognitionException {
        InstALParser.operation_return retval = new InstALParser.operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set129=null;

        CommonTree set129_tree=null;

        try {
            // InstAL.g:581:2: ( LT | GT | EQ | NE )
            // InstAL.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set129=(Token)input.LT(1);
            if ( (input.LA(1)>=LT && input.LA(1)<=NE) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set129));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "operation"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA3_eotS =
        "\26\uffff";
    static final String DFA3_eofS =
        "\26\uffff";
    static final String DFA3_minS =
        "\1\7\4\uffff\1\21\1\16\1\7\1\31\2\uffff\1\21\1\22\1\31\1\16\1\31"+
        "\1\16\2\22\1\31\2\22";
    static final String DFA3_maxS =
        "\1\47\4\uffff\1\21\1\26\1\7\1\31\2\uffff\1\22\1\46\1\31\1\26\1\31"+
        "\1\26\2\46\1\31\1\22\1\46";
    static final String DFA3_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\4\uffff\1\5\1\6\13\uffff";
    static final String DFA3_specialS =
        "\26\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\6\1\1\3\uffff\2\3\12\uffff\1\4\11\uffff\4\2\1\uffff\1\5",
            "",
            "",
            "",
            "",
            "\1\7",
            "\1\11\2\uffff\1\10\3\uffff\2\12",
            "\1\13",
            "\1\14",
            "",
            "",
            "\1\15\1\16",
            "\1\20\23\uffff\1\17",
            "\1\21",
            "\1\11\6\uffff\2\12",
            "\1\22",
            "\1\11\6\uffff\2\12",
            "\1\24\23\uffff\1\23",
            "\1\20\23\uffff\1\17",
            "\1\25",
            "\1\16",
            "\1\24\23\uffff\1\23"
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "404:1: constituent_decl : ( type_decl | event_decl | fluent_decl | obligation_decl | generates_rule | consequence_rule );";
        }
    }
    static final String DFA21_eotS =
        "\22\uffff";
    static final String DFA21_eofS =
        "\22\uffff";
    static final String DFA21_minS =
        "\1\7\2\21\1\7\1\31\2\uffff\1\21\1\22\1\31\1\25\1\31\1\25\2\22\1"+
        "\31\2\22";
    static final String DFA21_maxS =
        "\1\47\1\21\1\26\1\7\1\31\2\uffff\1\22\1\46\1\31\1\26\1\31\1\26\2"+
        "\46\1\31\1\22\1\46";
    static final String DFA21_acceptS =
        "\5\uffff\1\1\1\2\13\uffff";
    static final String DFA21_specialS =
        "\22\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\2\37\uffff\1\1",
            "\1\3",
            "\1\4\3\uffff\1\5\1\6",
            "\1\7",
            "\1\10",
            "",
            "",
            "\1\11\1\12",
            "\1\14\23\uffff\1\13",
            "\1\15",
            "\1\5\1\6",
            "\1\16",
            "\1\5\1\6",
            "\1\20\23\uffff\1\17",
            "\1\14\23\uffff\1\13",
            "\1\21",
            "\1\12",
            "\1\20\23\uffff\1\17"
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "525:4: ( initiates_rule | terminates_rule )";
        }
    }
 

    public static final BitSet FOLLOW_institution_decl_in_instal_specification58 = new BitSet(new long[]{0x000000BC01803190L});
    public static final BitSet FOLLOW_constituent_decl_in_instal_specification69 = new BitSet(new long[]{0x000000BC01803190L});
    public static final BitSet FOLLOW_LINE_COMMENT_in_instal_specification73 = new BitSet(new long[]{0x000000BC01803190L});
    public static final BitSet FOLLOW_initially_decl_in_instal_specification82 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_LINE_COMMENT_in_instal_specification88 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_EOF_in_instal_specification95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEY_INST_in_institution_decl119 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_institution_name_in_institution_decl121 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_END_in_institution_decl123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_institution_name138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_decl_in_constituent_decl148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_decl_in_constituent_decl154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fluent_decl_in_constituent_decl160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_obligation_decl_in_constituent_decl165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_generates_rule_in_constituent_decl172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_consequence_rule_in_constituent_decl178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEY_TYPE_in_type_decl192 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_type_name_in_type_decl194 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_END_in_type_decl196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPE_in_type_name213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_extended_event_decl_in_event_decl233 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_standard_event_decl_in_event_decl242 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_END_in_event_decl251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_description_in_standard_event_decl267 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_type_arguments_in_standard_event_decl269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_description_in_extended_event_decl288 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_variable_type_arguments_in_extended_event_decl290 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_KEY_WITH_in_extended_event_decl292 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_variable_constraints_in_extended_event_decl294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_type_in_event_description312 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_KEY_EVENT_in_event_description314 = new BitSet(new long[]{0x0000008000000080L});
    public static final BitSet FOLLOW_event_name_in_event_description316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_event_name330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_event_type340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_constraint_in_variable_constraints366 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_variable_constraints370 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_variable_constraint_in_variable_constraints372 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_variable_name_in_variable_constraint385 = new BitSet(new long[]{0x000000003C000000L});
    public static final BitSet FOLLOW_operation_in_variable_constraint387 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_variable_name_in_variable_constraint389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_noninertial_fluent_decl_in_fluent_decl405 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_standard_fluent_decl_in_fluent_decl413 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_END_in_fluent_decl421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEY_NONINERTIAL_in_noninertial_fluent_decl439 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_standard_fluent_decl_in_noninertial_fluent_decl441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEY_FLUENT_in_standard_fluent_decl459 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_fluent_name_in_standard_fluent_decl461 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_type_arguments_in_standard_fluent_decl463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_fluent_name478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_varient_in_generates_rule491 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_KEY_GENERATES_in_generates_rule493 = new BitSet(new long[]{0x0000008000000080L});
    public static final BitSet FOLLOW_events_with_variables_in_generates_rule497 = new BitSet(new long[]{0x0000000000008040L});
    public static final BitSet FOLLOW_KEY_IF_in_generates_rule501 = new BitSet(new long[]{0x0000000000190080L});
    public static final BitSet FOLLOW_fluents_with_variables_with_negation_in_generates_rule505 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_END_in_generates_rule510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_with_variables_in_events_with_variables540 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_events_with_variables544 = new BitSet(new long[]{0x0000008000000080L});
    public static final BitSet FOLLOW_event_with_variables_in_events_with_variables546 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_event_varient_in_event_with_variables563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fluent_with_variables_in_fluents_with_variables591 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_fluents_with_variables595 = new BitSet(new long[]{0x0000000000190080L});
    public static final BitSet FOLLOW_fluent_with_variables_in_fluents_with_variables597 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_fluent_varient_in_fluent_with_variables615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fluent_with_variables_with_negation_in_fluents_with_variables_with_negation643 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_fluents_with_variables_with_negation647 = new BitSet(new long[]{0x0000000000190080L});
    public static final BitSet FOLLOW_fluent_with_variables_with_negation_in_fluents_with_variables_with_negation649 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_KEY_NOT_in_fluent_with_variables_with_negation668 = new BitSet(new long[]{0x0000000000190080L});
    public static final BitSet FOLLOW_fluent_varient_in_fluent_with_variables_with_negation670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fluent_varient_in_fluent_with_variables_with_negation677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_event_varient700 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_LPAR_in_event_varient702 = new BitSet(new long[]{0x0000008000000080L});
    public static final BitSet FOLLOW_event_name_in_event_varient704 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_variable_arguments_in_event_varient707 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RPAR_in_event_varient710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_name_in_event_varient722 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_variable_arguments_in_event_varient725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEY_POW_in_fluent_varient750 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_LPAR_in_fluent_varient752 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_fluent_name_in_fluent_varient754 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_variable_arguments_in_fluent_varient756 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RPAR_in_fluent_varient759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEY_PERM_in_fluent_varient772 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_LPAR_in_fluent_varient774 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_fluent_name_in_fluent_varient776 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_variable_arguments_in_fluent_varient778 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RPAR_in_fluent_varient781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fluent_name_in_fluent_varient793 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_variable_arguments_in_fluent_varient795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_initiates_rule_in_consequence_rule818 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_terminates_rule_in_consequence_rule822 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_END_in_consequence_rule826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_varient_in_initiates_rule836 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_KEY_INITIATES_in_initiates_rule838 = new BitSet(new long[]{0x0000000000190080L});
    public static final BitSet FOLLOW_fluents_with_variables_in_initiates_rule842 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_KEY_IF_in_initiates_rule846 = new BitSet(new long[]{0x0000000000190080L});
    public static final BitSet FOLLOW_fluents_with_variables_in_initiates_rule850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_varient_in_terminates_rule867 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_KEY_TERMINATES_in_terminates_rule869 = new BitSet(new long[]{0x0000000000190080L});
    public static final BitSet FOLLOW_fluents_with_variables_in_terminates_rule873 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_KEY_IF_in_terminates_rule877 = new BitSet(new long[]{0x0000000000190080L});
    public static final BitSet FOLLOW_fluents_with_variables_in_terminates_rule881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEY_INITIALLY_in_initially_decl900 = new BitSet(new long[]{0x0000000000190080L});
    public static final BitSet FOLLOW_fluents_with_variables_in_initially_decl902 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_END_in_initially_decl904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEY_OBLIGATION_in_obligation_decl920 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_LPAR_in_obligation_decl922 = new BitSet(new long[]{0x0000008000000080L});
    public static final BitSet FOLLOW_event_varient_in_obligation_decl924 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_obligation_decl926 = new BitSet(new long[]{0x0000008000000080L});
    public static final BitSet FOLLOW_event_varient_in_obligation_decl928 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_obligation_decl930 = new BitSet(new long[]{0x0000008000000080L});
    public static final BitSet FOLLOW_event_varient_in_obligation_decl932 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RPAR_in_obligation_decl934 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_END_in_obligation_decl936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_in_type_arguments967 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_type_argument_in_type_arguments969 = new BitSet(new long[]{0x0000004000040000L});
    public static final BitSet FOLLOW_38_in_type_arguments972 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_type_argument_in_type_arguments974 = new BitSet(new long[]{0x0000004000040000L});
    public static final BitSet FOLLOW_RPAR_in_type_arguments978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_name_in_type_argument992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_in_variable_type_arguments1021 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_variable_type_argument_in_variable_type_arguments1023 = new BitSet(new long[]{0x0000004000040000L});
    public static final BitSet FOLLOW_38_in_variable_type_arguments1027 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_variable_type_argument_in_variable_type_arguments1029 = new BitSet(new long[]{0x0000004000040000L});
    public static final BitSet FOLLOW_RPAR_in_variable_type_arguments1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_name_in_variable_type_argument1046 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_variable_type_argument1048 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_type_name_in_variable_type_argument1050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_in_variable_arguments1080 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_variable_argument_in_variable_arguments1082 = new BitSet(new long[]{0x0000004000040000L});
    public static final BitSet FOLLOW_38_in_variable_arguments1086 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_variable_argument_in_variable_arguments1088 = new BitSet(new long[]{0x0000004000040000L});
    public static final BitSet FOLLOW_RPAR_in_variable_arguments1093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_name_in_variable_argument1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_variable_name1121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_operation0 = new BitSet(new long[]{0x0000000000000002L});

}