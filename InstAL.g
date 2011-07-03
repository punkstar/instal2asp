grammar InstAL;

options {
	language=Java;
	ASTLabelType=CommonTree;
	output=AST;
}

@header {
	package uk.ac.bath.cs.agents.instal.parser;
	
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.Hashtable;
	
	import uk.ac.bath.cs.agents.instal.*;
	import uk.ac.bath.cs.agents.instal.asp.*;
}

@lexer::header {
	package uk.ac.bath.cs.agents.instal.parser;
	
	import java.util.ArrayList;
	import java.util.Iterator;
	
	import uk.ac.bath.cs.agents.instal.*;
	import uk.ac.bath.cs.agents.instal.asp.*;
}

@members {	
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
	
	protected NoninertialFluent _getNoninertialFluent(String name) throws Exception {
		if(_noninertialFluentMap.containsKey(name)) {
			return _noninertialFluentMap.get(name);
		} else {
			emitErrorMessage("Nonintertial Fluent '" + name + "' is undefined");
			throw new Exception("Nonintertial Fluent '" + name + "' is undefined");
		}
	}
	
	protected Fluent _addInertialFluent(FluentCondition fc) throws Exception {
	    if (!_inertialFluentMap.containsKey(fc.getFluent())) {
	        if (fc.isModified()) {
	            if (fc.modifier.equals("perm")) {
        	        _inertialFluentMap.put(fc.getFluent(), _getEvent(fc.name).perm());	            
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
} // @members

instal_specification
	:
		institution_decl 			{ _setInsitutionName($institution_decl.name); }
		( constituent_decl | LINE_COMMENT )*
		( initially_decl   | LINE_COMMENT )*
		EOF
	;
		
institution_decl returns [String name]
	:	KEY_INST institution_name END { $name = $institution_name.text; }
	;
	
institution_name
	:	 LITERAL;
	
constituent_decl
	:	type_decl
	| 	event_decl
	| 	fluent_decl
	|	obligation_decl	
	| 	generates_rule
	| 	consequence_rule
	|	noninertial_rule
	;

/* TYPE DECL */

type_decl
	:	KEY_TYPE type_name END { _addType($type_name.text); }
	;

type_name returns [String result]
	:	TYPE	{ $result = $TYPE.text; }
	;
	
/* EVENT DECL */
event_decl
	:	
	(	extended_event_decl 	{ _addComplexEvent($extended_event_decl.type, $extended_event_decl.name, $extended_event_decl.types_with_names, $extended_event_decl.constraints); }
	| 	standard_event_decl	{ _addEvent($standard_event_decl.type, $standard_event_decl.name, $standard_event_decl.types); }
	)  	END
	;
	
standard_event_decl returns [String type, String name, ArrayList<String> types]
	:	event_description type_arguments? { $type = $event_description.type; $name = $event_description.name; $types = $type_arguments.args; }
	;
	
extended_event_decl returns [String type, String name, Hashtable<String, String> types_with_names, ArrayList<Constraint> constraints]
	:	event_description variable_type_arguments KEY_WITH variable_constraints { $type = $event_description.type; $name = $event_description.name; $types_with_names = $variable_type_arguments.typemap; $constraints = $variable_constraints.constraints; }
	;
	
event_description returns [String type, String name]
	:	event_type KEY_EVENT event_name { $type = $event_type.text; $name = $event_name.text; }
	;
	
event_name
	:	LITERAL;
	
event_type
	:	( 'exogenous' | 'inst' | EVENT_KEY_CREATE | 'violation' );
	
variable_constraints returns [ArrayList<Constraint> constraints]
	scope { ArrayList<Constraint> list; }
	@init { $variable_constraints::list = new ArrayList<Constraint>(); }
	:	variable_constraint ( ',' variable_constraint )*	{ $constraints = $variable_constraints::list; }
	;
	
variable_constraint
	:	x=variable_name op=operation y=variable_name { $variable_constraints::list.add(new Constraint($x.text, $op.text, $y.text)); }
	;

/* FLUENT DECL */
fluent_decl
	:	(
			nf=noninertial_fluent_decl	{ _addFluent($nf.type, $nf.name, $nf.args); }
		|	sf=standard_fluent_decl	        { _addFluent($sf.type, $sf.name, $sf.args); }
		) END 	
	;
	
noninertial_fluent_decl returns [String type, String name, ArrayList<String> args]
	:	KEY_NONINERTIAL standard_fluent_decl	{ $type = "noninertial"; $name = $standard_fluent_decl.name; $args = $standard_fluent_decl.args; }
	;
	
standard_fluent_decl returns [String type, String name, ArrayList<String> args]
	:	KEY_FLUENT fluent_name type_arguments?	{ $type = "inertial"; $name = $fluent_name.text; $args = $type_arguments.args; }
	;
	
fluent_name
	:	LITERAL;
	
/* GENERATES */

generates_rule
	:	event_varient KEY_GENERATES results=events_with_variables ( KEY_IF conditions=fluents_with_variables_with_negation )? END 	{ _addGeneratesRule($event_varient.name, $event_varient.args, $results.events, $conditions.fluents); }
	;
	
events_with_variables returns [ArrayList<EventWithVariables> events]
	scope { ArrayList<EventWithVariables> list; }
	@init { $events_with_variables::list = new ArrayList<EventWithVariables>(); }
	:	event_with_variables ( ',' event_with_variables )*	{ $events = $events_with_variables::list; }
	;
	
event_with_variables
	:	event_varient	{ $events_with_variables::list.add(new EventWithVariables($event_varient.name, $event_varient.args)); }
	;

fluents_with_variables returns [ArrayList<FluentCondition> fluents]
	scope { ArrayList<FluentCondition> list; }
	@init { $fluents_with_variables::list = new ArrayList<FluentCondition>(); }
	:	fluent_with_variables ( ',' fluent_with_variables )*		{ $fluents = $fluents_with_variables::list; }
	;
	
fluent_with_variables
	:	fluent_varient	{ $fluents_with_variables::list.add(new FluentCondition(false, $fluent_varient.name, $fluent_varient.args, $fluent_varient.modifier)); }
	;

fluents_with_variables_with_negation returns [ArrayList<FluentCondition> fluents]
	scope { ArrayList<FluentCondition> list; }
	@init { $fluents_with_variables_with_negation::list = new ArrayList<FluentCondition>(); }
	:	fluent_with_variables_with_negation ( ',' fluent_with_variables_with_negation )*		{ $fluents = $fluents_with_variables_with_negation::list; }
	;	
	
fluent_with_variables_with_negation
	:	KEY_NOT fluent_varient	{ $fluents_with_variables_with_negation::list.add(new FluentCondition(false, $fluent_varient.name, $fluent_varient.args)); }
	|	fluent_varient		{ $fluents_with_variables_with_negation::list.add(new FluentCondition(true,  $fluent_varient.name, $fluent_varient.args)); }
	;
	
	
event_varient returns [String name, ArrayList<String> args]
	:	( 'viol' LPAR event_name  variable_arguments? RPAR )	{ $name = $event_name.text; $args = $variable_arguments.args; }
	| 	( event_name  variable_arguments? )			{ $name = $event_name.text; $args = $variable_arguments.args; }
	;
	
fluent_varient returns [String type, String name, ArrayList<String> args, String modifier]
	:	( KEY_POW LPAR fluent_name variable_arguments? RPAR )		{ $name = $fluent_name.text; $args = $variable_arguments.args; $modifier = "pow";  }
	| 	( KEY_PERM LPAR fluent_name variable_arguments? RPAR )		{ $name = $fluent_name.text; $args = $variable_arguments.args; $modifier = "perm"; }
	|	( fluent_name variable_arguments? )				{ $name = $fluent_name.text; $args = $variable_arguments.args; $modifier = "";     }
	;

/* CONSEQUENCE RULES */
consequence_rule
	:	( initiates_rule | terminates_rule ) END;
	
initiates_rule
	:	event_varient KEY_INITIATES results=fluents_with_variables ( KEY_IF conditions=fluents_with_variables )?	{ _addInitiatesRule($event_varient.name, $event_varient.args, $results.fluents, $conditions.fluents); }
	;
	
terminates_rule
	:	event_varient KEY_TERMINATES results=fluents_with_variables ( KEY_IF conditions=fluents_with_variables )?	{ _addTerminatesRule($event_varient.name, $event_varient.args, $results.fluents, $conditions.fluents); }
	;
	
/* INITIALLY */
initially_decl
	:	KEY_INITIALLY initially_component+ END
	;
	
initially_component
	:	f=fluents_with_variables		{ _addInitiallyFluents($f.fluents); }
	|	','? o=obligation_statement ','?	{ _addObligation(o.act_name, o.act_args, o.before_name, o.before_args, o.otherwise_name, o.otherwise_args); }
	;
	
/* OBLIGATIONS */
obligation_decl
	:	o=obligation_statement END	{ _addObligation(o.act_name, o.act_args, o.before_name, o.before_args, o.otherwise_name, o.otherwise_args); }
	;
	
obligation_statement returns [String act_name, ArrayList<String> act_args, String before_name, ArrayList<String> before_args, String otherwise_name, ArrayList<String> otherwise_args]
	:	KEY_OBLIGATION LPAR act=event_varient ',' before=event_varient ',' otherwise=event_varient RPAR {
			$act_name = $act.name;
			$act_args = $act.args;
			$before_name = $before.name;
			$before_args = $before.args;
			$otherwise_name = $otherwise.name;
			$otherwise_args = $otherwise.args;
		}
	;
	
noninertial_rule
	:	KEY_ALWAYS
		results=fluents_with_variables
		KEY_WHEN
		conditions=fluents_with_variables_with_negation
		END {
			System.err.println("Always When Found");
			FluentCondition[] always = $results.fluents.toArray(new FluentCondition[] {});
			FluentCondition[] when = $conditions.fluents.toArray(new FluentCondition[] {});
			
			for (FluentCondition fluent : always) {
				AlwaysWhen aw;
				
				try {
					String[] args = fluent.args;
					NoninertialFluent nf = _getNoninertialFluent(fluent.name);
					
					aw = new AlwaysWhen(nf, args);
				} catch (Exception e) {
					System.err.println("Error finding nonintertial rule antecedent: " + e.getMessage());
					continue;
				}
				
				for (FluentCondition condition : when) {
					Fluent f;
					try {
						f = _getNoninertialFluent(condition.name);
					} catch (Exception e) {
						f = null;
					}

					if (f == null) {
						try {
							f = _getInertialFluent(condition.name);
						} catch (Exception e) {
							System.err.println("Error finding nonintertial rule conditions: " + e.getMessage());
							break;
						}
					}
					
					aw.condition(condition.sign, f, condition.args);
				}
				
				i.alwayswhen(aw);
			}
		}
	;
	
/* UTILITY */
type_arguments returns [ ArrayList<String> args ]
	scope { ArrayList<String> list; }
	@init { $type_arguments::list = new ArrayList<String>(); }
	:	LPAR (type_argument (',' type_argument)*)?  RPAR	{ $args = $type_arguments::list; }
	;
	
type_argument
	:	type_name	{ $type_arguments::list.add($type_name.text); }
	;
	
variable_type_arguments returns [Hashtable<String, String> typemap]
	scope { ArrayList<String> list; Hashtable<String, String> map; }
	@init { $variable_type_arguments::list = new ArrayList<String>(); $variable_type_arguments::map = new Hashtable<String, String>(); }
	:	LPAR variable_type_argument ( ',' variable_type_argument )* RPAR	{ $typemap = $variable_type_arguments::map; }
	;
	
variable_type_argument
	:	variable_name ':' type_name	{ $variable_type_arguments::list.add($variable_name.text); $variable_type_arguments::map.put($variable_name.text, $type_name.text); }
		;
	
variable_arguments returns [ArrayList<String> args]
	scope { ArrayList<String> list; }
	@init { $variable_arguments::list = new ArrayList<String>(); }
	:	LPAR variable_argument ( ',' variable_argument )* RPAR	{ $args = $variable_arguments::list; }
	;
	
variable_argument
	:	variable_name	{ $variable_arguments::list.add($variable_name.text); }
	;
	
variable_name
	:	TYPE | LITERAL
	;
	
operation
	:	LT | GT | EQ | NE;

LINE_COMMENT
	:	'%' ( ~('\r'|'\n')* ) '\r'? '\n' { skip(); }
	;
	
/**  KEYWORDS **/
KEY_INST	:	( 'institution' | 'inst' );
KEY_TYPE	:	'type';
KEY_EVENT	:	'event';
KEY_WITH	:	'with';
KEY_FLUENT	:	'fluent';
KEY_GENERATES	:	'generates';
KEY_INITIATES	:	'initiates';
KEY_TERMINATES	:	'terminates';
KEY_IF		:	'if';
KEY_INITIALLY	:	'initially';
KEY_NOT		:	'not';
KEY_OBLIGATION	:	'obl';
KEY_PERM	:	'perm';
KEY_POW		:	'pow';
KEY_NONINERTIAL :	'noninertial';
KEY_ALWAYS	:	'always';
KEY_WHEN	:	'when';

EVENT_KEY_CREATE
	:	('create'|'creation')
	;

LPAR	:	'(';
RPAR	:	')';
END	:	';';
TYPE	:	UCALPHA ( DIGIT | UCALPHA | LCALPHA | '_' )*;
LITERAL	:	INTEGER | (LCALPHA ( DIGIT | UCALPHA | LCALPHA | '_' )*);
LT	:	( '<' | 'lt' | 'LT' );
GT	:	( '>' | 'gt' | 'GT' );
EQ	:	( '=' | '==' | 'eq' | 'EQ' );
NE	:	( '!=' | 'ne' | 'NE' | '<>' );

fragment UCALPHA	:	'A'..'Z';
fragment LCALPHA	:	'a'..'z';
fragment DIGIT		:	'0'..'9';
fragment INTEGER	:	DIGIT+;

ANY	: 	. { skip(); };

