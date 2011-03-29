FOLDER=src/uk/ac/bath/cs/agents/instal/instal2asp
MAIN_CLASS=CommandLine

${FOLDER}/${MAIN_CLASS}.class: ${FOLDER}/${MAIN_CLASS}.java
	mkdir -p classes/uk/ac/bath/cs/agents/instal/parser/
	java -cp lib/antlr-3.3-complete.jar org.antlr.Tool InstAL.g -o src/uk/ac/bath/cs/agents/instal/parser
	javac -sourcepath java-instal/src -d classes java-instal/src/*.java
	javac -sourcepath java-instal/src -d classes java-instal/src/uk/ac/bath/cs/agents/instal/NoninertialFluent.java
	javac -sourcepath src -classpath lib/jcommander-1.13.jar:lib/antlr-3.3-complete.jar:java-instal/src:classes -d classes src/uk/ac/bath/cs/agents/instal/*/*.java

clean:
	rm -rf classes/*
