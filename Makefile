FOLDER=src/uk/ac/bath/cs/agents/instal2asp
MAIN_CLASS=CommandLine

${FOLDER}/${MAIN_CLASS}.class: ${FOLDER}/${MAIN_CLASS}.java
	javac -sourcepath src -classpath lib/jcommander-1.13.jar -d classes ${FOLDER}/${MAIN_CLASS}.java
