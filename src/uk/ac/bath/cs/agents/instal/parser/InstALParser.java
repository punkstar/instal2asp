// $ANTLR 3.3 Nov 30, 2010 12:45:30 InstAL.g 2011-05-04 09:07:25

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LINE_COMMENT", "KEY_INST", "END", "LITERAL", "KEY_TYPE", "TYPE", "KEY_WITH", "KEY_EVENT", "EVENT_KEY_CREATE", "KEY_NONINERTIAL", "KEY_FLUENT", "KEY_GENERATES", "KEY_IF", "KEY_NOT", "LPAR", "RPAR", "KEY_POW", "KEY_PERM", "KEY_INITIATES", "KEY_TERMINATES", "KEY_INITIALLY", "KEY_OBLIGATION", "LT", "GT", "EQ", "NE", "UCALPHA", "DIGIT", "LCALPHA", "INTEGER", "ANY", "'exogenous'", "'inst'", "'violation'", "','", "'viol'", "':'"
    };
    public static final int EOF=-1;
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
    public static final int INTEGER=33;
    public static final int ANY=34;

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

    	
    	public Institution i = new Institution("holder", 2); // Set it to a holder institution for testing the grammar
    	public Domain d = new Domain();
    	protected Hashtable<String, Type> _typeMap = new Hashtable<String, Type>();
    	protected Hashtable<String, NoninertialFluent> _noninertialFluentMap = new Hashtable<String, NoninertialFluent>();
    	protected Hashtable<String, Fluent> _inertialFluentMap = new Hashtable<String, Fluent>();
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
    	
    	// Constructors
    	protected void _setInsitutionName(String name) {
    		i.setName(name);
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
    		try {
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
    					}				}
    				i.event(e);
    				_eventMap.put(name, e);
    			} else if (type.equals("creation") || type.equals("create")) {
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
    		} catch (Exception e) {
    			emitErrorMessage("There was an error with an event definition: " + e.getMessage());
    		}
    	}
    	
    	protected void _addComplexEvent(String type, String name, Hashtable<String, String> types_with_names, ArrayList<Constraint> constraints) {
    		log("Adding complex event: " + name + ", " + type);
    		try {
    			Event e;
    			
    			if (type.equals("exogenous")) {
    				e = new ExogenousEvent(name);
    			} else if (type.equals("inst")) {
    				e = new NormativeEvent(name);
    			} else if (type.equals("creation") || type.equals("create")) {
    				e = new CreationEvent(name);
    			} else if (type.equals("violation")) {
    				e = new ViolationEvent(name);
    			} else {
    				emitErrorMessage("Unrecognised event type '" + type + "'");
    				return;
    			}
    			
    			if (types_with_names != null) {
    				Iterator<String> iter = types_with_names.keySet().iterator();
    				while (iter.hasNext()) {
    					String key = iter.next();
    					Type t = _getType(types_with_names.get(key));
    			
    					e.addParameter(t, key);
    				}
    			}
    			
    			if (constraints != null) {
    				Iterator<Constraint> iter_c = constraints.iterator();
    				while (iter_c.hasNext()) {
    					Constraint c = iter_c.next();
    					log("Adding constraint " + c.x + " " + c.op + " " + c.y);
    					e.constraint(c.x, c.op, c.y);
    				}
    			}
    			
    			log("Adding event to inst");
    			i.event(e);
    			log("Done");
    			_eventMap.put(name, e);
    			
    		} catch (Exception e) {
    			emitErrorMessage("There was an error with an event definition: " + e.getMessage());
    		}
    	}
    	
    	protected void _addFluent(String type, String name, ArrayList<String> args) {
    		try {
    			if (_inertialFluentMap.containsKey(name)) {
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
    				
    				i.noninertial(f);
    				_noninertialFluentMap.put(name, f);
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
    				
    				_inertialFluentMap.put(name, f);
    			} else {
    				emitErrorMessage("Unrecognised fluent type '" + type + "'");
    				return;
    			}
    		} catch (Exception e) {
    			emitErrorMessage("There was an error with a fluent definition: " + e.getMessage());
    		}
    	}

    	protected void _addGeneratesRule(String event, ArrayList<String> event_variables, ArrayList<EventWithVariables> result_events, ArrayList<FluentCondition> condition_fluents) {
    		String[] event_vars_array = new String[] {};
    		
    		if (event_variables != null) {
    			event_vars_array = event_variables.toArray(new String[] {});
    		}
    		
    		try {
    			if (_getEvent(event) != null) {
    				Generates g = new Generates(_getEvent(event), event_vars_array);
    				
    				g = (Generates) _addRuleConditions(g,condition_fluents);
    				g = (Generates) _addRuleResultEvents(g,result_events);
    				
    				i.generates(g);
    			}
    		} catch (Exception e) {
    			emitErrorMessage("There was an error with a generates rule: " + e.getMessage());
    		}
    	}
    	
    	protected void _addInitiatesRule(String event, ArrayList<String> event_variables, ArrayList<FluentCondition> result_fluents, ArrayList<FluentCondition> condition_fluents) {
    		String[] event_vars_array = new String[] {};
    		
    		if (event_variables != null) {
    			event_vars_array = event_variables.toArray(new String[] {});
    		}
    		
    		try {
    			if (_getEvent(event) != null) {
    				Initiates in = new Initiates(_getEvent(event), event_vars_array);
    				
    				if (_checkInertialFluentsExist(result_fluents) && _checkInertialFluentsExist(condition_fluents)) {
    					in = (Initiates) _addRuleConditions(in, condition_fluents);
    					in = (Initiates) _addRuleResultFluents(in, result_fluents);
    					
    					i.initiates(in);
    				} else {
    					log("Ignoring inititates because there are fluents that don't exist");
    				}
    			}
    		} catch (Exception e) {
    			emitErrorMessage("There was an error with an initiates rule: " + e.getMessage() + ", Event: " + event);
    			e.printStackTrace();
    		}
    	}

    	protected void _addTerminatesRule(String event, ArrayList<String> event_variables, ArrayList<FluentCondition> result_fluents, ArrayList<FluentCondition> condition_fluents) {
    		String[] event_vars_array = new String[] {};
    		
    		if (event_variables != null) {
    			event_vars_array = event_variables.toArray(new String[] {});
    		}
    	
    		try {
    			if (_getEvent(event) != null) {
    				Terminates t = new Terminates(_getEvent(event), event_vars_array);
    				
    				if (_checkInertialFluentsExist(result_fluents) && _checkInertialFluentsExist(condition_fluents)) {	
    					t = (Terminates) _addRuleConditions(t, condition_fluents);

    					t = (Terminates) _addRuleResultFluents(t, result_fluents);
    					
    					i.terminates(t);
    				} else {
    					log("Ignoring terminates because there are fluents that don't exist");
    				}
    			}		
    		} catch (Exception e) {
    			emitErrorMessage("There was an error with a terminates rule: " + e.getMessage());
    		}
    	}
    	
    	protected void _addObligation(String act, ArrayList<String> act_vars, String before, ArrayList<String> before_vars, String otherwise, ArrayList<String> otherwise_vars) {
    		Obligation o = new Obligation();
    		
    		Event eAct = null, eBefore = null, eOtherwise = null;
    			
    		try {	
    			eAct = _getEvent(act);
    			eBefore = _getEvent(before);
    			eOtherwise = _getEvent(otherwise);
    		} catch (Exception e) {
    			emitErrorMessage("There was a problem finding the event objects!: " + e.getMessage());
    			return;
    		}
    		
    		String[] vAct, vBefore, vOtherwise;
    		
    		if (act_vars == null) {
    			vAct = new String[] {};		
    		} else {
    			vAct = act_vars.toArray(new String[] {});
    		}
    		
    		if (before_vars == null) {
    			vBefore = new String[] {};
    		} else {
    			vBefore = before_vars.toArray(new String[] {});
    		}
    		
    		if (otherwise_vars == null) {
    			vOtherwise = new String[] {};
    		} else {
    			vOtherwise = otherwise_vars.toArray(new String[] {});
    		}
    		
    		o.act(eAct, vAct)
    		 .before(eBefore, vBefore)
    	  	 .otherwise(eOtherwise, vOtherwise);
    			 
    		i.obl(o);
    	}
    	
    	protected Rule _addRuleConditions(Rule r, ArrayList<FluentCondition> condition_fluents) throws Exception {
    		// Conditions
    		if (condition_fluents != null) {
    			Iterator<FluentCondition> iter2 = condition_fluents.iterator();
    			while (iter2.hasNext()) {
    				FluentCondition cond = iter2.next();
    				
    				_addInertialFluent(cond);
    				
    				if (cond.sign) {
    					r.condition(_getInertialFluent(cond.getFluent()), cond.args);
    				} else {
    					r.condition(false, _getInertialFluent(cond.getFluent()), cond.args);
    				}
    			}
    		}
    		
    		return r;
    	}
    	
    	protected Rule _addRuleResultFluents(Rule r, ArrayList<FluentCondition> result_fluents) throws Exception {
    		// Results
    		if (result_fluents != null) {
    			Iterator<FluentCondition> iter = result_fluents.iterator();
    			while (iter.hasNext()) {
    				FluentCondition f_v = iter.next();
    				
    				_addInertialFluent(f_v);
    				
    				if (f_v.args == null) {
    					r.result(_getInertialFluent(f_v.getFluent()));
    				} else {
    					r.result(_getInertialFluent(f_v.getFluent()), f_v.args);
    				}
    			}
    		}
    		
    		return r;
    	}
    	
    	protected Rule _addRuleResultEvents(Rule r, ArrayList<EventWithVariables> result_events) throws Exception {
    		// Results
    		if (result_events != null) {
    			Iterator<EventWithVariables> iter = result_events.iterator();
    			while (iter.hasNext()) {
    				EventWithVariables e_v = iter.next();
    				
    				if (e_v.args == null) {
    					r.result(_getEvent(e_v.name));
    				} else {
    					r.result(_getEvent(e_v.name), e_v.args);
    				}
    			}
    		}
    		
    		return r;
    	}
    	
    	protected void _addInitiallyFluents(ArrayList<FluentCondition> fluents) {
    		try {
    			Iterator<FluentCondition> iter = fluents.iterator();
    			while (iter.hasNext()) {
    				FluentCondition f = iter.next();
    				_addInitiallyFluent(f);
    			}
    		} catch (Exception e) {
    			emitErrorMessage("There was an error with an initially statement: " + e.getMessage());
    		}
    	}
    	
    	protected void _addInitiallyFluent(FluentCondition f) throws Exception {
    	    _addInertialFluent(f);
    		i.initially(_getInertialFluent(f.getFluent()).initially(f.args));
    	}
    	
    	// Utility
    	protected Type _getType(String name) throws Exception {
    		if (_typeMap.containsKey(name)) {
    			return _typeMap.get(name);
    		} else {
    			emitErrorMessage("Type '" + name + "' is undefined");
    			throw new Exception("Type '" + name + "' is undefined");
    		}
    	}
    	
    	protected uk.ac.bath.cs.agents.instal.Event _getEvent(String name) throws Exception {
    		if (_eventMap.containsKey(name)) {
    			return _eventMap.get(name);
    		} else {
    			emitErrorMessage("Event '" + name + "' is undefined");
    			throw new Exception("Event '" + name + "' is undefined");
    		}
    	}
    	
    	protected Fluent _getInertialFluent(String name) throws Exception {
    		if(_inertialFluentMap.containsKey(name)) {
    			return _inertialFluentMap.get(name);
    		} else {
    			emitErrorMessage("Fluent '" + name + "' is undefined");
    			throw new Exception("Fluent '" + name + "' is undefined");
    		}
    	}
    	
    	protected Fluent _addInertialFluent(FluentCondition fc) throws Exception {
    	    if (!_inertialFluentMap.containsKey(fc.getFluent())) {
    	        if (fc.isModified()) {
    	            if (fc.modifier.equals("perm")) {
            	        _inertialFluentMap.put(fc.getFluent(), _getEvent(fc.name).pow());	            
    	            } else if (fc.modifier.equals("pow")) {
            	        _inertialFluentMap.put(fc.getFluent(), _getEvent(fc.name).pow());
    	            }
    	        }
    	    }
    	    
    	    return _getInertialFluent(fc.getFluent());
    	}
    	
    	protected boolean _checkInertialFluentsExist(ArrayList<FluentCondition> fluents) {
    		if (fluents != null) {
    			Iterator<FluentCondition> iter = fluents.iterator();
    			while(iter.hasNext()) {
    				FluentCondition f = iter.next();
    				
    				try {
    					if (!f.isModified() && _getInertialFluent(f.getFluent()) == null) {
    						return false;
    					}
    				} catch (Exception e) {
    					return false;
    				}
    			}
    		}
    		
    		return true;
    	}
    	
    	private class FluentCondition {
    		public boolean sign;
    		public String name;
    		public String[] args;
    		public String modifier;
    		
    		public FluentCondition(boolean sign, String fluent, ArrayList<String> args, String modifier) {
    			this.sign = sign;
    			this.name = fluent;
    			this.modifier = modifier;
    			
    			if (args != null) {
    				this.args = args.toArray(new String[] {});
    			} else {
    				this.args = null;
    			}
    		}
    		
    		public FluentCondition(boolean sign, String fluent, ArrayList<String> args) {
    			this(sign, fluent, args, "");
    		}
    		
    		public String getFluent() {
    			if (modifier.equals("pow")) {
    				return "pow(" + this.name + ")";			
    			} else if (modifier.equals("perm")) {
    				return "perm(" + this.name + ")";
    			} else {
    				return this.name;
    			}
    		}
    		
    		public String getName() {
    			return this.name;
    		}
    		
    		public boolean isModified() {
    		    return !this.modifier.equals("");
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
    	
    	private class Constraint {
    		public String x;
    		public String y;
    		public String op;
    		
    		public Constraint(String x, String op, String y) {
    			this.x = x;
    			this.y = y;
    			this.op = op;
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
      	

        public String getErrorMessage(RecognitionException e,
                                      String[] tokenNames)
        {
            List stack = getRuleInvocationStack(e, this.getClass().getName());
            String msg = null;
            if ( e instanceof NoViableAltException ) {
               NoViableAltException nvae = (NoViableAltException)e;
               msg = " no viable alt; token="+e.token+
                  " (decision="+nvae.decisionNumber+
                  " state "+nvae.stateNumber+")"+
                  " decision=<<"+nvae.grammarDecisionDescription+">>";
            }
            else {
               msg = super.getErrorMessage(e, tokenNames);
            }
            return stack+" "+msg;
        }
        public String getTokenErrorDisplay(Token t) {
            return t.toString();
        }


    public static class instal_specification_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instal_specification"
    // InstAL.g:579:1: instal_specification : institution_decl ( constituent_decl | LINE_COMMENT )* ( initially_decl | LINE_COMMENT )* EOF ;
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
            // InstAL.g:580:2: ( institution_decl ( constituent_decl | LINE_COMMENT )* ( initially_decl | LINE_COMMENT )* EOF )
            // InstAL.g:581:3: institution_decl ( constituent_decl | LINE_COMMENT )* ( initially_decl | LINE_COMMENT )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_institution_decl_in_instal_specification58);
            institution_decl1=institution_decl();

            state._fsp--;

            adaptor.addChild(root_0, institution_decl1.getTree());
             _setInsitutionName((institution_decl1!=null?institution_decl1.name:null)); 
            // InstAL.g:582:3: ( constituent_decl | LINE_COMMENT )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==LINE_COMMENT) ) {
                    alt1=2;
                }
                else if ( ((LA1_0>=LITERAL && LA1_0<=KEY_TYPE)||(LA1_0>=EVENT_KEY_CREATE && LA1_0<=KEY_FLUENT)||LA1_0==KEY_OBLIGATION||(LA1_0>=35 && LA1_0<=37)||LA1_0==39) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InstAL.g:582:5: constituent_decl
            	    {
            	    pushFollow(FOLLOW_constituent_decl_in_instal_specification69);
            	    constituent_decl2=constituent_decl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, constituent_decl2.getTree());

            	    }
            	    break;
            	case 2 :
            	    // InstAL.g:582:24: LINE_COMMENT
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

            // InstAL.g:583:3: ( initially_decl | LINE_COMMENT )*
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
            	    // InstAL.g:583:5: initially_decl
            	    {
            	    pushFollow(FOLLOW_initially_decl_in_instal_specification82);
            	    initially_decl4=initially_decl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, initially_decl4.getTree());

            	    }
            	    break;
            	case 2 :
            	    // InstAL.g:583:24: LINE_COMMENT
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
    // InstAL.g:587:1: institution_decl returns [String name] : KEY_INST institution_name END ;
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
            // InstAL.g:588:2: ( KEY_INST institution_name END )
            // InstAL.g:588:4: KEY_INST institution_name END
            {
            root_0 = (CommonTree)adaptor.nil();

            KEY_INST7=(Token)match(input,KEY_INST,FOLLOW_KEY_INST_in_institution_decl112); 
            KEY_INST7_tree = (CommonTree)adaptor.create(KEY_INST7);
            adaptor.addChild(root_0, KEY_INST7_tree);

            pushFollow(FOLLOW_institution_name_in_institution_decl114);
            institution_name8=institution_name();

            state._fsp--;

            adaptor.addChild(root_0, institution_name8.getTree());
            END9=(Token)match(input,END,FOLLOW_END_in_institution_decl116); 
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
    // InstAL.g:591:1: institution_name : LITERAL ;
    public final InstALParser.institution_name_return institution_name() throws RecognitionException {
        InstALParser.institution_name_return retval = new InstALParser.institution_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LITERAL10=null;

        CommonTree LITERAL10_tree=null;

        try {
            // InstAL.g:592:2: ( LITERAL )
            // InstAL.g:592:5: LITERAL
            {
            root_0 = (CommonTree)adaptor.nil();

            LITERAL10=(Token)match(input,LITERAL,FOLLOW_LITERAL_in_institution_name131); 
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
    // InstAL.g:594:1: constituent_decl : ( type_decl | event_decl | fluent_decl | obligation_decl | generates_rule | consequence_rule );
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
            // InstAL.g:595:2: ( type_decl | event_decl | fluent_decl | obligation_decl | generates_rule | consequence_rule )
            int alt3=6;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // InstAL.g:595:4: type_decl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_type_decl_in_constituent_decl141);
                    type_decl11=type_decl();

                    state._fsp--;

                    adaptor.addChild(root_0, type_decl11.getTree());

                    }
                    break;
                case 2 :
                    // InstAL.g:596:5: event_decl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_event_decl_in_constituent_decl147);
                    event_decl12=event_decl();

                    state._fsp--;

                    adaptor.addChild(root_0, event_decl12.getTree());

                    }
                    break;
                case 3 :
                    // InstAL.g:597:5: fluent_decl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_fluent_decl_in_constituent_decl153);
                    fluent_decl13=fluent_decl();

                    state._fsp--;

                    adaptor.addChild(root_0, fluent_decl13.getTree());

                    }
                    break;
                case 4 :
                    // InstAL.g:598:4: obligation_decl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_obligation_decl_in_constituent_decl158);
                    obligation_decl14=obligation_decl();

                    state._fsp--;

                    adaptor.addChild(root_0, obligation_decl14.getTree());

                    }
                    break;
                case 5 :
                    // InstAL.g:599:5: generates_rule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_generates_rule_in_constituent_decl165);
                    generates_rule15=generates_rule();

                    state._fsp--;

                    adaptor.addChild(root_0, generates_rule15.getTree());

                    }
                    break;
                case 6 :
                    // InstAL.g:600:5: consequence_rule
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_consequence_rule_in_constituent_decl171);
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
    // InstAL.g:605:1: type_decl : KEY_TYPE type_name END ;
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
            // InstAL.g:606:2: ( KEY_TYPE type_name END )
            // InstAL.g:606:4: KEY_TYPE type_name END
            {
            root_0 = (CommonTree)adaptor.nil();

            KEY_TYPE17=(Token)match(input,KEY_TYPE,FOLLOW_KEY_TYPE_in_type_decl185); 
            KEY_TYPE17_tree = (CommonTree)adaptor.create(KEY_TYPE17);
            adaptor.addChild(root_0, KEY_TYPE17_tree);

            pushFollow(FOLLOW_type_name_in_type_decl187);
            type_name18=type_name();

            state._fsp--;

            adaptor.addChild(root_0, type_name18.getTree());
            END19=(Token)match(input,END,FOLLOW_END_in_type_decl189); 
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
    // InstAL.g:609:1: type_name returns [String result] : TYPE ;
    public final InstALParser.type_name_return type_name() throws RecognitionException {
        InstALParser.type_name_return retval = new InstALParser.type_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TYPE20=null;

        CommonTree TYPE20_tree=null;

        try {
            // InstAL.g:610:2: ( TYPE )
            // InstAL.g:610:4: TYPE
            {
            root_0 = (CommonTree)adaptor.nil();

            TYPE20=(Token)match(input,TYPE,FOLLOW_TYPE_in_type_name206); 
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
    // InstAL.g:614:1: event_decl : ( extended_event_decl | standard_event_decl ) END ;
    public final InstALParser.event_decl_return event_decl() throws RecognitionException {
        InstALParser.event_decl_return retval = new InstALParser.event_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token END23=null;
        InstALParser.extended_event_decl_return extended_event_decl21 = null;

        InstALParser.standard_event_decl_return standard_event_decl22 = null;


        CommonTree END23_tree=null;

        try {
            // InstAL.g:615:2: ( ( extended_event_decl | standard_event_decl ) END )
            // InstAL.g:616:2: ( extended_event_decl | standard_event_decl ) END
            {
            root_0 = (CommonTree)adaptor.nil();

            // InstAL.g:616:2: ( extended_event_decl | standard_event_decl )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==EVENT_KEY_CREATE||(LA4_0>=35 && LA4_0<=37)) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==KEY_EVENT) ) {
                    int LA4_2 = input.LA(3);

                    if ( (LA4_2==LITERAL) ) {
                        int LA4_3 = input.LA(4);

                        if ( (LA4_3==LPAR) ) {
                            switch ( input.LA(5) ) {
                            case TYPE:
                                {
                                int LA4_6 = input.LA(6);

                                if ( (LA4_6==40) ) {
                                    alt4=1;
                                }
                                else if ( (LA4_6==RPAR||LA4_6==38) ) {
                                    alt4=2;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 4, 6, input);

                                    throw nvae;
                                }
                                }
                                break;
                            case LITERAL:
                                {
                                alt4=1;
                                }
                                break;
                            case RPAR:
                                {
                                alt4=2;
                                }
                                break;
                            default:
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
                    // InstAL.g:616:4: extended_event_decl
                    {
                    pushFollow(FOLLOW_extended_event_decl_in_event_decl226);
                    extended_event_decl21=extended_event_decl();

                    state._fsp--;

                    adaptor.addChild(root_0, extended_event_decl21.getTree());
                     _addComplexEvent((extended_event_decl21!=null?extended_event_decl21.type:null), (extended_event_decl21!=null?extended_event_decl21.name:null), (extended_event_decl21!=null?extended_event_decl21.types_with_names:null), (extended_event_decl21!=null?extended_event_decl21.constraints:null)); 

                    }
                    break;
                case 2 :
                    // InstAL.g:617:5: standard_event_decl
                    {
                    pushFollow(FOLLOW_standard_event_decl_in_event_decl235);
                    standard_event_decl22=standard_event_decl();

                    state._fsp--;

                    adaptor.addChild(root_0, standard_event_decl22.getTree());
                     _addEvent((standard_event_decl22!=null?standard_event_decl22.type:null), (standard_event_decl22!=null?standard_event_decl22.name:null), (standard_event_decl22!=null?standard_event_decl22.types:null)); 

                    }
                    break;

            }

            END23=(Token)match(input,END,FOLLOW_END_in_event_decl244); 
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
    // InstAL.g:621:1: standard_event_decl returns [String type, String name, ArrayList<String> types] : event_description ( type_arguments )? ;
    public final InstALParser.standard_event_decl_return standard_event_decl() throws RecognitionException {
        InstALParser.standard_event_decl_return retval = new InstALParser.standard_event_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        InstALParser.event_description_return event_description24 = null;

        InstALParser.type_arguments_return type_arguments25 = null;



        try {
            // InstAL.g:622:2: ( event_description ( type_arguments )? )
            // InstAL.g:622:4: event_description ( type_arguments )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_event_description_in_standard_event_decl260);
            event_description24=event_description();

            state._fsp--;

            adaptor.addChild(root_0, event_description24.getTree());
            // InstAL.g:622:22: ( type_arguments )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==LPAR) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InstAL.g:622:22: type_arguments
                    {
                    pushFollow(FOLLOW_type_arguments_in_standard_event_decl262);
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
        public Hashtable<String, String> types_with_names;
        public ArrayList<Constraint> constraints;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "extended_event_decl"
    // InstAL.g:625:1: extended_event_decl returns [String type, String name, Hashtable<String, String> types_with_names, ArrayList<Constraint> constraints] : event_description variable_type_arguments KEY_WITH variable_constraints ;
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
            // InstAL.g:626:2: ( event_description variable_type_arguments KEY_WITH variable_constraints )
            // InstAL.g:626:4: event_description variable_type_arguments KEY_WITH variable_constraints
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_event_description_in_extended_event_decl281);
            event_description26=event_description();

            state._fsp--;

            adaptor.addChild(root_0, event_description26.getTree());
            pushFollow(FOLLOW_variable_type_arguments_in_extended_event_decl283);
            variable_type_arguments27=variable_type_arguments();

            state._fsp--;

            adaptor.addChild(root_0, variable_type_arguments27.getTree());
            KEY_WITH28=(Token)match(input,KEY_WITH,FOLLOW_KEY_WITH_in_extended_event_decl285); 
            KEY_WITH28_tree = (CommonTree)adaptor.create(KEY_WITH28);
            adaptor.addChild(root_0, KEY_WITH28_tree);

            pushFollow(FOLLOW_variable_constraints_in_extended_event_decl287);
            variable_constraints29=variable_constraints();

            state._fsp--;

            adaptor.addChild(root_0, variable_constraints29.getTree());
             retval.type = (event_description26!=null?event_description26.type:null); retval.name = (event_description26!=null?event_description26.name:null); retval.types_with_names = (variable_type_arguments27!=null?variable_type_arguments27.typemap:null); retval.constraints = (variable_constraints29!=null?variable_constraints29.constraints:null); 

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
    // InstAL.g:629:1: event_description returns [String type, String name] : event_type KEY_EVENT event_name ;
    public final InstALParser.event_description_return event_description() throws RecognitionException {
        InstALParser.event_description_return retval = new InstALParser.event_description_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_EVENT31=null;
        InstALParser.event_type_return event_type30 = null;

        InstALParser.event_name_return event_name32 = null;


        CommonTree KEY_EVENT31_tree=null;

        try {
            // InstAL.g:630:2: ( event_type KEY_EVENT event_name )
            // InstAL.g:630:4: event_type KEY_EVENT event_name
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_event_type_in_event_description305);
            event_type30=event_type();

            state._fsp--;

            adaptor.addChild(root_0, event_type30.getTree());
            KEY_EVENT31=(Token)match(input,KEY_EVENT,FOLLOW_KEY_EVENT_in_event_description307); 
            KEY_EVENT31_tree = (CommonTree)adaptor.create(KEY_EVENT31);
            adaptor.addChild(root_0, KEY_EVENT31_tree);

            pushFollow(FOLLOW_event_name_in_event_description309);
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
    // InstAL.g:633:1: event_name : LITERAL ;
    public final InstALParser.event_name_return event_name() throws RecognitionException {
        InstALParser.event_name_return retval = new InstALParser.event_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LITERAL33=null;

        CommonTree LITERAL33_tree=null;

        try {
            // InstAL.g:634:2: ( LITERAL )
            // InstAL.g:634:4: LITERAL
            {
            root_0 = (CommonTree)adaptor.nil();

            LITERAL33=(Token)match(input,LITERAL,FOLLOW_LITERAL_in_event_name323); 
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
    // InstAL.g:636:1: event_type : ( 'exogenous' | 'inst' | EVENT_KEY_CREATE | 'violation' ) ;
    public final InstALParser.event_type_return event_type() throws RecognitionException {
        InstALParser.event_type_return retval = new InstALParser.event_type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set34=null;

        CommonTree set34_tree=null;

        try {
            // InstAL.g:637:2: ( ( 'exogenous' | 'inst' | EVENT_KEY_CREATE | 'violation' ) )
            // InstAL.g:637:4: ( 'exogenous' | 'inst' | EVENT_KEY_CREATE | 'violation' )
            {
            root_0 = (CommonTree)adaptor.nil();

            set34=(Token)input.LT(1);
            if ( input.LA(1)==EVENT_KEY_CREATE||(input.LA(1)>=35 && input.LA(1)<=37) ) {
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

    protected static class variable_constraints_scope {
        ArrayList<Constraint> list;
    }
    protected Stack variable_constraints_stack = new Stack();

    public static class variable_constraints_return extends ParserRuleReturnScope {
        public ArrayList<Constraint> constraints;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable_constraints"
    // InstAL.g:639:1: variable_constraints returns [ArrayList<Constraint> constraints] : variable_constraint ( ',' variable_constraint )* ;
    public final InstALParser.variable_constraints_return variable_constraints() throws RecognitionException {
        variable_constraints_stack.push(new variable_constraints_scope());
        InstALParser.variable_constraints_return retval = new InstALParser.variable_constraints_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal36=null;
        InstALParser.variable_constraint_return variable_constraint35 = null;

        InstALParser.variable_constraint_return variable_constraint37 = null;


        CommonTree char_literal36_tree=null;

         ((variable_constraints_scope)variable_constraints_stack.peek()).list = new ArrayList<Constraint>(); 
        try {
            // InstAL.g:642:2: ( variable_constraint ( ',' variable_constraint )* )
            // InstAL.g:642:4: variable_constraint ( ',' variable_constraint )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_variable_constraint_in_variable_constraints374);
            variable_constraint35=variable_constraint();

            state._fsp--;

            adaptor.addChild(root_0, variable_constraint35.getTree());
            // InstAL.g:642:24: ( ',' variable_constraint )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==38) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InstAL.g:642:26: ',' variable_constraint
            	    {
            	    char_literal36=(Token)match(input,38,FOLLOW_38_in_variable_constraints378); 
            	    char_literal36_tree = (CommonTree)adaptor.create(char_literal36);
            	    adaptor.addChild(root_0, char_literal36_tree);

            	    pushFollow(FOLLOW_variable_constraint_in_variable_constraints380);
            	    variable_constraint37=variable_constraint();

            	    state._fsp--;

            	    adaptor.addChild(root_0, variable_constraint37.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             retval.constraints = ((variable_constraints_scope)variable_constraints_stack.peek()).list; 

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
            variable_constraints_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "variable_constraints"

    public static class variable_constraint_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable_constraint"
    // InstAL.g:645:1: variable_constraint : x= variable_name op= operation y= variable_name ;
    public final InstALParser.variable_constraint_return variable_constraint() throws RecognitionException {
        InstALParser.variable_constraint_return retval = new InstALParser.variable_constraint_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        InstALParser.variable_name_return x = null;

        InstALParser.operation_return op = null;

        InstALParser.variable_name_return y = null;



        try {
            // InstAL.g:646:2: (x= variable_name op= operation y= variable_name )
            // InstAL.g:646:4: x= variable_name op= operation y= variable_name
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_variable_name_in_variable_constraint399);
            x=variable_name();

            state._fsp--;

            adaptor.addChild(root_0, x.getTree());
            pushFollow(FOLLOW_operation_in_variable_constraint403);
            op=operation();

            state._fsp--;

            adaptor.addChild(root_0, op.getTree());
            pushFollow(FOLLOW_variable_name_in_variable_constraint407);
            y=variable_name();

            state._fsp--;

            adaptor.addChild(root_0, y.getTree());
             ((variable_constraints_scope)variable_constraints_stack.peek()).list.add(new Constraint((x!=null?input.toString(x.start,x.stop):null), (op!=null?input.toString(op.start,op.stop):null), (y!=null?input.toString(y.start,y.stop):null))); 

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
    // InstAL.g:650:1: fluent_decl : ( noninertial_fluent_decl | standard_fluent_decl ) END ;
    public final InstALParser.fluent_decl_return fluent_decl() throws RecognitionException {
        InstALParser.fluent_decl_return retval = new InstALParser.fluent_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token END40=null;
        InstALParser.noninertial_fluent_decl_return noninertial_fluent_decl38 = null;

        InstALParser.standard_fluent_decl_return standard_fluent_decl39 = null;


        CommonTree END40_tree=null;

        try {
            // InstAL.g:651:2: ( ( noninertial_fluent_decl | standard_fluent_decl ) END )
            // InstAL.g:651:4: ( noninertial_fluent_decl | standard_fluent_decl ) END
            {
            root_0 = (CommonTree)adaptor.nil();

            // InstAL.g:651:4: ( noninertial_fluent_decl | standard_fluent_decl )
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
                    // InstAL.g:652:4: noninertial_fluent_decl
                    {
                    pushFollow(FOLLOW_noninertial_fluent_decl_in_fluent_decl427);
                    noninertial_fluent_decl38=noninertial_fluent_decl();

                    state._fsp--;

                    adaptor.addChild(root_0, noninertial_fluent_decl38.getTree());
                     _addFluent((noninertial_fluent_decl38!=null?noninertial_fluent_decl38.type:null), (noninertial_fluent_decl38!=null?noninertial_fluent_decl38.name:null),  (noninertial_fluent_decl38!=null?noninertial_fluent_decl38.args:null)); 

                    }
                    break;
                case 2 :
                    // InstAL.g:653:5: standard_fluent_decl
                    {
                    pushFollow(FOLLOW_standard_fluent_decl_in_fluent_decl435);
                    standard_fluent_decl39=standard_fluent_decl();

                    state._fsp--;

                    adaptor.addChild(root_0, standard_fluent_decl39.getTree());
                     _addFluent((standard_fluent_decl39!=null?standard_fluent_decl39.type:null),    (standard_fluent_decl39!=null?standard_fluent_decl39.name:null),     (standard_fluent_decl39!=null?standard_fluent_decl39.args:null)  ); 

                    }
                    break;

            }

            END40=(Token)match(input,END,FOLLOW_END_in_fluent_decl443); 
            END40_tree = (CommonTree)adaptor.create(END40);
            adaptor.addChild(root_0, END40_tree);


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
    // InstAL.g:657:1: noninertial_fluent_decl returns [String type, String name, ArrayList<String> args] : KEY_NONINERTIAL standard_fluent_decl ;
    public final InstALParser.noninertial_fluent_decl_return noninertial_fluent_decl() throws RecognitionException {
        InstALParser.noninertial_fluent_decl_return retval = new InstALParser.noninertial_fluent_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_NONINERTIAL41=null;
        InstALParser.standard_fluent_decl_return standard_fluent_decl42 = null;


        CommonTree KEY_NONINERTIAL41_tree=null;

        try {
            // InstAL.g:658:2: ( KEY_NONINERTIAL standard_fluent_decl )
            // InstAL.g:658:4: KEY_NONINERTIAL standard_fluent_decl
            {
            root_0 = (CommonTree)adaptor.nil();

            KEY_NONINERTIAL41=(Token)match(input,KEY_NONINERTIAL,FOLLOW_KEY_NONINERTIAL_in_noninertial_fluent_decl461); 
            KEY_NONINERTIAL41_tree = (CommonTree)adaptor.create(KEY_NONINERTIAL41);
            adaptor.addChild(root_0, KEY_NONINERTIAL41_tree);

            pushFollow(FOLLOW_standard_fluent_decl_in_noninertial_fluent_decl463);
            standard_fluent_decl42=standard_fluent_decl();

            state._fsp--;

            adaptor.addChild(root_0, standard_fluent_decl42.getTree());
             retval.type = "noninertial"; retval.name = (standard_fluent_decl42!=null?standard_fluent_decl42.name:null); retval.args = (standard_fluent_decl42!=null?standard_fluent_decl42.args:null); 

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
    // InstAL.g:661:1: standard_fluent_decl returns [String type, String name, ArrayList<String> args] : KEY_FLUENT fluent_name ( type_arguments )? ;
    public final InstALParser.standard_fluent_decl_return standard_fluent_decl() throws RecognitionException {
        InstALParser.standard_fluent_decl_return retval = new InstALParser.standard_fluent_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_FLUENT43=null;
        InstALParser.fluent_name_return fluent_name44 = null;

        InstALParser.type_arguments_return type_arguments45 = null;


        CommonTree KEY_FLUENT43_tree=null;

        try {
            // InstAL.g:662:2: ( KEY_FLUENT fluent_name ( type_arguments )? )
            // InstAL.g:662:4: KEY_FLUENT fluent_name ( type_arguments )?
            {
            root_0 = (CommonTree)adaptor.nil();

            KEY_FLUENT43=(Token)match(input,KEY_FLUENT,FOLLOW_KEY_FLUENT_in_standard_fluent_decl481); 
            KEY_FLUENT43_tree = (CommonTree)adaptor.create(KEY_FLUENT43);
            adaptor.addChild(root_0, KEY_FLUENT43_tree);

            pushFollow(FOLLOW_fluent_name_in_standard_fluent_decl483);
            fluent_name44=fluent_name();

            state._fsp--;

            adaptor.addChild(root_0, fluent_name44.getTree());
            // InstAL.g:662:27: ( type_arguments )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==LPAR) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InstAL.g:662:27: type_arguments
                    {
                    pushFollow(FOLLOW_type_arguments_in_standard_fluent_decl485);
                    type_arguments45=type_arguments();

                    state._fsp--;

                    adaptor.addChild(root_0, type_arguments45.getTree());

                    }
                    break;

            }

             retval.type = "inertial"; retval.name = (fluent_name44!=null?input.toString(fluent_name44.start,fluent_name44.stop):null); retval.args = (type_arguments45!=null?type_arguments45.args:null); 

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
    // InstAL.g:665:1: fluent_name : LITERAL ;
    public final InstALParser.fluent_name_return fluent_name() throws RecognitionException {
        InstALParser.fluent_name_return retval = new InstALParser.fluent_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LITERAL46=null;

        CommonTree LITERAL46_tree=null;

        try {
            // InstAL.g:666:2: ( LITERAL )
            // InstAL.g:666:4: LITERAL
            {
            root_0 = (CommonTree)adaptor.nil();

            LITERAL46=(Token)match(input,LITERAL,FOLLOW_LITERAL_in_fluent_name500); 
            LITERAL46_tree = (CommonTree)adaptor.create(LITERAL46);
            adaptor.addChild(root_0, LITERAL46_tree);


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
    // InstAL.g:670:1: generates_rule : event_varient KEY_GENERATES results= events_with_variables ( KEY_IF conditions= fluents_with_variables_with_negation )? END ;
    public final InstALParser.generates_rule_return generates_rule() throws RecognitionException {
        InstALParser.generates_rule_return retval = new InstALParser.generates_rule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_GENERATES48=null;
        Token KEY_IF49=null;
        Token END50=null;
        InstALParser.events_with_variables_return results = null;

        InstALParser.fluents_with_variables_with_negation_return conditions = null;

        InstALParser.event_varient_return event_varient47 = null;


        CommonTree KEY_GENERATES48_tree=null;
        CommonTree KEY_IF49_tree=null;
        CommonTree END50_tree=null;

        try {
            // InstAL.g:671:2: ( event_varient KEY_GENERATES results= events_with_variables ( KEY_IF conditions= fluents_with_variables_with_negation )? END )
            // InstAL.g:671:4: event_varient KEY_GENERATES results= events_with_variables ( KEY_IF conditions= fluents_with_variables_with_negation )? END
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_event_varient_in_generates_rule513);
            event_varient47=event_varient();

            state._fsp--;

            adaptor.addChild(root_0, event_varient47.getTree());
            KEY_GENERATES48=(Token)match(input,KEY_GENERATES,FOLLOW_KEY_GENERATES_in_generates_rule515); 
            KEY_GENERATES48_tree = (CommonTree)adaptor.create(KEY_GENERATES48);
            adaptor.addChild(root_0, KEY_GENERATES48_tree);

            pushFollow(FOLLOW_events_with_variables_in_generates_rule519);
            results=events_with_variables();

            state._fsp--;

            adaptor.addChild(root_0, results.getTree());
            // InstAL.g:671:62: ( KEY_IF conditions= fluents_with_variables_with_negation )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==KEY_IF) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InstAL.g:671:64: KEY_IF conditions= fluents_with_variables_with_negation
                    {
                    KEY_IF49=(Token)match(input,KEY_IF,FOLLOW_KEY_IF_in_generates_rule523); 
                    KEY_IF49_tree = (CommonTree)adaptor.create(KEY_IF49);
                    adaptor.addChild(root_0, KEY_IF49_tree);

                    pushFollow(FOLLOW_fluents_with_variables_with_negation_in_generates_rule527);
                    conditions=fluents_with_variables_with_negation();

                    state._fsp--;

                    adaptor.addChild(root_0, conditions.getTree());

                    }
                    break;

            }

            END50=(Token)match(input,END,FOLLOW_END_in_generates_rule532); 
            END50_tree = (CommonTree)adaptor.create(END50);
            adaptor.addChild(root_0, END50_tree);

             _addGeneratesRule((event_varient47!=null?event_varient47.name:null), (event_varient47!=null?event_varient47.args:null), (results!=null?results.events:null), (conditions!=null?conditions.fluents:null)); 

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
    // InstAL.g:674:1: events_with_variables returns [ArrayList<EventWithVariables> events] : event_with_variables ( ',' event_with_variables )* ;
    public final InstALParser.events_with_variables_return events_with_variables() throws RecognitionException {
        events_with_variables_stack.push(new events_with_variables_scope());
        InstALParser.events_with_variables_return retval = new InstALParser.events_with_variables_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal52=null;
        InstALParser.event_with_variables_return event_with_variables51 = null;

        InstALParser.event_with_variables_return event_with_variables53 = null;


        CommonTree char_literal52_tree=null;

         ((events_with_variables_scope)events_with_variables_stack.peek()).list = new ArrayList<EventWithVariables>(); 
        try {
            // InstAL.g:677:2: ( event_with_variables ( ',' event_with_variables )* )
            // InstAL.g:677:4: event_with_variables ( ',' event_with_variables )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_event_with_variables_in_events_with_variables562);
            event_with_variables51=event_with_variables();

            state._fsp--;

            adaptor.addChild(root_0, event_with_variables51.getTree());
            // InstAL.g:677:25: ( ',' event_with_variables )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==38) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InstAL.g:677:27: ',' event_with_variables
            	    {
            	    char_literal52=(Token)match(input,38,FOLLOW_38_in_events_with_variables566); 
            	    char_literal52_tree = (CommonTree)adaptor.create(char_literal52);
            	    adaptor.addChild(root_0, char_literal52_tree);

            	    pushFollow(FOLLOW_event_with_variables_in_events_with_variables568);
            	    event_with_variables53=event_with_variables();

            	    state._fsp--;

            	    adaptor.addChild(root_0, event_with_variables53.getTree());

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
    // InstAL.g:680:1: event_with_variables : event_varient ;
    public final InstALParser.event_with_variables_return event_with_variables() throws RecognitionException {
        InstALParser.event_with_variables_return retval = new InstALParser.event_with_variables_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        InstALParser.event_varient_return event_varient54 = null;



        try {
            // InstAL.g:681:2: ( event_varient )
            // InstAL.g:681:4: event_varient
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_event_varient_in_event_with_variables585);
            event_varient54=event_varient();

            state._fsp--;

            adaptor.addChild(root_0, event_varient54.getTree());
             ((events_with_variables_scope)events_with_variables_stack.peek()).list.add(new EventWithVariables((event_varient54!=null?event_varient54.name:null), (event_varient54!=null?event_varient54.args:null))); 

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
    // InstAL.g:684:1: fluents_with_variables returns [ArrayList<FluentCondition> fluents] : fluent_with_variables ( ',' fluent_with_variables )* ;
    public final InstALParser.fluents_with_variables_return fluents_with_variables() throws RecognitionException {
        fluents_with_variables_stack.push(new fluents_with_variables_scope());
        InstALParser.fluents_with_variables_return retval = new InstALParser.fluents_with_variables_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal56=null;
        InstALParser.fluent_with_variables_return fluent_with_variables55 = null;

        InstALParser.fluent_with_variables_return fluent_with_variables57 = null;


        CommonTree char_literal56_tree=null;

         ((fluents_with_variables_scope)fluents_with_variables_stack.peek()).list = new ArrayList<FluentCondition>(); 
        try {
            // InstAL.g:687:2: ( fluent_with_variables ( ',' fluent_with_variables )* )
            // InstAL.g:687:4: fluent_with_variables ( ',' fluent_with_variables )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_fluent_with_variables_in_fluents_with_variables613);
            fluent_with_variables55=fluent_with_variables();

            state._fsp--;

            adaptor.addChild(root_0, fluent_with_variables55.getTree());
            // InstAL.g:687:26: ( ',' fluent_with_variables )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==38) ) {
                    int LA11_2 = input.LA(2);

                    if ( (LA11_2==LITERAL||(LA11_2>=KEY_POW && LA11_2<=KEY_PERM)) ) {
                        alt11=1;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // InstAL.g:687:28: ',' fluent_with_variables
            	    {
            	    char_literal56=(Token)match(input,38,FOLLOW_38_in_fluents_with_variables617); 
            	    char_literal56_tree = (CommonTree)adaptor.create(char_literal56);
            	    adaptor.addChild(root_0, char_literal56_tree);

            	    pushFollow(FOLLOW_fluent_with_variables_in_fluents_with_variables619);
            	    fluent_with_variables57=fluent_with_variables();

            	    state._fsp--;

            	    adaptor.addChild(root_0, fluent_with_variables57.getTree());

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
    // InstAL.g:690:1: fluent_with_variables : fluent_varient ;
    public final InstALParser.fluent_with_variables_return fluent_with_variables() throws RecognitionException {
        InstALParser.fluent_with_variables_return retval = new InstALParser.fluent_with_variables_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        InstALParser.fluent_varient_return fluent_varient58 = null;



        try {
            // InstAL.g:691:2: ( fluent_varient )
            // InstAL.g:691:4: fluent_varient
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_fluent_varient_in_fluent_with_variables637);
            fluent_varient58=fluent_varient();

            state._fsp--;

            adaptor.addChild(root_0, fluent_varient58.getTree());
             ((fluents_with_variables_scope)fluents_with_variables_stack.peek()).list.add(new FluentCondition(false, (fluent_varient58!=null?fluent_varient58.name:null), (fluent_varient58!=null?fluent_varient58.args:null), (fluent_varient58!=null?fluent_varient58.modifier:null))); 

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
    // InstAL.g:694:1: fluents_with_variables_with_negation returns [ArrayList<FluentCondition> fluents] : fluent_with_variables_with_negation ( ',' fluent_with_variables_with_negation )* ;
    public final InstALParser.fluents_with_variables_with_negation_return fluents_with_variables_with_negation() throws RecognitionException {
        fluents_with_variables_with_negation_stack.push(new fluents_with_variables_with_negation_scope());
        InstALParser.fluents_with_variables_with_negation_return retval = new InstALParser.fluents_with_variables_with_negation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal60=null;
        InstALParser.fluent_with_variables_with_negation_return fluent_with_variables_with_negation59 = null;

        InstALParser.fluent_with_variables_with_negation_return fluent_with_variables_with_negation61 = null;


        CommonTree char_literal60_tree=null;

         ((fluents_with_variables_with_negation_scope)fluents_with_variables_with_negation_stack.peek()).list = new ArrayList<FluentCondition>(); 
        try {
            // InstAL.g:697:2: ( fluent_with_variables_with_negation ( ',' fluent_with_variables_with_negation )* )
            // InstAL.g:697:4: fluent_with_variables_with_negation ( ',' fluent_with_variables_with_negation )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_fluent_with_variables_with_negation_in_fluents_with_variables_with_negation665);
            fluent_with_variables_with_negation59=fluent_with_variables_with_negation();

            state._fsp--;

            adaptor.addChild(root_0, fluent_with_variables_with_negation59.getTree());
            // InstAL.g:697:40: ( ',' fluent_with_variables_with_negation )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==38) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InstAL.g:697:42: ',' fluent_with_variables_with_negation
            	    {
            	    char_literal60=(Token)match(input,38,FOLLOW_38_in_fluents_with_variables_with_negation669); 
            	    char_literal60_tree = (CommonTree)adaptor.create(char_literal60);
            	    adaptor.addChild(root_0, char_literal60_tree);

            	    pushFollow(FOLLOW_fluent_with_variables_with_negation_in_fluents_with_variables_with_negation671);
            	    fluent_with_variables_with_negation61=fluent_with_variables_with_negation();

            	    state._fsp--;

            	    adaptor.addChild(root_0, fluent_with_variables_with_negation61.getTree());

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
    // InstAL.g:700:1: fluent_with_variables_with_negation : ( KEY_NOT fluent_varient | fluent_varient );
    public final InstALParser.fluent_with_variables_with_negation_return fluent_with_variables_with_negation() throws RecognitionException {
        InstALParser.fluent_with_variables_with_negation_return retval = new InstALParser.fluent_with_variables_with_negation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_NOT62=null;
        InstALParser.fluent_varient_return fluent_varient63 = null;

        InstALParser.fluent_varient_return fluent_varient64 = null;


        CommonTree KEY_NOT62_tree=null;

        try {
            // InstAL.g:701:2: ( KEY_NOT fluent_varient | fluent_varient )
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
                    // InstAL.g:701:4: KEY_NOT fluent_varient
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    KEY_NOT62=(Token)match(input,KEY_NOT,FOLLOW_KEY_NOT_in_fluent_with_variables_with_negation690); 
                    KEY_NOT62_tree = (CommonTree)adaptor.create(KEY_NOT62);
                    adaptor.addChild(root_0, KEY_NOT62_tree);

                    pushFollow(FOLLOW_fluent_varient_in_fluent_with_variables_with_negation692);
                    fluent_varient63=fluent_varient();

                    state._fsp--;

                    adaptor.addChild(root_0, fluent_varient63.getTree());
                     ((fluents_with_variables_with_negation_scope)fluents_with_variables_with_negation_stack.peek()).list.add(new FluentCondition(false, (fluent_varient63!=null?fluent_varient63.name:null), (fluent_varient63!=null?fluent_varient63.args:null))); 

                    }
                    break;
                case 2 :
                    // InstAL.g:702:4: fluent_varient
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_fluent_varient_in_fluent_with_variables_with_negation699);
                    fluent_varient64=fluent_varient();

                    state._fsp--;

                    adaptor.addChild(root_0, fluent_varient64.getTree());
                     ((fluents_with_variables_with_negation_scope)fluents_with_variables_with_negation_stack.peek()).list.add(new FluentCondition(true,  (fluent_varient64!=null?fluent_varient64.name:null), (fluent_varient64!=null?fluent_varient64.args:null))); 

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
    // InstAL.g:706:1: event_varient returns [String name, ArrayList<String> args] : ( ( 'viol' LPAR event_name ( variable_arguments )? RPAR ) | ( event_name ( variable_arguments )? ) );
    public final InstALParser.event_varient_return event_varient() throws RecognitionException {
        InstALParser.event_varient_return retval = new InstALParser.event_varient_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal65=null;
        Token LPAR66=null;
        Token RPAR69=null;
        InstALParser.event_name_return event_name67 = null;

        InstALParser.variable_arguments_return variable_arguments68 = null;

        InstALParser.event_name_return event_name70 = null;

        InstALParser.variable_arguments_return variable_arguments71 = null;


        CommonTree string_literal65_tree=null;
        CommonTree LPAR66_tree=null;
        CommonTree RPAR69_tree=null;

        try {
            // InstAL.g:707:2: ( ( 'viol' LPAR event_name ( variable_arguments )? RPAR ) | ( event_name ( variable_arguments )? ) )
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
                    // InstAL.g:707:4: ( 'viol' LPAR event_name ( variable_arguments )? RPAR )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // InstAL.g:707:4: ( 'viol' LPAR event_name ( variable_arguments )? RPAR )
                    // InstAL.g:707:6: 'viol' LPAR event_name ( variable_arguments )? RPAR
                    {
                    string_literal65=(Token)match(input,39,FOLLOW_39_in_event_varient722); 
                    string_literal65_tree = (CommonTree)adaptor.create(string_literal65);
                    adaptor.addChild(root_0, string_literal65_tree);

                    LPAR66=(Token)match(input,LPAR,FOLLOW_LPAR_in_event_varient724); 
                    LPAR66_tree = (CommonTree)adaptor.create(LPAR66);
                    adaptor.addChild(root_0, LPAR66_tree);

                    pushFollow(FOLLOW_event_name_in_event_varient726);
                    event_name67=event_name();

                    state._fsp--;

                    adaptor.addChild(root_0, event_name67.getTree());
                    // InstAL.g:707:30: ( variable_arguments )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==LPAR) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InstAL.g:707:30: variable_arguments
                            {
                            pushFollow(FOLLOW_variable_arguments_in_event_varient729);
                            variable_arguments68=variable_arguments();

                            state._fsp--;

                            adaptor.addChild(root_0, variable_arguments68.getTree());

                            }
                            break;

                    }

                    RPAR69=(Token)match(input,RPAR,FOLLOW_RPAR_in_event_varient732); 
                    RPAR69_tree = (CommonTree)adaptor.create(RPAR69);
                    adaptor.addChild(root_0, RPAR69_tree);


                    }

                     retval.name = (event_name67!=null?input.toString(event_name67.start,event_name67.stop):null); retval.args = (variable_arguments68!=null?variable_arguments68.args:null); 

                    }
                    break;
                case 2 :
                    // InstAL.g:708:5: ( event_name ( variable_arguments )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // InstAL.g:708:5: ( event_name ( variable_arguments )? )
                    // InstAL.g:708:7: event_name ( variable_arguments )?
                    {
                    pushFollow(FOLLOW_event_name_in_event_varient744);
                    event_name70=event_name();

                    state._fsp--;

                    adaptor.addChild(root_0, event_name70.getTree());
                    // InstAL.g:708:19: ( variable_arguments )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==LPAR) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // InstAL.g:708:19: variable_arguments
                            {
                            pushFollow(FOLLOW_variable_arguments_in_event_varient747);
                            variable_arguments71=variable_arguments();

                            state._fsp--;

                            adaptor.addChild(root_0, variable_arguments71.getTree());

                            }
                            break;

                    }


                    }

                     retval.name = (event_name70!=null?input.toString(event_name70.start,event_name70.stop):null); retval.args = (variable_arguments71!=null?variable_arguments71.args:null); 

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
        public String modifier;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fluent_varient"
    // InstAL.g:711:1: fluent_varient returns [String type, String name, ArrayList<String> args, String modifier] : ( ( KEY_POW LPAR fluent_name ( variable_arguments )? RPAR ) | ( KEY_PERM LPAR fluent_name ( variable_arguments )? RPAR ) | ( fluent_name ( variable_arguments )? ) );
    public final InstALParser.fluent_varient_return fluent_varient() throws RecognitionException {
        InstALParser.fluent_varient_return retval = new InstALParser.fluent_varient_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_POW72=null;
        Token LPAR73=null;
        Token RPAR76=null;
        Token KEY_PERM77=null;
        Token LPAR78=null;
        Token RPAR81=null;
        InstALParser.fluent_name_return fluent_name74 = null;

        InstALParser.variable_arguments_return variable_arguments75 = null;

        InstALParser.fluent_name_return fluent_name79 = null;

        InstALParser.variable_arguments_return variable_arguments80 = null;

        InstALParser.fluent_name_return fluent_name82 = null;

        InstALParser.variable_arguments_return variable_arguments83 = null;


        CommonTree KEY_POW72_tree=null;
        CommonTree LPAR73_tree=null;
        CommonTree RPAR76_tree=null;
        CommonTree KEY_PERM77_tree=null;
        CommonTree LPAR78_tree=null;
        CommonTree RPAR81_tree=null;

        try {
            // InstAL.g:712:2: ( ( KEY_POW LPAR fluent_name ( variable_arguments )? RPAR ) | ( KEY_PERM LPAR fluent_name ( variable_arguments )? RPAR ) | ( fluent_name ( variable_arguments )? ) )
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
                    // InstAL.g:712:4: ( KEY_POW LPAR fluent_name ( variable_arguments )? RPAR )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // InstAL.g:712:4: ( KEY_POW LPAR fluent_name ( variable_arguments )? RPAR )
                    // InstAL.g:712:6: KEY_POW LPAR fluent_name ( variable_arguments )? RPAR
                    {
                    KEY_POW72=(Token)match(input,KEY_POW,FOLLOW_KEY_POW_in_fluent_varient772); 
                    KEY_POW72_tree = (CommonTree)adaptor.create(KEY_POW72);
                    adaptor.addChild(root_0, KEY_POW72_tree);

                    LPAR73=(Token)match(input,LPAR,FOLLOW_LPAR_in_fluent_varient774); 
                    LPAR73_tree = (CommonTree)adaptor.create(LPAR73);
                    adaptor.addChild(root_0, LPAR73_tree);

                    pushFollow(FOLLOW_fluent_name_in_fluent_varient776);
                    fluent_name74=fluent_name();

                    state._fsp--;

                    adaptor.addChild(root_0, fluent_name74.getTree());
                    // InstAL.g:712:31: ( variable_arguments )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==LPAR) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // InstAL.g:712:31: variable_arguments
                            {
                            pushFollow(FOLLOW_variable_arguments_in_fluent_varient778);
                            variable_arguments75=variable_arguments();

                            state._fsp--;

                            adaptor.addChild(root_0, variable_arguments75.getTree());

                            }
                            break;

                    }

                    RPAR76=(Token)match(input,RPAR,FOLLOW_RPAR_in_fluent_varient781); 
                    RPAR76_tree = (CommonTree)adaptor.create(RPAR76);
                    adaptor.addChild(root_0, RPAR76_tree);


                    }

                     retval.name = (fluent_name74!=null?input.toString(fluent_name74.start,fluent_name74.stop):null); retval.args = (variable_arguments75!=null?variable_arguments75.args:null); retval.modifier = "pow";  

                    }
                    break;
                case 2 :
                    // InstAL.g:713:5: ( KEY_PERM LPAR fluent_name ( variable_arguments )? RPAR )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // InstAL.g:713:5: ( KEY_PERM LPAR fluent_name ( variable_arguments )? RPAR )
                    // InstAL.g:713:7: KEY_PERM LPAR fluent_name ( variable_arguments )? RPAR
                    {
                    KEY_PERM77=(Token)match(input,KEY_PERM,FOLLOW_KEY_PERM_in_fluent_varient794); 
                    KEY_PERM77_tree = (CommonTree)adaptor.create(KEY_PERM77);
                    adaptor.addChild(root_0, KEY_PERM77_tree);

                    LPAR78=(Token)match(input,LPAR,FOLLOW_LPAR_in_fluent_varient796); 
                    LPAR78_tree = (CommonTree)adaptor.create(LPAR78);
                    adaptor.addChild(root_0, LPAR78_tree);

                    pushFollow(FOLLOW_fluent_name_in_fluent_varient798);
                    fluent_name79=fluent_name();

                    state._fsp--;

                    adaptor.addChild(root_0, fluent_name79.getTree());
                    // InstAL.g:713:33: ( variable_arguments )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==LPAR) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // InstAL.g:713:33: variable_arguments
                            {
                            pushFollow(FOLLOW_variable_arguments_in_fluent_varient800);
                            variable_arguments80=variable_arguments();

                            state._fsp--;

                            adaptor.addChild(root_0, variable_arguments80.getTree());

                            }
                            break;

                    }

                    RPAR81=(Token)match(input,RPAR,FOLLOW_RPAR_in_fluent_varient803); 
                    RPAR81_tree = (CommonTree)adaptor.create(RPAR81);
                    adaptor.addChild(root_0, RPAR81_tree);


                    }

                     retval.name = (fluent_name79!=null?input.toString(fluent_name79.start,fluent_name79.stop):null); retval.args = (variable_arguments80!=null?variable_arguments80.args:null); retval.modifier = "perm"; 

                    }
                    break;
                case 3 :
                    // InstAL.g:714:4: ( fluent_name ( variable_arguments )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // InstAL.g:714:4: ( fluent_name ( variable_arguments )? )
                    // InstAL.g:714:6: fluent_name ( variable_arguments )?
                    {
                    pushFollow(FOLLOW_fluent_name_in_fluent_varient815);
                    fluent_name82=fluent_name();

                    state._fsp--;

                    adaptor.addChild(root_0, fluent_name82.getTree());
                    // InstAL.g:714:18: ( variable_arguments )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==LPAR) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // InstAL.g:714:18: variable_arguments
                            {
                            pushFollow(FOLLOW_variable_arguments_in_fluent_varient817);
                            variable_arguments83=variable_arguments();

                            state._fsp--;

                            adaptor.addChild(root_0, variable_arguments83.getTree());

                            }
                            break;

                    }


                    }

                     retval.name = (fluent_name82!=null?input.toString(fluent_name82.start,fluent_name82.stop):null); retval.args = (variable_arguments83!=null?variable_arguments83.args:null); retval.modifier = "";     

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
    // InstAL.g:718:1: consequence_rule : ( initiates_rule | terminates_rule ) END ;
    public final InstALParser.consequence_rule_return consequence_rule() throws RecognitionException {
        InstALParser.consequence_rule_return retval = new InstALParser.consequence_rule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token END86=null;
        InstALParser.initiates_rule_return initiates_rule84 = null;

        InstALParser.terminates_rule_return terminates_rule85 = null;


        CommonTree END86_tree=null;

        try {
            // InstAL.g:719:2: ( ( initiates_rule | terminates_rule ) END )
            // InstAL.g:719:4: ( initiates_rule | terminates_rule ) END
            {
            root_0 = (CommonTree)adaptor.nil();

            // InstAL.g:719:4: ( initiates_rule | terminates_rule )
            int alt21=2;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // InstAL.g:719:6: initiates_rule
                    {
                    pushFollow(FOLLOW_initiates_rule_in_consequence_rule840);
                    initiates_rule84=initiates_rule();

                    state._fsp--;

                    adaptor.addChild(root_0, initiates_rule84.getTree());

                    }
                    break;
                case 2 :
                    // InstAL.g:719:23: terminates_rule
                    {
                    pushFollow(FOLLOW_terminates_rule_in_consequence_rule844);
                    terminates_rule85=terminates_rule();

                    state._fsp--;

                    adaptor.addChild(root_0, terminates_rule85.getTree());

                    }
                    break;

            }

            END86=(Token)match(input,END,FOLLOW_END_in_consequence_rule848); 
            END86_tree = (CommonTree)adaptor.create(END86);
            adaptor.addChild(root_0, END86_tree);


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
    // InstAL.g:721:1: initiates_rule : event_varient KEY_INITIATES results= fluents_with_variables ( KEY_IF conditions= fluents_with_variables )? ;
    public final InstALParser.initiates_rule_return initiates_rule() throws RecognitionException {
        InstALParser.initiates_rule_return retval = new InstALParser.initiates_rule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_INITIATES88=null;
        Token KEY_IF89=null;
        InstALParser.fluents_with_variables_return results = null;

        InstALParser.fluents_with_variables_return conditions = null;

        InstALParser.event_varient_return event_varient87 = null;


        CommonTree KEY_INITIATES88_tree=null;
        CommonTree KEY_IF89_tree=null;

        try {
            // InstAL.g:722:2: ( event_varient KEY_INITIATES results= fluents_with_variables ( KEY_IF conditions= fluents_with_variables )? )
            // InstAL.g:722:4: event_varient KEY_INITIATES results= fluents_with_variables ( KEY_IF conditions= fluents_with_variables )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_event_varient_in_initiates_rule858);
            event_varient87=event_varient();

            state._fsp--;

            adaptor.addChild(root_0, event_varient87.getTree());
            KEY_INITIATES88=(Token)match(input,KEY_INITIATES,FOLLOW_KEY_INITIATES_in_initiates_rule860); 
            KEY_INITIATES88_tree = (CommonTree)adaptor.create(KEY_INITIATES88);
            adaptor.addChild(root_0, KEY_INITIATES88_tree);

            pushFollow(FOLLOW_fluents_with_variables_in_initiates_rule864);
            results=fluents_with_variables();

            state._fsp--;

            adaptor.addChild(root_0, results.getTree());
            // InstAL.g:722:63: ( KEY_IF conditions= fluents_with_variables )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==KEY_IF) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InstAL.g:722:65: KEY_IF conditions= fluents_with_variables
                    {
                    KEY_IF89=(Token)match(input,KEY_IF,FOLLOW_KEY_IF_in_initiates_rule868); 
                    KEY_IF89_tree = (CommonTree)adaptor.create(KEY_IF89);
                    adaptor.addChild(root_0, KEY_IF89_tree);

                    pushFollow(FOLLOW_fluents_with_variables_in_initiates_rule872);
                    conditions=fluents_with_variables();

                    state._fsp--;

                    adaptor.addChild(root_0, conditions.getTree());

                    }
                    break;

            }

             _addInitiatesRule((event_varient87!=null?event_varient87.name:null), (event_varient87!=null?event_varient87.args:null), (results!=null?results.fluents:null), (conditions!=null?conditions.fluents:null)); 

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
    // InstAL.g:725:1: terminates_rule : event_varient KEY_TERMINATES results= fluents_with_variables ( KEY_IF conditions= fluents_with_variables )? ;
    public final InstALParser.terminates_rule_return terminates_rule() throws RecognitionException {
        InstALParser.terminates_rule_return retval = new InstALParser.terminates_rule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_TERMINATES91=null;
        Token KEY_IF92=null;
        InstALParser.fluents_with_variables_return results = null;

        InstALParser.fluents_with_variables_return conditions = null;

        InstALParser.event_varient_return event_varient90 = null;


        CommonTree KEY_TERMINATES91_tree=null;
        CommonTree KEY_IF92_tree=null;

        try {
            // InstAL.g:726:2: ( event_varient KEY_TERMINATES results= fluents_with_variables ( KEY_IF conditions= fluents_with_variables )? )
            // InstAL.g:726:4: event_varient KEY_TERMINATES results= fluents_with_variables ( KEY_IF conditions= fluents_with_variables )?
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_event_varient_in_terminates_rule889);
            event_varient90=event_varient();

            state._fsp--;

            adaptor.addChild(root_0, event_varient90.getTree());
            KEY_TERMINATES91=(Token)match(input,KEY_TERMINATES,FOLLOW_KEY_TERMINATES_in_terminates_rule891); 
            KEY_TERMINATES91_tree = (CommonTree)adaptor.create(KEY_TERMINATES91);
            adaptor.addChild(root_0, KEY_TERMINATES91_tree);

            pushFollow(FOLLOW_fluents_with_variables_in_terminates_rule895);
            results=fluents_with_variables();

            state._fsp--;

            adaptor.addChild(root_0, results.getTree());
            // InstAL.g:726:64: ( KEY_IF conditions= fluents_with_variables )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==KEY_IF) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InstAL.g:726:66: KEY_IF conditions= fluents_with_variables
                    {
                    KEY_IF92=(Token)match(input,KEY_IF,FOLLOW_KEY_IF_in_terminates_rule899); 
                    KEY_IF92_tree = (CommonTree)adaptor.create(KEY_IF92);
                    adaptor.addChild(root_0, KEY_IF92_tree);

                    pushFollow(FOLLOW_fluents_with_variables_in_terminates_rule903);
                    conditions=fluents_with_variables();

                    state._fsp--;

                    adaptor.addChild(root_0, conditions.getTree());

                    }
                    break;

            }

             _addTerminatesRule((event_varient90!=null?event_varient90.name:null), (event_varient90!=null?event_varient90.args:null), (results!=null?results.fluents:null), (conditions!=null?conditions.fluents:null)); 

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
    // InstAL.g:730:1: initially_decl : KEY_INITIALLY ( initially_component )+ END ;
    public final InstALParser.initially_decl_return initially_decl() throws RecognitionException {
        InstALParser.initially_decl_return retval = new InstALParser.initially_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_INITIALLY93=null;
        Token END95=null;
        InstALParser.initially_component_return initially_component94 = null;


        CommonTree KEY_INITIALLY93_tree=null;
        CommonTree END95_tree=null;

        try {
            // InstAL.g:731:2: ( KEY_INITIALLY ( initially_component )+ END )
            // InstAL.g:731:4: KEY_INITIALLY ( initially_component )+ END
            {
            root_0 = (CommonTree)adaptor.nil();

            KEY_INITIALLY93=(Token)match(input,KEY_INITIALLY,FOLLOW_KEY_INITIALLY_in_initially_decl922); 
            KEY_INITIALLY93_tree = (CommonTree)adaptor.create(KEY_INITIALLY93);
            adaptor.addChild(root_0, KEY_INITIALLY93_tree);

            // InstAL.g:731:18: ( initially_component )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==LITERAL||(LA24_0>=KEY_POW && LA24_0<=KEY_PERM)||LA24_0==KEY_OBLIGATION||LA24_0==38) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InstAL.g:731:18: initially_component
            	    {
            	    pushFollow(FOLLOW_initially_component_in_initially_decl924);
            	    initially_component94=initially_component();

            	    state._fsp--;

            	    adaptor.addChild(root_0, initially_component94.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

            END95=(Token)match(input,END,FOLLOW_END_in_initially_decl927); 
            END95_tree = (CommonTree)adaptor.create(END95);
            adaptor.addChild(root_0, END95_tree);


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

    public static class initially_component_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "initially_component"
    // InstAL.g:734:1: initially_component : (f= fluents_with_variables | ( ',' )? o= obligation_statement ( ',' )? );
    public final InstALParser.initially_component_return initially_component() throws RecognitionException {
        InstALParser.initially_component_return retval = new InstALParser.initially_component_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal96=null;
        Token char_literal97=null;
        InstALParser.fluents_with_variables_return f = null;

        InstALParser.obligation_statement_return o = null;


        CommonTree char_literal96_tree=null;
        CommonTree char_literal97_tree=null;

        try {
            // InstAL.g:735:2: (f= fluents_with_variables | ( ',' )? o= obligation_statement ( ',' )? )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==LITERAL||(LA27_0>=KEY_POW && LA27_0<=KEY_PERM)) ) {
                alt27=1;
            }
            else if ( (LA27_0==KEY_OBLIGATION||LA27_0==38) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InstAL.g:735:4: f= fluents_with_variables
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_fluents_with_variables_in_initially_component941);
                    f=fluents_with_variables();

                    state._fsp--;

                    adaptor.addChild(root_0, f.getTree());
                     _addInitiallyFluents((f!=null?f.fluents:null)); 

                    }
                    break;
                case 2 :
                    // InstAL.g:736:4: ( ',' )? o= obligation_statement ( ',' )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // InstAL.g:736:4: ( ',' )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==38) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // InstAL.g:736:4: ','
                            {
                            char_literal96=(Token)match(input,38,FOLLOW_38_in_initially_component949); 
                            char_literal96_tree = (CommonTree)adaptor.create(char_literal96);
                            adaptor.addChild(root_0, char_literal96_tree);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_obligation_statement_in_initially_component954);
                    o=obligation_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, o.getTree());
                    // InstAL.g:736:32: ( ',' )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==38) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // InstAL.g:736:32: ','
                            {
                            char_literal97=(Token)match(input,38,FOLLOW_38_in_initially_component956); 
                            char_literal97_tree = (CommonTree)adaptor.create(char_literal97);
                            adaptor.addChild(root_0, char_literal97_tree);


                            }
                            break;

                    }

                     _addObligation(o.act_name, o.act_args, o.before_name, o.before_args, o.otherwise_name, o.otherwise_args); 

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
    // $ANTLR end "initially_component"

    public static class obligation_decl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "obligation_decl"
    // InstAL.g:740:1: obligation_decl : o= obligation_statement END ;
    public final InstALParser.obligation_decl_return obligation_decl() throws RecognitionException {
        InstALParser.obligation_decl_return retval = new InstALParser.obligation_decl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token END98=null;
        InstALParser.obligation_statement_return o = null;


        CommonTree END98_tree=null;

        try {
            // InstAL.g:741:2: (o= obligation_statement END )
            // InstAL.g:741:4: o= obligation_statement END
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_obligation_statement_in_obligation_decl975);
            o=obligation_statement();

            state._fsp--;

            adaptor.addChild(root_0, o.getTree());
            END98=(Token)match(input,END,FOLLOW_END_in_obligation_decl977); 
            END98_tree = (CommonTree)adaptor.create(END98);
            adaptor.addChild(root_0, END98_tree);

             _addObligation(o.act_name, o.act_args, o.before_name, o.before_args, o.otherwise_name, o.otherwise_args); 

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

    public static class obligation_statement_return extends ParserRuleReturnScope {
        public String act_name;
        public ArrayList<String> act_args;
        public String before_name;
        public ArrayList<String> before_args;
        public String otherwise_name;
        public ArrayList<String> otherwise_args;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "obligation_statement"
    // InstAL.g:744:1: obligation_statement returns [String act_name, ArrayList<String> act_args, String before_name, ArrayList<String> before_args, String otherwise_name, ArrayList<String> otherwise_args] : KEY_OBLIGATION LPAR act= event_varient ',' before= event_varient ',' otherwise= event_varient RPAR ;
    public final InstALParser.obligation_statement_return obligation_statement() throws RecognitionException {
        InstALParser.obligation_statement_return retval = new InstALParser.obligation_statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token KEY_OBLIGATION99=null;
        Token LPAR100=null;
        Token char_literal101=null;
        Token char_literal102=null;
        Token RPAR103=null;
        InstALParser.event_varient_return act = null;

        InstALParser.event_varient_return before = null;

        InstALParser.event_varient_return otherwise = null;


        CommonTree KEY_OBLIGATION99_tree=null;
        CommonTree LPAR100_tree=null;
        CommonTree char_literal101_tree=null;
        CommonTree char_literal102_tree=null;
        CommonTree RPAR103_tree=null;

        try {
            // InstAL.g:745:2: ( KEY_OBLIGATION LPAR act= event_varient ',' before= event_varient ',' otherwise= event_varient RPAR )
            // InstAL.g:745:4: KEY_OBLIGATION LPAR act= event_varient ',' before= event_varient ',' otherwise= event_varient RPAR
            {
            root_0 = (CommonTree)adaptor.nil();

            KEY_OBLIGATION99=(Token)match(input,KEY_OBLIGATION,FOLLOW_KEY_OBLIGATION_in_obligation_statement995); 
            KEY_OBLIGATION99_tree = (CommonTree)adaptor.create(KEY_OBLIGATION99);
            adaptor.addChild(root_0, KEY_OBLIGATION99_tree);

            LPAR100=(Token)match(input,LPAR,FOLLOW_LPAR_in_obligation_statement997); 
            LPAR100_tree = (CommonTree)adaptor.create(LPAR100);
            adaptor.addChild(root_0, LPAR100_tree);

            pushFollow(FOLLOW_event_varient_in_obligation_statement1001);
            act=event_varient();

            state._fsp--;

            adaptor.addChild(root_0, act.getTree());
            char_literal101=(Token)match(input,38,FOLLOW_38_in_obligation_statement1003); 
            char_literal101_tree = (CommonTree)adaptor.create(char_literal101);
            adaptor.addChild(root_0, char_literal101_tree);

            pushFollow(FOLLOW_event_varient_in_obligation_statement1007);
            before=event_varient();

            state._fsp--;

            adaptor.addChild(root_0, before.getTree());
            char_literal102=(Token)match(input,38,FOLLOW_38_in_obligation_statement1009); 
            char_literal102_tree = (CommonTree)adaptor.create(char_literal102);
            adaptor.addChild(root_0, char_literal102_tree);

            pushFollow(FOLLOW_event_varient_in_obligation_statement1013);
            otherwise=event_varient();

            state._fsp--;

            adaptor.addChild(root_0, otherwise.getTree());
            RPAR103=(Token)match(input,RPAR,FOLLOW_RPAR_in_obligation_statement1015); 
            RPAR103_tree = (CommonTree)adaptor.create(RPAR103);
            adaptor.addChild(root_0, RPAR103_tree);


            			retval.act_name = (act!=null?act.name:null);
            			retval.act_args = (act!=null?act.args:null);
            			retval.before_name = (before!=null?before.name:null);
            			retval.before_args = (before!=null?before.args:null);
            			retval.otherwise_name = (otherwise!=null?otherwise.name:null);
            			retval.otherwise_args = (otherwise!=null?otherwise.args:null);
            		

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
    // $ANTLR end "obligation_statement"

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
    // InstAL.g:756:1: type_arguments returns [ ArrayList<String> args ] : LPAR ( type_argument ( ',' type_argument )* )? RPAR ;
    public final InstALParser.type_arguments_return type_arguments() throws RecognitionException {
        type_arguments_stack.push(new type_arguments_scope());
        InstALParser.type_arguments_return retval = new InstALParser.type_arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LPAR104=null;
        Token char_literal106=null;
        Token RPAR108=null;
        InstALParser.type_argument_return type_argument105 = null;

        InstALParser.type_argument_return type_argument107 = null;


        CommonTree LPAR104_tree=null;
        CommonTree char_literal106_tree=null;
        CommonTree RPAR108_tree=null;

         ((type_arguments_scope)type_arguments_stack.peek()).list = new ArrayList<String>(); 
        try {
            // InstAL.g:759:2: ( LPAR ( type_argument ( ',' type_argument )* )? RPAR )
            // InstAL.g:759:4: LPAR ( type_argument ( ',' type_argument )* )? RPAR
            {
            root_0 = (CommonTree)adaptor.nil();

            LPAR104=(Token)match(input,LPAR,FOLLOW_LPAR_in_type_arguments1046); 
            LPAR104_tree = (CommonTree)adaptor.create(LPAR104);
            adaptor.addChild(root_0, LPAR104_tree);

            // InstAL.g:759:9: ( type_argument ( ',' type_argument )* )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==TYPE) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InstAL.g:759:10: type_argument ( ',' type_argument )*
                    {
                    pushFollow(FOLLOW_type_argument_in_type_arguments1049);
                    type_argument105=type_argument();

                    state._fsp--;

                    adaptor.addChild(root_0, type_argument105.getTree());
                    // InstAL.g:759:24: ( ',' type_argument )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==38) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InstAL.g:759:25: ',' type_argument
                    	    {
                    	    char_literal106=(Token)match(input,38,FOLLOW_38_in_type_arguments1052); 
                    	    char_literal106_tree = (CommonTree)adaptor.create(char_literal106);
                    	    adaptor.addChild(root_0, char_literal106_tree);

                    	    pushFollow(FOLLOW_type_argument_in_type_arguments1054);
                    	    type_argument107=type_argument();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, type_argument107.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


                    }
                    break;

            }

            RPAR108=(Token)match(input,RPAR,FOLLOW_RPAR_in_type_arguments1061); 
            RPAR108_tree = (CommonTree)adaptor.create(RPAR108);
            adaptor.addChild(root_0, RPAR108_tree);

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
    // InstAL.g:762:1: type_argument : type_name ;
    public final InstALParser.type_argument_return type_argument() throws RecognitionException {
        InstALParser.type_argument_return retval = new InstALParser.type_argument_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        InstALParser.type_name_return type_name109 = null;



        try {
            // InstAL.g:763:2: ( type_name )
            // InstAL.g:763:4: type_name
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_type_name_in_type_argument1075);
            type_name109=type_name();

            state._fsp--;

            adaptor.addChild(root_0, type_name109.getTree());
             ((type_arguments_scope)type_arguments_stack.peek()).list.add((type_name109!=null?input.toString(type_name109.start,type_name109.stop):null)); 

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
        public Hashtable<String, String> typemap;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable_type_arguments"
    // InstAL.g:766:1: variable_type_arguments returns [Hashtable<String, String> typemap] : LPAR variable_type_argument ( ',' variable_type_argument )* RPAR ;
    public final InstALParser.variable_type_arguments_return variable_type_arguments() throws RecognitionException {
        variable_type_arguments_stack.push(new variable_type_arguments_scope());
        InstALParser.variable_type_arguments_return retval = new InstALParser.variable_type_arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LPAR110=null;
        Token char_literal112=null;
        Token RPAR114=null;
        InstALParser.variable_type_argument_return variable_type_argument111 = null;

        InstALParser.variable_type_argument_return variable_type_argument113 = null;


        CommonTree LPAR110_tree=null;
        CommonTree char_literal112_tree=null;
        CommonTree RPAR114_tree=null;

         ((variable_type_arguments_scope)variable_type_arguments_stack.peek()).list = new ArrayList<String>(); ((variable_type_arguments_scope)variable_type_arguments_stack.peek()).map = new Hashtable<String, String>(); 
        try {
            // InstAL.g:769:2: ( LPAR variable_type_argument ( ',' variable_type_argument )* RPAR )
            // InstAL.g:769:4: LPAR variable_type_argument ( ',' variable_type_argument )* RPAR
            {
            root_0 = (CommonTree)adaptor.nil();

            LPAR110=(Token)match(input,LPAR,FOLLOW_LPAR_in_variable_type_arguments1104); 
            LPAR110_tree = (CommonTree)adaptor.create(LPAR110);
            adaptor.addChild(root_0, LPAR110_tree);

            pushFollow(FOLLOW_variable_type_argument_in_variable_type_arguments1106);
            variable_type_argument111=variable_type_argument();

            state._fsp--;

            adaptor.addChild(root_0, variable_type_argument111.getTree());
            // InstAL.g:769:32: ( ',' variable_type_argument )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==38) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InstAL.g:769:34: ',' variable_type_argument
            	    {
            	    char_literal112=(Token)match(input,38,FOLLOW_38_in_variable_type_arguments1110); 
            	    char_literal112_tree = (CommonTree)adaptor.create(char_literal112);
            	    adaptor.addChild(root_0, char_literal112_tree);

            	    pushFollow(FOLLOW_variable_type_argument_in_variable_type_arguments1112);
            	    variable_type_argument113=variable_type_argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, variable_type_argument113.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            RPAR114=(Token)match(input,RPAR,FOLLOW_RPAR_in_variable_type_arguments1117); 
            RPAR114_tree = (CommonTree)adaptor.create(RPAR114);
            adaptor.addChild(root_0, RPAR114_tree);

             retval.typemap = ((variable_type_arguments_scope)variable_type_arguments_stack.peek()).map; 

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
    // InstAL.g:772:1: variable_type_argument : variable_name ':' type_name ;
    public final InstALParser.variable_type_argument_return variable_type_argument() throws RecognitionException {
        InstALParser.variable_type_argument_return retval = new InstALParser.variable_type_argument_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal116=null;
        InstALParser.variable_name_return variable_name115 = null;

        InstALParser.type_name_return type_name117 = null;


        CommonTree char_literal116_tree=null;

        try {
            // InstAL.g:773:2: ( variable_name ':' type_name )
            // InstAL.g:773:4: variable_name ':' type_name
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_variable_name_in_variable_type_argument1131);
            variable_name115=variable_name();

            state._fsp--;

            adaptor.addChild(root_0, variable_name115.getTree());
            char_literal116=(Token)match(input,40,FOLLOW_40_in_variable_type_argument1133); 
            char_literal116_tree = (CommonTree)adaptor.create(char_literal116);
            adaptor.addChild(root_0, char_literal116_tree);

            pushFollow(FOLLOW_type_name_in_variable_type_argument1135);
            type_name117=type_name();

            state._fsp--;

            adaptor.addChild(root_0, type_name117.getTree());
             ((variable_type_arguments_scope)variable_type_arguments_stack.peek()).list.add((variable_name115!=null?input.toString(variable_name115.start,variable_name115.stop):null)); ((variable_type_arguments_scope)variable_type_arguments_stack.peek()).map.put((variable_name115!=null?input.toString(variable_name115.start,variable_name115.stop):null), (type_name117!=null?input.toString(type_name117.start,type_name117.stop):null)); 

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
    // InstAL.g:776:1: variable_arguments returns [ArrayList<String> args] : LPAR variable_argument ( ',' variable_argument )* RPAR ;
    public final InstALParser.variable_arguments_return variable_arguments() throws RecognitionException {
        variable_arguments_stack.push(new variable_arguments_scope());
        InstALParser.variable_arguments_return retval = new InstALParser.variable_arguments_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LPAR118=null;
        Token char_literal120=null;
        Token RPAR122=null;
        InstALParser.variable_argument_return variable_argument119 = null;

        InstALParser.variable_argument_return variable_argument121 = null;


        CommonTree LPAR118_tree=null;
        CommonTree char_literal120_tree=null;
        CommonTree RPAR122_tree=null;

         ((variable_arguments_scope)variable_arguments_stack.peek()).list = new ArrayList<String>(); 
        try {
            // InstAL.g:779:2: ( LPAR variable_argument ( ',' variable_argument )* RPAR )
            // InstAL.g:779:4: LPAR variable_argument ( ',' variable_argument )* RPAR
            {
            root_0 = (CommonTree)adaptor.nil();

            LPAR118=(Token)match(input,LPAR,FOLLOW_LPAR_in_variable_arguments1165); 
            LPAR118_tree = (CommonTree)adaptor.create(LPAR118);
            adaptor.addChild(root_0, LPAR118_tree);

            pushFollow(FOLLOW_variable_argument_in_variable_arguments1167);
            variable_argument119=variable_argument();

            state._fsp--;

            adaptor.addChild(root_0, variable_argument119.getTree());
            // InstAL.g:779:27: ( ',' variable_argument )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==38) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InstAL.g:779:29: ',' variable_argument
            	    {
            	    char_literal120=(Token)match(input,38,FOLLOW_38_in_variable_arguments1171); 
            	    char_literal120_tree = (CommonTree)adaptor.create(char_literal120);
            	    adaptor.addChild(root_0, char_literal120_tree);

            	    pushFollow(FOLLOW_variable_argument_in_variable_arguments1173);
            	    variable_argument121=variable_argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, variable_argument121.getTree());

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            RPAR122=(Token)match(input,RPAR,FOLLOW_RPAR_in_variable_arguments1178); 
            RPAR122_tree = (CommonTree)adaptor.create(RPAR122);
            adaptor.addChild(root_0, RPAR122_tree);

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
    // InstAL.g:782:1: variable_argument : variable_name ;
    public final InstALParser.variable_argument_return variable_argument() throws RecognitionException {
        InstALParser.variable_argument_return retval = new InstALParser.variable_argument_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        InstALParser.variable_name_return variable_name123 = null;



        try {
            // InstAL.g:783:2: ( variable_name )
            // InstAL.g:783:4: variable_name
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_variable_name_in_variable_argument1192);
            variable_name123=variable_name();

            state._fsp--;

            adaptor.addChild(root_0, variable_name123.getTree());
             ((variable_arguments_scope)variable_arguments_stack.peek()).list.add((variable_name123!=null?input.toString(variable_name123.start,variable_name123.stop):null)); 

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
    // InstAL.g:786:1: variable_name : ( TYPE | LITERAL );
    public final InstALParser.variable_name_return variable_name() throws RecognitionException {
        InstALParser.variable_name_return retval = new InstALParser.variable_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set124=null;

        CommonTree set124_tree=null;

        try {
            // InstAL.g:787:2: ( TYPE | LITERAL )
            // InstAL.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set124=(Token)input.LT(1);
            if ( input.LA(1)==LITERAL||input.LA(1)==TYPE ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set124));
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
    // $ANTLR end "variable_name"

    public static class operation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "operation"
    // InstAL.g:790:1: operation : ( LT | GT | EQ | NE );
    public final InstALParser.operation_return operation() throws RecognitionException {
        InstALParser.operation_return retval = new InstALParser.operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set125=null;

        CommonTree set125_tree=null;

        try {
            // InstAL.g:791:2: ( LT | GT | EQ | NE )
            // InstAL.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set125=(Token)input.LT(1);
            if ( (input.LA(1)>=LT && input.LA(1)<=NE) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set125));
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
        "\1\7\4\uffff\1\22\1\17\2\7\2\uffff\1\22\1\23\1\7\1\17\1\7\1\17\2"+
        "\23\1\7\2\23";
    static final String DFA3_maxS =
        "\1\47\4\uffff\1\22\1\27\1\7\1\11\2\uffff\1\23\1\46\1\11\1\27\1\11"+
        "\1\27\2\46\1\11\1\23\1\46";
    static final String DFA3_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\4\uffff\1\5\1\6\13\uffff";
    static final String DFA3_specialS =
        "\26\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\6\1\1\3\uffff\1\2\2\3\12\uffff\1\4\11\uffff\3\2\1\uffff\1"+
            "\5",
            "",
            "",
            "",
            "",
            "\1\7",
            "\1\11\2\uffff\1\10\3\uffff\2\12",
            "\1\13",
            "\1\14\1\uffff\1\14",
            "",
            "",
            "\1\15\1\16",
            "\1\20\22\uffff\1\17",
            "\1\21\1\uffff\1\21",
            "\1\11\6\uffff\2\12",
            "\1\22\1\uffff\1\22",
            "\1\11\6\uffff\2\12",
            "\1\24\22\uffff\1\23",
            "\1\20\22\uffff\1\17",
            "\1\25\1\uffff\1\25",
            "\1\16",
            "\1\24\22\uffff\1\23"
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
            return "594:1: constituent_decl : ( type_decl | event_decl | fluent_decl | obligation_decl | generates_rule | consequence_rule );";
        }
    }
    static final String DFA21_eotS =
        "\22\uffff";
    static final String DFA21_eofS =
        "\22\uffff";
    static final String DFA21_minS =
        "\1\7\2\22\2\7\2\uffff\1\22\1\23\1\7\1\26\1\7\1\26\2\23\1\7\2\23";
    static final String DFA21_maxS =
        "\1\47\1\22\1\27\1\7\1\11\2\uffff\1\23\1\46\1\11\1\27\1\11\1\27\2"+
        "\46\1\11\1\23\1\46";
    static final String DFA21_acceptS =
        "\5\uffff\1\1\1\2\13\uffff";
    static final String DFA21_specialS =
        "\22\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\2\37\uffff\1\1",
            "\1\3",
            "\1\4\3\uffff\1\5\1\6",
            "\1\7",
            "\1\10\1\uffff\1\10",
            "",
            "",
            "\1\11\1\12",
            "\1\14\22\uffff\1\13",
            "\1\15\1\uffff\1\15",
            "\1\5\1\6",
            "\1\16\1\uffff\1\16",
            "\1\5\1\6",
            "\1\20\22\uffff\1\17",
            "\1\14\22\uffff\1\13",
            "\1\21\1\uffff\1\21",
            "\1\12",
            "\1\20\22\uffff\1\17"
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
            return "719:4: ( initiates_rule | terminates_rule )";
        }
    }
 

    public static final BitSet FOLLOW_institution_decl_in_instal_specification58 = new BitSet(new long[]{0x000000B803007190L});
    public static final BitSet FOLLOW_constituent_decl_in_instal_specification69 = new BitSet(new long[]{0x000000B803007190L});
    public static final BitSet FOLLOW_LINE_COMMENT_in_instal_specification73 = new BitSet(new long[]{0x000000B803007190L});
    public static final BitSet FOLLOW_initially_decl_in_instal_specification82 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_LINE_COMMENT_in_instal_specification88 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_EOF_in_instal_specification95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEY_INST_in_institution_decl112 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_institution_name_in_institution_decl114 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_END_in_institution_decl116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_institution_name131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_decl_in_constituent_decl141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_decl_in_constituent_decl147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fluent_decl_in_constituent_decl153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_obligation_decl_in_constituent_decl158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_generates_rule_in_constituent_decl165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_consequence_rule_in_constituent_decl171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEY_TYPE_in_type_decl185 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_type_name_in_type_decl187 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_END_in_type_decl189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPE_in_type_name206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_extended_event_decl_in_event_decl226 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_standard_event_decl_in_event_decl235 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_END_in_event_decl244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_description_in_standard_event_decl260 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_type_arguments_in_standard_event_decl262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_description_in_extended_event_decl281 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_variable_type_arguments_in_extended_event_decl283 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_KEY_WITH_in_extended_event_decl285 = new BitSet(new long[]{0x0000000000000280L});
    public static final BitSet FOLLOW_variable_constraints_in_extended_event_decl287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_type_in_event_description305 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_KEY_EVENT_in_event_description307 = new BitSet(new long[]{0x0000008000000080L});
    public static final BitSet FOLLOW_event_name_in_event_description309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_event_name323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_event_type333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_constraint_in_variable_constraints374 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_variable_constraints378 = new BitSet(new long[]{0x0000000000000280L});
    public static final BitSet FOLLOW_variable_constraint_in_variable_constraints380 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_variable_name_in_variable_constraint399 = new BitSet(new long[]{0x000000003C000000L});
    public static final BitSet FOLLOW_operation_in_variable_constraint403 = new BitSet(new long[]{0x0000000000000280L});
    public static final BitSet FOLLOW_variable_name_in_variable_constraint407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_noninertial_fluent_decl_in_fluent_decl427 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_standard_fluent_decl_in_fluent_decl435 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_END_in_fluent_decl443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEY_NONINERTIAL_in_noninertial_fluent_decl461 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_standard_fluent_decl_in_noninertial_fluent_decl463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEY_FLUENT_in_standard_fluent_decl481 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_fluent_name_in_standard_fluent_decl483 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_type_arguments_in_standard_fluent_decl485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_fluent_name500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_varient_in_generates_rule513 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_KEY_GENERATES_in_generates_rule515 = new BitSet(new long[]{0x0000008000000080L});
    public static final BitSet FOLLOW_events_with_variables_in_generates_rule519 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_KEY_IF_in_generates_rule523 = new BitSet(new long[]{0x0000000000320080L});
    public static final BitSet FOLLOW_fluents_with_variables_with_negation_in_generates_rule527 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_END_in_generates_rule532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_with_variables_in_events_with_variables562 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_events_with_variables566 = new BitSet(new long[]{0x0000008000000080L});
    public static final BitSet FOLLOW_event_with_variables_in_events_with_variables568 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_event_varient_in_event_with_variables585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fluent_with_variables_in_fluents_with_variables613 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_fluents_with_variables617 = new BitSet(new long[]{0x0000000000320080L});
    public static final BitSet FOLLOW_fluent_with_variables_in_fluents_with_variables619 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_fluent_varient_in_fluent_with_variables637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fluent_with_variables_with_negation_in_fluents_with_variables_with_negation665 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_fluents_with_variables_with_negation669 = new BitSet(new long[]{0x0000000000320080L});
    public static final BitSet FOLLOW_fluent_with_variables_with_negation_in_fluents_with_variables_with_negation671 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_KEY_NOT_in_fluent_with_variables_with_negation690 = new BitSet(new long[]{0x0000000000320080L});
    public static final BitSet FOLLOW_fluent_varient_in_fluent_with_variables_with_negation692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fluent_varient_in_fluent_with_variables_with_negation699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_event_varient722 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_LPAR_in_event_varient724 = new BitSet(new long[]{0x0000008000000080L});
    public static final BitSet FOLLOW_event_name_in_event_varient726 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_variable_arguments_in_event_varient729 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RPAR_in_event_varient732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_name_in_event_varient744 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_variable_arguments_in_event_varient747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEY_POW_in_fluent_varient772 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_LPAR_in_fluent_varient774 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_fluent_name_in_fluent_varient776 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_variable_arguments_in_fluent_varient778 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RPAR_in_fluent_varient781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEY_PERM_in_fluent_varient794 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_LPAR_in_fluent_varient796 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_fluent_name_in_fluent_varient798 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_variable_arguments_in_fluent_varient800 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RPAR_in_fluent_varient803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fluent_name_in_fluent_varient815 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_variable_arguments_in_fluent_varient817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_initiates_rule_in_consequence_rule840 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_terminates_rule_in_consequence_rule844 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_END_in_consequence_rule848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_varient_in_initiates_rule858 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_KEY_INITIATES_in_initiates_rule860 = new BitSet(new long[]{0x0000000000320080L});
    public static final BitSet FOLLOW_fluents_with_variables_in_initiates_rule864 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_KEY_IF_in_initiates_rule868 = new BitSet(new long[]{0x0000000000320080L});
    public static final BitSet FOLLOW_fluents_with_variables_in_initiates_rule872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_event_varient_in_terminates_rule889 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_KEY_TERMINATES_in_terminates_rule891 = new BitSet(new long[]{0x0000000000320080L});
    public static final BitSet FOLLOW_fluents_with_variables_in_terminates_rule895 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_KEY_IF_in_terminates_rule899 = new BitSet(new long[]{0x0000000000320080L});
    public static final BitSet FOLLOW_fluents_with_variables_in_terminates_rule903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEY_INITIALLY_in_initially_decl922 = new BitSet(new long[]{0x0000004002320080L});
    public static final BitSet FOLLOW_initially_component_in_initially_decl924 = new BitSet(new long[]{0x00000040023200C0L});
    public static final BitSet FOLLOW_END_in_initially_decl927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fluents_with_variables_in_initially_component941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_initially_component949 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_obligation_statement_in_initially_component954 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_initially_component956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_obligation_statement_in_obligation_decl975 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_END_in_obligation_decl977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEY_OBLIGATION_in_obligation_statement995 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_LPAR_in_obligation_statement997 = new BitSet(new long[]{0x0000008000000080L});
    public static final BitSet FOLLOW_event_varient_in_obligation_statement1001 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_obligation_statement1003 = new BitSet(new long[]{0x0000008000000080L});
    public static final BitSet FOLLOW_event_varient_in_obligation_statement1007 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_obligation_statement1009 = new BitSet(new long[]{0x0000008000000080L});
    public static final BitSet FOLLOW_event_varient_in_obligation_statement1013 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RPAR_in_obligation_statement1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_in_type_arguments1046 = new BitSet(new long[]{0x0000000000080200L});
    public static final BitSet FOLLOW_type_argument_in_type_arguments1049 = new BitSet(new long[]{0x0000004000080000L});
    public static final BitSet FOLLOW_38_in_type_arguments1052 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_type_argument_in_type_arguments1054 = new BitSet(new long[]{0x0000004000080000L});
    public static final BitSet FOLLOW_RPAR_in_type_arguments1061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_name_in_type_argument1075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_in_variable_type_arguments1104 = new BitSet(new long[]{0x0000000000000280L});
    public static final BitSet FOLLOW_variable_type_argument_in_variable_type_arguments1106 = new BitSet(new long[]{0x0000004000080000L});
    public static final BitSet FOLLOW_38_in_variable_type_arguments1110 = new BitSet(new long[]{0x0000000000000280L});
    public static final BitSet FOLLOW_variable_type_argument_in_variable_type_arguments1112 = new BitSet(new long[]{0x0000004000080000L});
    public static final BitSet FOLLOW_RPAR_in_variable_type_arguments1117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_name_in_variable_type_argument1131 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_variable_type_argument1133 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_type_name_in_variable_type_argument1135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAR_in_variable_arguments1165 = new BitSet(new long[]{0x0000000000000280L});
    public static final BitSet FOLLOW_variable_argument_in_variable_arguments1167 = new BitSet(new long[]{0x0000004000080000L});
    public static final BitSet FOLLOW_38_in_variable_arguments1171 = new BitSet(new long[]{0x0000000000000280L});
    public static final BitSet FOLLOW_variable_argument_in_variable_arguments1173 = new BitSet(new long[]{0x0000004000080000L});
    public static final BitSet FOLLOW_RPAR_in_variable_arguments1178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_name_in_variable_argument1192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_variable_name0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_operation0 = new BitSet(new long[]{0x0000000000000002L});

}