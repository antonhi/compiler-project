JAVA=java
JAVAC=javac
JFLEX=$(JAVA) -jar jflex-full-1.8.2.jar
CUPJAR=./java-cup-11b.jar
CUP=$(JAVA) -jar $(CUPJAR)
CP=.:$(CUPJAR)

default: run

.SUFFIXES: $(SUFFIXES) .class .java

.java.class:
		$(JAVAC) -cp $(CP) $*.java

FILE=    Lexer.java      parser.java    sym.java \
    LexerTest.java      ScannerTest.java      Token.java \
	Program.java      Binaryop.java      AddStatement.java \
	Args.java      AssignmentStatement.java      BinaryExpression.java \
	BodyStatement.java      CastExpression.java      CharacterExpression.java \
	ConstructorExpression.java      ConstructorStatement.java      Expression.java      FalseExpression.java      FloatExpression.java      IdExpressionName.java      IdName.java      IfEnd.java      IfStatement.java      IntegerExpression.java      Name.java      NameExpression.java \
	NegateExpression.java      NestedExpression.java      NotExpression.java \
	ParameterConstructorExpression.java      ParameterConstructorStatement.java      PositiveExpression.java      PrintLineList.java      PrintLineStatement.java      PrintList.java      PrintStatement.java      ReadList.java      ReadStatement.java      ReturnExpressionStatement.java      ReturnStatement.java      Statement.java      StatementList.java      StringExpression.java      SubtractStatement.java      TertiaryExpression.java      TrueExpression.java      Type.java      WhileStatement.java

run: Phase2_empty.txt

all: Lexer.java parser.java $(FILE:java=class)

Phase2_empty.txt: all
		$(JAVA) -cp $(CP) ScannerTest Phase2_empty.txt > Phase2_empty_output.txt
		cat Phase2_empty.txt
		cat -n Phase2_empty_output.txt

basicTerminals.txt: all
		$(JAVA) -cp $(CP) LexerTest basicTerminals.txt > basicTerminals-output.txt
		cat basicTerminals.txt
		cat -n basicTerminals-output.txt

allTerminals.txt: all
		$(JAVA) -cp $(CP) LexerTest allTerminals.txt > allTerminals-output.txt
		cat allTerminals.txt
		cat -n allTerminals-output.txt


basicFails.txt: all
		$(JAVA) -cp $(CP) LexerTest basicFails.txt > basicFails-output.txt
		cat basicFails.txt
		cat -n basicFails-output.txt

advanced.txt: all
		$(JAVA) -cp $(CP) LexerTest advanced.txt > advanced-output.txt
		cat advanced.txt
		cat -n advanced-output.txt

advanced-invalid.txt: all
		$(JAVA) -cp $(CP) LexerTest advanced-invalid.txt > advanced-invalid-output.txt
		cat advanced-invalid.txt
		cat -n advanced-invalid-output.txt

clean:
		rm -f *.class *~ *.bak Lexer.java parser.java sym.java

Lexer.java: tokens.jflex
		$(JFLEX) tokens.jflex

parser.java: grammar.cup
		$(CUP) -interface < grammar.cup

parserD.java: grammar.cup
		$(CUP) -interface -dump < grammar.cup
