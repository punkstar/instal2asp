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
	public Institution i;
	protected Hashtable<String, Type> _typeMap = new Hashtable<String, Type>();
	protected Hashtable<String, Fluent> _fluentMap = new Hashtable<String, Fluent>();
	protected Hashtable<String, uk.ac.bath.cs.agents.instal.Event> _eventMap = new Hashtable<String, uk.ac.bath.cs.agents.instal.Event>();

	private static void log(String message) {
		System.err.println("[antlr]: " + message);
	}
	
	private static void log(ArrayList<String> list) {
		log("list start");
		
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				log("item: " + list.get(i));
			}
		} else {
			log("list was empty");
		}
		log("list end");
	}
	
	private class Event {
	
	}
	
	private void outputASP() {
		AnsProlog asp = new AnsProlog(this.i, new Domain());
		asp.generate();
		System.out.println(asp.toString());
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
		
		log("Adding fluent '" + name + "'");
	
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
	
	protected void _addInitiates(String event, ArrayList<String> event_variables, ArrayList<FluentCondition> result_fluents, ArrayList<FluentCondition> condition_fluents) {
		String[] event_vars_array = new String[] {};
		
		if (event_variables != null) {
			event_vars_array = event_variables.toArray(new String[] {});
		}
	
		if (_getEvent(event) != null) {
			Initiates in = new Initiates(_getEvent(event), event_vars_array);
			
			in = (Initiates) _addRuleConditions(in, condition_fluents);
			in = (Initiates) _addRuleResultFluents(in, result_fluents);
			
			i.initiates(in);
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
				
				r.result(_getFluent(f_v.fluent), f_v.args);
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
				
				r.result(_getEvent(e_v.name), e_v.args);
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
			}
		}
	}
	
} // @members

instal_specification
	:
		institution_decl 			{ _setInsitutionName($institution_decl.name); }
		( constituent_decl | LINE_COMMENT )*
		( initially_decl   | LINE_COMMENT )*
		EOF					{ outputASP(); } 
	;
		
institution_decl returns [String name]
	:	KEY_INST inst_name=institution_name END { $name = $inst_name.text; }
	;
	
institution_name
	:	 LITERAL;
	
constituent_decl
	:	type_decl
	| 	event_decl
	| 	fluent_decl		
	| 	generates_rule
	| 	consequence_rule
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
	(	extended_event_decl 	{ log("TODO: extended_event_decl"); }
	| 	standard_event_decl	{ _addEvent($standard_event_decl.type, $standard_event_decl.name, $standard_event_decl.types); }
	)  	END
	;
	
standard_event_decl returns [String type, String name, ArrayList<String> types]
	:	event_description type_arguments? { $type = $event_description.type; $name = $event_description.name; $types = $type_arguments.args; }
	;
	
extended_event_decl returns [String type, String name]
	:	event_description variable_type_arguments KEY_WITH variable_constraints { $type = $event_description.type; $name = $event_description.name; }
	;
	
event_description returns [String type, String name]
	:	event_type KEY_EVENT event_name { $type = $event_type.text; $name = $event_name.text; }
	;
	
event_name
	:	LITERAL;
	
event_type
	:	( 'exogenous' | 'inst' | 'creation' | 'violation' );
	
variable_constraints
	:	variable_constraint ( ',' variable_constraint )*;
	
variable_constraint
	:	variable_name operation variable_name;

/* FLUENT DECL */
fluent_decl
	:	(
			noninertial_fluent_decl	{ _addFluent($noninertial_fluent_decl.type, $noninertial_fluent_decl.name,  $noninertial_fluent_decl.args); }
		|	standard_fluent_decl	{ _addFluent($standard_fluent_decl.type,    $standard_fluent_decl.name,     $standard_fluent_decl.args  ); }
		) END 	
	;
	
noninertial_fluent_decl returns [String type, String name, ArrayList<String> args]
	:	'noninertial' standard_fluent_decl	{ $type = "noninertial"; $name = $standard_fluent_decl.name; $args = $standard_fluent_decl.args; }
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
	:	fluent_varient	{ $fluents_with_variables::list.add(new FluentCondition(false, $fluent_varient.text, $fluent_varient.args)); }
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
	:	( 'viol' LPAR event_name  variable_arguments? RPAR )	{ $name = "viol_" + $event_name.text; $args = $variable_arguments.args; }
	| 	( event_name  variable_arguments? )			{ $name = $event_name.text; $args = $variable_arguments.args; }
	;
	
fluent_varient returns [String name, ArrayList<String> args]
	:	( fluent_name variable_arguments? )			{ $name = $fluent_name.text; $args = $variable_arguments.args; }
	| 	( 'pow(' fluent_name variable_arguments? RPAR )		{ $name = $fluent_name.text; $args = $variable_arguments.args; }
	| 	( 'perm(' fluent_name variable_arguments? RPAR )	{ $name = $fluent_name.text; $args = $variable_arguments.args; }
	;

/* CONSEQUENCE RULES */
consequence_rule
	:	( initiates_rule | terminates_rule ) END;
	
initiates_rule
	:	event_name variable_arguments? KEY_INITIATES fluents_with_variables ( KEY_IF fluents_with_variables )?	{ log("TODO: initiates_rule"); }
	;
	
terminates_rule
	:	event_name variable_arguments? KEY_TERMINATES fluents_with_variables ( KEY_IF fluents_with_variables )?	{ log("TODO: terminates_rule"); }
	;
	
/* INITIALLY */
initially_decl
	:	KEY_INITIALLY fluents_with_variables END	{ log("TODO: initially_decl"); }
	;
	
/* UTILITY */
type_arguments returns [ ArrayList<String> args ]
	scope { ArrayList<String> list; }
	@init { $type_arguments::list = new ArrayList<String>(); }
	:	LPAR type_argument (',' type_argument)* RPAR	{ $args = $type_arguments::list; }
	;
	
type_argument
	:	type_name	{ $type_arguments::list.add($type_name.text); }
	;
	
variable_type_arguments returns [ArrayList<String> args]
	scope { ArrayList<String> list; Hashtable<String, String> map; }
	@init { $variable_type_arguments::list = new ArrayList<String>(); $variable_type_arguments::map = new Hashtable<String, String>(); }
	:	LPAR variable_type_argument ( ',' variable_type_argument )* RPAR
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
	:	VARIABLE/* (VARIABLE | TYPE | LITERAL) */
	;
	
operation
	:	LT | GT | EQ | NE;

LINE_COMMENT
	:	'%' ( ~('\r'|'\n')* ) '\r'? '\n' {skip();}
	;
	
/**  KEYWORDS **/
KEY_INST	:	'inst';
KEY_TYPE	:	'type';
KEY_EVENT	:	'event';
KEY_WITH	:	'with';
KEY_FLUENT	:	'fluent';
KEY_INITIATES	:	'initiates';
KEY_TERMINATES	:	'terminates';
KEY_GENERATES	:	'generates';
KEY_IF		:	'if';
KEY_INITIALLY	:	'initially';
KEY_NOT	:	'not';

LPAR	:	'(';
RPAR	:	')';
END	:	';';
VARIABLE:	( UCALPHA | DIGIT )+; // Apparently we're allowed digits at the start, including one letter digits
TYPE	:	UCALPHA ( DIGIT | UCALPHA | LCALPHA | '_' )*;
LITERAL	:	LCALPHA ( DIGIT | UCALPHA | LCALPHA | '_' )*;
LT	:	( '<' | 'lt' | 'LT' );
GT	:	( '>' | 'gt' | 'GT' );
EQ	:	( '=' | '==' | 'eq' | 'EQ' );
NE	:	( '!=' | 'ne' | 'NE' | '<>' );

fragment UCALPHA	:	'A'..'Z';
fragment LCALPHA	:	'a'..'z';
fragment DIGIT		:	'0'..'9';

ANY	: 	. { skip(); };
