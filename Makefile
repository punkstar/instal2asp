FOLDER=src/uk/ac/bath/cs/agents/instal/instal2asp
MAIN_CLASS=CommandLine

# Who needs Java-specific ant/maven when you've got good ol' Make :D
all: instal parser instal2asp

instal2asp:
	javac -sourcepath src -classpath lib/jcommander-1.13.jar:lib/antlr-3.3-complete.jar:classes -d classes src/uk/ac/bath/cs/agents/instal/*/*.java

parser:
	mkdir -p classes/uk/ac/bath/cs/agents/instal/parser/
	java -cp lib/antlr-3.3-complete.jar org.antlr.Tool InstAL.g -o src/uk/ac/bath/cs/agents/instal/parser

instal:
	javac -sourcepath java-instal/src -d classes java-instal/src/uk/ac/bath/cs/agents/instal/*.java
	javac -sourcepath java-instal/src -d classes java-instal/src/uk/ac/bath/cs/agents/instal/asp/*.java

clean:
	find . | grep -E ".class$$" | xargs -I {} rm -f {}

test: clean all
	java -classpath lib/antlr-3.3-complete.jar:classes org.antlr.gunit.Interp InstAL.gunit

run:
	./instal2asp -d examples/wgrid-obligation-driven/domain.txt examples/wgrid-obligation-driven/new.ial | clingo examples/wgrid-obligation-driven/basic.lp examples/wgrid-obligation-driven/alltrace.lp -

.PHONY: all instal2asp parser instal clean test run
